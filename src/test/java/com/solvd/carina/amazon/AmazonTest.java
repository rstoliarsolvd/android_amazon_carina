package com.solvd.carina.amazon;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.solvd.carina.amazon.base.*;
import com.solvd.carina.amazon.services.NavigationService;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AmazonTest extends AbstractTest implements IAbstractTest, IMobileUtils {
    private static final Logger LOGGER = Logger.getLogger(AmazonTest.class);


    //    @Test(threadPoolSize = 3, invocationCount = 3, timeOut = 10000)
    @Test
    public void verifySignInFormAppearedTest() {
        LOGGER.info("verifySignInFormAppearedTest Thread.currentThread().getId() = " + Thread.currentThread().getId());
        LOGGER.info("This test is running on browser - " + driverT.get().getCapabilities().getBrowserName());

        RemoteWebDriver driver = driverT.get();
        refreshPageIfWrongDesign(driver);

        UpTabBase upTab = initPage(driver, UpTabBase.class);
        SignInFormPageBase signInFormPage = upTab.clickSignInBtn();
        Assert.assertTrue(signInFormPage.isHeaderSignIn(), "Header on opened page is not 'Sign in'");
        signInFormPage.clickHomeBtn();
    }

    @DataProvider(name = "searchItem")
    public Object[][] searchItem() {
        return new Object[][]{{"iphone 11 case"}};
    }

    @Test(dataProvider = "searchItem")
    public void verifySearchFieldAndHomeBtn(String searchItem) {
        LOGGER.info("verifySearchFieldAndHomeBtn Thread.currentThread().getId() = " + Thread.currentThread().getId());
        LOGGER.info("This test is running on browser - " + driverT.get().getCapabilities().getBrowserName());

        RemoteWebDriver driver = driverT.get();
        refreshPageIfWrongDesign(driver);

        UpTabBase upTab = initPage(driver, UpTabBase.class);
        ResultsPageBase resultsPage = upTab.findItem(searchItem);
        Assert.assertTrue(resultsPage.areTitlesContainsItem(searchItem), "Not all goods titles contains searched items");
        HomePageBase homePage = NavigationService.goHome(driver, resultsPage);
        Assert.assertTrue(homePage.isHomePageOpen(), "Home page is not opened");
    }

    //    @Test(retryAnalyzer = RetryTestRunAttempts.class)
    @Test
    public void verifyTodayDealsOption() {
        LOGGER.info("verifyTodayDealsOption Thread.currentThread().getId() = " + Thread.currentThread().getId());
        LOGGER.info("This test is running on browser - " + driverT.get().getCapabilities().getBrowserName());

        RemoteWebDriver driver = driverT.get();
        refreshPageIfWrongDesign(driver);

        LocationAlertBase lAlert = initPage(driver, LocationAlertBase.class);
        lAlert.verifyAlert();
        MenuTabBase menuTab = initPage(driver, MenuTabBase.class);
        TodaysDealPageBase todaysDealPage = menuTab.clickTodaysDealsBtn();
        Assert.assertTrue(todaysDealPage.ifTDPageIsOpen(), "No Today's Deals page is open");
        Assert.assertTrue(todaysDealPage.areGoodsHaveDiscount(), "Not All goods have discounts");
        NavigationService.goHome(driver, todaysDealPage);

    }

    @Test
    public void verifyFilterTest() {
        LOGGER.info("verifyFilterTest Thread.currentThread().getId() = " + Thread.currentThread().getId());
        LOGGER.info("This test is running on browser - " + driverT.get().getCapabilities().getBrowserName());

        String pet = "pet";
        RemoteWebDriver driver = driverT.get();
        refreshPageIfWrongDesign(driver);

        MenuTabBase menuTab = initPage(driver, MenuTabBase.class);
        FilterMenuPageBase filterMenuPage = menuTab.clickFilterMenuBtn();

        filterMenuPage = filterMenuPage.clickSmartHomeBtn();
        Assert.assertTrue(filterMenuPage.isFMPageOpen(), "Filter menu page is not open");
        Assert.assertTrue(filterMenuPage.isSmartTitlePresent(), "Filter menu page is not open");

        FilterResultPageBase filterResultPage = filterMenuPage.clickPetBtn();
        Assert.assertTrue(filterResultPage.isTitleOnFilterResultPageWithPet(), " No 'Pet' title is displayed");
        Assert.assertTrue(filterResultPage.areAllGoodsTitleContainsSearchItem(pet), "No 'Pet' in title on filter result page present");
        NavigationService.goHome(driver, filterResultPage);
    }

    @Test
    public void verifyFilterMenuCloseBtn() {
        LOGGER.info("verifyFilterMenuCloseBtn Thread.currentThread().getId() = " + Thread.currentThread().getId());
        LOGGER.info("This test is running on browser - " + driverT.get().getCapabilities().getBrowserName());

        RemoteWebDriver driver = driverT.get();
        refreshPageIfWrongDesign(driver);

        MenuTabBase menuTab = initPage(driver, MenuTabBase.class);

//        MenuTab menuTab = new MenuTab(driver);
        FilterMenuPageBase filterMenuPage = menuTab.clickFilterMenuBtn();
        Assert.assertTrue(filterMenuPage.isFMPageOpen(), "Filter menu page is not open");
        HomePageBase homePage = filterMenuPage.clickCloseBtn();
        Assert.assertTrue(homePage.isHomePageOpen(), "Home page is not open");
    }

}
