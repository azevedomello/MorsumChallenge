package com.jsonPlaceHolder.apis.apiFactory;

import io.restassured.response.Response;

import static com.jsonPlaceHolder.apis.apiFactory.SpecBuilders.getRequestSpecification;
import static com.jsonPlaceHolder.apis.apiFactory.SpecBuilders.getResponseSpecification;
import static io.restassured.RestAssured.given;

public class VerbsBuilders {
    public static Response post(String path,Object postsRequestBody) {
        return given(getRequestSpecification()).
                body(postsRequestBody).
                when().
                post(path).
                then().
                spec(getResponseSpecification()).
                extract().response();
    }
    public static Response get(String path) {
        return given(getRequestSpecification()).
                when().
                get(path).
                then().
                spec(getResponseSpecification()).
                extract().
                response();
    }
    public static Response put(String path, Object putRequestBody) {
        return given(getRequestSpecification()).
                body(putRequestBody).
                when().
                put(path).
                then().
                spec(getResponseSpecification()).
                extract().response();
    }
    public static Response patch(String path, Object patchRequestBody) {
        return given(getRequestSpecification()).
                body(patchRequestBody).
                when().
                patch(path).
                then().
                spec(getResponseSpecification()).
                extract().response();
    }
    public static Response delete(String path) {
        return given(getRequestSpecification()).
                when().
                delete(path).
                then().
                spec(getResponseSpecification()).
                extract().response();
    }
    public static Response delete() {
        return given(getRequestSpecification()).
                when().
                delete().
                then().
                spec(getResponseSpecification()).
                extract().response();
    }
}
