/*
Programa principal para execução do simulador de Mario Kart
@author arthurpereira
@author athossilvano
@author samuelmiranda
*/
package ifnmg.test;

import ifnmg.backend.Personagem;
import ifnmg.backend.Rodada;
import static ifnmg.backend.Api.criaRodada;
import static ifnmg.backend.Api.csvToList;
import static ifnmg.backend.Api.executaRodada;
import static ifnmg.backend.Api.jogaDado;
import static ifnmg.backend.Api.sorteiaJogBotA;
import static ifnmg.backend.Api.sorteiaJogadorA;
import static ifnmg.backend.Api.sorteiaJogBotB;
import static ifnmg.backend.Api.sorteiaJogadorB;
import static ifnmg.backend.Api.sorteiaJogBotC;
import static ifnmg.backend.Api.sorteiaJogadorC;
import static ifnmg.backend.Api.sorteiaPista;
import static ifnmg.backend.Api.sorteiaRodadas;
import static ifnmg.backend.Api.vencedor;
import static ifnmg.backend.Api.zeraPontos;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
private static List<Personagem> personagemList = new ArrayList<>();
    public static void main(String[] args) throws FileNotFoundException, Exception {
        try(Scanner sc = new Scanner(System.in)){
            personagemList = csvToList("data/tabela-personagens.csv"); // item 4a
            System.out.println(personagemList);
            jogoCompleto(sc);
            /*
            String tipoPista = sorteiaPista(aleatorio);
            System.out.println(tipoPista); // item 4b
            Personagem jog1 = sorteiaJogador(aleatorio); // item 4c
            System.out.println(jog1);
            Personagem jog2 = sorteiaJogBot(aleatorio, jog1); // item 4c (extra)
            System.out.println(jog2);
            int dado1 = jogaDado(aleatorio); // item 4d
            System.out.println(dado1);
            int dado2 = jogaDado(aleatorio);
            System.out.println(dado2);
            int dado3 = jogaDado(aleatorio);
            System.out.println(dado3);
            Rodada rod = criaRodada(1, tipoPista, jog1.getId(), jog2.getId(), dado1, dado2); // item 4e
            System.out.println(rod);
            executaRodada(rod, dado3); // item 4f
            System.out.println(personagemList.get(rod.getIdJog1()-1));
            System.out.println(personagemList.get(rod.getIdJog2()-1));
            */
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public static void jogoCompleto(Scanner sc){
        int i, dado1, dado2, dado3, a=0, quantRodadas;
        String tipoPista, resposta;
        char opcao;
        Rodada rod = null;
        Personagem jog1, jog2;
        do{
            if(a==0){
                jog1 = sorteiaJogadorA(personagemList);
                jog2 = sorteiaJogBotA(personagemList, jog1);
            }
            else if(a==1){
                jog1 = sorteiaJogadorB(personagemList);
                jog2 = sorteiaJogBotB(personagemList, jog1);
            }
            else
            {
                jog1 = sorteiaJogadorC(personagemList);
                jog2 = sorteiaJogBotC(personagemList, jog1);
            }
            System.out.println("O jogador selecionado foi "+jog1.getNome()+".");
            System.out.println("O computador escolheu o jogador "+jog2.getNome()+".");
            quantRodadas = sorteiaRodadas();
            System.out.println("Foram sorteadas "+quantRodadas+" rodada(s) para o jogo!");
            for(i=1; i<=quantRodadas; i++)
            {
                System.out.println("----- "+i+"ª Rodada -----");
                tipoPista = sorteiaPista();
                System.out.println("A pista sorteada foi "+tipoPista+"!");
                dado1 = jogaDado();
                dado2 = jogaDado();
                dado3 = jogaDado();
                rod = criaRodada(i, tipoPista, jog1, jog2, dado1, dado2);
                executaRodada(rod, dado3);
                if(tipoPista=="RETA")
                {
                    System.out.println("O jogador "+jog1.getNome()+" jogou o dado e obteve "+dado1+"! Agora sua velocidade é "+rod.getUpgradeJog1()+".");
                    System.out.println("O jogador "+jog2.getNome()+" jogou o dado e obteve "+dado2+"! Agora sua velocidade é "+rod.getUpgradeJog2()+".");
                    if(rod.getUpgradeJog1()>rod.getUpgradeJog2())
                        System.out.println("A velocidade de "+jog1.getNome()+" é maior, então ele venceu a rodada e ganhou um ponto!");
                    else if(rod.getUpgradeJog1()<rod.getUpgradeJog2())
                        System.out.println("A velocidade de "+jog2.getNome()+" é maior, então ele venceu a rodada e ganhou um ponto!");
                    else
                        System.out.println("As velocidades de "+jog1.getNome()+" e "+jog2.getNome()+" são iguais, então ninguém somou pontos.");
                }
                else if(tipoPista=="CURVA")
                {
                    System.out.println("O jogador "+jog1.getNome()+" jogou o dado e obteve "+dado1+"! Agora sua manobrabilidade é "+rod.getUpgradeJog1()+".");
                    System.out.println("O jogador "+jog2.getNome()+" jogou o dado e obteve "+dado2+"! Agora sua manobrabilidade é "+rod.getUpgradeJog2()+".");
                    if(rod.getUpgradeJog1()>rod.getUpgradeJog2())
                        System.out.println("A manobrabilidade de "+jog1.getNome()+" é maior, então ele venceu a rodada e ganhou um ponto!");
                    else if(rod.getUpgradeJog1()<rod.getUpgradeJog2())
                        System.out.println("A manobrabilidade de "+jog2.getNome()+" é maior, então ele venceu a rodada e ganhou um ponto!");
                    else
                        System.out.println("As manobrabilidades de "+jog1.getNome()+" e "+jog2.getNome()+" são iguais, então ninguém somou pontos.");
                }
                else
                {
                    System.out.println("O jogador "+jog1.getNome()+" jogou o dado e obteve "+dado1+"! Agora seu poder é "+rod.getUpgradeJog1()+".");
                    System.out.println("O jogador "+jog2.getNome()+" jogou o dado e obteve "+dado2+"! Agora seu poder é "+rod.getUpgradeJog2()+".");
                    if(rod.getUpgradeJog1()>rod.getUpgradeJog2())
                    {
                        System.out.println("O poder de "+jog2.getNome()+" é menor, então ele perdeu a rodada e perdeu um ponto.");
                        if(dado3%2==0)
                            System.out.println("O jogador "+jog1.getNome()+" jogou o dado novamente e obteve "+dado3+". Como "+dado3+" é par, "+jog1.getNome()+" ganhou um ponto!");
                        else
                            System.out.println("O jogador "+jog1.getNome()+" jogou o dado novamente e obteve "+dado3+". Como "+dado3+" é ímpar, "+jog1.getNome()+" não somou pontos.");
                    }
                    else if(rod.getUpgradeJog1()<rod.getUpgradeJog2())
                    {
                        System.out.println("O poder de "+jog1.getNome()+" é menor, então ele perdeu a rodada e perdeu um ponto.");
                        dado3 = jogaDado();
                        if(dado3%2==0)
                            System.out.println("O jogador "+jog2.getNome()+" jogou o dado novamente e obteve "+dado3+". Como "+dado3+" é par, "+jog2.getNome()+" ganhou um ponto!");
                        else
                            System.out.println("O jogador "+jog2.getNome()+" jogou o dado novamente e obteve "+dado3+". Como "+dado3+" é ímpar, "+jog2.getNome()+" não somou pontos.");
                    }
                    else
                        System.out.println("Os poderes de "+jog1.getNome()+" e "+jog2.getNome()+" são iguais, então ninguém perdeu pontos.");
                }
            }
            System.out.println("----- Fim de Jogo -----");
            if(vencedor(jog1, jog2)==jog1)
            {
                System.out.println("O grande vencedor foi "+jog1.getNome()+", que ficou com "+jog1.getPontos()+" ponto(s), enquanto "+jog2.getNome()+" ficou com "+jog2.getPontos()+" ponto(s)!");
                if(a==0){
                    System.out.println("Parabéns, você desbloqueou o personagem SAMUEL!!!");
                    a++;
                }
                else if((a==1) && ("Samuel".equals(jog1.getNome()))){
                    System.out.println("Parabéns, você desbloqueou o personagem supremo DIDI!!!");
                    a++;
                }
                else if("Didi".equals(jog1.getNome()))
                {
                    System.out.println("Parabéns, você ganhou com o personagem supremo e zerou o jogo!!!");
                    break;
                }
            }
            else if(vencedor(jog1, jog2)==jog2)
                System.out.println("O vencedor foi "+jog2.getNome()+", que ficou com "+jog2.getPontos()+" ponto(s), enquanto "+jog1.getNome()+" ficou com "+jog1.getPontos()+" ponto(s)!");
            else
                System.out.println("Houve um empate, "+jog1.getNome()+" e "+jog2.getNome()+" ficaram ambos com "+jog1.getPontos()+" ponto(s)!");
            do{
                System.out.println("Deseja jogar de novo (S/N)?");
                resposta = sc.nextLine();
                opcao = resposta.charAt(0);
                if(opcao!='S' && opcao!='s' && opcao!='N' && opcao!='n')
                    System.out.println("Resposta inválida, tente novamente.");
            }while(opcao!='S' && opcao!='s' && opcao!='N' && opcao!='n');
                if(opcao=='s' || opcao=='S')
                    System.out.println("Recomençando...");
                else
                    System.out.println("GAME OVER!");
            zeraPontos(jog1, jog2);
        }while(opcao=='s' || opcao=='S');
    }   
}