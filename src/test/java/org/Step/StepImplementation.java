package org.Step;

import com.thoughtworks.gauge.Step;
import driver.DriverFactory;

import org.openqa.selenium.*;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.LocatorReader;
import utils.Methods;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class StepImplementation {
    private WebDriver driver = DriverFactory.getDriver();
    private Methods methods;
    private static final Logger logger = LoggerFactory.getLogger(StepImplementation.class);

    public StepImplementation() {
        methods = new Methods(driver);
    }

    @Step("<url> adresine gider")
    public void navigateTo(String url) {
        logger.info("{} adresine gidiliyor...", url);
        driver.get(url);
        methods.waitForPageLoad();
    }

    @Step("<key> li elementin merkezine tıkla")
    public void findAndClick(String key) {
        String locator = LocatorReader.getLocatorValue(key);
        if (locator == null || locator.isEmpty()) {
            logger.error("Locator bulunamadı: {}", key);
            throw new RuntimeException("Locator not found for key: " + key);
        }
        logger.info("Elemente tiklaniyor: {}", key);
        methods.clickElementCenter(locator);
    }

    @Step("<key> li elementi bul, temizle ve <text> değerini yaz")
    public void findAndEnterText(String key, String text) {
        String locator = LocatorReader.getLocatorValue(key);
        if (locator == null || locator.isEmpty()) {
            logger.error("Locator bulunamadi: {}", key);
            throw new RuntimeException("Locator not found for key: " + key);
        }
        logger.info("Elemente metin yaziliyor: {} -> {}", key, text);
        methods.clearAndEnterText(locator, text);
    }

    @Step("<locatorName> li elementi bul ve klavye ile temizle")
    public void clearforKeyboardElement(String locatorName) throws Exception {
        methods.clearForKeyboardbot(locatorName);  // Methods sınıfındaki metodu çağırıyoruz
    }


    @Step("<key> li elementi bul ve <text> değerini yaz")
    public void enterText(String key, String text) {
        String locator = LocatorReader.getLocatorValue(key);
        if (locator == null || locator.isEmpty()) {
            logger.error("Locator bulunamadi: {}", key);
            throw new RuntimeException("Locator not found for key: " + key);
        }
        logger.info("Elemente metin yaziliyor: {} -> {}", key, text);
        WebElement element = driver.findElement(By.cssSelector(locator));
        methods.clearAndEnterText(locator, text);
    }


    @Step("<seconds> saniye bekle")
    public void waitForSeconds(int seconds) {
        logger.info("{} saniye bekleniyor...", seconds);
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            logger.error("Bekleme sirasinda hata olustu: ", e);
        }
    }

    @Step("Sayfa kaynağında <key> kelimesinin bulunduğu doğrulanır")
    public void verifyPageContainsKey(String key) {
        logger.info("Sayfa kaynaginda '{}' kelimesi araniyor...", key);
        boolean containsKey = driver.getPageSource().contains(key);
        assertTrue("The page does not contain '" + key + "'", containsKey);
    }

    @Step("Sayfa başlığında <key> kelimesinin bulunduğu doğrulanır")
    public void verifyPageTitleContainsKey(String key) {
        logger.info("Sayfa basliginda '{}' kelimesi araniyor...", key);
        String pageTitle = driver.getTitle();
        assertTrue("The page title does not contain '" + key + "'", pageTitle.contains(key));
    }

    @Step("<text> yazısını bul ve tıkla")
    public void findAndClickText(String text) {
        logger.info("Sayfada '{}' yazisi bulunuyor ve tiklaniyor...", text);

        WebElement element = driver.findElement(By.xpath("//*[text()='" + text + "']"));
        if (element != null) {
            element.click();  // Belirtilen text'e sahip öğeye tıklıyoruz
        } else {
            logger.error("Sayfada '{}' yazisı bulunamadi.", text);
            throw new RuntimeException("Text not found: " + text);
        }
    }

    @Step("<key> alanında <text> bul ve tıkla")
    public void findAndClickTextWithinElement(String key, String text) {
        String locator = LocatorReader.getLocatorValue(key);
        if (locator == null || locator.isEmpty()) {
            logger.error("Locator bulunamadı: {}", key);
            throw new RuntimeException("Locator not found for key: " + key);
        }
        logger.info("{} alanında '{}' metni aranıyor ve tıklanıyor...", key, text);
        methods.clickElementByTextWithinElement(locator, text);
    }

    @Step("Sayfada <key> tiklanabilir button kontrolü")
    public void checkIfElementExists(String key) {
        String locator = LocatorReader.getLocatorValue(key);
        if (locator == null || locator.isEmpty()) {
            logger.error("Locator bulunamadi: {}", key);
            return;
        }

        try {
            WebElement element = driver.findElement(By.cssSelector(locator));
            if (element.isDisplayed()) {
                logger.info("{} sayfada tiklanilabilir button mevcut.", key);
            } else {
                logger.warn("{} sayfada tiklanilabilir button mevcut değil.", key);

            }
        } catch (NoSuchElementException e) {
            logger.info("{} sayfada tiklanilabilir button bulunamadi.", key);

        }
    }

    @Step("Sayfa kaynağında <text> kelimesi bulunursa hatalı test mesajı ver")
    public void verifyTextInPageSource(String text) {
        logger.info("Sayfa kaynaginda '{}' kelimesi araniyor...", text);
        if (driver.getPageSource().contains(text)) {
            logger.error("Sayfada '{}' kelimesi bulundu! Test hatali.", text);
            throw new RuntimeException("Sayfada '" + text + "' kelimesi bulundu. Test hatali.");
        } else {
            logger.info("Sayfada '{}' kelimesi bulunmadi.", text);
        }
    }

    @Step("Sayfa elemanı <locatorName> beklenen <expectedText> metnini içeriyor mu kontrol et")
    public void checkElementContainsText(String locatorName, String expectedText) {
        // Locator'ı alıyoruz
        String locator = LocatorReader.getLocatorValue(locatorName);
        if (locator == null || locator.isEmpty()) {
            logger.error("Locator bulunamadı: {}", locatorName);
            throw new RuntimeException("Locator not found for key: " + locatorName);
        }

        try {
            WebElement element = driver.findElement(By.cssSelector(locator));
            String elementText = element.getText().trim();

            if (!elementText.contains(expectedText)) {
                logger.error("{} elemani beklenen '{}' metnini içermiyor. Test hatali.", locatorName, expectedText);
                throw new RuntimeException(locatorName + " elemani beklenen '" + expectedText + "' metnini icermiyor.");
            } else {
                logger.info("{} elemani beklenen '{}' metnini iceriyor.", locatorName, expectedText);
            }
        } catch (NoSuchElementException e) {
            logger.error("{} elemani sayfada bulunamadı.", locatorName);
            throw new RuntimeException(locatorName + " elemani sayfada bulunamadi.");
        }
    }

    @Step("Sayfa elemanının <locatorName> görünür olduğunu kontrol et")
    public void visibilityElement(String locatorName) {

        String locator = LocatorReader.getLocatorValue(locatorName);
        if (locator == null || locator.isEmpty()) {
            logger.error("Locator bulunamadı: {}", locatorName);
            throw new RuntimeException("Locator not found for key: " + locatorName);
        }

        try {

            WebElement element = driver.findElement(By.cssSelector(locator));


            if (element.isDisplayed()) {
                logger.info("{} elemanı görünür durumda.", locatorName);
            } else {
                logger.error("{} elemanı görünür değil! Test hatalı.", locatorName);
                throw new RuntimeException(locatorName + " elemanı görünür değil.");
            }
        } catch (NoSuchElementException e) {
            logger.error("{} elemanı sayfada bulunamadı.", locatorName);
            throw new RuntimeException(locatorName + " elemanı sayfada bulunamadı.");
        }
    }

    @Step("<locatorName> disable olduğuna dair kontrol")
    public void verifyElementIsDisabled(String locatorName) {

        String locator = LocatorReader.getLocatorValue(locatorName);
        if (locator == null || locator.isEmpty()) {
            logger.error("Locator bulunamadi: {}", locatorName);
            throw new RuntimeException("Locator not found for key: " + locatorName);
        }

        try {

            WebElement element = driver.findElement(By.cssSelector(locator));


            boolean isDisabled = element.getAttribute("disabled") != null;
            if (isDisabled) {
                logger.info("{} butonu disable durumunda.", locatorName);
            } else {
                logger.error("{} butonu disable degil! Test hatali.", locatorName);
                throw new RuntimeException(locatorName + " butonu disable değil.");
            }
        } catch (NoSuchElementException e) {
            logger.error("{} butonu sayfada bulunamadi.", locatorName);
            throw new RuntimeException(locatorName + " butonu sayfada bulunamadi.");
        }
    }




    @Step("Hata mesajı kontrol edilir")
    public void checkIfAlertErrorMessageExistsAndContinue() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());

            String alertText = alert.getText();
            logger.warn("Sayfada hata mesaji goruntulendi: " + alertText);

            if (alertText.contains("Something went wrong. Please try again!")) {
                logger.warn("Hata mesaji algilandi! Ancak test devam ediyor...");
            }

            alert.accept();
        } catch (TimeoutException e) {
            logger.info("Hata mesajı goruntulenmedi, test devam ediyor.");
        }
    }













}