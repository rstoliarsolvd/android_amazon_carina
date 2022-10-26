package com.solvd.carina.amazon.services;

import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.carina.amazon.androidweb.pages.HomePage;
import com.solvd.carina.amazon.base.HomePageBase;
import com.solvd.carina.amazon.base.UpTabBase;
import org.openqa.selenium.remote.RemoteWebDriver;

public class NavigationService implements IMobileUtils {

    HomePage homePage = new HomePage(null);

    /**
     * Back to HomePage
     *
     * @param driver
     * @return
     */
    public static HomePageBase goHome(RemoteWebDriver driver, AbstractPage aPage) {
        UpTabBase upTab = aPage.initPage(driver, UpTabBase.class);
        upTab.clickHomeBtn();
        return aPage.initPage(driver, HomePageBase.class);
    }
}
