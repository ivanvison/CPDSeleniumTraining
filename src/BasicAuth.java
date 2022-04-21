import java.util.function.Predicate;
import org.openqa.selenium.chrome.ChromeDriver;
import java.net.URI;

public class BasicAuth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//http://httpbin.org/basic-auth/foo/bar
		//Class URI
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ivan\\Desktop\\QA Path\\Projects-Eclipse\\ChromeDriver.exe");
		ChromeDriver driver = new ChromeDriver(); // Open Chrome Browser
		
		//predicate - create filter condition --- consumer 
		Predicate <URI> uriPredicate = uri -> uri.getHost().contains("httpbin.org");
		
		//((HasAuthentication)driver).register(uriPredicate, UsernameAndPassword.of("foo", "bar"));
		driver.get("http://httpbin.org/basic-auth/foo/bar");

	}

}
