package ru.qascooter.praktikumservices.pageobject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Questions extends BasePage {

    public Questions(WebDriver driver){
        super(driver);
    }
    //Строка для получения вопроса
    private String questionLink = ".//div[@id='accordion__heading-%d']";

    //Строка для получения ответа
    private String answerLink = ".//div[@id='accordion__panel-%d']";

    //метод скрола до вопросов
    public void scrollToQuestion(){
        WebElement element = driver.findElement(By.id("accordion__heading-0"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    };

    //метод клика и получения ответа
    public String getAnswer(int itemIndex){
        driver.findElement(By.xpath(String.format(questionLink, itemIndex))).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement anotherElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(questionLink, itemIndex))));
        return driver.findElement(By.xpath(String.format(answerLink, itemIndex))).getText();
    }




}
