package reqres.webapis;

import contracts.HttpMethod;
import reqres.entities.contracts.user.GetMultipleUserResponse;
import reqres.entities.contracts.user.GetUserResponse;
import reqres.entities.contracts.user.UserRequest;
import reqres.entities.contracts.user.UserResponse;
import rest.assured.core.WebApiCaller;
import client.WebApiClient;
import rest.assured.core.WebApiRequest;

public class UserWebApi extends WebApiClient {

    public UserWebApi(WebApiCaller webApiCaller) {
        super(webApiCaller);
    }

    public GetUserResponse getUser(int userId) {
        WebApiRequest<String> getUserApiRequest = new WebApiRequest<>("/api/users/" + userId);
        return super.execute(HttpMethod.GET, getUserApiRequest).getResponse(GetUserResponse.class);
    }

    public GetMultipleUserResponse getMultipleUsers(int pageNumber) {
        WebApiRequest<String> getUserApiRequest = new WebApiRequest<>("/api/users?page=" + pageNumber);
        return super.execute(HttpMethod.GET, getUserApiRequest).getResponse(GetMultipleUserResponse.class);
    }

    public UserResponse createUser(UserRequest userRequestBody) {
        WebApiRequest<UserRequest> request = new WebApiRequest<>("api/users", userRequestBody);
        return super.execute(HttpMethod.POST, request).getResponse(UserResponse.class);
    }

}
