package uet.oop.bomberman.gui.menu;

import uet.oop.bomberman.gamestage.Game;

public class InfoPanel extends javax.swing.JPanel {

    public InfoPanel(Game game) {

        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        score = new javax.swing.JLabel();
        time = new javax.swing.JLabel();
        live = new javax.swing.JLabel();
        hi_score = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setOpaque(false);
        setLayout(new java.awt.GridBagLayout());

        jPanel1.setOpaque(false);

        score.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        score.setForeground(new java.awt.Color(255, 255, 255));
        score.setText("0");

        time.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        time.setForeground(new java.awt.Color(255, 255, 255));
        time.setText(game.getBoard().getTime() + "");

        live.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        live.setForeground(new java.awt.Color(255, 255, 255));
        live.setText(game.getBoard().getLives() + "");

        hi_score.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        hi_score.setForeground(new java.awt.Color(255, 255, 255));
        hi_score.setText("999999999");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(score, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56)
                                .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)
                                .addComponent(live)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                                .addComponent(hi_score, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(score, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(time)
                                        .addComponent(live, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(hi_score, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(17, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jPanel1, gridBagConstraints);

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/textures/taskbar.png")));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(background, gridBagConstraints);
    }

    public void setTime(int t) {
        time.setText(t + "");
    }

    public void setLives(int t) {
        live.setText(t + "");

    }

    public void setScore(int t) {
        score.setText(t + "");
    }

    public void setHi_score(int t) {
        hi_score.setText(t + "");
    }


    private javax.swing.JLabel background;
    private javax.swing.JLabel hi_score;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel live;
    private javax.swing.JLabel score;
    private javax.swing.JLabel time;
}
