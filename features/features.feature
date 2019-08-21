
@bitrix24

Feature:As a user I should be able to create a task from activity stream


  Background:
  Given Login with valid "help desk"  on landing page
    When click on task
    And write "image check" into todo box


@verify_creation
  Scenario: Verify that user can create new task by clicking on tasks onactivity stream
      Then click on send
      And go to "Task" module under activity stream
      Then user verifies "sample" been created


    @deadline
Scenario: Verify that user should be able to set up a deadline for new task
      Then user click on deadline box
      And user select 28
    Then user click on select button
      Then click on send
      And go to "Task" module under activity stream
      And user select "sample"
      Then user verifies new task has deadline

      @uploadFile
      Scenario: Verify that user can upload a file and image or link or add checklist regarding to new task.
        Then user click on upload "file" button
        And user upload "C:\Users\ademo\Desktop\FirstTask.jpg"file
        Then click on send
        And go to "Task" module under activity stream
        And user select "image check"
        Then  verify image is available




