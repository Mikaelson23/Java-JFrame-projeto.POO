import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GravadorDeDados {
	private String arquivoCardapio = "CardapioAndBebida" + File.separator +
			"Cardapio.txt";
	private String arquivoBebida = "CardapioAndBebida" + File.separator +
			"Bebidas.txt";

	public void gravarArquivoComida(List<Comida> lista) throws IOException {
		ObjectOutputStream gravandoDados = null;
		try {
			gravandoDados = new ObjectOutputStream(new FileOutputStream(arquivoCardapio));
			if(lista!=null) {
				gravandoDados.writeObject(lista);
				gravandoDados.close();
				System.out.printf("gravado ");
			}
		} catch (IOException erro) {
			throw erro;
			
		} finally {
			if (gravandoDados != null) {
				gravandoDados.close();
			}
		}
	}

	public List<Comida> lerArquivoComida() throws IOException, ClassNotFoundException {
		ObjectInputStream objInput = null;
		List<Comida> lista;

		try {
			objInput = new ObjectInputStream(new FileInputStream(arquivoCardapio));
			Object comidasList = objInput.readObject();
			lista = (List<Comida>) comidasList;
			System.out.printf("leu ");
			return lista;

		} catch (IOException | ClassNotFoundException erro1) {
			throw erro1;

		}finally {
			if(objInput!=null){
				objInput.close();
			}
		}
	}
	public void gravarArquivoBebida(List<Bebida> lista) throws IOException {
		ObjectOutputStream gravandoDados = null;
		try {
			gravandoDados = new ObjectOutputStream(new FileOutputStream(arquivoBebida));
			if(lista!=null) {
				gravandoDados.writeObject(lista);
				gravandoDados.close();
				System.out.printf("gravado ");
			}
		} catch (IOException erro) {
			throw erro;

		} finally {
			if (gravandoDados != null) {
				gravandoDados.close();
			}
		}
	}

	public List<Bebida> lerArquivoBebida() throws IOException, ClassNotFoundException {
		ObjectInputStream objInput = null;
		List<Bebida> lista;

		try {
			objInput = new ObjectInputStream(new FileInputStream(arquivoBebida));
			Object comidasList = objInput.readObject();
			lista = (List<Bebida>) comidasList;
			System.out.printf("leu ");
			return lista;

		} catch (IOException | ClassNotFoundException erro1) {
			throw erro1;

		}finally {
			if(objInput!=null){
				objInput.close();
			}
		}
	}
}