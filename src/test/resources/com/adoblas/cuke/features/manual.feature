Feature: Manual test scenarios for login, search and filtering functionality on amazon.

  ## LOGIN ##
  Scenario User login
    Given Amazon login page
    When I type <login> in login field
    And type <password> in password field
    Then a message with the following info <info> must be showed

  Examples:
    | login                   | password  | message                       |
    | u                       | correct   | invalid email or phone number |
    | 2                       | correct   | invalid email or phone number |
    | 馬                      | correct   | invalid email or phone number |
    | *****                   | correct   | invalid email or phone number |
    | a@aa.com                | correct   | invalid email                 |
    | aa@a.com                | correct   | invalid email                 |
    | too long email acount   | correct   | invalid email                 |
    | 6452154788              | correct   | Incorrect phone number        |
    | +8165144171             | correct   | Incorrect phone number        |
    | correct                 | incorrect | Incorrect password            |


    * correct value in password is the user real password


    ## SEARCH ##
  Scenario Search testing
    Given Amazon home page
    When I type <search> in search bar
    And press ENTER
    Then I should be able to get search result

  Examples:
    | search                   |
    | normal                   |
    | 2                        |
    | Ç                        |
    | %20                      |
    | 馬                       |
    | </span><span class="me"> |
    | too long search param    |



    ## FILTER ##
  Scenario Search testing category
    Given Amazon home page
    When I type <search> in search bar
    And the results are distributed in several categories
    Then I should be able to choose at least one of them by clicking on the category name
    And the list of results must be filtered by that category/categories

  Scenario Search testing delivery option
    Given Amazon home page
    When I type <search> in search bar
    And the results are divided by delivery option
    Then I should be able to choose one of them by clicking on the option name
    And the list of results must be filtered by that option

  Scenario Search testing brand
    Given Amazon home page
    When I type <search> in search bar
    And the results are divided in several brands
    Then I should be able to choose at least one of them by clicking on the brand name
    And the list of result must be filtered by that brand/brands


  Scenario Search testing customer review
    Given Amazon home page
    When I type <search> in search bar
    And the results are distributed in up to 5 stars (representing customer satisfaction)
    Then I should be able to choose one of them by clicking on the stars
    And the list of result must be filtered by that option

  Scenario Search testing new arrivals
    Given Amazon home page
    When I type <search> in search bar
    And the results are distributed in new arrivals category
    Then I should be able to choose one of them by clicking on the category name
    And the list of result must be filtered by that option

  Scenario Search testing price
    Given Amazon home page
    When I type <search> in search bar
    And the results are divided in price categories
    Then I should be able to choose one of them by clicking on the price range
    And the list of result must be filtered by that range

  Scenario Search testing custom price
    Given Amazon home page
    When I type <search> in search bar
    And the results are shown
    Then I should be able insert a low and a top range price
    And the list of results must be filtered by that range

  Scenario Search testing sellers
    Given Amazon home page
    When I type <search> in search bar
    And the results are distributed in several sellers
    Then I should be able to choose at least one of them by clicking on the seller name
    And the list of result must be filtered by that seller/sellers