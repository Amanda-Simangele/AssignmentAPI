package Tests;

import RequestBuilder.ResReqRequestBuilder;
import org.testng.annotations.Test;

public class ResReqTest {

    @Test
    public void getReqResUersList(){
        ResReqRequestBuilder.getReqResUersList()
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8");
    }
    @Test
    public void getReqResUser() {
        ResReqRequestBuilder.getReqResUser()
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8");
    }

}
