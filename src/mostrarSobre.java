import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mostrarSobre extends AbstractAction {

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "SOBRE O SISTEMA\n\nDesenvolvedores \nMikelson Wemeson\nFabiano Wanderlan\nKelner Xavier\nVersão: 2.1 (BETA)");
    }
}
