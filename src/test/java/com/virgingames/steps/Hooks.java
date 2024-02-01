package com.virgingames.steps;

import com.virgingames.propertyreader.PropertyReader;
import com.virgingames.utilities.Utilities;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends Utilities {
    @Before
    public void setUp(){
        selectBrowser(PropertyReader.getInstance().getProperty("browser"));
    }

    @After
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            final  byte[]  screenShot = getScreenShot();
            scenario.attach(screenShot, "image/png", scenario.getName());
        }
        closeBrowser();
    }
}
