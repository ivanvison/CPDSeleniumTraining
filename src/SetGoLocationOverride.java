import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

public class SetGoLocationOverride {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ivan\\Desktop\\QA Path\\Projects-Eclipse\\ChromeDriver.exe");
		ChromeDriver driver = new ChromeDriver(); // Open Chrome Browser
		
		DevTools devTools = driver.getDevTools();
		
		devTools.createSession();
		
		Map<String,Object> coordinates = new HashMap<String,Object>();
		coordinates.put("latitude",40);
		coordinates.put("longitude",3);
		coordinates.put("accuracy",1);		
		driver.executeCdpCommand("Emulation.setGeolocationOverride", coordinates);
		driver.get("https://google.com"); //Go to Site
		driver.findElement(By.name("q")).sendKeys("netflix",Keys.ENTER);
		driver.findElements(By.xpath("//h3[@class='LC20lb MBeuO DKV0Md']")).get(0).click();
		String title = driver.findElement(By.cssSelector(".our-story-card-title")).getText();
		System.out.println(title);
	}

}
