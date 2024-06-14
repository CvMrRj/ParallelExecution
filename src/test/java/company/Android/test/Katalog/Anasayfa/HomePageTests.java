package company.Android.test.Katalog.Anasayfa;

import org.Utilities.StepInit;
import org.junit.jupiter.api.BeforeEach;
import org.testng.annotations.Test;

public class HomePageTests extends StepInit {
    @BeforeEach
    public void beforeClass() {
        homePageSteps.checkHomePageOpen();
    }

    @Test(description = "Test Case 1")
    public void case76611AnaSayfaSearchPlaceHolderKontrolu() {
        homePageSteps.checkSearchPlaceHolderText();
    }

    @Test(description = "Test Case 2")
    public void case76612AnaSayfaSearchAlaniClickSonrasiPlaceHolderKontrolu() {
        homePageSteps.afterClickCheckSearchPlaceHolderText();
    }

    @Test(description = "Test Case 3")
    public void case76617PzPuanlarimClickAksiyonu() {
        homePageSteps.checkHomePageOpen();
        homePageSteps.checkPzPuanlarimBanner();
    }




}
