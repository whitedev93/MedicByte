package ec.edu.espe.medicbyte.view;

import ec.edu.espe.medicbyte.model.Appointment;
import ec.edu.espe.medicbyte.model.Location;
import ec.edu.espe.medicbyte.model.Medic;
import java.awt.Color;
import java.awt.Component;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.function.Consumer;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import jiconfont.icons.font_awesome.FontAwesome;
import jiconfont.swing.IconFontSwing;

/**
 *
 * @author Andres Jonathan J.
 */
public class ApproveAppointmentDialog extends javax.swing.JDialog {
    public class MedicsListCellRenderer extends DefaultListCellRenderer {

        public Component getListCellRendererComponent(
                                       JList list,
                                       Object value,
                                       int index,
                                       boolean isSelected,
                                       boolean cellHasFocus) {
            if (value instanceof Medic) {
                value = ((Medic)value).getDisplayName();
            }
            
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            return this;
        }
    }
    
    public class LocationListCellRenderer extends DefaultListCellRenderer {

        public Component getListCellRendererComponent(
                                       JList list,
                                       Object value,
                                       int index,
                                       boolean isSelected,
                                       boolean cellHasFocus) {
            if (value instanceof Location) {
                value = ((Location)value).getName();
            }
            
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            return this;
        }
    }

    private JComboBox<Medic> cmbMedics = new JComboBox();
    private JComboBox<Location> cmbLocations = new JComboBox();
    private final Appointment appointment;
    private final List<Medic> medics;

    private final Consumer<ApproveContext> callback;
    public static class ApproveContext {
        public LocalDate date;
        public LocalTime hour;
        public Medic medic;
        public Location location;
    }
    
    /**
     * Creates new form ApproveAppointmentWindow
     */
    public ApproveAppointmentDialog(
        Appointment appointment,
        List<Medic> medics, List<Location> locations, Consumer<ApproveContext> callback) {
        initComponents();
        
        lblMedicError.setVisible(false);
        lblDateError.setVisible(false);
        lblHourError.setVisible(false);
        
        timepkrHour.getSettings().setFormatForDisplayTime("HH:mm");
        
        datepkrDate.getSettings().setFormatForDatesCommonEra("dd-MM-yyyy");
        datepkrDate.getSettings().setFormatForDatesBeforeCommonEra("dd-MM-yyyy");
        datepkrDate.getSettings()
            .setDateRangeLimits(LocalDate.now(), LocalDate.MAX);
        
        JButton datePickerButton = datepkrDate.getComponentToggleCalendarButton();
        datePickerButton.setIcon(IconFontSwing.buildIcon(FontAwesome.CALENDAR, 18, new Color(71, 71, 71)));
        
        this.appointment = appointment;
        this.medics = medics;
        this.callback = callback;
        
        cmbMedics.setRenderer(new MedicsListCellRenderer());
        cmbLocations.setRenderer(new LocationListCellRenderer());
        
        medics.forEach(medic -> cmbMedics.addItem(medic));
        locations.forEach(location -> cmbLocations.addItem(location));
        
        pnlCmbMedics.add(cmbMedics);
        pnlCmbLocations.add(cmbLocations);
        repaint();
        revalidate();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT
     * modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        datepkrDate = new com.github.lgooddatepicker.components.DatePicker();
        jLabel2 = new javax.swing.JLabel();
        lblDateError = new javax.swing.JLabel();
        lblMedicError = new javax.swing.JLabel();
        btnApprove = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        pnlCmbMedics = new javax.swing.JPanel();
        pnlCmbLocations = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        timepkrHour = new com.github.lgooddatepicker.components.TimePicker();
        lblHourError = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Date:");
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jLabel2.setText("Medic:");
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        lblDateError.setText("{{ error }}");
        lblDateError.setForeground(new java.awt.Color(255, 102, 102));

        lblMedicError.setText("{{ error }}");
        lblMedicError.setForeground(new java.awt.Color(255, 102, 102));

        btnApprove.setText("Approve");
        btnApprove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApproveActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        pnlCmbMedics.setMinimumSize(new java.awt.Dimension(100, 30));
        pnlCmbMedics.setPreferredSize(new java.awt.Dimension(100, 30));
        pnlCmbMedics.setLayout(new javax.swing.BoxLayout(pnlCmbMedics, javax.swing.BoxLayout.LINE_AXIS));

        pnlCmbLocations.setMinimumSize(new java.awt.Dimension(100, 30));
        pnlCmbLocations.setPreferredSize(new java.awt.Dimension(100, 30));
        pnlCmbLocations.setLayout(new javax.swing.BoxLayout(pnlCmbLocations, javax.swing.BoxLayout.LINE_AXIS));

        jLabel3.setText("Location:");
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Hour:");

        lblHourError.setForeground(new java.awt.Color(255, 102, 102));
        lblHourError.setText("{{ error }}");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlCmbLocations, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnApprove))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel1)
                                .addComponent(datepkrDate, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                                .addComponent(lblDateError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addComponent(pnlCmbMedics, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblMedicError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(timepkrHour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(lblHourError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(timepkrHour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblHourError)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(datepkrDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDateError)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlCmbMedics, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMedicError)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(pnlCmbLocations, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnApprove)
                    .addComponent(btnCancel))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 264, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 333, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnApproveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApproveActionPerformed
        ApproveContext context = new ApproveContext();
                
        if (timepkrHour.getText().trim().isEmpty()) {
            lblHourError.setText("this field is required");
            lblHourError.setVisible(true);
            return;
        }
        
        if (datepkrDate.getText().trim().isEmpty()) {
            lblDateError.setText("this field is required");
            lblDateError.setVisible(true);
            return;
        }
        
        context.hour = timepkrHour.getTime();
        context.date = datepkrDate.getDate();
        
        if (cmbMedics.getItemCount() == 0) {
            lblMedicError.setVisible(true);
            lblMedicError.setText("no medics available");
            return;
        }
        
        context.medic = (Medic) cmbMedics.getSelectedItem();
        context.location = (Location) cmbLocations.getSelectedItem();
        callback.accept(context);
        dispose();
    }//GEN-LAST:event_btnApproveActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApprove;
    private javax.swing.JButton btnCancel;
    private com.github.lgooddatepicker.components.DatePicker datepkrDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblDateError;
    private javax.swing.JLabel lblHourError;
    private javax.swing.JLabel lblMedicError;
    private javax.swing.JPanel pnlCmbLocations;
    private javax.swing.JPanel pnlCmbMedics;
    private com.github.lgooddatepicker.components.TimePicker timepkrHour;
    // End of variables declaration//GEN-END:variables
}