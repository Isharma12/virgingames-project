package com.virgingames.pages;

import com.virgingames.utilities.Utilities;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;


public class HomePage extends Utilities {
  private static final Logger log = LogManager.getLogger(HomePage.class.getName());

  @CacheLookup
    @FindBy(css = "a[title='Privacy Policy']")
    WebElement privacyPolicy;

  @CacheLookup
    @FindBy(xpath = "//h3[normalize-space()='PRIVACY POLICY']")
    WebElement privacyPolicyText;


    public void scrollDownToFooter() {
        javaExecutorScriptExecuteScriptToScrollThePageTillElementFound(privacyPolicy);
        log.info("Scroll down to footer until get text : " + privacyPolicy.toString());
    }



    public String verifyPrivacyPolicyText() {
        String text = getTextFromElement(privacyPolicy);
        log.info("Getting Privacy policy text : " + privacyPolicy.toString());
        return text;
    }

    public void clickOnPrivacyPolicy() {
        javaExecutorScriptExecuteScriptToClick(privacyPolicy);
        log.info("Clicking on privacy Policy button : " + privacyPolicy);
    }

    public String navigateToPrivacyPolicyPage(String Url) {
        driver.navigate().to(Url);
        System.out.println("Current privacyPolicy page URL: " + driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

    public String verifyTheTitleText() {
        String msg = getTextFromElement(privacyPolicyText);
        log.info("Getting error text : " + privacyPolicyText);
        return msg;
    }


}


