package luxoft.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PrivacyModalPO extends BasePO {

    final By PRIVACY_MODAL_WINDOW_WRAPPER = By.className("alert");
    final By PRIVACY_ACCEPT_BUTTON = By.xpath("/html/body/div[2]/div[1]/div[2]/div[3]/div[2]/button");

    public PrivacyModalPO(WebDriver driver) {
        super(driver);
    }
    public void acceptPolicy(){
        getAcceptButton().click();
    }

    private WebElement getAcceptButton(){
        return findElementWithWait(PRIVACY_MODAL_WINDOW_WRAPPER)
                .findElement(PRIVACY_ACCEPT_BUTTON);
    }
}
