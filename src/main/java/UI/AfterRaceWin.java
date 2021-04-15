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
    public void setInfo(float WPM, int Errors, int time, float percentage){
        int seconds = 0;
        int minutes = 0;
        String s2 = null;
        String s1 = null;
        
        this.LastRaceSpeed.setText(String.format("%.0f", WPM));
        this.LastRaceErrors.setText(String.valueOf(Errors));
        this.LastRacePercentage.setText(String.format("%.0f", percentage) + '%');
        
        if(time > 60){
            minutes = time / 60;
            time = time % 60;
            seconds = time;
        }
        else{
            minutes = 0;
            seconds = time;
        }
        
        if(minutes < 10 && minutes != 0)
            s1 = '0' + String.valueOf(minutes);
        else if(minutes == 0)
            s1 = "00";
        else
            s1 = String.valueOf(minutes);
        
        if(seconds < 10 && seconds != 0)
            s2 = '0' + String.valueOf(seconds);
        else if(seconds == 0)
            s2 = "00";
        else
            s2 = String.valueOf(seconds);
        
        this.LastRaceTime.setText(s1 + ':' + s2);
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        LastRaceSpeed = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        LastRaceErrors = new javax.swing.JTextField();
        LastRacePercentage = new javax.swing.JTextField();
        LastRaceTime = new javax.swing.JTextField();
        WPMLabel = new javax.swing.JLabel();
        ErrorsLabel = new javax.swing.JLabel();
        PercentageLabel = new javax.swing.JLabel();
        TimeLabel = new javax.swing.JLabel();

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

        LastRaceSpeed.setEditable(false);
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

        LastRaceErrors.setEditable(false);
        LastRaceErrors.setBackground(new java.awt.Color(0, 0, 0));
        LastRaceErrors.setFont(new java.awt.Font("Yu Gothic Light", 0, 20)); // NOI18N
        LastRaceErrors.setForeground(new java.awt.Color(255, 255, 255));
        LastRaceErrors.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        LastRaceErrors.setText("N/A");

        LastRacePercentage.setEditable(false);
        LastRacePercentage.setBackground(new java.awt.Color(0, 0, 0));
        LastRacePercentage.setFont(new java.awt.Font("Yu Gothic Light", 0, 20)); // NOI18N
        LastRacePercentage.setForeground(new java.awt.Color(255, 255, 255));
        LastRacePercentage.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        LastRacePercentage.setText("N/A");

        LastRaceTime.setEditable(false);
        LastRaceTime.setBackground(new java.awt.Color(0, 0, 0));
        LastRaceTime.setFont(new java.awt.Font("Yu Gothic Light", 0, 20)); // NOI18N
        LastRaceTime.setForeground(new java.awt.Color(255, 255, 255));
        LastRaceTime.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        LastRaceTime.setText("N/A");

        WPMLabel.setForeground(new java.awt.Color(255, 255, 255));
        WPMLabel.setText("WPM:");

        ErrorsLabel.setForeground(new java.awt.Color(255, 255, 255));
        ErrorsLabel.setText("Errors:");

        PercentageLabel.setForeground(new java.awt.Color(255, 255, 255));
        PercentageLabel.setText("Percentage:");

        TimeLabel.setForeground(new java.awt.Color(255, 255, 255));
        TimeLabel.setText("Time:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(WPMLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LastRaceSpeed, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(LastRaceErrors, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                    .addComponent(ErrorsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(PercentageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(TimeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(LastRacePercentage, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(LastRaceTime, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)))
                .addGap(24, 24, 24))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(WPMLabel)
                            .addComponent(ErrorsLabel)
                            .addComponent(PercentageLabel)
                            .addComponent(TimeLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(LastRaceSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LastRaceErrors, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(LastRaceTime, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
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
    private javax.swing.JLabel ErrorsLabel;
    private javax.swing.JTextField LastRaceErrors;
    private javax.swing.JTextField LastRacePercentage;
    private javax.swing.JTextField LastRaceSpeed;
    private javax.swing.JTextField LastRaceTime;
    private javax.swing.JLabel PercentageLabel;
    private javax.swing.JLabel TimeLabel;
    private javax.swing.JLabel WPMLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    // End of variables declaration//GEN-END:variables
}
