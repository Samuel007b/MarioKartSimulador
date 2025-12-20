/*
Frame da tela de seleção de idioma
@author arthurpereira
@author athossilvano
@author samuelmiranda
*/
package ifnmg.frontend;

import javax.swing.JOptionPane;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class FrmIdioma extends javax.swing.JFrame {
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrmIdioma.class.getName());

    public FrmIdioma() {
        initComponents();
        this.setLocationRelativeTo(null);
        JOptionPane.showMessageDialog(null,"Please choose the game's language.\nPor favor, escolha o idioma do jogo.\nPor favor, seleccione el idioma del juego.");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlIdioma = new javax.swing.JPanel();
        btnEnglish = new javax.swing.JButton();
        btnPortugues = new javax.swing.JButton();
        btnEspañol = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlIdioma.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEnglish.setBackground(new java.awt.Color(255, 50, 50));
        btnEnglish.setFont(new java.awt.Font("Showcard Gothic", 1, 24)); // NOI18N
        btnEnglish.setForeground(new java.awt.Color(11, 166, 217));
        btnEnglish.setText("English");
        btnEnglish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnglishActionPerformed(evt);
            }
        });
        pnlIdioma.add(btnEnglish, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 480, 220, 70));

        btnPortugues.setBackground(new java.awt.Color(255, 255, 25));
        btnPortugues.setFont(new java.awt.Font("Showcard Gothic", 1, 18)); // NOI18N
        btnPortugues.setForeground(new java.awt.Color(50, 50, 255));
        btnPortugues.setText("Português");
        btnPortugues.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPortugues.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPortuguesActionPerformed(evt);
            }
        });
        pnlIdioma.add(btnPortugues, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 40, 220, 70));

        btnEspañol.setBackground(new java.awt.Color(255, 117, 25));
        btnEspañol.setFont(new java.awt.Font("Showcard Gothic", 1, 18)); // NOI18N
        btnEspañol.setForeground(new java.awt.Color(255, 25, 25));
        btnEspañol.setText("Español");
        btnEspañol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEspañolActionPerformed(evt);
            }
        });
        pnlIdioma.add(btnEspañol, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 480, 220, 70));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/telaIdioma.png"))); // NOI18N
        pnlIdioma.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlIdioma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlIdioma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPortuguesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPortuguesActionPerformed
        int resposta = JOptionPane.showConfirmDialog(null, "Você confirma o português como o idioma do jogo (não será possível mudar depois)?", "Confirmar Idioma", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(resposta==JOptionPane.YES_OPTION){
            try{
                AudioInputStream audio = AudioSystem.getAudioInputStream(new File("src/main/resources/audios/brasil.wav"));
                Clip brasil = AudioSystem.getClip();
                brasil.open(audio);
                brasil.start();
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Erro na leitura do arquivo.");
            }
            new FrmJogadores(0, 0, null, null).setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnPortuguesActionPerformed

    private void btnEspañolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEspañolActionPerformed
        int resposta = JOptionPane.showConfirmDialog(null, "¿Puedes confirmar que el español es el idioma del juego (no será posible cambiarlo más adelante)?", "Confirmar Idioma", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(resposta==JOptionPane.YES_OPTION){
            try{
                AudioInputStream audio = AudioSystem.getAudioInputStream(new File("src/main/resources/audios/espanha.wav"));
                Clip espanha = AudioSystem.getClip();
                espanha.open(audio);
                espanha.start();
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Erro na leitura do arquivo.");
            }
            new FrmJogadores(0, 0, null, null).setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnEspañolActionPerformed

    private void btnEnglishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnglishActionPerformed
        int resposta = JOptionPane.showConfirmDialog(null, "Can you confirm English as the game's language (it won't be possible to change it later)?", "Confirm Language", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(resposta==JOptionPane.YES_OPTION){
            try{
                AudioInputStream audio = AudioSystem.getAudioInputStream(new File("src/main/resources/audios/inglaterra.wav"));
                Clip inglaterra = AudioSystem.getClip();
                inglaterra.open(audio);
                inglaterra.start();
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Erro na leitura do arquivo.");
            }
            new FrmJogadores(0, 0, null, null).setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnEnglishActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new FrmIdioma().setVisible(true));
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnglish;
    private javax.swing.JButton btnEspañol;
    private javax.swing.JButton btnPortugues;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel pnlIdioma;
    // End of variables declaration//GEN-END:variables
}
