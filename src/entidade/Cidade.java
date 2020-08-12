/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cidade")
public class Cidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cidade")
    private Integer id_cidade;
    @Column(name = "ds_cidade")
    private String ds_cidade;
    @Column(name = "id_usuario_cadastro")
    private Integer id_usuario_cadastro;
    @Column(name = "ie_situacao")
    private Character ie_situacao;
    @JoinColumn(name = "id_estado", referencedColumnName = "id_estado")
    @ManyToOne(optional = false)
    private Estado id_estado;

    public Integer getId_cidade() {
        return id_cidade;
    }

    public void setId_cidade(Integer id_cidade) {
        this.id_cidade = id_cidade;
    }

    public String getDs_cidade() {
        return ds_cidade;
    }

    public void setDs_cidade(String ds_cidade) {
        this.ds_cidade = ds_cidade;
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

    public Estado getId_estado() {
        return id_estado;
    }

    public void setId_estado(Estado id_estado) {
        this.id_estado = id_estado;
    }

}
