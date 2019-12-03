Feature: Create a basic Api test for pet store

  @POST
  Scenario: Post a new pet
    Given the user provides a new pet details
    When the user submits post request
    Then valid response 200 should return

  @GET
  Scenario: Get a pet
    Given user provides existing pet id
    When the user submits get request
    Then the correct pet should appear

  @UPDATE
  Scenario: Update a pet
    Given user updates pet details
    When the user post the new details
    Then the pet should be updated succesfully

  @DELETE
  Scenario: Delete a pet
    Given user provides existing pet details
    When the user submits delete request
    Then the pet should be deleted
