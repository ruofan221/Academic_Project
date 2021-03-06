/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.dior.CSR;

import Business.Customer.CustomerDirectory;
import Business.Enterprise.BeautyEnterprise;
import Business.Enterprise.Enterprise;
import Business.Organization.CSROrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author too
 */
public class CSRWorkArea extends javax.swing.JPanel {
    private JPanel userProcessContainer;
    private UserAccount account;
    private CSROrganization csrOrganization;
    private BeautyEnterprise benterprise;
    /**
     * Creates new form CRSWorkarea
     */
    public CSRWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.csrOrganization = (CSROrganization)organization;
        this.benterprise =(BeautyEnterprise) enterprise;
    }

   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnPurchase = new javax.swing.JButton();
        btnOrderList = new javax.swing.JButton();

        jLabel1.setText("Welcome to CRS Workarea");

        btnPurchase.setText("Customer Info");
        btnPurchase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPurchaseActionPerformed(evt);
            }
        });

        btnOrderList.setText("Order List");
        btnOrderList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrderListActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(197, 197, 197)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnOrderList, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnPurchase, javax.swing.GroupLayout.Alignment.LEADING))))
                .addGap(0, 200, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addGap(97, 97, 97)
                .addComponent(btnPurchase)
                .addGap(18, 18, 18)
                .addComponent(btnOrderList)
                .addContainerGap(156, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnPurchaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPurchaseActionPerformed
        // TODO add your handling code here:
        
        Purchase p = new Purchase(userProcessContainer,account,benterprise,csrOrganization);
        userProcessContainer.add("p",p);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnPurchaseActionPerformed

    private void btnOrderListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrderListActionPerformed
        // TODO add your handling code here:
        CustomerDirectory customerDir =  benterprise.getCustomerDir();
        OrderList ol = new OrderList(userProcessContainer,account,benterprise,csrOrganization,customerDir);
        userProcessContainer.add("AdminWordAreaJPanel",ol);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnOrderListActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOrderList;
    private javax.swing.JButton btnPurchase;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
