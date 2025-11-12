package automationTestNg;

import com.microsoft.playwright.*;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.LoadState;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class openFb {

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
    public void openFacebook() {
        page.navigate("https://www.facebook.com");
        page.locator("input#email").click();
        page.fill("input#email", "testuser");
        page.locator("input#pass").click();
        page.fill("input#pass", "password");
        page.locator("button[name='login']").click();
        page.waitForLoadState(LoadState.NETWORKIDLE);
        String title = page.title();
        Assert.assertEquals(title, "Facebook", "Facebook home page is not opened");
    }
}
