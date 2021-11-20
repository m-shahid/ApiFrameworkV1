package rest.assured.core;

import contracts.ApiCaller;
import contracts.ApiRequest;
import contracts.ApiResponse;
import contracts.HttpMethod;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.Method;
import io.restassured.response.Response;

import java.util.Map;

public class WebApiCaller implements ApiCaller {

    private RequestSpecBuilder builder;

    public WebApiCaller(String baseUrl, Map<String, String> headers) {
        builder = new RequestSpecBuilder();
        builder.setBaseUri(baseUrl);
        builder.addHeaders(headers);
    }

    @Override
    public <TRequest> ApiResponse execute(HttpMethod method, ApiRequest<TRequest> request) {
        if(request.getBody() != null){
            builder.setBody(request.getBody());
        }
        if(request.getHeaders() != null){
            builder.addHeaders(request.getHeaders());
        }

        Response httpResponse = RestAssured.given().spec(builder.build()).log().all().request(Method.valueOf(method.toString()), request.getRoute());
        httpResponse.then().log().all();
        return new WebApiResponse(httpResponse);
    }
}
