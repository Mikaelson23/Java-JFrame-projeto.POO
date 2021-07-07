import java.io.IOException;
import java.util.List;

public interface CardapioI {

    public boolean CadastrarComida(Comida comida);

    public boolean CadastrarBebida(Bebida bedida);

    public boolean alterarDiasComidas(List<Dia> novoDia, List<Comida> comida);

    public List<Comida> mostrarCardapioDia(Dia dia);

    public List<Comida> mostrarCardapio();

    public List<Bebida> mostrarCardapioBebida();

    public void gravarDados();

    public void recuperarDados();

    public String mostrarComidas();

    public String mostrarBebidas();

    public Comida pesquisaComidaPorNome(String nome);

    public Bebida pesquisaBebidaPorNome(String nome);

    public boolean removerComida(Comida comida);

    public boolean removerBebida(Comida comida);
    
}
