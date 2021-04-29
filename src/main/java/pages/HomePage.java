package pages;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    public WebDriver driver;
    protected WebDriverWait wait;
    protected int timeout = 5;

    public void startBrowser(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, timeout);
        driver.get("https://qa-automation-challenge.github.io/sandbox/");
        Assert.assertEquals("Product Subscription Configurator", driver.getTitle());
    }

    public void closeBrowser(){
        driver.close();
    }

    public void selectType(String selectedType){
        Select type = new Select(driver.findElement(By.id("type")));
        type.selectByVisibleText(selectedType);
    }

    public void selectPlan(String selectedPlan){
        Select supportPlan = new Select(driver.findElement(By.id("support")));
        supportPlan.selectByVisibleText(selectedPlan);
    }

    public void setDuration(String months){
        driver.findElement(By.id("duration")).sendKeys(months);
    }

    public WebElement calculateButton(){
        WebElement button = driver.findElement(By.id("calculate"));
        return button;
    }

    public WebElement price(){
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".row.d-none"))); it didnt work  as planned :(
        WebElement price = driver.findElement(By.id("price"));
        return price;
    }
}
