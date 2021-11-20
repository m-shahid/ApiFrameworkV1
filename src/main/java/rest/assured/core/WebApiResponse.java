package rest.assured.core;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import contracts.ApiResponse;
import io.restassured.response.Response;

public class WebApiResponse implements ApiResponse {

    private Response response;

    public WebApiResponse(Response response){
        this.response = response;
    }

    @Override
    public int getStatusCode() {
        return response.statusCode();
    }

    @Override
    public <TRequest> TRequest getRequest() {
        return null;
    }

    @Override
    public <TResponse> TResponse getResponse(Class<TResponse> bodyClassType) {
        ObjectMapper mapper = new ObjectMapper();
        JavaType type = mapper.getTypeFactory().constructType(bodyClassType);
        return response.as(type);
    }
}
