import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v99.emulation.Emulation;
import org.openqa.selenium.devtools.v99.network.Network;

public class MobileEmulatorTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ivan\\Desktop\\QA Path\\Projects-Eclipse\\ChromeDriver.exe");
		ChromeDriver driver = new ChromeDriver(); // Open Chrome Browser
		
		DevTools devTools = driver.getDevTools();
		
		devTools.createSession();
		
		//Send Commands to CDP methods -> CDP Methods will invoke and get access to chrome dev tools
		//Emulate Device
		devTools.send(Emulation.setDeviceMetricsOverride(600, 1000, 50, true, Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));
		driver.get("https://rahulshettyacademy.com/angularAppdemo/"); //Go to Site
		driver.findElement(By.cssSelector(".navbar-toggler")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Library")).click();

		
	}

}
