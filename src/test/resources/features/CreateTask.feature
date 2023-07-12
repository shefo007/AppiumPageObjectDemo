Feature: Create New Task


  Scenario: The user can add new task
    Given Click Add new Task
    And Enter Task Name
    And  Enter Task Description
    When Click Save
    Then Task added successfully


  Scenario Outline: The user can add two new tasks
    Given Click Add new Task
    And Enter "<TaskName>" and "<TaskDesc>"
    When Click Save
    Then Task added successfully
    Examples:
      | TaskName | TaskDesc |
      | Cucumber Task 1 | Task 1 Details |
      | Cucumber Task 2 | Task 2 Details |