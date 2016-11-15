package appstore;

import appstore.app.Store;
import appstore.gui.Interface;

public class Main
{

	public static void main(String[] args)
	{
		Store store = new Store();
		Interface tela = new Interface(store);
		// Inicia a aplicação
		tela.iniciar();
	}
	
}
