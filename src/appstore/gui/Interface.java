package appstore.gui;

import java.util.Scanner;

import appstore.app.App;
import appstore.app.Store;
import appstore.utils.DateFormatter;

public class Interface 
{

	private Store store;
	private Scanner scanner;

	public Interface(Store store)
	{
		this.store = store;
		this.scanner = new Scanner(System.in);
	}

	public void iniciar()
	{
		System.out.println("#== Loja de aplicativos do HUE ==#");
		exibirMenu();
	}
	
	private void exibirMenu()
	{
		int tarefa = 0;
		
		do {
			System.out.println("Por favor, selecione uma ação:");
			System.out.println("1) Adicionar um novo aplicativo.");
			System.out.println("2) Buscar um aplicativo.");
			System.out.println("3) Remover um aplicativo.");
			System.out.println("0) Estava bêbado e não sei como vim parar aqui. Me tire aqui!!");
			tarefa = scanner.nextInt();
			executarTarefa(tarefa);
		} while (tarefa != 0);
	}
	
	private void executarTarefa(int tarefa)
	{
		try 
		{
			switch (tarefa)
			{
			case 1:
				adicionarAplicativo();
				break;
			case 2:
				buscarAplicativo();
				break;
			case 3:
				removerAplicativo();
				break;
			}
		}
		catch (Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}
	
	private void adicionarAplicativo()
	{
		String name;
		String author;
		String os;
		String version;
		String license;
		String country;
		int trialDays;
		double size;
		double price;
		
		System.out.println("Por favor, preencha os dados do aplicativo:");
		// Pede as informacoes do aplicativo
		System.out.print("Nome do aplicativo: ");
		name = scanner.next();
		System.out.print("Nome do autor do aplicativo: ");
		author = scanner.next();
		System.out.print("Preço do aplicativo: ");
		price = scanner.nextDouble();
		System.out.print("Sistema operacional: ");
		os = scanner.next();
		System.out.print("Versão: ");
		version = scanner.next();
		System.out.print("Tamanho do download: ");
		size = scanner.nextDouble();
		System.out.print("Tipo de licença: ");
		license = scanner.next();
		System.out.print("País de origem: ");
		country = scanner.next();
		System.out.print("Dias de trial: ");
		trialDays = scanner.nextInt();
		
		// Cria o aplicativo e o adiciona a loja
		App aplicativo = new App(name, author, price, os, version, size, license, country, trialDays);
		store.adicionar(aplicativo);
	}
	
	private void buscarAplicativo() throws Exception
	{
		String filter;
		
		System.out.println("Por favor, preencha o nome do aplicativo:");
		filter = scanner.next();
		
		// Busca o aplicativo pelo nome
		App aplicativo = store.buscarPorNome(filter);
		if (aplicativo == null)
		{
			throw new Exception("O aplicativo procurado não existe na loja!");
		}
		// Exibe detalhes do app
		exibirDetalhesApp(aplicativo);
	}
	
	private void removerAplicativo() throws Exception
	{
		String filter;
		
		System.out.println("Por favor, informe o nome do aplicativo:");
		filter = scanner.next();
		// Remove app
		store.remover(filter);
		// Só mostrará a mensagem se nenhuma exceção ocorrer
		System.out.println("O aplicativo foi removido com sucesso da loja!");
	}
	
	private void exibirDetalhesApp(App aplicativo) 
	{
		// Formata a data para o padrão brasileiro de hora
		String dataFormatada = DateFormatter.format(aplicativo.getRegisterDate(), "dd/MM/yyyy HH:mm");
		
		// Mostra os detalhes do aplicativo
		System.out.println("####### Detalhes do aplicativo #######");
		System.out.println("Identificador: " + aplicativo.getId());
		System.out.println("Nome: " + aplicativo.getName());
		System.out.println("Preço: " + aplicativo.getPrice());
		System.out.println("Autor: " + aplicativo.getAuthor());
		System.out.println("Versão: " + aplicativo.getVersion());
		System.out.println("Sistema operacional: " + aplicativo.getOs());
		System.out.println("Tamanho: " + aplicativo.getSize());
		System.out.println("Dias de trial: " + aplicativo.getTrial());
		System.out.println("Licença: " + aplicativo.getLicense());
		System.out.println("País: " + aplicativo.getCountry());
		System.out.println("Data inserção: " + dataFormatada);
		System.out.println("######################################");
		System.out.println();
	}

}