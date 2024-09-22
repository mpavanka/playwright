package automation;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class sampleTest {

    static Playwright playwright = Playwright.create();
    // It will create instance of playwright
    static BrowserType browserType = playwright.chromium();
    /*it will help to choose which browser type we need,
    so it can create web driver to that particular browser*/
    static Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
    // it will lunch the browser
    static Page page = browser.newPage();
    // it will create the page

    private void searchForGoogleCeo(){
        page.navigate("https://www.google.com");
        page.fill("[name='q']", "GOOGLE CEO");
        page.keyboard().press("Enter");
        String name = page.locator("[class='FLP8od']").textContent();
        System.out.println(name);
        page.close();
    }

    public static void main(String[] args) {
        sampleTest sampleTest = new sampleTest();
        sampleTest.searchForGoogleCeo();
    }
}
