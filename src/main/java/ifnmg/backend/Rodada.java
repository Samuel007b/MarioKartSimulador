/*
TAD para representar rodadas
@author arthurpereira
@author athossilvano
@author samuelmiranda
*/
package ifnmg.backend;

public class Rodada {
    public static final String PISTAS[] = {"RETA", "CURVA", "CONFRONTO"};
    private String tipo;
    private int id;
    private Personagem jog1;
    private Personagem jog2;
    private int upgradeJog1;
    private int upgradeJog2;
    public Rodada(int id){
        this.id=id;
    }
    public Rodada(String tipo, int id, Personagem jog1, Personagem jog2){
        this.tipo = tipo;
        this.id=id;
        this.jog1 = jog1;
        this.jog2 = jog2;
    }
    public Rodada(String tipo, int id, Personagem jog1, Personagem jog2, int upgradeJog1, int upgradeJog2) {
        this.tipo = tipo;
        this.id = id;
        this.jog1 = jog1;
        this.jog2 = jog2;
        this.upgradeJog1 = upgradeJog1;
        this.upgradeJog2 = upgradeJog2;
    }
    public String getTipo() {
        return tipo;
    }
    public int getId() {
        return id;
    }
    public Personagem getJog1() {
        return jog1;
    }
    public Personagem getJog2() {
        return jog2;
    }
    public int getUpgradeJog1() {
        return upgradeJog1;
    }
    public int getUpgradeJog2() {
        return upgradeJog2;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setJog1(Personagem jog1) {
        this.jog1 = jog1;
    }
    public void setJog2(Personagem jog2) {
        this.jog2 = jog2;
    }
    public void setUpgradeJog1(int upgradeJog1) {
        this.upgradeJog1 = upgradeJog1;
    }
    public void setUpgradeJog2(int upgradeJog2) {
        this.upgradeJog2 = upgradeJog2;
    }
    @Override
    public String toString() {
        if("RETA".equals(tipo)){
            if(upgradeJog1>upgradeJog2)
                return "\n----- "+id+"ª Rodada -----\nA pista sorteada foi "+tipo+"\n"+jog1.getNome()+" ganhou com "+upgradeJog1+" de velocidade, enquanto "+jog2.getNome()+ "ficou com "+upgradeJog2+" de velocidade";
            else if(upgradeJog2>upgradeJog1)
                return "\n----- "+id+"ª Rodada -----\nA pista sorteada foi "+tipo+"\n"+jog2.getNome()+" ganhou com "+upgradeJog2+" de velocidade, enquanto "+jog1.getNome()+ "ficou com "+upgradeJog1+" de velocidade";
            else
                return "\n----- "+id+"ª Rodada -----\nA pista sorteada foi "+tipo+"\n"+jog1.getNome()+" e "+jog2.getNome()+" empataram com "+upgradeJog1+" de velocidade";
        }
        else if("CURVA".equals(tipo)){
            if(upgradeJog1>upgradeJog2)
                return "\n----- "+id+"ª Rodada -----\nA pista sorteada foi "+tipo+"\n"+jog1.getNome()+" ganhou com "+upgradeJog1+" de manobrabilidade, enquanto "+jog2.getNome()+" ficou com "+upgradeJog2+" de manobrabilidade";
            else if(upgradeJog2>upgradeJog1)
                return "\n----- "+id+"ª Rodada -----\nA pista sorteada foi "+tipo+"\n"+jog2.getNome()+" ganhou com "+upgradeJog2+" de manobrabilidade, enquanto "+jog1.getNome()+" ficou com "+upgradeJog1+" de manobrabilidade";
            else
                return "\n----- "+id+"ª Rodada -----\nA pista sorteada foi "+tipo+"\n"+jog1.getNome()+" e "+jog2.getNome()+" empataram com "+upgradeJog1+" de manobrabilidade";
        }
        else if("CONFRONTO".equals(tipo)){
            if(upgradeJog1>upgradeJog2)
                return "\n----- "+id+"ª Rodada -----\nA pista sorteada foi "+tipo+"\n"+jog1.getNome()+" ganhou com "+upgradeJog1+" de poder, enquanto "+jog2.getNome()+" ficou com "+upgradeJog2+" de poder";
            else if(upgradeJog2>upgradeJog1)
                return "\n----- "+id+"ª Rodada -----\nA pista sorteada foi "+tipo+"\n"+jog2.getNome()+" ganhou com "+upgradeJog2+" de poder, enquanto "+jog1.getNome()+" ficou com "+upgradeJog1+" de poder";
            else
                return "\n----- "+id+"ª Rodada -----\nA pista sorteada foi "+tipo+"\n"+jog1.getNome()+" e "+jog2.getNome()+" empataram com "+upgradeJog1+" de poder";
        }
        else if("STRAIGHT".equals(tipo)){
            if(upgradeJog1>upgradeJog2)
                return "\n----- Round "+id+" -----\nThe track drawn was "+tipo+"\n"+jog1.getNome()+" won with a speed of "+upgradeJog1+", while "+jog2.getNome()+" was left with a speed of"+upgradeJog2;
            else if(upgradeJog2>upgradeJog1)
                return "\n----- Round "+id+" -----\nThe track drawn was "+tipo+"\n"+jog2.getNome()+" won with a speed of "+upgradeJog2+", while "+jog1.getNome()+" was left with a speed of"+upgradeJog1;
            else
                return "\n----- Round "+id+" -----\nThe track drawn was "+tipo+"\n"+jog1.getNome()+" and "+jog2.getNome()+" tied with a speed of"+upgradeJog1;
        }
        else if("CURVE".equals(tipo)){
            if(upgradeJog1>upgradeJog2)
                return "\n----- Round "+id+" -----\nThe track drawn was "+tipo+"\n"+jog1.getNome()+" won with a maneuverability of "+upgradeJog1+", while "+jog2.getNome()+" was left with a maneuverability of"+upgradeJog2;
            else if(upgradeJog2>upgradeJog1)
                return "\n----- Round "+id+" -----\nThe track drawn was "+tipo+"\n"+jog2.getNome()+" won with a maneuverability of "+upgradeJog2+", while "+jog1.getNome()+" was left with a maneuverability of"+upgradeJog1;
            else
                return "\n----- Round "+id+" -----\nThe track drawn was "+tipo+"\n"+jog1.getNome()+" and "+jog2.getNome()+" tied with a maneuverability of"+upgradeJog1;
        }
        else if("CONFRONTATION".equals(tipo)){
            if(upgradeJog1>upgradeJog2)
                return "\n----- Round "+id+" -----\nThe track drawn was "+tipo+"\n"+jog1.getNome()+" won with a power of "+upgradeJog1+", while "+jog2.getNome()+" was left with a power of"+upgradeJog2;
            else if(upgradeJog2>upgradeJog1)
                return "\n----- Round "+id+" -----\nThe track drawn was "+tipo+"\n"+jog2.getNome()+" won with a power of "+upgradeJog2+", while "+jog1.getNome()+" was left with a power of"+upgradeJog1;
            else
                return "\n----- Round "+id+" -----\nThe track drawn was "+tipo+"\n"+jog1.getNome()+" and "+jog2.getNome()+" tied with a power of"+upgradeJog1;
        }
        else if("RECTA".equals(tipo)){
            if(upgradeJog1>upgradeJog2)
                return "\n----- "+id+"ª Ronda -----\nLa pista elegida fue "+tipo+"\n"+jog1.getNome()+" ganó con "+upgradeJog1+" de velocidad, mientras que "+jog2.getNome()+" terminó con "+upgradeJog2+" de velocidad";
            else if(upgradeJog2>upgradeJog1)
                return "\n----- "+id+"ª Ronda -----\nLa pista elegida fue "+tipo+"\n"+jog2.getNome()+" ganó con "+upgradeJog2+" de velocidad, mientras que "+jog1.getNome()+" terminó con "+upgradeJog1+" de velocidad";
            else
                return "\n----- "+id+"ª Ronda -----\nLa pista elegida fue "+tipo+"\n"+jog1.getNome()+" y "+jog2.getNome()+" empataron con una velocidad de "+upgradeJog1;
        }
        else if("CURVO".equals(tipo)){
            if(upgradeJog1>upgradeJog2)
                return "\n----- "+id+"ª Ronda -----\nLa pista elegida fue "+tipo+"\n"+jog1.getNome()+" ganó con "+upgradeJog1+" de maniobrabilidad, mientras que "+jog2.getNome()+" terminó con "+upgradeJog2+" de maniobrabilidad";
            else if(upgradeJog2>upgradeJog1)
                return "\n----- "+id+"ª Ronda -----\nLa pista elegida fue "+tipo+"\n"+jog2.getNome()+" ganó con "+upgradeJog2+" de maniobrabilidad, mientras que "+jog1.getNome()+" terminó con "+upgradeJog1+" de maniobrabilidad";
            else
                return "\n----- "+id+"ª Ronda -----\nLa pista elegida fue "+tipo+"\n"+jog1.getNome()+" y "+jog2.getNome()+" empataron con una maniobrabilidad de "+upgradeJog1;
        }
        else{
            if(upgradeJog1>upgradeJog2)
                return "\n----- "+id+"ª Ronda -----\nLa pista elegida fue "+tipo+"\n"+jog1.getNome()+" ganó con "+upgradeJog1+" de poder, mientras que "+jog2.getNome()+" terminó con "+upgradeJog2+" de poder";
            else if(upgradeJog2>upgradeJog1)
                return "\n----- "+id+"ª Ronda -----\nLa pista elegida fue "+tipo+"\n"+jog2.getNome()+" ganó con "+upgradeJog2+" de poder, mientras que "+jog1.getNome()+" terminó con "+upgradeJog1+" de poder";
            else
                return "\n----- "+id+"ª Ronda -----\nLa pista elegida fue "+tipo+"\n"+jog1.getNome()+" y "+jog2.getNome()+" empataron con un poder de "+upgradeJog1;
        }
    }
}