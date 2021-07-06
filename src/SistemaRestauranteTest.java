import javax.swing.*;
import java.io.IOException;
import java.util.List;

public class SistemaRestauranteTest {

    public static void main(String[] args) throws IOException {
        CardapioList sistema = new CardapioList();
        Pedido sistemaPedidos = new Pedido();
        sistema.recuperarDados();
        JOptionPane.showMessageDialog(null, "dados recuperados");

        Dia[] a = {Dia.SEGUNDA, Dia.TERCA, Dia.QUARTA, Dia.QUINTA, Dia.SEXTA, Dia.SABADO, Dia.DOMINGO};
        List<Comida> q = sistema.mostrarCardapio();
        for (Comida zz : q) {
            for (Dia u : a) {
                if (zz.getDia().equals(u)) {
                    System.out.println(zz.toString() + "\n");
                    System.out.println(sistema.mostrarComidas());
                }
            }
        }

//        Cliente novoCliente = new Cliente("Jose");
//        sistemaPedidos.fazerPedido(novoCliente,q);
//        CardapioMap.gravarDados(sistema);

    }
}




