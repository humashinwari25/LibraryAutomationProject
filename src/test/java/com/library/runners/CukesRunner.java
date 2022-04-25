package com.library.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

    @RunWith(Cucumber.class)
    @CucumberOptions(

            plugin = {
                    "html:target/cucumber-report.html",
                    "rerun:target/rerun.txt",
                    "me.jvt.cucumber.report.PrettyReports:target/cucumber",
                    "json:target/cucumber.json",
                    //store the failed scenario into rerun.txt
            },
            features = "src/test/resources/features",
            glue = "com/library/step_definitions",
            dryRun =false,
            tags = "@wip",

            publish = true


    )



    public class CukesRunner {
    }
