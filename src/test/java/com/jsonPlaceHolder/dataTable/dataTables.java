package com.jsonPlaceHolder.dataTable;

import com.jsonPlaceHolder.apis.pojo.Posts;
import io.cucumber.java.DataTableType;

import java.util.List;
import java.util.Map;

import static com.jsonPlaceHolder.utils.util.removeCommas;
import static java.lang.Integer.parseInt;

public class dataTables {
    @DataTableType
    public static Posts parseDataTableToObject(Map<String, String> dataObject) {
        Posts post = new Posts();
        boolean hastID = dataObject.containsKey("id");
        boolean hastUserID = dataObject.containsKey("userId");
        boolean hastTitle = dataObject.containsKey("title");
        boolean hastBody = dataObject.containsKey("body");

        if(hastID){
            int id =  parseInt(removeCommas(dataObject.get("id")));
            post.setId(id);
        }
        if(hastUserID){
            int userID =  parseInt(removeCommas(dataObject.get("userId")));
            post.setUserId(userID);
        }
        if(hastTitle){
            String title = dataObject.get("title");
            post.setTitle(title);
        }
        if(hastBody){
            String body = dataObject.get("body");
            post.setBody(body);
        }
        return post;
    }
}

