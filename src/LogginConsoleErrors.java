import java.util.List;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v99.network.Network;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import com.google.common.collect.ImmutableList;

public class LogginConsoleErrors {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//Needs to be writtin in listeners - OnTestFailure
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ivan\\Desktop\\QA Path\\Projects-Eclipse\\ChromeDriver.exe");
		ChromeDriver driver = new ChromeDriver(); // Open Chrome Browser
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/angularAppdemo/"); //Go to Site
		driver.findElement(By.xpath("//a[contains(text(),'Browse Products')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Selenium')]")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Add to Cart')]")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Continue Shopping')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(),'Appium')]")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Add to Cart')]")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Continue Shopping')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(),'Cart')]")).click();
		
		driver.findElement(By.id("exampleInputEmail1")).clear();
		driver.findElement(By.id("exampleInputEmail1")).sendKeys("2");
		
		LogEntries entry = driver.manage().logs().get(LogType.BROWSER);
		List<LogEntry> logs = entry.getAll();
		
		for(LogEntry e : logs) {
			System.out.println(e.getMessage());
		}
				
		
		driver.quit();
		

	}

}
