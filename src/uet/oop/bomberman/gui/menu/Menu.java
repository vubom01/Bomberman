package uet.oop.bomberman.gui.menu;


import uet.oop.bomberman.gui.Frame;

public class Menu extends javax.swing.JPanel {

    Frame frame;

    public Menu(Frame frame) {
        initComponents();
        this.frame = frame;
    }

    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        JPanel = new javax.swing.JPanel();
        battle = new javax.swing.JButton();
        newgame = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        setLayout(new java.awt.GridBagLayout());

        JPanel.setOpaque(false);

        battle.setText("BATTLE");
        battle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                battleActionPerformed(evt);
            }
        });

        newgame.setText("NEW GAME");
        newgame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newgameActionPerformed(evt);
            }
        });

        exit.setText("EXIT");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JPanelLayout = new javax.swing.GroupLayout(JPanel);
        JPanel.setLayout(JPanelLayout);
        JPanelLayout.setHorizontalGroup(
                JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(JPanelLayout.createSequentialGroup()
                                .addGap(207, 207, 207)
                                .addGroup(JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(battle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(newgame, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                                        .addComponent(exit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(274, Short.MAX_VALUE))
        );
        JPanelLayout.setVerticalGroup(
                JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPanelLayout.createSequentialGroup()
                                .addContainerGap(328, Short.MAX_VALUE)
                                .addComponent(newgame, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(battle, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(196, 196, 196))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(JPanel, gridBagConstraints);

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/textures/background.png")));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(background, gridBagConstraints);
    }

    private void newgameActionPerformed(java.awt.event.ActionEvent evt) {
        frame.play();
    }

    private void battleActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {
    }


    private javax.swing.JPanel JPanel;
    private javax.swing.JLabel background;
    private javax.swing.JButton battle;
    private javax.swing.JButton exit;
    private javax.swing.JButton newgame;
}
