package com.jsonPlaceHolder.apis.pojo;

        import java.util.LinkedHashMap;
        import java.util.Map;
        import javax.annotation.Generated;

        import com.fasterxml.jackson.annotation.JsonIgnore;
        import com.fasterxml.jackson.annotation.JsonInclude;
        import com.fasterxml.jackson.annotation.JsonProperty;
        import com.fasterxml.jackson.annotation.JsonPropertyOrder;
        import lombok.Getter;
        import lombok.Setter;

        import static org.hamcrest.MatcherAssert.assertThat;

@Getter @Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "userId",
        "id",
        "title",
        "body"
})
@Generated("jsonschema2pojo")
public class Posts {

    @JsonProperty("userId")
    private Integer userId;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("title")
    private String title;
    @JsonProperty("body")
    private String body;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();
}
