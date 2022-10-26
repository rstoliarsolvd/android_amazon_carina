package com.solvd.carina.amazon.base;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.remote.RemoteWebDriver;

public abstract class MenuTabBase extends AbstractPage {

    public MenuTabBase(RemoteWebDriver driver) {
        super(driver);
    }

    public abstract FilterMenuPageBase clickFilterMenuBtn();

    public abstract TodaysDealPageBase clickTodaysDealsBtn();
}
