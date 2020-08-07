package ec.edu.espe.medicbyte.view;

import com.google.common.io.BaseEncoding;
import ec.edu.espe.medicbyte.common.core.View;
import ec.edu.espe.medicbyte.model.Speciality;
import ec.edu.espe.medicbyte.util.StringUtils;
import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

/**
 *
 * @author Andres Jonathan J.
 */
public class FrmAddMedic extends View {
    public static enum MessageStatus { SUCCESS, ERROR }
    public static enum Field { USERNAME, PASSWORD, FULLNAME, EMAIL, SPECIALITY }
    
    private static class FieldValidationStatus {
        private final String message;
        private final Field field;
        private final boolean valid;
        
        public FieldValidationStatus(Field field, boolean valid, String message) {
            this.field = field;
            this.valid = valid;
            this.message = message;
        }
        
        public Field getField() { return field; }
        public boolean isValid() { return valid; }
        public String getMessage() { return message; }
    }
    
    private List<Speciality> specialities;

    /**
     * Creates new form FrmAddMedic
     */
    public FrmAddMedic() {
        initComponents();
        setupComponents();
    }
    
    private void setupComponents() {
        lblStatusMessage.setVisible(false);
        txtPassword.setEchoChar('\u25CF');
        
        // hide errors
        Stream.of(pnlForm.getComponents()).forEach(component -> {
            if (component.getName() != null && component.getName().trim().startsWith("error:")) {
                component.setVisible(false);
            }
        });
        
        listen("submitComplete", (args) -> {
            MessageStatus status = args.get(0);
            String message = args.get(1);
            
            btnRegisterMedic.setEnabled(true);
            lblStatusMessage.setVisible(true);
            lblStatusMessage.setText(message);
            
            resetForm();

            switch (status) {
                case SUCCESS:
                    lblStatusMessage.setBackground(new Color(152, 250, 224));
                    lblStatusMessage.setForeground(new Color(13, 166, 127));
                break;
                case ERROR:
                    lblStatusMessage.setBackground(new Color(255, 161, 161));
                    lblStatusMessage.setForeground(new Color(227, 59, 60));
                break;
            }

            repaint();
        });
    }
    
    @Override
    protected void onChange(String name, Object oldValue, Object newValue) {
        if (name.equals("specialities")) {
            specialities = (List<Speciality>) newValue;
            cmbSpeciality.removeAllItems();
            specialities.forEach(speciality -> cmbSpeciality.addItem(speciality.getName()));
        }
        
        repaint();
        revalidate();
    }

    @Override
    protected void onLeave() {
        lblStatusMessage.setVisible(false);
        resetForm();
    }

