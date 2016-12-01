BDD Cucumber Selenium Webdriver Java Test Automation Framework
==============================================================

This project is an adaptation of a template test automation framework, which provides structured and standard way of 
creating automated test scripts for GUI, Mobile and API level tests across projects.

This framework supports automation of : 
- Web Browsers (Firefox, Chrome, Internet Explorer, Safari)
- Web Browser Responsive Design with view ports configuration


By default, running the tests will open a **chromedriver** instance. (which is located in the project base dir.)

Tools & libraries
=================
The test automation framework is comprised of following tools and libraries  

- Cucumber-JVM:- BDD Framework  
- Selenium WebDriver: - Browser automation framework
- TestNg: - TestNg Java testing framework  
- Maven: - Build tool  
- Spring: - Standard Dependency Injection     
- AssertJ: - Matcher's


Framework Setup steps
============================
There are two profiles preconfigured in order to run the different scenarios. 

**-Pweb** and **-Papi**


Information about profiles can be found in "pom.xml": 

        <profile>
            <id>api</id>
            <properties>
                <testToRun>stepDefintions/RunCukeTestApi.java</testToRun>
            </properties>
        </profile>


Compile, Build or Run Tests
===========================

To clean and compile the build
------------------------------

```
$ mvn clean install -DskipTests 
```

To run web tests
----------------

Before running web tests, chromedriver instance must have execution permission.
```
$ chmod +x chromedriver
```

```
$ mvn clean install -Pweb
```

- Use "mvn test -Dbrowser=browser_name" to run features on specific browser.
- browser_name can be one of following but make sure that browsers driver file are present and specified in system variable.
-- ff
-- chrome
-- ie
-- safari

To run api tests
----------------

```
$ mvn clean install -Papi
```



