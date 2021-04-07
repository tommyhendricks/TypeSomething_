/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

/**
 *
 * @author Tommy Hendricks
 */
public class AfterRaceWin extends javax.swing.JFrame {

    /**
     * Creates new form AfterRaceWin
     */
    public AfterRaceWin() {
        initComponents();
    }
    
    /**
     * 
     * @param WPM int
     * @param Errors int 
     * @param time float
     * This will set the info on the After race screen.
     * 
     */
    public void setInfo(float WPM, int Errors, float time, float percentage){
        this.LastRaceSpeed.setText(String.format("%.0f", WPM));
        this.LastRaceErrors.setText(String.valueOf(Errors));
        this.LastRacePercentage.setText(String.valueOf(percentage) + '%');
        
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        SpeedLable = new javax.swing.JTextField();
        LastRaceSpeed = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        LastRaceErrors = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        LastRacePercentage = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        LastRaceTime = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();

        jTextField7.setBackground(new java.awt.Color(0, 0, 0));
        jTextField7.setFont(new java.awt.Font("Yu Gothic Light", 0, 20)); // NOI18N
        jTextField7.setForeground(new java.awt.Color(255, 255, 255));
        jTextField7.setText("N/A");

        jTextField8.setEditable(false);
        jTextField8.setBackground(new java.awt.Color(0, 0, 0));
        jTextField8.setForeground(new java.awt.Color(255, 255, 255));
        jTextField8.setText("Speed:");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        SpeedLable.setEditable(false);
        SpeedLable.setBackground(new java.awt.Color(0, 0, 0));
        SpeedLable.setForeground(new java.awt.Color(255, 255, 255));
        SpeedLable.setText("Speed:");

        LastRaceSpeed.setBackground(new java.awt.Color(0, 0, 0));
        LastRaceSpeed.setFont(new java.awt.Font("Yu Gothic Light", 0, 20)); // NOI18N
        LastRaceSpeed.setForeground(new java.awt.Color(255, 255, 255));
        LastRaceSpeed.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        LastRaceSpeed.setText("N/A");

        jButton1.setText("Close");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        LastRaceErrors.setBackground(new java.awt.Color(0, 0, 0));
        LastRaceErrors.setFont(new java.awt.Font("Yu Gothic Light", 0, 20)); // NOI18N
        LastRaceErrors.setForeground(new java.awt.Color(255, 255, 255));
        LastRaceErrors.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        LastRaceErrors.setText("N/A");

        jTextField4.setEditable(false);
        jTextField4.setBackground(new java.awt.Color(0, 0, 0));
        jTextField4.setForeground(new java.awt.Color(255, 255, 255));
        jTextField4.setText("Errors:");

        LastRacePercentage.setBackground(new java.awt.Color(0, 0, 0));
        LastRacePercentage.setFont(new java.awt.Font("Yu Gothic Light", 0, 20)); // NOI18N
        LastRacePercentage.setForeground(new java.awt.Color(255, 255, 255));
        LastRacePercentage.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        LastRacePercentage.setText("N/A");

        jTextField6.setEditable(false);
        jTextField6.setBackground(new java.awt.Color(0, 0, 0));
        jTextField6.setForeground(new java.awt.Color(255, 255, 255));
        jTextField6.setText("Percentage:");

        LastRaceTime.setBackground(new java.awt.Color(0, 0, 0));
        LastRaceTime.setFont(new java.awt.Font("Yu Gothic Light", 0, 20)); // NOI18N
        LastRaceTime.setForeground(new java.awt.Color(255, 255, 255));
        LastRaceTime.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        LastRaceTime.setText("N/A");

        jTextField10.setEditable(false);
        jTextField10.setBackground(new java.awt.Color(0, 0, 0));
        jTextField10.setForeground(new java.awt.Color(255, 255, 255));
        jTextField10.setText("Time:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(SpeedLable)
                    .addComponent(LastRaceSpeed, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(LastRaceErrors, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                    .addComponent(jTextField4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(LastRacePercentage)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LastRaceTime, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                            .addComponent(jTextField10))))
                .addGap(24, 24, 24))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(SpeedLable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(LastRaceSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(LastRaceErrors, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LastRaceTime, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LastRacePercentage, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField LastRaceErrors;
    private javax.swing.JTextField LastRacePercentage;
    private javax.swing.JTextField LastRaceSpeed;
    private javax.swing.JTextField LastRaceTime;
    private javax.swing.JTextField SpeedLable;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    // End of variables declaration//GEN-END:variables
}
