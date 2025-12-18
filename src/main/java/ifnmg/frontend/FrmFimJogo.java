/*
Frame da tela final do jogo
@author arthurpereira
@author athossilvano
@author samuelmiranda
*/
package ifnmg.frontend;

import static ifnmg.backend.Api.vencedor;
import ifnmg.backend.Personagem;
import static ifnmg.frontend.FrmJogadores.jog1;
import static ifnmg.frontend.FrmJogadores.jog2;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class FrmFimJogo extends javax.swing.JFrame {
    private static int quantVitorias;
    private static final ImageIcon mario = new ImageIcon("src/main/resources/characters/marioM.gif");
    private static final ImageIcon bowser = new ImageIcon("src/main/resources/characters/bowserM.gif");
    private static final ImageIcon toad = new ImageIcon("src/main/resources/characters/toadM.gif");
    private static final ImageIcon luigi = new ImageIcon("src/main/resources/characters/luigiM.gif");
    private static final ImageIcon peach = new ImageIcon("src/main/resources/characters/peachM.gif");
    private static final ImageIcon yoshi = new ImageIcon("src/main/resources/characters/yoshiM.gif");
    private static final ImageIcon dk = new ImageIcon("src/main/resources/characters/dkM.gif");
    private static final ImageIcon samuel = new ImageIcon("src/main/resources/characters/samuelM.gif");
    private static final ImageIcon didi = new ImageIcon("src/main/resources/characters/didiM.gif");
    private static Personagem vencedor = null;
    public FrmFimJogo(int quantVitorias) {
        FrmFimJogo.quantVitorias=quantVitorias;
        initComponents();
        this.setLocationRelativeTo(null);
        vencedor = vencedor(jog1, jog2);
        if("Mario".equals(vencedor.getNome()))
            lblImagemVencedor.setIcon(mario);
        if("Bowser".equals(vencedor.getNome()))
            lblImagemVencedor.setIcon(bowser);
        if("Toad".equals(vencedor.getNome()))
            lblImagemVencedor.setIcon(toad);
        if("Luigi".equals(vencedor.getNome()))
            lblImagemVencedor.setIcon(luigi);
        if("Peach".equals(vencedor.getNome()))
            lblImagemVencedor.setIcon(peach);
        if("Yoshi".equals(vencedor.getNome()))
            lblImagemVencedor.setIcon(yoshi);
        if("Donkey Kong".equals(vencedor.getNome()))
            lblImagemVencedor.setIcon(dk);
        if("Samuel".equals(vencedor.getNome()))
            lblImagemVencedor.setIcon(samuel);
        if("Didi".equals(vencedor.getNome()))
            lblImagemVencedor.setIcon(didi);
        if(vencedor == jog1){
            lblVencedor.setText("O grande vencedor foi "+jog1.getNome()+"!!!");
            if(FrmFimJogo.quantVitorias<3){
                FrmFimJogo.quantVitorias++;
            }
            else if(quantVitorias==3 && "Samuel".equals(jog1.getNome())){
                FrmFimJogo.quantVitorias++;
            }
            else if(quantVitorias==4 && "Didi".equals(jog1.getNome())){
                JOptionPane.showMessageDialog(null, "Você zerou o jogo!!!");
                btnPlayAgain.setEnabled(false);
                btnPlayAgain.setVisible(false);
                FrmFimJogo.quantVitorias++;
            }
        }
        else if(vencedor == jog2){
            lblVencedor.setText("Infelizmente o vencedor foi "+jog2.getNome()+" ...");
            if(jog1.getNome()=="Didi"){
                JOptionPane.showMessageDialog(null, "Você fracassou...");
                btnPlayAgain.setEnabled(false);
                btnPlayAgain.setVisible(false);
            }
        }
        else{
            lblVencedor.setText("Houve um empate, "+jog1.getNome()+" e "+jog2.getNome()+" ficaram ambos com "+jog1.getPontos()+" ponto(s)!");
        }
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
        btnHistorico1.setActionCommand("Histórico desta Partida");
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
        pnlFimJogo.add(lblImagemVencedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, 320, 290));

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
            new FrmJogadores(FrmFimJogo.quantVitorias, jog1, jog2).setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnPlayAgainActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        int resposta = JOptionPane.showConfirmDialog(null, "Você quer sair do jogo?", "Encerrar Jogo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(resposta == JOptionPane.YES_OPTION){
            if(FrmFimJogo.quantVitorias==5)
                new FrmCreditos().setVisible(true);
            else
                this.dispose();
        }
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnHistorico1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistorico1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHistorico1ActionPerformed

    private void btnHistorico2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistorico2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHistorico2ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmFimJogo(FrmFimJogo.quantVitorias).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHistorico1;
    private javax.swing.JButton btnHistorico2;
    private javax.swing.JButton btnPlayAgain;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel lblImagemVencedor;
    private javax.swing.JLabel lblVencedor;
    private javax.swing.JPanel pnlFimJogo;
    // End of variables declaration//GEN-END:variables
}
