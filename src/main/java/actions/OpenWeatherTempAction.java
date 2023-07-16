package actions;
/*
 * Created by IntelliJ IDEA.
 * User: Prasad
 * Date: 8/4/21
 * Time: 12:54 PM
 */

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import support.UtilSupport;
import java.io.IOException;
import java.util.logging.Logger;



import static io.restassured.RestAssured.given;

public class OpenWeatherTempAction extends UtilSupport {
    RequestSpecification res;
    ResponseSpecification resspec;
    Response response;
    JsonPath js;
    Logger log = Logger.getLogger("devpinoyLogger");
    public void buildGetRequest(String lat, String lon) throws IOException {

        res = given().spec(requestSpecificationWeather()).queryParam("lat", lat).queryParam("lon", lon);
        resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
    }
    public void buildGetRequestPostCode(String pstCode) throws IOException {

        res = given().spec(requestSpecificationWeather()).queryParam("postal_code", pstCode);
        resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
    }
    public int getResponse() {
        response = res.when().get();
        js = convertToJsonResponse(response);
        return response.getStatusCode();
    }

    @Override
    public RequestSpecification requestSpecificationWeather() throws IOException {
        return super.requestSpecificationWeather();
    }

    public Boolean validateNextDaysTemp(String location)  {
        log.info("==> " + " City: " + js.getString("data[0].city_name") + " - Current Temp " + js.getString("data[0].app_temp") + " On : " + js.getString("data[0].datetime"));
//        log.info("==>  City: " + js.getString("data[0].city_name") + " - Current Temp " + js.getString("data[0].app_temp") + " On : " + js.getString("data[0].datetime"));
        return (js.getString("data[0].city_name").equals(location));
    }

}
