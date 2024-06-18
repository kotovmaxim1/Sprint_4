import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.qascooter.praktikumservices.pageobject.ScooterOrder;
import static org.hamcrest.CoreMatchers.containsString;
import static ru.qascooter.praktikumservices.pageobject.UrlPage.URL_QA_SCOOTER;

@RunWith(Parameterized.class)
public class ScooterOrderTest {

    WebDriver driver;
    String name;
    String secondName;
    String address;
    String phoneNumber;
    String date;
    String comment;

    public ScooterOrderTest(String name, String secondName, String address, String phoneNumber, String date, String comment){
        this.name = name;
        this.secondName = secondName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.date = date;
        this.comment = comment;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(URL_QA_SCOOTER);
    }

    @Parameterized.Parameters
    public static Object[][] testData(){
        return  new Object[][]{
                {"Алексей", "Петров", "Улица Пушкина", "+79992847777", "06.07.2024", "Люблю самокаты"},
                {"Иван", "Иванов", "Дом Колотушкина", "89992847777", "06.07.2024", "В домофон не звонить"}
        };
    }

    @Test
    public void scooterOrderTestWithTopButton(){
        ScooterOrder scooterOrder = new ScooterOrder(driver);
        scooterOrder.clickCloseCookieButton();
        scooterOrder.clickMakeOrderTopButton();
        scooterOrder.makeOrderScooter(name, secondName, address, phoneNumber, date, comment);
        String expected = "Заказ оформлен";
        Assert.assertThat("Текст успешного заказа не найден, вероятно у вас chrome", scooterOrder.findTextOrderSuccess(), containsString(expected));
    }

    @Test
    public void scooterOrderTestWithMiddleButton(){
        ScooterOrder scooterOrder = new ScooterOrder(driver);
        scooterOrder.clickCloseCookieButton();
        scooterOrder.clickMakeOrderMiddleButton();
        scooterOrder.makeOrderScooter(name, secondName, address, phoneNumber, date, comment);
        String expected = "Заказ оформлен";
        Assert.assertThat("Текст успешного заказа не найден, вероятно у вас chrome", scooterOrder.findTextOrderSuccess(), containsString(expected));
    }

    @After
    public void cleanUp(){
        driver.quit();
    }
}