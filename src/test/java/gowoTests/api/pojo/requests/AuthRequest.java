package gowoTests.api.pojo.requests;

public class AuthRequest {
    private String emailOrPhone;
    private String password;

    public AuthRequest(String emailOrPhone, String password) {
        this.emailOrPhone = emailOrPhone;
        this.password = password;
    }

    public String getEmailOrPhone() {
        return emailOrPhone;
    }

    public String getPassword() {
        return password;
    }
}
