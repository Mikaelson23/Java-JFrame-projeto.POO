import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class voltarJanela implements ActionListener {
    JFrame janelaAtual;
    JFrame janelaPrincipal;
    public voltarJanela(JFrame janelaCardapio, JFrame janela) {
        this.janelaAtual = janelaCardapio;
        this.janelaPrincipal = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        janelaAtual.setVisible(false);
        janelaPrincipal.setVisible(true);
    }
}