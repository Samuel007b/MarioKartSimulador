/*
Frame da tela de sorteio de atributos do Jogo das Estrelas (espanhol)
@author arthurpereira
@author athossilvano
@author samuelmiranda
*/
package ifnmg.frontend.spanishVersion;

import static ifnmg.backend.Api.csvToList;
import static ifnmg.backend.Api.jogaDado;
import ifnmg.backend.Personagem;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class FrmJugsJuegoEstrellas extends javax.swing.JFrame {
    public static Clip jogStar;
    private static int vitoriasLeo;
    private static int vitoriasCaio;
    private static int idPartida;
    public static Personagem jog1, jog2;
    private static List<Personagem> personagemList = new ArrayList<>();
    public FrmJugsJuegoEstrellas(int vitoriasLeo, int vitoriasCaio, int idPartida) {
        try{
            AudioInputStream audio = AudioSystem.getAudioInputStream(new File("src/main/resources/audios/musicaJogoEstrelas.wav"));
            jogStar = AudioSystem.getClip();
            jogStar.open(audio);
            jogStar.start();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro na leitura do arquivo.");
        }
        FrmJugsJuegoEstrellas.idPartida=idPartida+1;
        FrmJugsJuegoEstrellas.vitoriasLeo=vitoriasLeo;
        FrmJugsJuegoEstrellas.vitoriasCaio=vitoriasCaio;
        initComponents();
        this.setLocationRelativeTo(null);
        try{
            personagemList = csvToList("data/tabela-personagens.csv");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro na leitura do arquivo.");
        }
        jog1 = personagemList.get(9);
        jog2 = personagemList.get(10);
        exibeSeta(0, lblSeta1, lblSeta2, lblSeta3, lblSeta4, lblSeta5, lblSeta6);
        btnDado2.setEnabled(false);
        btnIniciar.setEnabled(false);
        JOptionPane.showMessageDialog(null, "Comece sorteando a velocidade de Léo.");
        lblSorteio.setText("Sorteie a velocidade de Léo!");
        exibeSeta(1, lblSeta1, lblSeta2, lblSeta3, lblSeta4, lblSeta5, lblSeta6);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlJogsJogoEstrelas = new javax.swing.JPanel();
        btnIniciar = new javax.swing.JButton();
        pnlLeo = new javax.swing.JPanel();
        lblVelocidade1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblPlayer1 = new javax.swing.JLabel();
        lblPoder1 = new javax.swing.JLabel();
        lblManobrabilidade1 = new javax.swing.JLabel();
        lblLeoIcon = new javax.swing.JLabel();
        lblSeta1 = new javax.swing.JLabel();
        lblSeta2 = new javax.swing.JLabel();
        lblSeta3 = new javax.swing.JLabel();
        pnlCaio = new javax.swing.JPanel();
        lblPoder2 = new javax.swing.JLabel();
        lblManobrabilidade2 = new javax.swing.JLabel();
        lblVelocidade2 = new javax.swing.JLabel();
        lblPlayer2 = new javax.swing.JLabel();
        lblCaioIcon = new javax.swing.JLabel();
        lblSeta4 = new javax.swing.JLabel();
        lblSeta5 = new javax.swing.JLabel();
        lblSeta6 = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        lblDado1 = new javax.swing.JLabel();
        lblDado2 = new javax.swing.JLabel();
        btnDado2 = new javax.swing.JButton();
        btnDado1 = new javax.swing.JButton();
        lblSorteio = new javax.swing.JLabel();
        lblFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlJogsJogoEstrelas.setBackground(new java.awt.Color(51, 0, 51));
        pnlJogsJogoEstrelas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnIniciar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/startRoad.png"))); // NOI18N
        btnIniciar.setContentAreaFilled(false);
        btnIniciar.setFocusable(false);
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });
        pnlJogsJogoEstrelas.add(btnIniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 470, 190, 80));

        pnlLeo.setBackground(new java.awt.Color(97, 163, 233));
        pnlLeo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblVelocidade1.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        lblVelocidade1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVelocidade1.setText("Velocidade: ?");
        pnlLeo.add(lblVelocidade1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 270, -1));
        pnlLeo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        lblPlayer1.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        lblPlayer1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPlayer1.setText("Jogador 1: Léo");
        pnlLeo.add(lblPlayer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 270, -1));

        lblPoder1.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        lblPoder1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPoder1.setText("Poder: ?");
        pnlLeo.add(lblPoder1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, 270, -1));

        lblManobrabilidade1.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        lblManobrabilidade1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblManobrabilidade1.setText("Manobrabilidade: ?");
        pnlLeo.add(lblManobrabilidade1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 450, 270, -1));

        lblLeoIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLeoIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/characters/leoM.gif"))); // NOI18N
        pnlLeo.add(lblLeoIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 90, 260, -1));

        lblSeta1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSeta1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/seta.gif"))); // NOI18N
        pnlLeo.add(lblSeta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 60, 20));

        lblSeta2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSeta2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/seta.gif"))); // NOI18N
        pnlLeo.add(lblSeta2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 450, 60, 20));

        lblSeta3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSeta3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/seta.gif"))); // NOI18N
        pnlLeo.add(lblSeta3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 500, 60, 20));

        pnlJogsJogoEstrelas.add(pnlLeo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 590));

        pnlCaio.setBackground(new java.awt.Color(44, 195, 185));
        pnlCaio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblPoder2.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        lblPoder2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPoder2.setText("Poder: ?");
        pnlCaio.add(lblPoder2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, 270, -1));

        lblManobrabilidade2.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        lblManobrabilidade2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblManobrabilidade2.setText("Manobrabilidade: ?");
        pnlCaio.add(lblManobrabilidade2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 450, 270, -1));

        lblVelocidade2.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        lblVelocidade2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVelocidade2.setText("Velocidade: ?");
        pnlCaio.add(lblVelocidade2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 270, -1));

        lblPlayer2.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        lblPlayer2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPlayer2.setText("Jogador 2: Caio");
        pnlCaio.add(lblPlayer2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 270, -1));

        lblCaioIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCaioIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/characters/caioM.gif"))); // NOI18N
        pnlCaio.add(lblCaioIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 90, 260, -1));

        lblSeta4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSeta4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/seta.gif"))); // NOI18N
        pnlCaio.add(lblSeta4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 60, 20));

        lblSeta5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSeta5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/seta.gif"))); // NOI18N
        pnlCaio.add(lblSeta5, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 450, 60, 20));

        lblSeta6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSeta6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/seta.gif"))); // NOI18N
        pnlCaio.add(lblSeta6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 500, 60, 20));

        pnlJogsJogoEstrelas.add(pnlCaio, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 0, 270, 590));

        lblTitulo.setFont(new java.awt.Font("Showcard Gothic", 0, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 0, 0));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Sorteie os atributos de Léo e Caio!");
        pnlJogsJogoEstrelas.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(267, 30, 500, -1));

        lblDado1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDado1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dado.gif"))); // NOI18N
        pnlJogsJogoEstrelas.add(lblDado1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 190, 180, 160));

        lblDado2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDado2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dado.gif"))); // NOI18N
        pnlJogsJogoEstrelas.add(lblDado2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 190, 180, 160));

        btnDado2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttons/playDado.gif"))); // NOI18N
        btnDado2.setBorderPainted(false);
        btnDado2.setContentAreaFilled(false);
        btnDado2.setFocusPainted(false);
        btnDado2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDado2ActionPerformed(evt);
            }
        });
        pnlJogsJogoEstrelas.add(btnDado2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 350, 120, 40));

        btnDado1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttons/playDado.gif"))); // NOI18N
        btnDado1.setBorderPainted(false);
        btnDado1.setContentAreaFilled(false);
        btnDado1.setFocusPainted(false);
        btnDado1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDado1ActionPerformed(evt);
            }
        });
        pnlJogsJogoEstrelas.add(btnDado1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 350, 120, 40));

        lblSorteio.setFont(new java.awt.Font("Showcard Gothic", 2, 14)); // NOI18N
        lblSorteio.setForeground(new java.awt.Color(255, 255, 0));
        lblSorteio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSorteio.setText("Sorteio de Atributo");
        pnlJogsJogoEstrelas.add(lblSorteio, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, 510, -1));

        lblFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/galaxia.jpg"))); // NOI18N
        pnlJogsJogoEstrelas.add(lblFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlJogsJogoEstrelas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlJogsJogoEstrelas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
        new FrmRondaJuegoEstrellas(FrmJugsJuegoEstrellas.vitoriasLeo, FrmJugsJuegoEstrellas.vitoriasCaio, FrmJugsJuegoEstrellas.idPartida).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnIniciarActionPerformed

    private void btnDado1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDado1ActionPerformed
        int dado;
        if(jog1.getVelocidade()==0){
            btnDado1.setEnabled(false);
            dado = jogaDado();
            trocaDado(dado, lblDado1);
            jog1.setVelocidade(dado);
            lblVelocidade1.setText("Velocidade: "+jog1.getVelocidade());
            lblSorteio.setText("Sorteie a manobrabilidade de Léo!");
            exibeSeta(2, lblSeta1, lblSeta2, lblSeta3, lblSeta4, lblSeta5, lblSeta6);
            JOptionPane.showMessageDialog(null, "A velocidade sorteada para Léo foi "+jog1.getVelocidade()+"! Agora sorteie sua manobrabilidade.");
            btnDado1.setEnabled(true);
            trocaDado(0, lblDado1);
        }
        else if(jog1.getManobrabilidade()==0){
            btnDado1.setEnabled(false);
            dado = jogaDado();
            trocaDado(dado, lblDado1);
            jog1.setManobrabilidade(dado);
            lblManobrabilidade1.setText("Manobrabilidade: "+jog1.getManobrabilidade());
            lblSorteio.setText("Sorteie o poder de Léo!");
            exibeSeta(3, lblSeta1, lblSeta2, lblSeta3, lblSeta4, lblSeta5, lblSeta6);
            JOptionPane.showMessageDialog(null, "A manobrabilidade sorteada para Léo foi "+jog1.getManobrabilidade()+"! Agora sorteie seu poder.");
            btnDado1.setEnabled(true);
            trocaDado(0, lblDado1);
        }
        else{
            btnDado1.setEnabled(false);
            dado = jogaDado();
            trocaDado(dado, lblDado1);
            jog1.setPoder(dado);
            lblPoder1.setText("Poder: "+jog1.getPoder());
            lblSorteio.setText("Sorteie a velocidade de Caio!");
            exibeSeta(4, lblSeta1, lblSeta2, lblSeta3, lblSeta4, lblSeta5, lblSeta6);
            JOptionPane.showMessageDialog(null, "O poder sorteado para Léo foi "+jog1.getPoder()+"! Agora sorteie os atributos de Caio, começando por sua velocidade.");
            btnDado2.setEnabled(true);
            trocaDado(0, lblDado1);
        }
    }//GEN-LAST:event_btnDado1ActionPerformed

    private void btnDado2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDado2ActionPerformed
        int dado;
        if(jog2.getVelocidade()==0){
            btnDado2.setEnabled(false);
            dado = jogaDado();
            trocaDado(dado, lblDado2);
            jog2.setVelocidade(dado);
            lblVelocidade2.setText("Velocidade: "+jog2.getVelocidade());
            lblSorteio.setText("Sorteie a manobrabilidade de Caio!");
            exibeSeta(5, lblSeta1, lblSeta2, lblSeta3, lblSeta4, lblSeta5, lblSeta6);
            JOptionPane.showMessageDialog(null, "A velocidade sorteada para Caio foi "+jog2.getVelocidade()+"! Agora sorteie sua manobrabilidade.");
            btnDado2.setEnabled(true);
            trocaDado(0, lblDado2);
        }
        else if(jog2.getManobrabilidade()==0){
            btnDado2.setEnabled(false);
            dado = jogaDado();
            trocaDado(dado, lblDado2);
            jog2.setManobrabilidade(dado);
            lblSorteio.setText("Sorteie o poder de Caio!");
            exibeSeta(6, lblSeta1, lblSeta2, lblSeta3, lblSeta4, lblSeta5, lblSeta6);
            lblManobrabilidade2.setText("Manobrabilidade: "+jog2.getManobrabilidade());
            JOptionPane.showMessageDialog(null, "A manobrabilidade sorteada para Caio foi "+jog2.getManobrabilidade()+"! Agora sorteie seu poder.");
            btnDado2.setEnabled(true);
            trocaDado(0, lblDado2);
        }
        else{
            btnDado2.setEnabled(false);
            dado = jogaDado();
            trocaDado(dado, lblDado2);
            jog2.setPoder(dado);
            lblPoder2.setText("Poder: "+jog2.getPoder());
            lblSorteio.setText("Sorteio concluído!");
            exibeSeta(0, lblSeta1, lblSeta2, lblSeta3, lblSeta4, lblSeta5, lblSeta6);
            JOptionPane.showMessageDialog(null, "O poder sorteado para Caio foi "+jog2.getPoder()+"! Clique em START para começar a Jogo das Estrelas!");
            trocaDado(0, lblDado2);
            btnIniciar.setEnabled(true);
        }
    }//GEN-LAST:event_btnDado2ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmJugsJuegoEstrellas(FrmJugsJuegoEstrellas.vitoriasLeo, FrmJugsJuegoEstrellas.vitoriasCaio, FrmJugsJuegoEstrellas.idPartida).setVisible(true);
            }
        });
    }
    private static void exibeSeta(int a, javax.swing.JLabel lblSeta1, javax.swing.JLabel lblSeta2, javax.swing.JLabel lblSeta3, javax.swing.JLabel lblSeta4, javax.swing.JLabel lblSeta5, javax.swing.JLabel lblSeta6){
        lblSeta1.setVisible(false);
        lblSeta2.setVisible(false);
        lblSeta3.setVisible(false);
        lblSeta4.setVisible(false);
        lblSeta5.setVisible(false);
        lblSeta6.setVisible(false);
        switch(a){
            case 1:
                lblSeta1.setVisible(true);
                break;
            case 2:
                lblSeta2.setVisible(true);
                break;
            case 3:
                lblSeta3.setVisible(true);
                break;
            case 4:
                lblSeta4.setVisible(true);
                break;
            case 5:
                lblSeta5.setVisible(true);
                break;
            case 6:
                lblSeta6.setVisible(true);
                break;
            default:
                break;
        }
    }
    private static void trocaDado(int dado, javax.swing.JLabel lblDado){
        ImageIcon d0 = new ImageIcon("src/main/resources/dado.gif");
        ImageIcon d1 = new ImageIcon("src/main/resources/dado1.png");
        ImageIcon d2 = new ImageIcon("src/main/resources/dado2.png");
        ImageIcon d3 = new ImageIcon("src/main/resources/dado3.png");
        ImageIcon d4 = new ImageIcon("src/main/resources/dado4.png");
        ImageIcon d5 = new ImageIcon("src/main/resources/dado5.png");
        ImageIcon d6 = new ImageIcon("src/main/resources/dado6.png");
        switch(dado){
            case 0:
                lblDado.setIcon(d0);
                break;
            case 1:
                lblDado.setIcon(d1);
                break;
            case 2:
                lblDado.setIcon(d2);
                break;
            case 3:
                lblDado.setIcon(d3);
                break;
            case 4:
                lblDado.setIcon(d4);
                break;
            case 5:
                lblDado.setIcon(d5);
                break;
            case 6:
                lblDado.setIcon(d6);
                break;
            default:
                break;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDado1;
    private javax.swing.JButton btnDado2;
    private javax.swing.JButton btnIniciar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblCaioIcon;
    private javax.swing.JLabel lblDado1;
    private javax.swing.JLabel lblDado2;
    private javax.swing.JLabel lblFundo;
    private javax.swing.JLabel lblLeoIcon;
    private javax.swing.JLabel lblManobrabilidade1;
    private javax.swing.JLabel lblManobrabilidade2;
    private javax.swing.JLabel lblPlayer1;
    private javax.swing.JLabel lblPlayer2;
    private javax.swing.JLabel lblPoder1;
    private javax.swing.JLabel lblPoder2;
    private javax.swing.JLabel lblSeta1;
    private javax.swing.JLabel lblSeta2;
    private javax.swing.JLabel lblSeta3;
    private javax.swing.JLabel lblSeta4;
    private javax.swing.JLabel lblSeta5;
    private javax.swing.JLabel lblSeta6;
    private javax.swing.JLabel lblSorteio;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblVelocidade1;
    private javax.swing.JLabel lblVelocidade2;
    private javax.swing.JPanel pnlCaio;
    private javax.swing.JPanel pnlJogsJogoEstrelas;
    private javax.swing.JPanel pnlLeo;
    // End of variables declaration//GEN-END:variables
}
