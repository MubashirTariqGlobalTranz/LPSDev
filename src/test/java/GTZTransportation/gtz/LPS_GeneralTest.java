package GTZTransportation.gtz;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import GTZTransportation.pages.LPS_General;

public class LPS_GeneralTest extends BaseClass {
	// public static WebDriver driver;
	LPS_General LPS;

	public LPS_GeneralTest() {
		super();
	}

	@BeforeTest(groups = ("Regression"))
	public void setup() {

		initialization();
		LPS = new LPS_General();
	}

	@Test(priority = 1, groups = ("Regression"), retryAnalyzer = listeners.MyRetry.class)
	public void LPS_General_Tests() {
		// This will run all the methods
		// LPS.LPS_Density_Calculator();
		LPS.LPS_Glossay();
		LPS.LPS_RoutingGuides();
		LPS.LPS_Prospects();
		LPS.LPS_MyProfile();
		LPS.LPS_MyTeam();
		LPS.LPS_DataEntry();
		LPS.LPS_Resources();
		// Assertion
		String actual = driver.findElement(By.xpath("//h1[@class='underline']")).getText();
		String expected = "Resources";

		Assert.assertEquals(actual, expected);

		captureScreenShot(driver, "LPS Resources");
	}

	@AfterTest(groups = ("Regression"))
	public void tearDown() {
		// close the WebDriver
		driver.quit();
	}
}
