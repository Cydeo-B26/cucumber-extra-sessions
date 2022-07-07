Feature: Simple examples about Scenario Outline

  Scenario Outline: Menu Options for <userType>
    Given user is on the login page
    When user enters the "<userType>" information
    Then user should be able to see following modules
      | Dashboards         |
      | Fleet              |
      | Customers          |
      | Sales              |
      | Activities         |
      | Marketing          |
      | Reports & Segments |
      | System             |

    Examples:
      | userType      |
      | sales_manager |
      | store_manager |
      | sales_manager |
      | store_manager |


  @scenarioOutline
  Scenario Outline: Login with given information for <user>
    Given user is on the login page
    When user enters below credentials
      | username | <user>      |
      | password | UserUser123 |
    Then user should be able to see folllowing information
      | firstname | <firstName> |
      | lastname  | <lastName>  |

    Examples:
      | user           | firstName | lastName |
      | user10         | John      | Doe      |
      | storemanager85 | John      | Doe      |



