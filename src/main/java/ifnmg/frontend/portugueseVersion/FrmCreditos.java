/*
Frame da tela especial de créditos (português)
@author arthurpereira
@author athossilvano
@author samuelmiranda
*/
package ifnmg.frontend.portugueseVersion;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class FrmCreditos extends javax.swing.JFrame {
    private static final ImageIcon mcqueen = new ImageIcon("src/main/resources/mcqueen.gif");
    private static Clip f1;
    private static boolean jogoEstrelas;
    public FrmCreditos(boolean jogoEstrelas) {
        initComponents();
        this.setLocationRelativeTo(null);
        try{
            AudioInputStream audio = AudioSystem.getAudioInputStream(new File("src/main/resources/audios/f1Theme.wav"));
            f1 = AudioSystem.getClip();
            f1.open(audio);
            f1.start();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro na leitura do arquivo.");
        }
        if(jogoEstrelas==true){
            btnJogoEstrelas.setVisible(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCreditos = new javax.swing.JPanel();
        lblHall = new javax.swing.JLabel();
        lblLeo = new javax.swing.JLabel();
        lblSamuel = new javax.swing.JLabel();
        lblCaio = new javax.swing.JLabel();
        lblParabens = new javax.swing.JLabel();
        lblMario = new javax.swing.JLabel();
        lblLuigi = new javax.swing.JLabel();
        lblPeach = new javax.swing.JLabel();
        lblBowser = new javax.swing.JLabel();
        lblToad = new javax.swing.JLabel();
        lblYoshi = new javax.swing.JLabel();
        lblDk = new javax.swing.JLabel();
        lblDidi = new javax.swing.JLabel();
        lblAgradecimentos = new javax.swing.JLabel();
        lblSair = new javax.swing.JButton();
        btnJogoEstrelas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblCreditos.setBackground(new java.awt.Color(102, 102, 102));
        lblCreditos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblHall.setFont(new java.awt.Font("Showcard Gothic", 1, 48)); // NOI18N
        lblHall.setForeground(new java.awt.Color(255, 255, 255));
        lblHall.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHall.setText("Bem-Vindo ao Hall das Lendas!!!");
        lblCreditos.add(lblHall, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 1200, -1));

        lblLeo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLeo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/leo.png"))); // NOI18N
        lblCreditos.add(lblLeo, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 230, -1, -1));

        lblSamuel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/samumaquina.png"))); // NOI18N
        lblCreditos.add(lblSamuel, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 230, -1, -1));

        lblCaio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCaio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/caio.png"))); // NOI18N
        lblCreditos.add(lblCaio, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 230, -1, -1));

        lblParabens.setFont(new java.awt.Font("Showcard Gothic", 2, 14)); // NOI18N
        lblParabens.setForeground(new java.awt.Color(255, 255, 255));
        lblParabens.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblParabens.setText("--- Você provou  que merecia estar aqui ---");
        lblCreditos.add(lblParabens, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 1200, -1));

        lblMario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mario.gif"))); // NOI18N
        lblCreditos.add(lblMario, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, -1, -1));

        lblLuigi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/luigi.gif"))); // NOI18N
        lblCreditos.add(lblLuigi, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, -1, -1));

        lblPeach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/peach.gif"))); // NOI18N
        lblCreditos.add(lblPeach, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 120, -1, -1));

        lblBowser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bowser.gif"))); // NOI18N
        lblCreditos.add(lblBowser, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 120, -1, -1));

        lblToad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/toad.gif"))); // NOI18N
        lblCreditos.add(lblToad, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 120, -1, -1));

        lblYoshi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/yoshi.gif"))); // NOI18N
        lblCreditos.add(lblYoshi, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 120, -1, -1));

        lblDk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dk.gif"))); // NOI18N
        lblCreditos.add(lblDk, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 120, -1, -1));

        lblDidi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/didiShow.png"))); // NOI18N
        lblCreditos.add(lblDidi, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 260, -1, -1));

        lblAgradecimentos.setBackground(new java.awt.Color(255, 255, 255));
        lblAgradecimentos.setFont(new java.awt.Font("Showcard Gothic", 2, 14)); // NOI18N
        lblAgradecimentos.setForeground(new java.awt.Color(255, 255, 255));
        lblAgradecimentos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAgradecimentos.setText("Agradecimentos especiais: Leonardo Humberto, Caio Lamas, Caio da Silva, Gustavo Santos, Ryanderson Henzyo & Sara Augusta");
        lblCreditos.add(lblAgradecimentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 450, 1190, -1));

        lblSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/exit.png"))); // NOI18N
        lblSair.setBorderPainted(false);
        lblSair.setContentAreaFilled(false);
        lblSair.setFocusPainted(false);
        lblSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblSairActionPerformed(evt);
            }
        });
        lblCreditos.add(lblSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 500, -1, -1));

        btnJogoEstrelas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttons/surpresa.gif"))); // NOI18N
        btnJogoEstrelas.setContentAreaFilled(false);
        btnJogoEstrelas.setFocusPainted(false);
        btnJogoEstrelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJogoEstrelasActionPerformed(evt);
            }
        });
        lblCreditos.add(btnJogoEstrelas, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 480, 80, 80));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblCreditos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblCreditos, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblSairActionPerformed
        int resposta = JOptionPane.showConfirmDialog(null, "Você quer encerrar o jogo?", "Finalizar Jogo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(resposta == JOptionPane.YES_OPTION){
            JOptionPane.showMessageDialog(null, "Obrigado por ter jogado Mario Kart Simulador, volte sempre!");
            this.dispose();
            JOptionPane.showMessageDialog(null, null, "A criatividade não tem limites!", JOptionPane.INFORMATION_MESSAGE, mcqueen);
        }
    }//GEN-LAST:event_lblSairActionPerformed

    private void btnJogoEstrelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJogoEstrelasActionPerformed
        try{
            AudioInputStream audio = AudioSystem.getAudioInputStream(new File("src/main/resources/audios/surpresa.wav"));
            Clip surpresa = AudioSystem.getClip();
            surpresa.open(audio);
            surpresa.start();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro na leitura do arquivo.");
        }
        int resposta = JOptionPane.showConfirmDialog(null, "Você quer disputar o Jogo das Estrelas?", "Bônus", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(resposta == JOptionPane.YES_OPTION){
            this.dispose();
            f1.close();
            try{
                AudioInputStream audio = AudioSystem.getAudioInputStream(new File("src/main/resources/audios/jogoEstrelasIntro.wav"));
                Clip estrela = AudioSystem.getClip();
                estrela.open(audio);
                estrela.start();
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Erro na leitura do arquivo.");
            }
            JOptionPane.showMessageDialog(null, "Bem vindo ao Jogo das Estrelas! Consiste em uma competição semelhante ao jogo original, porém com personagens especiais e que envolve o sorteio dos atributos dos jogadores.");
            new FrmJogsJogoEstrelas(0, 0, 0).setVisible(true);
        }
    }//GEN-LAST:event_btnJogoEstrelasActionPerformed

    public static void main(String args[]) {
        new FrmCreditos(jogoEstrelas).setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnJogoEstrelas;
    private javax.swing.JLabel lblAgradecimentos;
    private javax.swing.JLabel lblBowser;
    private javax.swing.JLabel lblCaio;
    private javax.swing.JPanel lblCreditos;
    private javax.swing.JLabel lblDidi;
    private javax.swing.JLabel lblDk;
    private javax.swing.JLabel lblHall;
    private javax.swing.JLabel lblLeo;
    private javax.swing.JLabel lblLuigi;
    private javax.swing.JLabel lblMario;
    private javax.swing.JLabel lblParabens;
    private javax.swing.JLabel lblPeach;
    private javax.swing.JButton lblSair;
    private javax.swing.JLabel lblSamuel;
    private javax.swing.JLabel lblToad;
    private javax.swing.JLabel lblYoshi;
    // End of variables declaration//GEN-END:variables
}