/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import TableModel.LogTableModel;
import Utils.JTableUtilities;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

/**
 *
 * @author evand
 */
public class IfrLog extends javax.swing.JInternalFrame {

    String fileName;
    LogTableModel tableModel = new LogTableModel();

    public IfrLog() {
        initComponents();
        this.fileName = "src/logs.log";
        montaTabela(tblLog);
        rbErro.setSelected(true);
        getRootPane().setDefaultButton(btnBuscar);
    }

    private void montaTabela(JTable table) {
        table.setModel(this.tableModel);
        JTableUtilities.setCellsAlignment(tblLog, SwingConstants.CENTER, new int[]{0, 1});
        tblLog.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//      JTableUtilities.resizeColumns(tblLog, new float[]{0.05f, 0.05f, 0.90f});
        JTableUtilities.setWidthAsPercentages(tblLog, 0.05f, 0.15f, 0.80f);
        this.setTitle("Registros de Log do Sistema");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgTipoLog = new javax.swing.ButtonGroup();
        scrLogTable = new javax.swing.JScrollPane();
        tblLog = new javax.swing.JTable();
        btnFechar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tfdBusca = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        rbErro = new javax.swing.JRadioButton();
        rbWarn = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        btnCSVLog = new javax.swing.JButton();
        dcDataInicial = new com.toedter.calendar.JDateChooser();
        dcDataFinal = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        tblLog.setModel(new javax.swing.table.DefaultTableModel(
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
        scrLogTable.setViewportView(tblLog);

        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        jLabel1.setText("Busca:");

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Images/search-30.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel2.setText("Tipo de Log:");

        bgTipoLog.add(rbErro);
        rbErro.setText("ERRO");

        bgTipoLog.add(rbWarn);
        rbWarn.setText("WARN");

        jLabel3.setText("Mensagem:");

        btnCSVLog.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Images/exportar-csv-30.png"))); // NOI18N
        btnCSVLog.setText("Exportar para CSV");

        jLabel4.setText("Data Inicial");

        jLabel5.setText("Data Final");

        jLabel6.setText("Filtro de data:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrLogTable, javax.swing.GroupLayout.DEFAULT_SIZE, 1067, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfdBusca))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(rbErro)
                                        .addGap(18, 18, 18)
                                        .addComponent(rbWarn))
                                    .addComponent(jLabel1))
                                .addGap(76, 76, 76)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(dcDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(38, 38, 38)
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(dcDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel6))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCSVLog, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE))
                        .addGap(4, 4, 4)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel6))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(rbErro)
                                .addComponent(rbWarn))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel5)
                                .addComponent(dcDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel4)
                                .addComponent(dcDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(btnCSVLog))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfdBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(scrLogTable, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFechar)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed

        this.dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // DATAS
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String dataInicial = "";
        String dataFinal = "";
        
        // TESTA SE DIGITOU ALGO NO CAMPO DE DATA
        if (dcDataInicial.getDate() != null) {
            dataInicial = df.format(dcDataInicial.getDate());
        }
        if (dcDataFinal.getDate() != null) {
            dataFinal = df.format(dcDataFinal.getDate());
        }

        if (rbErro.isSelected()) {
            this.tableModel.updateData(tfdBusca.getText(), "ERROR", dataInicial, dataFinal);
        } else if (rbWarn.isSelected()) {
            this.tableModel.updateData(tfdBusca.getText(), "WARN", dataInicial, dataFinal);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgTipoLog;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCSVLog;
    private javax.swing.JButton btnFechar;
    private com.toedter.calendar.JDateChooser dcDataFinal;
    private com.toedter.calendar.JDateChooser dcDataInicial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JRadioButton rbErro;
    private javax.swing.JRadioButton rbWarn;
    private javax.swing.JScrollPane scrLogTable;
    private javax.swing.JTable tblLog;
    private javax.swing.JTextField tfdBusca;
    // End of variables declaration//GEN-END:variables
}
