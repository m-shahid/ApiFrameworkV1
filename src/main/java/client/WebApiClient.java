package client;

import contracts.ApiRequest;
import contracts.ApiResponse;
import contracts.HttpMethod;
import io.restassured.http.Method;
import rest.assured.core.WebApiCaller;

public class WebApiClient {

    private ApiResponse apiResponse;
    private WebApiCaller webApiCaller;

    public WebApiClient(WebApiCaller webApiCaller) {
        this.webApiCaller = webApiCaller;
    }

    protected <TRequest> ApiResponse execute(HttpMethod method, ApiRequest<TRequest> apiRequest) {
        apiResponse = webApiCaller.execute(method, apiRequest);
        return apiResponse;
    }

    public int getStatusCode() {
        return apiResponse.getStatusCode();
    }
}
