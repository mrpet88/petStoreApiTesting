package petStoreApiTest.stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import steps.petHelper;

public class Get {
    petHelper pethelper = new petHelper();

    @Given("user provides existing pet id")
    public void userProvidePetId() {
        pethelper.buildUrl(false);
    }

    @When("the user submits get request")
    public void theUserSubmitsGetRequest() {
        pethelper.get();
    }

    @Then("the correct pet should appear")
    public void theRightPetShouldAppear() {
        pethelper.validateRequest();
    }
}
