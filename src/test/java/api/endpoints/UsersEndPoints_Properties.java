package api.endpoints;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


import java.util.Enumeration;
import java.util.ResourceBundle;

import static io.restassured.RestAssured.given;

public class UsersEndPoints_Properties {

    //Read properties file

    public static ResourceBundle routes=ResourceBundle.getBundle("routes");


    public static Response createUser(User payload){
        Response response=given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
        .when()
                .post(routes.getString("post_url"));

        return response;

    }

    public static Response getUser(String userName){
        Response response=given()

                .pathParam("username",userName)
                .when()
                .get(routes.getString("get_url"));

        return response;

    }

    public static Response putUser(User payload, String userName){
        Response response=given()
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .body(payload)
                    .pathParam("username",userName)
                .when()
                    .put(routes.getString("put_url"));

        return response;

    }

    public static Response deleteUser(String userName){
        Response response=given()

                    .pathParam("username",userName)
                .when()
                    .delete(routes.getString("delete_url"));

        return response;

    }
}
