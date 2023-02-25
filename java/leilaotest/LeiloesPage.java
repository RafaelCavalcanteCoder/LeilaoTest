package leilaotest;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LeiloesPage extends PageObject {
	private static final String URL_CADASTRO_LEILAO= "http://localhost:8080/leiloes/new";
	private static final String URL_LEILOES= "http://localhost:8080/leiloes/";

	
	public LeiloesPage(WebDriver browser) {
		super(browser);
		
				
	}
		

	public CadastroLeilaoPage carregarFormulario() {
		this.browser.navigate().to(URL_CADASTRO_LEILAO);
		return new CadastroLeilaoPage(browser); //retorna a nova pagina que manda o browser em parametro
	}


	public boolean isLeilaoCadastro(String nome, String valor, String hoje) {
		WebElement linhaDaTabela =this.browser.findElement(By.cssSelector("#tabela-leiloes tbody tr:last child")); //guardei numa variavel pra boas pratic
		WebElement colunaNome = linhaDaTabela.findElement(By.cssSelector("td:nth-child(1)"));// apartir da tabela a cima , aqui pega a ultima linha e o primeiro filho da linha
		WebElement colunaDataAbertura = linhaDaTabela.findElement(By.cssSelector("td:nth-child(2)")); //pega a 2º filho
		WebElement colunaValorInicial = linhaDaTabela.findElement(By.cssSelector("td:nt-child(3)"));// pega o 3º filho , sempre guardando em variaveis.
//apartir da linha da tabela recupera a coluna nome, que recupera outras a seguir, e os assert.
		return colunaNome.getText().equals(nome) &&
				colunaDataAbertura.getText().equals(hoje) &&
				colunaValorInicial.getText().equals(valor); // e verifica os textos passados como parametros.
								
	}


	public boolean isPaginaAtual() {
		browser.get(URL_LEILOES);
		return false;
	}
	


}

