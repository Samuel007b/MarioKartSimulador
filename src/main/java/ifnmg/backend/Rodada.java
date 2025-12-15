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
    public String toString() {
        return "\nRodada{" + "tipo=" + tipo + ", id=" + id + ", jog1=" + jog1.getNome() + ", jog2=" + jog2.getNome() + ", upgradeJog1=" + upgradeJog1 + ", upgradeJog2=" + upgradeJog2 + '}';
    }
}
