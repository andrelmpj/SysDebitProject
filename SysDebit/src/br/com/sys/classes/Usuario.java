/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sys.classes;

/**
 *
 * @author victorramide
 */
public class Usuario extends Pessoa{
       
    private String cargo;
    private String login;
    private String senha;

    public Usuario(String nome, String email, String cargo, String login, String senha) {
        this.nome = nome;
        this.email = email;
        this.cargo = cargo;
        this.login = login;
        this.senha = senha;
    }
    
    

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
