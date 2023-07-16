Feature: Validating Place API's

  Background:
    When browser is launched
  @VerifyTempByLatLong
  Scenario Outline: Verify Location name returned with temp detail when lat and lon has been provided
    Given I like to view next seven days of temperature with "<Lat>"  "<Lon>"
    When I look up weather forecast and returns status 200
    Then weather details has been returned for  "<Location>"

    Examples:
      | Location        | Lat     | Lon      |
      | Weehawken       | 40.7484 | -73.9967 |
      | Hillman Housing | 40.7152 | -73.9877 |

  @VerifyTemDetByPostCode
  Scenario Outline: Verify Location name returned with temp detail when postcode has been provided
    Given I like to view next seven days of temperature with post code "<PostCode>"
    When I look up weather forecast and returns status 200
    Then weather details has been returned for  "<Location>"

    Examples:
      | Location        | PostCode |
      | Weehawken       | 10001    |
      | Hillman Housing | 10002    |