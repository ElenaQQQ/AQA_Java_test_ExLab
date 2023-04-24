# AQA_Java_test_ExLab
UI testing of ExLab project - landing page https://exlab.team/
Stack: Java, Selenium WebDriver, Maven, TestNG, Allure, Jenkins

Testing functionality:
- presence of elements
- links work correctly
`
Using:
- PageObject model
- Data Provider
- Launch with .xml file
- Xpath and CSS locators
- headless mode for webdriver
- Annotations @BeforeGroups, @BeforeMethod, @AfterGroups, @AfterMethod`

Classes:
Driver - driver settings (Chrome browser)
utils/Config - values for setting test environment
pageObject/BasePage - basic methods
pageObject/LandingPage - locators, page methods
test/ExLabLandingTests - tests for landing page with Before and After annotations

--------------------------------------------------------------------------------------------------------- 
