/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidade;

import Utils.Calendario;
import java.text.ParseException;
import java.text.SimpleDateFormat;  
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Degasperi
 */
@Entity
@Table(name = "pessoa_fisica")
public class PessoaFisica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pessoa_fisica")
    private Integer id;
    @Column(name = "nm_pessoa_fisica")
    private String nome;
    @Column(name = "nr_cpf")
    private String cpf;
    @Column(name = "nr_rg")
    private String rg;
    @Column(name = "dt_nascimento")
    private Date dataNascimento;
    @Column(name = "ie_sexo")
    private Character sexo;
    @JoinColumn(name = "id_entidade", referencedColumnName = "id_entidade")
    @OneToOne
    private Entidade idEntidade;    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        Date date;
        try {
            date = new SimpleDateFormat("dd/MM/yyyy").parse(dataNascimento);
            this.dataNascimento = date;
        } catch (ParseException ex) {
            Logger.getLogger(PessoaFisica.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public Entidade getIdEntidade() {
        return idEntidade;
    }

    public void setIdEntidade(Entidade idEntidade) {
        this.idEntidade = idEntidade;
    }



    

}