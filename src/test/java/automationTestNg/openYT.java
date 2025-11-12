package automationTestNg;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.microsoft.playwright.*;

public class openYT {

    static Page page;
    static Browser browser;
    static BrowserContext context;
    static Playwright playwright;

    @BeforeClass
    public static void beforeStart() {
        // Initialize Playwright and launch the browser
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        // Create a browser context (use the same context throughout)
        Browser.NewContextOptions contextOptions = new Browser.NewContextOptions().setViewportSize(null);
        context = browser.newContext(contextOptions);

        // Create a new page inside the context
        page = context.newPage();
    }

    @AfterClass
    public static void afterClass(){
        page.close();
        browser.close();
    }


    @Test
    public void openYouTube() {
        page.navigate("https://www.youtube.com");
        page.locator("[name=\"search_query\"]").click();
        page.fill("[name=\"search_query\"]", "Playwright Testing");
        page.keyboard().press("Enter");
        String title = page.title();
        Assert.assertEquals(title, "YouTube", "YouTube home page is not opened");
    }

}
