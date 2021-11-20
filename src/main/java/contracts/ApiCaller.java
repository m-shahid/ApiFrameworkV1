package contracts;

public interface ApiCaller {
    <TRq> ApiResponse execute(HttpMethod method, ApiRequest<TRq> request);
}
