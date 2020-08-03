
package ec.edu.espe.medicbyte.view;

import ec.edu.espe.medicbyte.common.core.Window;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JPanel;
import jiconfont.IconCode;
import jiconfont.icons.font_awesome.FontAwesome;
import jiconfont.swing.IconFontSwing;

/**
 *
 * @author Andres Jonathan J.
 */
public class MainWindow extends Window {
    public static class MenuItem {
        private final String label;
        private IconCode icon;
        private final Callable<Boolean> callback;
        
        public MenuItem(String label, IconCode icon, Callable<Boolean> callback) {
            this.label = label;
            this.icon = icon;
            this.callback = callback;
        }
        
        public MenuItem(String label, Callable<Boolean> callback) {
            this.label = label;
            this.callback = callback;
            this.icon = null;
        }
        
        public String getLabel() { return label; }
        public IconCode getIcon() { return icon; }
        public Callable<Boolean> getCallback() { return callback; }
    }
    
    private static class MenuItemContext {
        public MenuItem item;
        public JButton button;
        public JPanel wrapper;
    }
    
    private List<MenuItemContext> menuItems = new ArrayList<>();
    
    /** Creates new form FrmAppointments */
    public MainWindow() {
        super();
        initComponents();
    }
    
    @Override
    public void init() {
        
    }
    
    @Override
    public void display(JPanel view) {
        view.setOpaque(false);
        
        content.removeAll();
        content.add(view);
        content.revalidate();
        content.repaint();
    }
    
