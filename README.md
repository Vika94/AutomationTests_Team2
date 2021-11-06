# AutomationTests_Team2

Requirements
-------------
* Java version >= 8
* Maven
* Selenide + TestNG
* Realization PageObject pattern
* Building the project through mvn + testng.xml
-------------

Running tests
-------------


1. Clone the project
   git clone https://github.com/AzarovaLena/AutomationTests_Team2.git 
or 
git clone https://github.com/Vika94/AutomationTests_Team2.git
2. After cloning the project add to .gitignore next folder:

* .idea
* /build/
*  /allure-results/
*  /target/
3. Checkout to the  test branch

4. Run tests with testng.xml:
* go to Run configuration
* click Edit configuration
* add TestNG
* in the field Test kind select Suite
* select path for Suite (xml files are located in /test/resources/name.xml)
* click apply then ok
5. Run tests with maven:
* command to running testng.xml file:
   mvn clean test -Dsuite="src/test/resources/tests.xml"

(this command runs tests.xml, required configurations are written in pom.xml)

----------------


Writing tests
-------------


1) Create new java class in src/main/java/pageObject folder or use existing one

2) Write logics your test to created class

Example class: src/main/java/pageObject/BasketPage.java

3) Create new java class in src/test/java folder or use existing one
4) Write realization your test to created class
5) Create file.xml in src/test/resources and create suite your tests in this file or use existing one

---------------------
Driver implementation
-------------
Driver implemented in src/main/java/baseTest  

* SelenideConfigurations - contains configurations browserSize, headless ,baseUrl,timeout, pageLoadTimeout
* BaseTest - contains method get which run driver by selenide's methods open() or page() 
* Listener (src/main/java/testngConfig/Listener.java) - contains a method for a screenshot on failed tests 
and a method that runs all configurations description in SelenideConfigurations
* properties (src/main/resources/onliner.properties) - contains configurations with value

--------------------- 


Reporters:
-------------
Allure
* use the command '_allure generate_' to generate a report
* use the command '_allure open_' to open a report


