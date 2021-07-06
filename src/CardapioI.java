import java.io.IOException;
import java.util.List;

public interface CardapioI {

    public boolean CadastrarComida(Comida comida);

    public boolean CadastrarBebida(Bebida bedida);

    public boolean alterarDiasComidas(List<Dia> novoDia, List<Comida> comida);

    public List<Comida> mostrarCardapioDia(Dia dia);

    public List<Comida> mostrarCardapio();

    public void recuperarDados() throws IOException;

    public String mostrarComidas();

    public String mostrarBebidas();

}