    public void addMenuItem(MenuItem item) {
        JPanel wrapper = new JPanel();
        JButton button = new JButton();
        
        wrapper.setBackground(new java.awt.Color(60, 171, 219));
        wrapper.setMaximumSize(new java.awt.Dimension(2147483647, 28));
        wrapper.setMinimumSize(new java.awt.Dimension(180, 28));
        wrapper.setOpaque(false);
        wrapper.setPreferredSize(new java.awt.Dimension(295, 28));
        wrapper.setLayout(new java.awt.BorderLayout());
        
        button.setForeground(new java.awt.Color(71, 71, 71));
        button.setText(item.getLabel());
        button.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 7, 4, 4));
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button.setFocusPainted(false);
        button.setFocusable(false);
        button.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        button.setMaximumSize(new java.awt.Dimension(180, 26));
        button.setMinimumSize(new java.awt.Dimension(180, 30));
        button.setPreferredSize(new java.awt.Dimension(180, 30));
        
        if (item.getIcon() != null) {
            button.setIcon(IconFontSwing.buildIcon(item.getIcon(), 15));
            button.setIconTextGap(8);
        }
        
        button.addActionListener(e -> {
            (new Thread() {
                @Override public void run() {
                    boolean accepted;
                    
                    try {
                        accepted = item.getCallback().call();
                    } catch (Exception ex) {
                        Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                        accepted = false;
                    }
                    
                    if (!accepted) {
                        return;
                    }
                    
                    wrapper.setOpaque(true);
                    button.setForeground(new Color(255, 255, 255));
                    
                    if (item.getIcon() != null) {
                        button.setIcon(IconFontSwing.buildIcon(
                                item.getIcon(), 15, new Color(255, 255, 255)));
                    }
                    
                    menuItems.forEach(menuItem -> {
                        if (menuItem.item == item) {
                            return;
                        }
                        
                        menuItem.button.setForeground(new Color(71, 71, 71));
                        menuItem.wrapper.setOpaque(false);
                        
                        if (menuItem.item.getIcon() != null) {
                            menuItem.button.setIcon(IconFontSwing.buildIcon(
                                    menuItem.item.getIcon(), 15, new Color(71, 71, 71)));
                        }
                    });
                    
                    repaint();
                    revalidate();
                }
            }).start();
        });
        
        MenuItemContext context = new MenuItemContext();
        context.item = item;
        context.button = button;
        context.wrapper = wrapper;
        
        wrapper.add(button);
        menu.add(wrapper);
        menuItems.add(context);
        
        // revalidate this frame to show changes
        revalidate();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        root = new javax.swing.JPanel();
        sidebar = new javax.swing.JPanel();
        userInfoPanel = new javax.swing.JPanel();
        avatar = new javax.swing.JLabel();
        usernameScrollPanel = new javax.swing.JScrollPane();
        usernameScrollPanel.getViewport().setOpaque(false);
        textareaUsername = new javax.swing.JTextArea();
        btnNotifications = new javax.swing.JButton();
        btnAccount = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        menu = new javax.swing.JPanel();
        container = new javax.swing.JPanel();
        content = new javax.swing.JPanel();
        statusbar = new javax.swing.JPanel();
        innerStatusbar = new javax.swing.JPanel();
        lblStatusbarContent = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(820, 400));
        setPreferredSize(new java.awt.Dimension(820, 550));

        root.setLayout(new java.awt.GridBagLayout());

        sidebar.setBackground(new java.awt.Color(234, 236, 236));
        sidebar.setMinimumSize(new java.awt.Dimension(180, 100));
        sidebar.setPreferredSize(new java.awt.Dimension(180, 227));
        sidebar.setLayout(new java.awt.BorderLayout());

        userInfoPanel.setMinimumSize(new java.awt.Dimension(180, 40));
        userInfoPanel.setOpaque(false);
        userInfoPanel.setPreferredSize(new java.awt.Dimension(180, 120));

        avatar.setBackground(new java.awt.Color(212, 212, 213));
        avatar.setOpaque(true);

        usernameScrollPanel.setBackground(new java.awt.Color(204, 204, 255));
        usernameScrollPanel.setBorder(null);
        usernameScrollPanel.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        usernameScrollPanel.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        usernameScrollPanel.setOpaque(false);

        textareaUsername.setEditable(false);
        textareaUsername.setColumns(20);
        textareaUsername.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        textareaUsername.setForeground(new java.awt.Color(126, 126, 126));
        textareaUsername.setLineWrap(true);
        textareaUsername.setRows(5);
        textareaUsername.setText("{{ username }}");
        textareaUsername.setWrapStyleWord(true);
        textareaUsername.setBorder(null);
        textareaUsername.setOpaque(false);
        usernameScrollPanel.setViewportView(textareaUsername);

        btnNotifications.setIcon(IconFontSwing.buildIcon(FontAwesome.BELL, 16));
        btnNotifications.setForeground(new java.awt.Color(176, 187, 190));
        btnNotifications.setContentAreaFilled(false);
        btnNotifications.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNotifications.setFocusPainted(false);

        btnAccount.setForeground(new java.awt.Color(126, 126, 126));
        btnAccount.setText("Account");
        btnAccount.setBorder(null);
        btnAccount.setBorderPainted(false);
        btnAccount.setContentAreaFilled(false);
        btnAccount.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAccount.setFocusPainted(false);

        btnLogout.setForeground(new java.awt.Color(126, 126, 126));
        btnLogout.setText("Logout");
        btnLogout.setBorder(null);
        btnLogout.setContentAreaFilled(false);
        btnLogout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogout.setFocusPainted(false);

        javax.swing.GroupLayout userInfoPanelLayout = new javax.swing.GroupLayout(userInfoPanel);
        userInfoPanel.setLayout(userInfoPanelLayout);
        userInfoPanelLayout.setHorizontalGroup(
            userInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userInfoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(userInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(usernameScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(userInfoPanelLayout.createSequentialGroup()
                        .addComponent(avatar, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addGroup(userInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAccount)
                            .addComponent(btnLogout))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addComponent(btnNotifications, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        userInfoPanelLayout.setVerticalGroup(
            userInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userInfoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(userInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(avatar, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNotifications, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(userInfoPanelLayout.createSequentialGroup()
                        .addComponent(btnAccount)
                        .addGap(0, 0, 0)
                        .addComponent(btnLogout)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usernameScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        sidebar.add(userInfoPanel, java.awt.BorderLayout.PAGE_START);

        menu.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 0, 10, 0));
        menu.setOpaque(false);
        menu.setLayout(new javax.swing.BoxLayout(menu, javax.swing.BoxLayout.Y_AXIS));
        sidebar.add(menu, java.awt.BorderLayout.LINE_START);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.weighty = 1.0;
        root.add(sidebar, gridBagConstraints);

        container.setBackground(new java.awt.Color(248, 248, 248));
        container.setPreferredSize(new java.awt.Dimension(350, 371));

        content.setBackground(new java.awt.Color(248, 248, 248));
        content.setOpaque(false);
        content.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout containerLayout = new javax.swing.GroupLayout(container);
        container.setLayout(containerLayout);
        containerLayout.setHorizontalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        containerLayout.setVerticalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.ABOVE_BASELINE;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        root.add(container, gridBagConstraints);

        statusbar.setMaximumSize(new java.awt.Dimension(2147483647, 30));
        statusbar.setPreferredSize(new java.awt.Dimension(629, 30));
        statusbar.setLayout(new java.awt.BorderLayout());

        innerStatusbar.setBackground(new java.awt.Color(213, 217, 219));
        innerStatusbar.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        innerStatusbar.setLayout(new javax.swing.BoxLayout(innerStatusbar, javax.swing.BoxLayout.LINE_AXIS));

        lblStatusbarContent.setForeground(new java.awt.Color(100, 112, 113));
        lblStatusbarContent.setText("Done!");
        innerStatusbar.add(lblStatusbarContent);

        statusbar.add(innerStatusbar, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BELOW_BASELINE_TRAILING;
        gridBagConstraints.weightx = 1.0;
        root.add(statusbar, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(root, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(root, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel avatar;
    private javax.swing.JButton btnAccount;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnNotifications;
    private javax.swing.JPanel container;
    private javax.swing.JPanel content;
    private javax.swing.JPanel innerStatusbar;
    private javax.swing.JLabel lblStatusbarContent;
    private javax.swing.JPanel menu;
    private javax.swing.JPanel root;
    private javax.swing.JPanel sidebar;
    private javax.swing.JPanel statusbar;
    private javax.swing.JTextArea textareaUsername;
    private javax.swing.JPanel userInfoPanel;
    private javax.swing.JScrollPane usernameScrollPanel;
    // End of variables declaration//GEN-END:variables

}
