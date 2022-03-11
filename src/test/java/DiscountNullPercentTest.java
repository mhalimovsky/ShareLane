import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DiscountNullPercentTest extends BaseTest{

    @Test
    public void discountShouldBeNullPerCent (){
        driver.get("https://www.sharelane.com");
        driver.findElement(By.partialLinkText("ENTER")).click();
        driver.findElement(By.partialLinkText("Sign up")).click();
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value = Continue]")).click();
        driver.findElement(By.name("first_name")).sendKeys("test");
        driver.findElement(By.name("last_name")).sendKeys("test");
        driver.findElement(By.name("email")).sendKeys("test@test.com");
        driver.findElement(By.name("password1")).sendKeys("test");
        driver.findElement(By.name("password2")).sendKeys("test");
        driver.findElement(By.cssSelector("[value = Register]")).click();
        String email = driver.findElement(By.xpath("//*[contains(text(), 'Email')]/..//b")).getText();
        String password = driver.findElement(By.xpath("//*[contains(text(), 'Password')]/..//td[2]")).getText();
        driver.get("https://sharelane.com/cgi-bin/show_book.py?book_id=2");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.cssSelector("[value = Login]")).click();
        driver.get("https://sharelane.com/cgi-bin/show_book.py?book_id=2");
        driver.findElement(By.cssSelector("[href='./add_to_cart.py?book_id=2']")).click();
        driver.findElement(By.linkText("Shopping Cart")).click();
        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("15");
        driver.findElement(By.cssSelector("[value = Update]")).click();
        String price = driver.findElement(By.xpath("//tr[2]//td[7]")).getText();
        assertEquals(price,"150","price is not correct");

    }
}
