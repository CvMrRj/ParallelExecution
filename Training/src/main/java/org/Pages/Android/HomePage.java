package org.Pages.Android;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AndroidFindBy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {

    //  public HomePage()  {
    //    PageFactory.initElements(getDriver(), this);
    //}
    public static By btnWallet = AppiumBy.id("walletButton");
    public static By btnNotification = AppiumBy.id("btn_notification");
    @AndroidFindBy(xpath = "//androidx.appcompat.widget.LinearLayoutCompat[1]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup")
    public static List<WebElement> homeProductCards;
    public static By imgLogoNewCompany = AppiumBy.id("logo");
    public static By bannerNewCompanyPuanlarim = AppiumBy.xpath("(//*[@resource-id='com.newConsulting.newCompany.app:id/imageViewSecond'])[2]");
    public static By bannerNewCompanyKuponlarim = AppiumBy.xpath("(//*[@resource-id='com.newConsulting.newCompany.app:id/imageViewFirst'])[2]");
    public static By titleNewCompanyPuanlarim = AppiumBy.xpath("//android.widget.TextView[@text=\"Puanlarım\"]");
    public static By layoutWallet = AppiumBy.id("layoutWalletContent");
    public static By tvTitleMarket = AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.newConsulting.newCompany.app:id/title\" and @text=\"Market\"]");
    public static By tvTitleNewCompanyPet = AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.newConsulting.newCompany.app:id/title\" and @text=\"NewCompany Pet\"]");
    public static By tvTitleSuperKazan = AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.newConsulting.newCompany.app:id/title\"]");
    public static By titleSuperKazan = AppiumBy.xpath("//android.widget.TextView[@text=\"Süper Kazan\"]");
    public static By btnBackLeftBackFromSuperKazan = AppiumBy.xpath("//android.webkit.WebView[@text=\"NewCompany\"]/android.view.View/android.view.View/android.widget.Button[1]");
    public static By btnBackWidget = AppiumBy.className("android.widget.ImageButton");
    public static By dokuzuncuSatir = AppiumBy.xpath("(//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.newConsulting.newCompany.app:id/recyclerView\"])[1]/androidx.appcompat.widget.LinearLayoutCompat[9]");
    public static By altinciSutun = AppiumBy.xpath("(//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.newConsulting.newCompany.app:id/recyclerView\"])[2]/androidx.appcompat.widget.LinearLayoutCompat[6]");
    public static By imgTaksitBanner = AppiumBy.xpath("(//android.widget.ImageView[@resource-id=\"com.newConsulting.newCompany.app:id/bannerIcon\"])[2]");
    public static By txtPopulerMagazalar = AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.newConsulting.newCompany.app:id/title\"]");
    public static By imgMagazaArea = AppiumBy.xpath("(//androidx.appcompat.widget.LinearLayoutCompat[@resource-id=\"com.newConsulting.newCompany.app:id/category_image_area\"])");
    public static By txtBannerCounter = AppiumBy.id("banner_count");
    public static By btnTatil = AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.newConsulting.newCompany.app:id/title\" and @text=\"Otel – Tatil  Uçak – Araç\"]");
    public static By btnTanitimiGec = AppiumBy.xpath("//android.widget.Button[@text=\"Tanıtımı Geç\"]");
    public static By btnUygulamayiKullanirkenIzinVer = AppiumBy.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button");
}
