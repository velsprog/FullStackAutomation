Feature: Account Feature

Scenario Outline: Create Account Functionality

Given Enter Username as <username>
And Enter Password as <password>
And Click Login Button
And Click ToggleMenu
And Click ViewAll Button
And Enter Search Key
And Click Sales
And Click Accounts Tab

When Click New Button
And Enter Account Name as <accountname>
And Select Ownership as <ownership>
And Click Save
Then Verify Accont is created with Account Name <accountname>

Examples:
|username                |password         |accountname    |ownership    |
|"fullstack@testleaf.com"|"SelBootcamp$123"|"David William"|"Public"     |
|"fullstack@testleaf.com"|"SelBootcamp$123"|"Frank Jones"  |"Private"    |
|"fullstack@testleaf.com"|"SelBootcamp$123"|"Chris Kong"   |"Subsidiary" |

