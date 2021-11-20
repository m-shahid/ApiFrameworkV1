package contracts;

public interface ApiResponse {
    int getStatusCode();
    <TRequest> TRequest getRequest();
    <TResponse> TResponse getResponse(Class<TResponse> bodyClassType);
}
