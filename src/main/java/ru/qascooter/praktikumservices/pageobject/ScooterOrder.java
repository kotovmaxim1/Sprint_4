package ru.qascooter.praktikumservices.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScooterOrder extends BasePage {

    public ScooterOrder(WebDriver driver){
        super(driver);
    }

    //Локатор кнопки Заказать вверху страницы
    private final By makeOrderTopButton = By.xpath(".//div[2]/button[1]");

    //Локатор кнопки Заказать в середине страницы
    private final By makeOrderMiddleButton = By.xpath("//div[5]/button");

    //Локатор кнопки закрытия сообщени кук
    private final By closeCookieButton = By.xpath(".//button[text()='да все привыкли']");

    //Локатор поля Имя
    private final By nameField = By.xpath(".//input[@placeholder='* Имя']");

    //Локатор поля Фамилия
    private final By secondNameField = By.xpath(".//input[@placeholder='* Фамилия']");

    //Локатор поля Адреса
    private final By addressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");

    //Локатор поля станции Метро
    private final By stationField = By.xpath(".//input[@placeholder='* Станция метро']");

    //Локатор выбора станции
    private final By stationSelect = By.xpath(".//div[text()='Сокольники']");

    //Локатор поля номера телефона
    private final By phoneNumberField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");

    //Локатор кнопки Далее
    private final By nextButton = By.xpath(".//div[2]/div[3]/button");

    //Локатор поля даты привоза самоката
    private final By dataField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");

    //Локатор выбора выпадающего меню колличества арендуемых дней
    private final By dropdownMenu = By.xpath(".//div[2]/div[2]/div[2]/div/div[2]/span");

    //Локатор выбора срока аренды одни сутки
    private final By oneDayOrder = By.xpath(".//div[text()='сутки']");

    //Локатор выбора черного цвета
    private final By blackColorField = By.xpath("//input[@id='black']");

    //Локатор поля комментария для курьера
    private final By commentField = By.xpath(".//input[@placeholder='Комментарий для курьера']");

    //Локатор кнопки Заказать
    private final By orderButton = By.xpath(".//div[2]/div[3]/button[2]");

    //Локатор кнопки подтверждения заказа
    private final By confirmOrderButton = By.xpath(".//div[5]/div[2]/button[2]");

    //Локатор текста успешного заказа
    private final By textOrderSuccess = By.xpath(".//div/div[2]/div[5]/div[1]");



    //Метод закрытия кук
    public void clickCloseCookieButton(){
        driver.findElement(closeCookieButton).click();
    }

    //Метод заказа самоката
    public void makeOrderScooter(String name, String secondName, String address, String phoneNumber, String date, String comment){
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(secondNameField).sendKeys(secondName);
        driver.findElement(addressField).sendKeys(address);
        driver.findElement(stationField).click();
        driver.findElement(stationSelect).click();
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
        driver.findElement(nextButton).click();
        driver.findElement(dataField).sendKeys(date);
        driver.findElement(dropdownMenu).click();
        driver.findElement(oneDayOrder).click();
        driver.findElement(blackColorField).click();
        driver.findElement(commentField).sendKeys(comment);
        driver.findElement(orderButton).click();
        driver.findElement(confirmOrderButton).click();
    }


    //Метод клика по верхней кнопке Заказать
    public void clickMakeOrderTopButton(){
        driver.findElement(makeOrderTopButton).click();
    }

    //Метод клика по кнопке в середине страницы
    public void clickMakeOrderMiddleButton(){
        WebElement element = driver.findElement(By.xpath("//div[5]/button"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(makeOrderMiddleButton).click();
    }


    //Метод поиска текста подтверждения заказа
    public String findTextOrderSuccess(){
        return driver.findElement(textOrderSuccess).getText();
    }

}
