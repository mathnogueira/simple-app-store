package appstore.app;

import java.util.List;
import java.util.ArrayList;

public class Store
{

	// Lista de aplicativos da loja
	private List<App> aplicativos;
	private int ultimoId;

	public Store() 
	{
		aplicativos = new ArrayList<App>();
		ultimoId = 1000;
	}

	// Adiciona um aplicativo a loja
	public void adicionar(App aplicativo) 
	{
		aplicativo.setId(ultimoId++);
		aplicativos.add(aplicativo);
	}

	// Remove um aplicativo da loja usando o nome como referencia para encontra-lo
	public void remover(String nome) throws Exception
	{
		App aplicativo = encontrarAplicativoPorNome(nome);
		removerAplicativo(aplicativo);
	}

	// Busca um aplicativo pelo seu nome
	public App buscarPorNome(String nome)
	{
		return encontrarAplicativoPorNome(nome);
	}

	// Funcao auxiliar para encontrar o aplicativo com o nome especificado
	private App encontrarAplicativoPorNome(String nome)
	{
		for (App aplicativo : aplicativos)
		{
			if (aplicativo.getName().equals(nome))
			{
				return aplicativo;
			}
		}
		return null;
	}

	// Funcao auxiliar que remove um elemento da loja
	private void removerAplicativo(App aplicativo) throws Exception
	{
		if (aplicativo == null)
		{
			throw new Exception("Aplicativo não encontrado na loja");
		}
		aplicativos.remove(aplicativo);
	}

}