package ExtentReportSent;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TestClass extends utillscClass {

	
	@Test
	public void enterText() throws IOException {
		test=extent.createTest("Testing Google App").createNode("MyFirstChildTest").assignCategory("GoogleApp");
		driver.findElement(By.name("email-address")).sendKeys("kanha");
		passFailScreenshot("Google_name");
	}
	
}

