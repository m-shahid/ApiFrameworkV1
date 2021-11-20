package reqres.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import reqres.entities.contracts.register.RegisterRequest;
import reqres.entities.contracts.register.RegisterResponse;
import reqres.entities.contracts.user.UserRequest;
import reqres.entities.contracts.user.UserResponse;
import reqres.webapis.RegisterWebApi;
import reqres.webapis.UserWebApi;

public class RegisterTest extends BaseTest{

    @Test
    public void validateRegisterSuccessful() {
        System.out.println("================== Starting Test ====================");
        System.out.println("Current Thread : " + Thread.currentThread().getId());

        RegisterWebApi registerWebApi = new RegisterWebApi(apiCaller);

        RegisterRequest registerRequest = new RegisterRequest("eve.holt@reqres.in", "pistol");
        RegisterResponse registerResponse = registerWebApi.register(registerRequest);

        Assert.assertEquals(registerWebApi.getStatusCode(), 200);
        Assert.assertNotEquals(registerResponse.getId(), 0);
        Assert.assertNotEquals(registerResponse.getToken(), "");
    }

    @Test
    public void validateRegisterUnSuccessful() {
        System.out.println("================== Starting Test ====================");
        System.out.println("Current Thread : " + Thread.currentThread().getId());

        RegisterWebApi registerWebApi = new RegisterWebApi(apiCaller);

        RegisterRequest registerRequest = new RegisterRequest("eve.holt@reqres.in", null);
        RegisterResponse registerResponse = registerWebApi.register(registerRequest);

        Assert.assertEquals(registerWebApi.getStatusCode(), 400);
        Assert.assertEquals(registerResponse.getError(), "Missing password");
    }
}
