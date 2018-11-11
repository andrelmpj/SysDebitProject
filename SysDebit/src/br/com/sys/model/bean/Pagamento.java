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
public class Pagamento {
    
    private int id;
    private Divida divida;
    private Date dataPagamento; //verificar o uso correto da classe de data.
    private double valorPago;
   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Divida getDivida() {
        return divida;
    }

    public void setDivida(Divida divida) {
        this.divida = divida;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }
}
