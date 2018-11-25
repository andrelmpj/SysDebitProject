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
public class DividaTableModel extends AbstractTableModel{
    
    private List<Divida> dados = new ArrayList();
    private String[] colunas = {"ID","Credor","Devedor","Valor", "Data"};
    
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
                return dados.get(linhas).getCodigo();
            case 1: 
                return dados.get(linhas).getCredor();
            case 2: 
                return dados.get(linhas).getDevedor();
            case 3: 
                return dados.get(linhas).getValorDivida();
            case 4:
                return dados.get(linhas).getDataAtualizacao();
        }
        
        return null;
    }
     public void addRow(Divida d) { 
        this.dados.add(d);
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
            dados.get(linhas).setCodigo((int) valor);
            break;
            case 1: 
            dados.get(linhas).setCredor((Cliente) valor);
            break;
            case 2: 
            dados.get(linhas).setDevedor((Cliente) valor);
            break;
            case 3: 
            dados.get(linhas).setValorDivida((double) valor);
            break;
            case 4:
            dados.get(linhas).setDataAtualizacao((Date) valor);
            break;
        }
        this.fireTableRowsUpdated(linhas, linhas);
    }
}
