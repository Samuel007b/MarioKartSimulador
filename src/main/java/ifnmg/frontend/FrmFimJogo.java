/*
Frame da tela final do jogo
@author arthurpereira
@author athossilvano
@author samuelmiranda
*/
package ifnmg.frontend;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import static ifnmg.backend.Api.vencedor;
import ifnmg.backend.Partida;
import ifnmg.backend.Personagem;
import ifnmg.backend.Rodada;
import static ifnmg.frontend.FrmJogadores.jog1;
import static ifnmg.frontend.FrmJogadores.jog2;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class FrmFimJogo extends javax.swing.JFrame {
    private static int quantVitorias;
    private static int idPartida;
    private static List<Rodada> rodadaList = new ArrayList<>();
    private static List<Partida> partidaList = new ArrayList<>();
    private static final ImageIcon empate = new ImageIcon("src/main/resources/characters/empate.png");
    private static final ImageIcon mario = new ImageIcon("src/main/resources/characters/marioM.gif");
    private static final ImageIcon bowser = new ImageIcon("src/main/resources/characters/bowserM.gif");
    private static final ImageIcon toad = new ImageIcon("src/main/resources/characters/toadM.gif");
    private static final ImageIcon luigi = new ImageIcon("src/main/resources/characters/luigiM.gif");
    private static final ImageIcon peach = new ImageIcon("src/main/resources/characters/peachM.gif");
    private static final ImageIcon yoshi = new ImageIcon("src/main/resources/characters/yoshiM.gif");
    private static final ImageIcon dk = new ImageIcon("src/main/resources/characters/dkM.gif");
    private static final ImageIcon samuel = new ImageIcon("src/main/resources/characters/samuelVit.gif");
    private static final ImageIcon didi = new ImageIcon("src/main/resources/characters/didiVit.gif");
    private static Personagem vencedor=null;
    public FrmFimJogo(int quantVitorias, int idPartida, List<Rodada> rodadaList) {
        this.idPartida=idPartida;
        this.rodadaList = rodadaList;
        FrmFimJogo.quantVitorias=quantVitorias;
        initComponents();
        this.setLocationRelativeTo(null);
        vencedor = vencedor(jog1, jog2);
        if(vencedor==null){
            lblImagemVencedor.setIcon(empate);
            lblTrofeu.setVisible(false);
            lblVencedor.setText("Houve um empate entre "+jog1.getNome()+" e "+jog2.getNome()+".");
            lblPerdedor.setText("Ambos ficaram ambos com "+jog1.getPontos()+" ponto(s).");
        }
        else if("Mario".equals(vencedor.getNome()))
            lblImagemVencedor.setIcon(mario);
        else if("Bowser".equals(vencedor.getNome()))
            lblImagemVencedor.setIcon(bowser);
        else if("Toad".equals(vencedor.getNome()))
            lblImagemVencedor.setIcon(toad);
        else if("Luigi".equals(vencedor.getNome()))
            lblImagemVencedor.setIcon(luigi);
        else if("Peach".equals(vencedor.getNome()))
            lblImagemVencedor.setIcon(peach);
        else if("Yoshi".equals(vencedor.getNome()))
            lblImagemVencedor.setIcon(yoshi);
        else if("Donkey Kong".equals(vencedor.getNome()))
            lblImagemVencedor.setIcon(dk);
        else if("Samuel".equals(vencedor.getNome()))
            lblImagemVencedor.setIcon(samuel);
        else if("Didi Show".equals(vencedor.getNome()))
            lblImagemVencedor.setIcon(didi);
        if(vencedor == jog1){
            try{
                AudioInputStream audio = AudioSystem.getAudioInputStream(new File("src/main/resources/audios/vitoria1.wav"));
                Clip vitoria1 = AudioSystem.getClip();
                vitoria1.open(audio);
                vitoria1.start();
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Erro na leitura do arquivo.");
            }
            lblVencedor.setText("O grande vencedor foi "+jog1.getNome()+" (você) !!!");
            try{
                AudioInputStream audio;
                if("Mario".equals(jog1.getNome()))
                    audio = AudioSystem.getAudioInputStream(new File("src/main/resources/audios/mario2.wav"));
                else if("Bowser".equals(jog1.getNome()))
                    audio = AudioSystem.getAudioInputStream(new File("src/main/resources/audios/bowser.wav"));
                else if("Toad".equals(jog1.getNome()))
                    audio = AudioSystem.getAudioInputStream(new File("src/main/resources/audios/toad2.wav"));
                else if("Luigi".equals(jog1.getNome()))
                    audio = AudioSystem.getAudioInputStream(new File("src/main/resources/audios/luigi2.wav"));
                else if("Peach".equals(jog1.getNome()))
                    audio = AudioSystem.getAudioInputStream(new File("src/main/resources/audios/peach2.wav"));
                else if("Yoshi".equals(jog1.getNome()))
                    audio = AudioSystem.getAudioInputStream(new File("src/main/resources/audios/yoshi2.wav"));
                else if("Donkey Kong".equals(jog1.getNome()))
                    audio = AudioSystem.getAudioInputStream(new File("src/main/resources/audios/dk2.wav"));
                else if("Samuel".equals(jog1.getNome()))
                    audio = AudioSystem.getAudioInputStream(new File("src/main/resources/audios/samuel-siuuu.wav"));
                else
                    audio = AudioSystem.getAudioInputStream(new File("src/main/resources/audios/didi/mer-por.wav"));
                Clip player1 = AudioSystem.getClip();
                player1.open(audio);
                player1.start();
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Erro na leitura do arquivo.");
            }
            lblPerdedor.setText(jog2.getNome()+" (computador) ficou em 2º lugar.");
            if(FrmFimJogo.quantVitorias<3){
                FrmFimJogo.quantVitorias++;
            }
            else if(quantVitorias==3 && "Samuel".equals(jog1.getNome())){
                FrmFimJogo.quantVitorias++;
            }
            else if(quantVitorias==4 && "Didi Show".equals(jog1.getNome())){
                btnPlayAgain.setEnabled(false);
                btnPlayAgain.setVisible(false);
                FrmFimJogo.quantVitorias++;
            }
        }
        else if(vencedor == jog2){
            try{
                AudioInputStream audio = AudioSystem.getAudioInputStream(new File("src/main/resources/audios/derrota.wav"));
                Clip derrota = AudioSystem.getClip();
                derrota.open(audio);
                derrota.start();
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Erro na leitura do arquivo.");
            }
            lblVencedor.setText("Infelizmente o vencedor foi "+jog2.getNome()+" (computador) ...");
            try{
                AudioInputStream audio;
                if("Mario".equals(jog2.getNome()))
                    audio = AudioSystem.getAudioInputStream(new File("src/main/resources/audios/mario2.wav"));
                else if("Bowser".equals(jog2.getNome()))
                    audio = AudioSystem.getAudioInputStream(new File("src/main/resources/audios/bowser.wav"));
                else if("Toad".equals(jog2.getNome()))
                    audio = AudioSystem.getAudioInputStream(new File("src/main/resources/audios/toad2.wav"));
                else if("Luigi".equals(jog2.getNome()))
                    audio = AudioSystem.getAudioInputStream(new File("src/main/resources/audios/luigi2.wav"));
                else if("Peach".equals(jog2.getNome()))
                    audio = AudioSystem.getAudioInputStream(new File("src/main/resources/audios/peach2.wav"));
                else if("Yoshi".equals(jog2.getNome()))
                    audio = AudioSystem.getAudioInputStream(new File("src/main/resources/audios/yoshi2.wav"));
                else if("Donkey Kong".equals(jog2.getNome()))
                    audio = AudioSystem.getAudioInputStream(new File("src/main/resources/audios/dk2.wav"));
                else if("Samuel".equals(jog2.getNome()))
                    audio = AudioSystem.getAudioInputStream(new File("src/main/resources/audios/samuel-siuuu.wav"));
                else
                    audio = AudioSystem.getAudioInputStream(new File("src/main/resources/audios/didi/mer-por.wav"));
                Clip player2 = AudioSystem.getClip();
                player2.open(audio);
                player2.start();
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Erro na leitura do arquivo.");
            }
            lblPerdedor.setText(jog1.getNome()+" (você) ficou em 2º lugar.");
            if("Didi Show".equals(jog1.getNome())){
                btnPlayAgain.setEnabled(false);
                btnPlayAgain.setVisible(false);
            }
        }
        Partida p = new Partida(idPartida, jog1.getNome(), jog2.getNome(), jog1.getPontos(), jog2.getPontos());
        partidaList.add(p);
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
        lblVencedor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVencedor.setText("O vencedor foi ...");
        pnlFimJogo.add(lblVencedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 1020, -1));

        btnHistorico1.setText("Histórico desta Partida");
        btnHistorico1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistorico1ActionPerformed(evt);
            }
        });
        pnlFimJogo.add(btnHistorico1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 540, -1, -1));

        btnHistorico2.setText("Histórico das Partidas");
        btnHistorico2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistorico2ActionPerformed(evt);
            }
        });
        pnlFimJogo.add(btnHistorico2, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 540, -1, -1));

        lblImagemVencedor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnlFimJogo.add(lblImagemVencedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 130, 320, 290));

        lblTrofeu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTrofeu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/trofeu.gif"))); // NOI18N
        pnlFimJogo.add(lblTrofeu, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 200, -1, -1));

        lblPerdedor.setFont(new java.awt.Font("Showcard Gothic", 0, 12)); // NOI18N
        lblPerdedor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPerdedor.setText("Perdedor");
        pnlFimJogo.add(lblPerdedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(-3, 480, 1020, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFimJogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFimJogo, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPlayAgainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayAgainActionPerformed
        int resposta = JOptionPane.showConfirmDialog(null, "Deseja jogar novamente?", "Voltar ao Menu Principal", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(resposta == JOptionPane.YES_OPTION){
            try{
                AudioInputStream audio = AudioSystem.getAudioInputStream(new File("src/main/resources/audios/samuel-por/duvide.wav"));
                Clip duvide = AudioSystem.getClip();
                duvide.open(audio);
                duvide.start();
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Erro na leitura do arquivo.");
            }
            new FrmJogadores(FrmFimJogo.quantVitorias, FrmFimJogo.idPartida, jog1, jog2).setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnPlayAgainActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        if(vencedor!=jog1 && "Samuel".equals(jog1.getNome())){
            try{
                AudioInputStream audio = AudioSystem.getAudioInputStream(new File("src/main/resources/audios/samuel-por/desistir.wav"));
                Clip desistir = AudioSystem.getClip();
                desistir.open(audio);
                desistir.start();
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Erro na leitura do arquivo.");
            }
        }
        int resposta = JOptionPane.showConfirmDialog(null, "Você quer sair do jogo?", "Encerrar Jogo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(resposta == JOptionPane.YES_OPTION){
            if(FrmFimJogo.quantVitorias==4 && "Didi Show".equals(jog1.getNome())){
                try{
                    AudioInputStream audio = AudioSystem.getAudioInputStream(new File("src/main/resources/audios/gameOver.wav"));
                    Clip gameOver = AudioSystem.getClip();
                    gameOver.open(audio);
                    gameOver.start();
                }
                catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Erro na leitura do arquivo.");
                }
                this.dispose();
                JOptionPane.showMessageDialog(null, "Você fracassou...");
            }
            else if(FrmFimJogo.quantVitorias==5){
                new FrmCreditos().setVisible(true);
                this.dispose();
                try{
                    AudioInputStream audio = AudioSystem.getAudioInputStream(new File("src/main/resources/audios/vitoria2.wav"));
                    Clip vitoria2 = AudioSystem.getClip();
                    vitoria2.open(audio);
                    vitoria2.start();
                }
                catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Erro na leitura do arquivo.");
                }
                JOptionPane.showMessageDialog(null, "Você zerou o jogo!!!");
            }
            else
                this.dispose();
        }
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnHistorico1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistorico1ActionPerformed
        if(vencedor == jog1)
            JOptionPane.showMessageDialog(null, this.rodadaList+"\n----- Fim de Jogo -----\n"+jog1.getNome()+" venceu o jogo com "+jog1.getPontos()+" pontos!\nJá "+jog2.getNome()+" perdeu e ficou com "+jog2.getPontos()+" pontos.");
        else if(vencedor == jog2)
            JOptionPane.showMessageDialog(null, this.rodadaList+"\n----- Fim de Jogo -----\n"+jog2.getNome()+" venceu o jogo com "+jog2.getPontos()+" pontos!\nJá "+jog1.getNome()+" perdeu e ficou com "+jog1.getPontos()+" pontos.");
        else
            JOptionPane.showMessageDialog(null, this.rodadaList+"\n----- Fim de Jogo -----\n"+jog1.getNome()+" e "+jog2.getNome()+" empataram com "+jog1.getPontos()+" pontos cada.");
    }//GEN-LAST:event_btnHistorico1ActionPerformed

    private void btnHistorico2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistorico2ActionPerformed
        JOptionPane.showMessageDialog(null, partidaList+"\n----- Resumo ----\nVocê está com "+FrmFimJogo.quantVitorias+" vitórias e "+(FrmFimJogo.idPartida-FrmFimJogo.quantVitorias)+" derrotas em "+FrmFimJogo.quantVitorias+" partidas.");
    }//GEN-LAST:event_btnHistorico2ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmFimJogo(FrmFimJogo.quantVitorias, FrmFimJogo.idPartida, rodadaList).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHistorico1;
    private javax.swing.JButton btnHistorico2;
    private javax.swing.JButton btnPlayAgain;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel lblImagemVencedor;
    private javax.swing.JLabel lblPerdedor;
    private javax.swing.JLabel lblTrofeu;
    private javax.swing.JLabel lblVencedor;
    private javax.swing.JPanel pnlFimJogo;
    // End of variables declaration//GEN-END:variables
}
