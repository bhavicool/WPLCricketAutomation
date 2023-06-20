package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	public List<WebElement> allPlayerNames(WebDriver driver) {
		return driver.findElements(By.xpath("//div[@class='table-left']/descendant::div[@class='table-body']/descendant::div[@class='table-data-wrapper']/descendant::h4"));
	}

	public List<WebElement> allHighestScores(WebDriver driver) {
		return driver.findElements(By.xpath(
				"//div[@class='table-right']/descendant::div[@class='table-body']/descendant::div[@class='table-data highest-score']"));
	}

	public List<String> getWPLPlayers(WebDriver driver)
	{
		List<String> playerNames=new ArrayList<String>();
		for(WebElement e:allPlayerNames(driver))
		{
			playerNames.add(e.getText());
		}
		return playerNames;
	}
	
	public List<String> getWPLPlayersHS(WebDriver driver)
	{
		List<String> playerHSScores=new ArrayList<String>();
		for(WebElement e:allHighestScores(driver))
		{
			playerHSScores.add(e.getText());
		}
		return playerHSScores;
	}
}
