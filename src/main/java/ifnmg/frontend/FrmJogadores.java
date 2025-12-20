/*
Frame da tela de seleção de personagens
@author arthurpereira
@author athossilvano
@author samuelmiranda
*/
package ifnmg.frontend;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import ifnmg.backend.Personagem;
import static ifnmg.backend.Api.csvToList;
import static ifnmg.backend.Api.sorteiaJogBotA;
import static ifnmg.backend.Api.sorteiaJogBotB;
import static ifnmg.backend.Api.sorteiaJogBotC;
import static ifnmg.backend.Api.vencedor;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
public class FrmJogadores extends javax.swing.JFrame {
    private static int quantVitorias;
    private static int idPartida;
    private static int pts;
    private static final ImageIcon samuel = new ImageIcon("src/main/resources/samuel.gif");
    private static final ImageIcon didi = new ImageIcon("src/main/resources/didi.gif");
    public static Personagem jog1, jog2;
    private static List<Personagem> personagemList = new ArrayList<>();
    public FrmJogadores(int quantVitorias, int idPartida, int pts, Personagem jog1, Personagem jog2) {
        FrmJogadores.idPartida=idPartida+1;
        FrmJogadores.quantVitorias=quantVitorias;
        FrmJogadores.pts=pts;
        try{
            personagemList = csvToList("data/tabela-personagens.csv");
            initComponents();
            if(FrmJogadores.pts>=3){
                btnP8.setIcon(samuel);
                if(FrmJogadores.pts>=4)
                    btnP9.setIcon(didi);
            }
            this.setLocationRelativeTo(null);
            lblImagem.setHorizontalAlignment(SwingConstants.CENTER);
            lblImagem.setVerticalAlignment(SwingConstants.CENTER);
            lblPlayer.setVisible(false);
            lblNome.setVisible(false);
            lblImagem.setVisible(false);
            lblVelocidade.setVisible(false);
            lblManobrabilidade.setVisible(false);
            lblPoder.setVisible(false);
            btnIniciar.setVisible(false);
            btnIniciar.setEnabled(false);
            if(FrmJogadores.pts==3 && vencedor(jog1, jog2)==jog1){
                JOptionPane.showMessageDialog(null, "Você desbloqueou o personagem SAMUEL !!!");
                try{
                    AudioInputStream audio = AudioSystem.getAudioInputStream(new File("src/main/resources/audios/samuel-siu.wav"));
                    Clip samuelsiu = AudioSystem.getClip();
                    samuelsiu.open(audio);
                    samuelsiu.start();
                    Thread.sleep(3000);
                    samuelsiu.close();
                }
                catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Erro na leitura do arquivo.");
                }
            }
            else if(FrmJogadores.pts==4 && vencedor(jog1, jog2)==jog1){
                JOptionPane.showMessageDialog(null, "Você desbloqueou o personagem DIDI SHOW !!!");
                try{
                    AudioInputStream audio = AudioSystem.getAudioInputStream(new File("src/main/resources/audios/didi/mer-por.wav"));
                    Clip didimer = AudioSystem.getClip();
                    didimer.open(audio);
                    didimer.start();
                    Thread.sleep(2000);
                    didimer.close();
                }
                catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Erro na leitura do arquivo.");
                }
            }
            jog1=null;
            jog2=null;
            try{
                AudioInputStream audio = AudioSystem.getAudioInputStream(new File("src/main/resources/audios/escolherJog.wav"));
                Clip escolherJog = AudioSystem.getClip();
                escolherJog.open(audio);
                escolherJog.start();
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Erro na leitura do arquivo.");
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlJogadores = new javax.swing.JPanel();
        btnSelectP1 = new javax.swing.JButton();
        btnSelectP2 = new javax.swing.JButton();
        btnSelectP3 = new javax.swing.JButton();
        btnSelectP4 = new javax.swing.JButton();
        btnSelectP5 = new javax.swing.JButton();
        btnSelectP6 = new javax.swing.JButton();
        btnSelectP7 = new javax.swing.JButton();
        btnSelectP8 = new javax.swing.JButton();
        btnSelectP9 = new javax.swing.JButton();
        pnlSelecionado = new javax.swing.JPanel();
        lblPlayer = new javax.swing.JLabel();
        lblVelocidade = new javax.swing.JLabel();
        lblManobrabilidade = new javax.swing.JLabel();
        lblPoder = new javax.swing.JLabel();
        lblImagem = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        btnIniciar = new javax.swing.JButton();
        btnP1 = new javax.swing.JButton();
        btnP4 = new javax.swing.JButton();
        btnP2 = new javax.swing.JButton();
        btnP7 = new javax.swing.JButton();
        btnP5 = new javax.swing.JButton();
        btnP3 = new javax.swing.JButton();
        btnP6 = new javax.swing.JButton();
        btnP8 = new javax.swing.JButton();
        btnP9 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlJogadores.setBackground(new java.awt.Color(101, 178, 255));
        pnlJogadores.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSelectP1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Mario-por.gif"))); // NOI18N
        btnSelectP1.setBorderPainted(false);
        btnSelectP1.setContentAreaFilled(false);
        btnSelectP1.setFocusPainted(false);
        btnSelectP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectP1ActionPerformed(evt);
            }
        });
        pnlJogadores.add(btnSelectP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 170, -1, -1));

        btnSelectP2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Bowser-por.gif"))); // NOI18N
        btnSelectP2.setBorderPainted(false);
        btnSelectP2.setContentAreaFilled(false);
        btnSelectP2.setFocusPainted(false);
        btnSelectP2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectP2ActionPerformed(evt);
            }
        });
        pnlJogadores.add(btnSelectP2, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 170, -1, -1));

        btnSelectP3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Toad-por.gif"))); // NOI18N
        btnSelectP3.setBorderPainted(false);
        btnSelectP3.setContentAreaFilled(false);
        btnSelectP3.setFocusPainted(false);
        btnSelectP3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectP3ActionPerformed(evt);
            }
        });
        pnlJogadores.add(btnSelectP3, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 170, -1, -1));

        btnSelectP4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Luigi-por.gif"))); // NOI18N
        btnSelectP4.setBorderPainted(false);
        btnSelectP4.setContentAreaFilled(false);
        btnSelectP4.setFocusPainted(false);
        btnSelectP4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectP4ActionPerformed(evt);
            }
        });
        pnlJogadores.add(btnSelectP4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 350, -1, -1));

        btnSelectP5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Peach-por.gif"))); // NOI18N
        btnSelectP5.setBorderPainted(false);
        btnSelectP5.setContentAreaFilled(false);
        btnSelectP5.setFocusPainted(false);
        btnSelectP5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectP5ActionPerformed(evt);
            }
        });
        pnlJogadores.add(btnSelectP5, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 350, -1, -1));

        btnSelectP6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Yoshi-por.gif"))); // NOI18N
        btnSelectP6.setBorderPainted(false);
        btnSelectP6.setContentAreaFilled(false);
        btnSelectP6.setFocusPainted(false);
        btnSelectP6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectP6ActionPerformed(evt);
            }
        });
        pnlJogadores.add(btnSelectP6, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 350, -1, -1));

        btnSelectP7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Dk-por.gif"))); // NOI18N
        btnSelectP7.setBorderPainted(false);
        btnSelectP7.setContentAreaFilled(false);
        btnSelectP7.setFocusPainted(false);
        btnSelectP7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectP7ActionPerformed(evt);
            }
        });
        pnlJogadores.add(btnSelectP7, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 530, -1, -1));

        btnSelectP8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Samuel-por.gif"))); // NOI18N
        btnSelectP8.setBorderPainted(false);
        btnSelectP8.setContentAreaFilled(false);
        btnSelectP8.setFocusPainted(false);
        btnSelectP8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectP8ActionPerformed(evt);
            }
        });
        pnlJogadores.add(btnSelectP8, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 530, -1, -1));

        btnSelectP9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Didi-por.gif"))); // NOI18N
        btnSelectP9.setBorderPainted(false);
        btnSelectP9.setContentAreaFilled(false);
        btnSelectP9.setFocusPainted(false);
        btnSelectP9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectP9ActionPerformed(evt);
            }
        });
        pnlJogadores.add(btnSelectP9, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 530, -1, -1));

        pnlSelecionado.setBackground(new java.awt.Color(255, 255, 102));
        pnlSelecionado.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblPlayer.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        lblPlayer.setText("Jogador 1 (você):");
        pnlSelecionado.add(lblPlayer, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        lblVelocidade.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        lblVelocidade.setText("Velocidade:");
        pnlSelecionado.add(lblVelocidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, -1, -1));

        lblManobrabilidade.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        lblManobrabilidade.setText("Manobrabilidade:");
        pnlSelecionado.add(lblManobrabilidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, -1, -1));

        lblPoder.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        lblPoder.setText("Poder:");
        pnlSelecionado.add(lblPoder, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, -1, -1));
        pnlSelecionado.add(lblImagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 310));

        lblNome.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        pnlSelecionado.add(lblNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 280, 20));

        btnIniciar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/startRoad.png"))); // NOI18N
        btnIniciar.setContentAreaFilled(false);
        btnIniciar.setFocusable(false);
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });
        pnlSelecionado.add(btnIniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 480, 190, 80));

        pnlJogadores.add(pnlSelecionado, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, 590));

        btnP1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mario.gif"))); // NOI18N
        btnP1.setBorderPainted(false);
        btnP1.setContentAreaFilled(false);
        btnP1.setFocusPainted(false);
        btnP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnP1ActionPerformed(evt);
            }
        });
        pnlJogadores.add(btnP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 30, -1, -1));

        btnP4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/luigi.gif"))); // NOI18N
        btnP4.setBorderPainted(false);
        btnP4.setContentAreaFilled(false);
        btnP4.setFocusPainted(false);
        btnP4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnP4ActionPerformed(evt);
            }
        });
        pnlJogadores.add(btnP4, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 200, -1, -1));

        btnP2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bowser.gif"))); // NOI18N
        btnP2.setBorderPainted(false);
        btnP2.setContentAreaFilled(false);
        btnP2.setFocusPainted(false);
        btnP2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnP2ActionPerformed(evt);
            }
        });
        pnlJogadores.add(btnP2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 20, -1, -1));

        btnP7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dk.gif"))); // NOI18N
        btnP7.setBorderPainted(false);
        btnP7.setContentAreaFilled(false);
        btnP7.setFocusPainted(false);
        btnP7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnP7ActionPerformed(evt);
            }
        });
        pnlJogadores.add(btnP7, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 380, -1, -1));

        btnP5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/peach.gif"))); // NOI18N
        btnP5.setBorderPainted(false);
        btnP5.setContentAreaFilled(false);
        btnP5.setFocusPainted(false);
        btnP5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnP5ActionPerformed(evt);
            }
        });
        pnlJogadores.add(btnP5, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 200, -1, -1));

        btnP3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/toad.gif"))); // NOI18N
        btnP3.setBorderPainted(false);
        btnP3.setContentAreaFilled(false);
        btnP3.setFocusPainted(false);
        btnP3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnP3ActionPerformed(evt);
            }
        });
        pnlJogadores.add(btnP3, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 20, -1, -1));

        btnP6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/yoshi.gif"))); // NOI18N
        btnP6.setBorderPainted(false);
        btnP6.setContentAreaFilled(false);
        btnP6.setFocusPainted(false);
        btnP6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnP6ActionPerformed(evt);
            }
        });
        pnlJogadores.add(btnP6, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 200, -1, -1));

        btnP8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cadeado.png"))); // NOI18N
        btnP8.setBorderPainted(false);
        btnP8.setContentAreaFilled(false);
        btnP8.setFocusPainted(false);
        btnP8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnP8ActionPerformed(evt);
            }
        });
        pnlJogadores.add(btnP8, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 380, 170, 160));

        btnP9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cadeado.png"))); // NOI18N
        btnP9.setBorderPainted(false);
        btnP9.setContentAreaFilled(false);
        btnP9.setFocusPainted(false);
        btnP9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnP9ActionPerformed(evt);
            }
        });
        pnlJogadores.add(btnP9, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 380, 150, 160));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlJogadores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlJogadores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSelectP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectP1ActionPerformed
        btnP1ActionPerformed(evt);
        int resposta = JOptionPane.showConfirmDialog(null, "Você quer mesmo jogar com "+personagemList.get(0).getNome()+"?", "Confirmar Jogador", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(resposta == JOptionPane.YES_OPTION){
            btnP1ActionPerformed(evt);
            jog1 = personagemList.get(0);
            JOptionPane.showMessageDialog(null,"Personagem "+jog1.getNome()+" escolhido!");
            if(FrmJogadores.pts>=3){
                jog2 = sorteiaJogBotB(personagemList, jog1);
                if(FrmJogadores.pts>=4)
                    jog2 = sorteiaJogBotC(personagemList, jog1);
            }
            else
                jog2 = sorteiaJogBotA(personagemList, jog1);
            somPlayer2(jog2);
            lblPlayer.setText("Jogador 2 (computador):");
            visualizarPlayer(lblPlayer, lblImagem, lblNome, lblVelocidade, lblManobrabilidade, lblPoder, jog2.getId()-1);
            JOptionPane.showMessageDialog(null,"O computador irá jogar como "+jog2.getNome()+"!");
            desabilitaBotoes(btnIniciar, btnP1, btnP2, btnP3, btnP4, btnP5, btnP6, btnP7, btnP8, btnP9, btnSelectP1, btnSelectP2, btnSelectP3, btnSelectP4, btnSelectP5, btnSelectP6, btnSelectP7, btnSelectP8, btnSelectP9);
        }
        else if(resposta == JOptionPane.NO_OPTION){
            JOptionPane.showMessageDialog(null,"Escolha novamente.");
        }
    }//GEN-LAST:event_btnSelectP1ActionPerformed

    private void btnSelectP2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectP2ActionPerformed
        btnP2ActionPerformed(evt);
        int resposta = JOptionPane.showConfirmDialog(null, "Você quer mesmo jogar com "+personagemList.get(1).getNome()+"?", "Confirmar Jogador", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(resposta == JOptionPane.YES_OPTION){
            btnP2ActionPerformed(evt);
            jog1 = personagemList.get(1);
            JOptionPane.showMessageDialog(null,"Personagem "+jog1.getNome()+" escolhido!");
            if(FrmJogadores.pts>=3){
                jog2 = sorteiaJogBotB(personagemList, jog1);
                if(FrmJogadores.pts>=4)
                    jog2 = sorteiaJogBotC(personagemList, jog1);
            }
            else
                jog2 = sorteiaJogBotA(personagemList, jog1);
            somPlayer2(jog2);
            lblPlayer.setText("Jogador 2 (computador):");
            visualizarPlayer(lblPlayer, lblImagem, lblNome, lblVelocidade, lblManobrabilidade, lblPoder, jog2.getId()-1);
            JOptionPane.showMessageDialog(null,"O computador irá jogar como "+jog2.getNome()+"!");
            desabilitaBotoes(btnIniciar, btnP1, btnP2, btnP3, btnP4, btnP5, btnP6, btnP7, btnP8, btnP9, btnSelectP1, btnSelectP2, btnSelectP3, btnSelectP4, btnSelectP5, btnSelectP6, btnSelectP7, btnSelectP8, btnSelectP9);
        }
        else if(resposta == JOptionPane.NO_OPTION){
            JOptionPane.showMessageDialog(null,"Escolha novamente.");
        }
    }//GEN-LAST:event_btnSelectP2ActionPerformed

    private void btnSelectP3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectP3ActionPerformed
        btnP3ActionPerformed(evt);
        int resposta = JOptionPane.showConfirmDialog(null, "Você quer mesmo jogar com "+personagemList.get(2).getNome()+"?", "Confirmar Jogador", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(resposta == JOptionPane.YES_OPTION){
            btnP3ActionPerformed(evt);
            jog1 = personagemList.get(2);
            JOptionPane.showMessageDialog(null,"Personagem "+jog1.getNome()+" escolhido!");
            if(FrmJogadores.pts>=3){
                jog2 = sorteiaJogBotB(personagemList, jog1);
                if(FrmJogadores.pts>=4)
                    jog2 = sorteiaJogBotC(personagemList, jog1);
            }
            else
                jog2 = sorteiaJogBotA(personagemList, jog1);
            somPlayer2(jog2);
            lblPlayer.setText("Jogador 2 (computador):");
            visualizarPlayer(lblPlayer, lblImagem, lblNome, lblVelocidade, lblManobrabilidade, lblPoder, jog2.getId()-1);
            JOptionPane.showMessageDialog(null,"O computador irá jogar como "+jog2.getNome()+"!");
            desabilitaBotoes(btnIniciar, btnP1, btnP2, btnP3, btnP4, btnP5, btnP6, btnP7, btnP8, btnP9, btnSelectP1, btnSelectP2, btnSelectP3, btnSelectP4, btnSelectP5, btnSelectP6, btnSelectP7, btnSelectP8, btnSelectP9);
        }
        else if(resposta == JOptionPane.NO_OPTION){
            JOptionPane.showMessageDialog(null,"Escolha novamente.");
        }
    }//GEN-LAST:event_btnSelectP3ActionPerformed

    private void btnSelectP4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectP4ActionPerformed
        btnP4ActionPerformed(evt);
        int resposta = JOptionPane.showConfirmDialog(null, "Você quer mesmo jogar com "+personagemList.get(3).getNome()+"?", "Confirmar Jogador", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(resposta == JOptionPane.YES_OPTION){
            btnP4ActionPerformed(evt);
            jog1 = personagemList.get(3);
            JOptionPane.showMessageDialog(null,"Personagem "+jog1.getNome()+" escolhido!");
            if(FrmJogadores.pts>=3){
                jog2 = sorteiaJogBotB(personagemList, jog1);
                if(FrmJogadores.pts>=4)
                    jog2 = sorteiaJogBotC(personagemList, jog1);
            }
            else
                jog2 = sorteiaJogBotA(personagemList, jog1);
            somPlayer2(jog2);
            lblPlayer.setText("Jogador 2 (computador):");
            visualizarPlayer(lblPlayer, lblImagem, lblNome, lblVelocidade, lblManobrabilidade, lblPoder, jog2.getId()-1);
            JOptionPane.showMessageDialog(null,"O computador irá jogar como "+jog2.getNome()+"!");
            desabilitaBotoes(btnIniciar, btnP1, btnP2, btnP3, btnP4, btnP5, btnP6, btnP7, btnP8, btnP9, btnSelectP1, btnSelectP2, btnSelectP3, btnSelectP4, btnSelectP5, btnSelectP6, btnSelectP7, btnSelectP8, btnSelectP9);
        }
        else if(resposta == JOptionPane.NO_OPTION){
            JOptionPane.showMessageDialog(null,"Escolha novamente.");
        }
    }//GEN-LAST:event_btnSelectP4ActionPerformed

    private void btnSelectP5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectP5ActionPerformed
        btnP5ActionPerformed(evt);
        int resposta = JOptionPane.showConfirmDialog(null, "Você quer mesmo jogar com "+personagemList.get(4).getNome()+"?", "Confirmar Jogador", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(resposta == JOptionPane.YES_OPTION){
            btnP5ActionPerformed(evt);
            jog1 = personagemList.get(4);
            JOptionPane.showMessageDialog(null,"Personagem "+jog1.getNome()+" escolhido!");
            if(FrmJogadores.pts>=3){
                jog2 = sorteiaJogBotB(personagemList, jog1);
                if(FrmJogadores.pts>=4)
                    jog2 = sorteiaJogBotC(personagemList, jog1);
            }
            else
                jog2 = sorteiaJogBotA(personagemList, jog1);
            somPlayer2(jog2);
            lblPlayer.setText("Jogador 2 (computador):");
            visualizarPlayer(lblPlayer, lblImagem, lblNome, lblVelocidade, lblManobrabilidade, lblPoder, jog2.getId()-1);
            JOptionPane.showMessageDialog(null,"O computador irá jogar como "+jog2.getNome()+"!");
            desabilitaBotoes(btnIniciar, btnP1, btnP2, btnP3, btnP4, btnP5, btnP6, btnP7, btnP8, btnP9, btnSelectP1, btnSelectP2, btnSelectP3, btnSelectP4, btnSelectP5, btnSelectP6, btnSelectP7, btnSelectP8, btnSelectP9);
        }
        else if(resposta == JOptionPane.NO_OPTION){
            JOptionPane.showMessageDialog(null,"Escolha novamente.");
        }
    }//GEN-LAST:event_btnSelectP5ActionPerformed

    private void btnSelectP6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectP6ActionPerformed
        btnP6ActionPerformed(evt);
        int resposta = JOptionPane.showConfirmDialog(null, "Você quer mesmo jogar com "+personagemList.get(5).getNome()+"?", "Confirmar Jogador", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(resposta == JOptionPane.YES_OPTION){
            btnP6ActionPerformed(evt);
            jog1 = personagemList.get(5);
            JOptionPane.showMessageDialog(null,"Personagem "+jog1.getNome()+" escolhido!");
            if(FrmJogadores.pts>=3){
                jog2 = sorteiaJogBotB(personagemList, jog1);
                if(FrmJogadores.pts>=4)
                    jog2 = sorteiaJogBotC(personagemList, jog1);
            }
            else
                jog2 = sorteiaJogBotA(personagemList, jog1);
            somPlayer2(jog2);
            lblPlayer.setText("Jogador 2 (computador):");
            visualizarPlayer(lblPlayer, lblImagem, lblNome, lblVelocidade, lblManobrabilidade, lblPoder, jog2.getId()-1);
            JOptionPane.showMessageDialog(null,"O computador irá jogar como "+jog2.getNome()+"!");
            desabilitaBotoes(btnIniciar, btnP1, btnP2, btnP3, btnP4, btnP5, btnP6, btnP7, btnP8, btnP9, btnSelectP1, btnSelectP2, btnSelectP3, btnSelectP4, btnSelectP5, btnSelectP6, btnSelectP7, btnSelectP8, btnSelectP9);
        }
        else if(resposta == JOptionPane.NO_OPTION){
            JOptionPane.showMessageDialog(null,"Escolha novamente.");
        }
    }//GEN-LAST:event_btnSelectP6ActionPerformed

    private void btnSelectP7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectP7ActionPerformed
        btnP7ActionPerformed(evt);
        int resposta = JOptionPane.showConfirmDialog(null, "Você quer mesmo jogar com "+personagemList.get(6).getNome()+"?", "Confirmar Jogador", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(resposta == JOptionPane.YES_OPTION){
            btnP7ActionPerformed(evt);
            jog1 = personagemList.get(6);
            JOptionPane.showMessageDialog(null,"Personagem "+jog1.getNome()+" escolhido!");
            if(FrmJogadores.pts>=3){
                jog2 = sorteiaJogBotB(personagemList, jog1);
                if(FrmJogadores.pts>=4)
                    jog2 = sorteiaJogBotC(personagemList, jog1);
            }
            else
                jog2 = sorteiaJogBotA(personagemList, jog1);
            somPlayer2(jog2);
            lblPlayer.setText("Jogador 2 (computador):");
            visualizarPlayer(lblPlayer, lblImagem, lblNome, lblVelocidade, lblManobrabilidade, lblPoder, jog2.getId()-1);
            JOptionPane.showMessageDialog(null,"O computador irá jogar como "+jog2.getNome()+"!");
            desabilitaBotoes(btnIniciar, btnP1, btnP2, btnP3, btnP4, btnP5, btnP6, btnP7, btnP8, btnP9, btnSelectP1, btnSelectP2, btnSelectP3, btnSelectP4, btnSelectP5, btnSelectP6, btnSelectP7, btnSelectP8, btnSelectP9);
        }
        else if(resposta == JOptionPane.NO_OPTION){
            JOptionPane.showMessageDialog(null,"Escolha novamente.");
        }
    }//GEN-LAST:event_btnSelectP7ActionPerformed

    private void btnP7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnP7ActionPerformed
        try{
            AudioInputStream audio = AudioSystem.getAudioInputStream(new File("src/main/resources/audios/dk1.wav"));
            Clip dk1 = AudioSystem.getClip();
            dk1.open(audio);
            dk1.start();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro na leitura do arquivo.");
        }
        visualizarPlayer(lblPlayer, lblImagem, lblNome, lblVelocidade, lblManobrabilidade, lblPoder, 6);
    }//GEN-LAST:event_btnP7ActionPerformed

    private void btnP6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnP6ActionPerformed
        try{
            AudioInputStream audio = AudioSystem.getAudioInputStream(new File("src/main/resources/audios/yoshi1.wav"));
            Clip yoshi1 = AudioSystem.getClip();
            yoshi1.open(audio);
            yoshi1.start();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro na leitura do arquivo.");
        }
        visualizarPlayer(lblPlayer, lblImagem, lblNome, lblVelocidade, lblManobrabilidade, lblPoder, 5);
    }//GEN-LAST:event_btnP6ActionPerformed

    private void btnP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnP1ActionPerformed
        try{
            AudioInputStream audio = AudioSystem.getAudioInputStream(new File("src/main/resources/audios/mario1.wav"));
            Clip mario1 = AudioSystem.getClip();
            mario1.open(audio);
            mario1.start();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro na leitura do arquivo.");
        }
        visualizarPlayer(lblPlayer, lblImagem, lblNome, lblVelocidade, lblManobrabilidade, lblPoder, 0);
        
    }//GEN-LAST:event_btnP1ActionPerformed

    private void btnP4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnP4ActionPerformed
        try{
            AudioInputStream audio = AudioSystem.getAudioInputStream(new File("src/main/resources/audios/luigi1.wav"));
            Clip luigi1 = AudioSystem.getClip();
            luigi1.open(audio);
            luigi1.start();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro na leitura do arquivo.");
        }
        visualizarPlayer(lblPlayer, lblImagem, lblNome, lblVelocidade, lblManobrabilidade, lblPoder, 3);
    }//GEN-LAST:event_btnP4ActionPerformed

    private void btnP2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnP2ActionPerformed
        try{
            AudioInputStream audio = AudioSystem.getAudioInputStream(new File("src/main/resources/audios/bowser.wav"));
            Clip bowser = AudioSystem.getClip();
            bowser.open(audio);
            bowser.start();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro na leitura do arquivo.");
        }
        visualizarPlayer(lblPlayer, lblImagem, lblNome, lblVelocidade, lblManobrabilidade, lblPoder, 1);
    }//GEN-LAST:event_btnP2ActionPerformed

    private void btnP5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnP5ActionPerformed
        try{
            AudioInputStream audio = AudioSystem.getAudioInputStream(new File("src/main/resources/audios/peach1.wav"));
            Clip peach1 = AudioSystem.getClip();
            peach1.open(audio);
            peach1.start();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro na leitura do arquivo.");
        }
        visualizarPlayer(lblPlayer, lblImagem, lblNome, lblVelocidade, lblManobrabilidade, lblPoder, 4);
    }//GEN-LAST:event_btnP5ActionPerformed

    private void btnSelectP8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectP8ActionPerformed
        btnP8ActionPerformed(evt);
        if(FrmJogadores.pts>=3){
            int resposta = JOptionPane.showConfirmDialog(null, "Você quer mesmo jogar com "+personagemList.get(7).getNome()+"?", "Confirmar Jogador", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(resposta == JOptionPane.YES_OPTION){
                try{
                    AudioInputStream audio = AudioSystem.getAudioInputStream(new File("src/main/resources/audios/samuel-por/escolha.wav"));
                    Clip escolha = AudioSystem.getClip();
                    escolha.open(audio);
                    escolha.start();
                }
                catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Erro na leitura do arquivo.");
                }
                jog1 = personagemList.get(7);
                JOptionPane.showMessageDialog(null,"Personagem "+jog1.getNome()+" escolhido!");
                if(FrmJogadores.pts>=4)
                    jog2 = sorteiaJogBotC(personagemList, jog1);
                else
                    jog2 = sorteiaJogBotB(personagemList, jog1);
                somPlayer2(jog2);
                lblPlayer.setText("Jogador 2 (computador):");
                visualizarPlayer(lblPlayer, lblImagem, lblNome, lblVelocidade, lblManobrabilidade, lblPoder, jog2.getId()-1);
                JOptionPane.showMessageDialog(null,"O computador irá jogar como "+jog2.getNome()+"!");
                desabilitaBotoes(btnIniciar, btnP1, btnP2, btnP3, btnP4, btnP5, btnP6, btnP7, btnP8, btnP9, btnSelectP1, btnSelectP2, btnSelectP3, btnSelectP4, btnSelectP5, btnSelectP6, btnSelectP7, btnSelectP8, btnSelectP9);
            }
            else if(resposta == JOptionPane.NO_OPTION){
                JOptionPane.showMessageDialog(null,"Escolha novamente.");
            }
        }
        else
            JOptionPane.showMessageDialog(null,"Personagem bloqueado, ganhe três partidas para desbloqueá-lo!");
    }//GEN-LAST:event_btnSelectP8ActionPerformed

    private void btnSelectP9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectP9ActionPerformed
        btnP9ActionPerformed(evt);
        if(FrmJogadores.pts>=4){
            int resposta = JOptionPane.showConfirmDialog(null, "Você quer mesmo jogar com "+personagemList.get(8).getNome()+"?", "Confirmar Jogador", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(resposta == JOptionPane.YES_OPTION){
                try{
                    AudioInputStream audio = AudioSystem.getAudioInputStream(new File("src/main/resources/audios/didi/mer-por.wav"));
                    Clip didiins = AudioSystem.getClip();
                    didiins.open(audio);
                    didiins.start();
                }
                catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Erro na leitura do arquivo.");
                }
                jog1 = personagemList.get(8);
                JOptionPane.showMessageDialog(null,"Personagem "+jog1.getNome()+" escolhido!");
                jog2 = sorteiaJogBotC(personagemList, jog1);
                somPlayer2(jog2);
                lblPlayer.setText("Jogador 2 (computador):");
                visualizarPlayer(lblPlayer, lblImagem, lblNome, lblVelocidade, lblManobrabilidade, lblPoder, jog2.getId()-1);
                JOptionPane.showMessageDialog(null,"O computador irá jogar como "+jog2.getNome()+"!");
                desabilitaBotoes(btnIniciar, btnP1, btnP2, btnP3, btnP4, btnP5, btnP6, btnP7, btnP8, btnP9, btnSelectP1, btnSelectP2, btnSelectP3, btnSelectP4, btnSelectP5, btnSelectP6, btnSelectP7, btnSelectP8, btnSelectP9);
            }
            else if(resposta == JOptionPane.NO_OPTION){
                JOptionPane.showMessageDialog(null,"Escolha novamente.");
            }
        }
        else if(FrmJogadores.pts==3){
            JOptionPane.showMessageDialog(null,"Personagem bloqueado, ganhe uma partida com Samuel para desbloqueá-lo!");
        }
        else
            JOptionPane.showMessageDialog(null,"Personagem bloqueado!");
    }//GEN-LAST:event_btnSelectP9ActionPerformed

    private void btnP8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnP8ActionPerformed
        lblImagem.setVisible(true);
        if(FrmJogadores.pts>=3){
            try{
                AudioInputStream audio = AudioSystem.getAudioInputStream(new File("src/main/resources/audios/samuel-por/melhor.wav"));
                Clip melhor = AudioSystem.getClip();
                melhor.open(audio);
                melhor.start();
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Erro na leitura do arquivo.");
            }
            visualizarPlayer(lblPlayer, lblImagem, lblNome, lblVelocidade, lblManobrabilidade, lblPoder, 7);
        }
        else{
            ImageIcon icon = new ImageIcon("src/main/resources/characters/bloqueado.png");
            lblImagem.setIcon(icon);
            lblNome.setText("?");
            lblVelocidade.setText("Velocidade: ?");
            lblManobrabilidade.setText("Manobrabilidade: ?");
            lblPoder.setText("Poder: ?");
        }
        lblPlayer.setVisible(true);
        lblNome.setVisible(true);
        lblVelocidade.setVisible(true);
        lblManobrabilidade.setVisible(true);
        lblPoder.setVisible(true);
    }//GEN-LAST:event_btnP8ActionPerformed

    private void btnP9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnP9ActionPerformed
        lblImagem.setVisible(true);
        if(FrmJogadores.pts>=4){
            try{
                AudioInputStream audio = AudioSystem.getAudioInputStream(new File("src/main/resources/audios/didi/ins-por.wav"));
                Clip didiins = AudioSystem.getClip();
                didiins.open(audio);
                didiins.start();
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Erro na leitura do arquivo.");
            }
            visualizarPlayer(lblPlayer, lblImagem, lblNome, lblVelocidade, lblManobrabilidade, lblPoder, 8);
        }
        else{
            ImageIcon icon = new ImageIcon("src/main/resources/characters/bloqueado.png");
            lblImagem.setIcon(icon);
            lblNome.setText("?");
            lblVelocidade.setText("Velocidade: ?");
            lblManobrabilidade.setText("Manobrabilidade: ?");
            lblPoder.setText("Poder: ?");
        }
        lblPlayer.setVisible(true);
        lblNome.setVisible(true);
        lblVelocidade.setVisible(true);
        lblManobrabilidade.setVisible(true);
        lblPoder.setVisible(true);
    }//GEN-LAST:event_btnP9ActionPerformed

    private void btnP3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnP3ActionPerformed
        try{
            AudioInputStream audio = AudioSystem.getAudioInputStream(new File("src/main/resources/audios/toad1.wav"));
            Clip toad1 = AudioSystem.getClip();
            toad1.open(audio);
            toad1.start();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro na leitura do arquivo.");
        }
        visualizarPlayer(lblPlayer, lblImagem, lblNome, lblVelocidade, lblManobrabilidade, lblPoder, 2);
    }//GEN-LAST:event_btnP3ActionPerformed

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
        new FrmRodada(FrmJogadores.quantVitorias, FrmJogadores.idPartida, FrmJogadores.pts).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnIniciarActionPerformed
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmJogadores(FrmJogadores.quantVitorias, FrmJogadores.idPartida, FrmJogadores.pts, jog1, jog2).setVisible(true);
                
            }
            
        });
    }
    private static void somPlayer2(Personagem jog2){
        try{
            AudioInputStream audio;
            if("Mario".equals(jog2.getNome()))
                audio = AudioSystem.getAudioInputStream(new File("src/main/resources/audios/mario1.wav"));
            else if("Bowser".equals(jog2.getNome()))
                audio = AudioSystem.getAudioInputStream(new File("src/main/resources/audios/bowser.wav"));
            else if("Toad".equals(jog2.getNome()))
                audio = AudioSystem.getAudioInputStream(new File("src/main/resources/audios/toad1.wav"));
            else if("Luigi".equals(jog2.getNome()))
                audio = AudioSystem.getAudioInputStream(new File("src/main/resources/audios/luigi1.wav"));
            else if("Peach".equals(jog2.getNome()))
                audio = AudioSystem.getAudioInputStream(new File("src/main/resources/audios/peach1.wav"));
            else if("Yoshi".equals(jog2.getNome()))
                audio = AudioSystem.getAudioInputStream(new File("src/main/resources/audios/yoshi1.wav"));
            else if("Donkey Kong".equals(jog2.getNome()))
                audio = AudioSystem.getAudioInputStream(new File("src/main/resources/audios/dk1.wav"));
            else if("Samuel".equals(jog2.getNome()))
                audio = AudioSystem.getAudioInputStream(new File("src/main/resources/audios/samuel-por/estouaqui.wav"));
            else
                audio = AudioSystem.getAudioInputStream(new File("src/main/resources/audios/didi/mer-por.wav"));
            Clip player2 = AudioSystem.getClip();
            player2.open(audio);
            player2.start();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro na leitura do arquivo.");
        }
    }
    private static void visualizarPlayer(javax.swing.JLabel lblPlayer, javax.swing.JLabel lblImagem, javax.swing.JLabel lblNome, javax.swing.JLabel lblVelocidade, javax.swing.JLabel lblManobrabilidade, javax.swing.JLabel lblPoder, int id){
        ImageIcon icon = new ImageIcon(personagemList.get(id).getImagem());
        lblImagem.setIcon(icon);
        lblImagem.setVisible(true);
        lblPlayer.setVisible(true);
        lblNome.setVisible(true);
        lblVelocidade.setVisible(true);
        lblManobrabilidade.setVisible(true);
        lblPoder.setVisible(true);
        lblNome.setText(personagemList.get(id).getNome());
        lblVelocidade.setText("Velocidade: "+personagemList.get(id).getVelocidade());
        lblManobrabilidade.setText("Manobrabilidade: "+personagemList.get(id).getManobrabilidade());
        lblPoder.setText("Poder: "+personagemList.get(id).getPoder());
    }
    private static void desabilitaBotoes(javax.swing.JButton btnIniciar, javax.swing.JButton btnP1, javax.swing.JButton btnP2, javax.swing.JButton btnP3, javax.swing.JButton btnP4, javax.swing.JButton btnP5, javax.swing.JButton btnP6, javax.swing.JButton btnP7, javax.swing.JButton btnP8, javax.swing.JButton btnP9, javax.swing.JButton btnSelectP1, javax.swing.JButton btnSelectP2, javax.swing.JButton btnSelectP3, javax.swing.JButton btnSelectP4, javax.swing.JButton btnSelectP5, javax.swing.JButton btnSelectP6, javax.swing.JButton btnSelectP7, javax.swing.JButton btnSelectP8, javax.swing.JButton btnSelectP9){
        btnSelectP1.setEnabled(false);
        btnSelectP2.setEnabled(false);
        btnSelectP3.setEnabled(false);
        btnSelectP4.setEnabled(false);
        btnSelectP5.setEnabled(false);
        btnSelectP6.setEnabled(false);
        btnSelectP7.setEnabled(false);
        btnSelectP8.setEnabled(false);
        btnSelectP9.setEnabled(false);
        btnP1.setEnabled(false);
        btnP2.setEnabled(false);
        btnP3.setEnabled(false);
        btnP4.setEnabled(false);
        btnP5.setEnabled(false);
        btnP6.setEnabled(false);
        btnP7.setEnabled(false);
        btnP8.setEnabled(false);
        btnP9.setEnabled(false);
        btnIniciar.setVisible(true);
        btnIniciar.setEnabled(true);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciar;
    private javax.swing.JButton btnP1;
    private javax.swing.JButton btnP2;
    private javax.swing.JButton btnP3;
    private javax.swing.JButton btnP4;
    private javax.swing.JButton btnP5;
    private javax.swing.JButton btnP6;
    private javax.swing.JButton btnP7;
    private javax.swing.JButton btnP8;
    private javax.swing.JButton btnP9;
    private javax.swing.JButton btnSelectP1;
    private javax.swing.JButton btnSelectP2;
    private javax.swing.JButton btnSelectP3;
    private javax.swing.JButton btnSelectP4;
    private javax.swing.JButton btnSelectP5;
    private javax.swing.JButton btnSelectP6;
    private javax.swing.JButton btnSelectP7;
    private javax.swing.JButton btnSelectP8;
    private javax.swing.JButton btnSelectP9;
    private javax.swing.JLabel lblImagem;
    private javax.swing.JLabel lblManobrabilidade;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblPlayer;
    private javax.swing.JLabel lblPoder;
    private javax.swing.JLabel lblVelocidade;
    private javax.swing.JPanel pnlJogadores;
    private javax.swing.JPanel pnlSelecionado;
    // End of variables declaration//GEN-END:variables
}
