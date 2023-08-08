package com.gorest.constant;

import com.gorest.model.UserPojo;

public class EndPoints {
    public static final String GET_SINGLE_USER_BY_ID = "/users/{id}";
    public static final String GET_SINGLE_USER_BY_NAME = "/users/{name}";
    public static final String GET_USERS = "/users";
    public static final String UPDATE_USER_BY_ID = "/users/{id}";
    public static final String DELETE_USER_BY_ID = "/users/{id}";

    public static UserPojo getStudentPojo(String name, String email, String gender,
                                          String status) {
        UserPojo userPojo = new UserPojo();
        userPojo.setName(name);
        userPojo.setEmail(email);
        userPojo.setGender(gender);
        userPojo.setStatus(status);
        return userPojo;
    }
}
//4278902,