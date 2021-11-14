Feature: Task Feature for Chrome

@Functional @Smoke @SIT @UAT
Scenario Outline: Edit Task

Given Enter Username as "<username>"
And Enter Password as "<password>"
And Click Login Button
And Click ToggleMenu
And Click ViewAll Button
And Click Content Tab
And Click ViewAll under Todays Task

When Enter Search Key as "<subject>"
And Click the "<subject>" for Edit Task
And Select Month as "<month>" and date as "<date>"
And I select RelatedTo Dropdown as "<relatedtodropdown>" 
And I select the existing "<accountname>" from dropdown
And Click Save in Task Page

Then Verify "<subject>" is displaying in EditToastMessage





Examples:
|username              |password       |subject|month   |date|relatedtodropdown|accountname|
|fullstack@testleaf.com|SelBootcamp$123|Email  |December|18  |Accounts         |Chris Kong |


