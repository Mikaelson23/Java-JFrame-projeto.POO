import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SistemaRestauranteJunitTests {

    @Test
    public void CardapioList() throws DiaNaoExisteException {
        CardapioList sistema = new CardapioList();
        List<Comida> comidas = sistema.mostrarCardapio();
        Pedido pedidos = new Pedido();
        assertEquals(comidas.size(), 0);
        Comida novaComida = new Comida("Almoço", 5.0,
                "a", Collections.singletonList(Dia.SEGUNDA),  10);
        Comida novaComida2 = new Comida("Café da manhã", 10.0,
                "b",Collections.singletonList(Dia.SEGUNDA), 60);
        Comida novaComida3 = new Comida("Jantar", 5.0,
                "c",Collections.singletonList(Dia.SEGUNDA), 10);

        ///esses testes devem retornar corretamente o que foi cadastrado e dar false ja que foram sim cadastrados
        sistema.CadastrarComida(novaComida);
        assertFalse(sistema.CadastrarComida(novaComida));
        sistema.CadastrarComida(novaComida2);
        assertFalse(sistema.CadastrarComida(novaComida2));
        sistema.CadastrarComida(novaComida3);
        assertFalse(sistema.CadastrarComida(novaComida3));

        ///teste basico para alteração dos dias de uma comida
        Dia[] asd = {Dia.SEGUNDA,Dia.TERCA};
        assertTrue(sistema.alterarDiasComidas(Arrays.asList(asd),comidas));
        assertTrue(sistema.CadastrarComida(novaComida2));
        assertTrue(sistema.CadastrarComida(novaComida3));

        ///Aqui faz o pedido do cliente
        Cliente cliente = new Cliente("kell");
        List<Comida> comidaList = sistema.mostrarCardapio();

        ///Aqui vamos estar testando se a lista de componentes que correspondem a uma lista de comidas verificando se
        ///o valor que é devolvido é o mesmo que temos para comparar
        assertEquals(comidaList.size(), 3);

        ///Aqui vamos estar testar se o objeto que pesquisamos é de fato o que esta sendo comparado
        assertNotSame(sistema.pesquisaComidaPorNome("a"), novaComida2);
        assertSame(novaComida2, sistema.pesquisaComidaPorNome("b"));

        ///Aqui vamos estar tentando se esta sendo removido o objeto que mandarmos
        assertTrue(sistema.removerComida(novaComida));
        assertNull(sistema.pesquisaComidaPorNome("a"));
    }
}
