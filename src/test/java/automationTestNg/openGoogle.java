package automationTestNg;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class openGoogle {

    static Page page;
    static Browser browser;
    static BrowserType browserType;
    static Playwright playwright;

    @BeforeClass
    public static void beforeStart() {
        playwright = Playwright.create();
        browserType = playwright.chromium();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();
    }

    @AfterClass
    public static void afterClass(){
        page.close();
        browser.close();
    }


    @Test
    public void searchForGoogleCeo() {
        page.navigate("https://www.google.com");
        page.fill("[name='q']", "GOOGLE CEO");
        page.keyboard().press("Enter");
        String name = page.locator("[class='FLP8od']").textContent();
        System.out.println(name);
    }

}
