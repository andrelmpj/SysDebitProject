/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sys.classes;

import java.text.DateFormat;

/**
 *
 * @author victorramide
 */
public class Divida {
    
    private int codigo;
    private Credor credor;
    private DateFormat dataAtualizacao; //verificar o uso correto da classe de data.
    private double valorDivida;
    private Devedor devedor;

    public Divida(int codigo, Credor credor, DateFormat dataAtualizacao, double valorDivida, Devedor devedor) {
        this.codigo = codigo;
        this.credor = credor;
        this.dataAtualizacao = dataAtualizacao;
        this.valorDivida = valorDivida;
        this.devedor = devedor;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Credor getCredor() {
        return credor;
    }

    public void setCredor(Credor credor) {
        this.credor = credor;
    }

    public DateFormat getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(DateFormat dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public double getValorDivida() {
        return valorDivida;
    }

    public void setValorDivida(double valorDivida) {
        this.valorDivida = valorDivida;
    }

    public Devedor getDevedor() {
        return devedor;
    }

    public void setDevedor(Devedor devedor) {
        this.devedor = devedor;
    }
}
