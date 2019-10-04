package luxoft.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultsPO extends BasePO {
    final By SEARCH_TABLE_RESULT_HEADER = By.cssSelector("div.search-listings-group h1.strong");
    public SearchResultsPO(WebDriver driver) {
        super(driver);
    }

    public String getResultsHeader(){
        return findElementWithWait(SEARCH_TABLE_RESULT_HEADER).getText().toLowerCase();
    }
}
