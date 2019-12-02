package petStoreApiTest.stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import steps.petHelper;

public class Delete {
    petHelper pethelper = new petHelper();

    @Given("user provides existing pet details")
    public void userProvidesExistingPetDetails() {
        pethelper.buildUrl(false);

    }

    @When("the user submits delete request")
    public void theUserSubmitsDeleteRequest() {
        pethelper.delete();
    }


    @Then("the pet should be deleted")
    public void thePetShouldBeDeleted() {
        pethelper.validateStatus(200);
    }
}
