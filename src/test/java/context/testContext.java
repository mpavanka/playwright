package context;

import com.microsoft.playwright.*;
import io.cucumber.java.Before;


public class testContext {

    private Playwright playwright;
    private BrowserType browserType;
    private Browser browser;
    private Page page;
    private BrowserContext context;

    // Ensure the context initializes when instantiated directly
    public testContext() {
        browserSetup();
    }


    public void browserSetup() {
       try {
           if (playwright == null) {
               playwright = Playwright.create();
               browserType = playwright.chromium();
               try {
                   // Try to use the installed Chrome browser first (preferred for real-browser testing)
                   browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));

               } catch (Exception e) {
                   // If launching the chrome channel fails (not installed), fall back to bundled Chromium
                   System.err.println("Failed to launch with channel 'chrome', falling back to default chromium: " + e.getMessage());
                   browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false));
               }
               context = browser.newContext(new Browser.NewContextOptions().setViewportSize(1920, 1080));
               page = context.newPage();

               if (page == null) {
                   throw new RuntimeException("Playwright Page initialization failed: page is null");
               }
           }
       } catch (Exception e) {
           e.printStackTrace();
           throw new RuntimeException("Failed to initialize Playwright browser", e);
       }
    }

    public Page getPage() {
        return page;
    }

    // Optional helper to close resources
    public void close() {
        try {
            if (browser != null) browser.close();
            if (playwright != null) playwright.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
