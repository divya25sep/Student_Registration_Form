package form;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Elements {
	
	@Test	
	public void enterinfo() throws AWTException{
		

	 System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
	 WebDriver driver = new ChromeDriver();
	 driver.get("https://www.demoqa.com/checkbox");
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	 
	 //CHECKBOX
     WebElement checkbox = driver.findElement(By.xpath("//span[@class='rct-checkbox']//*[local-name()='svg']"));
     checkbox.click();
     //RADIOBUTTON
     driver.get("https://www.demoqa.com/radio-button");
     WebElement radiobutton = driver.findElement(By.xpath("//label[normalize-space()='Impressive']"));
     radiobutton.click();
     //WEBTABLES
     driver.get("https://www.demoqa.com/webtables");
     List<WebElement> rows =driver.findElements(By.cssSelector("div.rt-tr-group"));
     System.out.println("No of rows are : " + rows.size());
    
     for(int row =0; row<rows.size(); row++)
     {    	 
    	 List < WebElement > Columns_row = rows.get(row).findElements(By.cssSelector("div.rt-td"));
    	 int col_count = Columns_row.size();
     for (int column = 0; column < col_count-1; column++) {
	        // To retrieve text from that specific cell.
	        String celtext = Columns_row.get(column).getText();
	        System.out.println("Cell Value of row number " + row + " and column number " + column + " Is " + celtext);
	    }
	    System.out.println("-------------------------------------------------- ");
	}
    
     List<WebElement> tableheading =driver.findElements(By.xpath("//div[@class='rt-thead -header']"));
    
         
      System.out.println("Headings of columns are :"+tableheading.get(0).getText());
     
    
     WebElement Thirdrow_secondcelldata = driver.findElement(By.cssSelector("div[class='rt-tbody'] div:nth-child(2) div:nth-child(1) div:nth-child(3)"));
     String value = Thirdrow_secondcelldata.getText();
     System.out.println(value);
     //BUTTONS
     driver.get("https://www.demoqa.com/buttons");
     Actions act = new Actions(driver);
     act.contextClick(driver.findElement(By.xpath("//button[normalize-space()='Right Click Me']"))).perform();
     act.doubleClick(driver.findElement(By.xpath("//button[normalize-space()='Double Click Me']"))).perform();
     act.click(driver.findElement(By.xpath("//button[normalize-space()='Click Me']"))).perform();
     //LINKS
     driver.get("https://www.demoqa.com/links");
     
     driver.findElement(By.xpath("//a[normalize-space()='Home']")).click();
    /* String urlToClick=driver.findElement(By.id("simpleLink")).getAttribute("href");
     
     //opening the new tab
     Robot r = new Robot();        
     r.keyPress(KeyEvent.VK_CONTROL);
     r.keyPress(KeyEvent.VK_T);
     r.keyRelease(KeyEvent.VK_CONTROL);
     r.keyRelease(KeyEvent.VK_T);
     
     //getting all the handles currently available
     Set<String> handles=driver.getWindowHandles();
     for(String actual: handles)
     {
         
      if(!actual.equalsIgnoreCase(driver.getWindowHandle()))
      {
          //switching to the opened tab
          driver.switchTo().window(actual);
          
          //opening the URL saved.
          driver.get(urlToClick);
      }
     }
     */
    
     //Download a file in chrome browser
     String downloadFilePath = "C:\\Users\\Divya Khandelwal\\Downloads";

     HashMap<String, Object> chromePref = new HashMap<String, Object>();

     chromePref.put("profile.default_content_settings.popups", 0);

     chromePref.put("download.default_directory", downloadFilePath);

     ChromeOptions options = new ChromeOptions();

     options.setExperimentalOption("prefs", chromePref);

     driver = new ChromeDriver(options);

     driver.get("https://www.demoqa.com/upload-download");

     driver.findElement(By.xpath("//a[normalize-space()='Download']")).click();

   
     
     //Dynamic Properties
     driver.get("https://www.demoqa.com/dynamic-properties");
     WebElement firstbutton = driver.findElement(By.xpath("//button[normalize-space()='Will enable 5 seconds']"));
     System.out.println("Text of first button: "+firstbutton.getText());
     WebElement secondbutton = driver.findElement(By.xpath("//button[normalize-space()='Color Change']"));
     System.out.println("Text of second button :"+secondbutton.getText());
     WebDriverWait wait=new WebDriverWait(driver, 20);
     WebElement thirdbutton= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Visible After 5 Seconds']")));
     System.out.println("Text of second button :"+thirdbutton.getText());
     


     
}
}
