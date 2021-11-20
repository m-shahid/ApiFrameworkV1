package contracts;

import java.util.Map;

public interface ApiRequest<TRequest> {

    Map<String, String> getHeaders();
    Map<String, String> getQueryStrings();
    String getRoute();
    TRequest getBody();

    ApiRequest setRoute(String route);
    ApiRequest addHeader(String name, String value);
    ApiRequest addQueryString(String key, String value);
    ApiRequest setBody(TRequest body);
}
