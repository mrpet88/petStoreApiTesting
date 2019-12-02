package petStoreApiTest.stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import steps.CreatePetObject;
import steps.petHelper;

public class Post {
    petHelper pethelper = new petHelper();

    @Given("^the user provides a new pet details$")
    public void userCreatesAPet() {
        new CreatePetObject().addPetDetails();
    }

    @When("the user submits post request")
    public void heMakesPostRequest() {
        pethelper.buildUrl(true);
        pethelper.post();
    }

    @Then("valid response {int} should return")
    public void validResponseShouldReturn(int expectedStatus) {
        pethelper.validateStatus(expectedStatus);
    }
}
