package gowoTests.api.pojo.responses;

public class AuthResponseData {
    private String token;

    public String getToken() {
        return token;
    }

    public AuthResponseData(String token) {
        this.token = token;
    }

    public AuthResponseData() {
    }
}
