/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sys.model.bean;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Victor
 */
public class PagamentoTableModel extends AbstractTableModel{
    
    private List<Pagamento> dados = new ArrayList();
    private String[] colunas = {"ID Divida","Valor Pago", "Data"};
    
    public String getColumnName(int column){
        return colunas[column];
    }

   @Override
    public int getRowCount() {
        return dados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linhas, int colunas) {
        switch (colunas) {
            case 0: 
                return dados.get(linhas).getDivida();
            case 1: 
                return dados.get(linhas).getValorPago();
            case 2: 
                return dados.get(linhas).getDataPagamento();
        }
        
        return null;
    }
     public void addRow(Pagamento p) { 
        this.dados.add(p);
        this.fireTableDataChanged();
        
    }
     
    public void removeRow(int linhas) { 
        this.dados.remove(linhas);
        this.fireTableRowsDeleted(linhas, linhas);
    }
    
    @Override
    public void setValueAt(Object valor, int linhas, int colunas) {
        switch (colunas) {
            case 0: 
            dados.get(linhas).setDivida((Divida) valor);
            break;
            case 1: 
            dados.get(linhas).setValorPago((double) valor);
            break;
            case 2: 
            dados.get(linhas).setDataPagamento((Date) valor);
            break;
        }
        this.fireTableRowsUpdated(linhas, linhas);
    }
    
}
