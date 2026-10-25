package api.testcases;

import api.endpoints.UsersEndPoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DataDrivenTests {

    @Test(priority = 1,dataProvider = "Data",dataProviderClass = DataProviders.class)
    public void testPostMethodDDT(String UserId,String	UserName,String	FirstName,String LastName,String Email,String Password,String Phone){

        User userPayload=new User();

        userPayload.setId(Integer.parseInt(UserId));
        userPayload.setUsername(UserName);
        userPayload.setFirstName(FirstName);
        userPayload.setLastName(LastName);
        userPayload.setEmail(Email);
        userPayload.setPassword(Password);
        userPayload.setPhone(Phone);

        Response response= UsersEndPoints.createUser(userPayload);
        response.then().log().body();
        Assert.assertEquals(response.getStatusCode(),200);
    }

    @Test(priority = 2,dataProvider = "UserNames",dataProviderClass = DataProviders.class)
    public void testGETMethodDDT(String	UserName){

        Response response= UsersEndPoints.getUser(UserName);
        response.then().log().body();
        Assert.assertEquals(response.getStatusCode(),200);
    }

    @Test(priority = 3,dataProvider = "UserNames",dataProviderClass = DataProviders.class)
    public void testDeleteMethodDDT(String	UserName){

        Response response= UsersEndPoints.deleteUser(UserName);
        response.then().log().body();
        Assert.assertEquals(response.getStatusCode(),200);
    }
}
