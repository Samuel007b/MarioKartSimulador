/*
Frame da tela de execução de rodada
@author arthurpereira
@author athossilvano
@author samuelmiranda
*/
package ifnmg.frontend;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import static ifnmg.backend.Api.criaRodada;
import static ifnmg.backend.Api.executaRodadaConfronto;
import static ifnmg.backend.Api.executaRodadaRetaCurva;
import static ifnmg.backend.Api.jogaDado;
import static ifnmg.backend.Api.sorteiaPista;
import static ifnmg.backend.Api.sorteiaRodadas;
import ifnmg.backend.Personagem;
import ifnmg.backend.Rodada;
import static ifnmg.frontend.FrmPlayers.jog1;
import static ifnmg.frontend.FrmPlayers.jog2;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class FrmRound extends javax.swing.JFrame {
    private static int quantVitorias;
    private static int idPartida;
    private static int pts;
    private static int quantRodadas, dado1, dado2, dado3;
    private static List<Rodada> rodadaList = new ArrayList<>();
    private String tipoPista;
    private Rodada rod;
    private int numRodada = 1;
    private final ImageIcon d0 = new ImageIcon("src/main/resources/dado.gif");
    private final ImageIcon reta = new ImageIcon("src/main/resources/PistaReta.png");
    private final ImageIcon curva = new ImageIcon("src/main/resources/PistaCurva.png");
    private final ImageIcon confronto = new ImageIcon("src/main/resources/PistaConfronto.png");
    public FrmRound(int quantVitorias, int idPartida, int pts) {
        rodadaList.clear();
        FrmRound.idPartida=idPartida;
        FrmRound.quantVitorias=quantVitorias;
        FrmRound.pts=pts;
        initComponents();
        this.setLocationRelativeTo(null);
        mostraEstrelas(0, lblJog1Star1, lblJog1Star2, lblJog1Star3, lblJog1Star4, lblJog1Star5, lblJog1Star6, lblJog1Star7, lblJog1Star8, lblJog1Star9, lblJog1Star10);
        mostraEstrelas(0, lblJog2Star1, lblJog2Star2, lblJog2Star3, lblJog2Star4, lblJog2Star5, lblJog2Star6, lblJog2Star7, lblJog2Star8, lblJog2Star9, lblJog2Star10);
        btnDado.setHorizontalAlignment(SwingConstants.CENTER);
        btnDado.setVerticalAlignment(SwingConstants.CENTER);
        btnDado3.setVisible(false);
        btnDado3.setEnabled(false);
        btnDado3.setHorizontalAlignment(SwingConstants.CENTER);
        btnDado3.setVerticalAlignment(SwingConstants.CENTER);
        btnProximo.setVisible(false);
        btnProximo.setEnabled(false);
        try{
            AudioInputStream audio = AudioSystem.getAudioInputStream(new File("src/main/resources/audios/iniciar.wav"));
            Clip iniciar = AudioSystem.getClip();
            iniciar.open(audio);
            iniciar.start();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error reading the file.");
        }
        String[] rodadas = {"5", "6", "7", "8", "9", "10", "Random"};
        JComboBox<String> comboBox = new JComboBox<>(rodadas);
        JPanel painel = new JPanel(new GridLayout(0, 1));
        painel.add(new JLabel("Choose the number of rounds:"));
        painel.add(comboBox);
        int resultado;
        do{
            resultado = JOptionPane.showConfirmDialog(null, painel, "Number of Rounds", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(resultado != JOptionPane.OK_OPTION)
                JOptionPane.showMessageDialog(null, "Set the number of rounds to proceed!");
        }while(resultado != JOptionPane.OK_OPTION);
        if(comboBox.getSelectedItem()=="Random"){
            quantRodadas = sorteiaRodadas();
            JOptionPane.showMessageDialog(null, quantRodadas + " rounds were drawn for the match!");
        }
        else{
            if(comboBox.getSelectedItem()=="5")
                quantRodadas=5;
            else if(comboBox.getSelectedItem()=="6")
                quantRodadas=6;
            else if(comboBox.getSelectedItem()=="7")
                quantRodadas=7;
            else if(comboBox.getSelectedItem()=="8")
                quantRodadas=8;
            if(comboBox.getSelectedItem()=="9")
                quantRodadas=9;
            if(comboBox.getSelectedItem()=="10")
                quantRodadas=10;
        }
        ImageIcon icon1 = new ImageIcon(jog1.getImagem());
        lblJog1Imagem.setIcon(icon1);
        lblJog1Imagem.setHorizontalAlignment(SwingConstants.CENTER);
        lblJog1Imagem.setVerticalAlignment(SwingConstants.CENTER);
        lblJog1Nome.setText("Player 1 (you): "+jog1.getNome());
        ImageIcon icon2 = new ImageIcon(jog2.getImagem());
        lblJog2Imagem.setIcon(icon2);
        lblJog2Imagem.setHorizontalAlignment(SwingConstants.CENTER);
        lblJog2Imagem.setVerticalAlignment(SwingConstants.CENTER);
        lblJog2Nome.setText("Player 2 (computer): "+jog2.getNome());
        lblDado1.setHorizontalAlignment(SwingConstants.CENTER);
        lblDado1.setVerticalAlignment(SwingConstants.CENTER);
        lblDado2.setHorizontalAlignment(SwingConstants.CENTER);
        lblDado2.setVerticalAlignment(SwingConstants.CENTER);
        iniciaRodada();
    }
    private void iniciaRodada() {
            btnDado.setVisible(true);
            btnDado.setEnabled(true);
            btnDado3.setVisible(false);
            btnDado3.setEnabled(false);
            btnProximo.setVisible(false);
            btnProximo.setEnabled(false);
            lblDado1.setIcon(d0);
            lblDado2.setIcon(d0);
            tipoPista = sorteiaPista();
            if(tipoPista=="RETA")
                tipoPista="STRAIGHT";
            else if(tipoPista=="CURVA")
                tipoPista="CURVE";
            else
                tipoPista="CONFRONTATION";
            rod = new Rodada(tipoPista, numRodada, jog1, jog2);
            if(numRodada==quantRodadas)
                lblRodada.setText("Round "+numRodada+" and final round: "+tipoPista+"!!!");
            else
                lblRodada.setText("Round "+numRodada+": "+tipoPista+"!");
            if(tipoPista=="STRAIGHT"){
                lblPista.setIcon(reta);
                lblJog1Atributo.setText("Speed: "+jog1.getVelocidade());
                lblJog2Atributo.setText("Speed: "+jog2.getVelocidade());
            }
            else if(tipoPista=="CURVE"){
                lblPista.setIcon(curva);
                lblJog1Atributo.setText("Maneuverability: "+jog1.getManobrabilidade());
                lblJog2Atributo.setText("Maneuverability: "+jog2.getManobrabilidade());
            }
            else{
                lblPista.setIcon(confronto);
                lblJog1Atributo.setText("Power: "+jog1.getPoder());
                lblJog2Atributo.setText("Power: "+jog2.getPoder());
            }
            JOptionPane.showMessageDialog(null,"The track drawn for round "+numRodada+" was "+tipoPista+"!");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlRodada = new javax.swing.JPanel();
        lblJog1Imagem = new javax.swing.JLabel();
        lblJog2Imagem = new javax.swing.JLabel();
        lblDado1 = new javax.swing.JLabel();
        lblDado2 = new javax.swing.JLabel();
        lblJog1Nome = new javax.swing.JLabel();
        lblJog2Nome = new javax.swing.JLabel();
        lblRodada = new javax.swing.JLabel();
        btnDado = new javax.swing.JButton();
        lblJog1Atributo = new javax.swing.JLabel();
        lblJog2Atributo = new javax.swing.JLabel();
        lblJog1Star1 = new javax.swing.JLabel();
        lblJog1Star2 = new javax.swing.JLabel();
        lblJog1Star3 = new javax.swing.JLabel();
        lblJog1Star4 = new javax.swing.JLabel();
        lblJog1Star5 = new javax.swing.JLabel();
        lblJog1Star6 = new javax.swing.JLabel();
        lblJog1Star7 = new javax.swing.JLabel();
        lblJog1Star8 = new javax.swing.JLabel();
        lblJog1Star9 = new javax.swing.JLabel();
        lblJog1Star10 = new javax.swing.JLabel();
        lblJog2Star1 = new javax.swing.JLabel();
        lblJog2Star2 = new javax.swing.JLabel();
        lblJog2Star3 = new javax.swing.JLabel();
        lblJog2Star4 = new javax.swing.JLabel();
        lblJog2Star5 = new javax.swing.JLabel();
        lblJog2Star6 = new javax.swing.JLabel();
        lblJog2Star7 = new javax.swing.JLabel();
        lblJog2Star8 = new javax.swing.JLabel();
        lblJog2Star9 = new javax.swing.JLabel();
        lblJog2Star10 = new javax.swing.JLabel();
        btnProximo = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnDado3 = new javax.swing.JButton();
        lblVS = new javax.swing.JLabel();
        lblRaio1 = new javax.swing.JLabel();
        lblRaio2 = new javax.swing.JLabel();
        lblPista = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlRodada.setBackground(new java.awt.Color(101, 178, 255));
        pnlRodada.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        pnlRodada.add(lblJog1Imagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 280, 280));
        pnlRodada.add(lblJog2Imagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 160, 280, 280));

        lblDado1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDado1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dado.gif"))); // NOI18N
        pnlRodada.add(lblDado1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 190, 160));

        lblDado2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDado2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dado.gif"))); // NOI18N
        pnlRodada.add(lblDado2, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 170, 190, 160));

        lblJog1Nome.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        lblJog1Nome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblJog1Nome.setText("Player 1 (You): ");
        lblJog1Nome.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnlRodada.add(lblJog1Nome, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 340, -1));

        lblJog2Nome.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        lblJog2Nome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblJog2Nome.setText("Player 2 (Computer): ");
        pnlRodada.add(lblJog2Nome, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 140, 340, -1));

        lblRodada.setFont(new java.awt.Font("Showcard Gothic", 2, 24)); // NOI18N
        lblRodada.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRodada.setText("Round:  ");
        pnlRodada.add(lblRodada, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 670, -1));

        btnDado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/playDado.gif"))); // NOI18N
        btnDado.setBorderPainted(false);
        btnDado.setContentAreaFilled(false);
        btnDado.setFocusPainted(false);
        btnDado.setFocusTraversalPolicyProvider(true);
        btnDado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDadoActionPerformed(evt);
            }
        });
        pnlRodada.add(btnDado, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 190, 90));

        lblJog1Atributo.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        lblJog1Atributo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblJog1Atributo.setText("Attribute: ");
        pnlRodada.add(lblJog1Atributo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 440, 280, -1));

        lblJog2Atributo.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        lblJog2Atributo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblJog2Atributo.setText("Attribute: ");
        pnlRodada.add(lblJog2Atributo, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 440, 280, -1));

        lblJog1Star1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/star.png"))); // NOI18N
        pnlRodada.add(lblJog1Star1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, -1, -1));

        lblJog1Star2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/star.png"))); // NOI18N
        pnlRodada.add(lblJog1Star2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 410, -1, -1));

        lblJog1Star3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/star.png"))); // NOI18N
        pnlRodada.add(lblJog1Star3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 410, -1, -1));

        lblJog1Star4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/star.png"))); // NOI18N
        pnlRodada.add(lblJog1Star4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, -1, -1));

        lblJog1Star5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/star.png"))); // NOI18N
        pnlRodada.add(lblJog1Star5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 460, -1, -1));

        lblJog1Star6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/star.png"))); // NOI18N
        pnlRodada.add(lblJog1Star6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 460, -1, -1));

        lblJog1Star7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/star.png"))); // NOI18N
        pnlRodada.add(lblJog1Star7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, -1, -1));

        lblJog1Star8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/star.png"))); // NOI18N
        pnlRodada.add(lblJog1Star8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 510, -1, -1));

        lblJog1Star9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/star.png"))); // NOI18N
        pnlRodada.add(lblJog1Star9, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 510, -1, -1));

        lblJog1Star10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/star.png"))); // NOI18N
        pnlRodada.add(lblJog1Star10, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 510, -1, -1));

        lblJog2Star1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/star.png"))); // NOI18N
        pnlRodada.add(lblJog2Star1, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 410, -1, -1));

        lblJog2Star2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/star.png"))); // NOI18N
        pnlRodada.add(lblJog2Star2, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 410, -1, -1));

        lblJog2Star3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/star.png"))); // NOI18N
        pnlRodada.add(lblJog2Star3, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 410, -1, -1));

        lblJog2Star4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/star.png"))); // NOI18N
        pnlRodada.add(lblJog2Star4, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 460, -1, -1));

        lblJog2Star5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/star.png"))); // NOI18N
        pnlRodada.add(lblJog2Star5, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 460, -1, -1));

        lblJog2Star6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/star.png"))); // NOI18N
        pnlRodada.add(lblJog2Star6, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 460, -1, -1));

        lblJog2Star7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/star.png"))); // NOI18N
        pnlRodada.add(lblJog2Star7, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 510, -1, -1));

        lblJog2Star8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/star.png"))); // NOI18N
        pnlRodada.add(lblJog2Star8, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 510, -1, -1));

        lblJog2Star9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/star.png"))); // NOI18N
        pnlRodada.add(lblJog2Star9, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 510, -1, -1));

        lblJog2Star10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/star.png"))); // NOI18N
        pnlRodada.add(lblJog2Star10, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 510, -1, -1));

        btnProximo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/next.png"))); // NOI18N
        btnProximo.setBorderPainted(false);
        btnProximo.setContentAreaFilled(false);
        btnProximo.setFocusPainted(false);
        btnProximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProximoActionPerformed(evt);
            }
        });
        pnlRodada.add(btnProximo, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 30, -1, -1));

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/exit.png"))); // NOI18N
        btnCancelar.setBorderPainted(false);
        btnCancelar.setContentAreaFilled(false);
        btnCancelar.setFocusPainted(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        pnlRodada.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        btnDado3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/playDado.gif"))); // NOI18N
        btnDado3.setBorderPainted(false);
        btnDado3.setContentAreaFilled(false);
        btnDado3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDado3ActionPerformed(evt);
            }
        });
        pnlRodada.add(btnDado3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 190, 90));

        lblVS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vs.png"))); // NOI18N
        pnlRodada.add(lblVS, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 220, -1, -1));

        lblRaio1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/raio.png"))); // NOI18N
        pnlRodada.add(lblRaio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 110, -1, -1));

        lblRaio2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/raio.png"))); // NOI18N
        pnlRodada.add(lblRaio2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 360, -1, -1));

        lblPista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PistaCurva.png"))); // NOI18N
        pnlRodada.add(lblPista, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlRodada, javax.swing.GroupLayout.PREFERRED_SIZE, 1024, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlRodada, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDadoActionPerformed
        btnDado.setEnabled(false);
        dado1 = jogaDado();
        trocaDado(dado1, lblDado1);
        if(tipoPista=="STRAIGHT"){
            rod.setUpgradeJog1(jog1.getVelocidade()+dado1);
            JOptionPane.showMessageDialog(null,jog1.getNome()+" rolled the die and got a "+dado1+". Now his speed is "+rod.getUpgradeJog1()+"!");
            lblJog1Atributo.setText("Speed: "+rod.getUpgradeJog1());
        }
        else if(tipoPista=="CURVE"){
            rod.setUpgradeJog1(jog1.getManobrabilidade()+dado1);
            JOptionPane.showMessageDialog(null,jog1.getNome()+" rolled the die and got a "+dado1+". Now his maneuverability is "+rod.getUpgradeJog1()+"!");
            lblJog1Atributo.setText("Maneuverability: "+rod.getUpgradeJog1());
        }
        else{
            rod.setUpgradeJog1(jog1.getPoder()+dado1);
            JOptionPane.showMessageDialog(null,jog1.getNome()+" rolled the die and got a "+dado1+". Now his power is "+rod.getUpgradeJog1()+"!");
            lblJog1Atributo.setText("Power: "+rod.getUpgradeJog1());
        }
        dado2 = jogaDado();
        trocaDado(dado2, lblDado2);
        if(tipoPista=="STRAIGHT"){
            
            rod.setUpgradeJog2(jog2.getVelocidade()+dado2);
            JOptionPane.showMessageDialog(null,jog2.getNome()+" rolled the die and got a "+dado2+". Now his speed is "+rod.getUpgradeJog2()+"!");
            lblJog2Atributo.setText("Speed: "+rod.getUpgradeJog2());
        }
        else if(tipoPista=="CURVE"){
            rod.setUpgradeJog2(jog2.getManobrabilidade()+dado2);
            JOptionPane.showMessageDialog(null,jog2.getNome()+" rolled the die and got a "+dado2+". Now his maneuverability is "+rod.getUpgradeJog2()+"!");
            lblJog2Atributo.setText("Maneuverability: "+rod.getUpgradeJog2());
        }
        else{
            rod.setUpgradeJog2(jog2.getPoder()+dado2);
            JOptionPane.showMessageDialog(null,jog2.getNome()+" rolled the die and got a "+dado2+". Now his power is "+rod.getUpgradeJog2()+"!");
            lblJog2Atributo.setText("Power: "+rod.getUpgradeJog2());
        }
        if(tipoPista=="STRAIGHT"){
            executaRodadaRetaCurva(rod);
            if(rod.getUpgradeJog1()>rod.getUpgradeJog2()){
                JOptionPane.showMessageDialog(null,jog1.getNome()+"'s speed is greater, so "+jog1.getNome()+" won the round and earned a point!");
                somVitoria(jog1);
                mostraEstrelas(jog1.getPontos(), lblJog1Star1, lblJog1Star2, lblJog1Star3, lblJog1Star4, lblJog1Star5, lblJog1Star6, lblJog1Star7, lblJog1Star8, lblJog1Star9, lblJog1Star10);
            }
            else if(rod.getUpgradeJog1()<rod.getUpgradeJog2()){
                JOptionPane.showMessageDialog(null,jog2.getNome()+"'s speed is greater, so "+jog2.getNome()+" won the round and earned a point!");
                somVitoria(jog2);
                mostraEstrelas(jog2.getPontos(), lblJog2Star1, lblJog2Star2, lblJog2Star3, lblJog2Star4, lblJog2Star5, lblJog2Star6, lblJog2Star7, lblJog2Star8, lblJog2Star9, lblJog2Star10);
            }
            else
                JOptionPane.showMessageDialog(null,jog1.getNome()+" and "+jog2.getNome()+" have the same speed, so neither scored any points.");
            btnProximo.setVisible(true);
            btnProximo.setEnabled(true);
        }
        else if(tipoPista=="CURVE"){
            executaRodadaRetaCurva(rod);
            if(rod.getUpgradeJog1()>rod.getUpgradeJog2()){
                JOptionPane.showMessageDialog(null,jog1.getNome()+"'s maneuverability is greater, so "+jog1.getNome()+" won the round and earned a point!");
                somVitoria(jog1);
                mostraEstrelas(jog1.getPontos(), lblJog1Star1, lblJog1Star2, lblJog1Star3, lblJog1Star4, lblJog1Star5, lblJog1Star6, lblJog1Star7, lblJog1Star8, lblJog1Star9, lblJog1Star10);
            }
            else if(rod.getUpgradeJog1()<rod.getUpgradeJog2()){
                JOptionPane.showMessageDialog(null,jog2.getNome()+"'s maneuverability is greater, so "+jog2.getNome()+" won the round and earned a point!");
                somVitoria(jog2);
                mostraEstrelas(jog2.getPontos(), lblJog2Star1, lblJog2Star2, lblJog2Star3, lblJog2Star4, lblJog2Star5, lblJog2Star6, lblJog2Star7, lblJog2Star8, lblJog2Star9, lblJog2Star10);
            }
            else
                JOptionPane.showMessageDialog(null,jog1.getNome()+" and "+jog2.getNome()+" have the same maneuverability, so neither scored any points.");
            btnProximo.setVisible(true);
            btnProximo.setEnabled(true);
        }
        else{
            executaRodadaConfronto(rod);
            if(rod.getUpgradeJog1()>rod.getUpgradeJog2()){
                JOptionPane.showMessageDialog(null,jog2.getNome()+"'s power is lower, so "+jog2.getNome()+" lost the round and lost a point.");
                mostraEstrelas(jog2.getPontos(), lblJog2Star1, lblJog2Star2, lblJog2Star3, lblJog2Star4, lblJog2Star5, lblJog2Star6, lblJog2Star7, lblJog2Star8, lblJog2Star9, lblJog2Star10);
                lblDado1.setIcon(d0);
                JOptionPane.showMessageDialog(null,"Since "+jog1.getNome()+"'s power is greater, "+jog1.getNome()+" can roll the die again to try and gain a point.");
                btnDado.setVisible(false);
                btnDado3.setVisible(true);
                btnDado3.setEnabled(true);
            }
            else if(rod.getUpgradeJog1()<rod.getUpgradeJog2()){
                JOptionPane.showMessageDialog(null,jog1.getNome()+"'s power is lower, so "+jog1.getNome()+" lost the round and lost a point.");
                mostraEstrelas(jog1.getPontos(), lblJog1Star1, lblJog1Star2, lblJog1Star3, lblJog1Star4, lblJog1Star5, lblJog1Star6, lblJog1Star7, lblJog1Star8, lblJog1Star9, lblJog1Star10);
                lblDado2.setIcon(d0);
                JOptionPane.showMessageDialog(null,"Since "+jog2.getNome()+"'s power is greater, "+jog2.getNome()+" can roll the die again to try and gain a point.");
                dado3 = jogaDado();
                trocaDado(dado3, lblDado2);
                if(dado3%2==0){
                    rod.getJog2().setPontos(rod.getJog2().getPontos()+1);
                    JOptionPane.showMessageDialog(null,jog2.getNome()+" rolled the die again and got a "+dado3+". Since "+dado3+" is even, "+jog2.getNome()+" earned a point!");
                    somVitoria(jog2);
                    mostraEstrelas(jog2.getPontos(), lblJog2Star1, lblJog2Star2, lblJog2Star3, lblJog2Star4, lblJog2Star5, lblJog2Star6, lblJog2Star7, lblJog2Star8, lblJog2Star9, lblJog2Star10);
                }
                else
                    JOptionPane.showMessageDialog(null,jog2.getNome()+" rolled the die again and got a "+dado3+". Since "+dado3+" is odd, "+jog2.getNome()+" didn't score any points.");
                btnProximo.setVisible(true);
                btnProximo.setEnabled(true);
            }
            else{
                JOptionPane.showMessageDialog(null,jog1.getNome()+" and "+jog2.getNome()+" have the same power, so neither lost points.");
                btnProximo.setVisible(true);
                btnProximo.setEnabled(true);
            }
        }
    }//GEN-LAST:event_btnDadoActionPerformed

    private void btnProximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProximoActionPerformed
        rod = criaRodada(numRodada, tipoPista, jog1, jog2, dado1, dado2);
        rodadaList.add(rod);
        numRodada++;
        if(numRodada<=quantRodadas){
            iniciaRodada();
            try{
                AudioInputStream audio = AudioSystem.getAudioInputStream(new File("src/main/resources/audios/rodada.wav"));
                Clip rodada = AudioSystem.getClip();
                rodada.open(audio);
                rodada.start();
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Error reading the file.");
            }
        } 
        else{
            new FrmEndGame(FrmRound.quantVitorias, FrmRound.idPartida, FrmRound.pts, FrmRound.rodadaList).setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnProximoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        int resposta = JOptionPane.showConfirmDialog(null, "Do you really want to quit (your progress in this match will be lost, but you can start another match)?", "Return to Main Menu", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(resposta == JOptionPane.YES_OPTION){
            new FrmPlayers(FrmRound.quantVitorias, FrmRound.idPartida-1, FrmRound.pts, null, null).setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnDado3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDado3ActionPerformed
        btnDado3.setEnabled(false);
        btnDado3.setVisible(false);
        dado3 = jogaDado();
        trocaDado(dado3, lblDado1);
        if(dado3%2==0){
            rod.getJog1().setPontos(rod.getJog1().getPontos()+1);
            JOptionPane.showMessageDialog(null,jog1.getNome()+" rolled the die again and got a "+dado3+". Since "+dado3+" is even, "+jog1.getNome()+" earned a point!");
            somVitoria(jog1);
            mostraEstrelas(jog1.getPontos(), lblJog1Star1, lblJog1Star2, lblJog1Star3, lblJog1Star4, lblJog1Star5, lblJog1Star6, lblJog1Star7, lblJog1Star8, lblJog1Star9, lblJog1Star10);
        }
        else
            JOptionPane.showMessageDialog(null,jog1.getNome()+" rolled the die again and got a "+dado3+". Since "+dado3+" is odd, "+jog1.getNome()+" didn't score any points.");
        btnProximo.setVisible(true);
        btnProximo.setEnabled(true);
    }//GEN-LAST:event_btnDado3ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmRound(FrmRound.quantVitorias, FrmRound.idPartida, FrmRound.pts).setVisible(true);
            }
        });
    }
    private static void mostraEstrelas(int pts, javax.swing.JLabel lblStar1, javax.swing.JLabel lblStar2, javax.swing.JLabel lblStar3, javax.swing.JLabel lblStar4, javax.swing.JLabel lblStar5, javax.swing.JLabel lblStar6, javax.swing.JLabel lblStar7, javax.swing.JLabel lblStar8, javax.swing.JLabel lblStar9, javax.swing.JLabel lblStar10){
        switch(pts){
            case 0:
                lblStar1.setVisible(false);
                lblStar2.setVisible(false);
                lblStar3.setVisible(false);
                lblStar4.setVisible(false);
                lblStar5.setVisible(false);
                lblStar6.setVisible(false);
                lblStar7.setVisible(false);
                lblStar8.setVisible(false);
                lblStar9.setVisible(false);
                lblStar10.setVisible(false);
                break;
            case 1:
                lblStar1.setVisible(true);
                lblStar2.setVisible(false);
                lblStar3.setVisible(false);
                lblStar4.setVisible(false);
                lblStar5.setVisible(false);
                lblStar6.setVisible(false);
                lblStar7.setVisible(false);
                lblStar8.setVisible(false);
                lblStar9.setVisible(false);
                lblStar10.setVisible(false);
                break;
            case 2:
                lblStar1.setVisible(true);
                lblStar2.setVisible(true);
                lblStar3.setVisible(false);
                lblStar4.setVisible(false);
                lblStar5.setVisible(false);
                lblStar6.setVisible(false);
                lblStar7.setVisible(false);
                lblStar8.setVisible(false);
                lblStar9.setVisible(false);
                lblStar10.setVisible(false);
                break;
            case 3:
                lblStar1.setVisible(true);
                lblStar2.setVisible(true);
                lblStar3.setVisible(true);
                lblStar4.setVisible(false);
                lblStar5.setVisible(false);
                lblStar6.setVisible(false);
                lblStar7.setVisible(false);
                lblStar8.setVisible(false);
                lblStar9.setVisible(false);
                lblStar10.setVisible(false);
                break;
            case 4:
                lblStar1.setVisible(true);
                lblStar2.setVisible(true);
                lblStar3.setVisible(true);
                lblStar4.setVisible(true);
                lblStar5.setVisible(false);
                lblStar6.setVisible(false);
                lblStar7.setVisible(false);
                lblStar8.setVisible(false);
                lblStar9.setVisible(false);
                lblStar10.setVisible(false);
                break;
            case 5:
                lblStar1.setVisible(true);
                lblStar2.setVisible(true);
                lblStar3.setVisible(true);
                lblStar4.setVisible(true);
                lblStar5.setVisible(true);
                lblStar6.setVisible(false);
                lblStar7.setVisible(false);
                lblStar8.setVisible(false);
                lblStar9.setVisible(false);
                lblStar10.setVisible(false);
                break;
            case 6:
                lblStar1.setVisible(true);
                lblStar2.setVisible(true);
                lblStar3.setVisible(true);
                lblStar4.setVisible(true);
                lblStar5.setVisible(true);
                lblStar6.setVisible(true);
                lblStar7.setVisible(false);
                lblStar8.setVisible(false);
                lblStar9.setVisible(false);
                lblStar10.setVisible(false);
                break;
            case 7:
                lblStar1.setVisible(true);
                lblStar2.setVisible(true);
                lblStar3.setVisible(true);
                lblStar4.setVisible(true);
                lblStar5.setVisible(true);
                lblStar6.setVisible(true);
                lblStar7.setVisible(true);
                lblStar8.setVisible(false);
                lblStar9.setVisible(false);
                lblStar10.setVisible(false);
                break;
            case 8:
                lblStar1.setVisible(true);
                lblStar2.setVisible(true);
                lblStar3.setVisible(true);
                lblStar4.setVisible(true);
                lblStar5.setVisible(true);
                lblStar6.setVisible(true);
                lblStar7.setVisible(true);
                lblStar8.setVisible(true);
                lblStar9.setVisible(false);
                lblStar10.setVisible(false);
                break;
            case 9:
                lblStar1.setVisible(true);
                lblStar2.setVisible(true);
                lblStar3.setVisible(true);
                lblStar4.setVisible(true);
                lblStar5.setVisible(true);
                lblStar6.setVisible(true);
                lblStar7.setVisible(true);
                lblStar8.setVisible(true);
                lblStar9.setVisible(true);
                lblStar10.setVisible(false);
                break;
            case 10:
                lblStar1.setVisible(true);
                lblStar2.setVisible(true);
                lblStar3.setVisible(true);
                lblStar4.setVisible(true);
                lblStar5.setVisible(true);
                lblStar6.setVisible(true);
                lblStar7.setVisible(true);
                lblStar8.setVisible(true);
                lblStar9.setVisible(true);
                lblStar10.setVisible(true);
                break;
            default:
                break;
        }
    }
    private static void trocaDado(int dado, javax.swing.JLabel lblDado){
        ImageIcon d1 = new ImageIcon("src/main/resources/dado1.png");
        ImageIcon d2 = new ImageIcon("src/main/resources/dado2.png");
        ImageIcon d3 = new ImageIcon("src/main/resources/dado3.png");
        ImageIcon d4 = new ImageIcon("src/main/resources/dado4.png");
        ImageIcon d5 = new ImageIcon("src/main/resources/dado5.png");
        ImageIcon d6 = new ImageIcon("src/main/resources/dado6.png");
        switch(dado){
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
                audio = AudioSystem.getAudioInputStream(new File("src/main/resources/audios/samuel-ing/estouaqui.wav"));
            else
                audio = AudioSystem.getAudioInputStream(new File("src/main/resources/audios/didi/ins-ing.wav"));
            Clip player = AudioSystem.getClip();
            player.open(audio);
            player.start();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error reading the file.");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnDado;
    private javax.swing.JButton btnDado3;
    private javax.swing.JButton btnProximo;
    private javax.swing.JLabel lblDado1;
    private javax.swing.JLabel lblDado2;
    private javax.swing.JLabel lblJog1Atributo;
    private javax.swing.JLabel lblJog1Imagem;
    private javax.swing.JLabel lblJog1Nome;
    private javax.swing.JLabel lblJog1Star1;
    private javax.swing.JLabel lblJog1Star10;
    private javax.swing.JLabel lblJog1Star2;
    private javax.swing.JLabel lblJog1Star3;
    private javax.swing.JLabel lblJog1Star4;
    private javax.swing.JLabel lblJog1Star5;
    private javax.swing.JLabel lblJog1Star6;
    private javax.swing.JLabel lblJog1Star7;
    private javax.swing.JLabel lblJog1Star8;
    private javax.swing.JLabel lblJog1Star9;
    private javax.swing.JLabel lblJog2Atributo;
    private javax.swing.JLabel lblJog2Imagem;
    private javax.swing.JLabel lblJog2Nome;
    private javax.swing.JLabel lblJog2Star1;
    private javax.swing.JLabel lblJog2Star10;
    private javax.swing.JLabel lblJog2Star2;
    private javax.swing.JLabel lblJog2Star3;
    private javax.swing.JLabel lblJog2Star4;
    private javax.swing.JLabel lblJog2Star5;
    private javax.swing.JLabel lblJog2Star6;
    private javax.swing.JLabel lblJog2Star7;
    private javax.swing.JLabel lblJog2Star8;
    private javax.swing.JLabel lblJog2Star9;
    private javax.swing.JLabel lblPista;
    private javax.swing.JLabel lblRaio1;
    private javax.swing.JLabel lblRaio2;
    private javax.swing.JLabel lblRodada;
    private javax.swing.JLabel lblVS;
    private javax.swing.JPanel pnlRodada;
    // End of variables declaration//GEN-END:variables
}