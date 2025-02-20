package API.restHelper;

import java.util.Map;

public class RestHelper {

    public static int getResponseStatus(String URL, Endpoints endpoint, Map<String, String> headers) {
        return given()
                .relaxedHTTPSValidation()
                .headers(headers)
                .when()
                .get(URL.concat(endpoint.getValue()))
                .then()
                .extract()
                .response().statusCode();
    }
    public static <T> T restGet(String URL, Endpoints endpoint, Map<String, String> headers, Class<T> responseClass) {
        return given()
                .relaxedHTTPSValidation()
                .headers(headers)
                .when()
                .get(URL.concat(endpoint.getValue()))
                .then()
                .extract()
                .as(responseClass);
    }
    public static <T> T restGetWithRequestParameters(String URL, Endpoints endpoint, Map<String, String> headers,Map<String, String> queryParameters, Class<T> responseClass) {
        return given()
                .relaxedHTTPSValidation()
                .headers(headers)
                .queryParams(queryParameters)
                .when()
                .get(URL.concat(endpoint.getValue()))
                .then()
                .extract()
                .as(responseClass);
    }
    public static Response restGetWithRequestParameters(String URL, Endpoints endpoint, Map<String, String> headers,Map<String, String> queryParameters) {
        return given()
                .relaxedHTTPSValidation()
                .headers(headers)
                .queryParams(queryParameters)
                .when()
                .get(URL.concat(endpoint.getValue()))
                .then()
                .extract()
                .response();
    }
    public static <T> T restPost(String URL,Endpoints endpoint, Map<String, String> headers, Object bodyData, Class<T> responseClass) {
        return given()
                .relaxedHTTPSValidation()
                .headers(headers)
                .body(bodyData)
                .when()
                .post(URL.concat(endpoint.getValue()))
                .then()
                .extract()
                .as(responseClass);
    }
}
