import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;


public class AutoMat1Test extends AutoMat1 {

    @Test
    public void testMain() throws Exception {
        ChromeDriverManager.getInstance().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.reserved.com/pl/pl/");
        driver.findElement(By.className("close")).click();
        WebElement him = driver.findElement(By.xpath("//*[@id='page']/header/nav/ul/li[2]/a"));
        him.click();
        WebElement polo = driver.findElement(By.xpath("//*[@id=\"page\"]/header/nav/ul/li[2]/div/div[2]/ul/li[1]/ul/li[3]/a"));
        polo.click();
        WebElement color = driver.findElement(By.xpath("//*[@id='colorFiltersHeader']"));
        color.click();
        WebElement colorBlack = driver.findElement(By.xpath("//*[@id=\"colorFiltersContent\"]/ul/li[2]/div/label/span"));
        colorBlack.click();
        WebElement size = driver.findElement(By.xpath("//*[@id='sizeFiltersHeader']"));
        size.click();
        WebElement sizeXXL = driver.findElement(By.xpath("//*[@id='sizeFiltersContent']/ul/li[6]/div/label"));
        sizeXXL.click();
        WebElement characteristic = driver.findElement(By.xpath("//*[@id='characteristicFiltersHeader']"));
        characteristic.click();
        WebElement chararcteristicBasic = driver.findElement(By.xpath("//*[@id=\"characteristicFiltersContent\"]/ul/li[5]/div/label"));
        chararcteristicBasic.click();
        WebElement price = driver.findElement(By.xpath("//*[@id='priceFilters']/h3"));
        price.click();
        WebElement pF = driver.findElement(By.id("priceFrom"));
        pF.sendKeys("39");
        WebElement pT = driver.findElement(By.id("priceTo"));
        pT.sendKeys("41");
        WebElement finalPolo = driver.findElement(By.xpath("//*[@id=\"category-bricks\"]/li[17]/div/div/h2/a"));
        finalPolo.click();
        driver.findElement(By.className("close")).click();
        Assert.assertEquals("Gładkie polo BASIC RJ356-99X", "Gładkie polo BASIC RJ356-99X");
        WebElement addBasket = driver.findElement(By.id("addToCartButton"));
        addBasket.click();
        WebElement popUpClose = driver.findElement(By.id("cboxClose"));
        popUpClose.click();
        driver.findElement(By.xpath("//*[@id='productSizeList']/li[4]/button")).click();
        addBasket.click();
        WebElement bagActive = driver.findElement(By.xpath("//*[@id=\"basket-btn\"]/span"));
        WebDriverWait driverWait = new WebDriverWait(driver, 5);
        driverWait.until(ExpectedConditions.visibilityOf(bagActive));
        Assert.assertEquals("Produkt Gładkie polo BASIC został dodany do koszyka", "Produkt Gładkie polo BASIC został dodany do koszyka");
        bagActive.click();
        WebElement checkboxField = driver.findElement(By.className("checkbox-label"));
        checkboxField.click();
        WebElement removeSelected = driver.findElement(By.id("cartRemoveSelected"));
        removeSelected.click();
        Assert.assertEquals("NIE POSIADASZ PRODUKTÓW W KOSZYKU.", "NIE POSIADASZ PRODUKTÓW W KOSZYKU.");
        driver.quit();
    }

}