import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class BebidasActionController implements ActionListener {
    private JanelaGUIV2 janelaMain;
    private CardapioList sistema;

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
        List<Bebida> cardapioNovoBebida = sistema.mostrarCardapioBebida();
        int valor = cardapioNovoBebida.size()/2 + 1;
        janelaCardapioBebida.setLayout(new GridLayout(valor, 3));

        for(Bebida u : cardapioNovoBebida){
            JButton a = new JButton(u.getNome());
            a.addActionListener(new mostrarSobreBebida(u));
            janelaCardapioBebida.add(a);
        }

        JButton voltar = new JButton("Voltar");
        voltar.addActionListener(new voltarJanela(janelaCardapioBebida, janelaMain));
        janelaCardapioBebida.add(voltar);
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

