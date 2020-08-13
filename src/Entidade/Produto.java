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
import javax.persistence.Table;

/**
 *
 * @author evand
 */
@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto")
    private Integer id_produto;
    @Column(name = "ds_produto")
    private String ds_produto;
    @Column(name = "vl_venda")
    private Double vl_venda;
    @Column(name = "id_usuario_cadastro")
    private Integer id_usuario_cadastro;
    @Column(name = "ie_situacao")
    private Character ie_situacao;

    public Integer getId_produto() {
        return id_produto;
    }

    public void setId_produto(Integer id_produto) {
        this.id_produto = id_produto;
    }

    public String getDs_produto() {
        return ds_produto;
    }

    public void setDs_produto(String ds_produto) {
        this.ds_produto = ds_produto;
    }

    public Double getVl_venda() {
        return vl_venda;
    }

    public void setVl_venda(Double vl_venda) {
        this.vl_venda = vl_venda;
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

}
