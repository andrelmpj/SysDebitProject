/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sys.model.bean;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ANDRE
 */
public class ClienteTableModel extends AbstractTableModel {
    
    private List<Cliente> dados = new ArrayList();
    private String[] colunas = {"ID","Nome","Email","Tipo"};

    public void setDados(List<Cliente> dados) {
        this.dados = dados;
    }

    
    @Override
    public String getColumnName(int column) {
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
                return dados.get(linhas).getId();
            case 1: 
                return dados.get(linhas).getNome();
            case 2: 
                return dados.get(linhas).getEmail();
            case 3: 
                return dados.get(linhas).getTipo();
        }
        
        return null;
    }
    
    public void addRow(Cliente c) { 
        this.dados.add(c);
        this.fireTableDataChanged();
        
    }
     
    public void removeRow(int linhas) { 
        this.dados.remove(linhas);
        this.fireTableRowsDeleted(linhas, linhas);
    }
    
    public void setValueAt(Object valor, int linhas, int colunas) {
        switch (colunas) {
            case 0: 
            dados.get(linhas).setId(Integer.parseInt((String) valor));
            break;
            case 1: 
            dados.get(linhas).setNome((String) valor);
            break;
            case 2: 
            dados.get(linhas).setEmail((String) valor);
            break;
            case 3: 
            dados.get(linhas).setTipo((String) valor);
            break;
        }
        this.fireTableRowsUpdated(linhas, linhas);
    }

    private String colunas(int column) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
