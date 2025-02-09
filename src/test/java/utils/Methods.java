package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Methods {
    private WebDriver driver;
    private WebDriverWait wait;

    public Methods(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickElementCenter(String locator) {
        waitForElement(locator);
        WebElement element = driver.findElement(By.cssSelector(locator));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
        waitForSeconds(2);
    }

    public void clearAndEnterText(String locator, String text) {
        waitForElement(locator);
        WebElement element = driver.findElement(By.cssSelector(locator));
        element.clear();
        element.sendKeys(text);
        waitForSeconds(1);
    }

    public void waitForPageLoad() {
        wait.until(driver -> ((JavascriptExecutor) driver)
                .executeScript("return document.readyState").equals("complete"));
    }

    public void waitForElement(String locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locator)));
    }

    public void clearForKeyboardbot(String key) throws Exception {
        try {
            WebElement element = driver.findElement(By.cssSelector(LocatorReader.getLocatorValue(key)));

            Actions actions = new Actions(driver);
            actions.moveToElement(element).click()
                    .sendKeys(Keys.CONTROL + "a")
                    .sendKeys(Keys.BACK_SPACE);
        } catch (Exception e) {
            throw new Exception("Silerken hata oluştu: " + e.getMessage());
        }
    }


    public void waitForSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public boolean isElementVisible(String locator) {
        try {
            WebElement element = driver.findElement(By.cssSelector(locator));
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void clickElementByTextWithinElement(String locator, String text) {
        WebElement parentElement = driver.findElement(By.cssSelector(locator));
        WebElement targetElement = parentElement.findElement(By.xpath(".//*[text()='" + text + "']"));
        if (targetElement != null) {
            targetElement.click();
        } else {
            throw new RuntimeException("Text not found within the specified element: " + text);
        }
    }





}
