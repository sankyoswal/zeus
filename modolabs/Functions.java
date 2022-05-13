package ngrokUpdate;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

	public void newLink(String ngrok, String ext) {
		apiUrl = ngrok + ext;
	}

	public void replace() throws InterruptedException {
		WebElement link = driver.findElement(By.name("componentOption_apiURL"));
		link.clear();
		System.out.println("Sending -->  " +(apiUrl));
		link.sendKeys(apiUrl);
		Thread.sleep(2000);
	}

	public boolean verify() {
		String url = driver.findElement(By.name("componentOption_apiURL")).getAttribute("value");
		if(url.equals(apiUrl))
			return true;
		else 
			return false;
	}

	public void save() {
		driver.findElement(By.name("save")).click();
	}	

	public void deploy() {
		driver.findElement(By.xpath("//*[@id=\"kgoui_Rcontent_I0_Rcontent_I0_Rbuttons_I1\"]/span")).click();
		wait.until(ExpectedConditions.elementToBeClickable (By.xpath("//*[@id=\"kgoui_Rcontent_I0_Rcontent_I0_Rbuttons_I1\"]")));
		driver.findElement(By.xpath("//*[@id=\"kgoui_Rcontent_I0_Rcontent_I0_Rbuttons_I1\"]")).click();
	}


	void newTab() {
		String newTab = Keys.chord(Keys.CONTROL, "t");
		driver.findElement(By.xpath("//*[@id=\"modoui_screen_header\"]/div[2]/ul/li[1]/a/div[2]")).sendKeys(newTab);
	}

	void close() {
		driver.close();
	}
}
