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
public class Devedor extends Pessoa{
    
    private int id;
    private String endereco;
    private String uf;
    private String telefone;
    private String documento;

    public Devedor(String nome, String email, int id, String endereco, String uf, String telefone, String documento) {
        this.nome = nome;
        this.email = email;
        this.id = id;
        this.endereco = endereco;
        this.uf = uf;
        this.telefone = telefone;
        this.documento = documento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
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
