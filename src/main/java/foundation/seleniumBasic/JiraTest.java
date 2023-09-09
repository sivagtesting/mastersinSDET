package foundation.seleniumBasic;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JiraTest {
	
	
	@Test
	public void testCreateStory() {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://api-training.atlassian.net/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@testleaf.com");
		driver.findElement(By.id("login-submit")).click();
		driver.findElement(By.id("password")).sendKeys("India@123");
		driver.findElement(By.id("login-submit")).click();
		driver.findElement(By.xpath("//p[@data-testid='deep-dive-card-content--project-name-heading']")).click();
		driver.findElement(By.id("createGlobalItem")).click();
		driver.findElement(By.id("summary-field")).sendKeys("New Story created by Siva_SDET for Automation");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//span[text()='Backlog']")).click();
		List<WebElement> userStories = driver.findElements(By.xpath("//span[text()='New Story created by Siva_SDET for Automation']"));
		for (WebElement webElement : userStories) {
			Assert.assertEquals("New Story created by Siva_SDET for Automation", webElement.getText());
		}
		driver.close();
	}

}
