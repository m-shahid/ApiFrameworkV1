package rest.assured.core;

import contracts.ApiRequest;

import java.util.HashMap;
import java.util.Map;

public class WebApiRequest<TRequest> implements ApiRequest<TRequest> {

    private String route;
    private Map<String, String> headers;
    private Map<String, String> queryStrings;
    private TRequest body;

    public WebApiRequest(){
        headers = new HashMap<>();
        queryStrings = new HashMap<>();
    }

    public WebApiRequest(String route){
        this();
        setRoute(route);
    }

    public WebApiRequest(String route, TRequest body){
        this(route);
        setBody(body);
    }

    public WebApiRequest(String route, TRequest body, Map<String, String> headers){
        this(route, body);
        headers.forEach(this::addHeader);
    }

    public WebApiRequest(String route, TRequest body, Map<String, String> headers, Map<String, String> queryStrings){
        this(route, body, headers);
        queryStrings.forEach(this::addQueryString);
    }

    @Override
    public Map<String, String> getHeaders() {
        return headers;
    }

    @Override
    public Map<String, String> getQueryStrings() {
        return queryStrings;
    }

    @Override
    public String getRoute() {
        return route;
    }

    @Override
    public TRequest getBody() {
        return body;
    }

    @Override
    public ApiRequest setRoute(String route) {
        this.route = route;
        return this;
    }

    @Override
    public ApiRequest addHeader(String name, String value) {
        headers.put(name, value);
        return this;
    }

    @Override
    public ApiRequest addQueryString(String key, String value) {
        queryStrings.put(key, value);
        return this;
    }

    @Override
    public ApiRequest setBody(TRequest body) {
        this.body = body;
        return this;
    }

}
