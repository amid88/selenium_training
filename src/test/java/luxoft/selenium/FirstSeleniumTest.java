package luxoft.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import org.testng.annotations.Test;



public class FirstSeleniumTest extends ParentTestSelenium {
    private void acceptPrivacyPolicy(){
        final By PRIVACY_MODAL_WINDOW_WRAPPER = By.className("alert");
        final By PRIVACY_ACCEPT_BUTTON = By.xpath("/html/body/div[2]/div[1]/div[2]/div[3]/div[2]/button");
        driver
                .findElement(PRIVACY_MODAL_WINDOW_WRAPPER)
                .findElement(PRIVACY_ACCEPT_BUTTON)
                .click();
    }
//    @Test
//    public void searchResultPageTitleConainsSearchQuery() throws InterruptedException {
//        String searchQuery = "dupa";
//        final By SEARCH_FIELD = By.name("search_query");
//        final By SEARCH_SUGGESTION_ELEMENT_FIRST =
//                By.cssSelector("#global-enhancements-search-suggestions ul div.as-first");
//        final By SEARCH_RESULT = By.cssSelector("div.search-listings-group h1.strong");
//        driver.get("http://www.etsy.com");
//        acceptPrivacyPolicy();
//        WebElement search_field = driver.findElement(SEARCH_FIELD);
//        search_field.clear();
//        search_field.sendKeys(searchQuery);
//        WebDriverWait waitForSuggestionItem = new WebDriverWait(driver, 5);
//        waitForSuggestionItem.until(ExpectedConditions.visibilityOfElementLocated(SEARCH_SUGGESTION_ELEMENT_FIRST)).click();
//        Assert.assertTrue(driver.findElement(SEARCH_RESULT).getText().contains(searchQuery));
//    }

    @Test
    public void searchResultTableHeaderConainsSearchQueryPOTest(){
        String searchQuerry = "leather bag";
        EtsyComMainPO etsyCom = new EtsyComMainPO(driver);
        SearchResultsPO etsyResults = new SearchResultsPO(driver);
        etsyCom.goTo()
                .acceptPrivacyPolicy()
                .searchFor(searchQuerry)
                .pickFirstItemInSuggestionsList();
        String searchResultsHeader = etsyResults.getResultsHeader();
        Assert.assertTrue(searchResultsHeader.contains(searchQuerry));
    }
}
