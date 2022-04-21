import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v99.network.model.Request;
import org.openqa.selenium.devtools.v99.network.model.Response;
import org.openqa.selenium.devtools.v99.network.Network;

public class NetworkLogActivity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ivan\\Desktop\\QA Path\\Projects-Eclipse\\ChromeDriver.exe");
		ChromeDriver driver = new ChromeDriver(); // Open Chrome Browser
		
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		
		devTools.addListener(Network.requestWillBeSent(), request -> {
			Request req = request.getRequest();
			//System.out.println(req.getUrl());
			
		});
		
		//Event when response
		devTools.addListener(Network.responseReceived(), response -> {
			
			Response res = response.getResponse();
			//System.out.println(res.getUrl());
			//System.out.println(res.getStatus());
			if(res.getStatus().toString().startsWith("4")) {
				System.out.println(res.getUrl()+" is failing with status code "+res.getStatus());
			}
			else {
				System.out.println("All good beibi - Status code: "+res.getStatus());				
			}
		});
		driver.get("https://rahulshettyacademy.com/angularAppffdemo/"); //Go to Site
		driver.findElement(By.cssSelector("button[routerlink*='library']")).click();


	}

}
