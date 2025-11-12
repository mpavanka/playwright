//package AutomationJunit;
//
//import com.microsoft.playwright.Browser;
//import com.microsoft.playwright.BrowserType;
//import com.microsoft.playwright.Page;
//import com.microsoft.playwright.Playwright;
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//
//public class openGoogle {
//
//    static Page page;
//    static Browser browser;
//    static BrowserType browserType;
//    static Playwright playwright;
//
//    @BeforeAll
//    public static void beforeStart() {
//        playwright = Playwright.create();
//        browserType = playwright.chromium();
//        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
//        page = browser.newPage();
//    }
//
//    @AfterAll
//    public static void afterClass(){
//        page.close();
//        browser.close();
//    }
//
//
//    @Test
//    public void searchForGoogleCeo() {
//        page.navigate("https://www.google.com");
//        page.fill("[name='q']", "GOOGLE CEO");
//        page.keyboard().press("Enter");
//        String name = page.locator("[class='FLP8od']").textContent();
//        System.out.println(name);
//    }
//
//}
