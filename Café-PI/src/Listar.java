
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author fabricio.pvilla
 */
public class Listar extends javax.swing.JFrame {

    /**
     * Creates new form receitas
     */
    public Listar() {
        initComponents();
        listar();
    }
    
    public void listar(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conectar = DriverManager.getConnection("jdbc:mysql://localhost:3306/cafe","root",""); 
            
            PreparedStatement st = conectar.prepareStatement("SELeCT * FROM receitas");
            ResultSet receitas = st.executeQuery();
            DefaultTableModel tblModelo = (DefaultTableModel) tblReceitas.getModel();
            tblModelo.setRowCount(0);
            
            while (receitas.next()) {                
                String linha[]={
                    receitas.getString("nome")
                };
                tblModelo.addRow(linha);
            }
           
            
        }catch(ClassNotFoundException | SQLException ex){
            JOptionPane.showInternalMessageDialog(null, "entre em contato com o suporte e informe o erro:"+ ex.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblReceitas = new javax.swing.JTable();
        txtReceita = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Receitas");
        getContentPane().setLayout(null);

        tblReceitas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "receitas"
            }
        ));
        jScrollPane1.setViewportView(tblReceitas);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(110, 130, 270, 280);
        getContentPane().add(txtReceita);
        txtReceita.setBounds(120, 70, 200, 40);

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/procurar.png"))); // NOI18N
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar);
        btnBuscar.setBounds(320, 70, 50, 40);

        jLabel1.setText("Receita:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(70, 70, 90, 50);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/1000_F_312194478_3gfoLemMP4xcsEOk31Gtn69qTSDmY6hS.jpg"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(-10, -220, 510, 1400);

        setSize(new java.awt.Dimension(482, 505));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String u;
        u = txtReceita.getText();
        if (u.equals("Todos")) {
            listar();
            return;
        }
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conectar = DriverManager.getConnection("jdbc:mysql://localhost:3306/cafe","root","");

            PreparedStatement st = conectar.prepareStatement("SELECT * FROM receitas WHERE nome LIKE ?");
            st.setString(1, "%" + u + "%");
            ResultSet usuarios = st.executeQuery();
            DefaultTableModel tblModelo = (DefaultTableModel) tblReceitas.getModel();
            tblModelo.setRowCount(0);
            
            while (usuarios.next()) {                
                String linha[]={
                    usuarios.getString("nome")
                };
                tblModelo.addRow(linha);
            }
            
        } catch (ClassNotFoundException ex) {
            JOptionPane.showInternalMessageDialog(null, "entre em contato com o suporte e informe o erro:"+ ex.getMessage());
        } catch (SQLException ex) {
            String erro = ex.getMessage();
            if(erro.contains("Duplycate entry")){
                JOptionPane.showMessageDialog(null, "usuario ja cadastrado");
            }else{
                JOptionPane.showInternalMessageDialog(null, "entre em contato com o suporte e informe o erro:"+ ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Listar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Listar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Listar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Listar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Listar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblReceitas;
    private javax.swing.JTextField txtReceita;
    // End of variables declaration//GEN-END:variables
}
