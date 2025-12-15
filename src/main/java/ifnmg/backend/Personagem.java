/*
TAD para representar personagens
@author arthurpereira
@author athossilvano
@author samuelmiranda
*/
package ifnmg.backend;

public class Personagem
{
    private int id;
    private String nome;
    private int velocidade;
    private int manobrabilidade;
    private int poder;
    private int pontos;
    private String imagem;
    public Personagem(){
        
    }
    public Personagem(int id, String nome, int velocidade, int manobrabilidade, int poder, String imagem, int pontos){
        this.id=id;
        this.nome=nome;
        this.velocidade=velocidade;
        this.manobrabilidade=manobrabilidade;
        this.poder=poder;
        this.imagem=imagem;
        this.pontos=pontos;
    }
    public int getId(){
        return id;
    }
    public String getNome(){
        return nome;
    }
    public int getVelocidade(){
        return velocidade;
    }
    public int getManobrabilidade(){
        return manobrabilidade;
    }
    public int getPoder(){
        return poder;
    }
    public String getImagem(){
        return imagem;
    }
    public int getPontos(){
        return pontos;
    }
    public void setId(int id){
        this.id=id;
    }
    public void setNome(String nome){
        this.nome=nome;
    }
    public void setVelocidade(int velocidade){
        this.velocidade=velocidade;
    }
    public void setManobrabilidade(int manobrabilidade){
        this.manobrabilidade=manobrabilidade;
    }
    public void setPoder(int poder){
        this.poder=poder;
    }
    public void setImagem(String nome){
        this.imagem=imagem;
    }
    public void setPontos(int pontos){
        if(pontos>=0)
            this.pontos=pontos;
    }
    public String toString() {
        return "\nPersonagem{" + "ID=" +id + ", nome=" + nome + ", velocidade=" + velocidade + ", manobrabilidade=" + manobrabilidade + ", poder=" + poder + ", imagem=" + imagem + ", pontuação=" + pontos + '}';
    }
}
