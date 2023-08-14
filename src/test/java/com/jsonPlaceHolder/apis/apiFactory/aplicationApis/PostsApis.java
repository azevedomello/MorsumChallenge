package com.jsonPlaceHolder.apis.apiFactory.aplicationApis;

import com.jsonPlaceHolder.apis.apiFactory.VerbsBuilders;
import com.jsonPlaceHolder.apis.pojo.Posts;
import io.restassured.response.Response;
import static com.jsonPlaceHolder.constants.Constants.*;

public class PostsApis {

    public static Response post(Posts postsRequestBody) {
        return VerbsBuilders.post(POSTS_ROUTE,postsRequestBody);
    }
    public static Response get(int id) {
        return VerbsBuilders.get(POSTS_ROUTE + "/" +id);
    }
    public static Response get() {
        return VerbsBuilders.get(POSTS_ROUTE);
    }
    public static Response put(int id, Posts putRequestBody) {
        return VerbsBuilders.put(POSTS_ROUTE + "/" + id, putRequestBody);
    }
    public static Response patch(int id, Posts patchRequestBody) {
        return VerbsBuilders.patch(POSTS_ROUTE + "/" + id, patchRequestBody);
    }
    public static Response delete(int id) {
        return VerbsBuilders.delete(POSTS_ROUTE + "/" + id);
    }
    public static Response delete() {
        return VerbsBuilders.delete(POSTS_ROUTE);
    }
}
