package org.Utilities;

import org.Base.BaseTest;

import org.Steps.Android.HomePageSteps;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class StepInit extends BaseTest {
    public static HomePageSteps homePageSteps;

    public static WebDriverWait wait;



    public static void init() {
        homePageSteps = new HomePageSteps();




        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));



    }
}
