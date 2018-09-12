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
public class Pagamento {
    
    private int id;
    private Divida divida;
    private DateFormat dataPagamento; //verificar o uso correto da classe de data.
    private double valorPago;

    public Pagamento(int id, Divida divida, DateFormat dataPagamento, double valorPago) {
        this.id = id;
        this.divida = divida;
        this.dataPagamento = dataPagamento;
        this.valorPago = valorPago;
    }
    
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

    public DateFormat getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(DateFormat dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }
}
