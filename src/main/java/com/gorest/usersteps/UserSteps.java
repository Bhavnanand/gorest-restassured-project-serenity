package com.gorest.usersteps;

import com.gorest.constant.EndPoints;
import com.gorest.model.UserPojo;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class UserSteps {
    static final String token = "Bearer a62302ce309660f0d0138cd8f880202a930b67372ab17dd1b88e6ff9bd00dd1";

    @Step("Creating new user record with name: {0}, email: {1}, gender: {2} and status: {3}")
    public ValidatableResponse createUserRecord(String name, String email, String gender, String status) {
        UserPojo userPojo = new UserPojo();
        userPojo.setName(name);
        userPojo.setEmail(email);
        userPojo.setGender(gender);
        userPojo.setStatus(status);
        return SerenityRest.given().log().all()
                .header("Authorization", token)
                .header("Content-Type", "application/json")
                .header("Connection", "keep-alive")
                .body(userPojo)
                .when()
                .post("/users")
                .then().log().all().statusCode(201);
    }

    @Step("Getting all users records")
    public ValidatableResponse getUserIDs() {
        return SerenityRest.given().log().all()
                .header("Authorization", token)
                .header("Connection", "keep-alive")
                .when()
                .get(EndPoints.GET_USERS)
                .then().log().all().statusCode(200);
    }

   // @Step("Updating user record with id: {0}, name: {1}, email: {2}, gender: {3} and status: {4}")
   /* public void userRecordUpdate() {
        UserPojo userPojo = new UserPojo();
        userPojo.setName(name);
        userPojo.setEmail(email);
        userPojo.setGender(gender);
        userPojo.setStatus(status);
        SerenityRest.given().log().all()
                .header("Authorization", token)
                .header("Content-Type", "application/json")
                .header("Connection", "keep-alive")
                .pathParam("id", id)
                .body(userPojo)
                .when()
                .put(EndPoints.UPDATE_USER_BY_ID)
                .then().log().all().statusCode(200);
    }*/

    @Step("Getting single record with id: {0}")
    public ValidatableResponse getSingleUser(int id) {
        return SerenityRest.given().log().all()
                .header("Authorization", token)
                .header("Connection", "keep-alive")
                .pathParam("id", id)
                .when()
                .get(EndPoints.GET_SINGLE_USER_BY_ID)
                .then().log().all();
    }

    @Step("Deleting  user record with id: {0}")
    public ValidatableResponse deleteUserRecord(int id) {
        return SerenityRest.given().log().all()
                .header("Authorization", token)
                .header("Connection", "keep-alive")
                .pathParam("id", id)
                .when()
                .delete(EndPoints.DELETE_USER_BY_ID)
                .then().log().all();
    }
}
   /* public ValidatableResponse createUser(String name, String email, String gender, String status) {
        UserPojo userPojo = new UserPojo();
        userPojo.setName(name);
        userPojo.setEmail(email);
        userPojo.setGender(gender);
        userPojo.setStatus(status);
        return SerenityRest.given()
                .header(Ccontent-Type,application/JSON)
                .header("Connection","keep-alive")
            .body(userPojo)
                .post()
                .then();
    }

    public ValidatableResponse getUserInfoByName(String name) {
        String s1 = "findAll{it.name == '";
        String s2 = "'}.get(0)";
        return SerenityRest.given()
                .when()
                .get(EndPoints.GET_SINGLE_USER_BY_NAME)
                .then().statusCode(200)
                .extract()
                .path(s1 + name + s2);
    }

    @Step("Updating User Information with  UserId  :{0},nmae:{1},email:{2},gender:{3},status:{4}")
    public ValidatableResponse updateUser(int UserId, String name, String email, String gender, String status) {
        UserPojo userPojo = new UserPojo();
        userPojo.setName(name);
        userPojo.setEmail(email);
        userPojo.setGender(gender);
        userPojo.setStatus(status);
        return (ValidatableResponse) SerenityRest.given()
                .header("Authentication", token)
                .header("Content Type", "application/json")
                .pathParam("UserID", UserId)
                .then();
    }

    @Step("Updating student information with UserID: {0}, Name: {1}, email: {3},gender:{4},status:{5} ")
    public ValidatableResponse deleteUser(int UserId) {
        return SerenityRest.given()
                .pathParam("UserID", UserId)
                .when()
                .delete(EndPoints.DELETE_USER_BY_ID)
                .then();
    }

    @Step("Deleting user with UserId:{0}")

    public ValidatableResponse getStudentById() {
        return SerenityRest.given()
                //  .pathParam("studentID", studentId)
                .when()
                .get(EndPoints.GET_SINGLE_USER_BY_ID)
                .then();
    }

}
*/