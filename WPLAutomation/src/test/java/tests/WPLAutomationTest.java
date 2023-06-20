package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.HomePage;
import services.GetExpectedWPLData;

public class WPLAutomationTest {

	WebDriver driver;
	HomePage homePage = new HomePage();
	GetExpectedWPLData getExpectedWPLData = new GetExpectedWPLData();

	@BeforeMethod
	public void setup() {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(option);
		driver.get("https://stg-wpl.sportz.io/stats/most-runs-2-statistics");
		driver.manage().window().maximize();
	}

	@Test
	public void testPlayersHighestScore() throws InterruptedException {
		Thread.sleep(2000);
		homePage.allPlayerNames(driver);
		System.out.println("Player names are:" + homePage.getWPLPlayers(driver));
		// homePage.allHighestScores(driver);
		// System.out.println("Player HighestScores is:" +
		// homePage.getWPLPlayersHS(driver));
		// getExpectedWPLData.getExpectedWPLHSScores();
		Assert.assertEquals(homePage.getWPLPlayersHS(driver), getExpectedWPLData.getExpectedWPLHSScores());
	}

	@AfterMethod
	public void cleanUp() {
		driver.close();
	}
}
