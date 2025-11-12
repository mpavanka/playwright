package automationTestNg;

import com.microsoft.playwright.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class openGle {

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
//        String name = page.locator("[data-attrid=\"title\"]").textContent();
//        System.out.println(name);
    }
//
//    @Test(dependsOnMethods="searchForGoogleCeo")
//    public void clickOnInstaLink() throws Throwable {
//        page.evaluate("window.scrollBy(0, 1000)");
//        page.waitForSelector("//*[@id=\"_QEUMadXnNb-c4-EPu7SCmAY_107\"]", new Page.WaitForSelectorOptions().setTimeout(5000));
//        page.locator("//*[@id=\"_QEUMadXnNb-c4-EPu7SCmAY_107\"]").click();
//        String errorMessage = page.locator("[class=\"eu_h\"]").textContent();
//        Assert.assertEquals(errorMessage, "D22", "We got permission to see google CEO profile in linkedIN");
//    }

//    @Test
//    public void openYouTube() {
//        page.navigate("https://www.youtube.com");
//        page.locator("input#search").click();
//        page.fill("input#search", "Playwright Testing");
//        page.keyboard().press("Enter");
//        String title = page.title();
//        Assert.assertEquals(title, "YouTube", "YouTube home page is not opened");
//    }

//    @Test
//    public void openFacebook() {
//        page.navigate("https://www.facebook.com");
//        page.locator("input#email").click();
//        page.fill("input#email", "testuser");
//        page.locator("input#pass").click();
//        page.fill("input#pass", "password");
//        page.locator("button[name='login']").click();
//        String title = page.title();
//        Assert.assertEquals(title, "Facebook", "Facebook home page is not opened");
//    }
//
//    @Test
//    public void openTwitter() {
//        page.navigate("https://www.twitter.com");
//        page.locator("input[name='session[username_or_email]']").click();
//        page.fill("input[name='session[username_or_email]']", "testuser");
//        page.locator("input[name='session[password]']").click();
//        page.fill("input[name='session[password]']", "password");
//        page.locator("div[data-testid='LoginForm_Login_Button']").click();
//        String title = page.title();
//        Assert.assertEquals(title, "Twitter", "Twitter home page is not opened");
//    }


}
