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

@Entity
@Table(name = "estado")
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estado")
    private Integer id_estado;
    @Column(name = "ds_estado")
    private String ds_estado;
    @Column(name = "ie_estado")
    private String ie_estado;
    @Column(name = "ie_situacao")
    private Character ie_situacao;

    public Integer getId_estado() {
        return id_estado;
    }

    public void setId_estado(Integer id_estado) {
        this.id_estado = id_estado;
    }

    public String getDs_estado() {
        return ds_estado;
    }

    public void setDs_estado(String ds_estado) {
        this.ds_estado = ds_estado;
    }

    public String getIe_estado() {
        return ie_estado;
    }

    public void setIe_estado(String ie_estado) {
        this.ie_estado = ie_estado;
    }

    public Character getIe_situacao() {
        return ie_situacao;
    }

    public void setIe_situacao(Character ie_situacao) {
        this.ie_situacao = ie_situacao;
    }
    
    
}
