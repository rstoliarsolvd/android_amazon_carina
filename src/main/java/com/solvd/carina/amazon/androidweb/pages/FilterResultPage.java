package com.solvd.carina.amazon.androidweb.pages;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.carina.amazon.base.FilterResultPageBase;
import com.solvd.carina.amazon.services.CheckMethods;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = FilterResultPageBase.class)
public class FilterResultPage extends FilterResultPageBase {

    public static final Logger LOGGER = Logger.getLogger(FilterResultPage.class);

    @FindBy(xpath = "//*[text()='Smart Pet | Smart Home']")
    private ExtendedWebElement titleSmartPet;

    @FindBy(xpath = "//span[@class='a-truncate-cut']")
    private List<ExtendedWebElement> goodsOfFilter;

    public FilterResultPage(RemoteWebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isTitleOnFilterResultPageWithPet() {
        boolean isTitleSmartPetDisplayed = titleSmartPet.isPresent();
        LOGGER.info("Verifying if title with 'Smart Home' and 'Pet' Present. : " + isTitleSmartPetDisplayed);
        return isTitleSmartPetDisplayed;
    }

    @Override
    public List<String> getGoodsTitlesList() {
        return goodsOfFilter.stream()
                .map(ExtendedWebElement::getText)
                .collect(Collectors.toList());
    }

    @Override
    public boolean areAllGoodsTitleContainsSearchItem(String pet) {
        List<String> goodsText = getGoodsTitlesList();
        boolean isStringPetPresentInGoodsList = CheckMethods.isStringPresentInList(goodsText, pet);
        LOGGER.info("Verifying if " + pet + " Present in all goods : " + isStringPetPresentInGoodsList);
        return isStringPetPresentInGoodsList;
    }
}
