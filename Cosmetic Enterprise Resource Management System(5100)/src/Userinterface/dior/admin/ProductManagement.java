/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Userinterface.dior.admin;

import Business.EcoSystem;
import Business.Enterprise.BeautyEnterprise;
import Business.Enterprise.Enterprise;
import Business.Enterprise.SupplierEnterprise;
import Business.Network.Network;
import Business.Organization.DiorAdminOrganization;
import Business.Organization.Organization;
import Business.Product.Product;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.ProductRequest;
import Business.WorkQueue.ProductUpdateRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author too
 */
public class ProductManagement extends javax.swing.JPanel {

    /**
     * Creates new form OrderJPanel
     */
    private JPanel userProcessContainer;
    private BeautyEnterprise beautyenterprise;
    private SupplierEnterprise supplierenterprise;
    private UserAccount account;
    private DiorAdminOrganization organization;
    private EcoSystem business;
    private Network network;
    
    public ProductManagement(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        beautyenterprise = (BeautyEnterprise)enterprise;
//        supplierenterprise = (SupplierEnterprise)enterprise;
        
        this.account = account;
        this.business = business;
        this.organization = (DiorAdminOrganization)organization;
         network = searchNetwork();
       
        populateProductTable();
        populateRequestTable();
        populateRequestfromSupplierTable();
        populatComboBox();
    }
    
    public Network searchNetwork(){
            for(Network network: business.getNetworkList()){
                if(network.getEnterpriseDirectory().getEnterpriseList().contains(beautyenterprise))
                    return network;
        }
            return null;
        }
    
   
    
    public void populateRequestfromSupplierTable(){
        DefaultTableModel model = (DefaultTableModel) RequestfromSupplierTable.getModel();
        model.setRowCount(0);
                for(WorkRequest request: beautyenterprise.getWorkQueue().getWorkRequestList()){
                    if(request instanceof ProductRequest){
                        System.out.println(((ProductRequest)request).getProductid());
                        Object[] row = new Object[4];
                        row[0] = ((ProductRequest)request).getName();
                        row[1] = ((ProductRequest)request).getQuality();
                        row[2] = ((ProductRequest)request).getSupplierenterpirsename() == null ? null : ((ProductRequest)request).getSupplierenterpirsename();
                        row[3] = request.getStatus();
                        model.addRow(row);
                    }
                }   
            }   


    
    public void populateProductTable(){
        DefaultTableModel model = (DefaultTableModel) ProductTable.getModel();
        
        model.setRowCount(0);
        for (Product p : beautyenterprise.getProductDir().getProductList()){
            Object[] row = new Object[5];
            row[0] = p.getProductName();
            row[1] = p.getProductId();
            row[2] = p.getAvailNum();
            row[3] = p.getPurchasingPrice();
            row[4] = p.getSalesPrice();
            
            model.addRow(row);
            
        }
    }
    
    public void populatComboBox(){
       // typeComboBox.removeAllItems();
        ComboBox.removeAllItems();   
        for(Enterprise e: network.getEnterpriseDirectory().getEnterpriseList()){
            if(e instanceof SupplierEnterprise){
                
                ComboBox.addItem(e.getName());
            }
        }
    }
    
    public void populateRequestTable(){
        DefaultTableModel model = (DefaultTableModel) PUrequestTable.getModel();
        
        model.setRowCount(0);
        
        for (WorkRequest request : organization.getWorkQueue().getWorkRequestList()){
           if(request instanceof ProductUpdateRequest){
            Object[] row = new Object[8];
            row[0] = ((ProductUpdateRequest)request).getName();
            row[1] = ((ProductUpdateRequest)request).getProductid();
            row[2] = ((ProductUpdateRequest)request).getAvailnum();
            row[3] = ((ProductUpdateRequest)request).getSaleprice();
            row[4] = ((ProductUpdateRequest)request).getPurchasingprice();  
            row[5] = request.getSender().getEmployee().getName();
            row[6] = request;
            row[7] = request.getStatus();
            model.addRow(row);
           }
        }
    };

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
        ProductTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btnRefresh = new javax.swing.JButton();
        btnAgree = new javax.swing.JButton();
        btnDisagree = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        PUrequestTable = new javax.swing.JTable();
        btnUpdate = new javax.swing.JButton();
        txtId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        RequestfromSupplierTable = new javax.swing.JTable();
        ComboBox = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        txtQuatity = new javax.swing.JTextField();

