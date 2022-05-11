package runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features={"src/test/java/features"},
        glue ={"stepDefinitions"},
        monochrome = true,
        dryRun = false,
        plugin = {"pretty","html:target/cucumber.html","json:target/cucumber.json"}
)
public class TestRunner extends AbstractTestNGCucumberTests {

    //to run test in parallel reffer https://cucumber.io/docs/guides/parallel-execution/#testng

    @Override
    @DataProvider(parallel = true)
    //@DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
