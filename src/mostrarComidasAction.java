import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class mostrarComidasAction implements ActionListener {
    Dia[] a = {Dia.SEGUNDA, Dia.TERCA, Dia.QUARTA, Dia.QUINTA, Dia.SEXTA, Dia.SABADO, Dia.DOMINGO};
    private CardapioList cardapio;
    private JanelaGUIV2 janela;

    public mostrarComidasAction(JanelaGUIV2 janelaGUIV2, CardapioList cardapio) {
        this.cardapio = cardapio;
        this.janela = janelaGUIV2;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        janela.setVisible(false);
        JFrame janelaCardapio = new JFrame();
        janelaCardapio.setLocation(100, 50);
        janelaCardapio.setResizable(false);
        janelaCardapio.setVisible(true);
        List<Comida> cardapioNovo = cardapio.mostrarCardapio();
        janelaCardapio.setLayout(new BorderLayout(5,5));

        JToolBar diasJPanel = new JToolBar();
        JPanel comidasCardapio = new JPanel();
        diasJPanel.setFloatable(false);

        for(Comida u : cardapioNovo){
            JButton a = new JButton(u.getDescricao());
            if(u.getNome().equals("café da manhã")){
                a.setBackground(new Color(240,255,240));
            }else if(u.getNome().equals("almoco")){
                a.setBackground(new Color(255,218,185));
            }else{
                a.setBackground(new Color(176,224,230));
            }
            a.addActionListener(new mostrarSobreComida(u));
            comidasCardapio.add(a);
        }

        JButton voltar = new JButton("Voltar");
        voltar.addActionListener(new voltarJanela(janelaCardapio, janela));

        janelaCardapio.add(diasJPanel, BorderLayout.NORTH);
        janelaCardapio.add(comidasCardapio, BorderLayout.CENTER);
        janelaCardapio.add(voltar, BorderLayout.SOUTH);
        janelaCardapio.pack();
    }

    private class mostrarSobreComida implements ActionListener {
        private Comida comida;
        public mostrarSobreComida(Comida a) {
            this.comida = a;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, comida.toString());
        }
    }
}