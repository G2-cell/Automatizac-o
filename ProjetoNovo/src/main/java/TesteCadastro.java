import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;



public class TesteCadastro {

private WebDriver driver;
private DSL dsl;
	
	
	@Before 
	public void inicializa() {
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/campo-treinamento/componentes.html");
		dsl = new DSL(driver);
		
		
	}
	
	@After
	public void finaliza() {
		driver.quit();
	}
	
	@Test 
	public void DeveRealizarCadsatroComSucesso(){
		
        
        dsl.escreve("elementosForm:nome" ,"Guilherme");
        dsl.escreve("elementosForm:sobrenome","Oliver");
        dsl.clicarRadio("elementosForm:sexo:0");
        dsl.clicarRadio("elementosForm:comidaFavorita:2");
        dsl.selecionarCombo("elementosForm:escolaridade","Superior");
        dsl.selecionarCombo("elementosForm:esportes","Natacao");
        dsl.clicarrBotao("elementosForm:cadastrar");
        
        Assert.assertTrue(dsl.obterTexto("resultado").startsWith("Cadastrado"));
        Assert.assertTrue(driver.findElement(By.id("descNome")).getText().endsWith("Guilherme"));
        Assert.assertEquals("Sobrenome: Oliver", dsl.obterTexto("descSobrenome"));
        Assert.assertEquals("Sexo: Masculino", dsl.obterTexto("descSexo"));
        Assert.assertEquals("Comida: Pizza", dsl.obterTexto("descComida"));
        Assert.assertEquals("Escolaridade: superior", dsl.obterTexto("descEscolaridade"));
        Assert.assertEquals("Esportes: Natacao", dsl.obterTexto("descEsportes"));
        
        
        
		
}
	@Test 
	public void DeveValdiarNomeObrigatorio(){
		
		dsl.clicarBotao("elementosForm:cadastrar");
		Assert.assertEquals("Nome eh obrigatorio", dsl.alertaObterTextoEAceita());
		
}
	@Test 
	public void DeveValdiarSobrenomeObrigatorio(){
		

		dsl.escrever("elementosForm:nome","Nome qualquer");
		dsl.clicarBotao("elementosForm:cadastrar");
		Assert.assertEquals("Sobrenome eh obrigatorio", dsl.alertaObterTextoEAceita());
		
	
	
	}
	@Test 
	public void DeveValdiarSexoObrigatorio(){
		

		dsl.escrever("elementosForm:nome","Nome qualquer");
		dsl.escrever("elementosForm:sobrenome","Sobrenome qualquer");
		dsl.clicarBotao("elementosForm:cadastrar");
		Assert.assertEquals("Sexo eh obrigatorio", dsl.alertaObterTextoEAceita());
		
	
	
	}
	@Test 
	public void DeveValdiarComidaVegetariana(){
		

		dsl.escrever("elementosForm:nome","Nome qualquer");
		dsl.escrever("elementosForm:sobrenome","Sobrenome qualquer");
		dsl.clicarRadio("elementosForm:sexo:1");
		dsl.clicarRadio("elementosForm:comidaFavorita:0");
		dsl.clicarRadio("elementosForm:comidaFavorita:3");
		dsl.clicarBotao("elementosForm:cadastrar");
    	Assert.assertEquals("Tem certeza que voce eh vegetariano?", dsl.alertaObterTextoEAceita());
		
	
	
	}
	@Test 
	public void DeveValdiarEsportistaIndeciso(){
		

		dsl.escrever("elementosForm:nome","Nome qualquer");
		dsl.escrever("elementosForm:sobrenome","Sobrenome qualquer");
		dsl.clicarRadio("elementosForm:sexo:1");
		dsl.clicarRadio("elementosForm:comidaFavorita:0");
		dsl.selecionarCombo("elementosForm:esportes","Karate");
		dsl.selecionarCombo("elementosForm:esportes","O que eh esporte?");
		dsl.clicarBotao("elementosForm:cadastrar");
		Assert.assertEquals("Voce faz esporte ou nao?", dsl.alertaObtertextoEAceita());
		
	
	
	}
}	