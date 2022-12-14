package com.solvd.carina.amazon.services;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.solvd.carina.amazon.androidweb.pages.HomePage;
import com.solvd.carina.amazon.androidweb.pages.UpTab;
import com.solvd.carina.amazon.base.HomePageBase;
import com.solvd.carina.amazon.base.UpTabBase;
import org.openqa.selenium.remote.RemoteWebDriver;

public class NavigationService implements IAbstractTest, IMobileUtils {

    /**
     * Back to HomePage
     *
     * @param driver
     * @return
     */
    public static HomePageBase goHome(RemoteWebDriver driver) {
        UpTabBase upTab = new UpTab(driver);
//        UpTabBase upTab = initPage(UpTabBase.class);
        upTab.clickHomeBtn();
        return  new HomePage(driver);
    }
}
