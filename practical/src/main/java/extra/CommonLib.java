package extra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by DenishM on 26-11-2019
 */
public class CommonLib
{

	WebDriver driver;

	public CommonLib(WebDriver driver)
	{
		this.driver = driver;
	}

	public void waitForElement(WebElement element, String action, int timeout)
	{
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		System.out.println("Waiting for: " + element.toString());
		try
		{
			if (action.equalsIgnoreCase("visibility"))
			{
				wait.until(ExpectedConditions.visibilityOf(element));
			}
			else if (action.equalsIgnoreCase("clickable"))
			{
				wait.until(ExpectedConditions.elementToBeClickable(element));
			}
			else if (action.equalsIgnoreCase("invisible"))
			{
				wait.until(ExpectedConditions.invisibilityOf(element));
			}
		}
		catch (Exception e)
		{
			System.err.println("waitForElement timeOut");
		}

	}

	public boolean checkElementPresent(WebElement element)
	{
		try
		{
			element.getTagName();
			System.out.println("Element present");
			return true;
		}
		catch (Exception e)
		{
			System.out.println("Element not present");
			return false;
		}

	}
}
