/*
Frame da tela inicial do jogo (padrão para inglês, português e espanhol)
@author arthurpereira
@author athossilvano
@author samuelmiranda
*/
package ifnmg.frontend;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;

public class FrmInicio extends javax.swing.JFrame {
    public static Clip inicio;
    public FrmInicio(){
        initComponents();
        this.setLocationRelativeTo(null);
        try{
            AudioInputStream audio = AudioSystem.getAudioInputStream(new File("src/main/resources/audios/musicaInicial.wav"));
            inicio = AudioSystem.getClip();
            inicio.open(audio);
            inicio.start();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro na leitura do arquivo.");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlInicio = new javax.swing.JPanel();
        btnStart = new javax.swing.JButton();
        lblInicio = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlInicio.setBackground(new java.awt.Color(255, 255, 255));
        pnlInicio.setLayout(null);

        btnStart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttons/startGame.jpg"))); // NOI18N
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });
        pnlInicio.add(btnStart);
        btnStart.setBounds(780, 490, 220, 80);

        lblInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/telaInicio.jpg"))); // NOI18N
        pnlInicio.add(lblInicio);
        lblInicio.setBounds(0, 0, 1024, 590);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlInicio, javax.swing.GroupLayout.DEFAULT_SIZE, 1024, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlInicio, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        try{
            AudioInputStream audio = AudioSystem.getAudioInputStream(new File("src/main/resources/audios/welcome.wav"));
            Clip welcome = AudioSystem.getClip();
            welcome.open(audio);
            welcome.start();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro na leitura do arquivo.");
        }
        new FrmIdioma().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnStartActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmInicio().setVisible(true);
                
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnStart;
    private javax.swing.JLabel lblInicio;
    private javax.swing.JPanel pnlInicio;
    // End of variables declaration//GEN-END:variables
}