package reqres.webapis;

import client.WebApiClient;
import contracts.HttpMethod;
import reqres.entities.contracts.register.RegisterRequest;
import reqres.entities.contracts.register.RegisterResponse;
import reqres.entities.contracts.user.UserRequest;
import reqres.entities.contracts.user.UserResponse;
import rest.assured.core.WebApiCaller;
import rest.assured.core.WebApiRequest;

public class RegisterWebApi extends WebApiClient {

    public RegisterWebApi(WebApiCaller webApiCaller) {
        super(webApiCaller);
    }

    public RegisterResponse register(RegisterRequest registerRequest) {
        WebApiRequest<RegisterRequest> request = new WebApiRequest<>("api/register", registerRequest);
        return super.execute(HttpMethod.POST, request).getResponse(RegisterResponse.class);
    }
}
