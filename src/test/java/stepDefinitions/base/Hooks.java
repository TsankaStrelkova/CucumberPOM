package stepDefinitions.base;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;

import static driver.DriverFactory.cleanupDriver;
import static driver.DriverFactory.getDriver;

public class Hooks {


    @Before
    public void setup() {
        getDriver();
    }

    @AfterStep
    public void takeScreenshot(Scenario scenario)
    {
        if (scenario.isFailed())
        {
            String name = scenario.getName();

            Timestamp ts=new Timestamp(System.currentTimeMillis());

            String timeMilliseconds = String.valueOf(ts.getTime());


            //System.out.println("=== SCENARIO "+name+" failed at " +timeMilliseconds);
            byte[] scrShot =((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(scrShot,"image/png", timeMilliseconds);

        }
    }

    @After
    public void tearDown() {
        cleanupDriver();
    }
}
