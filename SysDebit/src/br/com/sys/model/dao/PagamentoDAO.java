/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sys.model.dao;

import br.com.sys.connection.ConnectionFactory;
import br.com.sys.model.bean.Divida;
import br.com.sys.model.bean.Pagamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ANDRE
 */
public class PagamentoDAO {
    public void create(Pagamento p){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO pagamento ( divida, dataPagamento, valorPago) "
                    + ""
                    + "VALUES (?,?,?)");
            
            stmt.setString(1, p.getDivida().toString());
            stmt.setString(2, p.getDataPagamento().toString());
            stmt.setDouble(3, p.getValorPago());
            
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }          
    }
    
    public void update(Pagamento p) { 
        Connection con = ConnectionFactory.getConnection(); 
        PreparedStatement stmt = null; 
        
        try { 
            
            stmt = con.prepareStatement("UPDATE pagamento SET divida = ? , dataPagamento = ? , valorPago = ?, WHERE id = ? ");
            stmt.setInt(1, p.getDivida().getCodigo());
            stmt.setDate(2, p.getDataPagamento());
            stmt.setDouble(3, p.getValorPago());
          
            
        JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }     
}
    
    public void pagar(Pagamento p){
        
        Connection con = ConnectionFactory.getConnection(); 
        PreparedStatement stmt = null; 
        try { 
            stmt = con.prepareStatement("UPDATE divida SET pago = true WHERE id = ?");
            stmt.setInt(1, p.getDivida().getCodigo());
        JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Erro ao inserir o pagamento na dívida"+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }     
    }
    public List<Pagamento> read(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Pagamento> pagamentos = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM pagamento");
            rs = stmt.executeQuery();
            
            while (rs.next()){
                Pagamento pag = new Pagamento();
                pag.setDivida((Divida) rs.getObject("divida"));
                pag.setDataPagamento( rs.getDate("data"));
                pag.setValorPago(rs.getDouble("valorPago"));
                
                pagamentos.add(pag);
                
                                     
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar os pagamentos: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return pagamentos;
    }
    
        public List<Pagamento> readForIdDivida(int divida){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Pagamento> pagamentos = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM pagamento WHERE divida LIKE ?");
            stmt.setString(1, "%"+divida+"%");
            rs = stmt.executeQuery();
            
            while (rs.next()){
                Pagamento pag = new Pagamento();
                pag.setDivida((Divida) rs.getObject("divida"));
                pag.setDataPagamento( rs.getDate("data"));
                pag.setValorPago(rs.getDouble("valorPago"));
                
                pagamentos.add(pag);                            
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar os pagamentos: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return pagamentos;
    }
      
        public void delete(Pagamento p) { 
          Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE FROM pagamento WHERE id = ?) ");
            stmt.setInt(1, p.getId());
                    
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir"+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }    
    
 }

  }
    


    
    
   

