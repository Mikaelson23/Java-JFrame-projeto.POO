import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class JanelaGUIV2 extends JFrame {
    JToolBar tollBarPedidos, toolBar;
    JButton pedidoComida, pedidoBebida;
    JLabel linha2;
    private String imagem = "Images" + File.separator + "giphy.gif";
    private String imagemVoltar = "Images" + File.separator + "voltar.png";
    ImageIcon Img = new ImageIcon(imagem);
    CardapioList cardapio = new CardapioList();

    public JanelaGUIV2(){
        super("Cardapio");
        cardapio.recuperarDados();
        setSize(800, 600); //tamanho da janela
        setLocation(100, 50);
        setResizable(false);
        toolBar = new JToolBar();
        tollBarPedidos = new JToolBar();
        add(toolBar);

        linha2 = new JLabel(Img, JLabel.CENTER);
        pedidoComida = new JButton("pedir comida");
        pedidoComida.addActionListener(new fazerPedido(cardapio, this));
        pedidoBebida = new JButton("Pedir bebida");
        pedidoBebida.addActionListener(new fazerPedidoBebida(cardapio, this));

        tollBarPedidos.add(pedidoComida);
        tollBarPedidos.add(pedidoBebida);

        JButton menuCardapio = new JButton("Cardapio");
        menuCardapio.addActionListener(new mostrarComidasAction(this,cardapio));

        JButton menuMostrarBebidas = new JButton("Bebidas");
        menuMostrarBebidas.addActionListener(new BebidasActionController(this,cardapio));

        JPanel espaco1 = new JPanel();

        JButton menuSistema = new JButton("Sobre");
        menuSistema.addActionListener(new mostrarSobre());

        JButton menuFuncionarios = new JButton("Fazer alterações");
        menuFuncionarios.addActionListener(new sistemaFuncionarios(this,cardapio));

        JButton menuSair = new JButton("Sair");
        menuSair.addActionListener( new sairAction(cardapio));

        toolBar.add(menuCardapio);
        toolBar.add(menuMostrarBebidas);
        toolBar.add(espaco1);
        toolBar.add(menuSistema);
        toolBar.add(menuFuncionarios);
        toolBar.add(menuSair);
        toolBar.setFloatable(false);
        tollBarPedidos.setFloatable(false);

        setLayout(new BorderLayout());
        add(BorderLayout.CENTER, linha2);
        add(BorderLayout.NORTH, toolBar);
        add(BorderLayout.SOUTH, tollBarPedidos);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        pack();
    }
    private class fazerPedido implements ActionListener {
        CardapioList cardapioList;
        JanelaGUIV2 janelaMain;

        public fazerPedido(CardapioList cardapio, JanelaGUIV2 janela) {
            this.cardapioList = cardapio;
            this.janelaMain = janela;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            janelaPedido pedidos = new janelaPedido(cardapio, janelaMain);
        }
    }


    private class fazerPedidoBebida implements ActionListener {
        CardapioList cardapioList;
        JanelaGUIV2 janelaMain;

        public fazerPedidoBebida(CardapioList cardapio, JanelaGUIV2 janela) {
            this.cardapioList = cardapio;
            this.janelaMain = janela;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            janelaPedidoBebida pedidos = new janelaPedidoBebida(cardapio, janelaMain);
        }
    }

    public static void main(String[] args) {
        JFrame janela = new JanelaGUIV2();
    }
}


