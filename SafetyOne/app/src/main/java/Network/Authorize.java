package Network;

import com.google.gson.annotations.SerializedName;

public class Authorize {

    @SerializedName("access_token")
    private String accessToken;

    @SerializedName("token_type")
    private String tokenType;

    @SerializedName("expires_in")
    private String expiration;

    @SerializedName("refresh_token")
    private String refreshToken;

    @SerializedName("id_token")
    private String idToken;

    public Authorize(String accessToken, String tokenType,
                     String expiration, String refresh_token, String idToken)
    {
        this.accessToken = accessToken;
        this.tokenType = tokenType;
        this.expiration = expiration;
        this.refreshToken = refresh_token;
        this.idToken = idToken;
    }

    public String getAccessToken()
    {
        return this.accessToken;
    }

    public String getExpiration()
    {
        return this.expiration;
    }

    public String getRefresh_token()
    {
        return this.refreshToken;
    }

    public String getIdToken()
    {
        return this.idToken;
    }
}
