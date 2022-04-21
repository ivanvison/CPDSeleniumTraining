import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v99.network.model.ErrorReason;
import org.openqa.selenium.devtools.v99.network.model.Request;
import org.openqa.selenium.devtools.v99.network.model.Response;
import org.openqa.selenium.devtools.v99.fetch.Fetch;
import org.openqa.selenium.devtools.v99.fetch.model.RequestPattern;
import org.openqa.selenium.devtools.v99.network.Network;

public class NetworkFailRequest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ivan\\Desktop\\QA Path\\Projects-Eclipse\\ChromeDriver.exe");
		ChromeDriver driver = new ChromeDriver(); // Open Chrome Browser
		
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		
		//Fetch
		Optional<List<RequestPattern>> patterns = Optional.of(Arrays.asList(new RequestPattern(Optional.of("*GetBook*"), Optional.empty(), Optional.empty())));
		devTools.send(Fetch.enable(patterns, Optional.empty()));
		
		devTools.addListener(Fetch.requestPaused(), request -> {
			Request req = request.getRequest();
			//System.out.println(req.getUrl());
			devTools.send(Fetch.failRequest(request.getRequestId(), ErrorReason.FAILED));
		});

		driver.get("https://rahulshettyacademy.com/angularAppdemo/"); //Go to Site
		driver.findElement(By.cssSelector("button[routerlink*='library']")).click();
		
	}

}
