/* 
 * Triggers de segurança
    -  Validação
 */
/**
 * Author:  evand
 * Created: 05/10/2020
 */

-- Inserts de apoio iniciais

insert into estado values(1,'Rio Grande do Sul','RS','A');
insert into cidade values(1, 'Lajeado',1,'A',1);
insert into entidade values(1, 'Rua 123', 'Central', '123','A',1,'5137501010','51999999999','email@email.com',1);
insert into pessoa_fisica values(1, 'Bóris', '12345678912','1234567891', current_date, 'Masculino', 1);
insert into usuario values(1, 'admin', 'admin', current_date, current_date, 1, 'A');

-- Triggers de Validação em banco

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

-- Tabela quarto
-- não aceita nr_quarto nulo

CREATE FUNCTION valida_quarto() RETURNS trigger AS $valida_quarto$
    BEGIN
        IF NEW.nr_quarto IS NULL THEN
            RAISE EXCEPTION 'O número do quarto não pode ser nulo';
        END IF;
    RETURN NEW;
END;
$valida_quarto$ LANGUAGE plpgsql;

CREATE TRIGGER valida_quarto BEFORE INSERT OR UPDATE ON quarto
    FOR EACH ROW EXECUTE PROCEDURE valida_quarto();

-- Tabela tipo_quarto
-- Valores de reserva e descrição precisam estar corretos

CREATE FUNCTION valida_tipo_quarto() RETURNS trigger AS $valida_tipo_quarto$
    BEGIN
        IF NEW.ds_tipo_quarto IS NULL THEN
            RAISE EXCEPTION 'A descrição do tipo de quarto não pode ser nula';
        END IF;
        IF NEW.vl_reserva < 0 THEN
            RAISE EXCEPTION '% não pode ter um valor negativo.', NEW.ds_tipo_quarto;
        END IF;
    RETURN NEW;
END;
$valida_tipo_quarto$ LANGUAGE plpgsql;

CREATE TRIGGER valida_tipo_quarto BEFORE INSERT OR UPDATE ON tipo_quarto
    FOR EACH ROW EXECUTE PROCEDURE valida_tipo_quarto();