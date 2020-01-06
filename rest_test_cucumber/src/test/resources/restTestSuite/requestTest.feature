Feature: simpler REST request test
  as a REST client
  I want to perform simple get request
  so that I can get http returns


  @rest
  Scenario Outline: >>>http request for "<code>"
    Given a rest endpoint is up
    When the get request is sent to the endpoint for code "<code>"
    Then the http status return value is "<code>"
    And the http return message is "<message>"

    Examples: http returns
      | code | message     |
      | 200  | OK          |
      | 403  | Forbidden   |
      | 502  | Bad Gateway |
      | 418  | I'm a teapot|