    @Override
    protected void onEnter() {}

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT
     * modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        pnlForm = new javax.swing.JPanel();
        lblStatusMessage = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmbSpeciality = new javax.swing.JComboBox<>();
        btnRegisterMedic = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txaDescription1 = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        txtFullName = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        lblGeneratePassword = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblRevealPassword = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setLayout(new java.awt.GridBagLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 10, 0));
        jPanel2.setOpaque(false);
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.Y_AXIS));

        jLabel1.setText("Add new medic");
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        jPanel2.add(jLabel1);
        jPanel2.add(jSeparator2);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 294;
        gridBagConstraints.ipady = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 0, 0);
        add(jPanel2, gridBagConstraints);

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.Y_AXIS));

        pnlForm.setOpaque(false);

        lblStatusMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStatusMessage.setOpaque(true);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Specialty:");
        jLabel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 0, 0, 0));

        cmbSpeciality.setToolTipText("");
        cmbSpeciality.setName("SPECIALITY"); // NOI18N
        cmbSpeciality.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSpecialityActionPerformed(evt);
            }
        });

        btnRegisterMedic.setText("Register medic");
        btnRegisterMedic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterMedicActionPerformed(evt);
            }
        });

        txaDescription1.setColumns(20);
        txaDescription1.setRows(5);
        jScrollPane2.setViewportView(txaDescription1);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Username:");
        jLabel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 0, 0, 0));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Full name:");
        jLabel6.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 0, 0, 0));

        txtUsername.setName("USERNAME"); // NOI18N
        txtUsername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFieldKeyReleased(evt);
            }
        });

        txtFullName.setName("FULLNAME"); // NOI18N
        txtFullName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFieldKeyReleased(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Email:");
        jLabel7.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 0, 0, 0));

        txtEmail.setName("EMAIL"); // NOI18N
        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFieldKeyReleased(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Password:");
        jLabel8.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 0, 0, 0));

        lblGeneratePassword.setForeground(new java.awt.Color(51, 153, 255));
        lblGeneratePassword.setText("Generate random password");
        lblGeneratePassword.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblGeneratePassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblGeneratePasswordMouseClicked(evt);
            }
        });

        txtPassword.setName("PASSWORD"); // NOI18N
        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFieldKeyReleased(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(255, 102, 102));
        jLabel3.setText("{{ error_username }}");
        jLabel3.setName("error:username"); // NOI18N

        jLabel4.setForeground(new java.awt.Color(255, 102, 102));
        jLabel4.setText("{{ error_fullname }}");
        jLabel4.setName("error:fullname"); // NOI18N

        jLabel10.setForeground(new java.awt.Color(255, 102, 102));
        jLabel10.setText("{{ error_email }}");
        jLabel10.setName("error:email"); // NOI18N

        jLabel11.setForeground(new java.awt.Color(255, 102, 102));
        jLabel11.setText("{{ error_password }}");
        jLabel11.setName("error:password"); // NOI18N

        lblRevealPassword.setForeground(new java.awt.Color(51, 153, 255));
        lblRevealPassword.setText("Reveal");
        lblRevealPassword.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblRevealPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRevealPasswordMouseClicked(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout pnlFormLayout = new javax.swing.GroupLayout(pnlForm);
        pnlForm.setLayout(pnlFormLayout);
        pnlFormLayout.setHorizontalGroup(
            pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblStatusMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlFormLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPassword)
                    .addGroup(pnlFormLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblRevealPassword)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblGeneratePassword))
                    .addGroup(pnlFormLayout.createSequentialGroup()
                        .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbSpeciality, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRegisterMedic, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUsername, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFullName, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlFormLayout.setVerticalGroup(
            pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFormLayout.createSequentialGroup()
                .addComponent(lblStatusMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFullName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlFormLayout.createSequentialGroup()
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(lblGeneratePassword)
                            .addComponent(lblRevealPassword)))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbSpeciality, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btnRegisterMedic)
                .addGap(18, 18, 18))
        );

        jPanel1.add(pnlForm);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(jPanel1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegisterMedicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterMedicActionPerformed
        Speciality speciality = specialities.stream().filter(s -> {
            return s.getName().equals((String) cmbSpeciality.getSelectedItem());
        }).map(s -> {
            for (Speciality item : specialities) {
                if (item.getName().equals(s.getName())) {
                    return item;
                }
            }
            
            return null;
        }).findFirst().orElse(null);
        
        String username = txtUsername.getText();
        String fullName = txtFullName.getText();
        String email = txtEmail.getText();
        char password[] = txtPassword.getPassword();
        
        List<FieldValidationStatus> statuses = new ArrayList<>();
        List<String> fieldConstants = Stream.of(Field.values())
            .map(f -> f.name())
            .collect(Collectors.toList());
        
        Stream.of(pnlForm.getComponents()).forEach(c -> {
            if (c.getName() == null || !fieldConstants.contains(c.getName())) return;
            FieldValidationStatus status = validateField(Field.valueOf(c.getName()), c);
            statuses.add(status);
        });
        
        statuses.forEach(status -> showFieldErrorStatus(status));
        boolean hasErrors = statuses.stream().anyMatch(status -> !status.valid);
        
        if (hasErrors) {
            return;
        }
        
        btnRegisterMedic.setEnabled(false);
        emit("submit", username, fullName, email, password, speciality);
    }//GEN-LAST:event_btnRegisterMedicActionPerformed

    private void txtFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFieldKeyReleased
        Component component = evt.getComponent();
        Field field;
        
        if (component.getName() == null) {
            return;
        }
        
        field = Field.valueOf(component.getName());
        
        if (field == null) {
            return;
        }
        
        FieldValidationStatus status = validateField(field, component);
        showFieldErrorStatus(status);
    }//GEN-LAST:event_txtFieldKeyReleased

    private void cmbSpecialityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSpecialityActionPerformed
        FieldValidationStatus status = validateField(Field.SPECIALITY, cmbSpeciality);
        showFieldErrorStatus(status);
    }//GEN-LAST:event_cmbSpecialityActionPerformed

    private void lblRevealPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRevealPasswordMouseClicked
        char mask = txtPassword.getEchoChar();
        
        if (mask == '\0') {
            txtPassword.setEchoChar('\u25CF');
        } else {
            txtPassword.setEchoChar('\0');
        }
    }//GEN-LAST:event_lblRevealPasswordMouseClicked

    private void lblGeneratePasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGeneratePasswordMouseClicked
        final byte[] buffer = new byte[5];
        Random random = new Random();
        
        random.nextBytes(buffer);
        String password = BaseEncoding.base64Url().omitPadding().encode(buffer);
        
        txtPassword.setText(password);
    }//GEN-LAST:event_lblGeneratePasswordMouseClicked
    
    private void showFieldErrorStatus(FieldValidationStatus status) {
        Component target = Stream.of(pnlForm.getComponents()).filter(component -> {
            // error:FIELD
            return component.getName() != null
                && component.getName().startsWith("error:")
                && component.getName().substring(6).equalsIgnoreCase(status.field.name());
        }).findFirst().orElse(null);
        
        if (target == null) {
            return;
        }
        
        JLabel errorLabel = (JLabel)target;
        
        if (status.isValid()) {
            errorLabel.setVisible(false);
            return;
        }
        
        errorLabel.setVisible(true);
        errorLabel.setText(status.getMessage());
    }
    
    private FieldValidationStatus validateField(Field field, Component component) {
        if (component instanceof JTextComponent
            && ((JTextComponent)component).getText().trim().isEmpty()) {
            return new FieldValidationStatus(field, false, "this field is required");
        }
        
        switch (field) {
            case USERNAME: {
               String value = ((JTextField)component).getText();
               
                if(value.length() < 3 || value.length() > 24) {
                    return new FieldValidationStatus(field, false, "Username must be between 3 and 24 characters");
                } else if (!value.matches("^[a-zA-Z0-9\\-\\_\\.]+$")) {
                    return new FieldValidationStatus(field, false, "Username can only have letters, numbers, hyphens or dots");
                }
            } break;
            case FULLNAME:
                if(((JTextField)component).getText().length() < 2) {
                    return new FieldValidationStatus(field, false, "Full name must have at least 2 characters");
                }
            break;
            case EMAIL: {
                String value = ((JTextField)component).getText();
                
                if (!StringUtils.isValidEmail(value)) {
                    return new FieldValidationStatus(field, false, "Incorrect email");
                }
            } break;
            case PASSWORD: {
                char[] value = ((JPasswordField)component).getPassword();
                
                if(value.length < 4) {
                    return new FieldValidationStatus(field, false, "The password must have at least 4 characters");
                }
            } break;
        }
        
        return new FieldValidationStatus(field, true, "done");
    }
    
    private void resetForm() {
        btnRegisterMedic.setEnabled(true);
        Stream.of(pnlForm.getComponents())
            .filter(c -> c.getName() != null && c.getName().startsWith("error:"))
            .forEach(c -> c.setVisible(false));

        Stream.of(pnlForm.getComponents())
            .filter(c -> c instanceof JTextComponent)
            .map(c -> (JTextComponent) c)
            .forEach(c -> c.setText(""));

        cmbSpeciality.setSelectedIndex(0);
        txtPassword.setEchoChar('\u25CF');
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegisterMedic;
    private javax.swing.JComboBox<String> cmbSpeciality;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblGeneratePassword;
    private javax.swing.JLabel lblRevealPassword;
    private javax.swing.JLabel lblStatusMessage;
    private javax.swing.JPanel pnlForm;
    private javax.swing.JTextArea txaDescription1;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFullName;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables

}
