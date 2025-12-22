/*
TAD para representar partida (português)
@author arthurpereira
@author athossilvano
@author samuelmiranda
*/
package ifnmg.backend;

public class Partida {
    private int id;
    private String jog1Nome;
    private String jog2Nome;
    private int jog1Pontos;
    private int jog2Pontos;

    public Partida(int id, String jog1Nome, String jog2Nome, int jog1Pontos, int jog2Pontos) {
        this.id = id;
        this.jog1Nome = jog1Nome;
        this.jog2Nome = jog2Nome;
        this.jog1Pontos = jog1Pontos;
        this.jog2Pontos = jog2Pontos;
    }    
    @Override
    public String toString() {
        if("Léo".equals(jog1Nome)&&"Caio".equals(jog2Nome)){
            if(jog1Pontos>jog2Pontos)
                return "\n----- "+id+"ª Partida -----\n"+jog1Nome+" venceu a partida com "+jog1Pontos+" pontos! "+jog2Nome+" perdeu a partida com "+jog2Pontos+" pontos.";
            else if(jog1Pontos<jog2Pontos)
                return "\n----- "+id+"ª Partida -----\n"+jog2Nome+" venceu a partida com "+jog2Pontos+" pontos! "+jog1Nome+" perdeu a partida com "+jog1Pontos+" pontos.";
            else
                return "\n----- "+id+"ª Partida -----\n"+jog1Nome+" e "+jog2Nome+" empataram na partida com "+jog1Pontos+" pontos.";
        }
        else{
            if(jog1Pontos>jog2Pontos)
                return "\n----- "+id+"ª Partida -----\n"+jog1Nome+" (você) venceu a partida com "+jog1Pontos+" pontos! "+jog2Nome+" (computador) perdeu a partida com "+jog2Pontos+" pontos.";
            else if(jog1Pontos<jog2Pontos)
                return "\n----- "+id+"ª Partida -----\n"+jog2Nome+" (computador) venceu a partida com "+jog2Pontos+" pontos! "+jog1Nome+" (você) perdeu a partida com "+jog1Pontos+" pontos.";
            else
                return "\n----- "+id+"ª Partida -----\n"+jog1Nome+" (você) e "+jog2Nome+" (computador) empataram na partida com "+jog1Pontos+" pontos.";
        }
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