        jLabel1.setText("Product Update Request:");

        ProductTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Name", "ProductId", "AvailNum", "Purchasing Price", "Sale Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(ProductTable);
        if (ProductTable.getColumnModel().getColumnCount() > 0) {
            ProductTable.getColumnModel().getColumn(0).setResizable(false);
            ProductTable.getColumnModel().getColumn(1).setResizable(false);
            ProductTable.getColumnModel().getColumn(2).setResizable(false);
            ProductTable.getColumnModel().getColumn(3).setResizable(false);
            ProductTable.getColumnModel().getColumn(4).setResizable(false);
            ProductTable.getColumnModel().getColumn(4).setHeaderValue("Sale Price");
        }

        jLabel2.setText("Product List:");

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        btnAgree.setText("Processed");
        btnAgree.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgreeActionPerformed(evt);
            }
        });

        btnDisagree.setText("Disagreee");
        btnDisagree.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDisagreeActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        PUrequestTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Name", "ProductId", "AvailNum", "Sale Price", "Purchasing Price", "Sender", "Message", "Statues"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(PUrequestTable);
        if (PUrequestTable.getColumnModel().getColumnCount() > 0) {
            PUrequestTable.getColumnModel().getColumn(0).setResizable(false);
            PUrequestTable.getColumnModel().getColumn(1).setResizable(false);
            PUrequestTable.getColumnModel().getColumn(2).setResizable(false);
            PUrequestTable.getColumnModel().getColumn(3).setResizable(false);
            PUrequestTable.getColumnModel().getColumn(4).setResizable(false);
            PUrequestTable.getColumnModel().getColumn(5).setResizable(false);
            PUrequestTable.getColumnModel().getColumn(6).setResizable(false);
            PUrequestTable.getColumnModel().getColumn(7).setResizable(false);
        }

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });

        jLabel3.setText("ID:");

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Request Product From");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        RequestfromSupplierTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Name", "Quitity", "Satus", "Supplier"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(RequestfromSupplierTable);
        if (RequestfromSupplierTable.getColumnModel().getColumnCount() > 0) {
            RequestfromSupplierTable.getColumnModel().getColumn(0).setResizable(false);
            RequestfromSupplierTable.getColumnModel().getColumn(1).setResizable(false);
            RequestfromSupplierTable.getColumnModel().getColumn(2).setResizable(false);
            RequestfromSupplierTable.getColumnModel().getColumn(3).setResizable(false);
        }

        ComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("Quaitity:");

        txtQuatity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQuatityActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(txtQuatity, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDisagree)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAgree)))
                .addGap(98, 98, 98))
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(btnBack)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnUpdate)
                .addGap(41, 41, 41))
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRefresh)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(12, 12, 12)
                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(102, 102, 102))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDisagree)
                    .addComponent(btnAgree)
                    .addComponent(jButton2)
                    .addComponent(ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtQuatity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1)
                            .addComponent(btnRefresh))
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(btnDelete)
                    .addComponent(btnUpdate))
                .addContainerGap(10, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        
        int row = ProductTable.getSelectedRow();
        if(row<0){
            JOptionPane.showMessageDialog(null, "Please select a row from the table first", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Product product = (Product)ProductTable.getValueAt(row, 0);
        ProductInfoUpdate piu = new ProductInfoUpdate(userProcessContainer,product);
        userProcessContainer.add("createproduct",piu);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int row = ProductTable.getSelectedRow();
        if(row<0){
            JOptionPane.showMessageDialog(null, "Please select a row from the table first", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        } 
        int selectionButton = JOptionPane.YES_NO_OPTION;
        int selectionResult = JOptionPane.showConfirmDialog(null, "Are you sure to delete??","Warning",selectionButton);
        if(selectionResult == JOptionPane.YES_OPTION){
        Product product = (Product)ProductTable.getValueAt(row, 0);
        beautyenterprise.getProductDir().removeProduct(product);
        populateProductTable();
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int search = Integer.parseInt(txtId.getText());
        for(Product p : beautyenterprise.getProductDir().getProductList()){
            if(p.getProductId() == search){
               DefaultTableModel model = (DefaultTableModel) ProductTable.getModel();
                model.setRowCount(0);
                 Object[] row = new Object[5];
                 row[0] = p;
            row[1] = p.getProductId();
            row[2] = p.getAvailNum();
            row[3] = p.getPurchasingPrice();
            row[4] = p.getSalesPrice();
            model.addRow(row);
            }
            
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        populateProductTable();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnAgreeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgreeActionPerformed
        // TODO add your handling code here:
        int row = PUrequestTable.getSelectedRow();
        if(row<0){
            JOptionPane.showMessageDialog(null, "Please select a row from the table first", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        } 
        
        ProductUpdateRequest r = (ProductUpdateRequest)PUrequestTable.getValueAt(row, 6);
        int Id = r.getProductid();
        for(Product product:beautyenterprise.getProductDir().getProductList()){
            if(product.getProductId() == Id){
                product.setProductName(r.getName());
                product.setPurchasingPrice(r.getPurchasingprice());
                product.setSalesPrice(r.getSaleprice());
                product.setAvailNum(r.getAvailnum());
            }
        }
        r.setStatus("Agreed");
        r.setReceiver(account);
        populateRequestTable();
        
    }//GEN-LAST:event_btnAgreeActionPerformed

    private void btnDisagreeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDisagreeActionPerformed
        // TODO add your handling code here:
        int row = PUrequestTable.getSelectedRow();
        if(row<0){
            JOptionPane.showMessageDialog(null, "Please select a row from the table first", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        } 
        
        ProductUpdateRequest r = (ProductUpdateRequest)PUrequestTable.getValueAt(row, 6);
        r.setStatus("Disagreed");
        r.setReceiver(account);
        populateRequestTable();
    }//GEN-LAST:event_btnDisagreeActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int row = PUrequestTable.getSelectedRow();
        if(row<0){
            JOptionPane.showMessageDialog(null, "Please select a row from the table first", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }else if(txtQuatity.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Quatity cannotbe empty");
            return;
        }
        
        ProductUpdateRequest r = (ProductUpdateRequest)PUrequestTable.getValueAt(row, 6);
         String productname = r.getName();
            for(Product product:beautyenterprise.getProductDir().getProductList()){
            if(product.getProductName().equals(productname)){
                product.setProductName(r.getName());
                product.setPurchasingPrice(r.getPurchasingprice());
                product.setSalesPrice(r.getSaleprice());
                product.setAvailNum(Integer.parseInt(txtQuatity.getText()));
            }
        }
        
        ProductRequest request = new ProductRequest(); 
        request.setProductid(r.getProductid());
        request.setName(r.getName());
        request.setQuality(Integer.parseInt(txtQuatity.getText()));
        request.setStatus("Pending");
        request.setBeautyenterprisename(beautyenterprise.getName());
        String suppliername = String.valueOf(ComboBox.getSelectedItem());
        
        Network network = business.getNetworkList().get(0);
        SupplierEnterprise supplierenterprise = null;
        for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()){
            if (enterprise instanceof SupplierEnterprise && enterprise.getName().equals(suppliername)){   
                supplierenterprise = (SupplierEnterprise)enterprise;
                supplierenterprise.getWorkQueue().getWorkRequestList().add(request);
                
            }
        }
        
        if (supplierenterprise!=null){
            
//            supplierenterprise.getWorkQueue().getWorkRequestList().add(request);  
            beautyenterprise.getWorkQueue().getWorkRequestList().add(request);
        }
        populateRequestfromSupplierTable();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtQuatityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQuatityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQuatityActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox ComboBox;
    private javax.swing.JTable PUrequestTable;
    private javax.swing.JTable ProductTable;
    private javax.swing.JTable RequestfromSupplierTable;
    private javax.swing.JButton btnAgree;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDisagree;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtQuatity;
    // End of variables declaration//GEN-END:variables
}
