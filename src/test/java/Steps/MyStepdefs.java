package Steps;


import com.microsoft.playwright.Page;
import context.testContext;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.openPage;

public class MyStepdefs {

    openPage op ;
    Page page;
    testContext context;
    public MyStepdefs() {
        context = new testContext();
        page = context.getPage();
        op = new openPage(page);
    }

    @Given("^I open the Facebook login page$")
    public void iOpenTheFacebookLoginPage() {
        op.openFb();
    }

    @When("I enter valid username and password")
    public void iEnterValidUsernameAndPassword() {

    }

    @And("I click on the login button")
    public void iClickOnTheLoginButton() {

    }

    @Then("I should be logged in successfully")
    public void iShouldBeLoggedInSuccessfully() {

    }
}
