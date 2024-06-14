package org.Steps.Android;

import org.Pages.Android.HomePage;
import org.testng.Assert;

import static org.Base.BaseTest.getDriver;


public class HomePageSteps extends HomePage {

    public void scrollUpHome() {
        scroll(ScrollDirection.DOWN, 0.5, "Aşağı scroll yapılır");
    }

    public void checkHomePageOpen() {
        waitVisibleByLocator(imgLogoNewCompany);
        Assert.assertTrue(isExist(imgLogoNewCompany), "NewCompany logosu sayfada bulunmuyor");
    }
    public void goToHomePage(){
        getDriver().get("newCompany.app://h");
        clickElement(bottomTabHome,"Ana sayfa tab ine tıklanır ve ana asayfanını açıldığı doğrulanır");
        checkHomePageOpen();
    }

    public void checkSearchPlaceHolderText() {
        Assert.assertEquals(getTextElement(searchArea), "Marka, ürün veya hizmet arayın",
                "Search alanındaki metin yanlış");
    }

    public void afterClickCheckSearchPlaceHolderText() {
        clickElement(searchArea, "Arama input alanına tıklanır ve place holder metni kontrol edilir");
        Assert.assertEquals(getTextElement(GlobalPage.searchAreaInSearch), "Marka, ürün veya hizmet arayın", "Search alanındaki metin yanlış");
    }

    public void checkNewCompanyPuanlarimBanner() {
        scrollUntilElementVisible(bannerNewCompanyPuanlarim);
        clickElement(bannerNewCompanyPuanlarim, "NewCompany puanlarım banner'i tıklanır ve puanlarım sayfası açıldığı doğrulanır");
        Assert.assertTrue(isDisplayElement(titleNewCompanyPuanlarim), "Puanlarım başlığı gelmedi");
    }
    public void checkNewCompanyKuponlarimBanner(){
        scrollUntilElementVisible(bannerNewCompanyKuponlarim);
        clickElement(bannerNewCompanyKuponlarim,"Kuponlarım banner'i tıklanır ve kuponlarım sayfası açıldığı doğrulanır");
        Assert.assertEquals(getTextElement(titleToolBar),"Kuponlarım","Kuponlarım sayfası açılmadı!");
    }

    public void checkHomePageAction() {
        clickElement(bottomTabHome, "Ana sayfa tab butonuna tıklanır ve sayfasının yukarı scroll edildiği doğrulanır");
        Assert.assertTrue(isExist(imgLogoNewCompany), "Sayfa yukarı scroll edilmedi");
    }

    public void checkStickyHeaderView() {
        Assert.assertFalse(isExist(btnWallet), "Cüzdan butonu var");
        Assert.assertFalse(isExist(imgLogoNewCompany), "NewCompany logosu var");
        Assert.assertTrue(isExist(searchArea), "Arama alanı yok");
    }

    public void checkWalletClickAction() {
        checkHomePageOpen();
        wait(2); // beklemeden tıklayınca belirsiz olarak tıkladığı halde açılmıyor bu yüzden static wait ekledim
        clickElement(btnWallet, "Cüzdan butonu tıklanır ve cüzdan sayfası açıldığı doğrulanır");
        if (isExist(btnTanitimiGec)) clickElement(btnTanitimiGec, "Tanıtımı gec tıklanır");
        if (isExist(btnUygulamayiKullanirkenIzinVer))
            clickElement(btnUygulamayiKullanirkenIzinVer, "Konum izni verilir");
        Assert.assertTrue(isExist(layoutWallet), "Cüzdana hoşgeldiniz alanı yok");
    }

    public void checkWalletToHomePageAction() {
        clickElement(bottomTabHome, "Ana sayfa tabına tıklanır ve ana sayfa açıldığı doğrulanır");
        checkHomePageOpen();
    }

    public void goToMarketFromHomePage() {
        clickElement(tvTitleMarket, "Market title ına tıklanır ve market sayfası açıldığı doğrulanır");
        Assert.assertTrue(isExist(appbarMarket), "Market appbar'ı gelmedi");
    }

    public void goToNewCompanyHomePageTopLeftBack() {
        clickElement(btnBackWidget, "Geri butonu tıklanır ve ana sayfa açıldığı doğrulanır");
        checkHomePageOpen();
    }

    public void goToPetFromHomePage() {
        clickElement(tvTitleNewCompanyPet, "NewCompany Pet title ına tıklanır ve pet sayfası açıldığı doğrulanır");
        Assert.assertTrue(isExist(imgPaw), "Pati görseli yok, NewCompany Pet açılmadı");
    }

