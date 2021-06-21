package PatientClient;

import RMI_Interfaces.JaxbMarshaler;
import RMI_Interfaces.TakenInterface;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelPackage.Patient;
import userUI.ViewUser;
import userpackage.PatientWebService;
import userpackage.PatientWebService_Service;

public class ViewPatient extends javax.swing.JFrame {

    public String userId;
    public String patientId;
    public Patient patient;
    DefaultTableModel model;

    public ViewPatient(String userID, String patientId) {
        this.userId = userID;
        this.patientId = patientId;

        initComponents();
        this.setLocationRelativeTo(null);
        setVisible(true);
        model = (DefaultTableModel) takenMedicineTable.getModel();
        if (!this.loadPatient()) {
            JOptionPane.showMessageDialog(this, "No Patient Data Found!!");
            this.dispose();

        }
        this.loadPatientInterface();
        this.loadTakenMedicineInterface();

    }

    public boolean loadPatient() {
        PatientWebService_Service patientWebService_Service = new PatientWebService_Service();
        PatientWebService patientWebService = patientWebService_Service.getPatientWebServicePort();
        String val = patientWebService.viewPatient(this.patientId);

        JaxbMarshaler jM = new JaxbMarshaler();
        patient = (Patient) jM.stringToObject(val, Patient.class);
        return patient.getFirstName() != null;
    }

    public void loadPatientInterface() {
        this.patientIDLabel.setText(patient.getPatientID());
        this.fullNameLabel.setText(patient.getFirstName() + " " + patient.getMiddleName() + " " + patient.getLastName());
        if (patient.getGender().equals("M")) {
            this.genderLabel.setText("Male");
        } else {
            this.genderLabel.setText("Female");
        }
        this.ageLabel.setText(patient.getAge() + "");
        this.registeredByLabel.setText(patient.getRegisteredBy());
        this.activeLabel.setText(patient.isActive() + "");

    }

    private void loadTakenMedicineInterface() {
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        fullNameLabel = new javax.swing.JLabel();
        patientIDLabel = new javax.swing.JLabel();
        genderLabel = new javax.swing.JLabel();
        ageLabel = new javax.swing.JLabel();
        registeredByLabel = new javax.swing.JLabel();
        activeLabel = new javax.swing.JLabel();
        updatePatient = new javax.swing.JButton();
        disablePatient = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        takenMedicineTable = new javax.swing.JTable();
        updateTaken = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Patient ID");

        jLabel2.setText("Full Name");

        jLabel3.setText("Gender");

        jLabel4.setText("Age");

        jLabel5.setText("Registered By");

        jLabel6.setText("Active");

        fullNameLabel.setText("full name");

        patientIDLabel.setText("ID");

        genderLabel.setText("full name");

        ageLabel.setText("full name");

        registeredByLabel.setText("full name");
        registeredByLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registeredByLabelMouseClicked(evt);
            }
        });

        activeLabel.setText("full name");

        updatePatient.setText("Update");
        updatePatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatePatientActionPerformed(evt);
            }
        });

        disablePatient.setText("Disable");
        disablePatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disablePatientActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(genderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(fullNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(patientIDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(registeredByLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(updatePatient)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 116, Short.MAX_VALUE)
                                        .addComponent(activeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(disablePatient)
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(12, 12, 12)))
                .addGap(51, 51, 51))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(patientIDLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(fullNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(genderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(ageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(registeredByLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(activeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updatePatient)
                    .addComponent(disablePatient))
                .addGap(108, 108, 108))
        );

        takenMedicineTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Medicine", "Start Date (YYYY-MM-DD)", "End Date (YYYY-MM-DD)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(takenMedicineTable);
        if (takenMedicineTable.getColumnModel().getColumnCount() > 0) {
            takenMedicineTable.getColumnModel().getColumn(0).setMinWidth(200);
            takenMedicineTable.getColumnModel().getColumn(0).setPreferredWidth(200);
            takenMedicineTable.getColumnModel().getColumn(0).setMaxWidth(200);
        }

        updateTaken.setText("Update");
        updateTaken.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateTakenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(updateTaken)
                        .addGap(136, 136, 136))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(updateTaken))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void updateTakenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateTakenActionPerformed
        new UpdateTakenMedicine(this.patientId);
    }//GEN-LAST:event_updateTakenActionPerformed

    private void disablePatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disablePatientActionPerformed
        PatientWebService_Service patientWebService_Service = new PatientWebService_Service();
        PatientWebService patientWebService = patientWebService_Service.getPatientWebServicePort();
        String val = patientWebService.disablePatient(this.patientId);

        if (val.equals("true")) {
            JOptionPane.showMessageDialog(this, "Successfully Disabled!!");
            this.loadPatientInterface();
        } else {
            JOptionPane.showMessageDialog(this, "Unexpected Error Occured!!");
        }

    }//GEN-LAST:event_disablePatientActionPerformed

    private void updatePatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatePatientActionPerformed
        new UpdatePatientInformation(this.userId, this.patientId);
    }//GEN-LAST:event_updatePatientActionPerformed

    private void registeredByLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registeredByLabelMouseClicked
        new ViewUser(patient.getRegisteredBy());
    }//GEN-LAST:event_registeredByLabelMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel activeLabel;
    private javax.swing.JLabel ageLabel;
    private javax.swing.JButton disablePatient;
    private javax.swing.JLabel fullNameLabel;
    private javax.swing.JLabel genderLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel patientIDLabel;
    private javax.swing.JLabel registeredByLabel;
    private javax.swing.JTable takenMedicineTable;
    private javax.swing.JButton updatePatient;
    private javax.swing.JButton updateTaken;
    // End of variables declaration//GEN-END:variables

}
