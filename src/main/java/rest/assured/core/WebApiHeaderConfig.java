package rest.assured.core;

import contracts.ApiHeaderConfig;

import java.util.HashMap;
import java.util.Map;

public class WebApiHeaderConfig implements ApiHeaderConfig {

    private Map<String, String> headers;

    public WebApiHeaderConfig() {
        headers = new HashMap<>();
    }

    @Override
    public Map<String, String> getHeaders() {
        return headers;
    }

    @Override
    public void setHeader(String name, String value) {
        headers.put(name, value);
    }
}
