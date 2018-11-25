/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sys.view;

import br.com.sys.model.bean.Cliente;
import br.com.sys.model.bean.Divida;
import br.com.sys.model.dao.ClienteDAO;
import br.com.sys.model.dao.DividaDAO;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author ANDRE
 */
public class TelaDivida extends javax.swing.JInternalFrame {

    /**
     * Creates new form TelaDivida
     */
    public TelaDivida() {
        initComponents();
        DefaultTableModel modelo = (DefaultTableModel) tableDivida.getModel();
        tableDivida.setRowSorter(new TableRowSorter(modelo));
        preencherJComboBox();
    }
    
    public void readTable() { 
        DefaultTableModel modelo = (DefaultTableModel) tableDivida.getModel();
        modelo.setNumRows(0);
        DividaDAO ddao = new DividaDAO();
        
        for (Divida d : ddao.read()) {
            modelo.addRow(new Object[]{
                d.getCodigo(),
                d.getCredor(),
                d.getDevedor(),
                d.getValorDivida(),
                d.getDataAtualizacao(),
                d.isPago()
            });
        }
    }
    
    public void readJTableDividasNaoPagas() {
        
        DefaultTableModel modelo = (DefaultTableModel) tableDivida.getModel();
        modelo.setNumRows(0);
        DividaDAO ddao = new DividaDAO();

        for (Divida d : ddao.readDividasNaoPagas()) {
            modelo.addRow(new Object[]{
                d.getCodigo(),
                d.getCredor(),
                d.getDevedor(),
                d.getValorDivida(),
                d.getDataAtualizacao(),
                d.isPago()
            });
        }
    }
    
    public void preencherJComboBox(){
	ClienteDAO cdao = new ClienteDAO();
	for (Cliente cliente : cdao.read()){
		cmbCredor.addItem(cliente.toString());
		cmbDevedor.addItem(cliente.toString());
	}
    }
    /*public void readJTableForName(String nome) {
        
        DefaultTableModel modelo = (DefaultTableModel) tableDivida.getModel();
        modelo.setNumRows(0);
        DividaDAO ddao = new DividaDAO();

        for (Divida d : ddao.read()) {

            modelo.addRow(new Object[]{
                d.getCodigo(),
                d.getCredor(),
                d.getDevedor(),
                d.getValorDivida(),
                d.getDataAtualizacao(),
            });
        }
    }*/
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtIdDiv = new javax.swing.JTextField();
        txtDivValor = new javax.swing.JTextField();
        cmbCredor = new javax.swing.JComboBox<>();
        cmbDevedor = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnAdicionar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableDivida = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        txtDivData = new javax.swing.JFormattedTextField();

        jLabel1.setText("jLabel1");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Dívida");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("ID:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Credor:*");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Devedor:*");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Valor:*");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Data*");

        txtDivValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDivValorActionPerformed(evt);
            }
        });

        cmbCredor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCredorActionPerformed(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sys/imagens/sisdebt 185x85.png"))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("*Campos obrigatórios");

        btnAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sys/imagens/add.png"))); // NOI18N
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sys/imagens/update.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sys/imagens/del.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        tableDivida.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Credor", "Devedor", "Valor", "Data", "Pago"
            }
        ));
        jScrollPane2.setViewportView(tableDivida);

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setText("Listar dívidas");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton5.setText("Exibir dívidas em aberto");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        txtDivData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
        txtDivData.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtDivData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDivDataActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(221, 221, 221)
                        .addComponent(jLabel7))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(26, 26, 26)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtDivValor, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtDivData))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(txtIdDiv, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                                .addComponent(jLabel8))
                            .addComponent(cmbDevedor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbCredor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton5))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(80, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addComponent(btnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtIdDiv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbCredor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbDevedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(txtDivValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDivData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAdicionar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDivValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDivValorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDivValorActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        try {
            // TODO add your handling code here:
            SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date invoiceDate = formatDate.parse(txtDivData.getText());
            java.sql.Date sqlDate = new java.sql.Date(invoiceDate.getTime());
            
            Divida d = new Divida();
            DividaDAO dao = new DividaDAO();
            d.setCodigo(Integer.parseInt(txtIdDiv.getText()));
            d.setCredor((Cliente) cmbCredor.getSelectedItem());
            d.setDevedor((Cliente) cmbDevedor.getSelectedItem());
            d.setValorDivida(Integer.parseInt(txtDivValor.getText()));
            d.setDataAtualizacao(sqlDate);
            dao.create(d);
            
            txtIdDiv.setText("");
            txtDivValor.setText("");
            txtDivData.setText("");
            
            readTable();
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Verifique se o formato da data está correto.", "ERRO AO ADICIONAR", ERROR);
        }
        
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void txtDivDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDivDataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDivDataActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            // TODO add your handling code here:
            SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date invoiceDate = formatDate.parse(txtDivData.getText());
            java.sql.Date sqlDate = new java.sql.Date(invoiceDate.getTime());
            
            if (tableDivida.getSelectedRow() != -1 ) {
                
                Divida d = new Divida();
                DividaDAO dao = new DividaDAO();
                d.setCodigo((int) tableDivida.getValueAt(tableDivida.getSelectedRow(), 0));
                d.setCredor((Cliente) cmbCredor.getSelectedItem());
                d.setDevedor((Cliente) cmbDevedor.getSelectedItem());
                d.setValorDivida(Integer.parseInt(txtDivValor.getText()));
                d.setDataAtualizacao(sqlDate);
                
                dao.update(d);
                
                txtIdDiv.setText("");
                txtDivValor.setText("");
                txtDivData.setText("");
                
                readTable();
                
            }
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Verifique se o formato da data está correto.", "ERRO AO ATUALIZAR", ERROR);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if (tableDivida.getSelectedRow() != -1) {
        Divida d = new Divida();
        DividaDAO dao = new DividaDAO();
        d.setCodigo((int) tableDivida.getValueAt(tableDivida.getSelectedRow(), 0));
        
        dao.delete(d);
        
        txtIdDiv.setText("");
        txtDivValor.setText("");
        txtDivData.setText("");
        
        readTable();
        
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void cmbCredorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCredorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCredorActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        readTable();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JComboBox<String> cmbCredor;
    private javax.swing.JComboBox<String> cmbDevedor;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tableDivida;
    private javax.swing.JFormattedTextField txtDivData;
    private javax.swing.JTextField txtDivValor;
    private javax.swing.JTextField txtIdDiv;
    // End of variables declaration//GEN-END:variables
}
