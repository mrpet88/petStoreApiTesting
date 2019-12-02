package petStoreApiTest.stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import steps.CreatePetObject;
import steps.petHelper;

public class Update {
    petHelper pethelper = new petHelper();

    @Given("user updates pet details")
    public void updatingAPet() {
        new CreatePetObject().updatePetDetails();

    }

    @When("the user post the new details")
    public void theUserPostTheNewDetails() {
        pethelper.buildUrl(true);
        pethelper.post();
    }

    @Then("the pet should be updated succesfully")
    public void thePetShouldBeUpdated() {
        pethelper.validateGetRequest(true);
    }
}
