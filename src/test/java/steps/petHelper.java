package steps;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.thucydides.core.annotations.Steps;
import org.assertj.core.api.SoftAssertions;
import org.testng.Assert;
import steps.utils.petStatus;

import static net.serenitybdd.rest.SerenityRest.given;
import static steps.CreatePetObject.pet;
import static steps.utils.WebServiceEndpoint.petUrl;

public class petHelper {
    @Steps
    String PetUrl = "https://petstore.swagger.io/v2/pet/";
    Response response;
    RequestSpecification requestSpec;
    SoftAssertions softly = new SoftAssertions();


    public void buildUrl(boolean isPost) {
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setBaseUri(petUrl.getUrl());
        if (isPost) {
            builder.setBody(pet.toString());
        }
        builder.setContentType("application/json");
        requestSpec = builder.build();
    }

    public void buildUpdateUrl() {
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setBaseUri(petUrl.getUrl());
        builder.addFormParam("name", "updatedName");
        builder.addFormParam("status", petStatus.Pending.getStatus());
        builder.setContentType("application/json");
        requestSpec = builder.build();
    }

    public void post() {
        response = given().spec(requestSpec)
                .when()
                .post(petUrl.getUrl());
    }

    public void get() {
        response = given().spec(requestSpec)
                .when()
                .get(petUrl.getUrl() + "{id}", pet.get("id"));
    }

    public void delete() {
        response = given().spec(requestSpec)
                .when()
                .delete(petUrl.getUrl() + "{id}", pet.get("id"));
    }

    public void validateStatus(int expectedStatus) {
        int statusResponse = response.getStatusCode();
        Assert.assertEquals(statusResponse, expectedStatus);
    }

    public void validateGetRequest(boolean isUpdated) {
        JsonPath jp = response.jsonPath();
        validateStatus(200);
        softly.assertThat((Long) jp.get("id")).as("pet id").isEqualTo(pet.get("id"));
        softly.assertThat((String) jp.get("name")).as("pet name").isEqualTo(pet.get("name"));
        if (isUpdated) {
            softly.assertThat((String) jp.get("status")).as("pet status").isEqualTo(petStatus.Pending.getStatus());
        } else {
            softly.assertThat((String) jp.get("status")).as("pet status").isEqualTo(petStatus.Available.getStatus());
        }
        softly.assertAll();
    }
}

