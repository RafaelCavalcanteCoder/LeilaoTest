package leilaotest;

import java.util.concurrent.TimeUnit;

import org.h2.mvstore.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageObject {
	protected WebDriver browser;
	
	public PageObject(WebDriver browser){
		System.setProperty("webdriver.chrome.driver","drivers/chromedrivernew.exe");
		if(browser==null) { // o se parametro do new objeto PageObject vier nulo, entao inicia nova aba;
		 this.browser = new ChromeDriver();
		} else {
		this.browser = browser; //caso acontrario o browser que esta no parametro é o que esta aberto.
		}
		
		this.browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS).pageLoadTimeout(10, TimeUnit.SECONDS); // para esperar elemento aparecer e 
		// e esperar a pag carregar.
		
	
	}
	
	public void fechar() {
		this.browser.quit();
		
}
}