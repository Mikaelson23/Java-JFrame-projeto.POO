import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JanelaCadastrarBebida {
    CardapioList cadastrarNoSistema;
    JTextField nomeBebida, valorBebida;
    JCheckBox alcolicaBebida;

    public JanelaCadastrarBebida(CardapioList sistema){
        this.cadastrarNoSistema = sistema;
        JFrame janelaTratarDados = new JFrame();
        janelaTratarDados.setSize(500, 500);
        janelaTratarDados.setLocation(100, 100);
        janelaTratarDados.setResizable(false);
        janelaTratarDados.setBackground(Color.BLACK);
        janelaTratarDados.setTitle("Nova Comida");
        janelaTratarDados.setVisible(true);
        janelaTratarDados.setLayout(new GridLayout(12, 4));

        JLabel nome = new JLabel("nome da bebida");
        nomeBebida = new JTextField();
        janelaTratarDados.add(nome);
        janelaTratarDados.add(nomeBebida);

        JLabel valor = new JLabel("valor da bebida");
        valorBebida = new JTextField();
        janelaTratarDados.add(valor);
        janelaTratarDados.add(valorBebida);

        JLabel alcolica = new JLabel("é alcolica?");
        alcolicaBebida = new JCheckBox("selecione se for alcolica",false);
        janelaTratarDados.add(alcolica);
        janelaTratarDados.add(alcolicaBebida);

        JButton cadastrar = new JButton("Cadastrar Bebida");
        janelaTratarDados.add(cadastrar);
        cadastrar.addActionListener(new cadastrarBebida(janelaTratarDados));

        janelaTratarDados.setVisible(true);
        janelaTratarDados.pack();
    }

    private class cadastrarBebida implements ActionListener {
        private JFrame janelaMain3;
        public cadastrarBebida(JFrame janelaTratarDados) {
            this.janelaMain3 = janelaTratarDados;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            Bebida novissima = new Bebida(nomeBebida.getText(),Double.parseDouble(valorBebida.getText()),alcolicaBebida.isSelected());
            if(cadastrarNoSistema.CadastrarBebida(novissima)){
                janelaMain3.dispose();
                JOptionPane.showMessageDialog(null, novissima.toString());
            }else{
                JOptionPane.showMessageDialog(null, "Não cadastrada");
            }
        }
    }
}

