import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.qascooter.praktikumservices.pageobject.Questions;
import static ru.qascooter.praktikumservices.pageobject.UrlPage.URL_QA_SCOOTER;

@RunWith(Parameterized.class)

public class QuestionsTest {

    WebDriver driver;

    int itemIndex;
    private String expectedAnswer;

    //конутруктор параметризированного теста
    public QuestionsTest(int itemIndex, String expectedAnswer) {
        this.itemIndex = itemIndex;
        this.expectedAnswer = expectedAnswer;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(URL_QA_SCOOTER);
    }

    //провайдер данных для параметризированного теста
    @Parameterized.Parameters
    public static Object[][] testQuestionData(){
        return new Object[][]{
                {0, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {1, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {2, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {3, "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {4, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {5, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {6, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {7, "Да, обязательно. Всем самокатов! И Москве, и Московской области."}
        };
    }

    @Test
    public void questionTextTest() {
        Questions questions = new Questions(driver);
        questions.scrollToQuestion();
        String actualText = questions.getAnswer(itemIndex);
        Assert.assertEquals(expectedAnswer, actualText);
}

    @After
    public void tearDown(){
        driver.quit();
    }
}