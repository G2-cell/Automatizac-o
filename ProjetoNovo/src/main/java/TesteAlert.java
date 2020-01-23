import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TesteAlert {
	
private WebDriver driver;
	
	
	@Before 
	public void inicializa() {
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/campo-treinamento/componentes.html");
		
		
		
	}
	
	@After
	public void finaliza() {
		driver.quit();
	}
	
	@Test 
	public void DeveInteragirComAlertSimples(){
		
	    dsl.clicarBotao("alert");
	    String texto = dsl.alertaObterTextoEAceita();
	    Assert.assertEquals("Alert simples",texto);
	    
	    dsl.escrever("elementosForm:nome", texto);
	
}
	@Test 
	public void DeveInteragirComAlertConfirm(){
        
		dsl.clicarBotao("confirm");
		Assert.assertEquals("Confirm Simples", dsl.alertaObterTextoEAceita());
		Assert.assertEquals("Confirmado", dsl.alertaObterTextoEAceita());
		
		dsl.clicarBotao("confirm");
		Assert.assertEquals("Confirm Simples", dsl.alertaObterTextoENega());
		Assert.assertEquals("Negado", dsl.alertaObterTextoENega());
		
}

	@Test 
	public void DeveInteragirComAlertPrompt(){

        dsl.clicarBotao("prompt");
        Assert.assertEquals("Digite um numero", dsl,alertaobterTexto());
        dsl.alertaEscrever("12");
        Assert.assertEquals("Era 12?", dsl.alertaObterTextoEAceita());
        Assert.assertEquals(":D", dsl.alertaObterTextoEAceita());
        
        

}
}