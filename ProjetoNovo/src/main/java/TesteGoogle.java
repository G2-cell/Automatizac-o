import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteGoogle {

	
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
	public void teste () {
    	
    	//System.setProperty("webdriver.gecko.driver", "C:\\drivers.exe");
    	//WebDriver driver = new FirefoxDriver();
    	
		driver.get("http://www.google.com");
		Assert.assertEquals("Google",driver.getTitle()); 
		
	}
}
 