package pages;

import com.microsoft.playwright.Page;


public class openPage {

    public Page page;

    public openPage(Page page) {
        this.page = page;
    }


    public void openFb() {
        page.navigate("https://www.facebook.com/");
        page.waitForTimeout(20000);
    }
}
