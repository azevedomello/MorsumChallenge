package com.jsonPlaceHolder.apis.apiFactory;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static com.jsonPlaceHolder.constants.Constants.URLBASE;

public class SpecBuilders {
    String token;

    public static RequestSpecification getRequestSpecification() {
        return new RequestSpecBuilder().
                setBaseUri(URLBASE).
                setContentType(ContentType.JSON).
                log(LogDetail.ALL).
                build();
    }

    public static ResponseSpecification getResponseSpecification() {
        return new ResponseSpecBuilder().
                expectContentType(ContentType.JSON).
                log(LogDetail.ALL)
                .build();
    }

}
