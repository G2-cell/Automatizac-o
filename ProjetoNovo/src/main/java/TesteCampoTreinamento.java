import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.openqa.selenium.By;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
	



public class TesteCampoTreinamento {
	
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
	public void testeTextField() {
		    dsl.escrever("elementosForm:nome", "Teste de escrita");
			Assert.assertEquals("Teste de escrita", dsl.obterValorCampo("elementosForm:nome"));
			
			
			
		
		
	}
	@Test
	public void deveInteragirComTextArea(){
	
		dsl.escrever("elementosForm:sugestoes", "teste\nuudsah\nodasoii\noiuwqoeiqw");
		Assert.assertEquals("teste\nuudsah\\nodasoii\\noiuwqoeiqw", dsl.obterValorCampo("elementosForm:sugestoes"));
		
		
	}
	@Test
	public void deveInteragirComRadioButton(){
		
		
       dsl.clicarRadio("elementosForm:sexo 0 ");
       Assert.assertTrue(dsl.isRadioMarcado("elementosForm:sexo 0"));
        
       
}
	@Test
	public void deveInteragirComCheckbox(){
		
		
        dsl.clicarRadio("elementosForm:comidaFavorita:2");
        Assert.assertTrue(dsl.isRadioMarcado("elementosForm:comidaFavorita:2"));
        
        
}
	@Test
	public void deveInteragirComCombo(){
		
		
        //combo.selectByIndex(2);
        //combo.deselectByVisibleText("2o grau completo");
        
        dsl.selecionarCombo("elementosForm:escolaridade", "2o grau completo");
        Assert.assertEquals("2o grau completo", dsl.obterValorCampo("elementosForm:escolaridade"));
        
        
	}
	@Test
	public void deveVerificarValoresCombo(){
		
		
		Assert.assertEquals(8, dsl.obterQuantidadeOpcoesCombo("elementosForm:escolaridade"));
		Assert.assertTrue(dsl.verificarOpcaoCombo("elementosForm:escolaridade", "Superior"));
       
        
}
	@Test
	public void deveVerificarValoresComboMultiplo8(){
		
		dsl.selecionarCombo("elementosForm:esportes", "Natacao");
		dsl.selecionarCombo("elementosForm:esportes", "Corrida");
		dsl.selecionarCombo("elementosForm:esportes", "O que eh esporte?");
        WebElement element = driver.findElement(By.id("elementosForm:esportes"));
        Select combo = new Select(element);
        
        List<String> opcoesMarcadas = dsl.obterValoresCombo("elementosForm:esportes");
        Assert.assertEquals(3, opcoesMarcadas.size());
        
        dsl.deselecionarCombo("elementosForm:esportes","Corrida");
        opcoesMarcadas = dsl.obterValoresCombo("elementosForm:esportes");
        Assert.assertEquals(2,  opcoesMarcadas.size());
        Assert.assertTrue(opcoesMarcadas.containsAll(Arrays.asList("Natacao","O que eh esporte?")));
        
	}
	
	@Test
	public void DeveInteragirComBotoes(){
		
		dsl.clicarBotao("buttonSimple");
		
		Assert.assertEquals("Obrigado!", dsl.obterValueElemento("buttonSimple"));
		
		
		
}
	@Test
	public void DeveInteragirComLinks(){
		
		
       dsl.clicarLink("Voltar");
        
	    Assert.assertEquals("Voltou!", dsl.obterTexto("resultado"));
	    
	    
	}





	@Test 
	public void DeveBuscarTextosNaPagina(){
		
        
		//Aqui acha o texto porém não mostra o lugar exato do valor procurado 
		//Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Campo de Treinamento"));
		
		Assert.assertEquals("Campo de Treinamento", dsl.obterTexto(By.tagName("h3")));
		
		Assert.assertEquals("Cuidado onde clica, muitas armadilhas...", dsl.obterTexto(By.className("facilAchar")));
		
		
}
}
