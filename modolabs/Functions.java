package ngrokUpdate;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Functions {

	String apiUrl = null;
	Constants c = new Constants();

	WebDriver driver;
	WebDriverWait wait;

	@SuppressWarnings("deprecation")
	public void initializeDriver() {
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();  
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver,5);
	}

	public void launch(String url) {
		driver.get(url);
		signin();
	}

	public void signin() {
		driver.findElement(By.name("username")).sendKeys(c.username);
		driver.findElement(By.xpath("/html/body/div/main/form/div[3]/button")).click();
		driver.findElement(By.name("password")).sendKeys(c.password);
		driver.findElement(By.name("login")).click();
	}

	public int[] getFlags(String sheetName) {
		switch(sheetName) {
		case "modo4v3": return c.modo4v3;
		case "modo4v2": return c.modo4v2;
		case "btwTest": return c.btwTest;
		case "btw": return c.btw;
		}
		return null;
	}

	public void newLink(String ngrok, String ext) {
		apiUrl = ngrok + ext;
	}

	public void replace() {
		WebElement link = driver.findElement(By.name("componentOption_apiURL"));
		link.clear();
		System.out.println("Sending -->  " +(apiUrl));
		link.sendKeys(apiUrl);
	}

	public boolean verify() {
		String url = driver.findElement(By.name("componentOption_apiURL")).getAttribute("value");
		if(url.equals(apiUrl))
			return true;
		else 
			return false;
	}

	public boolean isDeployed() {
		if (driver.getPageSource().contains("This module has changes ready for you to deploy")) {
			return false;
		}
		return true;		
	}

	public void save() throws InterruptedException {
		driver.findElement(By.name("save")).click();
		Thread.sleep(2000);
	}	

	public void deploy () {
		driver.findElement(By.xpath("//span[contains(text(),'Deploy')]")).click();
		acceptAlert();
		wait.until(ExpectedConditions.elementToBeClickable (By.xpath("//span[contains(text(),'Deploy')]")));
		driver.findElement(By.xpath("//span[contains(text(),'Deploy')]")).click();
	}

	public void deploy(String sheetName) {
		switch(sheetName) {
		case "modo4v3": modo4Deploy();
		break;
		case "modo4v2": modo4Deploy();
		break;
		case "btw": btwDeploy();
		break;
		case "btwTest": btwTestDeploy();
		break;
		}
	}

	public void modo4Deploy() {
		driver.findElement(By.xpath("//*[@id=\"kgoui_Rcontent_I0_Rcontent_I0_Rbuttons_I1\"]/span")).click();
		wait.until(ExpectedConditions.elementToBeClickable (By.xpath("//*[@id=\"kgoui_Rcontent_I0_Rcontent_I0_Rbuttons_I1\"]")));
		driver.findElement(By.xpath("//*[@id=\"kgoui_Rcontent_I0_Rcontent_I0_Rbuttons_I1\"]")).click();
	}		

	public void btwDeploy() {
		driver.findElement(By.xpath("//*[@id=\"kgoui_Rcontent_I0_Rcontent_I0_Rbuttons_I1\"]/a")).click();
		acceptAlert();
		wait.until(ExpectedConditions.elementToBeClickable (By.xpath("//*[@id=\"kgoui_Rcontent_I0_Rcontent_I0_Rbuttons_I1\"]/button")));
		driver.findElement(By.xpath("//*[@id=\"kgoui_Rcontent_I0_Rcontent_I0_Rbuttons_I1\"]/button")).click();
		acceptAlert();
	}

	public void btwTestDeploy() {
		//		wait.until(ExpectedConditions.elementToBeClickable (By.xpath("//*[@id=\\\"kgoui_Rcontent_I0_Rcontent_I0_Rbuttons_I1\\\"]/a/span")));
		//		driver.findElement(By.xpath("//*[@id=\"kgoui_Rcontent_I0_Rcontent_I0_Rbuttons_I1\"]/a/span")).click();
		//		wait.until(ExpectedConditions.elementToBeClickable (By.xpath("//span[text()=\\\"Deploy\\\"]")));
		driver.findElement(By.xpath("//span[text()=\"Deploy\"]")).click();
		acceptAlert();
		wait.until(ExpectedConditions.elementToBeClickable (By.xpath("//*[@id=\"kgoui_Rcontent_I0_Rcontent_I0_Rbuttons_I1\"]/button/span")));
		driver.findElement(By.xpath("//*[@id=\"kgoui_Rcontent_I0_Rcontent_I0_Rbuttons_I1\"]/button/span")).click();
		acceptAlert();
	}

	void acceptAlert() {
		try {
			driver.switchTo().alert().accept();			
		}
		catch(NoAlertPresentException Ex) {
			System.out.println(Ex);
		}
	}

	void close() {
		driver.close();
	}	
}
