import java.io.Serializable;
import java.util.List;

public class Comida implements Serializable{
    private String nome;
    private double valor;
    private String descricao;
    private List<Dia> dia;
    private int tempo;

    public Comida(String nome, double valor, String descricao, List<Dia> dia, int tempo) {
        this.nome = nome;
        this.valor = valor;
        this.descricao = descricao;
        this.dia = dia;
        this.tempo = tempo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Dia> getDia() {
        return dia;
    }

    public void setDia(List<Dia> dia) {
        this.dia = dia;
    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public String toString() {
        return  "\n|Prato do dia: " + getDia() + "\n|" +
                "Nome do prato: " + getNome() + "\n|" +
                "Descrição do prato: " + getDescricao() + "\n|" +
                "Valor:  $" + getValor();
    }
}
