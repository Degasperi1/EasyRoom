-- Configurações de auditoria
CREATE TABLE audit_log (
    username text, -- who did the change
    event_time_utc timestamp, -- when the event was recorded
    table_name text, -- contains schema-qualified table name
    operation text, -- INSERT, UPDATE, DELETE or TRUNCATE
    before_value json, -- the OLD tuple value
    after_value json -- the NEW tuple value
);

CREATE OR REPLACE FUNCTION audit_trigger() 
  RETURNS trigger AS $$ 
DECLARE 
    old_row json := NULL; 
    new_row json := NULL; 
BEGIN 
    IF TG_OP IN ('UPDATE','DELETE') THEN 
        old_row = row_to_json(OLD); 
    END IF; 
    IF TG_OP IN ('INSERT','UPDATE') THEN 
        new_row = row_to_json(NEW); 
    END IF; 
    INSERT INTO  audit_log( 
        username, 
        event_time_utc, 
        table_name, 
        operation, 
        before_value, 
        after_value 
    ) VALUES ( 
        session_user, 
        current_timestamp AT TIME ZONE 'UTC', 
        TG_TABLE_SCHEMA ||  '.' || TG_TABLE_NAME, 
        TG_OP, 
        old_row, 
        new_row 
    ); 
    RETURN NEW; 
END; 
$$ LANGUAGE plpgsql;

-- Tabelas auditadas

CREATE TRIGGER audit_cidade 
  AFTER INSERT OR UPDATE OR DELETE 
  ON cidade 
  FOR EACH ROW 
EXECUTE PROCEDURE audit_trigger();

CREATE TRIGGER audit_produto
  AFTER INSERT OR UPDATE OR DELETE 
  ON produto 
  FOR EACH ROW 
EXECUTE PROCEDURE audit_trigger();

CREATE TRIGGER audit_quarto 
  AFTER INSERT OR UPDATE OR DELETE 
  ON quarto 
  FOR EACH ROW 
EXECUTE PROCEDURE audit_trigger();

CREATE TRIGGER audit_tipo_quarto
  AFTER INSERT OR UPDATE OR DELETE 
  ON tipo_quarto 
  FOR EACH ROW 
EXECUTE PROCEDURE audit_trigger();

-- VIEWS

CREATE VIEW pessoa_fisica_v AS (
SELECT
	a.nm_pessoa_fisica,
	a.nr_cpf,
	a.nr_rg,
	a.dt_nascimento,
	a.ie_sexo,
	c.ds_cidade,
	b.ds_endereco,
	b.ds_bairro,
	b.nr_endereco,
	b.nr_telefone,
	b.nr_celular,
	b.ds_email
FROM
	pessoa_fisica a,
	entidade b,
	cidade c
WHERE
	a.id_entidade = b.id_entidade
	AND b.id_cidade = c.id_cidade
ORDER BY
	b.id_entidade
);

CREATE VIEW quarto_v AS (
SELECT
	a.nr_quarto,
	a.nr_andar,
	b.ds_tipo_quarto,
	b.nr_capacidade,
	b.nr_comodo,
	b.nr_banheiro,
	b.vl_reserva
FROM
	quarto a,
	tipo_quarto b
WHERE
	a.id_tipo_quarto = b.id_tipo_quarto
ORDER BY
	a.nr_quarto,
	a.nr_andar
);


CREATE VIEW pessoa_juridica_v AS (
SELECT
	a.nm_fantasia,
	a.nm_razao_social,
	a.nr_cnpj,
	c.ds_cidade,
	b.ds_endereco,
	b.ds_bairro,
	b.nr_endereco,
	b.nr_telefone,
	b.nr_celular,
	b.ds_email
FROM
	pessoa_juridica a,
	entidade b,
	cidade c
WHERE
	a.id_entidade = b.id_entidade
	AND b.id_cidade = c.id_cidade
ORDER BY
	b.id_entidade
);

-- PROCEDURES

CREATE OR REPLACE FUNCTION data_reserva (dtinicio date, dtfim date)
RETURNS SETOF reserva
AS $$
SELECT *
FROM reserva
WHERE dt_reserva BETWEEN $1 AND  $2
$$ LANGUAGE sql;

CREATE OR REPLACE FUNCTION busca_andar (nr text)
RETURNS text
AS $$
SELECT nr_andar
FROM quarto
WHERE nr_quarto = $1
$$ LANGUAGE sql;

-- Triggers de validação

CREATE FUNCTION valida_produto() RETURNS trigger AS $valida_produto$
    BEGIN
        IF NEW.ds_produto IS NULL THEN
            RAISE EXCEPTION 'A descrição do produto não pode ser nula';
        END IF;
        IF NEW.vl_venda IS NULL THEN
            RAISE EXCEPTION '% não pode ter um valor nulo', NEW.nome;
        END IF;      
	IF NEW.vl_venda < 0 THEN
            RAISE EXCEPTION '% não pode ter um valor negativo', NEW.nome;
        END IF;
        
		RETURN NEW;
    END;
  $valida_produto$ LANGUAGE plpgsql;

CREATE TRIGGER valida_produto BEFORE INSERT OR UPDATE ON produto
    FOR EACH ROW EXECUTE PROCEDURE valida_produto();