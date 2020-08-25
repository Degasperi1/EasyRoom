package Entidade;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_quarto")
public class TipoQuarto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_quarto")
    private Integer id_tipo_quarto;
    @Column(name = "ds_tipo_quarto")
    private String ds_tipo_quarto;
    @Column(name = "nr_capacidade")
    private Integer nr_capacidade;
    @Column(name = "nr_comodo")
    private Integer nr_comodo;
    @Column(name = "nr_banheiro")
    private Integer nr_banheiro;
    @Column(name = "id_usuario_cadastro")
    private Integer id_usuario_cadastro;
    @Column(name = "vl_reserva")
    private Double vl_reserva;
    @Column(name = "ie_situacao")
    private Character ie_situacao;

    public Integer getId_tipo_quarto() {
        return id_tipo_quarto;
    }

    public void setId_tipo_quarto(Integer id_tipo_quarto) {
        this.id_tipo_quarto = id_tipo_quarto;
    }

    public String getDs_tipo_quarto() {
        return ds_tipo_quarto;
    }

    public void setDs_tipo_quarto(String ds_tipo_quarto) {
        this.ds_tipo_quarto = ds_tipo_quarto;
    }

    public Integer getNr_capacidade() {
        return nr_capacidade;
    }

    public void setNr_capacidade(Integer nr_capacidade) {
        this.nr_capacidade = nr_capacidade;
    }

    public Integer getNr_comodo() {
        return nr_comodo;
    }

    public void setNr_comodo(Integer nr_comodo) {
        this.nr_comodo = nr_comodo;
    }

    public Integer getNr_banheiro() {
        return nr_banheiro;
    }

    public void setNr_banheiro(Integer nr_banheiro) {
        this.nr_banheiro = nr_banheiro;
    }

    public Integer getId_usuario_cadastro() {
        return id_usuario_cadastro;
    }

    public void setId_usuario_cadastro(Integer id_usuario_cadastro) {
        this.id_usuario_cadastro = id_usuario_cadastro;
    }

    public Double getVl_reserva() {
        return vl_reserva;
    }

    public void setVl_reserva(Double vl_reserva) {
        this.vl_reserva = vl_reserva;
    }

    public Character getIe_situacao() {
        return ie_situacao;
    }

    public void setIe_situacao(Character ie_situacao) {
        this.ie_situacao = ie_situacao;
    }

    @Override
    public String toString() {
        return this.ds_tipo_quarto;
    }

    
}
