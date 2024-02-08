package task18;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropOperation {

	public static void main(String[] args) {

			//Using Edge Browser Instead of Chrome
			WebDriver driver = new EdgeDriver();  
			
			//Maximizing the window 
			driver.manage().window().maximize();
			
			//Using ImplicitlyWait for page to wait
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		 
			//Navigating the URL
			driver.get("https://jqueryui.com/droppable/");
		
			//Using Actions for drag and drop
			Actions mouse =new Actions(driver);         
		
			//Using switchTo for index
			driver.switchTo().frame(0);
		
			//Finding dragged element
			WebElement drag = driver.findElement(By.id("draggable"));       
		
			//Finding dropped element
			WebElement drop = driver.findElement(By.id("droppable"));
			
			
			String BeforeColor = drop.getCssValue("background-color");
			System.out.println("\nBefore Dragging -> "+BeforeColor);
		
			//Performing drag and drop 
			mouse.dragAndDrop(drag, drop).perform(); 
			
			String afterColor = drop.getCssValue("background-color");
			System.out.println("\nAfter Dragging -> " +afterColor);
			
			//Using getText to verify the action
			String droppedtext = driver.findElement(By.xpath("//p[text()='Dropped!']")).getText();  

			//Printing the message
			System.out.println("\n" +droppedtext);  
			
			if (droppedtext.equals("Dropped!") && afterColor.equals("rgba(255, 250, 144, 1)")) 
			{
				System.out.println("\nDrag & Drop Operation success");				
						
			} 
			else 
			{
				System.out.println("\nDrag & Drop Operation failed");
			}
			
				
			//Closing the driver
			driver.close();

	}

}
