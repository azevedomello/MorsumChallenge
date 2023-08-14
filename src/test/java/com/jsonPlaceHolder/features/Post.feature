Feature: Post Functionality
  As a Json Place holder user
  I want to be able to manage posts via API
  So that I can create a post, modify it, delete it, and search it.

 # @regression
  Scenario Outline: Validate Post Retrieval getting all data via API GET
    When I send a GET request to the endpoint POST with id <id>
    Then the response status should be <status>
    And the API should respond in less than <time> seconds
    And  the response body should contain a list with an amount of <expected_amount> records.

    Examples:
      | status | time  | expected_amount | id     |
      | 200    | 10000 | 100             | "null" |

  Scenario Outline: Validate the Retrieval for a specific post with id valid and invalid via API
    When I send a GET request to the endpoint POST with id <id>
    Then the response status should be <status>
    And the API should respond in less than <time> seconds
    And the response body should have the expected result
      | key    | value    |
      | id     | <id>     |
      | userId | <userId> |
      | title  | <title>  |
      | body   | <body>   |

    Examples:
      | status | time | userId | id    | title                                                                      | body                                                                                                                                                              |
      | 200    | 1000 | 1      | "1"   | sunt aut facere repellat provident occaecati excepturi optio reprehenderit | quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto |
      | 404    | 1000 | 1      | "999" | reprehenderi                                                               | testing                                                                                                                                                           |

  Scenario Outline: Validate the Creation of a new post via API
    When I send a POST request to the endpoint POST with data
      | key    | value    |
      | userId | <userId> |
      | title  | <title>  |
      | body   | <body>   |

    Then the response status should be <status>
    And the API should respond in less than <time> seconds
    And the response body should have the expected result
      | key    | value    |
      | userId | <userId> |
      | id     | <id>     |
      | title  | <title>  |
      | body   | <body>   |

    Examples:
      | status | time | userId | id    | title                       | body                                   |
      | 201    | 1000 | 10     | "101" | I think I am a Jedi...      | I tend to speak sentences backwards... |
      | 201    | 1000 | 1      | "101" | I think I am a chewbacca... | hummdkfhadshlfkdalsfj...               |

  Scenario Outline: validate existing post Updating via API
    Given I get the amount of existing posts from database
    When I send a PUT request to the endpoint POST with data
      | key    | value    |
      | userId | <userId> |
      | id     | <id>     |
      | title  | <title>  |
      | body   | <body>   |

    Then the response status should be <status>
    And the API should respond in less than <time> seconds
    And I see that the initial number of posts is the same as the number after execution
    And the response body should have the expected result
      | key    | value    |
      | userId | <userId> |
      | id     | <id>     |
      | title  | <title>  |
      | body   | <body>   |

    Examples:
      | status | time | userId | id  | title           | body                                     |
      | 200    | 1000 | 1      | "1" | Whats your name | I am an AI but you can call me... SkyNet |


  Scenario Outline: Validate the Update of a specific property an exist post via API
    When I send a Patch request to change property <property> to the value <value> for user <id>
    Then the response status should be <status>
    And the API should respond in less than <time> seconds
    And the response body should have the expected result
      | key    | value    |
      | userId | <userId> |
      | id     | <id>     |
      | title  | <title>  |
      | body   | <body>   |

    Examples:
      | status | time | property | value                                      | userId | id  | title                                                                      | body                                                                                                                                                              |
      | 200    | 2000 | "title"  | "great is your love for us"                | 1      | "1" | great is your love for us                                                  | quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto |
      | 200    | 1000 | "body"   | "You have never given up on anyone before" | 1      | "1" | sunt aut facere repellat provident occaecati excepturi optio reprehenderit | You have never given up on anyone before                                                                                                                          |

  Scenario Outline: Validate deletion of a specific existing post via API
    When I send a DELETE request to the endpoint POST with id <id>
    Then the response status should be <status>
    And the API should respond in less than <time> seconds
    And the response body should have the expected result
      | key | value |
      |     |       |

    Examples:
      | status | time | id     |
      | 200    | 2000 | "1"    |
      | 404    | 2000 | "null" |