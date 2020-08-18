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
 * @author Degasperi
 */
@Entity
@Table(name = "entidade")
public class Entidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_entidade")
    private Integer id;
    @Column(name = "ds_endereco")
    private String endereco;
    @Column(name = "ds_bairro")
    private String bairro;
    @Column(name = "nr_endereco")
    private Integer numero;
    @Column(name = "ie_situacao")
    private Character situaca0;
    @Column(name = "ie_usuario_cadastro")
    private Character usuarioCadastro;
    @Column(name = "nr_telefone")
    private String telefone;
    @Column(name = "nr_celular")
    private String celular;
    @Column(name = "ds_email")
    private String email;
    @JoinColumn(name = "id_cidade", referencedColumnName = "id_cidade")
    @ManyToOne(optional = false)
    private Cidade cidade;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Character getSituaca0() {
        return situaca0;
    }

    public void setSituaca0(Character situaca0) {
        this.situaca0 = situaca0;
    }

    public Character getUsuarioCadastro() {
        return usuarioCadastro;
    }

    public void setUsuarioCadastro(Character usuarioCadastro) {
        this.usuarioCadastro = usuarioCadastro;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
    

}