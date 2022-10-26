package com.solvd.carina.amazon.base;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.List;

public abstract class ResultsPageBase extends AbstractPage {

    public ResultsPageBase(RemoteWebDriver driver) {
        super(driver);
    }

    public abstract List<String> goodsTitles();

    public abstract boolean areTitlesContainsItem(String input);
}
