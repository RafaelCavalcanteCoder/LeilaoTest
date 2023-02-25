package leilaotest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class CadastroLeilaoPage extends PageObject {
	private static final String URL_CADASTRO_LEILAO= "http://localhost:8080/leiloes/new";
	
	
	public CadastroLeilaoPage(WebDriver browser) {
		super(browser);
				
	}
		
	public LeiloesPage cadastrarLeilao(String nome, String valorInicial, String dataAbertura) {
		this.browser.findElement(By.id("nome")).sendKeys(nome);
		this.browser.findElement(By.id("valorInicial")).sendKeys(valorInicial);
		this.browser.findElement(By.id("dataAbetura")).sendKeys(dataAbertura);
		this.browser.findElement(By.id("button-submuit")).submit();
		
		return new LeiloesPage(browser);
		
	}

public boolean isPaginaAtual() {
	return browser.getCurrentUrl().equals(URL_CADASTRO_LEILAO);
}

public boolean isMensagensDeValidacoesVisiveis() {
	String pageSource = browser.getPageSource(); //verifica textos na pagina inteira. coloquei na string. 
	return pageSource.contains("minimo de 3 caracteres") &&
			pageSource.contains("não deve estar em branco") &&
			pageSource.contains("deve ser um valor maior de 0.1") &&
			pageSource.contains("deve ser uma data no formato dd/MM/yyyy");
}


}

