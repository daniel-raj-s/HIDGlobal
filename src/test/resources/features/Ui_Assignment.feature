@UI_Assignment
Feature: Assignment1

  Background: 
    Given User Navigates to "https:legacy.reactjs.org"

  @Assignment1
  Scenario Outline: Highlight Subelements and Links
    Given User clicks on Docs tab
    And Expand "<sectionName>" section
    Then Hightlight all sub element under "<sectionName>"
    And Store sub elements of "<sectionName>" text and links into file
    
    Examples: 
      | sectionName     |
      | Main Concepts   |
      | Advanced Guides |

  @Assignment2
  Scenario: Verify scroll functionality and content changes
    When User clicks on the Tutorial tab
    Then User scrolls down the page
    And User verifies the respected content is bolded on the right navigation
    And User verifies the blue color line is seen
