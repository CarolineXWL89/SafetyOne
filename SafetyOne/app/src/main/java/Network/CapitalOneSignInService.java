package Network;

import java.util.List;

import retrofit2.Call;

import retrofit2.http.GET;

public interface CapitalOneSignInService {
    String baseUrl = "api-sandbox.capitalone.com";

    @GET("identity/signin/tools/web-button")
    Call<String> getSignInButton();

    @GET("oauth2/token")
    Call<List<AccessToken>> getTokens();
}
