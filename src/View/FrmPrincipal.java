/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Color;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

/**
 *
 * @author evand
 */
public class FrmPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form FrmPrincipal
     */
    public FrmPrincipal() {
        initComponents();
        getContentPane().setBackground(new Color(238, 107, 38));      
        //makeFullScreen();
        setExtendedState(FrmPrincipal.MAXIMIZED_BOTH);
        
    }
    
    private void makeFullScreen() {
        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice myDevice = env.getDefaultScreenDevice();
        myDevice.setFullScreenWindow(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlUsuario = new javax.swing.JPanel();
        btnLogout = new javax.swing.JButton();
        btnReport = new javax.swing.JButton();
        btnHome = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();
        pnlLogo = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        dskPrincipal = new javax.swing.JDesktopPane();
        btnPessoaFisica = new javax.swing.JButton();
        btnPessoaJuridica = new javax.swing.JButton();
        btnReserva = new javax.swing.JButton();
        btnProduto = new javax.swing.JButton();
        btnCidade = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("EasyRoom");

        pnlUsuario.setBackground(new java.awt.Color(32, 41, 95));
        pnlUsuario.setPreferredSize(new java.awt.Dimension(198, 324));

        btnLogout.setBackground(new java.awt.Color(238, 107, 38));
        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Images/logout.png"))); // NOI18N
        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        btnReport.setBackground(new java.awt.Color(238, 107, 38));
        btnReport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Images/reports.png"))); // NOI18N
        btnReport.setText("Relatórios");

        btnHome.setBackground(new java.awt.Color(238, 107, 38));
        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Images/home.png"))); // NOI18N
        btnHome.setText("Home        ");
        btnHome.setDisabledIcon(null);
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Administrador");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Celso Júnior Degasperi");

        lblUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Images/user.png"))); // NOI18N

        javax.swing.GroupLayout pnlUsuarioLayout = new javax.swing.GroupLayout(pnlUsuario);
        pnlUsuario.setLayout(pnlUsuarioLayout);
        pnlUsuarioLayout.setHorizontalGroup(
            pnlUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUsuarioLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(pnlUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlUsuarioLayout.createSequentialGroup()
                        .addGroup(pnlUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnReport, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlUsuarioLayout.createSequentialGroup()
                        .addGroup(pnlUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlUsuarioLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(44, 44, 44)))
                        .addGap(20, 20, 20))))
            .addGroup(pnlUsuarioLayout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(lblUser)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlUsuarioLayout.setVerticalGroup(
            pnlUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlUsuarioLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(lblUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(49, 49, 49)
                .addComponent(btnHome)
                .addGap(18, 18, 18)
                .addComponent(btnReport)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 403, Short.MAX_VALUE)
                .addComponent(btnLogout)
                .addGap(44, 44, 44))
        );

        pnlLogo.setBackground(new java.awt.Color(32, 41, 95));
        pnlLogo.setPreferredSize(new java.awt.Dimension(163, 72));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Images/logo.png"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("EasyRoom");

        javax.swing.GroupLayout pnlLogoLayout = new javax.swing.GroupLayout(pnlLogo);
        pnlLogo.setLayout(pnlLogoLayout);
        pnlLogoLayout.setHorizontalGroup(
            pnlLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLogoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 1253, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlLogoLayout.setVerticalGroup(
            pnlLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLogoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(pnlLogoLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(697, 697, 697))
        );

        dskPrincipal.setBackground(new java.awt.Color(204, 204, 204));

        btnPessoaFisica.setBackground(new java.awt.Color(238, 107, 38));
        btnPessoaFisica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Images/cadastro.png"))); // NOI18N
        btnPessoaFisica.setText("Cadastro de Pessoa Física");
        btnPessoaFisica.setToolTipText("");
        btnPessoaFisica.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnPessoaFisica.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPessoaFisica.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPessoaFisica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPessoaFisicaActionPerformed(evt);
            }
        });

        btnPessoaJuridica.setBackground(new java.awt.Color(238, 107, 38));
        btnPessoaJuridica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Images/juridica.png"))); // NOI18N
        btnPessoaJuridica.setText("Cadastro de Pessoa Jurídica");
        btnPessoaJuridica.setToolTipText("");
        btnPessoaJuridica.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnPessoaJuridica.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPessoaJuridica.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPessoaJuridica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPessoaJuridicaActionPerformed(evt);
            }
        });

        btnReserva.setBackground(new java.awt.Color(238, 107, 38));
        btnReserva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Images/reserva.png"))); // NOI18N
        btnReserva.setText("Reservas");
        btnReserva.setToolTipText("");
        btnReserva.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnReserva.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnReserva.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReservaActionPerformed(evt);
            }
        });

        btnProduto.setBackground(new java.awt.Color(238, 107, 38));
        btnProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Images/product.png"))); // NOI18N
        btnProduto.setText("Cadastro de Produtos");
        btnProduto.setToolTipText("");
        btnProduto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnProduto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnProduto.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProdutoActionPerformed(evt);
            }
        });

        btnCidade.setBackground(new java.awt.Color(238, 107, 38));
        btnCidade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Images/cidade.png"))); // NOI18N
        btnCidade.setText("Cadastro de Cidades");
        btnCidade.setToolTipText("");
        btnCidade.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCidade.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCidade.setMaximumSize(new java.awt.Dimension(170, 75));
        btnCidade.setMinimumSize(new java.awt.Dimension(170, 75));
        btnCidade.setPreferredSize(new java.awt.Dimension(170, 75));
        btnCidade.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCidadeActionPerformed(evt);
            }
        });

        dskPrincipal.setLayer(btnPessoaFisica, javax.swing.JLayeredPane.DEFAULT_LAYER);
        dskPrincipal.setLayer(btnPessoaJuridica, javax.swing.JLayeredPane.DEFAULT_LAYER);
        dskPrincipal.setLayer(btnReserva, javax.swing.JLayeredPane.DEFAULT_LAYER);
        dskPrincipal.setLayer(btnProduto, javax.swing.JLayeredPane.DEFAULT_LAYER);
        dskPrincipal.setLayer(btnCidade, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout dskPrincipalLayout = new javax.swing.GroupLayout(dskPrincipal);
        dskPrincipal.setLayout(dskPrincipalLayout);
        dskPrincipalLayout.setHorizontalGroup(
            dskPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dskPrincipalLayout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(btnPessoaFisica, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(btnPessoaJuridica, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(btnReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(btnCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(btnProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        dskPrincipalLayout.setVerticalGroup(
            dskPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dskPrincipalLayout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(dskPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPessoaJuridica, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPessoaFisica, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlLogo, javax.swing.GroupLayout.DEFAULT_SIZE, 1333, Short.MAX_VALUE)
                    .addComponent(dskPrincipal)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 758, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dskPrincipal))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnPessoaFisicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPessoaFisicaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPessoaFisicaActionPerformed

    private void btnPessoaJuridicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPessoaJuridicaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPessoaJuridicaActionPerformed

    private void btnReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReservaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnReservaActionPerformed

    private void btnProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProdutoActionPerformed
        IfrProduto ifrProduto = new IfrProduto();
        dskPrincipal.add(ifrProduto);
        ifrProduto.setVisible(true);
    }//GEN-LAST:event_btnProdutoActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCidadeActionPerformed
        IfrCidade ifrCidade = new IfrCidade();
        dskPrincipal.add(ifrCidade);
        ifrCidade.setVisible(true);
    }//GEN-LAST:event_btnCidadeActionPerformed

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
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCidade;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnPessoaFisica;
    private javax.swing.JButton btnPessoaJuridica;
    private javax.swing.JButton btnProduto;
    private javax.swing.JButton btnReport;
    private javax.swing.JButton btnReserva;
    private javax.swing.JDesktopPane dskPrincipal;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lblUser;
    private javax.swing.JPanel pnlLogo;
    private javax.swing.JPanel pnlUsuario;
    // End of variables declaration//GEN-END:variables
}