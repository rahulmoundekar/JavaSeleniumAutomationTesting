# Java Selenium Automation Testing

Selenium is the first thing that comes to mind when one is planning to automate the testing of web applications. Selenium Webdriver with Java, one needs to bring the different components together, to start coding.

Selenium is one of the automation testing tools which is an open source tool. Selenium automates web application. In this Free Selenium training tutorial, we cover all Selenium concepts (basic selenium scripts to advanced testing framework) in detail with easy to understand practical examples. This Selenium Tutorial is helpful for beginners to advanced level users who want to learn selenium or learn automation.

# What are the prerequisites?
- Knowledge on Manual Testing Concepts 
- Basic knowledge of Programming Language Core Java (Java basics and Object Oriented Programming OOPs)

# What is Software Testing?
Software testing is a process, to evaluate the functionality of a software application with an intent to find whether the developed software met the specified requirements or not and to identify the defects to ensure that the product is defect free in order to produce the quality product.

# When do you prefer Manual Testing over Automation Testing?
We prefer Manual Testing over Automation Testing in the following scenarios

- When the project is in initial development stage.
- When testing user interface especially their visual aspects.
- When exploratory or adhoc testing needs to be performed.
- If the project is a short term and writing scripts will be time consuming when compared to manual testing
- If the test case is not automatable. Example captcha.

# What is Automation Testing?
Automation testing is the process of testing the software using an automation tools to find the defects. In this process, executing the test scripts and generating the results are performed automatically by automation tools. Some most popular tools to do automation testing are HP QTP/UFT, Selenium WebDriver, etc.,

# Selenium Introduction:
Selenium Introduction – It is an open source (free) automated testing suite to test web applications. It supports different platforms and browsers. It has gained a lot of popularity in terms of web-based automated testing and giving a great competition to the famous commercial tool HP QTP (Quick Test Professional) AKA HP UFT (Unified Functional Testing).

Selenium is a set of different software tools. Each tool has a different approach in supporting web based automation testing.

It has four components namely,
i. Selenium IDE (Integrated Development Environment)
ii. Selenium RC (Remote Control)
iii. Selenium WebDriver
iv. Selenium Grid

# What is Selenium WebDriver?
Selenium WebDriver AKA Selenium 2 is a browser automation framework that accepts commands and sends them to a browser. It is implemented through a browser-specific driver. It controls the browser by directly communicating with it. Selenium WebDriver supports Java, C#, PHP, Python, Perl, Ruby.

Operation System Support – Windows, Mac OS, Linux, Solaris
Browser Support – Mozilla Firefox, Internet Explorer, Google Chrome 12.0.712.0 and above, Safari, Opera 11.5 and above, Android, iOS, HtmlUnit 2.9 and above

# How To Download And Install Selenium WebDriver (2020)
https://www.softwaretestingmaterial.com/install-selenium-webdriver/

#### In the first Selenium WebDriver Script, let’s see the below mentioned sceanario using Selenium WebDriver.

#### Scenario:
To open appropriate URL and verify the title of the home page

Steps:
i. Open Firefox browser
ii. Go to the specified URL
iii. Verify the title and print the output of the title
iv. Close the Firefox browser

# Locators in Selenium WebDriver
Selenium identifies the elements to be worked on using the following locators.

##### Different types of Locators in Selenium are as follows:
i. ID
ii. Name
iii. Class Name
iv. Tag Name
v. Link Text & Partial Link Text
vi. CSS Selector
vii. XPath

Locating elements in WebDriver is done by using the method 
  ```
  “findElement(By.locator())“.
  ```
