package ec.edu.espe.medicbyte.view;

import ec.edu.espe.medicbyte.common.core.View;
import ec.edu.espe.medicbyte.common.core.Window;
import java.awt.Color;
import java.awt.Component;
import java.net.URL;
import javax.swing.ImageIcon;
import jiconfont.icons.font_awesome.FontAwesome;
import jiconfont.swing.IconFontSwing;

/**
 *
 * @author Andres Jonathan J.
 */
public class AuthWindow extends Window {
    /**
     * Creates new form AuthWindow
     */
    public AuthWindow() {
        initComponents();
        setupComponents();
    }
    
    @Override
    public void reveal() {
        super.reveal();
        setAlwaysOnTop(true);
        toFront();
        repaint();
        setAlwaysOnTop(false);
    }

    @Override
    public void display(View view) {
        view.setOpaque(false);
        
        if (formContainer.getComponents().length > 0) {
            Component child = formContainer.getComponent(0);
            
            if (child instanceof View) {
                ((View) child).leave();
            }
        }
        
        formContainer.removeAll();
        formContainer.add(view);
        view.enter();
        formContainer.revalidate();
        formContainer.repaint();
    }

    @Override
    protected void onChange(String name, Object oldValue, Object newValue) {}
    
    private void setupComponents() {
        setLocationRelativeTo(null);
        setIconImage(IconFontSwing.buildImage(FontAwesome.HEARTBEAT, 16, new Color(82, 116, 147)));
        
        URL logo = getClass().getResource("/images/logo.png");
        lblLogo.setIcon(new ImageIcon(logo));
        
        URL image = getClass().getResource("/images/auth-wireframe.png");
        lblWireframe.setIcon(new ImageIcon(image));
    }
    
    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT
     * modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        formContainer = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        lblWireframe = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MedicByte - Authentification");
        setMaximumSize(new java.awt.Dimension(750, 600));
        setMinimumSize(new java.awt.Dimension(750, 600));
        setPreferredSize(new java.awt.Dimension(750, 600));
        setResizable(false);

        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        formContainer.setBackground(new java.awt.Color(255, 255, 255));
        formContainer.setLayout(new java.awt.CardLayout());
        jPanel1.add(formContainer);

        jPanel3.setBackground(new java.awt.Color(250, 250, 250));
        jPanel3.setLayout(new java.awt.BorderLayout());

        lblLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogo.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblLogo.setBorder(javax.swing.BorderFactory.createEmptyBorder(40, 1, 1, 1));
        lblLogo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel3.add(lblLogo, java.awt.BorderLayout.PAGE_START);

        lblWireframe.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel3.add(lblWireframe, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 682, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel formContainer;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblWireframe;
    // End of variables declaration//GEN-END:variables
}
