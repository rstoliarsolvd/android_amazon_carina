package com.solvd.carina.amazon.androidweb.pages;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.carina.amazon.base.ResultsPageBase;
import com.solvd.carina.amazon.services.CheckMethods;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ResultsPageBase.class)
public class ResultsPage extends ResultsPageBase {

    private static final Logger LOGGER = Logger.getLogger(ResultsPage.class);

    @FindBy(xpath = "//*[contains(@class, 's-main-slot')]//*[contains(@class, 's-title-instructions-style')]")
    private List<ExtendedWebElement> goodsResult;

    public ResultsPage(RemoteWebDriver driver) {
        super(driver);
    }

    @Override
    public List<String> goodsTitles() {
        waitForJSToLoad();
        List<String> titles = goodsResult.stream()
                .map(ExtendedWebElement::getText)
                .collect(Collectors.toList());
        return titles;
    }

    @Override
    public boolean areTitlesContainsItem(String input) {
        String[] str = input.split(" ");
        List<String> titles = goodsTitles();
        boolean areElsContainsEls = CheckMethods.areAllElementsContainAllElements(titles, str);
        LOGGER.info("Verifying all goods have in their title - " + input + " : " + areElsContainsEls);
        return areElsContainsEls;
    }
}
