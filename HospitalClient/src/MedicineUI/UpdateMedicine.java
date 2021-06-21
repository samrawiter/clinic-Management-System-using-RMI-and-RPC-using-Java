/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MedicineUI;

import RMI_Interfaces.JaxbMarshaler;
import RMI_Interfaces.MedicineInterface;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.Date;
import javax.swing.JOptionPane;
import modelPackage.Medicine;

public class UpdateMedicine extends javax.swing.JFrame {

    String medicineName;
    Medicine medicine;

    public UpdateMedicine(String medicineName) {
        this.medicineName = medicineName;
        initComponents();
        this.setLocationRelativeTo(null);
        setVisible(true);
        if (!this.loadMedicineInterface()) {
            JOptionPane.showMessageDialog(this, "No User Data Found!!");
            this.dispose();

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel12 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        insertMedicineButton = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        medicineManufacturedBy = new javax.swing.JTextField();
        manufacturedDate = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel23.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel23.setText("          Update Medicine Information");

        jLabel25.setText("Manufactured By");

        insertMedicineButton.setText("Update");
        insertMedicineButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertMedicineButtonActionPerformed(evt);
            }
        });

        jLabel27.setText("Manufactured Date");

        manufacturedDate.setText("      ");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(medicineManufacturedBy, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                            .addComponent(manufacturedDate)))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(178, 178, 178)
                        .addComponent(insertMedicineButton)))
                .addContainerGap(129, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(medicineManufacturedBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(manufacturedDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27))
                .addGap(28, 28, 28)
                .addComponent(insertMedicineButton)
                .addContainerGap(143, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 9, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void insertMedicineButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertMedicineButtonActionPerformed
        try {

            Registry reg = LocateRegistry.getRegistry("169.254.5.2", 5050);

            MedicineInterface i = (MedicineInterface) reg.lookup("medicine");
            Date date;
            date = Date.valueOf(manufacturedDate.getText());
            String status = i.updateMedicine(this.medicineName, medicineManufacturedBy.getText(), date);

            if (status.equals("true")) {
                JOptionPane.showMessageDialog(this, "Successfully Updated!!");
            } else {
                JOptionPane.showMessageDialog(this, "Unexpected Error Occured!!");
            }
        } catch (NotBoundException | RemoteException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_insertMedicineButtonActionPerformed

    private boolean loadMedicineInterface() {
        try {

            Registry reg = LocateRegistry.getRegistry("169.254.5.2", 5050);

            MedicineInterface i = (MedicineInterface) reg.lookup("medicine");
            String val = i.viewMedicine(this.medicineName);
            JaxbMarshaler jM = new JaxbMarshaler();
            medicine = (Medicine) jM.stringToObject(val, Medicine.class);
            jLabel23.setText("Update " + medicine.getName() + " Information");
            medicineManufacturedBy.setText(medicine.getManufacturedCountry());
            manufacturedDate.setText(medicine.getManufacturedDate().toString());
        } catch (NotBoundException | RemoteException ex) {
            ex.printStackTrace();
        }
        return medicine.getName() != null;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton insertMedicineButton;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JTextField manufacturedDate;
    private javax.swing.JTextField medicineManufacturedBy;
    // End of variables declaration//GEN-END:variables

}
