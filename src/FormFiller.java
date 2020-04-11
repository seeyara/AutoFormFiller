import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;

public class FormFiller {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

	public static boolean selenium(String website) {
		boolean formSent = false;
		System.out.println(website);
		File file = new File("D://chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		WebElement message = null, email, name, subject;

		// Load website
		WebDriver driver = new ChromeDriver();
		driver.get("http://www." + website);

		WebDriverWait driverWait = new WebDriverWait(driver, 1);

		// Search for contact page	
		if (driver.getPageSource().contains("Contact")) {
			WebElement contact = driver.findElement(By.partialLinkText("CONTACT"));
			contact.click();

			// // name
			// if (driver.findElement(By.partialLinkText("Name")) != null) {
			// name = driver.findElement(By.partialLinkText("name"));
			// name.sendKeys("Illesha");
			// }
			driverWait.until(ExpectedConditions.or(ExpectedConditions.presenceOfElementLocated(By.name("Email")),
					ExpectedConditions.presenceOfElementLocated(By.tagName("textArea"))));

			// email
			// if (driver.findElement(By.name("Email")) != null) {
			email = driver.findElement(By.name("email"));
			email.sendKeys("Illesha@crave.social");
			// }

			// // subject
			// if (driver.findElement(By.partialLinkText("Subject")) != null) {
			// subject = driver.findElement(By.partialLinkText("Subject"));
			// subject.sendKeys("Free consultation");
			// }

			// message
			if (driver.findElement(By.tagName("textArea")) != null) {
				message = driver.findElement(By.tagName("textArea"));
				message.sendKeys("Heyy");
			}
			//
			// WebElement submit =
			// driver.findElement(By.partialLinkText("SUBMIT"));
			message.submit();
			// boolean searchFormPresence =
			// driver.findElement(By.tagName("input")).isDisplayed();
			// driver.findElement(By.tagName("body")).getText();
			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement we=driver.findElement(By.xpath("//*[contains(text(), 'Thank you')]"));
			System.out.println(we);
//			WebElement messageElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Thank you")));
//
//			String message1 = messageElement.getText();
//			String successMsg = "Thank you";
//			Assert.assertEquals(message1, successMsg);
//			System.out.println(message.getAttribute("value"));
//			WebElement form = driver.findElement(By.tagName("form"));

//			if (!form.isDisplayed())
//				return true;
//			else
//				return false;
		}
		return formSent;
	}
}
