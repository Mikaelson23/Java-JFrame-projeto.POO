import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class JanelaCadastrarComida {
    CardapioList cadastrarNoSistema;
    JTextField valorComida,descricaoComida,tempoComida;
    Dia[] a = {Dia.SEGUNDA, Dia.TERCA, Dia.QUARTA, Dia.QUINTA, Dia.SEXTA, Dia.SABADO, Dia.DOMINGO};
    List<Dia> diasEscolhidosCadastro = new ArrayList<>();
    String nome = "";
    public JanelaCadastrarComida(CardapioList sistema){
        this.cadastrarNoSistema = sistema;
        JFrame janelaTratarDados = new JFrame();
        janelaTratarDados.setSize(300,600);
        janelaTratarDados.setLocation(100, 100);
        janelaTratarDados.setResizable(false);
        janelaTratarDados.setBackground(Color.BLACK);
        janelaTratarDados.setTitle("Nova Comida");
        janelaTratarDados.setVisible(true);
//        janelaTratarDados.setLayout(new GridLayout(12, 4));
        janelaTratarDados.setLayout(new BorderLayout(5,5));

        JToolBar tipo = new JToolBar();
        JToolBar valorAndDescricao = new JToolBar(JToolBar.VERTICAL);
        JToolBar diasAndCadastrar = new JToolBar(JToolBar.VERTICAL);
        tipo.setFloatable(false);
        valorAndDescricao.setFloatable(false);
        diasAndCadastrar.setFloatable(false);

        JCheckBox tipoAlmoco = new JCheckBox("almoço", false);
        JCheckBox tipoCafe = new JCheckBox("café da manhã", false);
        JCheckBox tipoJantar = new JCheckBox("Jantar", false);
        tipo.add(tipoCafe);
        tipo.add(tipoAlmoco);
        tipo.add(tipoJantar);
        ActionListener qualtipo = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(tipoAlmoco.isSelected()){
                    nome = tipoAlmoco.getText();
                }else if(tipoCafe.isSelected()){
                    nome = tipoCafe.getText();
                }else{
                    nome = tipoJantar.getText();
                }
            }
        };
        tipoCafe.addActionListener(qualtipo);
        tipoAlmoco.addActionListener(qualtipo);
        tipoJantar.addActionListener(qualtipo);



        JLabel valor = new JLabel("valor do prato");
        valorComida = new JTextField(10);
        valorAndDescricao.add(valor);
        valorAndDescricao.add(valorComida);

        JLabel descricao = new JLabel("descrição do prato");
        descricaoComida = new JTextField(10);
        valorAndDescricao.add(descricao);
        valorAndDescricao.add(descricaoComida);


        for(Dia dias: a){
            JCheckBox dia = new JCheckBox(dias.name(),false);
            diasAndCadastrar.add(dia);
            ActionListener click = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(dia.isSelected()){
                        diasEscolhidosCadastro.add(dias);
                    }else{
                        diasEscolhidosCadastro.remove(dias);
                    }
                }
            };
            dia.addActionListener(click);
        }

        JLabel tempo = new JLabel("tempo do prato");
        tempoComida = new JTextField(10);
        valorAndDescricao.add(tempo);
        valorAndDescricao.add(tempoComida);

        JButton cadastrar = new JButton("Cadastrar Comida");
        diasAndCadastrar.add(cadastrar);
        cadastrar.addActionListener(new cadastrarComida(janelaTratarDados));

        janelaTratarDados.add(tipo, BorderLayout.NORTH);
        janelaTratarDados.add(valorAndDescricao, BorderLayout.CENTER);
        janelaTratarDados.add(diasAndCadastrar, BorderLayout.SOUTH);



        janelaTratarDados.setVisible(true);
//        janelaTratarDados.pack();
    }

    private class cadastrarComida implements ActionListener {
        private JFrame janelaMain3;
        public cadastrarComida(JFrame janelaTratarDados) {
            this.janelaMain3 = janelaTratarDados;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(nome + valorComida.getText() + descricaoComida.getText());
            Comida novissima = new Comida(nome, Double.parseDouble(valorComida.getText()),descricaoComida.getText(),
                    diasEscolhidosCadastro,Integer.parseInt(tempoComida.getText()));
            if(cadastrarNoSistema.CadastrarComida(novissima)){
                janelaMain3.dispose();
                JOptionPane.showMessageDialog(null, novissima.toString());
            }else{
                JOptionPane.showMessageDialog(null, "Não cadastrada");
            }
        }
    }
}

