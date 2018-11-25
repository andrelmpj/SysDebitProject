/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sys.model.dao;

import br.com.sys.connection.ConnectionFactory;
import br.com.sys.model.bean.Cliente;
import br.com.sys.model.bean.Divida;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author victo
 */
public class DividaDAO {
    
    public void create(Divida d){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO divida (id, credor, devedor, data_atualizacao, valor_divida, pago) "
                    + "VALUES (?,?,?,?,?)");
            stmt.setInt(1, d.getCodigo());
            stmt.setInt(2, d.getCredor().getId());
            stmt.setInt(3, d.getDevedor().getId());
            stmt.setString(4, d.getDataAtualizacao().toString());
            stmt.setDouble(5, d.getValorDivida());
            stmt.setBoolean(6, d.isPago());
            
        JOptionPane.showMessageDialog(null, "Dívida adcionada com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao adicionar "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }    
    }
    
    public void update(Divida d) { 
        Connection con = ConnectionFactory.getConnection(); 
        PreparedStatement stmt = null; 
        
        try { 
            
            stmt = con.prepareStatement("UPDATE divida SET credor = ? , devedor = ? , data_atualizacao = ?, valor_divida = ? WHERE id = ? ");
            stmt.setInt(1, d.getCredor().getId());
            stmt.setInt(2, d.getDevedor().getId());
            stmt.setString(3, d.getDataAtualizacao().toString());
            stmt.setDouble(4, d.getValorDivida());
            stmt.setInt(5, d.getCodigo());
            
        JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }     
    
    
}
    
    public List<Divida> read(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Divida> divida = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM divida");
            rs = stmt.executeQuery();
            
            while (rs.next()){
                Divida div = new Divida();
                div.setCodigo(rs.getInt("id"));
                div.setCredor((Cliente) rs.getObject("credor"));
                div.setDevedor((Cliente) rs.getObject("devedor"));
                div.setDataAtualizacao((Date) rs.getObject("data"));
                div.setValorDivida(rs.getDouble("valorDivida"));
                div.setPago(rs.getBoolean("pago"));
                divida.add(div);
                
                                     
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar as dividas: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return divida;
    }
      
    public List<Divida> readDividasNaoPagas(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Divida> divida = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM divida WHERE pago = false");
            rs = stmt.executeQuery();
            
            while (rs.next()){
                Divida div = new Divida();
                div.setCodigo(rs.getInt("id"));
                div.setCredor((Cliente) rs.getObject("credor"));
                div.setDevedor((Cliente) rs.getObject("devedor"));
                div.setDataAtualizacao((Date) rs.getObject("data"));
                div.setValorDivida(rs.getDouble("valorDivida"));
                div.setPago(rs.getBoolean("pago"));
                divida.add(div);             
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar as dividas não pagas: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return divida;
    }
    
        public List<Divida> readDividasFaturadas(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Divida> divida = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM divida WHERE pago = true");
            rs = stmt.executeQuery();
            
            while (rs.next()){
                Divida div = new Divida();
                div.setCodigo(rs.getInt("id"));
                div.setCredor((Cliente) rs.getObject("credor"));
                div.setDevedor((Cliente) rs.getObject("devedor"));
                div.setDataAtualizacao((Date) rs.getObject("data"));
                div.setValorDivida(rs.getDouble("valorDivida"));
                div.setPago(rs.getBoolean("pago"));
                divida.add(div);             
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar as dividas faturadas: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return divida;
    } 
      
      public void delete(Divida d) { 
          Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE FROM divida WHERE id = ?) ");
            stmt.setInt(1, d.getCodigo());
                    
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir"+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }    
    
}
 
}