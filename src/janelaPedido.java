import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class janelaPedido extends JFrame {
    private Pedido funcaoPedido = new Pedido();
    private JTextField nomeCliente;
    private JLabel titulo;
    private String quant;
    private JScrollPane rolagem;

    public janelaPedido(CardapioList cardapio, JanelaGUIV2 janela) {
        super("Pedidos");
        janela.setVisible(false);
        setSize(700, 500);
        setLocation(150, 150);
        setResizable(false);
        setBackground(Color.ORANGE);
        List<Comida> cardapioNovo = cardapio.mostrarCardapio();
        nomeCliente = new JTextField(10);
        titulo = new JLabel("Digite seu nome:",SwingConstants.CENTER);
        this.setLayout(new BorderLayout(5,5));

        JPanel jpanelTopo = new JPanel();
        JPanel jpanelCentro = new JPanel();
        jpanelCentro.setLayout(new GridLayout(cardapioNovo.size(),3));

        jpanelTopo.add(titulo);
        jpanelTopo.add(nomeCliente);

        String clienteText = nomeCliente.getText();
        Cliente nome = new Cliente(clienteText);

        List<ItemDePedido> listaDeComidasMap = new ArrayList<>();
        for (Comida u : cardapioNovo) {
            JRadioButton radioButton = new JRadioButton(u.getDescricao(),false);
            JTextField quantidade = new JTextField(3);
            JButton adicionar = new JButton("Por pedido");
            quantidade.setEnabled(false);
            jpanelCentro.add(radioButton);
            jpanelCentro.add(quantidade);
            jpanelCentro.add(adicionar);



            ActionListener clickRadioButton = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(radioButton.isSelected()){
                        quantidade.setEnabled(true);
                    }else{
                        quantidade.setEnabled(false);
                        listaDeComidasMap.remove(u);
                    }
                }
            };
            ActionListener botaoAdicionar = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    quant = quantidade.getText();
                    if(quant!=null){
                        ItemDePedido novoItem = new ItemDePedido(u,Integer.parseInt(quant));
                        listaDeComidasMap.add(novoItem);
                        JOptionPane.showMessageDialog(null, listaDeComidasMap.toString());
                    }else{
                        JOptionPane.showMessageDialog(null, "digite um valor");
                    }

                }
            };
            adicionar.addActionListener(botaoAdicionar);
            radioButton.addActionListener(clickRadioButton);
        }

        JPanel sairOrCadastrar = new JPanel();

        JButton voltar = new JButton("Voltar");
        voltar.addActionListener(new voltarJanela(this, janela));
        sairOrCadastrar.add(voltar);

        JButton fazerPedido = new JButton("Finalizar Pedido");
        fazerPedido.addActionListener(new confirmarPedido(listaDeComidasMap,funcaoPedido,nome));
        sairOrCadastrar.add(fazerPedido);

        rolagem = new JScrollPane(jpanelCentro);

        this.add(jpanelTopo, BorderLayout.NORTH);
        this.add(rolagem);
        this.add(sairOrCadastrar, BorderLayout.SOUTH);
//        pack();
        setVisible(true);
    }

    private class confirmarPedido implements ActionListener {
        private List<ItemDePedido> comidaList;
        private Pedido comanda;
        private Cliente cliente;


        public confirmarPedido(List<ItemDePedido> listaDeComidas, Pedido funcaoPedido, Cliente nome) {
            this.comidaList = listaDeComidas;
            this.comanda = funcaoPedido;
            this.cliente= nome;

        }
        @Override
        public void actionPerformed(ActionEvent e) {
            double valor = 0;
            if(comanda.fazerPedido(cliente,comidaList)){
                for(ItemDePedido u: comidaList) {
                    valor = valor + (u.getPedidoDaComida().getValor() * u.getQuantidadeDaLista());
                }
            }
            JOptionPane.showMessageDialog(null,"Presado cliente " + nomeCliente.getText() + "\n"
                        + "Sua comida sairá em: " + comanda.tempoPedido(comidaList) + " minutos.\n"+ "valor: R$"+ valor);
        }
    }
}