    public void goToOynaKazanFromHomePage() {
        clickElement(tvTitleSuperKazan, "Super kazan tıklanır ve süper kazan sayfası açıldığı doğrulanır");
        if (isExist(btnTanitimiGec)) clickElement(btnTanitimiGec, "Tanıtımı geç tıklanır");
        Assert.assertTrue(isExist(titleSuperKazan), "Super kazan başlığı gelmedi");
    }

    public void goToHomePageFromSuperKazan() {
        clickElement(btnBackLeftBackFromSuperKazan, "Geri butonu tıklanır ve ana sayfa açıldığı doğrulanır");
        checkHomePageOpen();
    }

    public void checkEkosistem() {
        Assert.assertFalse(isExist(dokuzuncuSatir), "Ekosistemde sekizinci satır var");
        Assert.assertFalse(isExist(altinciSutun), "Ekosistemde beşinci sütun var");
    }

    public void taksitBannerKontrolu() {
        Assert.assertTrue(isExist(imgTaksitBanner), "Maximum karta peşin fiyatına 6-9-12 taksit banneri yok");
    }

    public void goToNotification() {
        clickElement(btnNotification, "Bildirimler tıklanır ve bildirimler sayfası açıldığı doğrulanır");
        Assert.assertEquals(getTextElement(titleToolBar), "Bildirimler",
                "Bildirimler sayfası açılmadı");
    }

    public void checkPopulerMagazalarSwiper() {
        scrollUntilElementVisible(txtPopulerMagazalar);
        // locator gözüktükten sonra alttaki markalarında gözüktüğünden emin olmak için bi scroll daha yapılır
        scroll(ScrollDirection.DOWN,0.1,"Sayfa scroll edilir");
        Assert.assertEquals(getTextElement(txtPopulerMagazalar), "Popüler Mağazalar",
                "Popüler mağazalar alanı gelmedi");
    }

    public void checkClickAction() {
        clickElement(imgMagazaArea, "Popüler mağazalar alanına tıklanır ve mağaza sayfasına yönlendiği doğrulanır");
        Assert.assertTrue(isExist(btnMagazaBilgileri), "Magaza sayfası açılmadı");
    }

    public void checkBannerCounter() {
        scrollUntilElementVisible(txtBannerCounter);
        Assert.assertTrue(isExist(txtBannerCounter), "Banner sayacı yok");
    }

    public void checkKategoriBannerExist() {
        checkHomePageOpen();
        Assert.assertTrue(isExist(bottomTabCategories), "Kategoriler butonu yok");
    }

    public void clickKategoriBanner() {
        clickElement(bottomTabCategories, "Kategoriler tıklanır ve kategoriler sayfası açıldığı doğrulanır");
        categoriesPageSteps.checkCategoriesPageTitle();
    }

    public void checkAnasayfaTabButton() {
        Assert.assertTrue(isExist(bottomTabHome), "Ana sayfa tab butonu yok");
    }

    public void goToHesabimPage() {
        clickElement(bottomTabProfile, "Hesabım tıklanır");
    }

    public void goToCarouselBanner() {
        scroll(ScrollDirection.DOWN, 0.8, "Scroll aşağı yapılıyor");
        scrollUntilElementVisible(btnSeeAllProduct);
        String title = getTextElement(txtTitle);
        clickElement(btnSeeAllProduct, "Carousel banner tümünü gör tıklanır ve banner sayfası açıldığı kontrol edilir");
        Assert.assertEquals(getTextElement(titleToolBar), title, "Açılan sayfanın başlığı yanlış");
        Assert.assertEquals(getTextElement(txtTitle), title, "Alt başlıktaki başlık yanlış");
        Assert.assertTrue(isExist(txtTitle), "Yukarı ok butonu yok");
    }

    public void checkAkordiyonButton() {
        Assert.assertTrue(isExist(imgProductView), "Bannerlar gelmedi");
        clickElement(txtTitle, "Akordiyon butonu tıklanır ve bannerlar geldiği kontrol edilir");
        Assert.assertFalse(isExist(imgProductView), "Bannerlar gitmedi");
    }

    public void goToTatilFromHomePage() {
        clickElement(btnTatil, "");
        wait(2); // tatil webview e yönlenmesi icin 1sn lik statik wait ekledim
        Assert.assertFalse(isExist(imgLogoNewCompany), "");
    }

    public void waitHomePageAndGoToMenu(String url) {
        waitVisibleByLocator(imgLogoNewCompany);
        getDriver().get(url);
        waitVisibleByLocator(titleToolBar);
    }
}
