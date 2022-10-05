package com.dgMarkt.stepDefs;


import com.dgMarkt.pages.LoginPanel;
import com.dgMarkt.utilities.ConfigurationReader;
import com.dgMarkt.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class Hooks {

    LoginPanel loginPanel =new LoginPanel();

    @Before
    public void setup() {

        Driver.get().get(ConfigurationReader.get("url"));
        Driver.get().manage().window().maximize();
        Driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginPanel.loginPanelM();
    }


    @After
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshot");
        }


        Driver.closeDriver();
    }

}
