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

    // Usage of TestNG annotation to run test
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

        // WebDriver polls the DOM for a certain duration when trying to find any element
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);

        // Clear and type in the word "stainless work table" in the input field box
        driver.findElement(By.id("searchval")).clear();
        driver.findElement(By.id("searchval")).sendKeys("stainless work table");

        // WebDriver polls the DOM for a certain duration when trying to find any element
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);

        // Tabs to the search button and press Enter key
        driver.findElement(By.id("searchval")).sendKeys(Keys.TAB);
        driver.findElement(By.id("searchval")).sendKeys(Keys.TAB);
        driver.findElement(By.id("searchval")).sendKeys(Keys.ENTER);

        // Initializes a new instance of the WebDriverWait class
        WebDriverWait wait = new WebDriverWait(driver, 9000);

        // Create a list of element and wait until all visible word table presented on page
        List<WebElement> tableElements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[contains(text(),'Table')]")));

        // Check if there is any matching table word elements, print out all contains table
        for (WebElement element : tableElements) {
            System.out.println(element.getText());
        }

        // WebDriver polls the DOM for a certain duration when trying to find any element
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);

        // Create webElement in Selenium is essentially an HTML element on a website
        WebElement addToCartLastProduct = driver.findElement(By.xpath("(//a[contains(text(),'Table')])[last()-1]"));

        // WebDriver polls the DOM for a certain duration when trying to find any element
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);

        // Click the last product to Add to Cart
        addToCartLastProduct.click();

        // WebDriver polls the DOM for a certain duration when trying to find any element
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

        // Create webElement in Selenium is essentially an HTML element on a website
        WebElement addToCart = driver.findElement(By.xpath("(//input[@value='Add to Cart'])[1]"));

        // Click Add to Cart button
        addToCart.click();

        // Create webElement in Selenium is essentially an HTML element on a website
        WebElement viewCart = driver.findElement(By.xpath("//button[contains(text(), 'View Cart')]"));

        // WebDriver polls the DOM for a certain duration when trying to find any element
        driver.manage().timeouts().pageLoadTimeout(15000, TimeUnit.MILLISECONDS);

        // JavaScriptExecutor is an interface that helps to execute JavaScript through Selenium Webdriver
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", viewCart);

        // Wait for an element to be visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'View Cart')]")));

        // WebDriver polls the DOM for a certain duration when trying to find any element
        driver.manage().timeouts().implicitlyWait(3000    , TimeUnit.MILLISECONDS);

        // Click View Cart button
        viewCart.click();

        // WebDriver polls the DOM for a certain duration when trying to find any element
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

        // WebDriver polls the DOM for a certain duration when trying to find any element
        WebElement emptyCart = driver.findElement(By.xpath("//button[contains(text(), 'Empty Cart')]"));

        // Assertion equals text string same as element on page
        Assert.assertEquals("Empty Cart", driver.findElement(By.xpath("//button[contains(text(), 'Empty Cart')]")).getText());

        // JavaScriptExecutor is an interface that helps to execute JavaScript through Selenium Webdriver
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", emptyCart);

        // WebDriver polls the DOM for a certain duration when trying to find any element
        driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.MILLISECONDS);

        // Click empty cart button
        emptyCart.click();

        // WebDriver polls the DOM for a certain duration when trying to find any element
        WebElement emptyCartConfirmation = driver.findElement(By.xpath("(//button[contains(.,'Cart')])[2]"));

        // JavaScriptExecutor is an interface that helps to execute JavaScript through Selenium Webdriver
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", emptyCartConfirmation);

        // WebDriver polls the DOM for a certain duration when trying to find any element
        driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.MILLISECONDS);

        // Click empty card confirmation button
        emptyCartConfirmation.click();

        // Close the driver browser page
        driver.close();
    }
}




