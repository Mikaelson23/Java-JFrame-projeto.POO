//import org.junit.jupiter.api.Test;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class SistemaRestauranteJunitTests {
//
//    @Test
//    public void CardapioList() throws DiaNaoExisteException {
//        CardapioList sistema = new CardapioList();
//        List<Comida> comidas = sistema.mostrarCardapio();
//        Pedido pedidos = new Pedido();
//        assertEquals(comidas.size(), 0);
//        Comida novaComida = new Comida("bolo", 5.0,
//                "Bolo de morango", Dia.SEGUNDA, "Sobremesa", 10);
//        Comida novaComida2 = new Comida("bolo", 10.0,
//                "Bolo de amora",null, "Sobremesa", 60);
//        Comida novaComida3 = new Comida(null, 5.0,
//                "Bolo de morango", Dia.QUARTA, "Sobremesa", 10);
//        ///esses testes devem retornar corretamente o que foi cadastrado
//        comidas.add(novaComida);
//        assertTrue(comidas.size()!=0);
//        assertTrue(sistema.CadastrarComida(novaComida));
//        ///esse teste é para falhar ,ja que não foi cadastrado o "bolo de amora, mas aparecerá Joptionspane para
//        ///alteraçoes dos valores cadastrados do dia que der erro, fazendo assim os testes darem true
//        assertTrue(sistema.criarCardapioDeUmDia(Dia.TERCA,Dia.QUARTA));
//        assertTrue(sistema.CadastrarComida(novaComida2));
//        assertTrue(sistema.CadastrarComida(novaComida3));
//        ///Aqui faz o pedido do cliente
//        Cliente cliente = new Cliente("kell");
//        List<Comida> comidaList = sistema.mostrarCardapio();
//        ///Aqui vamos estar testando se a lista de componentes que correspondem a uma lista de comidas verificando se
//        ///o valor que é devolvido é o mesmo que temos para comparar
//        assertEquals(comidaList.size(), 3);
//        ///Aqui vamos estar testar se o objeto que pesquisamos é de fato o que esta sendo comparado
//        assertSame(sistema.pesquisaComidaPorNome("Bolo de morango"), novaComida);
//        assertNotSame(sistema.pesquisaComidaPorNome("Bolo de morango"), novaComida2);
//        assertSame("Sobremesa", sistema.pesquisaComidaPorNome("Bolo de amora").getTipo());
//    }
//}
//
