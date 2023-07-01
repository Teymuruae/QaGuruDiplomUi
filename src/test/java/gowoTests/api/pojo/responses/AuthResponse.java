package gowoTests.api.pojo.responses;

import java.util.ArrayList;

public class AuthResponse {

        private AuthResponseData data;
        private ArrayList<Object> pagination;

    public AuthResponse(AuthResponseData data, ArrayList<Object> pagination) {
        this.data = data;
        this.pagination = pagination;
    }

    public AuthResponse() {
    }

    public AuthResponseData getData() {
        return data;
    }

    public ArrayList<Object> getPagination() {
        return pagination;
    }
}
