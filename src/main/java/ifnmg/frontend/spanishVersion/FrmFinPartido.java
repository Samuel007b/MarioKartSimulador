/*
Frame da tela final do jogo (português)
@author arthurpereira
@author athossilvano
@author samuelmiranda
*/
package ifnmg.frontend.spanishVersion;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import static ifnmg.backend.Api.vencedor;
import ifnmg.backend.Partido;
import ifnmg.backend.Personagem;
import ifnmg.backend.Rodada;
import static ifnmg.frontend.FrmInicio.inicio;
import static ifnmg.frontend.spanishVersion.FrmJugadores.jog1;
import static ifnmg.frontend.spanishVersion.FrmJugadores.jog2;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class FrmFinPartido extends javax.swing.JFrame {
    private static int quantVitorias;
    private static int idPartida;
    private static int pts;
    private static List<Rodada> rodadaList = new ArrayList<>();
    private static List<Partido> partidaList = new ArrayList<>();
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
    public FrmFinPartido(int quantVitorias, int idPartida, int pts, List<Rodada> rodadaList) {
        FrmFinPartido.quantVitorias=quantVitorias;
        FrmFinPartido.idPartida=idPartida;
        FrmFinPartido.pts=pts;
        FrmFinPartido.rodadaList = rodadaList;
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
                JOptionPane.showMessageDialog(null, "Error al leer el archivo.");
            }
            lblImagemEmpate.setIcon(empate);
            lblTrofeu.setVisible(false);
            lblVencedor.setText("Hubo un empate entre "+jog1.getNome()+" y "+jog2.getNome()+".");
            lblPerdedor.setText("Ambos terminaron con "+jog1.getPontos()+" punto(s).");
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
            FrmFinPartido.quantVitorias++;
            try{
                AudioInputStream audio = AudioSystem.getAudioInputStream(new File("src/main/resources/audios/vitoria1.wav"));
                Clip vitoria1 = AudioSystem.getClip();
                vitoria1.open(audio);
                vitoria1.start();
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Error al leer el archivo.");
            }
            lblVencedor.setText("¡El gran ganador fue "+jog1.getNome()+" (tú)¡");
            somVitoria(jog1);
            lblPerdedor.setText(jog2.getNome()+" (computadora) quedó en 2º lugar.");
            if(FrmFinPartido.pts<3){
                FrmFinPartido.pts++;
            }
            else if(FrmFinPartido.pts==3 && "Samuel".equals(jog1.getNome())){
                FrmFinPartido.pts++;
            }
            else if(FrmFinPartido.pts==4 && "Didi Show".equals(jog1.getNome())){
                btnPlayAgain.setEnabled(false);
                btnPlayAgain.setVisible(false);
                FrmFinPartido.pts++;
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
                JOptionPane.showMessageDialog(null, "Error al leer el archivo.");
            }
            lblVencedor.setText("Desafortunadamente, el ganador fue "+jog2.getNome()+" (computadora) ...");
            somVitoria(jog2);
            lblPerdedor.setText(jog1.getNome()+" (tú) quedó en 2º lugar.");
            if("Didi Show".equals(jog1.getNome())){
                btnPlayAgain.setEnabled(false);
                btnPlayAgain.setVisible(false);
            }
        }
        Partido p = new Partido(idPartida, jog1.getNome(), jog2.getNome(), jog1.getPontos(), jog2.getPontos());
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
        lblImagemEmpate = new javax.swing.JLabel();

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
        lblVencedor.setText("El ganador fue...");
        pnlFimJogo.add(lblVencedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 410, 1020, -1));

        btnHistorico1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttons/Historico1-esp.gif"))); // NOI18N
        btnHistorico1.setContentAreaFilled(false);
        btnHistorico1.setFocusPainted(false);
        btnHistorico1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistorico1ActionPerformed(evt);
            }
        });
        pnlFimJogo.add(btnHistorico1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 517, 260, 40));

        btnHistorico2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttons/Historico2-esp.gif"))); // NOI18N
        btnHistorico2.setToolTipText("");
        btnHistorico2.setContentAreaFilled(false);
        btnHistorico2.setFocusPainted(false);
        btnHistorico2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistorico2ActionPerformed(evt);
            }
        });
        pnlFimJogo.add(btnHistorico2, new org.netbeans.lib.awtextra.AbsoluteConstraints(738, 517, 250, 40));

        lblImagemVencedor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnlFimJogo.add(lblImagemVencedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, 320, 290));

        lblTrofeu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTrofeu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/trofeu.gif"))); // NOI18N
        pnlFimJogo.add(lblTrofeu, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 180, -1, -1));

        lblPerdedor.setFont(new java.awt.Font("Showcard Gothic", 0, 12)); // NOI18N
        lblPerdedor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPerdedor.setText("Perdedor");
        pnlFimJogo.add(lblPerdedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 460, 1020, -1));

        lblImagemEmpate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnlFimJogo.add(lblImagemEmpate, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 120, 320, 290));

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
        int resposta = JOptionPane.showConfirmDialog(null, "¿Quieres jugar de nuevo?", "Regresar al Menú Principal", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(resposta == JOptionPane.YES_OPTION){
            new FrmJugadores(FrmFinPartido.quantVitorias, FrmFinPartido.idPartida, FrmFinPartido.pts, jog1, jog2).setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnPlayAgainActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        if(vencedor!=jog1 && "Samuel".equals(jog1.getNome())){
            try{
                AudioInputStream audio = AudioSystem.getAudioInputStream(new File("src/main/resources/audios/samuel-esp/desistir.wav"));
                Clip desistir = AudioSystem.getClip();
                desistir.open(audio);
                desistir.start();
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Error al leer el archivo.");
            }
        }
        int resposta = JOptionPane.showConfirmDialog(null, "¿Quieres salir del juego?", "Terminar el Juego", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(resposta == JOptionPane.YES_OPTION){
            inicio.close();
            if(FrmFinPartido.pts==4 && "Didi Show".equals(jog1.getNome())){
                try{
                    AudioInputStream audio = AudioSystem.getAudioInputStream(new File("src/main/resources/audios/gameOver.wav"));
                    Clip gameOver = AudioSystem.getClip();
                    gameOver.open(audio);
                    gameOver.start();
                }
                catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Error al leer el archivo.");
                }
                this.dispose();
                JOptionPane.showMessageDialog(null, "Fallaste...");
            }
            else if(FrmFinPartido.pts==5){
                new FrmCreditus(false).setVisible(true);
                this.dispose();
                try{
                    AudioInputStream audio = AudioSystem.getAudioInputStream(new File("src/main/resources/audios/vitoria2.wav"));
                    Clip vitoria2 = AudioSystem.getClip();
                    vitoria2.open(audio);
                    vitoria2.start();
                }
                catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Error al leer el archivo.");
                }
                JOptionPane.showMessageDialog(null, "¡¡¡Ganaste el juego!!!");
            }
            else
                this.dispose();
        }
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnHistorico1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistorico1ActionPerformed
        if(vencedor == jog1)
            JOptionPane.showMessageDialog(null, FrmFinPartido.rodadaList+"\n----- Fin del Partido -----\n¡"+jog1.getNome()+" ganó el partido con "+jog1.getPontos()+" puntos!\nPor otro lado "+jog2.getNome()+" perdió y terminó con "+jog2.getPontos()+" puntos.");
        else if(vencedor == jog2)
            JOptionPane.showMessageDialog(null, FrmFinPartido.rodadaList+"\n----- Fin del Partido -----\n¡"+jog2.getNome()+" ganó el partido con "+jog2.getPontos()+" puntos!\nPor otro lado "+jog1.getNome()+" perdió y terminó con "+jog1.getPontos()+" puntos.");
        else
            JOptionPane.showMessageDialog(null, FrmFinPartido.rodadaList+"\n----- Fin del Partido -----\n"+jog1.getNome()+" y "+jog2.getNome()+" empataron con "+jog1.getPontos()+" puntos cada uno.");
    }//GEN-LAST:event_btnHistorico1ActionPerformed

    private void btnHistorico2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistorico2ActionPerformed
        JOptionPane.showMessageDialog(null, partidaList+"\n----- Resumen ----\nTienes "+FrmFinPartido.quantVitorias+" victorias en "+FrmFinPartido.idPartida+" partidos.");
    }//GEN-LAST:event_btnHistorico2ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmFinPartido(FrmFinPartido.quantVitorias, FrmFinPartido.idPartida, FrmFinPartido.pts, rodadaList).setVisible(true);
            }
        });
    }
    private static void somVitoria(Personagem jog){
        try{
            AudioInputStream audio;
            if("Mario".equals(jog.getNome()))
                audio = AudioSystem.getAudioInputStream(new File("src/main/resources/audios/mario2.wav"));
            else if("Bowser".equals(jog.getNome()))
                audio = AudioSystem.getAudioInputStream(new File("src/main/resources/audios/bowser.wav"));
            else if("Toad".equals(jog.getNome()))
                audio = AudioSystem.getAudioInputStream(new File("src/main/resources/audios/toad2.wav"));
            else if("Luigi".equals(jog.getNome()))
                audio = AudioSystem.getAudioInputStream(new File("src/main/resources/audios/luigi2.wav"));
            else if("Peach".equals(jog.getNome()))
                audio = AudioSystem.getAudioInputStream(new File("src/main/resources/audios/peach2.wav"));
            else if("Yoshi".equals(jog.getNome()))
                audio = AudioSystem.getAudioInputStream(new File("src/main/resources/audios/yoshi2.wav"));
            else if("Donkey Kong".equals(jog.getNome()))
                audio = AudioSystem.getAudioInputStream(new File("src/main/resources/audios/dk2.wav"));
            else if("Samuel".equals(jog.getNome()))
                audio = AudioSystem.getAudioInputStream(new File("src/main/resources/audios/samuel-siuuu.wav"));
            else
                audio = AudioSystem.getAudioInputStream(new File("src/main/resources/audios/didi/mer-esp.wav"));
            Clip player = AudioSystem.getClip();
            player.open(audio);
            player.start();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al leer el archivo.");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHistorico1;
    private javax.swing.JButton btnHistorico2;
    private javax.swing.JButton btnPlayAgain;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel lblImagemEmpate;
    private javax.swing.JLabel lblImagemVencedor;
    private javax.swing.JLabel lblPerdedor;
    private javax.swing.JLabel lblTrofeu;
    private javax.swing.JLabel lblVencedor;
    private javax.swing.JPanel pnlFimJogo;
    // End of variables declaration//GEN-END:variables
}