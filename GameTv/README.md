Automate the login scenario  for  GameTV via Twitter

IDE :  Eclipse

Build tool: Maven

Testing framework: TestNG

Language: Java

Automation Framework: Appium

Reporting tool: Extent  Report


Read Requirements.txt file for all pre-requisites

 Update global.properties file accordingly with  your deviceid and appium mainjs file path which will be there in node_modules folder (no need if you are running appium server manually)
 
 Comment out startserver from setup folder and service.stop in teardown functions in GameTvTest.java if you are running appium manually or if there is a problem in running server programmatically in your IDE.
 
 Execution Ways:
 cmd: mvn test
 
 IDE: Right click on project and run as TestNg suite
 
 html Report can be seen under Reports folder
 
 Note: App is not logging in as it gives page not found, so last test to verify home page will always fail (not able to get the locator as well)
