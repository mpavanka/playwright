package practice;


import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.BeforeAll;

import java.util.HashMap;
import java.util.Map;

public class getRequst {


    private static Playwright playwright;
    public static APIRequestContext request;

    public static void main(String[] args) {
        playwright = Playwright.create();
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJwYXZhbmthbHlhbjY4MzM1QGdtYWlsLmNvbSIsImV4cCI6MTgwOTI0OTQxNywiaWF0IjoxNzc3NzEzNDE3fQ.jN0rp-2af5VeRedxRkemWbyykLq9CE7WdH9iDFN2NLU");
        String token = playwright.request().newContext(new APIRequest.NewContextOptions()
                       .setBaseURL("https://api.restful-api.dev")
                       .setExtraHTTPHeaders(headers))
                .get("/dashboard-data")
                .text();
        System.out.println(token);
        disposeAPIRequestContext();
        closePlaywright();
    }

    static void disposeAPIRequestContext() {
        if (request != null) {
            request.dispose();
            request = null;
        }
    }

    static void closePlaywright() {
        if (playwright != null) {
            playwright.close();
            playwright = null;
        }
    }
}
