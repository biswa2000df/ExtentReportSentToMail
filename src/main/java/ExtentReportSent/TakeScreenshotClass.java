package ExtentReportSent;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class TakeScreenshotClass extends utillscClass {

	public static String GetScreenshot(String screenshotName) throws IOException {
		System.out.println("1");
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String imagePath = "." + File.separator + "report" + File.separator + "Screenshot" + File.separator
				+ screenshotName + ".png";
		System.out.println("2");
		File destFile = new File(imagePath);
		System.out.println("3");
		FileUtils.copyFile(srcFile, destFile);
		System.out.println("4");
		System.out.println(imagePath);
		return imagePath;

	}

}
