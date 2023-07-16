package stepDef;
/*
 * Created by IntelliJ IDEA.
 * User: Prasad
 * Date: 8/4/21
 * Time: 12:54 PM
 */

import actions.OpenWeatherTempAction;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import support.UtilSupport;

import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;

public class OpenWeatherTempStepDef extends UtilSupport {

    private OpenWeatherTempAction openWeatherTempAction;
    Logger log = Logger.getLogger("devpinoyLogger");

    @When("browser is launched")
    public void browser_is_launched() {
        if (openWeatherTempAction == null) {
            openWeatherTempAction = new OpenWeatherTempAction();
        }
    }

    @Given("I like to view next seven days of temperature with {string}  {string}")
    public void iLikeToViewNextSevenDaysOfTemperatureWith(String lat, String lon) {

        try {
            openWeatherTempAction.buildGetRequest(lat, lon);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @When("I look up weather forecast and returns status {int}")
    public void iLookUpWeatherForecastAndReturnsStatus(int statusNum) {
        Assert.assertEquals("Some issue with response", statusNum, openWeatherTempAction.getResponse());
    }



    @Given("I like to view next seven days of temperature with post code {string}")
    public void i_like_to_view_next_seven_days_of_temperature_with_post_code(String pstCode) {
          try {
            openWeatherTempAction.buildGetRequestPostCode(pstCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Then("weather details has been returned for  {string}")
    public void weather_details_has_been_returned_for(String loc) {
        Assert.assertTrue("Location temp detail has responded successfully", openWeatherTempAction.validateNextDaysTemp(loc));
    }
}
