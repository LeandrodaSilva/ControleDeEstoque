/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Aluno
 */
public class TopBar extends javax.swing.JPanel {

    /**
     * Creates new form TopBar
     */
    public TopBar() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lTittle = new javax.swing.JLabel();
        bClose = new javax.swing.JButton();
        bMinimize = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(800, 50));

        lTittle.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lTittle.setText("Tittle");

        bClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/closeB.png"))); // NOI18N
        bClose.setBorder(null);
        bClose.setBorderPainted(false);
        bClose.setContentAreaFilled(false);
        bClose.setPreferredSize(new java.awt.Dimension(30, 10));

        bMinimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/minimizeB.png"))); // NOI18N
        bMinimize.setBorder(null);
        bMinimize.setBorderPainted(false);
        bMinimize.setContentAreaFilled(false);
        bMinimize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bMinimizeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lTittle, javax.swing.GroupLayout.DEFAULT_SIZE, 651, Short.MAX_VALUE)
                .addGap(58, 58, 58)
                .addComponent(bMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bClose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lTittle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bClose, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bMinimizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bMinimizeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bMinimizeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bClose;
    private javax.swing.JButton bMinimize;
    private javax.swing.JLabel lTittle;
    // End of variables declaration//GEN-END:variables
}