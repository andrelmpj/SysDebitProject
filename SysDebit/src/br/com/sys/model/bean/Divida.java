/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sys.model.bean;

import br.com.sys.model.bean.Cliente;
import java.text.DateFormat;

/**
 *
 * @author victorramide
 */
public class Divida {
    
    private int codigo;
    private Cliente cliente;
    private DateFormat dataAtualizacao; //verificar o uso correto da classe de data.
    private double valorDivida;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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
}
