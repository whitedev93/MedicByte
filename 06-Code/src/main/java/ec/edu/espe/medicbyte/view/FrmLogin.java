package ec.edu.espe.medicbyte.view;

import ec.edu.espe.medicbyte.common.core.View;
import java.awt.Color;

/**
 *
 * @author Junior Jurado
 */
public class FrmLogin extends View {

    /**
     * Creates new form FrmLogin
     */
    public FrmLogin() {
        initComponents();
        hideError();
         
        listen("onSubmitError", (args) -> {
            showError(args.get(0));
            repaint();
        });
        
        listen("setEnabledBtnLogin", (args) -> {
            btnLogin.setEnabled(args.get(0));
        });
    }
    
    private void showError(String error) {
        //scrErrors.setVisible(true);
        scrErrors.getViewport().setBackground(new Color(255,219,219));
        txaErrors.setText(error);
        repaint();
    }
    
    private void hideError() {
        //scrErrors.setVisible(false);
        scrErrors.getViewport().setBackground(new Color(255,255,255));
        txaErrors.setText("");
        repaint();
    }

    @Override
    protected void onChange(String name, Object oldValue, Object newValue) {}
    
    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT
     * modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        btnLogin = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnCreateAccount = new javax.swing.JButton();
        scrErrors = new javax.swing.JScrollPane();
        txaErrors = new javax.swing.JTextArea();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(103, 103, 103));
        jLabel1.setText("Log in");

        jLabel2.setForeground(new java.awt.Color(99, 99, 99));
        jLabel2.setText("Username or email:");

        jLabel3.setForeground(new java.awt.Color(99, 99, 99));
        jLabel3.setText("Password:");

        btnLogin.setBackground(new java.awt.Color(71, 170, 226));
        btnLogin.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("Log in");
        btnLogin.setBorder(javax.swing.BorderFactory.createEmptyBorder(7, 1, 7, 1));
        btnLogin.setBorderPainted(false);
        btnLogin.setContentAreaFilled(false);
        btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogin.setFocusPainted(false);
        btnLogin.setOpaque(true);
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        jLabel4.setText("- OR -");

        btnCreateAccount.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnCreateAccount.setForeground(new java.awt.Color(54, 138, 185));
        btnCreateAccount.setText("Create an account");
        btnCreateAccount.setBorderPainted(false);
        btnCreateAccount.setContentAreaFilled(false);
        btnCreateAccount.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        scrErrors.setBorder(null);

        txaErrors.setBackground(new java.awt.Color(255, 219, 219));
        txaErrors.setColumns(20);
        txaErrors.setForeground(new java.awt.Color(204, 0, 0));
        txaErrors.setRows(5);
        txaErrors.setOpaque(false);
        scrErrors.setViewportView(txaErrors);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(txtUsername)
                    .addComponent(txtPassword)
                    .addComponent(btnLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(btnCreateAccount))
                    .addComponent(jLabel1)
                    .addComponent(scrErrors))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(56, 56, 56)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCreateAccount)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrErrors, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        String username = txtUsername.getText();
        String password = txtPassword.getText();
        
        if (username.trim().isEmpty()) {
            showError("Username is required");
            return;
        }
        
        if (password.trim().isEmpty()) {
            showError("Password is required");
            return;
        }
        
        btnLogin.setEnabled(false);
        hideError();
        
        emit("submit", username.trim(), password);
    }//GEN-LAST:event_btnLoginActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreateAccount;
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane scrErrors;
    private javax.swing.JTextArea txaErrors;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
