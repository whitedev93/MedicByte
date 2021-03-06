package ec.edu.espe.medicbyte.view;

import ec.edu.espe.medicbyte.model.Appointment;
import ec.edu.espe.medicbyte.model.Location;
import ec.edu.espe.medicbyte.model.Medic;
import ec.edu.espe.medicbyte.view.DlgApproveAppointment.ApproveContext;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Consumer;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import static javax.swing.JOptionPane.YES_NO_OPTION;

/**
 *
 * @author Andres Jonathan J.
 */
public class RequestedAppointmentItem extends javax.swing.JPanel {
    ResourceBundle lang = ResourceBundle.getBundle("ec/edu/espe/medicbyte/view/Bundle");
    private final Appointment appointment;
    private Consumer<ApproveContext> approveCallback;
    private Runnable rejectCallback;
    private final List<Medic> medics;
    private final List<Location> locations;

    /**
     * Creates new form RequestedAppointmentItem
     * 
     * @param appointment
     * @param medics
     * @param locations
     */
    public RequestedAppointmentItem(Appointment appointment, List<Medic> medics, List<Location> locations) {
        initComponents();
        this.appointment = appointment;
        
        lblPatientValue.setText(appointment.getPatient().getDisplayName());
        lblRequestedDateValue.setText(appointment.getDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        lblSpecialityValue.setText(appointment.getSpeciality().getName());
        this.medics = medics;
        this.locations = locations;
    }
    
    public void onApprove(Consumer<ApproveContext> callback) {
        approveCallback = callback;
    }
    
    public void onReject(Runnable callback) {
        rejectCallback = callback;
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT
     * modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        lblPatient = new javax.swing.JLabel();
        lblPatientValue = new javax.swing.JLabel();
        lblRequestedDate = new javax.swing.JLabel();
        lblRequestedDateValue = new javax.swing.JLabel();
        lblSpeciality = new javax.swing.JLabel();
        lblSpecialityValue = new javax.swing.JLabel();
        btnApprove = new javax.swing.JButton();
        btnReject = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(2147483647, 100));
        setLayout(new java.awt.BorderLayout());

        jPanel9.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jPanel9.setLayout(new java.awt.BorderLayout());

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(165, 177, 194)));

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("ec/edu/espe/medicbyte/view/Bundle"); // NOI18N
        lblPatient.setText(bundle.getString("RequestedAppointmentItem.lblPatient.text")); // NOI18N
        lblPatient.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        lblPatientValue.setText(bundle.getString("RequestedAppointmentItem.lblPatientValue.text")); // NOI18N

        lblRequestedDate.setText(bundle.getString("RequestedAppointmentItem.lblRequestedDate.text")); // NOI18N
        lblRequestedDate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        lblRequestedDateValue.setText(bundle.getString("RequestedAppointmentItem.lblRequestedDateValue.text")); // NOI18N

        lblSpeciality.setText(bundle.getString("RequestedAppointmentItem.lblSpeciality.text")); // NOI18N
        lblSpeciality.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        lblSpecialityValue.setText(bundle.getString("RequestedAppointmentItem.lblSpecialityValue.text")); // NOI18N

        btnApprove.setBackground(new java.awt.Color(33, 200, 112));
        btnApprove.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnApprove.setForeground(new java.awt.Color(255, 255, 255));
        btnApprove.setText(bundle.getString("RequestedAppointmentItem.btnApprove.text")); // NOI18N
        btnApprove.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 8, 4, 8));
        btnApprove.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnApprove.setFocusPainted(false);
        btnApprove.setFocusable(false);
        btnApprove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApproveActionPerformed(evt);
            }
        });

        btnReject.setBackground(new java.awt.Color(235, 59, 90));
        btnReject.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnReject.setForeground(new java.awt.Color(255, 255, 255));
        btnReject.setText(bundle.getString("RequestedAppointmentItem.btnReject.text")); // NOI18N
        btnReject.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 8, 4, 8));
        btnReject.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReject.setFocusPainted(false);
        btnReject.setFocusable(false);
        btnReject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRejectActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(lblSpeciality)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSpecialityValue)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 344, Short.MAX_VALUE)
                        .addComponent(btnReject)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnApprove))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(lblPatient)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblPatientValue))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(lblRequestedDate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblRequestedDateValue)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPatient)
                    .addComponent(lblPatientValue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRequestedDate)
                    .addComponent(lblRequestedDateValue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSpeciality)
                    .addComponent(lblSpecialityValue))
                .addContainerGap(16, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnApprove)
                    .addComponent(btnReject))
                .addContainerGap())
        );

        jPanel9.add(jPanel10, java.awt.BorderLayout.CENTER);

        add(jPanel9, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRejectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRejectActionPerformed
        int action = JOptionPane.showConfirmDialog(
            this.getRootPane(),
            lang.getString("ask_confirm_reject_appointment"),
            lang.getString("are_you_sure"),
            YES_NO_OPTION
        );
        
        if (action == 0) {
            rejectCallback.run();
        }
    }//GEN-LAST:event_btnRejectActionPerformed

    private void btnApproveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApproveActionPerformed
        DlgApproveAppointment dialog = new DlgApproveAppointment(appointment, medics, locations, (context) -> {
               approveCallback.accept(context);
        });
        
        //dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setTitle("Approve an appointment");
        dialog.setLocationRelativeTo(this.getParent());
        dialog.setModal(true);
        dialog.setVisible(true);
        dialog.pack();
    }//GEN-LAST:event_btnApproveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApprove;
    private javax.swing.JButton btnReject;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel lblPatient;
    private javax.swing.JLabel lblPatientValue;
    private javax.swing.JLabel lblRequestedDate;
    private javax.swing.JLabel lblRequestedDateValue;
    private javax.swing.JLabel lblSpeciality;
    private javax.swing.JLabel lblSpecialityValue;
    // End of variables declaration//GEN-END:variables
}
