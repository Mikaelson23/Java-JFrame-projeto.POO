import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class sistemaFuncionarios implements ActionListener {
    private CardapioList cardapio;
    private JanelaGUIV2 janela;
    private JButton cadastrarBebida, cadastrarComida, removerComida, removerBebida, criarCardapioDoDia, mostrarCardapioDeUmDia, mostrarComidasCardapio, mostrarBebidasCardapio, voltar;
    double senha = 1234;
    public sistemaFuncionarios(JanelaGUIV2 janelaGUIV2, CardapioList cardapioList) {
        this.cardapio = cardapioList;
        this.janela = janelaGUIV2;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        janela.setVisible(false);
        JFrame janelaFuncionarios = new JFrame();
        janelaFuncionarios.setSize(800, 600);
        janelaFuncionarios.setLocation(100, 100);
        janelaFuncionarios.setResizable(false);
        janelaFuncionarios.setBackground(Color.ORANGE);
        janelaFuncionarios.setLayout(new GridLayout(4, 2));

        cadastrarComida = new JButton("Cadastrar comida");
        cadastrarComida.addActionListener(new cadastrarComidaAction(janelaFuncionarios));
        criarCardapioDoDia = new JButton("Alterar dias de comidas do cardapio");
        criarCardapioDoDia.addActionListener(new criarCardapioDoDiaAction( janelaFuncionarios));
        cadastrarBebida = new JButton("Cadastrar Bebida");
        cadastrarBebida.addActionListener(new cadastrarBebidasAction( janelaFuncionarios));
        mostrarComidasCardapio = new JButton("mostrar as comidas do cardapio");
        mostrarComidasCardapio.addActionListener(new mostrarComidasAction(janelaFuncionarios));
        mostrarBebidasCardapio = new JButton("Mostrar bebidas do cardapio");
        mostrarBebidasCardapio.addActionListener(new mostrarBebidasAction( janelaFuncionarios));
        mostrarCardapioDeUmDia = new JButton("Mostrar cardapio de um dia");
        mostrarCardapioDeUmDia.addActionListener(new mostrarCardapioDeUmDiaAction(janelaFuncionarios));
        removerComida = new JButton("Remover uma comida");
        removerComida.addActionListener(new removerComidaAction(janelaFuncionarios));
        removerBebida = new JButton("Remover uma bebida");
        removerBebida.addActionListener(new removerBebidaAction(janelaFuncionarios));
        voltar = new JButton("Voltar");
        voltar.addActionListener(new voltarJanela(janelaFuncionarios,janela));

        try {
            double validacao = Double.parseDouble(JOptionPane.showInputDialog(null, "senha:\n","validação",JOptionPane.INFORMATION_MESSAGE));
            if(validacao == senha){
                janela.setVisible(false);
                janelaFuncionarios.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null, "Senha Incorreta","validação",JOptionPane.INFORMATION_MESSAGE);
                janelaFuncionarios.dispose();
                janela.setVisible(true);
            }
        }catch(NullPointerException validacao){
            janelaFuncionarios.dispose();
            janela.setVisible(true);
        }

        janelaFuncionarios.add(cadastrarComida);
        janelaFuncionarios.add(cadastrarBebida);
        janelaFuncionarios.add(criarCardapioDoDia);
        janelaFuncionarios.add(mostrarComidasCardapio);
        janelaFuncionarios.add(mostrarBebidasCardapio);
        janelaFuncionarios.add(mostrarCardapioDeUmDia);
        janelaFuncionarios.add(removerComida);
        janelaFuncionarios.add(removerBebida);
        janelaFuncionarios.add(voltar);
        janelaFuncionarios.pack();
    }

    private class mostrarComidasAction implements ActionListener {
        private JFrame janelaMain2;
        public mostrarComidasAction( JFrame sistemaFuncionarios) {
            this.janelaMain2 = sistemaFuncionarios;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            janelaMain2.setVisible(false);
            JFrame janelaMCA = new JFrame();
            janelaMCA.setSize(600, 400);
            janelaMCA.setLocation(100, 100);
            janelaMCA.setResizable(false);
            janelaMCA.setBackground(Color.ORANGE);
            janelaMCA.setVisible(true);

            List<Comida> cardapioNovo = cardapio.mostrarCardapio();
            int valor = cardapioNovo.size()/2 + 1;
            janelaMCA.setLayout(new GridLayout(valor, 3));

            for(Comida u : cardapioNovo){
                JLabel a = new JLabel(u.getDescricao(),SwingConstants.CENTER);
                a.setToolTipText(u.toString());
                janelaMCA.add(a);
            }
            JButton voltar = new JButton("Voltar");
            voltar.addActionListener(new voltarJanela(janelaMCA,janelaMain2));
            janelaMCA.add(voltar);
            janelaMCA.pack();
        }
    }

    private class cadastrarComidaAction implements ActionListener {
        private JFrame janelaMain2;
        public cadastrarComidaAction(JFrame sistemaFuncionarios) {
            this.janelaMain2 = sistemaFuncionarios;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            janelaMain2.setVisible(false);
            JFrame janelaCCA = new JFrame();
            janelaCCA.setSize(100, 100);
            janelaCCA.setLocation(100, 100);
            janelaCCA.setResizable(false);
            janelaCCA.setBackground(Color.BLACK);
            janelaCCA.setVisible(true);
            janelaCCA.setLayout(new GridLayout(2, 1));

            JButton voltar = new JButton("Voltar");
            voltar.addActionListener(new voltarJanela(janelaCCA,janelaMain2));

            JButton cadastrar = new JButton("Cadastrar");
            cadastrar.addActionListener(new comidaCadastro(cardapio));

            janelaCCA.add(cadastrar);
            janelaCCA.add(voltar);
            janelaCCA.pack();
        }
    }

    private class criarCardapioDoDiaAction implements ActionListener {
        private JFrame janelaMain2;
        public criarCardapioDoDiaAction(JFrame janelaFuncionarios) {
            this.janelaMain2 = janelaFuncionarios;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            janelaMain2.setVisible(false);
            JFrame janelaCCDDA = new JFrame();
            janelaCCDDA.setSize(100, 100);
            janelaCCDDA.setLocation(100, 100);
            janelaCCDDA.setResizable(false);
            janelaCCDDA.setVisible(true);
            janelaCCDDA.setLayout(new GridLayout(4, 2));

            Dia[] a = {Dia.SEGUNDA, Dia.TERCA, Dia.QUARTA, Dia.QUINTA, Dia.SEXTA, Dia.SABADO, Dia.DOMINGO};
            List<Dia> diasEscolhidos = new ArrayList<>();
            JLabel titulo = new JLabel("Selecione os dias\n a serem adicionados");
            janelaCCDDA.add(titulo);
            for(Dia dia: a){
                JRadioButton diaCaixa = new JRadioButton(String.valueOf(dia),false);
                janelaCCDDA.add(diaCaixa);
                ActionListener clickDiaComida = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(diaCaixa.isSelected()){
                            diasEscolhidos.add(dia);
                        }
                    }
                };
                diaCaixa.addActionListener(clickDiaComida);
            }
            JLabel espaco = new JLabel("");
            janelaCCDDA.add(espaco);
            JButton cadastrarComidaDia = new JButton("Continuar");
            cadastrarComidaDia.addActionListener(new diaComidaCadastro(diasEscolhidos));

            JButton voltar = new JButton("Voltar");
            voltar.addActionListener(new voltarJanela(janelaCCDDA,janelaMain2));

            janelaCCDDA.add(cadastrarComidaDia);
            janelaCCDDA.add(voltar);
            janelaCCDDA.pack();
        }

        private class diaComidaCadastro implements ActionListener {
            private List<Dia> listDia;
            public diaComidaCadastro(List<Dia> diasEscolhidos) {
                this.listDia = diasEscolhidos;
            }
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame janelaCCDDA = new JFrame();
                janelaCCDDA.setSize(300, 300);
                janelaCCDDA.setLocation(100, 100);
                janelaCCDDA.setResizable(false);
                janelaCCDDA.setVisible(true);
                janelaCCDDA.setLayout(new GridLayout(4, 2));
                List<Comida> cardapios = cardapio.mostrarCardapio();
                List<Comida> comidasEscolhidas = new ArrayList<>();
                for(Comida u: cardapios){
                    JRadioButton comidaList = new JRadioButton(u.getNome(),false);
                    janelaCCDDA.add(comidaList);
                    ActionListener clickComida = new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if(comidaList.isSelected()){
                                comidasEscolhidas.add(u);
                            }
                        }
                    };
                    comidaList.addActionListener(clickComida);
                }
                JButton alterar = new JButton("Alterar");
                janelaCCDDA.add(alterar);
                alterar.addActionListener(new alterarDias(comidasEscolhidas, listDia, janelaCCDDA));
            }

            private class alterarDias implements ActionListener {
                private List<Dia> listDia;
                private List<Comida> comidas;
                private JFrame janelaCadastro;

                public alterarDias(List<Comida> comidasEscolhidas, List<Dia> listDia, JFrame janelaCCDDA) {
                    this.listDia = listDia;
                    this.comidas = comidasEscolhidas;
                    this.janelaCadastro = janelaCCDDA;
                }

                @Override
                public void actionPerformed(ActionEvent e) {
                    cardapio.alterarDiasComidas(listDia, comidas);
                    janelaCadastro.setVisible(false);
                }
            }
        }
    }

    private class mostrarBebidasAction implements ActionListener {
        private JFrame janelaFuncionarios;
        public mostrarBebidasAction( JFrame janelaFuncionarios) {
            this.janelaFuncionarios = janelaFuncionarios;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame janelaCardapio = new JFrame();
            janelaCardapio.setSize(400, 600);
            janelaCardapio.setLocation(100, 50);
            janelaCardapio.setResizable(false);
            janelaCardapio.setBackground(Color.ORANGE);
            janelaCardapio.setVisible(true);
            List<Bebida> cardapioNovo = cardapio.mostrarCardapioBebida();
            int valor = cardapioNovo.size()/2 + 1;
            janelaCardapio.setLayout(new GridLayout(valor, 3));

            for(Bebida u : cardapioNovo){
                JButton a = new JButton(u.getNome());
                a.addActionListener(new mostrarSobreBebida(u));
                janelaCardapio.add(a);
            }

            JButton voltar = new JButton("Voltar");
            voltar.addActionListener(new voltarJanela(janelaCardapio, janela));
            janelaCardapio.add(voltar);
        }

        private class mostrarSobreBebida implements ActionListener {
            private Bebida bebida;
            public mostrarSobreBebida(Bebida u) {
                this.bebida = u;
            }
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, bebida.toString());
            }
        }
    }

    private class mostrarCardapioDeUmDiaAction implements ActionListener {
        private JFrame janela;
        public mostrarCardapioDeUmDiaAction(JFrame janelaFuncionarios) {
            this.janela = janelaFuncionarios;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame janelaCardapio = new JFrame();
            janelaCardapio.setSize(400, 600);
            janelaCardapio.setLocation(100, 50);
            janelaCardapio.setResizable(false);
            janelaCardapio.setBackground(Color.ORANGE);
            janelaCardapio.setVisible(true);
            List<Comida> cardapioNovo = cardapio.mostrarCardapio();
            int valor = cardapioNovo.size()/2 + 1;
            janelaCardapio.setLayout(new GridLayout(valor, 3));

            for(Comida u : cardapioNovo){
                JButton a = new JButton(u.getNome());
                a.addActionListener(new mostrarSobreComida(u));
                janelaCardapio.add(a);
            }

            JButton voltar = new JButton("Voltar");
            voltar.addActionListener(new voltarJanela(janelaCardapio, janela));
            janelaCardapio.add(voltar);
        }

        private class mostrarSobreComida implements ActionListener {
            private Comida mostrarComida;
            public mostrarSobreComida(Comida u) {
                this.mostrarComida = u;
            }
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, mostrarComida.toString());
            }
        }
    }

    private class cadastrarBebidasAction implements ActionListener {
        private JFrame janelaMain2;
        public cadastrarBebidasAction(JFrame janelaFuncionarios) {
            this.janelaMain2 = janelaFuncionarios;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            janelaMain2.setVisible(false);
            JFrame janelaCCA = new JFrame();
            janelaCCA.setSize(100, 100);
            janelaCCA.setLocation(100, 100);
            janelaCCA.setResizable(false);
            janelaCCA.setBackground(Color.BLACK);
            janelaCCA.setVisible(true);
            janelaCCA.setLayout(new GridLayout(2, 1));

            JButton voltar = new JButton("Voltar");
            voltar.addActionListener(new voltarJanela(janelaCCA,janelaMain2));

            JButton cadastrar = new JButton("Cadastrar");
            cadastrar.addActionListener(new bebidaCadastro());

            janelaCCA.add(cadastrar);
            janelaCCA.add(voltar);
            janelaCCA.pack();
        }

        private class bebidaCadastro implements ActionListener {
            public bebidaCadastro() {
            }
            @Override
            public void actionPerformed(ActionEvent e) {
                JanelaCadastrarBebida novaBebida = new JanelaCadastrarBebida(cardapio);
            }
        }
    }

    private class removerComidaAction implements ActionListener {
        private JFrame janelaMain2;
        public removerComidaAction(JFrame janelaFuncionarios) {
            this.janelaMain2 = janelaFuncionarios;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            janelaMain2.setVisible(false);
            JFrame janelaCCA = new JFrame();
            janelaCCA.setSize(400, 300);
            janelaCCA.setLocation(100, 100);
            janelaCCA.setResizable(false);
            janelaCCA.setVisible(true);
            janelaCCA.setLayout(new BorderLayout(5,5));

            JPanel comidas = new JPanel();
            List<Comida> listComidas = cardapio.mostrarCardapio();
            comidas.setLayout(new GridLayout(listComidas.size(),2));
            for(Comida u: listComidas){
                JLabel opcao = new JLabel(u.getDescricao());
                JButton retirar = new JButton("Remover");
                ActionListener retirarComida = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(cardapio.removerComida(u)){
                            JOptionPane.showMessageDialog(null, "removida");
                            comidas.remove(opcao);
                            comidas.remove(retirar);
                        }
                    }
                };
                retirar.addActionListener(retirarComida);
                comidas.add(opcao);
                comidas.add(retirar);
            }
            JScrollPane rolagem = new JScrollPane(comidas);

            JButton voltar = new JButton("Voltar");
            voltar.addActionListener(new voltarJanela(janelaCCA,janelaMain2));

            janelaCCA.add(rolagem,BorderLayout.CENTER);
            janelaCCA.add(voltar,BorderLayout.SOUTH);
        }
    }

    private class removerBebidaAction implements ActionListener {
        private JFrame janelaMain2;
        public removerBebidaAction(JFrame janelaFuncionarios) {
            this.janelaMain2 = janelaFuncionarios;

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            janelaMain2.setVisible(false);
            JFrame janelaCCA = new JFrame();
            janelaCCA.setSize(400, 300);
            janelaCCA.setLocation(100, 100);
            janelaCCA.setResizable(false);
            janelaCCA.setVisible(true);
            janelaCCA.setLayout(new BorderLayout(5,5));

            JPanel bebidas = new JPanel();
            List<Bebida> bebidaList = cardapio.mostrarCardapioBebida();
            bebidas.setLayout(new GridLayout(bebidaList.size(),2));
            for(Bebida u: bebidaList){
                JLabel opcao = new JLabel(u.getNome());
                JButton retirar = new JButton("Remover");
                bebidas.add(opcao);
                bebidas.add(retirar);
                ActionListener retirarComida = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(cardapio.removerBebida(u)){
                            JOptionPane.showMessageDialog(null, "removida");
                            bebidas.remove(opcao);
                            bebidas.remove(retirar);
                        }
                    }
                };
                retirar.addActionListener(retirarComida);
            }
            JScrollPane rolagem = new JScrollPane(bebidas);

            JButton voltar = new JButton("Voltar");
            voltar.addActionListener(new voltarJanela(janelaCCA,janelaMain2));

            janelaCCA.add(rolagem,BorderLayout.CENTER);
            janelaCCA.add(voltar,BorderLayout.SOUTH);
        }
    }
}
