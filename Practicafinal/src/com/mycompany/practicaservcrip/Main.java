/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practicaservcrip;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.ImageIcon;


public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(Alignment.LEADING, layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(panel, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(888, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(panel, GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
        			.addGap(20))
        );
        panel.setLayout(null);
        rbCD = new javax.swing.JRadioButton();
        rbCD.setBounds(22, 35, 225, 51);
        panel.add(rbCD);
        
                rbCD.setFont(new Font("Freestyle Script", Font.BOLD | Font.ITALIC, 36)); // NOI18N
                rbCD.setText("Cifrado/Descifrado");
                rbFV = new javax.swing.JRadioButton();
                rbFV.setBounds(22, 150, 221, 51);
                panel.add(rbFV);
                
                        rbFV.setFont(new Font("Freestyle Script", Font.BOLD | Font.ITALIC, 36)); // NOI18N
                        rbFV.setText("Firma/Verificaci\u00F3n");
                        ejecutar = new javax.swing.JButton();
                        ejecutar.setBounds(176, 222, 71, 21);
                        panel.add(ejecutar);
                        
                                ejecutar.setText("Ejecutar");
                                
                                JLabel lblNewLabel = new JLabel("New label");
                                lblNewLabel.setIcon(new ImageIcon("C:\\Users\\josei\\eclipse-workspace\\Practicafinal\\image\\ipnlog.jpg"));
                                lblNewLabel.setBounds(10, 10, 237, 233);
                                panel.add(lblNewLabel);
                                ejecutar.addActionListener(new java.awt.event.ActionListener() {
                                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                                        ejecutarActionPerformed(evt);
                                    }
                                });
                        rbFV.addActionListener(new java.awt.event.ActionListener() {
                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                rbFVActionPerformed(evt);
                            }
                        });
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbFVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbFVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbFVActionPerformed

    private void ejecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ejecutarActionPerformed
        // TODO add your handling code here:
        Main m= new Main();
        CifrarDescifrar cd = new CifrarDescifrar();
        FirmaVerificar fv= new FirmaVerificar();
        Todos T= new Todos();
        
        if(rbCD.isSelected() && rbFV.isSelected())
        {
            T.setVisible(true);
            dispose();
        }
        else if(rbFV.isSelected())
        {
            fv.setVisible(true);
            dispose();
        }
        else if(rbCD.isSelected())
        {
            cd.setVisible(true);
            dispose();
        }
        
        
    }//GEN-LAST:event_ejecutarActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton ejecutar;
    private javax.swing.JRadioButton rbCD;
    private javax.swing.JRadioButton rbFV;
}