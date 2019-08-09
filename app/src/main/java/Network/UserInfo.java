package Network;

import com.google.gson.annotations.SerializedName;

public class UserInfo
{

    @SerializedName("identity")
    private Identity identity;
    @SerializedName("iat")
    private long iat;
    @SerializedName("iss")
    private String iss;
    @SerializedName("aud")
    private String aud;
    @SerializedName("sub")
    private String sub;

    public UserInfo(Identity identity, long iat, String iss, String aud, String sub)
    {
        this.identity = identity;
        this.iat = iat;
        this.iss = iss;
        this.aud = aud;
        this.sub = sub;
    }


    private class Identity
    {
        @SerializedName("full_name")
        private String full_name;
        @SerializedName("address")
        private Address address;
        @SerializedName("date_of_birth")
        private String dateOfBirth;
        @SerializedName("email")
        private String email;
        @SerializedName("phone")
        private String phone;

        public Identity(String full_name, Address address,
                        String dateOfBirth, String email, String phone)
        {
            this.full_name = full_name;
            this.address = address;
            this.dateOfBirth = dateOfBirth;
            this.email = email;
            this.phone = phone;
        }


        private class Address {
            @SerializedName("address_line1")
            private String address_line1;
            @SerializedName("address_line2")
            private String address_line2;
            @SerializedName("city")
            private String city;
            @SerializedName("state_code")
            private String stateCode;
            @SerializedName("postal_code")
            private String postalCode;
            @SerializedName("country_code")
            private String countryCode;

            public Address(String address_line1, String address_line2,
                           String city, String stateCode, String postalCode, String countryCode)
            {
                this.address_line1 = address_line1;
                this.address_line2 = address_line2;
                this.city = city;
                this.stateCode = stateCode;
                this.postalCode = postalCode;
                this.countryCode = countryCode;
            }
        }
    }
}
