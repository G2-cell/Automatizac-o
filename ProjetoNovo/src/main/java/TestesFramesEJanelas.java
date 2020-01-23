import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestesFramesEJanelas {
	
	
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
	public void DeveInteragirComFrames(){
        
        dsl.entrarFrame("frame1");
        dsl.clicarBotao("frameButton");
        String msg = dsl.alertaObterTextoEAceita();
        Assert.assertEquals("Frame OK!", msg);
        
        dsl.sairFrame();
        dsl.escrever ("elementosForm:nome" , msg);
        
}
	@Test 
	public void DeveInteragirComJanelas(){
        
       dsl.clicarBotao("buttonPopUpEasy");
       dsl.trocarJanela("Popup");
       dsl.escrever(By.tagName("textarea"), "Deu certo?");
       driver.close();
       dsl.trocarJanela("");
       dsl.escrever(By.tagName"textarea"), "e agora?");
		
	}
       @Test 
       public void DeveInteragirComJanelasSemTitulo(){
	
    
    dsl.clicarBotao("burronPopUpHard");
    System.out.println(driver.getWindowHandle());
    System.out.println(driver.getWindowHandle());
    dsl.trocarJanela((String)driver.getWindowHandle().toArray()[1]);
    dsl.escrever(By.tagName"textarea"), "Deu certo?");
    dsl.trocarJanela((String)driver.getWindowHandle().toArray()[0]);
    dsl.escrever(By.tagName("textarea"),"e agora?");
     
     
}
}
