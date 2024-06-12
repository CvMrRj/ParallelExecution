package org.Base;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumServer {
    private static AppiumDriverLocalService service;

    public static void startAppiumServer(int port) {
        AppiumServiceBuilder builder = new AppiumServiceBuilder()
                .withIPAddress("127.0.0.1")
                .usingPort(port)
                .withArgument(() -> "--allow-insecure=get_server_logs");

        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("win")) {
            builder.withArgument(() -> "--base-path", "/wd/hub"); // Just Windows
        }
        service = AppiumDriverLocalService.buildService(builder);
        service.start();
    }

    public static void stopAppiumServer() {
        if (service != null) {
            service.stop();
        }
    }
}