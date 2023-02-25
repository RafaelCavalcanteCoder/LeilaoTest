package logintest;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import leilaotest.LeiloesPage;
import leilaotest.PageObject;

public class LoginPage extends PageObject {
	private static final String URL_LOGIN= "http://localhost:8080/login";
	private WebDriver browser;
	
	public LoginPage() {
		super(null);
		this.browser.navigate().to(URL_LOGIN);
		
		
		
	}
	public boolean contemElementoNaPagina(String texto) {
		return browser.getPageSource().contains(texto);
		
	}
	
	

	public void preencheForumalariodeLogin(String username, String password) {
		browser.findElement(By.id("username")).sendKeys(username);
		browser.findElement(By.id("password")).sendKeys(password);
		
	}

	public LeiloesPage efetuaLogin() {
		browser.findElement(By.id("submit")).click();	
		return new LeiloesPage(browser);
	}

	public boolean isPaginaDeLogin() {
		return browser.getCurrentUrl().equals(URL_LOGIN);
		
	}

	public String getNomeUsuarioLogado() {
		try {
			return browser.findElement(By.id("usuario-logado")).getText();
		}catch (NoSuchElementException e) {
		return null;
		}
	}
	public void navegaParaPaginaDeLances() {
		browser.navigate().to("http://localhost:8080/leiloes/2");
		}
	
	
}

	

