package org.Capabilities;

public interface MobileCapabilityTypes {
    String platformName = "platformName";
    String platformVersion = "platformVersion";
    String deviceName = "deviceName";
    String appPackage = "appPackage";
    String appActivity = "appActivity";
    String appWaitForLaunch = "appWaitForLaunch";
    String automationName = "automationName";
    String automatorAndroid = "UiAutomator2";
    String pushPermissions = "autoGrantPermissions";
    String noReset = "noReset";
    String fullReset = "fullReset";
    String enableMultiWindows = "appium:enableMultiWindows";
    String allowInvisibleElements = "appium:allowInvisibleElements";
    String app = "app";
    String udid = "udid";
    String bundleId = "bundleId";
    String autoAcceptAlert = "autoAcceptAlerts";
    String appId = "appium:app_id";
}
