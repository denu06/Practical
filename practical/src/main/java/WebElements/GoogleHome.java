package WebElements;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by DenishM on 26-11-2019
 */
public class GoogleHome
{
	WebDriver				driver;

	@FindBy(css = "input[name='q']")
	public WebElement		txtSearchBox;

	@FindBy(xpath = "(//*[@class='sbl1'])[1]")
	public WebElement		firstSuggestion;

	@FindBy(css = ".sbl1")
	public List<WebElement>	lstSearchSuggestion;

	@FindBy(css = ".rc > .r > a")
	public List<WebElement>	lstSearchLinks;

	@FindBy(xpath = "(//div[@class='rc'])[1]")
	public WebElement		firstRecord;

	public GoogleHome(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
