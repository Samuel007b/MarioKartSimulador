/*
Frame da tela final do Jogo das Estrelas (inglês)
@author arthurpereira
@author athossilvano
@author samuelmiranda
*/
package ifnmg.frontend.englishVersion;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import static ifnmg.backend.Api.vencedor;
import ifnmg.backend.Match;
import ifnmg.backend.Personagem;
import ifnmg.backend.Rodada;
import static ifnmg.frontend.englishVersion.FrmPlayersStarGame.jogStar;
import static ifnmg.frontend.englishVersion.FrmPlayersStarGame.jog1;
import static ifnmg.frontend.englishVersion.FrmPlayersStarGame.jog2;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class FrmEndStarGame extends javax.swing.JFrame {
    private static int vitoriasLeo;
    private static int vitoriasCaio;
    private static int idPartida;
    private static List<Rodada> rodadaList = new ArrayList<>();
    private static List<Match> partidaList = new ArrayList<>();
    private static final ImageIcon empate = new ImageIcon("src/main/resources/characters/empate.png");
    private static final ImageIcon leo = new ImageIcon("src/main/resources/characters/leoVit.png");
    private static final ImageIcon caio = new ImageIcon("src/main/resources/characters/caioVit.png");
    private static Personagem vencedor=null;
    public FrmEndStarGame(int vitoriasLeo, int vitoriasCaio, int idPartida, List<Rodada> rodadaList) {
        FrmEndStarGame.vitoriasLeo=vitoriasLeo;
        FrmEndStarGame.vitoriasCaio=vitoriasCaio;
        FrmEndStarGame.idPartida=idPartida;
        FrmEndStarGame.rodadaList = rodadaList;
        initComponents();
        this.setLocationRelativeTo(null);
        vencedor = vencedor(jog1, jog2);
        if(vencedor==null){
            try{
                AudioInputStream audio = AudioSystem.getAudioInputStream(new File("src/main/resources/audios/empate.wav"));
                Clip empate = AudioSystem.getClip();
                empate.open(audio);
                empate.start();
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Error reading the file.");
            }
            lblImagemEmpate.setIcon(empate);
            lblTrofeu.setVisible(false);
            lblVencedor.setText("There was a tie between "+jog1.getNome()+" and "+jog2.getNome()+".");
            lblPerdedor.setText("They both ended up with "+jog1.getPontos()+" point(s) in the All-Star Game.");
        }
        else if("Léo".equals(vencedor.getNome()))
            lblImagemVencedor.setIcon(leo);
        else if("Caio".equals(vencedor.getNome()))
            lblImagemVencedor.setIcon(caio);
        if(vencedor == jog1){
            FrmEndStarGame.vitoriasLeo++;
            try{
                AudioInputStream audio = AudioSystem.getAudioInputStream(new File("src/main/resources/audios/vitoria1.wav"));
                Clip vitoria1 = AudioSystem.getClip();
                vitoria1.open(audio);
                vitoria1.start();
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Error reading the file.");
            }
            lblVencedor.setText("The great champion of the All-Star Game was "+jog1.getNome()+" !!!");
            lblPerdedor.setText(jog2.getNome()+" came in second place.");
            
        }
        else if(vencedor == jog2){
            FrmEndStarGame.vitoriasCaio++;
            try{
                AudioInputStream audio = AudioSystem.getAudioInputStream(new File("src/main/resources/audios/vitoria1.wav"));
                Clip vitoria1 = AudioSystem.getClip();
                vitoria1.open(audio);
                vitoria1.start();
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Erro na leitura do arquivo.");
            }
            lblVencedor.setText("The great champion of the All-Star Game was "+jog2.getNome()+" !!!");
            lblPerdedor.setText(jog1.getNome()+" came in second place.");
        }
        Match m = new Match(idPartida, jog1.getNome(), jog2.getNome(), jog1.getPontos(), jog2.getPontos());
        partidaList.add(m);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlFimJogo = new javax.swing.JPanel();
        btnPlayAgain = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        lblVencedor = new javax.swing.JLabel();
        btnHistorico1 = new javax.swing.JButton();
        btnHistorico2 = new javax.swing.JButton();
        lblImagemVencedor = new javax.swing.JLabel();
        lblTrofeu = new javax.swing.JLabel();
        lblPerdedor = new javax.swing.JLabel();
        lblImagemEmpate = new javax.swing.JLabel();
        lblFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlFimJogo.setBackground(new java.awt.Color(101, 178, 255));
        pnlFimJogo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnPlayAgain.setIcon(new javax.swing.ImageIcon(getClass().getResource("/playAgain.png"))); // NOI18N
        btnPlayAgain.setBorderPainted(false);
        btnPlayAgain.setContentAreaFilled(false);
        btnPlayAgain.setFocusPainted(false);
        btnPlayAgain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayAgainActionPerformed(evt);
            }
        });
        pnlFimJogo.add(btnPlayAgain, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/exit.png"))); // NOI18N
        btnSair.setBorderPainted(false);
        btnSair.setContentAreaFilled(false);
        btnSair.setFocusPainted(false);
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });
        pnlFimJogo.add(btnSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 30, -1, -1));

        lblVencedor.setFont(new java.awt.Font("Showcard Gothic", 0, 24)); // NOI18N
        lblVencedor.setForeground(new java.awt.Color(255, 255, 255));
        lblVencedor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVencedor.setText("The Winner was  ...");
        pnlFimJogo.add(lblVencedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 410, 1020, -1));

        btnHistorico1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttons/Historico1-ing.gif"))); // NOI18N
        btnHistorico1.setContentAreaFilled(false);
        btnHistorico1.setFocusPainted(false);
        btnHistorico1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistorico1ActionPerformed(evt);
            }
        });
        pnlFimJogo.add(btnHistorico1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 517, 230, 40));

        btnHistorico2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttons/Historico2-ing.gif"))); // NOI18N
        btnHistorico2.setContentAreaFilled(false);
        btnHistorico2.setFocusPainted(false);
        btnHistorico2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistorico2ActionPerformed(evt);
            }
        });
        pnlFimJogo.add(btnHistorico2, new org.netbeans.lib.awtextra.AbsoluteConstraints(776, 517, 210, 40));

        lblImagemVencedor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnlFimJogo.add(lblImagemVencedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, 320, 290));

        lblTrofeu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTrofeu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/trofeu.gif"))); // NOI18N
        pnlFimJogo.add(lblTrofeu, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 180, -1, -1));

        lblPerdedor.setFont(new java.awt.Font("Showcard Gothic", 0, 12)); // NOI18N
        lblPerdedor.setForeground(new java.awt.Color(255, 255, 255));
        lblPerdedor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPerdedor.setText("Loser");
        pnlFimJogo.add(lblPerdedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 460, 1020, -1));

        lblImagemEmpate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnlFimJogo.add(lblImagemEmpate, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 120, 320, 290));

        lblFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/estrelas.jpg"))); // NOI18N
        pnlFimJogo.add(lblFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFimJogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFimJogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPlayAgainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayAgainActionPerformed
        int resposta = JOptionPane.showConfirmDialog(null, "Do you want to play again?", "Return to Main Menu", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(resposta == JOptionPane.YES_OPTION){
            jogStar.close();
            new FrmPlayersStarGame(FrmEndStarGame.vitoriasLeo, FrmEndStarGame.vitoriasCaio, FrmEndStarGame.idPartida).setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnPlayAgainActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        int resposta = JOptionPane.showConfirmDialog(null, "Do you want to quit the All-Star Game?", "End the All-Star Game", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(resposta == JOptionPane.YES_OPTION){
            jogStar.close();
            new FrmCredits(true).setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnHistorico1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistorico1ActionPerformed
        if(vencedor == jog1)
            JOptionPane.showMessageDialog(null, FrmEndStarGame.rodadaList+"\n----- End of the All-Star Game -----\n"+jog1.getNome()+" won the game with "+jog1.getPontos()+" point(s)!\nMeanwhile "+jog2.getNome()+" lost and was left with "+jog2.getPontos()+" point(s).");
        else if(vencedor == jog2)
            JOptionPane.showMessageDialog(null, FrmEndStarGame.rodadaList+"\n----- End of the All-Star Game -----\n"+jog2.getNome()+" won the game with "+jog2.getPontos()+" point(s)!\nMeanwhile "+jog1.getNome()+" lost and was left with "+jog1.getPontos()+" point(s).");
        else
            JOptionPane.showMessageDialog(null, FrmEndStarGame.rodadaList+"\n----- End of the All-Star Game -----\n"+jog1.getNome()+" and "+jog2.getNome()+" tied with "+jog1.getPontos()+" points each.");
    }//GEN-LAST:event_btnHistorico1ActionPerformed

    private void btnHistorico2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistorico2ActionPerformed
        JOptionPane.showMessageDialog(null, partidaList+"\n----- Summary ----\nIn "+FrmEndStarGame.idPartida+" matches, Léo has "+FrmEndStarGame.vitoriasLeo+" wins, Caio has "+FrmEndStarGame.vitoriasCaio+" wins, and there were "+(FrmEndStarGame.idPartida-FrmEndStarGame.vitoriasLeo-FrmEndStarGame.vitoriasCaio)+" draws.");
    }//GEN-LAST:event_btnHistorico2ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmEndStarGame(FrmEndStarGame.vitoriasLeo, FrmEndStarGame.vitoriasCaio, FrmEndStarGame.idPartida, rodadaList).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHistorico1;
    private javax.swing.JButton btnHistorico2;
    private javax.swing.JButton btnPlayAgain;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel lblFundo;
    private javax.swing.JLabel lblImagemEmpate;
    private javax.swing.JLabel lblImagemVencedor;
    private javax.swing.JLabel lblPerdedor;
    private javax.swing.JLabel lblTrofeu;
    private javax.swing.JLabel lblVencedor;
    private javax.swing.JPanel pnlFimJogo;
    // End of variables declaration//GEN-END:variables
}