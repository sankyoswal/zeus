package modolabs;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class XComp {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver;
		WebDriverWait wait;
		WebElement inputBox;
		String apiURL = null, blockType = null;
		Constants c = new Constants();
		Functions f = new Functions();
		
		String extSelf = "/v3/v3/selfAssessment";
		String extToday = "/v3/v3/today?XModuleId=sanket_modo4_local&XModuleAdminMain=sanket_modo4_local_admin_home";
		String extBuddy = "/v3/v3/buddyCollageXcomponent?XModuleId=sanket_modo4_local&XModuleAdminMain=sanket_modo4_local_admin_home";
		

		System.setProperty("webdriver.chrome.driver", "E:\\Softwares\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 5);

		driver.get("https://ogyulzod7y7uc19a-admin.modolabs.net/admin/edit/edit?_tab=configuration&id=_%2Fattendance_desk_xcomponent&parentId=sanket_modo4_local_xcomp");
		driver.findElement(By.name("username")).sendKeys(c.username);
		driver.findElement(By.xpath("/html/body/div/main/form/div[3]/button")).click();
		driver.findElement(By.name("password")).sendKeys(c.password);
		driver.findElement(By.name("login")).click();
		driver.findElement(By.xpath("//*[@id=\"kgoui_Rcontent_I0_Rcontent_I0_Ritems_I0_Rleft_I0_RnavigatorItems_I2\"]")).click();
		List <WebElement> blocks = new ArrayList<WebElement>();
		blocks = driver.findElements(By.xpath("//*[text()='XComponent block']//parent::div//parent::a//parent::li"));

		for (WebElement block : blocks) {

			block.click();
			inputBox = driver.findElement(By.xpath("//div[contains(text(),'URL starts with')]//preceding::input[1]"));
			apiURL = inputBox.getAttribute("value");

			if (apiURL.contains("selfAssessment")) {
				blockType = "selfAss";
			}
			else if (apiURL.contains("today")) {
				blockType = "today";
			}
			else if (apiURL.contains("buddy")) {
				blockType = "buddy";
			}
			switch (blockType) {
			case "selfAss":
				inputBox.clear();
				inputBox.sendKeys(c.ngrok + extSelf);
				inputBox.sendKeys(Keys.ENTER);
				Thread.sleep(2500);
			case "today":
				inputBox.clear();
				inputBox.sendKeys(c.ngrok + extToday);
				inputBox.sendKeys(Keys.ENTER);
				Thread.sleep(2500);
			case "buddy":
				inputBox.clear();
				inputBox.sendKeys(c.ngrok + extBuddy);
				inputBox.sendKeys(Keys.ENTER);
				Thread.sleep(2500);
			}

		}
	}

}
