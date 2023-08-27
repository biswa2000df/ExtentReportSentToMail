package ExtentReportSent;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class utillscClass {

	// Extentreport
	public static ExtentHtmlReporter htmlReport;
	public static ExtentReports extent;
	public static ExtentTest test;

	static WebDriver driver;

	String concat = ".";

	@BeforeTest
	public void setUp() throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://mail.apmosys.com/webmail/");
		Thread.sleep(2000);

		htmlReport = new ExtentHtmlReporter(
				System.getProperty("user.dir") + "." + File.separator + "report" + File.separator + "normal.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReport);

		htmlReport.config().setDocumentTitle("Biswajit FrameWork Report");// Title of the report
		htmlReport.config().setReportName("Automation Report");// Name of the report
		htmlReport.config().setTestViewChartLocation(ChartLocation.BOTTOM);
		htmlReport.config().setChartVisibilityOnOpen(false);
		htmlReport.config().setProtocol(Protocol.HTTP);
		htmlReport.config().setTheme(Theme.DARK);

		extent.setSystemInfo("Comapny Name", "APMOSYS");
		extent.setSystemInfo("FrameWork", "Biswajit Framework");
		extent.setSystemInfo("Project Name", "ISHINE");
		extent.setSystemInfo("Test Lead", "Prabhat Padhy");
		extent.setSystemInfo("OS", "Window11");
		extent.setSystemInfo("Tester Name", "Biswajit");
		extent.setSystemInfo("Browser", "Chrome");
		extent.setSystemInfo("Application URL", "https://www.google.com");

	}

	@AfterTest
	public void afterMethod() {
		extent.flush();
		driver.quit();

	}

	public void passFailScreenshot(String name) throws IOException {
		System.out.println("kanha");
		String screenshotName =  "."+TakeScreenshotClass.GetScreenshot(name);
		System.out.println(screenshotName);
		screenCapture("Testing", screenshotName);
		System.out.println("5");
	}

	public static Object screenCapture(String logdetails, String imagepath) throws IOException {
		System.out.println("6");
		test.log(Status.INFO, logdetails, MediaEntityBuilder.createScreenCaptureFromPath(imagepath).build());
		return test;
	}

}
