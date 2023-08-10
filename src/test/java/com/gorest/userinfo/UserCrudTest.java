package com.gorest.userinfo;

import com.gorest.constant.EndPoints;
import com.gorest.testbase.TestBase;
import com.gorest.usersteps.UserSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashMap;

import static org.hamcrest.Matchers.hasValue;

@RunWith(SerenityRunner.class)
public class UserCrudTest extends TestBase {
     static final String token= "bearer a62302ce309660f0d0138cd8f880202a930b67372ab17dd1b88e6ff9bd00dd1d";
    //"name": "{{user_name}}",
//"email": "{{user_email}}",
//"gender": "male",
//"status":active
    static String name="Hina";
    static String email="Hinadoshi123@gmail.com";
    static String gender="Female";
    static String status ="Active";
    static int userId;

    @Steps
    UserSteps userSteps;

    @Title("This will create a new user")
    @Test
    public void test001() {
        userSteps.createUserRecord(name,email,gender,status);

    }
    @Title("Verify if the student was added to the application")
    @Test
    public void test002(){
        HashMap<String,Object> userMap = (HashMap<String, Object>) userSteps.getSingleUser(userId);
        Assert.assertThat(userMap, hasValue(name));
        userId = (int) userMap.get("id");
    }

    @Test()
    public void test003(){
   //  userSteps.userRecordUpdate(int userId,S);
    }
    @Title("Delete the student and verify if the student is deleted!")
    @Test
    public void test004() {
        SerenityRest.given()
                .pathParam("UserID",userId)
                .when()
                .then()
                .statusCode(204);
        SerenityRest.given()
                .pathParam("UserID", userId)
                .when()
                .get(EndPoints.DELETE_USER_BY_ID)
                .then()
                .statusCode(404);
    }
}






