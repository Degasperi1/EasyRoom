/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author evand
 */
@Entity
@Table(name = "quarto")
public class Quarto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_quarto")
    private Integer id_quarto;
    @Column(name = "nr_quarto")
    private String nr_quarto;
    @Column(name = "nr_andar")
    private String nr_andar;
    @Column(name = "id_usuario_cadastro")
    private Integer id_usuario_cadastro;
    @Column(name = "ie_situacao")
    private Character ie_situacao;
    @JoinColumn(name = "id_tipo_quarto", referencedColumnName = "id_tipo_quarto")
    @ManyToOne(optional = false)
    private TipoQuarto id_tipo_quarto;

    public Integer getId_quarto() {
        return id_quarto;
    }

    public void setId_quarto(Integer id_quarto) {
        this.id_quarto = id_quarto;
    }

    public String getNr_quarto() {
        return nr_quarto;
    }

    public void setNr_quarto(String nr_quarto) {
        this.nr_quarto = nr_quarto;
    }

    public String getNr_andar() {
        return nr_andar;
    }

    public void setNr_andar(String nr_andar) {
        this.nr_andar = nr_andar;
    }

    public Integer getId_usuario_cadastro() {
        return id_usuario_cadastro;
    }

    public void setId_usuario_cadastro(Integer id_usuario_cadastro) {
        this.id_usuario_cadastro = id_usuario_cadastro;
    }

    public Character getIe_situacao() {
        return ie_situacao;
    }

    public void setIe_situacao(Character ie_situacao) {
        this.ie_situacao = ie_situacao;
    }

    public TipoQuarto getId_tipo_quarto() {
        return id_tipo_quarto;
    }

    public void setId_tipo_quarto(TipoQuarto id_tipo_quarto) {
        this.id_tipo_quarto = id_tipo_quarto;
    }

}
