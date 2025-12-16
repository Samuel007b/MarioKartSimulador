/*
Frame da tela de execução de rodada
@author arthurpereira
@author athossilvano
@author samuelmiranda
*/
package ifnmg.frontend;

import static ifnmg.backend.Api.criaRodada;
import static ifnmg.backend.Api.executaRodadaConfronto;
import static ifnmg.backend.Api.executaRodadaRetaCurva;
import static ifnmg.backend.Api.jogaDado;
import static ifnmg.backend.Api.sorteiaPista;
import static ifnmg.backend.Api.sorteiaRodadas;
import ifnmg.backend.Personagem;
import ifnmg.backend.Rodada;
import static ifnmg.frontend.FrmJogadores.jog1;
import static ifnmg.frontend.FrmJogadores.jog2;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class FrmRodada extends javax.swing.JFrame {
    private static int quantRodadas, dado1, dado2, dado3;
    private static List<Rodada> rodadaList = new ArrayList<>();
    private String tipoPista;
    private Rodada rod;
    private int numRodada = 1;
    private final ImageIcon d0 = new ImageIcon("src/main/resources/dado.gif");
    private final ImageIcon d1 = new ImageIcon("src/main/resources/dado1.png");
    private final ImageIcon d2 = new ImageIcon("src/main/resources/dado2.png");
    private final ImageIcon d3 = new ImageIcon("src/main/resources/dado3.png");
    private final ImageIcon d4 = new ImageIcon("src/main/resources/dado4.png");
    private final ImageIcon d5 = new ImageIcon("src/main/resources/dado5.png");
    private final ImageIcon d6 = new ImageIcon("src/main/resources/dado6.png");
    private final ImageIcon reta = new ImageIcon("src/main/resources/PistaReta.png");
    private final ImageIcon curva = new ImageIcon("src/main/resources/PistaCurva.png");
    private final ImageIcon confronto = new ImageIcon("src/main/resources/PistaConfronto.png");
    public FrmRodada() {
        initComponents();
        this.setLocationRelativeTo(null);
        lblJog1Star1.setVisible(false);
        lblJog1Star2.setVisible(false);
        lblJog1Star3.setVisible(false);
        lblJog1Star4.setVisible(false);
        lblJog1Star5.setVisible(false);
        lblJog1Star6.setVisible(false);
        lblJog1Star7.setVisible(false);
        lblJog1Star8.setVisible(false);
        lblJog1Star9.setVisible(false);
        lblJog1Star10.setVisible(false);
        lblJog2Star1.setVisible(false);
        lblJog2Star2.setVisible(false);
        lblJog2Star3.setVisible(false);
        lblJog2Star4.setVisible(false);
        lblJog2Star5.setVisible(false);
        lblJog2Star6.setVisible(false);
        lblJog2Star7.setVisible(false);
        lblJog2Star8.setVisible(false);
        lblJog2Star9.setVisible(false);
        lblJog2Star10.setVisible(false);
        btnDado.setHorizontalAlignment(SwingConstants.CENTER);
        btnDado.setVerticalAlignment(SwingConstants.CENTER);
        btnDado3.setVisible(false);
        btnDado3.setEnabled(false);
        btnDado3.setHorizontalAlignment(SwingConstants.CENTER);
        btnDado3.setVerticalAlignment(SwingConstants.CENTER);
        btnProximo.setVisible(false);
        btnProximo.setEnabled(false);
        String[] rodadas = {"5", "6", "7", "8", "9", "10", "Aleatório"};
        JComboBox<String> comboBox = new JComboBox<>(rodadas);
        JPanel painel = new JPanel(new GridLayout(0, 1));
        painel.add(new JLabel("Escolha a quantidade de rodadas:"));
        painel.add(comboBox);
        int resultado;
        do{
            resultado = JOptionPane.showConfirmDialog(null, painel, "Quantidade de Rodadas", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(resultado != JOptionPane.OK_OPTION)
                JOptionPane.showMessageDialog(null, "Defina a quantidade de rodadas para prosseguir!");
        }while(resultado != JOptionPane.OK_OPTION);
        if(comboBox.getSelectedItem()=="Aleatório"){
            quantRodadas = sorteiaRodadas();
            JOptionPane.showMessageDialog(null, "Foram sorteadas " + quantRodadas + " rodadas para a partida!");
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
        lblJog1Nome.setText("Jogador 1 (você): "+jog1.getNome());
        ImageIcon icon2 = new ImageIcon(jog2.getImagem());
        lblJog2Imagem.setIcon(icon2);
        lblJog2Imagem.setHorizontalAlignment(SwingConstants.CENTER);
        lblJog2Imagem.setVerticalAlignment(SwingConstants.CENTER);
        lblJog2Nome.setText("Jogador 2 (computador): "+jog2.getNome());
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
            rod = new Rodada(tipoPista, numRodada, jog1, jog2);
            if(numRodada==quantRodadas)
                lblRodada.setText(numRodada+"ª e Última Rodada: "+tipoPista+"!!!");
            else
                lblRodada.setText(numRodada+"ª Rodada: "+tipoPista+"!");
            if(tipoPista=="RETA"){
                lblPista.setIcon(reta);
                lblJog1Atributo.setText("Velocidade: "+jog1.getVelocidade());
                lblJog2Atributo.setText("Velocidade: "+jog2.getVelocidade());
            }
            else if(tipoPista=="CURVA"){
                lblPista.setIcon(curva);
                lblJog1Atributo.setText("Manobrabilidade: "+jog1.getManobrabilidade());
                lblJog2Atributo.setText("Manobrabilidade: "+jog2.getManobrabilidade());
            }
            else{
                lblPista.setIcon(confronto);
                lblJog1Atributo.setText("Poder: "+jog1.getPoder());
                lblJog2Atributo.setText("Poder: "+jog2.getPoder());
            }
            JOptionPane.showMessageDialog(null,"A pista sorteada para a "+numRodada+"ª rodada foi "+tipoPista+"!");
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

        lblJog1Nome.setFont(new java.awt.Font("Showcard Gothic", 1, 14)); // NOI18N
        lblJog1Nome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblJog1Nome.setText("Jogador 1 (você): ");
        lblJog1Nome.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnlRodada.add(lblJog1Nome, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 280, -1));

        lblJog2Nome.setFont(new java.awt.Font("Showcard Gothic", 1, 14)); // NOI18N
        lblJog2Nome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblJog2Nome.setText("Jogador 2 (computador): ");
        pnlRodada.add(lblJog2Nome, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 140, 280, -1));

        lblRodada.setFont(new java.awt.Font("Showcard Gothic", 2, 24)); // NOI18N
        lblRodada.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRodada.setText("ª Rodada: ");
        pnlRodada.add(lblRodada, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 50, 460, -1));

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

        lblJog1Atributo.setFont(new java.awt.Font("Showcard Gothic", 1, 14)); // NOI18N
        lblJog1Atributo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblJog1Atributo.setText("Atributo: ");
        pnlRodada.add(lblJog1Atributo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 440, 280, -1));

        lblJog2Atributo.setFont(new java.awt.Font("Showcard Gothic", 1, 14)); // NOI18N
        lblJog2Atributo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblJog2Atributo.setText("Atributo: ");
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
            .addComponent(pnlRodada, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDadoActionPerformed
        btnDado.setEnabled(false);
        dado1 = jogaDado();
        switch(dado1){
            case 1:
                lblDado1.setIcon(d1);
                break;
            case 2:
                lblDado1.setIcon(d2);
                break;
            case 3:
                lblDado1.setIcon(d3);
                break;
            case 4:
                lblDado1.setIcon(d4);
                break;
            case 5:
                lblDado1.setIcon(d5);
                break;
            case 6:
                lblDado1.setIcon(d6);
                break;
            default:
                break;
        }
        if(tipoPista=="RETA"){
            
            rod.setUpgradeJog1(jog1.getVelocidade()+dado1);
            JOptionPane.showMessageDialog(null,jog1.getNome()+" jogou o dado e obteve "+dado1+". Agora sua velocidade é "+rod.getUpgradeJog1()+"!");
            lblJog1Atributo.setText("Velocidade: "+rod.getUpgradeJog1());
        }
        else if(tipoPista=="CURVA"){
            rod.setUpgradeJog1(jog1.getManobrabilidade()+dado1);
            JOptionPane.showMessageDialog(null,jog1.getNome()+" jogou o dado e obteve "+dado1+". Agora sua manobrabilidade é "+rod.getUpgradeJog1()+"!");
            lblJog1Atributo.setText("Manobrabilidade: "+rod.getUpgradeJog1());
        }
        else{
            rod.setUpgradeJog1(jog1.getPoder()+dado1);
            JOptionPane.showMessageDialog(null,jog1.getNome()+" jogou o dado e obteve "+dado1+". Agora seu poder é "+rod.getUpgradeJog1()+"!");
            lblJog1Atributo.setText("Poder: "+rod.getUpgradeJog1());
        }
        dado2 = jogaDado();
        switch(dado2){
            case 1:
                lblDado2.setIcon(d1);
                break;
            case 2:
                lblDado2.setIcon(d2);
                break;
            case 3:
                lblDado2.setIcon(d3);
                break;
            case 4:
                lblDado2.setIcon(d4);
                break;
            case 5:
                lblDado2.setIcon(d5);
                break;
            case 6:
                lblDado2.setIcon(d6);
                break;
            default:
                break;
        }
        if(tipoPista=="RETA"){
            
            rod.setUpgradeJog2(jog2.getVelocidade()+dado2);
            JOptionPane.showMessageDialog(null,jog2.getNome()+" jogou o dado e obteve "+dado2+". Agora sua velocidade é "+rod.getUpgradeJog2()+"!");
            lblJog2Atributo.setText("Velocidade: "+rod.getUpgradeJog2());
        }
        else if(tipoPista=="CURVA"){
            rod.setUpgradeJog2(jog2.getManobrabilidade()+dado2);
            JOptionPane.showMessageDialog(null,jog2.getNome()+" jogou o dado e obteve "+dado2+". Agora sua manobrabilidade é "+rod.getUpgradeJog2()+"!");
            lblJog2Atributo.setText("Manobrabilidade: "+rod.getUpgradeJog2());
        }
        else{
            rod.setUpgradeJog2(jog2.getPoder()+dado2);
            JOptionPane.showMessageDialog(null,jog2.getNome()+" jogou o dado e obteve "+dado2+". Agora seu poder é "+rod.getUpgradeJog2()+"!");
            lblJog2Atributo.setText("Poder: "+rod.getUpgradeJog2());
        }
        if(tipoPista=="RETA"){
            executaRodadaRetaCurva(rod);
            if(rod.getUpgradeJog1()>rod.getUpgradeJog2()){
                JOptionPane.showMessageDialog(null,"A velocidade de "+jog1.getNome()+" é maior, então "+jog1.getNome()+" venceu a rodada e ganhou um ponto!");
                switch(jog1.getPontos()){
                    case 0:
                        lblJog1Star1.setVisible(false);
                        lblJog1Star2.setVisible(false);
                        lblJog1Star3.setVisible(false);
                        lblJog1Star4.setVisible(false);
                        lblJog1Star5.setVisible(false);
                        lblJog1Star6.setVisible(false);
                        lblJog1Star7.setVisible(false);
                        lblJog1Star8.setVisible(false);
                        lblJog1Star9.setVisible(false);
                        lblJog1Star10.setVisible(false);
                        break;
                    case 1:
                        lblJog1Star1.setVisible(true);
                        lblJog1Star2.setVisible(false);
                        lblJog1Star3.setVisible(false);
                        lblJog1Star4.setVisible(false);
                        lblJog1Star5.setVisible(false);
                        lblJog1Star6.setVisible(false);
                        lblJog1Star7.setVisible(false);
                        lblJog1Star8.setVisible(false);
                        lblJog1Star9.setVisible(false);
                        lblJog1Star10.setVisible(false);
                        break;
                    case 2:
                        lblJog1Star1.setVisible(true);
                        lblJog1Star2.setVisible(true);
                        lblJog1Star3.setVisible(false);
                        lblJog1Star4.setVisible(false);
                        lblJog1Star5.setVisible(false);
                        lblJog1Star6.setVisible(false);
                        lblJog1Star7.setVisible(false);
                        lblJog1Star8.setVisible(false);
                        lblJog1Star9.setVisible(false);
                        lblJog1Star10.setVisible(false);
                        break;
                    case 3:
                        lblJog1Star1.setVisible(true);
                        lblJog1Star2.setVisible(true);
                        lblJog1Star3.setVisible(true);
                        lblJog1Star4.setVisible(false);
                        lblJog1Star5.setVisible(false);
                        lblJog1Star6.setVisible(false);
                        lblJog1Star7.setVisible(false);
                        lblJog1Star8.setVisible(false);
                        lblJog1Star9.setVisible(false);
                        lblJog1Star10.setVisible(false);
                        break;
                    case 4:
                        lblJog1Star1.setVisible(true);
                        lblJog1Star2.setVisible(true);
                        lblJog1Star3.setVisible(true);
                        lblJog1Star4.setVisible(true);
                        lblJog1Star5.setVisible(false);
                        lblJog1Star6.setVisible(false);
                        lblJog1Star7.setVisible(false);
                        lblJog1Star8.setVisible(false);
                        lblJog1Star9.setVisible(false);
                        lblJog1Star10.setVisible(false);
                        break;
                    case 5:
                        lblJog1Star1.setVisible(true);
                        lblJog1Star2.setVisible(true);
                        lblJog1Star3.setVisible(true);
                        lblJog1Star4.setVisible(true);
                        lblJog1Star5.setVisible(true);
                        lblJog1Star6.setVisible(false);
                        lblJog1Star7.setVisible(false);
                        lblJog1Star8.setVisible(false);
                        lblJog1Star9.setVisible(false);
                        lblJog1Star10.setVisible(false);
                        break;
                    case 6:
                        lblJog1Star1.setVisible(true);
                        lblJog1Star2.setVisible(true);
                        lblJog1Star3.setVisible(true);
                        lblJog1Star4.setVisible(true);
                        lblJog1Star5.setVisible(true);
                        lblJog1Star6.setVisible(true);
                        lblJog1Star7.setVisible(false);
                        lblJog1Star8.setVisible(false);
                        lblJog1Star9.setVisible(false);
                        lblJog1Star10.setVisible(false);
                        break;
                    case 7:
                        lblJog1Star1.setVisible(true);
                        lblJog1Star2.setVisible(true);
                        lblJog1Star3.setVisible(true);
                        lblJog1Star4.setVisible(true);
                        lblJog1Star5.setVisible(true);
                        lblJog1Star6.setVisible(true);
                        lblJog1Star7.setVisible(true);
                        lblJog1Star8.setVisible(false);
                        lblJog1Star9.setVisible(false);
                        lblJog1Star10.setVisible(false);
                        break;
                    case 8:
                        lblJog1Star1.setVisible(true);
                        lblJog1Star2.setVisible(true);
                        lblJog1Star3.setVisible(true);
                        lblJog1Star4.setVisible(true);
                        lblJog1Star5.setVisible(true);
                        lblJog1Star6.setVisible(true);
                        lblJog1Star7.setVisible(true);
                        lblJog1Star8.setVisible(true);
                        lblJog1Star9.setVisible(false);
                        lblJog1Star10.setVisible(false);
                        break;
                    case 9:
                        lblJog1Star1.setVisible(true);
                        lblJog1Star2.setVisible(true);
                        lblJog1Star3.setVisible(true);
                        lblJog1Star4.setVisible(true);
                        lblJog1Star5.setVisible(true);
                        lblJog1Star6.setVisible(true);
                        lblJog1Star7.setVisible(true);
                        lblJog1Star8.setVisible(true);
                        lblJog1Star9.setVisible(true);
                        lblJog1Star10.setVisible(false);
                        break;
                    case 10:
                        lblJog1Star1.setVisible(true);
                        lblJog1Star2.setVisible(true);
                        lblJog1Star3.setVisible(true);
                        lblJog1Star4.setVisible(true);
                        lblJog1Star5.setVisible(true);
                        lblJog1Star6.setVisible(true);
                        lblJog1Star7.setVisible(true);
                        lblJog1Star8.setVisible(true);
                        lblJog1Star9.setVisible(true);
                        lblJog1Star10.setVisible(true);
                        break;
                    default:
                        break;
                }
            }
            else if(rod.getUpgradeJog1()<rod.getUpgradeJog2()){
                JOptionPane.showMessageDialog(null,"A velocidade de "+jog2.getNome()+" é maior, então "+jog2.getNome()+" venceu a rodada e ganhou um ponto!");
                switch(jog2.getPontos()){
                    case 0:
                        lblJog2Star1.setVisible(false);
                        lblJog2Star2.setVisible(false);
                        lblJog2Star3.setVisible(false);
                        lblJog2Star4.setVisible(false);
                        lblJog2Star5.setVisible(false);
                        lblJog2Star6.setVisible(false);
                        lblJog2Star7.setVisible(false);
                        lblJog2Star8.setVisible(false);
                        lblJog2Star9.setVisible(false);
                        lblJog2Star10.setVisible(false);
                        break;
                    case 1:
                        lblJog2Star1.setVisible(true);
                        lblJog2Star2.setVisible(false);
                        lblJog2Star3.setVisible(false);
                        lblJog2Star4.setVisible(false);
                        lblJog2Star5.setVisible(false);
                        lblJog2Star6.setVisible(false);
                        lblJog2Star7.setVisible(false);
                        lblJog2Star8.setVisible(false);
                        lblJog2Star9.setVisible(false);
                        lblJog2Star10.setVisible(false);
                        break;
                    case 2:
                        lblJog2Star1.setVisible(true);
                        lblJog2Star2.setVisible(true);
                        lblJog2Star3.setVisible(false);
                        lblJog2Star4.setVisible(false);
                        lblJog2Star5.setVisible(false);
                        lblJog2Star6.setVisible(false);
                        lblJog2Star7.setVisible(false);
                        lblJog2Star8.setVisible(false);
                        lblJog2Star9.setVisible(false);
                        lblJog2Star10.setVisible(false);
                        break;
                    case 3:
                        lblJog2Star1.setVisible(true);
                        lblJog2Star2.setVisible(true);
                        lblJog2Star3.setVisible(true);
                        lblJog2Star4.setVisible(false);
                        lblJog2Star5.setVisible(false);
                        lblJog2Star6.setVisible(false);
                        lblJog2Star7.setVisible(false);
                        lblJog2Star8.setVisible(false);
                        lblJog2Star9.setVisible(false);
                        lblJog2Star10.setVisible(false);
                        break;
                    case 4:
                        lblJog2Star1.setVisible(true);
                        lblJog2Star2.setVisible(true);
                        lblJog2Star3.setVisible(true);
                        lblJog2Star4.setVisible(true);
                        lblJog2Star5.setVisible(false);
                        lblJog2Star6.setVisible(false);
                        lblJog2Star7.setVisible(false);
                        lblJog2Star8.setVisible(false);
                        lblJog2Star9.setVisible(false);
                        lblJog2Star10.setVisible(false);
                        break;
                    case 5:
                        lblJog2Star1.setVisible(true);
                        lblJog2Star2.setVisible(true);
                        lblJog2Star3.setVisible(true);
                        lblJog2Star4.setVisible(true);
                        lblJog2Star5.setVisible(true);
                        lblJog2Star6.setVisible(false);
                        lblJog2Star7.setVisible(false);
                        lblJog2Star8.setVisible(false);
                        lblJog2Star9.setVisible(false);
                        lblJog2Star10.setVisible(false);
                        break;
                    case 6:
                        lblJog2Star1.setVisible(true);
                        lblJog2Star2.setVisible(true);
                        lblJog2Star3.setVisible(true);
                        lblJog2Star4.setVisible(true);
                        lblJog2Star5.setVisible(true);
                        lblJog2Star6.setVisible(true);
                        lblJog2Star7.setVisible(false);
                        lblJog2Star8.setVisible(false);
                        lblJog2Star9.setVisible(false);
                        lblJog2Star10.setVisible(false);
                        break;
                    case 7:
                        lblJog2Star1.setVisible(true);
                        lblJog2Star2.setVisible(true);
                        lblJog2Star3.setVisible(true);
                        lblJog2Star4.setVisible(true);
                        lblJog2Star5.setVisible(true);
                        lblJog2Star6.setVisible(true);
                        lblJog2Star7.setVisible(true);
                        lblJog2Star8.setVisible(false);
                        lblJog2Star9.setVisible(false);
                        lblJog2Star10.setVisible(false);
                        break;
                    case 8:
                        lblJog2Star1.setVisible(true);
                        lblJog2Star2.setVisible(true);
                        lblJog2Star3.setVisible(true);
                        lblJog2Star4.setVisible(true);
                        lblJog2Star5.setVisible(true);
                        lblJog2Star6.setVisible(true);
                        lblJog2Star7.setVisible(true);
                        lblJog2Star8.setVisible(true);
                        lblJog2Star9.setVisible(false);
                        lblJog2Star10.setVisible(false);
                        break;
                    case 9:
                        lblJog2Star1.setVisible(true);
                        lblJog2Star2.setVisible(true);
                        lblJog2Star3.setVisible(true);
                        lblJog2Star4.setVisible(true);
                        lblJog2Star5.setVisible(true);
                        lblJog2Star6.setVisible(true);
                        lblJog2Star7.setVisible(true);
                        lblJog2Star8.setVisible(true);
                        lblJog2Star9.setVisible(true);
                        lblJog2Star10.setVisible(false);
                        break;
                    case 10:
                        lblJog2Star1.setVisible(true);
                        lblJog2Star2.setVisible(true);
                        lblJog2Star3.setVisible(true);
                        lblJog2Star4.setVisible(true);
                        lblJog2Star5.setVisible(true);
                        lblJog2Star6.setVisible(true);
                        lblJog2Star7.setVisible(true);
                        lblJog2Star8.setVisible(true);
                        lblJog2Star9.setVisible(true);
                        lblJog2Star10.setVisible(true);
                        break;
                    default:
                        break;
                }
            }
            else
                JOptionPane.showMessageDialog(null,"As velocidades de "+jog1.getNome()+" e "+jog2.getNome()+" são iguais, então ninguém somou pontos.");
            btnProximo.setVisible(true);
            btnProximo.setEnabled(true);
        }
        else if(tipoPista=="CURVA"){
            executaRodadaRetaCurva(rod);
            if(rod.getUpgradeJog1()>rod.getUpgradeJog2()){
                JOptionPane.showMessageDialog(null,"A manobrabilidade de "+jog1.getNome()+" é maior, então "+jog1.getNome()+" venceu a rodada e ganhou um ponto!");
                switch(jog1.getPontos()){
                    case 0:
                        lblJog1Star1.setVisible(false);
                        lblJog1Star2.setVisible(false);
                        lblJog1Star3.setVisible(false);
                        lblJog1Star4.setVisible(false);
                        lblJog1Star5.setVisible(false);
                        lblJog1Star6.setVisible(false);
                        lblJog1Star7.setVisible(false);
                        lblJog1Star8.setVisible(false);
                        lblJog1Star9.setVisible(false);
                        lblJog1Star10.setVisible(false);
                        break;
                    case 1:
                        lblJog1Star1.setVisible(true);
                        lblJog1Star2.setVisible(false);
                        lblJog1Star3.setVisible(false);
                        lblJog1Star4.setVisible(false);
                        lblJog1Star5.setVisible(false);
                        lblJog1Star6.setVisible(false);
                        lblJog1Star7.setVisible(false);
                        lblJog1Star8.setVisible(false);
                        lblJog1Star9.setVisible(false);
                        lblJog1Star10.setVisible(false);
                        break;
                    case 2:
                        lblJog1Star1.setVisible(true);
                        lblJog1Star2.setVisible(true);
                        lblJog1Star3.setVisible(false);
                        lblJog1Star4.setVisible(false);
                        lblJog1Star5.setVisible(false);
                        lblJog1Star6.setVisible(false);
                        lblJog1Star7.setVisible(false);
                        lblJog1Star8.setVisible(false);
                        lblJog1Star9.setVisible(false);
                        lblJog1Star10.setVisible(false);
                        break;
                    case 3:
                        lblJog1Star1.setVisible(true);
                        lblJog1Star2.setVisible(true);
                        lblJog1Star3.setVisible(true);
                        lblJog1Star4.setVisible(false);
                        lblJog1Star5.setVisible(false);
                        lblJog1Star6.setVisible(false);
                        lblJog1Star7.setVisible(false);
                        lblJog1Star8.setVisible(false);
                        lblJog1Star9.setVisible(false);
                        lblJog1Star10.setVisible(false);
                        break;
                    case 4:
                        lblJog1Star1.setVisible(true);
                        lblJog1Star2.setVisible(true);
                        lblJog1Star3.setVisible(true);
                        lblJog1Star4.setVisible(true);
                        lblJog1Star5.setVisible(false);
                        lblJog1Star6.setVisible(false);
                        lblJog1Star7.setVisible(false);
                        lblJog1Star8.setVisible(false);
                        lblJog1Star9.setVisible(false);
                        lblJog1Star10.setVisible(false);
                        break;
                    case 5:
                        lblJog1Star1.setVisible(true);
                        lblJog1Star2.setVisible(true);
                        lblJog1Star3.setVisible(true);
                        lblJog1Star4.setVisible(true);
                        lblJog1Star5.setVisible(true);
                        lblJog1Star6.setVisible(false);
                        lblJog1Star7.setVisible(false);
                        lblJog1Star8.setVisible(false);
                        lblJog1Star9.setVisible(false);
                        lblJog1Star10.setVisible(false);
                        break;
                    case 6:
                        lblJog1Star1.setVisible(true);
                        lblJog1Star2.setVisible(true);
                        lblJog1Star3.setVisible(true);
                        lblJog1Star4.setVisible(true);
                        lblJog1Star5.setVisible(true);
                        lblJog1Star6.setVisible(true);
                        lblJog1Star7.setVisible(false);
                        lblJog1Star8.setVisible(false);
                        lblJog1Star9.setVisible(false);
                        lblJog1Star10.setVisible(false);
                        break;
                    case 7:
                        lblJog1Star1.setVisible(true);
                        lblJog1Star2.setVisible(true);
                        lblJog1Star3.setVisible(true);
                        lblJog1Star4.setVisible(true);
                        lblJog1Star5.setVisible(true);
                        lblJog1Star6.setVisible(true);
                        lblJog1Star7.setVisible(true);
                        lblJog1Star8.setVisible(false);
                        lblJog1Star9.setVisible(false);
                        lblJog1Star10.setVisible(false);
                        break;
                    case 8:
                        lblJog1Star1.setVisible(true);
                        lblJog1Star2.setVisible(true);
                        lblJog1Star3.setVisible(true);
                        lblJog1Star4.setVisible(true);
                        lblJog1Star5.setVisible(true);
                        lblJog1Star6.setVisible(true);
                        lblJog1Star7.setVisible(true);
                        lblJog1Star8.setVisible(true);
                        lblJog1Star9.setVisible(false);
                        lblJog1Star10.setVisible(false);
                        break;
                    case 9:
                        lblJog1Star1.setVisible(true);
                        lblJog1Star2.setVisible(true);
                        lblJog1Star3.setVisible(true);
                        lblJog1Star4.setVisible(true);
                        lblJog1Star5.setVisible(true);
                        lblJog1Star6.setVisible(true);
                        lblJog1Star7.setVisible(true);
                        lblJog1Star8.setVisible(true);
                        lblJog1Star9.setVisible(true);
                        lblJog1Star10.setVisible(false);
                        break;
                    case 10:
                        lblJog1Star1.setVisible(true);
                        lblJog1Star2.setVisible(true);
                        lblJog1Star3.setVisible(true);
                        lblJog1Star4.setVisible(true);
                        lblJog1Star5.setVisible(true);
                        lblJog1Star6.setVisible(true);
                        lblJog1Star7.setVisible(true);
                        lblJog1Star8.setVisible(true);
                        lblJog1Star9.setVisible(true);
                        lblJog1Star10.setVisible(true);
                        break;
                    default:
                        break;
                }
            }
            else if(rod.getUpgradeJog1()<rod.getUpgradeJog2()){
                JOptionPane.showMessageDialog(null,"A manobrabilidade de "+jog2.getNome()+" é maior, então "+jog2.getNome()+" venceu a rodada e ganhou um ponto!");
                switch(jog2.getPontos()){
                    case 0:
                        lblJog2Star1.setVisible(false);
                        lblJog2Star2.setVisible(false);
                        lblJog2Star3.setVisible(false);
                        lblJog2Star4.setVisible(false);
                        lblJog2Star5.setVisible(false);
                        lblJog2Star6.setVisible(false);
                        lblJog2Star7.setVisible(false);
                        lblJog2Star8.setVisible(false);
                        lblJog2Star9.setVisible(false);
                        lblJog2Star10.setVisible(false);
                        break;
                    case 1:
                        lblJog2Star1.setVisible(true);
                        lblJog2Star2.setVisible(false);
                        lblJog2Star3.setVisible(false);
                        lblJog2Star4.setVisible(false);
                        lblJog2Star5.setVisible(false);
                        lblJog2Star6.setVisible(false);
                        lblJog2Star7.setVisible(false);
                        lblJog2Star8.setVisible(false);
                        lblJog2Star9.setVisible(false);
                        lblJog2Star10.setVisible(false);
                        break;
                    case 2:
                        lblJog2Star1.setVisible(true);
                        lblJog2Star2.setVisible(true);
                        lblJog2Star3.setVisible(false);
                        lblJog2Star4.setVisible(false);
                        lblJog2Star5.setVisible(false);
                        lblJog2Star6.setVisible(false);
                        lblJog2Star7.setVisible(false);
                        lblJog2Star8.setVisible(false);
                        lblJog2Star9.setVisible(false);
                        lblJog2Star10.setVisible(false);
                        break;
                    case 3:
                        lblJog2Star1.setVisible(true);
                        lblJog2Star2.setVisible(true);
                        lblJog2Star3.setVisible(true);
                        lblJog2Star4.setVisible(false);
                        lblJog2Star5.setVisible(false);
                        lblJog2Star6.setVisible(false);
                        lblJog2Star7.setVisible(false);
                        lblJog2Star8.setVisible(false);
                        lblJog2Star9.setVisible(false);
                        lblJog2Star10.setVisible(false);
                        break;
                    case 4:
                        lblJog2Star1.setVisible(true);
                        lblJog2Star2.setVisible(true);
                        lblJog2Star3.setVisible(true);
                        lblJog2Star4.setVisible(true);
                        lblJog2Star5.setVisible(false);
                        lblJog2Star6.setVisible(false);
                        lblJog2Star7.setVisible(false);
                        lblJog2Star8.setVisible(false);
                        lblJog2Star9.setVisible(false);
                        lblJog2Star10.setVisible(false);
                        break;
                    case 5:
                        lblJog2Star1.setVisible(true);
                        lblJog2Star2.setVisible(true);
                        lblJog2Star3.setVisible(true);
                        lblJog2Star4.setVisible(true);
                        lblJog2Star5.setVisible(true);
                        lblJog2Star6.setVisible(false);
                        lblJog2Star7.setVisible(false);
                        lblJog2Star8.setVisible(false);
                        lblJog2Star9.setVisible(false);
                        lblJog2Star10.setVisible(false);
                        break;
                    case 6:
                        lblJog2Star1.setVisible(true);
                        lblJog2Star2.setVisible(true);
                        lblJog2Star3.setVisible(true);
                        lblJog2Star4.setVisible(true);
                        lblJog2Star5.setVisible(true);
                        lblJog2Star6.setVisible(true);
                        lblJog2Star7.setVisible(false);
                        lblJog2Star8.setVisible(false);
                        lblJog2Star9.setVisible(false);
                        lblJog2Star10.setVisible(false);
                        break;
                    case 7:
                        lblJog2Star1.setVisible(true);
                        lblJog2Star2.setVisible(true);
                        lblJog2Star3.setVisible(true);
                        lblJog2Star4.setVisible(true);
                        lblJog2Star5.setVisible(true);
                        lblJog2Star6.setVisible(true);
                        lblJog2Star7.setVisible(true);
                        lblJog2Star8.setVisible(false);
                        lblJog2Star9.setVisible(false);
                        lblJog2Star10.setVisible(false);
                        break;
                    case 8:
                        lblJog2Star1.setVisible(true);
                        lblJog2Star2.setVisible(true);
                        lblJog2Star3.setVisible(true);
                        lblJog2Star4.setVisible(true);
                        lblJog2Star5.setVisible(true);
                        lblJog2Star6.setVisible(true);
                        lblJog2Star7.setVisible(true);
                        lblJog2Star8.setVisible(true);
                        lblJog2Star9.setVisible(false);
                        lblJog2Star10.setVisible(false);
                        break;
                    case 9:
                        lblJog2Star1.setVisible(true);
                        lblJog2Star2.setVisible(true);
                        lblJog2Star3.setVisible(true);
                        lblJog2Star4.setVisible(true);
                        lblJog2Star5.setVisible(true);
                        lblJog2Star6.setVisible(true);
                        lblJog2Star7.setVisible(true);
                        lblJog2Star8.setVisible(true);
                        lblJog2Star9.setVisible(true);
                        lblJog2Star10.setVisible(false);
                        break;
                    case 10:
                        lblJog2Star1.setVisible(true);
                        lblJog2Star2.setVisible(true);
                        lblJog2Star3.setVisible(true);
                        lblJog2Star4.setVisible(true);
                        lblJog2Star5.setVisible(true);
                        lblJog2Star6.setVisible(true);
                        lblJog2Star7.setVisible(true);
                        lblJog2Star8.setVisible(true);
                        lblJog2Star9.setVisible(true);
                        lblJog2Star10.setVisible(true);
                        break;
                    default:
                        break;
                }
            }
            else
                JOptionPane.showMessageDialog(null,"As manobrabilidades de "+jog1.getNome()+" e "+jog2.getNome()+" são iguais, então ninguém somou pontos.");
            btnProximo.setVisible(true);
            btnProximo.setEnabled(true);
        }
        else{
            executaRodadaConfronto(rod);
            if(rod.getUpgradeJog1()>rod.getUpgradeJog2()){
                JOptionPane.showMessageDialog(null,"O poder de "+jog2.getNome()+" é menor, então "+jog2.getNome()+" perdeu a rodada e perdeu um ponto.");
                switch(jog2.getPontos()){
                    case 0:
                        lblJog2Star1.setVisible(false);
                        lblJog2Star2.setVisible(false);
                        lblJog2Star3.setVisible(false);
                        lblJog2Star4.setVisible(false);
                        lblJog2Star5.setVisible(false);
                        lblJog2Star6.setVisible(false);
                        lblJog2Star7.setVisible(false);
                        lblJog2Star8.setVisible(false);
                        lblJog2Star9.setVisible(false);
                        lblJog2Star10.setVisible(false);
                        break;
                    case 1:
                        lblJog2Star1.setVisible(true);
                        lblJog2Star2.setVisible(false);
                        lblJog2Star3.setVisible(false);
                        lblJog2Star4.setVisible(false);
                        lblJog2Star5.setVisible(false);
                        lblJog2Star6.setVisible(false);
                        lblJog2Star7.setVisible(false);
                        lblJog2Star8.setVisible(false);
                        lblJog2Star9.setVisible(false);
                        lblJog2Star10.setVisible(false);
                        break;
                    case 2:
                        lblJog2Star1.setVisible(true);
                        lblJog2Star2.setVisible(true);
                        lblJog2Star3.setVisible(false);
                        lblJog2Star4.setVisible(false);
                        lblJog2Star5.setVisible(false);
                        lblJog2Star6.setVisible(false);
                        lblJog2Star7.setVisible(false);
                        lblJog2Star8.setVisible(false);
                        lblJog2Star9.setVisible(false);
                        lblJog2Star10.setVisible(false);
                        break;
                    case 3:
                        lblJog2Star1.setVisible(true);
                        lblJog2Star2.setVisible(true);
                        lblJog2Star3.setVisible(true);
                        lblJog2Star4.setVisible(false);
                        lblJog2Star5.setVisible(false);
                        lblJog2Star6.setVisible(false);
                        lblJog2Star7.setVisible(false);
                        lblJog2Star8.setVisible(false);
                        lblJog2Star9.setVisible(false);
                        lblJog2Star10.setVisible(false);
                        break;
                    case 4:
                        lblJog2Star1.setVisible(true);
                        lblJog2Star2.setVisible(true);
                        lblJog2Star3.setVisible(true);
                        lblJog2Star4.setVisible(true);
                        lblJog2Star5.setVisible(false);
                        lblJog2Star6.setVisible(false);
                        lblJog2Star7.setVisible(false);
                        lblJog2Star8.setVisible(false);
                        lblJog2Star9.setVisible(false);
                        lblJog2Star10.setVisible(false);
                        break;
                    case 5:
                        lblJog2Star1.setVisible(true);
                        lblJog2Star2.setVisible(true);
                        lblJog2Star3.setVisible(true);
                        lblJog2Star4.setVisible(true);
                        lblJog2Star5.setVisible(true);
                        lblJog2Star6.setVisible(false);
                        lblJog2Star7.setVisible(false);
                        lblJog2Star8.setVisible(false);
                        lblJog2Star9.setVisible(false);
                        lblJog2Star10.setVisible(false);
                        break;
                    case 6:
                        lblJog2Star1.setVisible(true);
                        lblJog2Star2.setVisible(true);
                        lblJog2Star3.setVisible(true);
                        lblJog2Star4.setVisible(true);
                        lblJog2Star5.setVisible(true);
                        lblJog2Star6.setVisible(true);
                        lblJog2Star7.setVisible(false);
                        lblJog2Star8.setVisible(false);
                        lblJog2Star9.setVisible(false);
                        lblJog2Star10.setVisible(false);
                        break;
                    case 7:
                        lblJog2Star1.setVisible(true);
                        lblJog2Star2.setVisible(true);
                        lblJog2Star3.setVisible(true);
                        lblJog2Star4.setVisible(true);
                        lblJog2Star5.setVisible(true);
                        lblJog2Star6.setVisible(true);
                        lblJog2Star7.setVisible(true);
                        lblJog2Star8.setVisible(false);
                        lblJog2Star9.setVisible(false);
                        lblJog2Star10.setVisible(false);
                        break;
                    case 8:
                        lblJog2Star1.setVisible(true);
                        lblJog2Star2.setVisible(true);
                        lblJog2Star3.setVisible(true);
                        lblJog2Star4.setVisible(true);
                        lblJog2Star5.setVisible(true);
                        lblJog2Star6.setVisible(true);
                        lblJog2Star7.setVisible(true);
                        lblJog2Star8.setVisible(true);
                        lblJog2Star9.setVisible(false);
                        lblJog2Star10.setVisible(false);
                        break;
                    case 9:
                        lblJog2Star1.setVisible(true);
                        lblJog2Star2.setVisible(true);
                        lblJog2Star3.setVisible(true);
                        lblJog2Star4.setVisible(true);
                        lblJog2Star5.setVisible(true);
                        lblJog2Star6.setVisible(true);
                        lblJog2Star7.setVisible(true);
                        lblJog2Star8.setVisible(true);
                        lblJog2Star9.setVisible(true);
                        lblJog2Star10.setVisible(false);
                        break;
                    case 10:
                        lblJog2Star1.setVisible(true);
                        lblJog2Star2.setVisible(true);
                        lblJog2Star3.setVisible(true);
                        lblJog2Star4.setVisible(true);
                        lblJog2Star5.setVisible(true);
                        lblJog2Star6.setVisible(true);
                        lblJog2Star7.setVisible(true);
                        lblJog2Star8.setVisible(true);
                        lblJog2Star9.setVisible(true);
                        lblJog2Star10.setVisible(true);
                        break;
                    default:
                        break;
                }
                lblDado1.setIcon(d0);
                JOptionPane.showMessageDialog(null,"Como o poder de "+jog1.getNome()+" é maior, "+jog1.getNome()+" pode jogar o dado novamente para tentar ganhar um ponto.");
                btnDado.setVisible(false);
                btnDado3.setVisible(true);
                btnDado3.setEnabled(true);
            }
            else if(rod.getUpgradeJog1()<rod.getUpgradeJog2()){
                JOptionPane.showMessageDialog(null,"O poder de "+jog1.getNome()+" é menor, então "+jog1.getNome()+" perdeu a rodada e perdeu um ponto.");
                switch(jog1.getPontos()){
                    case 0:
                        lblJog1Star1.setVisible(false);
                        lblJog1Star2.setVisible(false);
                        lblJog1Star3.setVisible(false);
                        lblJog1Star4.setVisible(false);
                        lblJog1Star5.setVisible(false);
                        lblJog1Star6.setVisible(false);
                        lblJog1Star7.setVisible(false);
                        lblJog1Star8.setVisible(false);
                        lblJog1Star9.setVisible(false);
                        lblJog1Star10.setVisible(false);
                        break;
                    case 1:
                        lblJog1Star1.setVisible(true);
                        lblJog1Star2.setVisible(false);
                        lblJog1Star3.setVisible(false);
                        lblJog1Star4.setVisible(false);
                        lblJog1Star5.setVisible(false);
                        lblJog1Star6.setVisible(false);
                        lblJog1Star7.setVisible(false);
                        lblJog1Star8.setVisible(false);
                        lblJog1Star9.setVisible(false);
                        lblJog1Star10.setVisible(false);
                        break;
                    case 2:
                        lblJog1Star1.setVisible(true);
                        lblJog1Star2.setVisible(true);
                        lblJog1Star3.setVisible(false);
                        lblJog1Star4.setVisible(false);
                        lblJog1Star5.setVisible(false);
                        lblJog1Star6.setVisible(false);
                        lblJog1Star7.setVisible(false);
                        lblJog1Star8.setVisible(false);
                        lblJog1Star9.setVisible(false);
                        lblJog1Star10.setVisible(false);
                        break;
                    case 3:
                        lblJog1Star1.setVisible(true);
                        lblJog1Star2.setVisible(true);
                        lblJog1Star3.setVisible(true);
                        lblJog1Star4.setVisible(false);
                        lblJog1Star5.setVisible(false);
                        lblJog1Star6.setVisible(false);
                        lblJog1Star7.setVisible(false);
                        lblJog1Star8.setVisible(false);
                        lblJog1Star9.setVisible(false);
                        lblJog1Star10.setVisible(false);
                        break;
                    case 4:
                        lblJog1Star1.setVisible(true);
                        lblJog1Star2.setVisible(true);
                        lblJog1Star3.setVisible(true);
                        lblJog1Star4.setVisible(true);
                        lblJog1Star5.setVisible(false);
                        lblJog1Star6.setVisible(false);
                        lblJog1Star7.setVisible(false);
                        lblJog1Star8.setVisible(false);
                        lblJog1Star9.setVisible(false);
                        lblJog1Star10.setVisible(false);
                        break;
                    case 5:
                        lblJog1Star1.setVisible(true);
                        lblJog1Star2.setVisible(true);
                        lblJog1Star3.setVisible(true);
                        lblJog1Star4.setVisible(true);
                        lblJog1Star5.setVisible(true);
                        lblJog1Star6.setVisible(false);
                        lblJog1Star7.setVisible(false);
                        lblJog1Star8.setVisible(false);
                        lblJog1Star9.setVisible(false);
                        lblJog1Star10.setVisible(false);
                        break;
                    case 6:
                        lblJog1Star1.setVisible(true);
                        lblJog1Star2.setVisible(true);
                        lblJog1Star3.setVisible(true);
                        lblJog1Star4.setVisible(true);
                        lblJog1Star5.setVisible(true);
                        lblJog1Star6.setVisible(true);
                        lblJog1Star7.setVisible(false);
                        lblJog1Star8.setVisible(false);
                        lblJog1Star9.setVisible(false);
                        lblJog1Star10.setVisible(false);
                        break;
                    case 7:
                        lblJog1Star1.setVisible(true);
                        lblJog1Star2.setVisible(true);
                        lblJog1Star3.setVisible(true);
                        lblJog1Star4.setVisible(true);
                        lblJog1Star5.setVisible(true);
                        lblJog1Star6.setVisible(true);
                        lblJog1Star7.setVisible(true);
                        lblJog1Star8.setVisible(false);
                        lblJog1Star9.setVisible(false);
                        lblJog1Star10.setVisible(false);
                        break;
                    case 8:
                        lblJog1Star1.setVisible(true);
                        lblJog1Star2.setVisible(true);
                        lblJog1Star3.setVisible(true);
                        lblJog1Star4.setVisible(true);
                        lblJog1Star5.setVisible(true);
                        lblJog1Star6.setVisible(true);
                        lblJog1Star7.setVisible(true);
                        lblJog1Star8.setVisible(true);
                        lblJog1Star9.setVisible(false);
                        lblJog1Star10.setVisible(false);
                        break;
                    case 9:
                        lblJog1Star1.setVisible(true);
                        lblJog1Star2.setVisible(true);
                        lblJog1Star3.setVisible(true);
                        lblJog1Star4.setVisible(true);
                        lblJog1Star5.setVisible(true);
                        lblJog1Star6.setVisible(true);
                        lblJog1Star7.setVisible(true);
                        lblJog1Star8.setVisible(true);
                        lblJog1Star9.setVisible(true);
                        lblJog1Star10.setVisible(false);
                        break;
                    case 10:
                        lblJog1Star1.setVisible(true);
                        lblJog1Star2.setVisible(true);
                        lblJog1Star3.setVisible(true);
                        lblJog1Star4.setVisible(true);
                        lblJog1Star5.setVisible(true);
                        lblJog1Star6.setVisible(true);
                        lblJog1Star7.setVisible(true);
                        lblJog1Star8.setVisible(true);
                        lblJog1Star9.setVisible(true);
                        lblJog1Star10.setVisible(true);
                        break;
                    default:
                        break;
                }
                lblDado2.setIcon(d0);
                JOptionPane.showMessageDialog(null,"Como o poder de "+jog2.getNome()+" é maior, "+jog2.getNome()+" pode jogar o dado novamente para tentar ganhar um ponto.");
                dado3 = jogaDado();
                switch(dado3){
                    case 1:
                        lblDado2.setIcon(d1);
                        break;
                    case 2:
                        lblDado2.setIcon(d2);
                        break;
                    case 3:
                        lblDado2.setIcon(d3);
                        break;
                    case 4:
                        lblDado2.setIcon(d4);
                        break;
                    case 5:
                        lblDado2.setIcon(d5);
                        break;
                    case 6:
                        lblDado2.setIcon(d6);
                        break;
                    default:
                        break;
                }
                if(dado3%2==0){
                    rod.getJog2().setPontos(rod.getJog2().getPontos()+1);
                    JOptionPane.showMessageDialog(null,jog2.getNome()+" jogou o dado novamente e obteve "+dado3+". Como "+dado3+" é par, "+jog2.getNome()+" ganhou um ponto!");
                    switch(jog2.getPontos()){
                        case 0:
                            lblJog2Star1.setVisible(false);
                            lblJog2Star2.setVisible(false);
                            lblJog2Star3.setVisible(false);
                            lblJog2Star4.setVisible(false);
                            lblJog2Star5.setVisible(false);
                            lblJog2Star6.setVisible(false);
                            lblJog2Star7.setVisible(false);
                            lblJog2Star8.setVisible(false);
                            lblJog2Star9.setVisible(false);
                            lblJog2Star10.setVisible(false);
                            break;
                        case 1:
                            lblJog2Star1.setVisible(true);
                            lblJog2Star2.setVisible(false);
                            lblJog2Star3.setVisible(false);
                            lblJog2Star4.setVisible(false);
                            lblJog2Star5.setVisible(false);
                            lblJog2Star6.setVisible(false);
                            lblJog2Star7.setVisible(false);
                            lblJog2Star8.setVisible(false);
                            lblJog2Star9.setVisible(false);
                            lblJog2Star10.setVisible(false);
                            break;
                        case 2:
                            lblJog2Star1.setVisible(true);
                            lblJog2Star2.setVisible(true);
                            lblJog2Star3.setVisible(false);
                            lblJog2Star4.setVisible(false);
                            lblJog2Star5.setVisible(false);
                            lblJog2Star6.setVisible(false);
                            lblJog2Star7.setVisible(false);
                            lblJog2Star8.setVisible(false);
                            lblJog2Star9.setVisible(false);
                            lblJog2Star10.setVisible(false);
                            break;
                        case 3:
                            lblJog2Star1.setVisible(true);
                            lblJog2Star2.setVisible(true);
                            lblJog2Star3.setVisible(true);
                            lblJog2Star4.setVisible(false);
                            lblJog2Star5.setVisible(false);
                            lblJog2Star6.setVisible(false);
                            lblJog2Star7.setVisible(false);
                            lblJog2Star8.setVisible(false);
                            lblJog2Star9.setVisible(false);
                            lblJog2Star10.setVisible(false);
                            break;
                        case 4:
                            lblJog2Star1.setVisible(true);
                            lblJog2Star2.setVisible(true);
                            lblJog2Star3.setVisible(true);
                            lblJog2Star4.setVisible(true);
                            lblJog2Star5.setVisible(false);
                            lblJog2Star6.setVisible(false);
                            lblJog2Star7.setVisible(false);
                            lblJog2Star8.setVisible(false);
                            lblJog2Star9.setVisible(false);
                            lblJog2Star10.setVisible(false);
                            break;
                        case 5:
                            lblJog2Star1.setVisible(true);
                            lblJog2Star2.setVisible(true);
                            lblJog2Star3.setVisible(true);
                            lblJog2Star4.setVisible(true);
                            lblJog2Star5.setVisible(true);
                            lblJog2Star6.setVisible(false);
                            lblJog2Star7.setVisible(false);
                            lblJog2Star8.setVisible(false);
                            lblJog2Star9.setVisible(false);
                            lblJog2Star10.setVisible(false);
                            break;
                        case 6:
                            lblJog2Star1.setVisible(true);
                            lblJog2Star2.setVisible(true);
                            lblJog2Star3.setVisible(true);
                            lblJog2Star4.setVisible(true);
                            lblJog2Star5.setVisible(true);
                            lblJog2Star6.setVisible(true);
                            lblJog2Star7.setVisible(false);
                            lblJog2Star8.setVisible(false);
                            lblJog2Star9.setVisible(false);
                            lblJog2Star10.setVisible(false);
                            break;
                        case 7:
                            lblJog2Star1.setVisible(true);
                            lblJog2Star2.setVisible(true);
                            lblJog2Star3.setVisible(true);
                            lblJog2Star4.setVisible(true);
                            lblJog2Star5.setVisible(true);
                            lblJog2Star6.setVisible(true);
                            lblJog2Star7.setVisible(true);
                            lblJog2Star8.setVisible(false);
                            lblJog2Star9.setVisible(false);
                            lblJog2Star10.setVisible(false);
                        case 8:
                            lblJog2Star1.setVisible(true);
                            lblJog2Star2.setVisible(true);
                            lblJog2Star3.setVisible(true);
                            lblJog2Star4.setVisible(true);
                            lblJog2Star5.setVisible(true);
                            lblJog2Star6.setVisible(true);
                            lblJog2Star7.setVisible(true);
                            lblJog2Star8.setVisible(true);
                            lblJog2Star9.setVisible(false);
                            lblJog2Star10.setVisible(false);
                        case 9:
                            lblJog2Star1.setVisible(true);
                            lblJog2Star2.setVisible(true);
                            lblJog2Star3.setVisible(true);
                            lblJog2Star4.setVisible(true);
                            lblJog2Star5.setVisible(true);
                            lblJog2Star6.setVisible(true);
                            lblJog2Star7.setVisible(true);
                            lblJog2Star8.setVisible(true);
                            lblJog2Star9.setVisible(true);
                            lblJog2Star10.setVisible(false);
                        case 10:
                            lblJog2Star1.setVisible(true);
                            lblJog2Star2.setVisible(true);
                            lblJog2Star3.setVisible(true);
                            lblJog2Star4.setVisible(true);
                            lblJog2Star5.setVisible(true);
                            lblJog2Star6.setVisible(true);
                            lblJog2Star7.setVisible(true);
                            lblJog2Star8.setVisible(true);
                            lblJog2Star9.setVisible(true);
                            lblJog2Star10.setVisible(true);
                        default:
                            break;
                    }
                }
                else
                    JOptionPane.showMessageDialog(null,jog2.getNome()+" jogou o dado novamente e obteve "+dado3+". Como "+dado3+" é ímpar, "+jog2.getNome()+" não somou pontos.");
                btnProximo.setVisible(true);
                btnProximo.setEnabled(true);
            }
            else{
                JOptionPane.showMessageDialog(null,"Os poderes de "+jog1.getNome()+" e "+jog2.getNome()+" são iguais, então ninguém perdeu pontos.");
                btnProximo.setVisible(true);
                btnProximo.setEnabled(true);
            }
        }
    }//GEN-LAST:event_btnDadoActionPerformed

    private void btnProximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProximoActionPerformed
        rod = criaRodada(numRodada, tipoPista, jog1, jog2, dado1, dado2);
        rodadaList.add(rod);
        numRodada++;
        if(numRodada<=quantRodadas)
            iniciaRodada();
        else{
            new FrmFimJogo().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnProximoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        int resposta = JOptionPane.showConfirmDialog(null, "Você quer mesmo sair (seu progresso nesta partida será perdido, mas você poderá iniciar outra partida)?", "Voltar ao Menu Principal", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(resposta == JOptionPane.YES_OPTION){
            new FrmJogadores().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnDado3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDado3ActionPerformed
        btnDado3.setEnabled(false);
        btnDado3.setVisible(false);
        dado3 = jogaDado();
        switch(dado3){
            case 1:
                lblDado1.setIcon(d1);
                break;
            case 2:
                lblDado1.setIcon(d2);
                break;
            case 3:
                lblDado1.setIcon(d3);
                break;
            case 4:
                lblDado1.setIcon(d4);
                break;
            case 5:
                lblDado1.setIcon(d5);
                break;
            case 6:
                lblDado1.setIcon(d6);
                break;
            default:
                break;
        }
        if(dado3%2==0){
            rod.getJog1().setPontos(rod.getJog1().getPontos()+1);
            JOptionPane.showMessageDialog(null,jog1.getNome()+" jogou o dado novamente e obteve "+dado3+". Como "+dado3+" é par, "+jog1.getNome()+" ganhou um ponto!");
            switch(jog1.getPontos()){
                case 0:
                    lblJog1Star1.setVisible(false);
                    lblJog1Star2.setVisible(false);
                    lblJog1Star3.setVisible(false);
                    lblJog1Star4.setVisible(false);
                    lblJog1Star5.setVisible(false);
                    lblJog1Star6.setVisible(false);
                    lblJog1Star7.setVisible(false);
                    lblJog1Star8.setVisible(false);
                    lblJog1Star9.setVisible(false);
                    lblJog1Star10.setVisible(false);
                    break;
                case 1:
                    lblJog1Star1.setVisible(true);
                    lblJog1Star2.setVisible(false);
                    lblJog1Star3.setVisible(false);
                    lblJog1Star4.setVisible(false);
                    lblJog1Star5.setVisible(false);
                    lblJog1Star6.setVisible(false);
                    lblJog1Star7.setVisible(false);
                    lblJog1Star8.setVisible(false);
                    lblJog1Star9.setVisible(false);
                    lblJog1Star10.setVisible(false);
                    break;
                case 2:
                    lblJog1Star1.setVisible(true);
                    lblJog1Star2.setVisible(true);
                    lblJog1Star3.setVisible(false);
                    lblJog1Star4.setVisible(false);
                    lblJog1Star5.setVisible(false);
                    lblJog1Star6.setVisible(false);
                    lblJog1Star7.setVisible(false);
                    lblJog1Star8.setVisible(false);
                    lblJog1Star9.setVisible(false);
                    lblJog1Star10.setVisible(false);
                    break;
                case 3:
                    lblJog1Star1.setVisible(true);
                    lblJog1Star2.setVisible(true);
                    lblJog1Star3.setVisible(true);
                    lblJog1Star4.setVisible(false);
                    lblJog1Star5.setVisible(false);
                    lblJog1Star6.setVisible(false);
                    lblJog1Star7.setVisible(false);
                    lblJog1Star8.setVisible(false);
                    lblJog1Star9.setVisible(false);
                    lblJog1Star10.setVisible(false);
                    break;
                case 4:
                    lblJog1Star1.setVisible(true);
                    lblJog1Star2.setVisible(true);
                    lblJog1Star3.setVisible(true);
                    lblJog1Star4.setVisible(true);
                    lblJog1Star5.setVisible(false);
                    lblJog1Star6.setVisible(false);
                    lblJog1Star7.setVisible(false);
                    lblJog1Star8.setVisible(false);
                    lblJog1Star9.setVisible(false);
                    lblJog1Star10.setVisible(false);
                    break;
                case 5:
                    lblJog1Star1.setVisible(true);
                    lblJog1Star2.setVisible(true);
                    lblJog1Star3.setVisible(true);
                    lblJog1Star4.setVisible(true);
                    lblJog1Star5.setVisible(true);
                    lblJog1Star6.setVisible(false);
                    lblJog1Star7.setVisible(false);
                    lblJog1Star8.setVisible(false);
                    lblJog1Star9.setVisible(false);
                    lblJog1Star10.setVisible(false);
                    break;
                case 6:
                    lblJog1Star1.setVisible(true);
                    lblJog1Star2.setVisible(true);
                    lblJog1Star3.setVisible(true);
                    lblJog1Star4.setVisible(true);
                    lblJog1Star5.setVisible(true);
                    lblJog1Star6.setVisible(true);
                    lblJog1Star7.setVisible(false);
                    lblJog1Star8.setVisible(false);
                    lblJog1Star9.setVisible(false);
                    lblJog1Star10.setVisible(false);
                    break;
                case 7:
                    lblJog1Star1.setVisible(true);
                    lblJog1Star2.setVisible(true);
                    lblJog1Star3.setVisible(true);
                    lblJog1Star4.setVisible(true);
                    lblJog1Star5.setVisible(true);
                    lblJog1Star6.setVisible(true);
                    lblJog1Star7.setVisible(true);
                    lblJog1Star8.setVisible(false);
                    lblJog1Star9.setVisible(false);
                    lblJog1Star10.setVisible(false);
                    break;
                case 8:
                    lblJog1Star1.setVisible(true);
                    lblJog1Star2.setVisible(true);
                    lblJog1Star3.setVisible(true);
                    lblJog1Star4.setVisible(true);
                    lblJog1Star5.setVisible(true);
                    lblJog1Star6.setVisible(true);
                    lblJog1Star7.setVisible(true);
                    lblJog1Star8.setVisible(true);
                    lblJog1Star9.setVisible(false);
                    lblJog1Star10.setVisible(false);
                    break;
                case 9:
                    lblJog1Star1.setVisible(true);
                    lblJog1Star2.setVisible(true);
                    lblJog1Star3.setVisible(true);
                    lblJog1Star4.setVisible(true);
                    lblJog1Star5.setVisible(true);
                    lblJog1Star6.setVisible(true);
                    lblJog1Star7.setVisible(true);
                    lblJog1Star8.setVisible(true);
                    lblJog1Star9.setVisible(true);
                    lblJog1Star10.setVisible(false);
                    break;
                case 10:
                    lblJog1Star1.setVisible(true);
                    lblJog1Star2.setVisible(true);
                    lblJog1Star3.setVisible(true);
                    lblJog1Star4.setVisible(true);
                    lblJog1Star5.setVisible(true);
                    lblJog1Star6.setVisible(true);
                    lblJog1Star7.setVisible(true);
                    lblJog1Star8.setVisible(true);
                    lblJog1Star9.setVisible(true);
                    lblJog1Star10.setVisible(false);
                    break;
                default:
                    break;
            }
        }
        else
            JOptionPane.showMessageDialog(null,jog1.getNome()+" jogou o dado novamente e obteve "+dado3+". Como "+dado3+" é ímpar, "+jog1.getNome()+" não somou pontos.");
        btnProximo.setVisible(true);
        btnProximo.setEnabled(true);
    }//GEN-LAST:event_btnDado3ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmRodada().setVisible(true);
            }
        });
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