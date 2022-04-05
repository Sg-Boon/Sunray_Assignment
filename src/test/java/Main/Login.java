package Main;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {
	 public static WebDriver driver;
	
	 @BeforeMethod
	 public void launchBrowser()
		{
		//Setup chromedriver via maven webdriver manager
		 WebDriverManager.chromedriver().setup();

		}
	 
		
		@SuppressWarnings("deprecation")
		@Test
		public void loginTest01() throws InterruptedException 
		{
			//Create object of the chrome driver	
			 driver = new ChromeDriver();
			//Open Webpage
			driver.get("https://react-redux.realworld.io/");
			driver.manage().window().maximize();
			Thread.sleep(2000);
			String expected_Error = "email or password is invalid";
			
			// Click on the Global "Sign in" label
			driver.findElement(By.xpath("//*[@id=\"main\"]/div/nav/div/ul/li[2]/a")).click();
			//Fill in Email
			driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div/div/form/fieldset/fieldset[1]/input"))
					.sendKeys("abc@gmail.com");
			//Fill in Password
			driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div/div/form/fieldset/fieldset[2]/input"))
					.sendKeys("your_password");
			//Click on the login page "Sign in" button
			driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div/div/form/fieldset/button")).click();

			//Compare actual error and expected error
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			String actual_Error = driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/ul/li")).getText();
			Assert.assertEquals(actual_Error, expected_Error);
			System.out.println("Actual Error Message:"+actual_Error);
		}
		
		@SuppressWarnings("deprecation")
		@Test
		public void loginTest02() throws InterruptedException 
		{
			//Create object of the chrome driver	
			 driver = new ChromeDriver();
			//Open Webpage
			driver.get("https://react-redux.realworld.io/");
			driver.manage().window().maximize();
			Thread.sleep(2000);
			String expected_Error = "email can't be blank";
			
			// Click on the Global "Sign in" label
			driver.findElement(By.xpath("//*[@id=\"main\"]/div/nav/div/ul/li[2]/a")).click();
			//Click on the login page "Sign in" button			
			driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div/div/form/fieldset/button")).click();
			
			//Compare actual error and expected error
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			String actual_Error = driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/ul/li")).getText();
			Assert.assertEquals(actual_Error, expected_Error);
			System.out.println("Actual Error Message:"+actual_Error);
		}
		
		@SuppressWarnings("deprecation")
		@Test
		public void loginTest03() throws InterruptedException 
		{
			//Create object of the chrome driver	
			 driver = new ChromeDriver();
			//Open Webpage
			driver.get("https://react-redux.realworld.io/");
			driver.manage().window().maximize();
			Thread.sleep(2000);
			String expected_Error = "password can't be blank";
			
			// Click on the Global "Sign in" label
			driver.findElement(By.xpath("//*[@id=\"main\"]/div/nav/div/ul/li[2]/a")).click();
			//Fill in Email
			driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div/div/form/fieldset/fieldset[1]/input"))
					.sendKeys("abc@gmail.com");
			//Click on the login page "Sign in" button
			driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div/div/form/fieldset/button")).click();
			//driver.close();
			//Compare actual error and expected error
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			String actual_error = driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/ul/li")).getText();
			Assert.assertEquals(actual_error, expected_Error);
			System.out.println("Actual Error Message:"+actual_error);
		}

		
		@Test
		public void loginTest04() throws InterruptedException 
		{
			//Create object of the chrome driver	
			 driver = new ChromeDriver();
			//Open Webpage
			driver.get("https://react-redux.realworld.io/");
			driver.manage().window().maximize();
			Thread.sleep(2000);

			
			// Click on the Global "Sign in" label
			driver.findElement(By.xpath("//*[@id=\"main\"]/div/nav/div/ul/li[2]/a")).click();
			//Fill in Email
			driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div/div/form/fieldset/fieldset[1]/input"))
					.sendKeys("Test02@Test.com");
			//Fill in Password
			driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div/div/form/fieldset/fieldset[2]/input"))
					.sendKeys("Test02");
			//Click on the login page "Sign in" button
			driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div/div/form/fieldset/button")).click();
		Thread.sleep(3000);
		}
		
		@Test
		public void loginTest05() throws InterruptedException 
		{
			//Create object of the chrome driver	
			 driver = new ChromeDriver();
			//Open Webpage
			driver.get("https://react-redux.realworld.io/");
			driver.manage().window().maximize();
			Thread.sleep(2000);

			
			// Click on the Global "Sign up" label
			driver.findElement(By.xpath("//*[@id=\"main\"]/div/nav/div/ul/li[3]/a")).click();
			//Fill in Username
			driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div/div/form/fieldset/fieldset[1]/input"))
			.sendKeys("Test03");
			//Fill in Email
			driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div/div/form/fieldset/fieldset[2]/input"))
					.sendKeys("Test03@Test.com");
			//Fill in Password
			driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div/div/form/fieldset/fieldset[3]/input"))
					.sendKeys("Test03");
			//Click on the login page "Sign in" button
			driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div/div/form/fieldset/button")).click();
		Thread.sleep(3000);
		}
		
		@SuppressWarnings("deprecation")
		@Test
		public void loginTest06() throws InterruptedException 
		{
			//Create object of the chrome driver	
			 driver = new ChromeDriver();
			//Open Webpage
			driver.get("https://react-redux.realworld.io/");
			driver.manage().window().maximize();
			Thread.sleep(2000);
			String expected_Error1 = "email has already been taken";
			String expected_Error2 = "username has already been taken";

			
			// Click on the Global "Sign up" label
			driver.findElement(By.xpath("//*[@id=\"main\"]/div/nav/div/ul/li[3]/a")).click();
			//Fill in Username
			driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div/div/form/fieldset/fieldset[1]/input"))
			.sendKeys("Test03");
			//Fill in Email
			driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div/div/form/fieldset/fieldset[2]/input"))
					.sendKeys("Test03@Test.com");
			//Fill in Password
			driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div/div/form/fieldset/fieldset[3]/input"))
					.sendKeys("Test03");
			//Click on the login page "Sign in" button
			driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div/div/form/fieldset/button")).click();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			String actual_Error1 = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div/div/ul/li[1]")).getText();
			Assert.assertEquals(actual_Error1, expected_Error1);
			String actual_Error2 = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div/div/ul/li[2]")).getText();
			Assert.assertEquals(actual_Error2, expected_Error2);
			Thread.sleep(3000);
		}
		
		@AfterMethod
		 public void closeBrowser()
			{
			 driver.close();

			}
	}
	
