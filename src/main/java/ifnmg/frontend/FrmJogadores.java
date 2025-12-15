/*
Frame da tela de seleção de personagens
@author arthurpereira
@author athossilvano
@author samuelmiranda
*/
package ifnmg.frontend;
import ifnmg.backend.Personagem;
import ifnmg.backend.Rodada;
import static ifnmg.backend.Api.criaRodada;
import static ifnmg.backend.Api.csvToList;
import static ifnmg.backend.Api.executaRodada;
import static ifnmg.backend.Api.jogaDado;
import static ifnmg.backend.Api.sorteiaJogBotA;
import static ifnmg.backend.Api.sorteiaJogBotB;
import static ifnmg.backend.Api.sorteiaJogBotC;
import static ifnmg.backend.Api.sorteiaPista;
import static ifnmg.backend.Api.sorteiaRodadas;
import static ifnmg.backend.Api.vencedor;
import static ifnmg.backend.Api.zeraPontos;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
public class FrmJogadores extends javax.swing.JFrame {
    public static Personagem jog1=null, jog2=null;
    private static List<Personagem> personagemList = new ArrayList<>();
    public FrmJogadores() {
        try{
            personagemList = csvToList("data/tabela-personagens.csv");
            initComponents();
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
        btnP8lock = new javax.swing.JButton();
        btnP9lock = new javax.swing.JButton();

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

        btnSelectP8.setText("Selecionar");
        btnSelectP8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectP8ActionPerformed(evt);
            }
        });
        pnlJogadores.add(btnSelectP8, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 530, -1, -1));

        btnSelectP9.setText("Selecionar");
        btnSelectP9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectP9ActionPerformed(evt);
            }
        });
        pnlJogadores.add(btnSelectP9, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 530, -1, -1));

        pnlSelecionado.setBackground(new java.awt.Color(255, 255, 102));
        pnlSelecionado.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblPlayer.setFont(new java.awt.Font("Showcard Gothic", 1, 18)); // NOI18N
        lblPlayer.setText("Jogador 1 (você):");
        pnlSelecionado.add(lblPlayer, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        lblVelocidade.setFont(new java.awt.Font("Showcard Gothic", 1, 18)); // NOI18N
        lblVelocidade.setText("Velocidade:");
        pnlSelecionado.add(lblVelocidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, -1, -1));

        lblManobrabilidade.setFont(new java.awt.Font("Showcard Gothic", 1, 18)); // NOI18N
        lblManobrabilidade.setText("Manobrabilidade:");
        pnlSelecionado.add(lblManobrabilidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, -1, -1));

        lblPoder.setFont(new java.awt.Font("Showcard Gothic", 1, 18)); // NOI18N
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

        btnP8lock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cadeado.png"))); // NOI18N
        btnP8lock.setBorderPainted(false);
        btnP8lock.setContentAreaFilled(false);
        btnP8lock.setFocusPainted(false);
        btnP8lock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnP8lockActionPerformed(evt);
            }
        });
        pnlJogadores.add(btnP8lock, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 410, -1, -1));

        btnP9lock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cadeado.png"))); // NOI18N
        btnP9lock.setBorderPainted(false);
        btnP9lock.setContentAreaFilled(false);
        btnP9lock.setFocusPainted(false);
        btnP9lock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnP9lockActionPerformed(evt);
            }
        });
        pnlJogadores.add(btnP9lock, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 410, -1, -1));

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
            jog1 = personagemList.get(0);
            JOptionPane.showMessageDialog(null,"Personagem "+jog1.getNome()+" escolhido!");
            jog2 = sorteiaJogBotA(personagemList, jog1);
            ImageIcon icon = new ImageIcon(jog2.getImagem());
            lblPlayer.setVisible(true);
            lblNome.setVisible(true);
            lblImagem.setVisible(true);
            lblVelocidade.setVisible(true);
            lblManobrabilidade.setVisible(true);
            lblPoder.setVisible(true);
            lblImagem.setIcon(icon);
            lblPlayer.setText("Jogador 2 (computador):");
            lblNome.setText(jog2.getNome());
            lblVelocidade.setText("Velocidade: "+jog2.getVelocidade());
            lblManobrabilidade.setText("Manobrabilidade: "+jog2.getManobrabilidade());
            lblPoder.setText("Poder: "+jog2.getPoder());
            JOptionPane.showMessageDialog(null,"O computador irá jogar como "+jog2.getNome()+"!");
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
            btnP8lock.setEnabled(false);
            btnP9lock.setEnabled(false);
            btnIniciar.setVisible(true);
            btnIniciar.setEnabled(true);
        }
        else if(resposta == JOptionPane.NO_OPTION){
            JOptionPane.showMessageDialog(null,"Escolha novamente.");
        }
    }//GEN-LAST:event_btnSelectP1ActionPerformed

    private void btnSelectP2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectP2ActionPerformed
        btnP2ActionPerformed(evt);
        int resposta = JOptionPane.showConfirmDialog(null, "Você quer mesmo jogar com "+personagemList.get(1).getNome()+"?", "Confirmar Jogador", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(resposta == JOptionPane.YES_OPTION){
            jog1 = personagemList.get(1);
            JOptionPane.showMessageDialog(null,"Personagem "+jog1.getNome()+" escolhido!");
            jog2 = sorteiaJogBotA(personagemList, jog1);
            ImageIcon icon = new ImageIcon(jog2.getImagem());
            lblPlayer.setVisible(true);
            lblNome.setVisible(true);
            lblImagem.setVisible(true);
            lblVelocidade.setVisible(true);
            lblManobrabilidade.setVisible(true);
            lblPoder.setVisible(true);
            lblImagem.setIcon(icon);
            lblPlayer.setText("Jogador 2 (computador):");
            lblNome.setText(jog2.getNome());
            lblVelocidade.setText("Velocidade: "+jog2.getVelocidade());
            lblManobrabilidade.setText("Manobrabilidade: "+jog2.getManobrabilidade());
            lblPoder.setText("Poder: "+jog2.getPoder());
            JOptionPane.showMessageDialog(null,"O computador irá jogar como "+jog2.getNome()+"!");
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
            btnP8lock.setEnabled(false);
            btnP9lock.setEnabled(false);
            btnIniciar.setVisible(true);
            btnIniciar.setEnabled(true);
        }
        else if(resposta == JOptionPane.NO_OPTION){
            JOptionPane.showMessageDialog(null,"Escolha novamente.");
        }
    }//GEN-LAST:event_btnSelectP2ActionPerformed

    private void btnSelectP3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectP3ActionPerformed
        btnP3ActionPerformed(evt);
        int resposta = JOptionPane.showConfirmDialog(null, "Você quer mesmo jogar com "+personagemList.get(2).getNome()+"?", "Confirmar Jogador", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(resposta == JOptionPane.YES_OPTION){
            jog1 = personagemList.get(2);
            JOptionPane.showMessageDialog(null,"Personagem "+jog1.getNome()+" escolhido!");
            jog2 = sorteiaJogBotA(personagemList, jog1);
            ImageIcon icon = new ImageIcon(jog2.getImagem());
            lblPlayer.setVisible(true);
            lblNome.setVisible(true);
            lblImagem.setVisible(true);
            lblVelocidade.setVisible(true);
            lblManobrabilidade.setVisible(true);
            lblPoder.setVisible(true);
            lblImagem.setIcon(icon);
            lblPlayer.setText("Jogador 2 (computador):");
            lblNome.setText(jog2.getNome());
            lblVelocidade.setText("Velocidade: "+jog2.getVelocidade());
            lblManobrabilidade.setText("Manobrabilidade: "+jog2.getManobrabilidade());
            lblPoder.setText("Poder: "+jog2.getPoder());
            JOptionPane.showMessageDialog(null,"O computador irá jogar como "+jog2.getNome()+"!");
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
            btnP8lock.setEnabled(false);
            btnP9lock.setEnabled(false);
            btnIniciar.setVisible(true);
            btnIniciar.setEnabled(true);
        }
        else if(resposta == JOptionPane.NO_OPTION){
            JOptionPane.showMessageDialog(null,"Escolha novamente.");
        }
    }//GEN-LAST:event_btnSelectP3ActionPerformed

    private void btnSelectP4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectP4ActionPerformed
        btnP4ActionPerformed(evt);
        int resposta = JOptionPane.showConfirmDialog(null, "Você quer mesmo jogar com "+personagemList.get(3).getNome()+"?", "Confirmar Jogador", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(resposta == JOptionPane.YES_OPTION){
            jog1 = personagemList.get(3);
            JOptionPane.showMessageDialog(null,"Personagem "+jog1.getNome()+" escolhido!");
            jog2 = sorteiaJogBotA(personagemList, jog1);
            ImageIcon icon = new ImageIcon(jog2.getImagem());
            lblPlayer.setVisible(true);
            lblNome.setVisible(true);
            lblImagem.setVisible(true);
            lblVelocidade.setVisible(true);
            lblManobrabilidade.setVisible(true);
            lblPoder.setVisible(true);
            lblImagem.setIcon(icon);
            lblPlayer.setText("Jogador 2 (computador):");
            lblNome.setText(jog2.getNome());
            lblVelocidade.setText("Velocidade: "+jog2.getVelocidade());
            lblManobrabilidade.setText("Manobrabilidade: "+jog2.getManobrabilidade());
            lblPoder.setText("Poder: "+jog2.getPoder());
            JOptionPane.showMessageDialog(null,"O computador irá jogar como "+jog2.getNome()+"!");
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
            btnP8lock.setEnabled(false);
            btnP9lock.setEnabled(false);
            btnIniciar.setVisible(true);
            btnIniciar.setEnabled(true);
        }
        else if(resposta == JOptionPane.NO_OPTION){
            JOptionPane.showMessageDialog(null,"Escolha novamente.");
        }
    }//GEN-LAST:event_btnSelectP4ActionPerformed

    private void btnSelectP5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectP5ActionPerformed
        btnP5ActionPerformed(evt);
        int resposta = JOptionPane.showConfirmDialog(null, "Você quer mesmo jogar com "+personagemList.get(4).getNome()+"?", "Confirmar Jogador", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(resposta == JOptionPane.YES_OPTION){
            jog1 = personagemList.get(4);
            JOptionPane.showMessageDialog(null,"Personagem "+jog1.getNome()+" escolhido!");
            jog2 = sorteiaJogBotA(personagemList, jog1);
            ImageIcon icon = new ImageIcon(jog2.getImagem());
            lblPlayer.setVisible(true);
            lblNome.setVisible(true);
            lblImagem.setVisible(true);
            lblVelocidade.setVisible(true);
            lblManobrabilidade.setVisible(true);
            lblPoder.setVisible(true);
            lblImagem.setIcon(icon);
            lblPlayer.setText("Jogador 2 (computador):");
            lblNome.setText(jog2.getNome());
            lblVelocidade.setText("Velocidade: "+jog2.getVelocidade());
            lblManobrabilidade.setText("Manobrabilidade: "+jog2.getManobrabilidade());
            lblPoder.setText("Poder: "+jog2.getPoder());
            JOptionPane.showMessageDialog(null,"O computador irá jogar como "+jog2.getNome()+"!");
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
            btnP8lock.setEnabled(false);
            btnP9lock.setEnabled(false);
            btnIniciar.setVisible(true);
            btnIniciar.setEnabled(true);
        }
        else if(resposta == JOptionPane.NO_OPTION){
            JOptionPane.showMessageDialog(null,"Escolha novamente.");
        }
    }//GEN-LAST:event_btnSelectP5ActionPerformed

    private void btnSelectP6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectP6ActionPerformed
        btnP6ActionPerformed(evt);
        int resposta = JOptionPane.showConfirmDialog(null, "Você quer mesmo jogar com "+personagemList.get(5).getNome()+"?", "Confirmar Jogador", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(resposta == JOptionPane.YES_OPTION){
            jog1 = personagemList.get(5);
            JOptionPane.showMessageDialog(null,"Personagem "+jog1.getNome()+" escolhido!");
            jog2 = sorteiaJogBotA(personagemList, jog1);
            ImageIcon icon = new ImageIcon(jog2.getImagem());
            lblPlayer.setVisible(true);
            lblNome.setVisible(true);
            lblImagem.setVisible(true);
            lblVelocidade.setVisible(true);
            lblManobrabilidade.setVisible(true);
            lblPoder.setVisible(true);
            lblImagem.setIcon(icon);
            lblPlayer.setText("Jogador 2 (computador):");
            lblNome.setText(jog2.getNome());
            lblVelocidade.setText("Velocidade: "+jog2.getVelocidade());
            lblManobrabilidade.setText("Manobrabilidade: "+jog2.getManobrabilidade());
            lblPoder.setText("Poder: "+jog2.getPoder());
            JOptionPane.showMessageDialog(null,"O computador irá jogar como "+jog2.getNome()+"!");
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
            btnP8lock.setEnabled(false);
            btnP9lock.setEnabled(false);
            btnIniciar.setVisible(true);
            btnIniciar.setEnabled(true);
        }
        else if(resposta == JOptionPane.NO_OPTION){
            JOptionPane.showMessageDialog(null,"Escolha novamente.");
        }
    }//GEN-LAST:event_btnSelectP6ActionPerformed

    private void btnSelectP7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectP7ActionPerformed
        btnP7ActionPerformed(evt);
        int resposta = JOptionPane.showConfirmDialog(null, "Você quer mesmo jogar com "+personagemList.get(6).getNome()+"?", "Confirmar Jogador", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(resposta == JOptionPane.YES_OPTION){
            jog1 = personagemList.get(6);
            JOptionPane.showMessageDialog(null,"Personagem "+jog1.getNome()+" escolhido!");
            jog2 = sorteiaJogBotA(personagemList, jog1);
            ImageIcon icon = new ImageIcon(jog2.getImagem());
            lblPlayer.setVisible(true);
            lblNome.setVisible(true);
            lblImagem.setVisible(true);
            lblVelocidade.setVisible(true);
            lblManobrabilidade.setVisible(true);
            lblPoder.setVisible(true);
            lblImagem.setIcon(icon);
            lblPlayer.setText("Jogador 2 (computador):");
            lblNome.setText(jog2.getNome());
            lblVelocidade.setText("Velocidade: "+jog2.getVelocidade());
            lblManobrabilidade.setText("Manobrabilidade: "+jog2.getManobrabilidade());
            lblPoder.setText("Poder: "+jog2.getPoder());
            JOptionPane.showMessageDialog(null,"O computador irá jogar como "+jog2.getNome()+"!");
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
            btnP8lock.setEnabled(false);
            btnP9lock.setEnabled(false);
            btnIniciar.setVisible(true);
            btnIniciar.setEnabled(true);
        }
        else if(resposta == JOptionPane.NO_OPTION){
            JOptionPane.showMessageDialog(null,"Escolha novamente.");
        }
    }//GEN-LAST:event_btnSelectP7ActionPerformed

    private void btnP7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnP7ActionPerformed
        lblImagem.setVisible(true);
        ImageIcon icon = new ImageIcon(personagemList.get(6).getImagem());
        lblImagem.setIcon(icon);
        lblPlayer.setVisible(true);
        lblNome.setVisible(true);
        lblVelocidade.setVisible(true);
        lblManobrabilidade.setVisible(true);
        lblPoder.setVisible(true);
        lblNome.setText(personagemList.get(6).getNome());
        lblVelocidade.setText("Velocidade: "+personagemList.get(6).getVelocidade());
        lblManobrabilidade.setText("Manobrabilidade: "+personagemList.get(6).getManobrabilidade());
        lblPoder.setText("Poder: "+personagemList.get(6).getPoder());
    }//GEN-LAST:event_btnP7ActionPerformed

    private void btnP6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnP6ActionPerformed
        lblImagem.setVisible(true);
        ImageIcon icon = new ImageIcon(personagemList.get(5).getImagem());
        lblImagem.setIcon(icon);
        lblPlayer.setVisible(true);
        lblNome.setVisible(true);
        lblVelocidade.setVisible(true);
        lblManobrabilidade.setVisible(true);
        lblPoder.setVisible(true);
        lblNome.setText(personagemList.get(5).getNome());
        lblVelocidade.setText("Velocidade: "+personagemList.get(5).getVelocidade());
        lblManobrabilidade.setText("Manobrabilidade: "+personagemList.get(5).getManobrabilidade());
        lblPoder.setText("Poder: "+personagemList.get(5).getPoder());
    }//GEN-LAST:event_btnP6ActionPerformed

    private void btnP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnP1ActionPerformed
        lblImagem.setVisible(true);
        ImageIcon icon = new ImageIcon(personagemList.get(0).getImagem());
        lblImagem.setIcon(icon);
        lblPlayer.setVisible(true);
        lblNome.setVisible(true);
        lblVelocidade.setVisible(true);
        lblManobrabilidade.setVisible(true);
        lblPoder.setVisible(true);
        lblNome.setText(personagemList.get(0).getNome());
        lblVelocidade.setText("Velocidade: "+personagemList.get(0).getVelocidade());
        lblManobrabilidade.setText("Manobrabilidade: "+personagemList.get(0).getManobrabilidade());
        lblPoder.setText("Poder: "+personagemList.get(0).getPoder());
    }//GEN-LAST:event_btnP1ActionPerformed

    private void btnP4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnP4ActionPerformed
        lblImagem.setVisible(true);
        ImageIcon icon = new ImageIcon(personagemList.get(3).getImagem());
        lblImagem.setIcon(icon);
        lblPlayer.setVisible(true);
        lblNome.setVisible(true);
        lblVelocidade.setVisible(true);
        lblManobrabilidade.setVisible(true);
        lblPoder.setVisible(true);
        lblNome.setText(personagemList.get(3).getNome());
        lblVelocidade.setText("Velocidade: "+personagemList.get(3).getVelocidade());
        lblManobrabilidade.setText("Manobrabilidade: "+personagemList.get(3).getManobrabilidade());
        lblPoder.setText("Poder: "+personagemList.get(3).getPoder());
    }//GEN-LAST:event_btnP4ActionPerformed

    private void btnP2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnP2ActionPerformed
        lblImagem.setVisible(true);
        ImageIcon icon = new ImageIcon(personagemList.get(1).getImagem());
        lblImagem.setIcon(icon);
        lblPlayer.setVisible(true);
        lblNome.setVisible(true);
        lblVelocidade.setVisible(true);
        lblManobrabilidade.setVisible(true);
        lblPoder.setVisible(true);
        lblNome.setText(personagemList.get(1).getNome());
        lblVelocidade.setText("Velocidade: "+personagemList.get(1).getVelocidade());
        lblManobrabilidade.setText("Manobrabilidade: "+personagemList.get(1).getManobrabilidade());
        lblPoder.setText("Poder: "+personagemList.get(1).getPoder());
    }//GEN-LAST:event_btnP2ActionPerformed

    private void btnP5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnP5ActionPerformed
        lblImagem.setVisible(true);
        ImageIcon icon = new ImageIcon(personagemList.get(4).getImagem());
        lblImagem.setIcon(icon);
        lblPlayer.setVisible(true);
        lblNome.setVisible(true);
        lblVelocidade.setVisible(true);
        lblManobrabilidade.setVisible(true);
        lblPoder.setVisible(true);
        lblNome.setText(personagemList.get(4).getNome());
        lblVelocidade.setText("Velocidade: "+personagemList.get(4).getVelocidade());
        lblManobrabilidade.setText("Manobrabilidade: "+personagemList.get(4).getManobrabilidade());
        lblPoder.setText("Poder: "+personagemList.get(4).getPoder());
    }//GEN-LAST:event_btnP5ActionPerformed

    private void btnSelectP8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectP8ActionPerformed
        btnP8lockActionPerformed(evt);
        JOptionPane.showMessageDialog(null,"Personagem bloqueado, ganhe três partidas para desbloqueá-lo!");
    }//GEN-LAST:event_btnSelectP8ActionPerformed

    private void btnSelectP9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectP9ActionPerformed
        btnP9lockActionPerformed(evt);
        JOptionPane.showMessageDialog(null,"Personagem bloqueado!");
    }//GEN-LAST:event_btnSelectP9ActionPerformed

    private void btnP8lockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnP8lockActionPerformed
        lblImagem.setVisible(true);
        ImageIcon icon = new ImageIcon("src/main/resources/characters/bloqueado.png");
        lblImagem.setIcon(icon);
        lblPlayer.setVisible(true);
        lblNome.setVisible(true);
        lblVelocidade.setVisible(true);
        lblManobrabilidade.setVisible(true);
        lblPoder.setVisible(true);
        lblNome.setText("?");
        lblVelocidade.setText("Velocidade: ?");
        lblManobrabilidade.setText("Manobrabilidade: ?");
        lblPoder.setText("Poder: ?");
    }//GEN-LAST:event_btnP8lockActionPerformed

    private void btnP9lockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnP9lockActionPerformed
        lblImagem.setVisible(true);
        ImageIcon icon = new ImageIcon("src/main/resources/characters/bloqueado.png");
        lblImagem.setIcon(icon);
        lblPlayer.setVisible(true);
        lblNome.setVisible(true);
        lblVelocidade.setVisible(true);
        lblManobrabilidade.setVisible(true);
        lblPoder.setVisible(true);
        lblNome.setText("?");
        lblVelocidade.setText("Velocidade: ?");
        lblManobrabilidade.setText("Manobrabilidade: ?");
        lblPoder.setText("Poder: ?");
    }//GEN-LAST:event_btnP9lockActionPerformed

    private void btnP3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnP3ActionPerformed
        lblImagem.setVisible(true);
        ImageIcon icon = new ImageIcon(personagemList.get(2).getImagem());
        lblImagem.setIcon(icon);
        lblPlayer.setVisible(true);
        lblNome.setVisible(true);
        lblVelocidade.setVisible(true);
        lblManobrabilidade.setVisible(true);
        lblPoder.setVisible(true);
        lblNome.setText(personagemList.get(2).getNome());
        lblVelocidade.setText("Velocidade: "+personagemList.get(2).getVelocidade());
        lblManobrabilidade.setText("Manobrabilidade: "+personagemList.get(2).getManobrabilidade());
        lblPoder.setText("Poder: "+personagemList.get(2).getPoder());
    }//GEN-LAST:event_btnP3ActionPerformed

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
        new FrmRodada().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnIniciarActionPerformed
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmJogadores().setVisible(true);
                
            }
            
        });
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
    private javax.swing.JButton btnP8lock;
    private javax.swing.JButton btnP9lock;
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
