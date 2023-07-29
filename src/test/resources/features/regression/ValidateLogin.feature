Feature: To validate Login in Orange HRM 

@smoke @regression
Scenario: To validate login using valid credentials

Given user starts "chrome" browser
And user launch app using url "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
When user enters text "Admin" using xpath "//input[@name='username']"
And user enters text "admin123" using xpath "//input[@name='password']"
And user clicks button using xpath "//button[@type='submit']"
Then user validates URL to  be "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index"


@regression
Scenario Outline: To validate login using Invalid credentials

Given user starts "chrome" browser
And user launch app using url "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
When user enters text '<username>' using xpath "//input[@name='username']"
And user enters text '<password>' using xpath "//input[@name='password']"
And user clicks button using xpath "//button[@type='submit']"
Then user validates URL to  be '<expectedURL>'

Examples:
| username | password | expectedURL |
| admin	| admin456 | https://opensource-demo.orangehrmlive.com/web/index.php/auth/login |
| admin777 | admin123 | https://opensource-demo.orangehrmlive.com/web/index.php/auth/login |
| admin777	| amdin456 | https://opensource-demo.orangehrmlive.com/web/index.php/auth/login |


