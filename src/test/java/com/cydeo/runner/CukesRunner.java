package com.cydeo.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumber-report.html", //html report
                "me.jvt.cucumber.report.PrettyReports:target/cucumber",
                "json:target/cucumber.json"}, // cucumber report
        features = "src/test/resources/features" ,
        glue = "com/cydeo/steps",
         dryRun = false,
        tags = "@smoke"
)
public class CukesRunner {
}

/*
  ------- SAME BROWSER -----
Can we run this project in local parallelly ?

    -Surefire with parallel setup
            <configuration>
                    <parallel>methods</parallel>
                    <threadCount>4</threadCount>
                    <testFailureIgnore>true</testFailureIgnore>
                    <includes>
                      <include>/CukesRunner*.java</include>
                  </includes>
         </configuration>

     -DriverPool -->private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();


Can we run this project in jenkins ?
     - Yes
     - Do I need to change anything to run ?
        - No if you have previous setup it works


Can we run this project in grid parallelly ?

      - No, We can't

       Add following case to run it in grid parallely

            case "remote-chrome":
                    try {
                        // assign your grid server address
                        String gridAddress = "52.90.101.147";
                        URL url = new URL("http://"+ gridAddress + ":4444/wd/hub");
                        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                        desiredCapabilities.setBrowserName("chrome");
                        driverPool.set(new RemoteWebDriver(url, desiredCapabilities));
                        //driverPool.set(new RemoteWebDriver(new URL("http://0.0.0.0:4444/wd/hub"),desiredCapabilities));

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

         Change your config.properties browser to --> remote-chrome


    What if I wanna change it from maven ?

        Use that command to change browser from maven

          test -Dcucumber.filter.tags=@smoke -Dbrowser=remote-chrome

  ------- DIFF BROWSER -----

 Create different jenkins job to rn tests against different browsers

      Smoke-chrome
                    test -Dcucumber.filter.tags=@smoke -Dbrowser=remote-chrome

      Smoke-firefox
                    test -Dcucumber.filter.tags=@smoke -Dbrowser=remote-firefox


why we are using remote if we running on jenkins ?

    - JENKINS --> main responsiblity of jenkins is managing journey application
            Browsers are really resource consuming that s we need dedicated server to run
    - GRID    --> REMOTE execution




How to run parallely ?

    - Add surefire with parallel setup
    - Make sure you have more than one feature
    - Driver needs to be eligible for Parallel Run  --> InheritableThreadLocal
    - Run from MAVEN

NOTE --> It is not possible to run from CUKESRUNNER paralelly

 */