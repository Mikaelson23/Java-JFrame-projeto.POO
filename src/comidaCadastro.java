import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class comidaCadastro implements ActionListener {
    private CardapioList cardapioList;
    public comidaCadastro(CardapioList cardapioList) {
        this.cardapioList = cardapioList;

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JanelaCadastrarComida comidaNova = new JanelaCadastrarComida(cardapioList);
    }
}
