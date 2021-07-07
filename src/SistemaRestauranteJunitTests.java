import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SistemaRestauranteJunitTests {

    @Test
    public void CardapioList() throws DiaNaoExisteException {
        CardapioList sistema = new CardapioList();
        sistema.recuperarDados();
        List<Comida> comidas = sistema.mostrarCardapio();
        List<Bebida> bebidas = sistema.mostrarCardapioBebida();
        System.out.println(comidas);
        Pedido pedidos = new Pedido();
        ///esse teste testa se há elementos no arquivo que foram retornados
        ///que esta vazio e é para estar 0 mesmo
        assertEquals(comidas.size(), 0);
        assertEquals(bebidas.size(), 0);

        Comida novaComida = new Comida("Almoço", 5.0,
                "a", Collections.singletonList(Dia.SEGUNDA),  10);
        Comida novaComida2 = new Comida("Café da manhã", 10.0,
                "b",Collections.singletonList(Dia.SEGUNDA), 60);
        Comida novaComida3 = new Comida("Jantar", 5.0,
                "c",Collections.singletonList(Dia.SEGUNDA), 10);
        Bebida novaBebida = new Bebida("lata de cerveja", 2,true);
        Bebida novaBebida2 = new Bebida("refrigerante", 1.50,false);
        Bebida novaBebida3 = new Bebida("achocolatado", 1,false);

        ///esses testes devem retornar corretamente o que foi cadastrado e dar false ja que foram
        ///sim cadastradas as comidas
        sistema.CadastrarComida(novaComida);
        assertFalse(sistema.CadastrarComida(novaComida));
        sistema.CadastrarComida(novaComida2);
        assertFalse(sistema.CadastrarComida(novaComida2));
        sistema.CadastrarComida(novaComida3);
        assertFalse(sistema.CadastrarComida(novaComida3));

        ///esses testes devem retornar corretamente o que foi cadastrado e dar false ja que foram
        ///sim cadastradas as bebidas
        sistema.CadastrarBebida(novaBebida);
        assertFalse(sistema.CadastrarBebida(novaBebida));
        sistema.CadastrarBebida(novaBebida2);
        assertFalse(sistema.CadastrarBebida(novaBebida2));
        sistema.CadastrarBebida(novaBebida3);
        assertFalse(sistema.CadastrarBebida(novaBebida3));

        ///teste basico para alteração dos dias de uma comida
        Dia[] asd = {Dia.SEGUNDA,Dia.TERCA};
        assertTrue(sistema.alterarDiasComidas(Arrays.asList(asd),comidas));

        ///teste para ver a funcionalidade do metodo mostrarCardapioDia onde passamos um dia e é retornado
        ///umalista de comidas que estão naquele dia
        System.out.println(sistema.mostrarCardapioDia(Dia.SEGUNDA));
        assertEquals(sistema.mostrarCardapioDia(Dia.SEGUNDA).size(), 3);
        assertEquals(sistema.mostrarCardapioDia(Dia.QUARTA).size(), 0);

        ///Aqui faz o pedido do cliente
        Cliente cliente = new Cliente("kell");
        List<ItemDePedido> comidaLista = new ArrayList<>();
        ItemDePedido itemDePedido = new ItemDePedido(novaComida,2);
        ItemDePedido itemDePedido2 = new ItemDePedido(novaComida2,1);
        ItemDePedido itemDePedido3 = new ItemDePedido(novaComida3,2);
        comidaLista.add(itemDePedido);
        comidaLista.add(itemDePedido2);
        comidaLista.add(itemDePedido3);
        assertTrue(pedidos.fazerPedido(cliente, comidaLista));

        ///Aqui faz o pedido de uma bebida do cliente
        Cliente cliente2 = new Cliente("Lívia");
        List<ItemDePedido> bebidaList = new ArrayList<>();
        ItemDePedido pedidoBebida = new ItemDePedido(novaBebida,3);
        ItemDePedido pedidoBebida2 = new ItemDePedido(novaBebida2,6);
        ItemDePedido pedidoBebida3 = new ItemDePedido(novaBebida3,8);
        bebidaList.add(pedidoBebida);
        bebidaList.add(pedidoBebida2);
        bebidaList.add(pedidoBebida3);
        assertTrue(pedidos.fazerPedido(cliente, bebidaList));

        ///Aqui vamos estar testar se o objeto que pesquisamos é de fato o que esta sendo comparado
        assertNotSame(sistema.pesquisaComidaPorNome("a"), novaComida2);
        assertEquals(sistema.pesquisaComidaPorNome("b"), novaComida2);

        ///Aqui vamos estar tentando se esta sendo removido o objeto que mandarmos
        assertTrue(sistema.removerComida(novaComida));
        assertNull(sistema.pesquisaComidaPorNome("a"));

        ///Aqui iremos ver se no arquivo Cardapio há alguma comida após salvar com o Gravador de
        ///Dados
        sistema.gravarDados();
        assertNotNull(sistema.mostrarCardapio());

    }
}

