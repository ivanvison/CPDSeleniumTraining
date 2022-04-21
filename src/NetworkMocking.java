import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v99.network.model.Request;
import org.openqa.selenium.devtools.v99.network.model.Response;
import org.openqa.selenium.devtools.v99.fetch.Fetch;
import org.openqa.selenium.devtools.v99.network.Network;

public class NetworkMocking {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ivan\\Desktop\\QA Path\\Projects-Eclipse\\ChromeDriver.exe");
		ChromeDriver driver = new ChromeDriver(); // Open Chrome Browser
		
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		
		//Fetch
		devTools.send(Fetch.enable(Optional.empty(), Optional.empty()));
		
		devTools.addListener(Fetch.requestPaused(), request -> {
			Request req = request.getRequest();
			//System.out.println(req.getUrl());
			if(req.getUrl().contains("shetty")) {
				String mockedUrl = req.getUrl().replace("=shetty", "=BadGuy");
				System.out.println(mockedUrl);
				devTools.send(Fetch.continueRequest(request.getRequestId(), Optional.of(mockedUrl), Optional.of(request.getRequest().getMethod()), Optional.empty(), Optional.empty(), Optional.empty()));
			}
			else {
				devTools.send(Fetch.continueRequest(request.getRequestId(), Optional.of(req.getUrl()), Optional.of(request.getRequest().getMethod()), Optional.empty(), Optional.empty(), Optional.empty()));
			}
		});
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/"); //Go to Site
		driver.findElement(By.cssSelector("button[routerlink*='library']")).click();
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.cssSelector("p")).getText());
		
	}

}
