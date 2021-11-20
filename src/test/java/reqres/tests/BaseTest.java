package reqres.tests;

import org.testng.annotations.BeforeMethod;
import rest.assured.core.WebApiCaller;
import rest.assured.core.WebApiHeaderConfig;

import java.util.Map;

public class BaseTest {

    protected WebApiCaller apiCaller;
    private WebApiHeaderConfig headerConfig;

    @BeforeMethod
    public void setup() {
        headerConfig = new WebApiHeaderConfig();
        headerConfig.setHeader("Content-type", "application/json");
        apiCaller = new WebApiCaller("https://reqres.in", headerConfig.getHeaders());
    }

}
