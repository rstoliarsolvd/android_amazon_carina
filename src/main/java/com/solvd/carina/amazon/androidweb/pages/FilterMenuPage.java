package com.solvd.carina.amazon.androidweb.pages;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.carina.amazon.base.FilterMenuPageBase;
import com.solvd.carina.amazon.base.FilterResultPageBase;
import com.solvd.carina.amazon.base.HomePageBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = FilterMenuPageBase.class)
public class FilterMenuPage extends FilterMenuPageBase {

    private static final Logger LOGGER = Logger.getLogger(FilterMenuPage.class);

    @FindBy(xpath = "//div[text()='Smart Home']")
    private ExtendedWebElement smartHomeBtn;

    @FindBy(xpath = "//a[@class ='hmenu-item'][text()='Pet']")
    private ExtendedWebElement petBtn;

    @FindBy(xpath = "//div[@class ='nav-sprite hmenu-close-icon']")
    private ExtendedWebElement closeFilterMenuBtn;

    //    @FindBy(xpath = "//*[@id='hmenu-content']")
    @FindBy(xpath = "//ul[@class='hmenu hmenu-visible']")
    private ExtendedWebElement filterBlock;

    @FindBy(xpath = "//*[@id='hmenu-content']//following::div[contains(text(),'smart home')]")
    private ExtendedWebElement smartHomeTitle;

    @FindBy(xpath = "//*[text()='Smart Pet | Smart Home']")
    private ExtendedWebElement titleSmartPet;

    public FilterMenuPage(RemoteWebDriver driver) {
        super(driver);
    }

    @Override
    public FilterMenuPageBase clickSmartHomeBtn() {
        assertElementPresent(smartHomeBtn);
        smartHomeBtn.click();
        waitForJSToLoad();
        return initPage(driver, FilterMenuPageBase.class);
    }

    @Override
    public FilterResultPageBase clickPetBtn() {
        assertElementPresent(petBtn);
        petBtn.click();
        waitForJSToLoad();
        return initPage(driver, FilterResultPage.class);
    }

    @Override
    public boolean isFMPageOpen() {
        waitForJSToLoad();
        return closeFilterMenuBtn.isElementPresent() || filterBlock.isElementPresent();
    }

    @Override
    public boolean isSmartTitlePresent() {
        waitForJSToLoad();
        boolean isSmartHomeTitleDisplayed = smartHomeTitle.isElementPresent();
        LOGGER.info("Verifying 'Smart Home' Presence on title of page : " + isSmartHomeTitleDisplayed);
        return isSmartHomeTitleDisplayed;
    }

    @Override
    public HomePageBase clickCloseBtn() {
        waitForJSToLoad();
        closeFilterMenuBtn.click();
        boolean isCloseFilterMenuBtnDisplayed = closeFilterMenuBtn.isElementPresent();
        waitForJSToLoad();
        LOGGER.info("closeFilterMenuBtn disappeared after clicking on it - " + !isCloseFilterMenuBtnDisplayed);
        return initPage(driver, HomePage.class);
    }

    @Override
    public ExtendedWebElement getCloseFilterMenuBtn() {
        return closeFilterMenuBtn;
    }
}
