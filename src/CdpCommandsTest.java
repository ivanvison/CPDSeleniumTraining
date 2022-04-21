import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v99.emulation.Emulation;

public class CdpCommandsTest {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ivan\\Desktop\\QA Path\\Projects-Eclipse\\ChromeDriver.exe");
		ChromeDriver driver = new ChromeDriver(); // Open Chrome Browser
		
		DevTools devTools = driver.getDevTools();
		
		devTools.createSession();
		
		Map deviceMetrics = new HashMap();
		deviceMetrics.put("width",600);
		deviceMetrics.put("height",1000);
		deviceMetrics.put("deviceScaleFactor",600);
		deviceMetrics.put("mobile",true);
		driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", deviceMetrics);
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/"); //Go to Site
		driver.findElement(By.cssSelector(".navbar-toggler")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Library")).click();
	}

}
