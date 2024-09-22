package automationTestNg;

import com.microsoft.playwright.*;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class openGoogle {

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
    public void searchForGoogleCeo() {
        // Navigate to Google and search for "GOOGLE CEO"
        page.navigate("https://www.google.com");
        page.fill("[name='q']", "GOOGLE CEO");
        page.keyboard().press("Enter");
        String name = page.locator("[class='FLP8od']").textContent();
        System.out.println(name);
    }

    @Test(dependsOnMethods="searchForGoogleCeo")
    public void clickOnInstaLink() throws Throwable {
        page.evaluate("window.scrollBy(0, 1000)");
        page.waitForSelector("//*[@id=\"rso\"]/div[3]/div/div/div[1]/div/div/span/a/h3", new Page.WaitForSelectorOptions().setTimeout(5000));
        page.locator("[class=\"uq_cd\"]").click();
        String errorMessage = page.locator("[class=\"eu_h\"]").textContent();
        Assert.assertEquals(errorMessage, "D22", "We got permission to see google CEO profile in linkedIN");
    }
}
