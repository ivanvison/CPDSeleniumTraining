import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v99.network.Network;
import org.openqa.selenium.devtools.v99.network.model.ConnectionType;
import org.openqa.selenium.devtools.v99.network.model.Request;

import com.google.common.collect.ImmutableList;

public class NetworkSpeed {

	//Add lantecy
	//waits 2-3 seconds
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ivan\\Desktop\\QA Path\\Projects-Eclipse\\ChromeDriver.exe");
		ChromeDriver driver = new ChromeDriver(); // Open Chrome Browser
		
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		
		//Network
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		devTools.send(Network.emulateNetworkConditions(true, 3000, 20000, 10000, Optional.of(ConnectionType.WIFI)));

		devTools.addListener(Network.loadingFailed(), loadingFailed -> {
			System.out.println(loadingFailed.getErrorText() + " - " + loadingFailed.getTimestamp());
		});
		
		long startTime = System.currentTimeMillis();
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/"); //Go to Site
		driver.findElement(By.cssSelector("button[routerlink*='library']")).click();
		
		long endTime = System.currentTimeMillis();
		
		System.out.println(endTime - startTime);
		
		driver.quit();
	}
//15208 vs 2266
}