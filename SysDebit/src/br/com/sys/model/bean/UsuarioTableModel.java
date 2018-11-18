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
public class UsuarioTableModel extends AbstractTableModel {
    
    private List<Usuario> dados = new ArrayList();
    private String[] colunas = {"Nome","Usuario","Email","Cargo"};
    
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
                return dados.get(linhas).getNome();
            case 1: 
                return dados.get(linhas).getLogin();
            case 2: 
                return dados.get(linhas).getEmail();
            case 3: 
                return dados.get(linhas).getCargo();
        }
        
        return null;
    }
     public void addRow(Usuario u) { 
        this.dados.add(u);
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
            dados.get(linhas).setNome((String) valor);
            break;
            case 1: 
            dados.get(linhas).setLogin((String) valor);
            break;
            case 2: 
            dados.get(linhas).setEmail((String) valor);
            break;
            case 3: 
            dados.get(linhas).setCargo((String) valor);
            break;
        }
        this.fireTableRowsUpdated(linhas, linhas);
    }

    

    
    
}
