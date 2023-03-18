import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class JavaSelenium {
    @Test
    public void WebDemo() {

        // Create WebDriver drives a browser natively, as a user would, either locally or on a remote machine using the Selenium server,
        // marks a leap forward in terms of browser automation.
        WebDriver driver = null;

        // Create web driver manager to open chrome web page
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        // Maximize web page
        driver.manage().window().maximize();

        // Go to url
        driver.get("https://www.webstaurantstore.com/");

        // Implicits times to waits until table elements to load on page
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);

        // Type in the word "stainless work table" in the input field box
        driver.findElement(By.id("searchval")).clear();
        driver.findElement(By.id("searchval")).sendKeys("stainless work table");

        // Tabs to the search button and press Enter key
        driver.findElement(By.id("searchval")).sendKeys(Keys.TAB);
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
        driver.findElement(By.id("searchval")).sendKeys(Keys.TAB);
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
        driver.findElement(By.id("searchval")).sendKeys(Keys.ENTER);

        // Initializes a new instance of the WebDriverWait class
        WebDriverWait wait = new WebDriverWait(driver, 9000);

        // Create a list of element and wait until all visible word table presented on page
        List<WebElement> tableElements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[contains(text(),'Table')]")));

        // Check if there is any matching table word elements, print out all contains table
        for (WebElement element : tableElements) {
            System.out.println(element.getText());
        }

        // Implicits times to waits until table elements to load on page
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);

        // Create webElement in Selenium is essentially an HTML element on a website
        WebElement addToCartLastProduct = driver.findElement(By.xpath("(//a[contains(text(),'Table')])[last()-1]"));

        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);

        // Click on the element as create on the page
        addToCartLastProduct.click();

        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

        WebElement addToCart = driver.findElement(By.xpath("(//input[@value='Add to Cart'])[1]"));

        addToCart.click();

        WebElement viewCart = driver.findElement(By.xpath("//button[contains(text(), 'View Cart')]"));

        driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);

        // JavaScriptExecutor is an interface that helps to execute JavaScript through Selenium Webdriver
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", viewCart);


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'View Cart')]")));

        viewCart.click();

        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

        WebElement emptyCart = driver.findElement(By.xpath("//button[contains(text(), 'Empty Cart')]"));

        // Assertion equals text string same as element on page
        Assert.assertEquals("Empty Cart", driver.findElement(By.xpath("//button[contains(text(), 'Empty Cart')]")).getText());

        // JavaScriptExecutor is an interface that helps to execute JavaScript through Selenium Webdriver
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", emptyCart);

        driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.MILLISECONDS);
        emptyCart.click();

        WebElement emptyCartConfirmation = driver.findElement(By.xpath("(//button[contains(.,'Cart')])[2]"));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", emptyCartConfirmation);

        driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.MILLISECONDS);
        emptyCartConfirmation.click();

        // Close the driver browser page
        driver.close();
    }
}




