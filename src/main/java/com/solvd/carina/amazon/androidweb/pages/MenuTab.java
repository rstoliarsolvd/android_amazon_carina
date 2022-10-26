package com.solvd.carina.amazon.androidweb.pages;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.carina.amazon.base.MenuTabBase;
import com.solvd.carina.amazon.base.TodaysDealPageBase;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = MenuTabBase.class)
public class MenuTab extends MenuTabBase {

    @FindBy(xpath = "//*[@id='nav-xshop']//a[1]")
    private ExtendedWebElement todaysDealsBtn;

    @FindBy(xpath = "//*[@class='hm-icon nav-sprite']")
    private ExtendedWebElement filterMenuBtn;

    public MenuTab(RemoteWebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public FilterMenuPage clickFilterMenuBtn() {
        filterMenuBtn.clickIfPresent();
        return new FilterMenuPage((RemoteWebDriver) driver);
    }

    @Override
    public TodaysDealPageBase clickTodaysDealsBtn() {
       todaysDealsBtn.clickIfPresent();
        return initPage(driver, TodaysDealPageBase.class);
    }
}
