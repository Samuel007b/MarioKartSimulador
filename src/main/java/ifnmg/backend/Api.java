/*
API para execução do jogo
@author arthurpereira
@author athossilvano
@author samuelmiranda
*/
package ifnmg.backend;

import static ifnmg.backend.Rodada.PISTAS;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;

public class Api {
    public static List<Personagem> csvToList(String csvFileName) throws FileNotFoundException{
        List<Personagem> myList = new ArrayList<>();
        File csvFile = new File(csvFileName);
        try(Scanner sc = new Scanner(csvFile)){
            sc.nextLine(); // Pula a 1ª linha
            while(sc.hasNext()){
                String line = sc.nextLine();
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String nome = data[1];
                int velocidade = Integer.parseInt(data[2]);
                int manobrabilidade = Integer.parseInt(data[3]);
                int poder = Integer.parseInt(data[4]);
                String imagem = data[5];
                int pontos = Integer.parseInt(data[6]);
                Personagem jog = new Personagem(id, nome, velocidade, manobrabilidade, poder, imagem, pontos);
                myList.add(jog);
            }
        }
        return myList;
    }
    public static int sorteiaRodadas(){
        Random aleatorio = new Random();
        int quantRodadas = aleatorio.nextInt(6)+5;
        return quantRodadas;
    }
    public static String sorteiaPista(){
        Random aleatorio = new Random();
        int tipo = aleatorio.nextInt(3);
        return PISTAS[tipo];
    }
    public static Personagem sorteiaJogadorA(List<Personagem> personagemList){
        Random aleatorio = new Random();
        Personagem jog1 = personagemList.get(aleatorio.nextInt(7));
        return jog1;
    }
    public static Personagem sorteiaJogBotA(List<Personagem> personagemList, Personagem jog1){
        Random aleatorio = new Random();
        Personagem jog2 = new Personagem();
        do{
            jog2 = personagemList.get(aleatorio.nextInt(7));
        }while(jog1==jog2);
        return jog2;
    }
    public static Personagem sorteiaJogadorB(List<Personagem> personagemList){
        Random aleatorio = new Random();
        Personagem jog1 = personagemList.get(aleatorio.nextInt(8));
        return jog1;
    }
    public static Personagem sorteiaJogBotB(List<Personagem> personagemList, Personagem jog1){
        Random aleatorio = new Random();
        Personagem jog2 = new Personagem();
        do{
            jog2 = personagemList.get(aleatorio.nextInt(8));
        }while(jog1==jog2);
        return jog2;
    }
    public static Personagem sorteiaJogadorC(List<Personagem> personagemList){
        Random aleatorio = new Random();
        Personagem jog1 = personagemList.get(aleatorio.nextInt(9));
        return jog1;
    }
    public static Personagem sorteiaJogBotC(List<Personagem> personagemList, Personagem jog1){
        Random aleatorio = new Random();
        Personagem jog2 = new Personagem();
        do{
            jog2 = personagemList.get(aleatorio.nextInt(9));
        }while(jog1==jog2);
        return jog2;
    }
    public static int jogaDado(){
        try{
            AudioInputStream audio = AudioSystem.getAudioInputStream(new File("src/main/resources/audios/dado.wav"));
            Clip dado = AudioSystem.getClip();
            dado.open(audio);
            dado.start();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro na leitura do arquivo.");
        }
        Random aleatorio = new Random();
        return aleatorio.nextInt(6)+1;
    }
    public static Rodada criaRodada(int numRodada, String tipoPista, Personagem jog1, Personagem jog2, int dado1, int dado2){
        Rodada rod = new Rodada(numRodada);
        rod.setTipo(tipoPista);
        rod.setJog1(jog1);
        rod.setJog2(jog2);
        if(rod.getTipo()=="RETA")
        {
            rod.setUpgradeJog1(jog1.getVelocidade()+dado1);
            rod.setUpgradeJog2(jog2.getVelocidade()+dado2);
        }
        else if(rod.getTipo()=="CURVA")
        {
            rod.setUpgradeJog1(jog1.getManobrabilidade()+dado1);
            rod.setUpgradeJog2(jog2.getManobrabilidade()+dado2);
        }
        else
        {
            rod.setUpgradeJog1(jog1.getPoder()+dado1);
            rod.setUpgradeJog2(jog2.getPoder()+dado2);
        }
        return rod;
    }
    public static void executaRodadaRetaCurva(Rodada rod){
        if(rod.getUpgradeJog1()>rod.getUpgradeJog2())
            rod.getJog1().setPontos(rod.getJog1().getPontos()+1);
        else if(rod.getUpgradeJog1()<rod.getUpgradeJog2())
            rod.getJog2().setPontos(rod.getJog2().getPontos()+1);
    }
    public static void executaRodadaConfronto(Rodada rod){
        if(rod.getUpgradeJog1()<rod.getUpgradeJog2())
            rod.getJog1().setPontos(rod.getJog1().getPontos()-1);
        else if(rod.getUpgradeJog1()>rod.getUpgradeJog2())
            rod.getJog2().setPontos(rod.getJog2().getPontos()-1);
    }
    public static void executaRodada(Rodada rod, int dado3){
        if((rod.getTipo()=="RETA")||(rod.getTipo()=="CURVA"))
        {
            if(rod.getUpgradeJog1()>rod.getUpgradeJog2())
                rod.getJog1().setPontos(rod.getJog1().getPontos()+1);
            else if(rod.getUpgradeJog1()<rod.getUpgradeJog2())
                rod.getJog2().setPontos(rod.getJog2().getPontos()+1);
        }
        else
        {
            if(rod.getUpgradeJog1()<rod.getUpgradeJog2())
            {
                rod.getJog1().setPontos(rod.getJog1().getPontos()-1);
                if(dado3%2==0)
                    rod.getJog2().setPontos(rod.getJog2().getPontos()+1);
            }
            else if(rod.getUpgradeJog1()>rod.getUpgradeJog2())
            {
                rod.getJog2().setPontos(rod.getJog2().getPontos()-1);
                if(dado3%2==0)
                    rod.getJog1().setPontos(rod.getJog1().getPontos()+1);
            }
        }
    }
    public static Personagem vencedor(Personagem jog1, Personagem jog2){
        if(jog1.getPontos()>jog2.getPontos())
            return jog1;
        else if(jog1.getPontos()<jog2.getPontos())
            return jog2;
        else
            return null;
    }
    public static void zeraPontos(Personagem jog1, Personagem jog2){
        jog1.setPontos(0);
        jog2.setPontos(0);
    }
}