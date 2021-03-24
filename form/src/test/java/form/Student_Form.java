
package form;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
 
public class Student_Form {
 
@Test	
public void enterdetails(){
	

 System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
 WebDriver driver = new ChromeDriver();
 driver.get("https://www.demoqa.com/automation-practice-form");
 driver.manage().window().maximize();
 Actions act = new Actions(driver);
 driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
 WebElement heading = driver.findElement(By.xpath("//h5[normalize-space()='Student Registration Form']"));
 WebElement f_name  = driver.findElement(By.xpath("//input[@id='firstName']"));
 f_name.sendKeys("Divya");
 WebElement l_name  = driver.findElement(By.xpath("//input[@id='lastName']"));
 l_name.sendKeys("Khandelwal");
 WebElement Email = driver.findElement(By.xpath("//input[@id='userEmail']"));
 Email.sendKeys("divyakhandelwal0001@gmail.com");
 WebElement Gender = driver.findElement(By.xpath("//label[normalize-space()='Female']"));
 Gender.click();
 WebElement Mobile = driver.findElement(By.xpath("//input[@id='userNumber']"));
 Mobile.sendKeys("9958708052");
 WebElement newElement = driver.findElement(By.cssSelector("#dateOfBirthInput"));
 
 JavascriptExecutor js = (JavascriptExecutor) driver;
 js.executeScript("document.getElementById('dateOfBirthInput').value='10 Mar 2000'");
 
 act.moveToElement(driver.findElement(By.xpath("//div[@class='subjects-auto-complete__value-container subjects-auto-complete__value-container--is-multi css-1hwfws3']"))).click().sendKeys("Maths").sendKeys(Keys.ENTER).build().perform();


 
  WebElement checkbox =driver.findElement(By.xpath("//label[normalize-space()='Reading']"));
  checkbox.click();
  WebElement upload_pic =driver.findElement(By.xpath("//input[@id='uploadPicture']"));
  upload_pic.sendKeys("C:\\Users\\Divya Khandelwal\\Desktop\\Documents\\passport size photo.jpg");
  WebElement address = driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
  address.sendKeys("Greater Noida");
  
  



act.click(driver.findElement(By.xpath("//div[contains(text(),'Select State')]"))).perform();
act.keyDown(Keys.CONTROL).sendKeys(Keys.ENTER).keyUp(Keys.CONTROL).build().perform();
 // Select state = new Select(driver.findElement(By.xpath("//div[contains(text(),'Select State')]")));
 // state.selectByVisibleText("Haryana");
  

 act.click(driver.findElement(By.xpath("//div[contains(text(),'Select City')]"))).perform();
 act.keyDown(Keys.CONTROL).sendKeys(Keys.ENTER).keyUp(Keys.CONTROL).build().perform(); 
  
  
 WebElement submit = driver.findElement(By.xpath("//button[normalize-space()='Submit']"));
 submit.click();

 WebElement modal = driver.findElement(By.xpath("//div[@id='example-modal-sizes-title-lg']"));
 String val=modal.getAttribute("innerText");
 System.out.println(val);
 
 driver.findElement(By.xpath("//button[normalize-space()='Close']")).click();
 

}
}