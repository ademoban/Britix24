Feature:As a user I should be able to create a task from activity stream
  Background:
  Given Login with valid "help desk"  on landing page
    When click on task
    And write "final task8" into todo box
@verify_creation
  Scenario: Verify that user can create new task by clicking on tasks onactivity stream
      Then click on send
      And go to "Task" module under activity stream
      Then user verifies "new task topic" been created
    @deadline
Scenario: Verify that user should be able to set up a deadline for new task
      Then user click on deadline box
      And user select 26
    Then user click on select button
      Then click on send
      And go to "Task" module under activity stream
      And user select "final task8"
      Then user verifies new task has deadline



