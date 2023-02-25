package leilaotest;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import logintest.LoginPage;

public class LeiloesTest {
	
	private LeiloesPage paginaDeLeiloes;
	private CadastroLeilaoPage paginaDeCadastro;
	
	@BeforeEach
	public void beforeEach() {
		LoginPage paginaDeLogin = new LoginPage();
		paginaDeLogin.preencheForumalariodeLogin("fulano", "pass");
		this.paginaDeLeiloes =paginaDeLogin.efetuaLogin();//quando efetua login cai na pagina de leiloes.
		this.paginaDeCadastro = paginaDeLeiloes.carregarFormulario();//quando submit cai na pag de cadastrp
	}
	
		
	@AfterEach
	public void afterEach() {
		this.paginaDeLeiloes.fechar();
	}
	
	
	
	
	
	@Test
	public void deveriaCadastrarLeiloes() {
		LoginPage paginaDeLogin = new LoginPage();
		paginaDeLogin.preencheForumalariodeLogin("fulano", "pass");
		this.paginaDeLeiloes =paginaDeLogin.efetuaLogin();//quando efetua login cai na pagina de leiloes.
		CadastroLeilaoPage paginaDeCadastro = paginaDeLeiloes.carregarFormulario();//quando submit cai na pag de cadastrp
		
		String hoje = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		String nome = "Leilão do dia"+hoje;
		String valor= "500.00";
		
		this.paginaDeLeiloes = paginaDeCadastro.cadastrarLeilao(nome, valor, hoje);
		
		Assert.assertTrue(paginaDeLeiloes.isLeilaoCadastro(nome, valor ,hoje));
		
	}
	
	@Test
	public void deveriaValidarCadastroDeLeilao() {
		this.paginaDeLeiloes = paginaDeCadastro.cadastrarLeilao("", "", ""); //dados vazios sao string vazias
		Assert.assertFalse(this.paginaDeCadastro.isPaginaAtual());
		Assert.assertTrue(this.paginaDeLeiloes.isPaginaAtual());
		Assert.assertTrue(this.paginaDeCadastro.isMensagensDeValidacoesVisiveis());

	}
	

}