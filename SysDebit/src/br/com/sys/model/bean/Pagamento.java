/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sys.model.bean;
import java.sql.Date;
import java.util.logging.Logger;

/**
 *
 * @author victorramide
 */
public class Pagamento {
    
    private int id;
    public Divida divida;
    private Date dataPagamento; //verificar o uso correto da classe de data.
    private double juros;
    private double valorPago;
    private Date data_Inicial;
    private Date data_Final;

    public Date getData_Inicial() {
        return data_Inicial;
    }

    public void setData_Inicial(Date data_Inicial) {
        this.data_Inicial = data_Inicial;
    }

    public Date getData_Final() {
        return data_Final;
    }

    public void setData_Final(Date data_Final) {
        this.data_Final = data_Final;
    }
    
    
    private static final Logger LOG = Logger.getLogger(Pagamento.class.getName());
    
    

    public double getJuros() {
        return juros;
    }

    public void setJuros(double juros) {
        this.juros = juros;
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

    public Object setDivida() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
