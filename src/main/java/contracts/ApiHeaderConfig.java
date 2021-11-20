package contracts;

import java.util.Map;

public interface ApiHeaderConfig {
    Map<String, String> getHeaders();
    void setHeader(String name, String value);
}
