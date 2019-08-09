package Network;

import java.util.List;

import retrofit2.Call;

import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface CapitalOneSignUpService {
    String baseUrl = "api-sandbox.capitalone.com";

    @GET("developer-platform/key-management/clients/{clientId}/key")
    Call<String> registerRSAKey(@Path("clientId") String clientId);

    @GET("identity/signup/tools/web-button")
    Call<String> getSignUpButton();

    @GET("oauth2/authorize")
    Call<Authorize> authorize();

    @POST("oauth2/token")
    Call<List<AccessToken>> getTokens();

    @GET("oauth2/userinfo")
    Call<UserInfo> getUserInfo();

    @GET("developer-platform/key-management/certificates/keys/{keyId}")
    Call<String> getPublicRSAKey(@Path("keyId") String clientId);
}
