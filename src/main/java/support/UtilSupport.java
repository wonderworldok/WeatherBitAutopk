package support;
/*
 * Created by IntelliJ IDEA.
 * User: Prasad
 * Date: 8/4/21
 * Time: 12:54 PM
 */
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

public class UtilSupport {
    public static RequestSpecification req;
    public RequestSpecification requestSpecificationWeather() throws IOException
    {
        if(req==null)
        {
            PrintStream log =new PrintStream(new FileOutputStream("logging.txt"));
            req=new RequestSpecBuilder().setBaseUri(getGlobalValue("baseWeatherUrl")).addQueryParam("key", "cfe3210ce30a4cf9ac96973cc5f68d4e").addQueryParam("units", "metric")
                    .addFilter(RequestLoggingFilter.logRequestTo(log))
                    .addFilter(ResponseLoggingFilter.logResponseTo(log))
                    .setContentType(ContentType.JSON).build();
            return req;
        }
        return req;
    }

    public static String getGlobalValue(String key) throws IOException
    {
        Properties prop =new Properties();
        FileInputStream fis =new FileInputStream( System.getProperty("user.dir") + "\\src\\main\\java\\support\\global.properties");
        prop.load(fis);
        return prop.getProperty(key);
    }
    public static JsonPath convertToJsonResponse(Response rawResponse) {

        String responseString = rawResponse.asString();
        JsonPath responseJson = new JsonPath(responseString);
        return responseJson;
    }
}
