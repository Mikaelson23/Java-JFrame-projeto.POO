import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Pedido {
    private Map<Cliente, List<Comida>> pedidos;
    private Map<Cliente, List<Bebida>> pedidoBebida;

    public Pedido() {
        this.pedidos = new HashMap<Cliente, List<Comida>>();
        this.pedidoBebida = new HashMap<Cliente, List<Bebida>>();

    }

    public boolean fazerPedido(Cliente cliente, List<ItemDePedido> comida) {
        if (this.pedidos.containsValue(cliente)) {
            return false;
        } else {
            List<Comida> listaDePedido = new ArrayList<>();
            for (ItemDePedido zz : comida) {
                listaDePedido.add(zz.getPedidoDaComida());
            }
            this.pedidos.put(cliente, listaDePedido);
            return true;
        }
    }
    public boolean fazerPedidoBebida(Cliente cliente, List<ItemDePedido> bebida) {
        if (this.pedidos.containsValue(cliente)) {
            return false;
        } else {
            List<Bebida> listaDePedido = new ArrayList<>();
            for (ItemDePedido zz : bebida) {
                listaDePedido.add(zz.getPedidoBebida());
            }
            this.pedidoBebida.put(cliente, listaDePedido);
            return true;
        }
    }

    public int tempoPedido(List<ItemDePedido> comida){
        int tempoMaximo = 0;
        for(ItemDePedido u: comida){
            if(u.getPedidoDaComida().getTempo()>tempoMaximo){
                tempoMaximo = u.getPedidoDaComida().getTempo();
            }
        }
        return tempoMaximo;
    }

}
