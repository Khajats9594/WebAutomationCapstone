package pages;

import enums.WaitStrategy;
import org.openqa.selenium.By;

public class SearchPage extends BasePage{

    public static SearchPage getInstance(){
        return new SearchPage();
    }


    public String getSearchResultText(){
        return getTitle();
    }
}
