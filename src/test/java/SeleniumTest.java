import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumTest {
    public static ChromeOptions options;

    public static WebDriver driver;

    @BeforeTest
     void setup(){
        options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/test/resources/chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.get("https://www.mediastore.hr");
    }
    @Test
    void loginTest() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("denismrdalj@gmail.com");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"passwd\"]")).sendKeys("denis.dena");
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]")).click();
    }
    @Test
    void searchTest() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"search_query_top\"]")).sendKeys("pioneer dj");
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id=\"searchbox\"]/button")).click();
    }
    @Test
    void newsletterTest() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"newsletter-input\"]")).sendKeys("fakemail@fake.com");
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id=\"newsletter_block_left\"]/div/ul/li/form/div/button")).click();
    }
    @Test
    void wishlistTest() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("denismrdalj@gmail.com");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"passwd\"]")).sendKeys("denis.dena");
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]")).click();

        driver.findElement(By.xpath("//*[@id=\"search_query_top\"]")).sendKeys("pioneer dj");
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id=\"searchbox\"]/button")).click();
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[1]/div/a/img[1]"));
        action.moveToElement(element);
        WebElement wishlist = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[1]/div/div[2]/div[2]"));
        action.moveToElement(wishlist);
        action.click().build().perform();
    }
    @Test
    void addToCartTest() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"search_query_top\"]")).sendKeys("pioneer dj");
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id=\"searchbox\"]/button")).click();
        driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/div[2]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[3]/div/a")).click();
    }
}
