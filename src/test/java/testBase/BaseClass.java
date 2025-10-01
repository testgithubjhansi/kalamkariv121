package testBase;

 import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;


public class BaseClass {
	
public static WebDriver driver;
public Logger logger;
public Properties p;
	
	@BeforeClass
    @Parameters({"os","browser"})
	public void setup(String os,String br) throws IOException {
		//logger=LogManager.getLogger(this.getClass());
		
		FileReader file=new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		
		switch(br.toLowerCase()) {
		case "chrome":driver= new ChromeDriver();break;
		case "edge":driver= new EdgeDriver();break;
		case "firefox":driver= new FirefoxDriver();break;
		default :System.out.println("invalid username");return;
		}
	
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("appurl"));
		driver.manage().window().maximize();
	}
		//@AfterClass
		public void tearDown() {
			driver.quit();
		}
		public String capturescreen(String tname) {
			String timestamp= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			
			 TakesScreenshot ts = (TakesScreenshot) driver;
			 File sourceFile = ts.getScreenshotAs(OutputType.FILE);
			 String targerFilePath=System.getProperty(("user.dir")+"\\screenshots\\"+tname+"_"+timestamp);
			 File targetFile = new File(targerFilePath);
			 sourceFile.renameTo(targetFile);
			
			return targerFilePath;
		}

		
			
		}
		
		
		
	