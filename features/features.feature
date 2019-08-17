Feature:As a user I should be able to create a task from activity stream
  Background:
  Given Login with valid "marketing"  on landing page
    Scenario: Verify that user can create new task by clicking on tasks onactivity stream
      When click on task
      And write "new task topic" into todo box
      Then click on send
      And go to "Task" module under activity stream
      Then user verifies "new task topic" been created


