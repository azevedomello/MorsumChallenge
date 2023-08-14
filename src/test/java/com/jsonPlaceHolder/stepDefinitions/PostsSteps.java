package com.jsonPlaceHolder.stepDefinitions;

import com.jsonPlaceHolder.constants.Constants.*;
import com.jsonPlaceHolder.apis.apiFactory.aplicationApis.PostsApis;
import com.jsonPlaceHolder.apis.pojo.Posts;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import java.util.List;
import java.util.Map;
import static com.jsonPlaceHolder.apis.tests.support.PostsSupportClass.*;
import static com.jsonPlaceHolder.dataTable.dataTables.parseDataTableToObject;
import static java.lang.Integer.parseInt;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class PostsSteps {
    List<Posts> postsResponseList;
    String response;
    Response rawResponse;
    int amountOfPosts;
    boolean hasIDFilled = false;
    int statusCode;
    int postID;
    Posts existentPost;
    Posts postsTestsRequestBody;
    Methods methods;

    @Given("I get the amount of existing posts from database")
    public void iGetTheAmountOfExistingPostsFromDatabase() {
        amountOfPosts = getAmountOfPosts();
    }

    @When("I send a PUT request to the endpoint POST with data")
    public void iSendAPUTRequestToTheEndpointPOSTWithData(Map<String, String> dataTable) {
        methods = Methods.PUT;
        postsTestsRequestBody = parseDataTableToObject(dataTable);
        rawResponse = PostsApis.put(postsTestsRequestBody.getId(), postsTestsRequestBody);
    }

    @When("I send a DELETE request to the endpoint POST with id {string}")
    public void iSendADeleteRequestToTheEndpointPOSTWithIdId(String id) {
        methods = Methods.DELETE;
        hasIDFilled = !(id.equals("null"));
        if (hasIDFilled) {
            postID = parseInt(id);
        }
        rawResponse = (hasIDFilled) ? PostsApis.delete(postID):PostsApis.delete();
    }

    @When("I send a GET request to the endpoint POST with id {string}")
    public void iSendAGETRequestToTheEndpointPOSTWithIdId(String id) {
        methods = Methods.GET;
        hasIDFilled = !(id.equals("null"));
        if (hasIDFilled) {
            postID = parseInt(id);
        }
        rawResponse = (hasIDFilled) ? PostsApis.get(postID) : PostsApis.get();
    }

    @When("I send a POST request to the endpoint POST with data")
    public void iSendAPOSTRequestToTheEndpointPOSTWithData(Map<String, String> dataTable) {
        methods = Methods.POST;
        postID = getAmountOfPosts() + 1;
        postsTestsRequestBody = parseDataTableToObject(dataTable);

        rawResponse = PostsApis.post(postsTestsRequestBody);
        postsTestsRequestBody.setId(postID);
    }

    @When("I send a Patch request to change property {string} to the value {string} for user {string}")
    public void iSendAPatchRequestToChangePropertyToTheValueForUser(String property, String value, String id) {
        methods = Methods.PATCH;
        postID = parseInt(id);
        postsTestsRequestBody = new Posts();

        if (property.equals("title")) {
            postsTestsRequestBody.setTitle(value);
        } else {
            postsTestsRequestBody.setBody(value);
        }

        rawResponse = PostsApis.patch(postID, postsTestsRequestBody);
    }

    @Then("the response status should be {int}")
    public void theResponseStatusShouldBe(Integer expectedStatusCode) {
        statusCode = expectedStatusCode;
        assertPostsStatusCode(rawResponse, expectedStatusCode);
    }

    @And("the response body should contain a list with an amount of {int} records.")
    public void theResponseBodyShouldContainAListWithAnAmountOfExpected_amountRecords(Integer amount) {
        response = rawResponse.asString();
        postsResponseList = parsePostResponseToList(response);

        assertThat(postsResponseList, notNullValue());
        assertThat(postsResponseList, Matchers.hasSize(amount));
    }

    @And("the API should respond in less than {int} seconds")
    public void theAPIShouldRespondInLessThanSeconds(Integer time) {
        assertThat(rawResponse.time(), lessThan((long) time));
    }

    @And("the response body should have the expected result")
    public void theResponseBodyShouldHaveTheExpectedResult(Map<String, String> dataTable) {
        boolean isTableEmpty = dataTable.isEmpty();

        if (isTableEmpty||statusCode == 404) {
            assertThat(rawResponse.body().asString(), equalTo("{}"));
        } else {
            Posts expectedPostData = parseDataTableToObject(dataTable);
            assertPosts(rawResponse.as(Posts.class), expectedPostData);
        }
    }

    @And("I see that the initial number of posts is the same as the number after execution")
    public void ISeeThatTheInitialNumberOfPostsIsTheSameAsTheNumberAfterExecution() {
        assertThat(amountOfPosts, equalTo(getAmountOfPosts()));
    }

    @And("I see that the amount after execution is less than the previous one")
    public void iSeeThatTheAmountAfterExecutionIsLessThanThePreviousOne() {
        assertThat(amountOfPosts, lessThan(getAmountOfPosts()));
    }
}
