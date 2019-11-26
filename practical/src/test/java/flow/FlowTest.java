package flow;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import WebElements.Flipkart;
import WebElements.GoogleHome;
import extra.CommonLib;

/**
 * Created by DenishM on 26-11-2019
 */
public class FlowTest
{

	WebDriver		driver;
	final String	browser	= "chrome";

	@BeforeTest
	void setUp()
	{
		switch (browser)
		{
			case "chrome":
				System.out.println("Chrome Browser");
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\Denish.M\\Downloads\\chromedriver.exe");
				driver = new ChromeDriver();
				break;

			case "firefox":
				System.out.println("Firefox Browser");
				System.setProperty("webdriver.gecko.driver", "C:\\Users\\Denish.M\\Downloads\\GeckoDriver.exe");
				driver = new FirefoxDriver();
				break;
		}

		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		//driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}

	@Test
	void WorkFlowTest1() throws InterruptedException
	{
		CommonLib commonLib = new CommonLib(driver);
		GoogleHome googleHome = new GoogleHome(driver);
		commonLib.waitForElement(googleHome.txtSearchBox, "visibility", 20);
		googleHome.txtSearchBox.sendKeys("flipkart");

		commonLib.waitForElement(googleHome.firstSuggestion, "visibility", 5);

		for (WebElement ele : googleHome.lstSearchSuggestion)
		{
			System.out.println("Search Suiggestion: " + ele.getText());
		}

		googleHome.txtSearchBox.sendKeys(Keys.ENTER);
		commonLib.waitForElement(googleHome.firstRecord, "visibility", 10);

		for (WebElement ele : googleHome.lstSearchLinks)
		{
			String link = ele.getAttribute("href");
			if (link.toLowerCase().contains("flipkart.com"))
			{
				ele.click();
				break;
			}
		}

		Flipkart flipkart = new Flipkart(driver);
		commonLib.waitForElement(flipkart.lnkTvAndAppliances, "visibility", 20);

		if (commonLib.checkElementPresent(flipkart.btnCloseButton))
		{
			flipkart.btnCloseButton.click();
		}

		flipkart.lnkTvAndAppliances.click();
		commonLib.waitForElement(flipkart.lnkWindowsAc, "visibility", 20);
		flipkart.lnkWindowsAc.click();

		commonLib.waitForElement(flipkart.firstProduct, "clickable", 20);
		flipkart.AddToCompareCheckBoxes.get(1).click();
		flipkart.AddToCompareCheckBoxes.get(2).click();

		commonLib.waitForElement(flipkart.btnCompare, "visibility", 20);
		flipkart.btnCompare.click();

		commonLib.waitForElement(flipkart.chooseBrand, "clickable", 20);
		flipkart.chooseBrand.click();

		commonLib.waitForElement(flipkart.lnkSamsung, "clickable", 20);
		flipkart.lnkSamsung.click();

		commonLib.waitForElement(flipkart.chooseProduct, "clickable", 20);
		Thread.sleep(2000);
		flipkart.chooseProduct.click();
		flipkart.firstProductFromList.click();

		for (int i = 0; i < flipkart.lstSelectedPrice.size(); i++)
		{
			System.out.print(flipkart.lstSelectedProducts.get(i).getText() + " => ");
			System.out.println(flipkart.lstSelectedPrice.get(i).getText());
		}
	}

	@AfterTest
	void down()
	{
		driver.quit();
	}

}
