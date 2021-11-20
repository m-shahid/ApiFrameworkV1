package reqres.tests;

import reqres.entities.contracts.user.GetMultipleUserResponse;
import reqres.entities.contracts.user.GetUserResponse;
import reqres.entities.contracts.user.UserRequest;
import reqres.entities.contracts.user.UserResponse;
import org.testng.Assert;
import org.testng.annotations.Test;
import reqres.webapis.UserWebApi;


public class UserTest extends BaseTest {

    @Test
    public void validateGetUser() {
        System.out.println("================== Starting Test ====================");
        System.out.println("Current Thread : " + Thread.currentThread().getId());

        UserWebApi userWebApi = new UserWebApi(apiCaller);

        GetUserResponse response = userWebApi.getUser(2);

        Assert.assertEquals(userWebApi.getStatusCode(), 200);
        Assert.assertEquals(response.getData().getId(), 2);
    }

    @Test
    public void validateGetUserNotFound() {
        System.out.println("================== Starting Test ====================");
        System.out.println("Current Thread : " + Thread.currentThread().getId());

        UserWebApi userWebApi = new UserWebApi(apiCaller);

        userWebApi.getUser(23);

        Assert.assertEquals(userWebApi.getStatusCode(), 404);
    }

    @Test
    public void validateGetMultipleUsers() {
        System.out.println("================== Starting Test ====================");
        System.out.println("Current Thread : " + Thread.currentThread().getId());

        UserWebApi userWebApi = new UserWebApi(apiCaller);

        GetMultipleUserResponse userResponse = userWebApi.getMultipleUsers(2);

        Assert.assertEquals(userWebApi.getStatusCode(), 200);
        Assert.assertTrue(userResponse.getData().size() > 0);
    }

    @Test
    public void validateCreateUser() {
        System.out.println("================== Starting Test ====================");
        System.out.println("Current Thread : " + Thread.currentThread().getId());

        UserWebApi userWebApi = new UserWebApi(apiCaller);

        UserRequest userRequest = new UserRequest("morpheus", "leader");
        UserResponse userResponse = userWebApi.createUser(userRequest);

        Assert.assertEquals(userWebApi.getStatusCode(), 201);
        Assert.assertEquals(userResponse.getName(), userRequest.getName());
    }
}
