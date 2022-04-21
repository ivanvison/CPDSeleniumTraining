import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v99.network.model.Request;
import org.openqa.selenium.devtools.v99.network.model.Response;

import com.google.common.collect.ImmutableList;

import org.openqa.selenium.devtools.v99.network.Network;

public class BlockNetworkCalls {

	//Stop CSS, Images
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ivan\\Desktop\\QA Path\\Projects-Eclipse\\ChromeDriver.exe");
		ChromeDriver driver = new ChromeDriver(); // Open Chrome Browser
		
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		
		//Network
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		devTools.send(Network.setBlockedURLs(ImmutableList.of("*.jpg", "*.css")));

		driver.get("https://rahulshettyacademy.com/angularAppdemo/"); //Go to Site
		driver.findElement(By.cssSelector("a[routerlink*='products']")).click(); 
		driver.findElement(By.xpath("//a[contains(text(),'Selenium')]")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Add to Cart')]")).click();
		System.out.println(driver.findElement(By.className("sp")).getText());
	}

}