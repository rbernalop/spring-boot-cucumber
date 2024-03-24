package org.rbernalop.spring_boot_cucumber.it;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/cucumber_tests",
        glue = "org.rbernalop.spring_boot_cucumber.it",
        plugin = {"pretty"})
public class CucumberIT {

}
