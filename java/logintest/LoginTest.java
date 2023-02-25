package logintest;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
	
	private LoginPage paginaDeLogin;
	private static final String URL_LOGIN= "http://localhost:8080/login";

	
	@BeforeEach
	public void beforeEach() {
		this.paginaDeLogin =new LoginPage();
	}
	@AfterEach
	public void afterEach() {
		this.paginaDeLogin.fechar();
	}
	
	
	//TESTES \/
	@Test
	public void deveriaEfetuarLoginComDadosValidos() {
		
		paginaDeLogin.preencheForumalariodeLogin("fulano", "pass");
		paginaDeLogin.efetuaLogin(); //sou submit.
		
		Assert.assertFalse(paginaDeLogin.isPaginaDeLogin()); //verifique se eu nao estou mais na pagina de login.
		Assert.assertEquals("fulano", paginaDeLogin.getNomeUsuarioLogado()); //Asser se fulano, se encontra no browser.findElement...
	}
	
	
	@Test
	public void naoDeveriaLogarComDadosInvalidos() {
				
		paginaDeLogin.preencheForumalariodeLogin("dados invalidos", "senha errada ");
		paginaDeLogin.efetuaLogin(); //sou submit.
		
		Assert.assertTrue(paginaDeLogin.isPaginaDeLogin()); //usuario permaneceu na pag de login
		Assert.assertTrue(paginaDeLogin.contemElementoNaPagina("Usuário e senha inválidos."));//verifique na pag inteira se contem a msg Usuario e sen Inva.
		Assert.assertNull(paginaDeLogin.getNomeUsuarioLogado());

	}
	
	@Test
	public void naoDeveriAcessarPaginaRestritaSemEstarLogado() {
		
		paginaDeLogin.navegaParaPaginaDeLances();
		
		Assert.assertTrue(paginaDeLogin.isPaginaDeLogin()); //usuario permaneceu na pag de login
		Assert.assertFalse(paginaDeLogin.contemElementoNaPagina("Dados do Leilão")); //nao tem que conter Dados do leilao na pagina 
	}
	
	
	
	
	
	
	
}
