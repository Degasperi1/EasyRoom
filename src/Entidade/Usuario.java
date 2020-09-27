/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidade;

/**
 *
 * @author Eduardo
 */
public class Usuario {

    private String id;
    private String login;

    public Usuario(String id, String login) {
        
    } public Usuario() {
}

    public String getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    
}
