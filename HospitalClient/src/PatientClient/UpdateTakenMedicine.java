/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientClient;

import RMI_Interfaces.TakenInterface;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.Date;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class UpdateTakenMedicine extends javax.swing.JFrame {

    String patientId;
    DefaultTableModel model;

    public UpdateTakenMedicine(String patientID) {
        this.patientId = patientID;
        initComponents();
        model = (DefaultTableModel) takenMedicineTable.getModel();

        this.setLocationRelativeTo(null);
        setVisible(true);
        this.loadTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        takenMedicineTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        addMedicine = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        takenMedicineTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Medicine", "Start Date (YYYY-MM-DD)", "End Date (YYYY-MM-DD)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(takenMedicineTable);

        jButton1.setText("update");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        addMedicine.setText("Add Medicine");
        addMedicine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMedicineActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jButton1)
                        .addGap(52, 52, 52)
                        .addComponent(addMedicine, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(addMedicine))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addMedicineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMedicineActionPerformed
        model.setRowCount(model.getRowCount() + 1);
    }//GEN-LAST:event_addMedicineActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.insertData();
        JOptionPane.showMessageDialog(this, "Successfully Updated!!");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void loadTable() {

        try {

            Registry reg = LocateRegistry.getRegistry("169.254.5.2", 5050);
            TakenInterface i = (TakenInterface) reg.lookup("taken");
            String val = i.viewTaken(this.patientId);
            Gson gson = new Gson();
            ArrayList<modelPackage.Taken> takenList
                    = gson.fromJson(val, new TypeToken<ArrayList<modelPackage.Taken>>() {
                    }.getType());

            for (modelPackage.Taken taken : takenList) {
                model.addRow(new Object[]{taken.getMedicineName(), taken.getStartDate(), taken.getEndDate()});

            }

        } catch (NotBoundException | RemoteException ex) {
            ex.printStackTrace();
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addMedicine;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable takenMedicineTable;
    // End of variables declaration//GEN-END:variables

    private void insertData() {
        Registry reg;
        TakenInterface takenInterface;
        try {
            reg = LocateRegistry.getRegistry("169.254.5.2", 5050);

            takenInterface = (TakenInterface) reg.lookup("taken");

            for (int i = 0; i < model.getRowCount(); i++) {
                String medicineName = (String) model.getValueAt(i, 0);
                Date startDate = Date.valueOf(model.getValueAt(i, 1).toString());
                Date endDate = Date.valueOf((String) model.getValueAt(i, 2).toString());
                takenInterface.deleteTaken(medicineName, this.patientId, startDate, endDate);
                String val = takenInterface.addTaken(medicineName, this.patientId, startDate, endDate);
            }
        } catch (RemoteException | NotBoundException ex) {
            Logger.getLogger(UpdateTakenMedicine.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
