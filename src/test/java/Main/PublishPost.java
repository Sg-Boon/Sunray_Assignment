package Main;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PublishPost {

	public static WebDriver driver;

	@BeforeMethod
	public void launchBrowser() {
		// Setup chromedriver via maven webdriver manager
		WebDriverManager.chromedriver().setup();

	}

	@SuppressWarnings("deprecation")
	@Test
	public void publishPost01() throws InterruptedException {
		// Create object of the chrome driver
		driver = new ChromeDriver();
		// Open Webpage
		driver.get("https://react-redux.realworld.io/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		Date date = new Date();
		String expected_ArticleTitle = ("Test02" + " " + date.toString());
		Lorem lorem = LoremIpsum.getInstance();
		String expected_ArticleAbout = (lorem.getCountry());
		String expected_FillArticle = (lorem.getWords(100));
		String expected_ArticleTag = (lorem.getWords(1, 2));
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Click on the Global "Sign in" label
		driver.findElement(By.xpath("//*[@id=\"main\"]/div/nav/div/ul/li[2]/a")).click();
		// Fill in Email
		driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div/div/form/fieldset/fieldset[1]/input"))
				.sendKeys("Test02@Test.com");
		// Fill in Password
		driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div/div/form/fieldset/fieldset[2]/input"))
				.sendKeys("Test02");
		// Click on the login page "Sign in" button
		driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div/div/form/fieldset/button")).click();
		Thread.sleep(3000);
		// Click on New Post
		driver.findElement(By.xpath("//*[@id=\"main\"]/div/nav/div/ul/li[2]/a")).click();
		// Fill in Article Title
		driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div/div/form/fieldset/fieldset[1]/input"))
				.sendKeys(expected_ArticleTitle);

		// Fill in article about
		driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div/div/form/fieldset/fieldset[2]/input"))
				.sendKeys(expected_ArticleAbout);

		// Fill in article
		driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div/div/form/fieldset/fieldset[3]/textarea"))
				.sendKeys(expected_FillArticle);
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		// Fill in tag
		driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div/div/form/fieldset/fieldset[4]/input"))
				.sendKeys(expected_ArticleTag);
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		// Click on Publish Article
		driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div/div/form/fieldset/button")).click();
		// Verify fields are publish correctly
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		String actual_ArticleTitle = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div[1]/div/h1")).getText();
		Assert.assertEquals(actual_ArticleTitle, expected_ArticleTitle);
		System.out.println("expect"+expected_FillArticle);
		String actual_FillArticle = driver
				.findElement(By.xpath("//*[@id=\"main\"]/div/div/div[2]/div[1]/div/div/p"))
				.getText();
		System.out.println("actual"+actual_FillArticle);
		Assert.assertEquals(actual_FillArticle, expected_FillArticle);
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		//Sign Out
		//Click on the Global Smiley face icon on top right corner
		driver.findElement(By.xpath("//*[@id=\"main\"]/div/nav/div/ul/li[4]/a")).click();
		// Click on the button " Edit Profile Settings"
		driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div[1]/div/div/div/a")).click();
        //This will scroll the web page till end.		
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		// Click on the button "Or click here to logout".
		driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div/div/button")).click();

	
	}
	
	@AfterMethod	
	public void closeBrowser()
	{
		//driver.close();
	}

}
