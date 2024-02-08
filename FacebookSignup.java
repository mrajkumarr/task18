package task18;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FacebookSignup {

	public static void main(String[] args) {
		
			
			WebDriver driver = new ChromeDriver();  
		
			//Maximizing the window 
			driver.manage().window().maximize();
			
			//Navigating the URL
			driver.navigate().to("https://www.facebook.com/");
			
			//Using ImplicitlyWait for page to wait
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			
			//Using getTitle to verify the URL
			String title = driver.getTitle();
			System.out.println("Current Page -> " +title); 
					
			//To find create a new account and click
			driver.findElement(By.linkText("Create new account")).click();
			
			//Values for First Name
			driver.findElement(By.name("firstname")).sendKeys("Rajkumar");			
			//Values for Last Name
			driver.findElement(By.name("lastname")).sendKeys("Raj");			
			//Values for Email
			driver.findElement(By.name("reg_email__")).sendKeys("mrajkumarrr@gmail.com");
			driver.findElement(By.name("reg_email_confirmation__")).sendKeys("mrajkumarrr@gmail.com");
			//Values for Password
			driver.findElement(By.id("password_step_input")).sendKeys("Gamer619@");
			
			//Using Select class to select the value
			WebElement day = driver.findElement(By.id("day"));     
			Select selectDay = new Select(day);
			selectDay.selectByVisibleText("26");		
			
			WebElement month = driver.findElement(By.id("month"));         
			Select selectMonth = new Select(month);
			selectMonth.selectByValue("5");
		
			WebElement year = driver.findElement(By.id("year"));		
			Select selectYear = new Select(year);
			selectYear.selectByVisibleText("1995");
			
			//For clicking male radio button
			driver.findElement(By.xpath("(//input[@name='sex'])[2]")).click();
					 
			//Clicking submit button
			driver.findElement(By.name("websubmit")).click();
			
			driver.findElement(By.linkText("No, Create New Account")).click();
		
			//To verify the page
			String verify = driver.findElement(By.xpath("(//h2[text()='Enter the code from your email'])")).getText();			
			
			if (verify.equals("Enter the code from your email")) 
			{
				System.out.println("\nVerification code sent to your registered Email");
			} 
			else 
			{
				System.out.println("\nVerification Failed");
			}
			
			//Closing the driver
			//driver.close();
	}

}
