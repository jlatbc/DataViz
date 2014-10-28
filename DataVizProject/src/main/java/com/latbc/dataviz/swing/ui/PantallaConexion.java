package com.latbc.dataviz.swing.ui;

import com.latbc.dataviz.utils.ConnectorDB;
import com.latbc.dataviz.beans.ConnectionBean;
import com.latbc.dataviz.utils.DBFactory;
import com.latbc.dataviz.utils.PropertiesUtil;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Latbc
 */
public class PantallaConexion extends javax.swing.JFrame {
    
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(PantallaConexion.class);

//    private PantallaPrueba pantallaPrueba;
//
//    public void setPantallaPrueba(PantallaPrueba pantallaPrueba) {
//        this.pantallaPrueba = pantallaPrueba;
//        pantallaPrueba.getjTextField1().setText("MIJO");
//    }
    /**
     * Creates new form PantallaConexion
     */
    public PantallaConexion() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        USER_TEXT_FIELD = new javax.swing.JTextField();
        PASS_TEXT_FIELD = new javax.swing.JTextField();
        URL_TEXT_FIELD = new javax.swing.JTextField();
        CONNECTION_BUTTON = new javax.swing.JButton();
        URL_LABEL = new javax.swing.JLabel();
        USER_LABEL = new javax.swing.JLabel();
        PASSWORD_LABEL = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Conectar a base de datos");

        USER_TEXT_FIELD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                USER_TEXT_FIELDActionPerformed(evt);
            }
        });

        CONNECTION_BUTTON.setText("Conectar");
        CONNECTION_BUTTON.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CONNECTION_BUTTONActionPerformed(evt);
            }
        });
        CONNECTION_BUTTON.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CONNECTION_BUTTONKeyPressed(evt);
            }
        });

        URL_LABEL.setText("URL");

        USER_LABEL.setText("User");

        PASSWORD_LABEL.setText("Password");

        jButton1.setText("Cerrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(URL_LABEL)
                                    .addGap(107, 107, 107))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(USER_LABEL)
                                    .addGap(104, 104, 104)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(PASSWORD_LABEL)
                                .addGap(93, 93, 93)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(USER_TEXT_FIELD, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(URL_TEXT_FIELD, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PASS_TEXT_FIELD, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(141, 141, 141))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(CONNECTION_BUTTON, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(202, 202, 202))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(URL_TEXT_FIELD, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(URL_LABEL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(USER_TEXT_FIELD, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(USER_LABEL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PASS_TEXT_FIELD, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PASSWORD_LABEL))
                .addGap(27, 27, 27)
                .addComponent(CONNECTION_BUTTON)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        DBFactory dbFactory = new DBFactory();
        try {
            dbFactory.closeConnection();
        } catch (SQLException e) {
            e.getMessage();
        }
    }                                        

    private void CONNECTION_BUTTONKeyPressed(java.awt.event.KeyEvent evt) {                                             
        // TODO add your handling code here:
    }                                            

    private void CONNECTION_BUTTONActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        // TODO add your handling code here:

        ConnectionBean connectionBean = new ConnectionBean();
        PropertiesUtil propUtil = new PropertiesUtil();
        propUtil.setPath("src//main//resources//config.properties");

        try {
            propUtil.loadProperties();
        } catch (IOException ex) {
            Logger.getLogger(PantallaConexion.class.getName()).log(Level.SEVERE, null, ex);
        }

        String url = propUtil.getProperty("urlMySQL");
        String user = propUtil.getProperty("userNameMySQL");
        String pass = propUtil.getProperty("passwordMySQL");

        connectionBean.setDriver("com.mysql.jdbc.Driver");
        connectionBean.setDbName("person_db_test");

        //Compara que el valor
        if (URL_TEXT_FIELD.getText() != null && URL_TEXT_FIELD.getText().equals(url)) {
            connectionBean.setUrl(URL_TEXT_FIELD.getText());
            LOGGER.info("URL--");
        }

        if (USER_TEXT_FIELD.getText() != null && USER_TEXT_FIELD.getText().equals(user)) {
            connectionBean.setUser(USER_TEXT_FIELD.getText());
            LOGGER.info("USER--");
        }

        if (PASS_TEXT_FIELD.getText() != null && PASS_TEXT_FIELD.getText().equals(pass)) {
            connectionBean.setPassword(PASS_TEXT_FIELD.getText());
            LOGGER.info("PASS--");
        }

        DBFactory dbFactory = new DBFactory();     
        try {
            ConnectorDB connectorDB = dbFactory.getConnection("MySQL");
            connectorDB.createConnection(connectionBean);

        } catch (Exception ex) {
            LOGGER.debug("Error: " + ex);
        }

//        if (connectionBean.getUser() != null && connectionBean.getUrl() != null && connectionBean.getPassword() != null) {
//            PantallaQuery pantallaQuery = new PantallaQuery();
//            pantallaQuery.setVisible(true);
//        }

//        pantallaPrueba.setVisible(true);

    }                                                 

    private void USER_TEXT_FIELDActionPerformed(java.awt.event.ActionEvent evt) {                                                
        // TODO add your handling code here:
    }                                               

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
            java.util.logging.Logger.getLogger(PantallaConexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaConexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaConexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaConexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaConexion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton CONNECTION_BUTTON;
    private javax.swing.JLabel PASSWORD_LABEL;
    private javax.swing.JTextField PASS_TEXT_FIELD;
    private javax.swing.JLabel URL_LABEL;
    private javax.swing.JTextField URL_TEXT_FIELD;
    private javax.swing.JLabel USER_LABEL;
    private javax.swing.JTextField USER_TEXT_FIELD;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration                   
}
