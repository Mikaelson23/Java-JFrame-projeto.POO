import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class BebidasActionController implements ActionListener {
    private JanelaGUIV2 janelaMain;
    private CardapioList sistema;
    private JButton alcoolica, naoAlcoolica;

    public BebidasActionController(JanelaGUIV2 janelaGUIV2, CardapioList cardapio) {
        this.janelaMain = janelaGUIV2;
        this.sistema = cardapio;

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        janelaMain.setVisible(false);
        JFrame janelaCardapioBebida = new JFrame();
        janelaCardapioBebida.setSize(400, 600);
        janelaCardapioBebida.setLocation(100, 50);
        janelaCardapioBebida.setResizable(false);
        janelaCardapioBebida.setBackground(Color.ORANGE);
        janelaCardapioBebida.setVisible(true);
        
        JPanel topo = new JPanel();
        alcoolica = new JButton("Alcoolica");
        alcoolica.setBackground(Color.orange);
        alcoolica.setEnabled(false);
        naoAlcoolica = new JButton("sem alcool");
        naoAlcoolica.setBackground(Color.PINK);
        naoAlcoolica.setEnabled(false);
        topo.add(alcoolica);
        topo.add(naoAlcoolica);

        List<Bebida> cardapioNovoBebida = sistema.mostrarCardapioBebida();
        janelaCardapioBebida.setLayout(new BorderLayout(5,5));
        JPanel mostrarBebidas = new JPanel();
        mostrarBebidas.setLayout(new GridLayout(3,cardapioNovoBebida.size()));

        for(Bebida u : cardapioNovoBebida){
            JButton a = new JButton(u.getNome());
            a.addActionListener(new mostrarSobreBebida(u));
            if(u.isAlcoolica()){
                a.setBackground(Color.orange);
            }else{
                a.setBackground(Color.PINK);
            }
            mostrarBebidas.add(a);
        }
        JScrollPane rolagem = new JScrollPane(mostrarBebidas);
        janelaCardapioBebida.add(topo, BorderLayout.NORTH);
        janelaCardapioBebida.add(rolagem, BorderLayout.CENTER);

        JButton voltar = new JButton("Voltar");
        voltar.addActionListener(new voltarJanela(janelaCardapioBebida, janelaMain));
        janelaCardapioBebida.add(voltar, BorderLayout.SOUTH);
    }

    private class mostrarSobreBebida implements ActionListener {
        private Bebida bebidas;
        public mostrarSobreBebida(Bebida bebida) {
            this.bebidas = bebida;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, bebidas.toString());
        }
    }
}

