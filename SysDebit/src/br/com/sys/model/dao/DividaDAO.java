/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sys.model.dao;

import br.com.sys.connection.ConnectionFactory;
import br.com.sys.model.bean.Divida;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author victo
 */
public class DividaDAO {
    
    public void create(Divida d){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO divida (credor, devedor, data_atualizacao, valor_divida) VALUES (?,?,?,?)");
            stmt.setInt(1, d.getCredor().getId());
            stmt.setInt(2, d.getDevedor().getId());
            
        } catch (SQLException ex) {
            Logger.getLogger(DividaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
