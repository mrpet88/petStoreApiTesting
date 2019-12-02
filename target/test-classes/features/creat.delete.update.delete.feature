Feature: Create a basic Api test for pet store

  @POST
  Scenario: Post a new pet
    Given user creates a pet
    When he makes post request
    Then valid response 200 should return

  @GET
  Scenario: Get a pet
    Given user provide pet id
    When the user submits get request
    Then the right pet should appear

  @UPDATE
  Scenario: Update a pet
    Given user updates pet details
    When the user post the new details
    Then the pet should be updated

  Scenario: Delete a pet
    Given user provides the deleted pet id
    When the user submits delete request
    Then the pet should be deleted
