import java.util.List;

public class ItemDePedido {
    private Comida pedidoDaComida;
    private Bebida pedidoBebida;
    private int quantidadeDaLista;

    public ItemDePedido(Comida pedido, int quantidade){
        this.pedidoDaComida = pedido;
        this.quantidadeDaLista = quantidade;
    }

    public ItemDePedido(Bebida bebida, int quantidade) {
        this.pedidoBebida = bebida;
        this.quantidadeDaLista = quantidade;
    }

    public Comida getPedidoDaComida() {
        return pedidoDaComida;
    }

    public void setPedidoDaComida(Comida pedidoDaComida) {
        this.pedidoDaComida = pedidoDaComida;
    }

    public int getQuantidadeDaLista() {
        return quantidadeDaLista;
    }

    public void setQuantidadeDaLista(int quantidadeDaLista) {
        this.quantidadeDaLista = quantidadeDaLista;
    }

    public Bebida getPedidoBebida() {
        return pedidoBebida;
    }

    public void setPedidoBebida(Bebida pedidoBebida) {
        this.pedidoBebida = pedidoBebida;
    }

    public String toString(String tipo) {
        if(tipo.equals("comida")) return getPedidoDaComida().toString();
        else return getPedidoBebida().toString();
    }

}
