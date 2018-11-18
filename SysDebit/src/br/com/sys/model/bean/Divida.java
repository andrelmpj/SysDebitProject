/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sys.model.bean;

import java.sql.Date;

/**
 *
 * @author victorramide
 */
public class Divida {
    
    private int codigo;
    private Cliente credor;
    private Cliente devedor;
    private Date dataAtualizacao;
    private double valorDivida;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Cliente getCredor() {
        return credor;
    }

    public void setCredor(Cliente credor) {
        this.credor = credor;
    }
    
    public Cliente getDevedor() {
        return devedor;
    }

    public void setDevedor(Cliente devedor) {
        this.devedor = devedor;
    }

    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public double getValorDivida() {
        return valorDivida;
    }

    public void setValorDivida(double valorDivida) {
        this.valorDivida = valorDivida;
    }    
}
