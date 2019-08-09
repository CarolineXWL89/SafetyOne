package Network;

import com.google.gson.annotations.SerializedName;

public class AccessToken {
    @SerializedName("access_token")
    private String accessToken;

    public AccessToken(String accessToken)
    {
        this.accessToken = accessToken;
    }
}
