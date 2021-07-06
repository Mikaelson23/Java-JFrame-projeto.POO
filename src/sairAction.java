import javax.swing.*;
import java.awt.event.ActionEvent;

public class sairAction extends AbstractAction  {

    private CardapioList cardapioList;

    public sairAction(CardapioList cardapioList) {
        this.cardapioList = cardapioList;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        cardapioList.gravarDados();
        System.exit(0);
    }
}
