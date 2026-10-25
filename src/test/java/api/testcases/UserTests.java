package api.testcases;


import api.endpoints.UsersEndPoints;
import api.payload.User;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UserTests {

    Faker faker;
    User userPayload;
    //create data for payload

    String  username;
    String  firstName;
    String  lastName;
    String  email;
    String  password;
    String  phone;
    int userStatus;
    @BeforeTest
    void setUpPayLoad(){
        faker=new Faker();
        userPayload = new User();

        userPayload.setId(faker.idNumber().hashCode());
        userPayload.setUsername(faker.name().username());
        userPayload.setFirstName(faker.name().firstName());
        userPayload.setLastName(faker.name().lastName());
        userPayload.setEmail(faker.internet().emailAddress());
        userPayload.setPassword(faker.internet().password());
        userPayload.setPhone(faker.phoneNumber().cellPhone());
    }



    @Test(priority = 1)
    public void testPostMethod(){
        Response response=UsersEndPoints.createUser(userPayload);
        response.then().log().body();
        Assert.assertEquals(response.getStatusCode(),200);
    }

    @Test(priority = 2)
    public void testGetMethod(){
        Response response=UsersEndPoints.getUser(userPayload.getUsername());
        response.then().log().body();
        Assert.assertEquals(response.getStatusCode(),200);
    }


    @Test(priority = 3)
    public void testPutMethod(){
        userPayload.setFirstName(faker.name().firstName());
        userPayload.setLastName(faker.name().lastName());
        userPayload.setEmail(faker.internet().emailAddress());

        Response response=UsersEndPoints.putUser(userPayload,userPayload.getUsername());
        response.then().log().body();
        Assert.assertEquals(response.getStatusCode(),200);

        Response responseAfterUpdate=UsersEndPoints.getUser(userPayload.getUsername());
        responseAfterUpdate.then().log().body();
        Assert.assertEquals(responseAfterUpdate.getStatusCode(),200);
    }

    @Test(priority = 4)
    public void testDeleteMethod(){
        Response response=UsersEndPoints.deleteUser(this.userPayload.getUsername());
        response.then().log().body();
        Assert.assertEquals(response.getStatusCode(),200);
    }
}
