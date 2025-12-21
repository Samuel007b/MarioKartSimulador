/*
TAD para representar partida (espanhol)
@author arthurpereira
@author athossilvano
@author samuelmiranda
*/
package ifnmg.backend;

public class Partido {
    private int id;
    private String jog1Nome;
    private String jog2Nome;
    private int jog1Pontos;
    private int jog2Pontos;

    public Partido(int id, String jog1Nome, String jog2Nome, int jog1Pontos, int jog2Pontos) {
        this.id = id;
        this.jog1Nome = jog1Nome;
        this.jog2Nome = jog2Nome;
        this.jog1Pontos = jog1Pontos;
        this.jog2Pontos = jog2Pontos;
    }    
    @Override
    public String toString() {
        if(jog1Pontos>jog2Pontos)
            return "\n----- "+id+"º Partido -----\n¡"+jog1Nome+" (tú) ganó el partido con "+jog1Pontos+" puntos! "+jog2Nome+" (computadora) perdió el partido con "+jog2Pontos+" puntos.";
        else if(jog1Pontos<jog2Pontos)
            return "\n----- "+id+"º Partido -----\n¡"+jog2Nome+" (computadora) ganó el partido con "+jog2Pontos+" puntos! "+jog1Nome+" (tú) perdió el partido con "+jog1Pontos+" puntos.";
        else
            return "\n----- "+id+"º Partido -----\n"+jog1Nome+" (tú) y "+jog2Nome+" (computadora) empataron en el partido con "+jog1Pontos+" puntos.";
    }
    public int getId() {
        return id;
    }
    public int getJog1Pontos() {
        return jog1Pontos;
    }
    public int getJog2Pontos() {
        return jog2Pontos;
    }
    public String getJog1Nome() {
        return jog1Nome;
    }
    public String getJog2Nome() {
        return jog2Nome;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setJog1Pontos(int jog1Pontos) {
        this.jog1Pontos = jog1Pontos;
    }
    public void setJog2Pontos(int jog2Pontos) {
        this.jog2Pontos = jog2Pontos;
    }
    public void setJog1Nome(String jog1Nome) {
        this.jog1Nome = jog1Nome;
    }
    public void setJog2Nome(String jog2Nome) {
        this.jog2Nome = jog2Nome;
    }
}