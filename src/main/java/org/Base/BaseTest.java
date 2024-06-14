package org.Base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.*;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.Capabilities.MobileCapabilityTypes;
import org.openqa.selenium.Platform;

import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;


import static org.Utilities.StepInit.init;


public abstract class BaseTest {

    private static final Logger LOGGER = LogManager.getLogger(BaseTest.class);
    private static final ThreadLocal<AppiumDriver> appiumDriver = new ThreadLocal<>();
    AppiumServer appiumServer = new AppiumServer();


    public static AppiumDriver getDriver() {
        return appiumDriver.get();
    }

    public void setDriver(String deviceType, boolean noReset,
                          String platformVersion, String appPackage, String appActivity,
                          boolean appWaitForLaunch, boolean pushPermission, boolean enableMultiWindows,
                          boolean allowInvisibleElements, String url, @Optional String app, String udid,
                          String bundleId, String appId, String deleteApp, @Optional("0") int wdaLocalPort, @Optional("0") int port, @Optional String deviceName) {

        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("win")) {
            url = url + "/wd/hub"; // Just Windows
        }

        switch (deviceType) {
            case "IOS":
                appiumServer.startAppiumServer(port);
                XCUITestOptions xcuiTestOptions = new XCUITestOptions();
                xcuiTestOptions.setCapability(MobileCapabilityTypes.platformName, "iOS");
                xcuiTestOptions.setCapability(MobileCapabilityTypes.platformVersion, platformVersion);
                xcuiTestOptions.setCapability(MobileCapabilityTypes.automationName, "XCUITest");
                xcuiTestOptions.setCapability(MobileCapabilityTypes.bundleId, bundleId);
                xcuiTestOptions.setCapability(MobileCapabilityTypes.pushPermissions, pushPermission);
                xcuiTestOptions.setCapability(MobileCapabilityTypes.autoAcceptAlert, true);
                xcuiTestOptions.setCapability(MobileCapabilityTypes.udid, udid);
                xcuiTestOptions.setCapability(MobileCapabilityTypes.appId, appId);
                xcuiTestOptions.setCapability("xcodeOrgId", "18AYT1T2YF");
                xcuiTestOptions.setCapability("xcodeSigningId", "iPhone Developer");
                xcuiTestOptions.setCapability("updatedWDABundleId", "com.facebook17283073.WebDriverAgentRunner");
                xcuiTestOptions.setWdaLocalPort(wdaLocalPort);

                try {
                    appiumDriver.set(new IOSDriver(new URL(url), xcuiTestOptions));
                } catch (MalformedURLException e) {
                    LOGGER.error("Driver could not be created! ErrorMessage: " + e.getMessage());
                }
                break;
            case "Android":
                appiumServer.startAppiumServer(port);
                UiAutomator2Options uiAutomator2Options = new UiAutomator2Options();
                uiAutomator2Options.setCapability(MobileCapabilityTypes.platformName, Platform.ANDROID);
                uiAutomator2Options.setCapability("newCommandTimeout", 22600);
                uiAutomator2Options.setCapability(MobileCapabilityTypes.platformVersion, platformVersion);
                uiAutomator2Options.setCapability(MobileCapabilityTypes.automationName, MobileCapabilityTypes.automatorAndroid);
                uiAutomator2Options.setCapability(MobileCapabilityTypes.appPackage, appPackage);
                uiAutomator2Options.setCapability(MobileCapabilityTypes.appActivity, appActivity);
                uiAutomator2Options.setCapability(MobileCapabilityTypes.appWaitForLaunch, appWaitForLaunch);
                uiAutomator2Options.setCapability(MobileCapabilityTypes.pushPermissions, pushPermission);
                uiAutomator2Options.setCapability(MobileCapabilityTypes.noReset, noReset);
                uiAutomator2Options.setCapability(MobileCapabilityTypes.enableMultiWindows, enableMultiWindows);
                uiAutomator2Options.setCapability(MobileCapabilityTypes.allowInvisibleElements, allowInvisibleElements);
                uiAutomator2Options.setCapability(MobileCapabilityTypes.app, app);
                uiAutomator2Options.setCapability(MobileCapabilityTypes.udid, udid);
                uiAutomator2Options.setCapability(MobileCapabilityTypes.appId, appId);

                try {
                    appiumDriver.set(new AndroidDriver(new URL(url), uiAutomator2Options));
                } catch (MalformedURLException e) {
                    LOGGER.error("Driver could not be created! ErrorMessage: " + e.getMessage());
                }

                getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                break;

            default:
                LOGGER.info("There is no such a device");
                break;
        }
    }

    @Parameters({"platform", "noReset", "platformVersion", "appPackage", "appActivity",
            "appWaitForLaunch", "pushPermission", "enableMultiWindows", "allowInvisibleElements", "url",
            "app", "udid", "bundleId", "appId", "deleteApp", "wdaLocalPort", "port", "deviceName"})
    @BeforeClass
    public void beforeClass(String platform, @Optional("true") boolean noReset, String platformVersion,
                            String appPackage, String appActivity, boolean appWaitForLaunch, @Optional("true") boolean pushPermission,
                            boolean enableMultiWindows, boolean allowInvisibleElements, String url, @Optional String app,
                            String udid, String bundleId, String appId, String deleteApp, @Optional("0") int wdaLocalPort,
                            @Optional("0") int port, @Optional String deviceName) {

        setDriver(platform, noReset, platformVersion, appPackage, appActivity, appWaitForLaunch,
                pushPermission, enableMultiWindows, allowInvisibleElements, url, app, udid, bundleId, appId, deleteApp,
                wdaLocalPort, port, deviceName);
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        init();
    }

    @Parameters({"platform", "noReset", "platformVersion", "appPackage", "appActivity",
            "appWaitForLaunch", "pushPermission", "enableMultiWindows", "allowInvisibleElements", "url",
            "app", "udid", "bundleId", "appId", "deleteApp", "wdaLocalPort", "port", "deviceName"})
    @BeforeMethod
    public void beforeMethod(String platform, @Optional("true") boolean noReset, String platformVersion,
                             String appPackage, String appActivity, boolean appWaitForLaunch, @Optional("true") boolean pushPermission,
                             boolean enableMultiWindows, boolean allowInvisibleElements, String url, @Optional String app,
                             String udid, String bundleId, String appId, String deleteApp, @Optional("0") int wdaLocalPort,
                             @Optional("0") int port, @Optional String deviceName) {
        if (getDriver() != null && noReset) {
            if (platform.equals("Android")) {
                ((AndroidDriver) getDriver()).terminateApp(appPackage);
                ((AndroidDriver) getDriver()).activateApp(appPackage);
            } else {
                ((IOSDriver) getDriver()).terminateApp(bundleId);
                ((IOSDriver) getDriver()).activateApp(bundleId);
            }
        }
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Parameters({"platform", "appPackage"})
    @AfterClass
    public void afterClass(String platform, String appPackage) {
        if (platform.equals("Android")) {
            ((AndroidDriver) getDriver()).terminateApp(appPackage);
        } else {
            ((IOSDriver) getDriver()).terminateApp(appPackage);
        }
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        appiumServer.stopAppiumServer();
    }
}