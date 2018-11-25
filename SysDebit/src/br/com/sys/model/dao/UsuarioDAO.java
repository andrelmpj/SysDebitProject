/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sys.model.dao;

import br.com.sys.connection.ConnectionFactory;
import br.com.sys.model.bean.Usuario;
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
public class UsuarioDAO {
    /* private String nome;
    private String email;
    private String cargo;
    private String login;
    private String senha; */
    
     public void create(Usuario u){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO usuario (nome, email, cargo, login, senha) "
                    + ""
                    + "VALUES (?,?,?,?,?)");
            
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getEmail());
            stmt.setString(3, u.getCargo());
            stmt.setString(4, u.getLogin());
            stmt.setString(4, u.getSenha());
            
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }          
    }
    
    public void update(Usuario u) { 
        Connection con = ConnectionFactory.getConnection(); 
        PreparedStatement stmt = null; 
        
        try { 
            
            stmt = con.prepareStatement("UPDATE ususario SET nome = ? , email = ? , cargo = ?, login = ?, senha = ? WHERE nome = ? ");
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getEmail());
            stmt.setString(3, u.getCargo());
            stmt.setString(4, u.getLogin());
            stmt.setString(5, u.getSenha());
          
            
        JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }     
}
    
        public List<Usuario> read(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Usuario> usuario = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM usuario");
            rs = stmt.executeQuery();
            
            while (rs.next()){
                Usuario user = new Usuario();
                user.setNome(rs.getString("nome"));
                user.setEmail( rs.getString("email"));
                user.setCargo(rs.getString("cargo"));
                user.setLogin(rs.getString("login"));
                user.setSenha(rs.getString("senha"));
                
                usuario.add(user);                    
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar as dividas: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return usuario;
        }
        
        public List<Usuario> readForName(String nome){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Usuario> usuario = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM usuario WHERE nome LIKE ?");
            stmt.setString(1, "%"+nome+"%");
            rs = stmt.executeQuery();
            
                while (rs.next()){
                Usuario user = new Usuario();
                user.setNome(rs.getString("nome"));
                user.setEmail( rs.getString("email"));
                user.setCargo(rs.getString("cargo"));
                user.setLogin(rs.getString("login"));
                user.setSenha(rs.getString("senha"));
                
                usuario.add(user);                       
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar os usuarios: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return usuario;
        }
        
        public boolean checkLogin(String login, String senha){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        boolean check = false;
        
        try {
            stmt = con.prepareStatement("SELECT * FROM usuario WHERE login = ? and senha = ?");
            stmt.setString(1, login);
            stmt.setString(2, senha);
            
            rs = stmt.executeQuery();
            
            if (rs.next()){
                check = true;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: verifique se digitou o login e a senha corretamente.: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return check;
        }
      
        public void delete(Usuario u) { 
          Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE FROM usuario WHERE nome = ?) ");
            stmt.setString(1, u.getNome());
                    
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir"+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }    
    
 }
    
}
