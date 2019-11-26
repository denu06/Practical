package WebElements;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by DenishM on 26-11-2019
 */
public class Flipkart
{
	WebDriver				driver;

	@FindBy(xpath = "//button[@class='_2AkmmA _29YdH8']")
	public WebElement		btnCloseButton;

	@FindBy(xpath = ".//span[text()='TVs & Appliances']")
	public WebElement		lnkTvAndAppliances;

	@FindBy(xpath = "//a[@title='Window ACs']")
	public WebElement		lnkWindowsAc;

	@FindBy(css = "._1UoZlX ._1p7h2j")
	public List<WebElement>	AddToCompareCheckBoxes;

	@FindBy(xpath = "(//div[@class='_3ozNsv'])[2]/div")
	public WebElement		firstProductFromList;

	@FindBy(xpath = "//span[text()='COMPARE']")
	public WebElement		btnCompare;

	@FindBy(xpath = "(//*[@class='col-2-5']//div[text()='Choose Brand'])[1]")
	public WebElement		chooseBrand;

	@FindBy(xpath = "(//*[@class='col-2-5']//div[@title='Samsung'])[1]")
	public WebElement		lnkSamsung;

	@FindBy(xpath = "(//*[@class='col-2-5']//div[text()='Choose a Product'])[1]")
	public WebElement		chooseProduct;

	/*	@FindBy(css = "(//div[@class='_3ozNsv'])[2]/div")
		public List<WebElement>	lstProducts;*/

	@FindBy(css = "._1ouGhW ._3YNWH1")
	public List<WebElement>	lstSelectedProducts;

	@FindBy(css = ".aqcZRL ._1vC4OE")
	public List<WebElement>	lstSelectedPrice;

	@FindBy(xpath = "(//div[@class='_1UoZlX'])[1]")
	public WebElement		firstProduct;

	public Flipkart(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
