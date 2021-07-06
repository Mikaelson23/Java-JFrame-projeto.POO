import java.io.IOException;
import java.util.*;


public class CardapioList implements CardapioI{
    private List<Comida> comidaList;
    private List<Bebida> bebidaList;
    GravadorDeDados gravador = new GravadorDeDados();

    public CardapioList() {
        this.comidaList = new ArrayList<>();
        this.bebidaList = new ArrayList<>();
    }

    public boolean CadastrarComida(Comida comida) {
        if (this.comidaList.contains(comida)) {
            return false;
        } else {
            this.comidaList.add(comida);
            return true;
        }
    }
    public boolean CadastrarBebida(Bebida bedida) {
        if (this.bebidaList.contains(bedida)) {
            return false;
        } else {
            this.bebidaList.add(bedida);
            return true;
        }
    }

    @Override
    public boolean alterarDiasComidas(List<Dia> novoDia, List<Comida> comida) {
        for (Comida u : comida) {
            for(Dia d: novoDia){
                if (u.getDia().contains(d)) {
                    u.setDia(novoDia);
                    System.out.println("a");
                    break;
                }
            }
        }return true;
    }

    public List<Comida> mostrarCardapioDia(Dia dia) {
        List<Comida> cardapion = new ArrayList<>();
        for (Comida u : comidaList) {
            if (u.getDia().contains(dia)) {
                cardapion.add(u);
            }
        }
        return cardapion;
    }

    public List<Comida> mostrarCardapio() {
        return comidaList;
    }

    public List<Bebida> mostrarCardapioBebida(){
        return bebidaList;
    }

    public void gravarDados() {
        try{
            gravador.gravarArquivoBebida(bebidaList);
            gravador.gravarArquivoComida(comidaList);
        }catch(IOException e ){
            System.out.println(e+ "\nNão gravou");
        }
    }

    public void recuperarDados(){
        try{
            bebidaList = gravador.lerArquivoBebida();
            comidaList = gravador.lerArquivoComida();
        } catch (IOException | ClassNotFoundException e){
            comidaList = new ArrayList<>();
            bebidaList = new ArrayList<>();
        }
    }

    public String mostrarComidas() {
        String comida = "";
        for(Comida u: comidaList){
            comida = u.toString() + "\n";
        }
        return comida;
    }

    public String mostrarBebidas() {
        String bebida = "";
        for(Bebida u : bebidaList){
            bebida = bebida + u.toString() + "\n";
        }
        return bebida;
    }

    public Comida pesquisaComidaPorNome(String nome){
        for(Comida u: comidaList){
            if(u.getDescricao()==nome){
                return u;
            }
        }
        return null;
    }

    public boolean removerComida(Comida comida){
        if(comidaList.contains(comida)){
            comidaList.remove(comida);
            return true;
        }
        return false;
    }
    public boolean removerBebida(Bebida bebida){
        if(bebidaList.contains(bebida)){
            bebidaList.remove(bebida);
            return true;
        }
        return false;
    }
}