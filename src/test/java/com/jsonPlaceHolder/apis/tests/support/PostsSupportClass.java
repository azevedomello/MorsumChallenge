package com.jsonPlaceHolder.apis.tests.support;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jsonPlaceHolder.apis.apiFactory.aplicationApis.PostsApis;
import com.jsonPlaceHolder.apis.pojo.Posts;
import io.restassured.response.Response;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class PostsSupportClass {
    private static Response rawResponse;
    private static String postResponse;

    public static int getAmountOfPosts() {
        rawResponse = PostsApis.get();
        assertThat(rawResponse.statusCode(), equalTo(200));

        postResponse = rawResponse.asString();
        return parsePostResponseToList(postResponse).size();
    }

    public static Posts getASpecificPost(int postId) {
        rawResponse = PostsApis.get(postId);
        assertThat(rawResponse.statusCode(), equalTo(200));
        return rawResponse.as(Posts.class);
    }

    public static List<Posts> parsePostResponseToList(String res) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(res, new TypeReference<>() {
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void assertPosts(Posts actualPosts, Posts expectedPosts) {
        assertThat(actualPosts.getId(), equalTo(expectedPosts.getId()));
        assertThat(actualPosts.getUserId(), equalTo(expectedPosts.getUserId()));
        assertThat(actualPosts.getTitle(), equalTo(expectedPosts.getTitle()));
        assertThat(actualPosts.getBody(), equalTo(expectedPosts.getBody()));
    }
    public static void assertPostsStatusCode(Response resp,int statusCode) {
        assertThat(resp.getStatusCode(),equalTo(statusCode));
    }
}