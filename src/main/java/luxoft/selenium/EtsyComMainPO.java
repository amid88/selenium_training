package luxoft.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EtsyComMainPO extends BasePO {

    final By SEARCH_FIELD = By.name("search_query");
    final By SEARCH_SUGGESTION_ELEMENT_FIRST =
            By.cssSelector("#global-enhancements-search-suggestions ul div.as-first");

    PrivacyModalPO policyModal;

    public EtsyComMainPO(WebDriver driver) {
        super(driver);
        policyModal = new PrivacyModalPO(driver);
    }

    public EtsyComMainPO acceptPrivacyPolicy() {
        policyModal.acceptPolicy();
        return this;
    }

    public EtsyComMainPO goTo(){
        driver.get("http://www.etsy.com");
        return this;
    }

    public EtsyComMainPO searchFor(String query){
        enterSearchQuery(query);
        return this;
    }

    private void enterSearchQuery(String query){
        WebElement searchField = findElementWithWait(SEARCH_FIELD);
        searchField.clear();
        searchField.sendKeys(query);
    }

    public EtsyComMainPO pickFirstItemInSuggestionsList(){
        getFirstItemInSuggestionsList().click();
        return this;
    }

    private WebElement getFirstItemInSuggestionsList() {
        return findElementWithWait(SEARCH_SUGGESTION_ELEMENT_FIRST);
    }

}
