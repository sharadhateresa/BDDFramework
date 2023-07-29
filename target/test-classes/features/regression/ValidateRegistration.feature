Feature: To validate Registration

@wip2907
Scenario: To validate registration with valid data

Given user starts "chrome" browser
And user launch app using url "https://adactinhotelapp.com/"
When user clicks linktext using xpath "//a[text()='New User Register Here']"
Then user validates URL to  be "https://adactinhotelapp.com/Register.php"
When user enters details in Registration form
| reyaz2907 | reyaz123 | reyaz123 | reyaz S| abcd@gmail.com | reest |

@wip2907a
Scenario: To validate registration with valid data

Given user starts "chrome" browser
And user launch app using url "https://adactinhotelapp.com/"
When user clicks linktext using xpath "//a[text()='New User Register Here']"
Then user validates URL to  be "https://adactinhotelapp.com/Register.php"
When user enters details in Registration form2
| username | password |  confirm Password | full name | email address | captcha|
| reyaz2907 | reyaz123 | reyaz123 | reyaz S| abcd@gmail.com | reest |
