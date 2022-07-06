Feature: Examples for DataTable

  # DataTable-List
  Scenario: Menu Options for driver
    Given user is on the login page
    When user enters the "driver" information
    Then user should be able to see following modules
      | Fleet      |
      | Customers  |
      | Activities |
      | System     |


        # DataTable-List
  Scenario: Menu Options for salesmanager
    Given user is on the login page
    When user enters the "sales manager" information
    Then user should be able to see following modules
      | Dashboards         |
      | Fleet              |
      | Customers          |
      | Sales              |
      | Activities         |
      | Marketing          |
      | Reports & Segments |
      | System             |


  @wip
  Scenario: Login with given information
    Given user is on the login page
    When user enters below credentials
      | username | user10      |
      | password | UserUser123 |
    Then user should be able to see folllowing information
      | firstname | John |
      | lastname  | Doe  |


# DataTable - ListOfMap
  Scenario: verify each product price
    Given User is on the HomePage
    Then User should be able to see expected prices in following products
      | Category | Product           | expectedPrice |
      | Phones   | Samsung galaxy s6 | 360           |
      | Phones   | Nokia lumia 1520  | 820           |
      | Phones   | Nexus 6           | 650           |
      | Laptops  | Sony vaio i5      | 790           |
      | Laptops  | Sony vaio i7      | 790           |
      | Laptops  | MacBook air       | 700           |
      | Monitors | Apple monitor 24  | 400           |
      | Monitors | ASUS Full HD      | 230           |





  Scenario: verify each product price listOfList
    Given User is on the HomePage
    Then User should be able to see expected prices in following products with listOflist
      | Phones    | Samsung galaxy s6 | 360           |
      | Phones    | Nokia lumia 1520  | 820           |
      | Phones    | Nexus 6           | 650           |
      | Laptops   | Sony vaio i5      | 790           |
      | Laptops   | Sony vaio i7      | 790           |
      | Laptops   | MacBook air       | 700           |
      | Monitors  | Apple monitor 24  | 400           |
      | Monitors  | ASUS Full HD      | 230           |