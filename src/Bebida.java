import java.io.Serializable;

public class Bebida implements Serializable {

    private String nome;
    private double valor;
    private boolean alcoolica;

    public Bebida(String nome, double valor, boolean ehalcoolica){
        this.nome = nome;
        this.valor = valor;
        this.alcoolica = ehalcoolica;
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

    public boolean isAlcoolica() {
        return alcoolica;
    }

    public void setAlcoolica(boolean alcoolica) {
        this.alcoolica = alcoolica;
    }

    public String toString(){
        return "\n| Nome: " + getNome() + "\n| " +
                "Valor: " + getValor() + "\n| " +
                "é alcoolica? " + String.valueOf(isAlcoolica()) + "\n";
    }


}
