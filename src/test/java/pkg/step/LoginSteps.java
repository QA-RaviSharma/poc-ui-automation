package pkg.step;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import pkg.helpers.Helper;
import pkg.model.LoginRequestModel;
import pkg.page.LoginPage;

import java.util.List;
import java.util.Random;

import static pkg.page.LoginPage.errorBox;
import static pkg.page.LoginPage.productPage;

public class LoginSteps extends Helper {
    private static int i = 0;
    private LoginRequestModel loginRequestModel = new LoginRequestModel();
    private String verifyInventoryPage = null;
    private String errorMessage = null;

    @When("^User enters valid details in email and password fields$")
    public void userEntersValidDetailsInEmailAndPasswordFields(List<LoginRequestModel> loginRequestModelList) {
        switch (loginRequestModelList.get(0).getUserName()) {
            case "valid user name":
                loginRequestModel.setUserName(Helper.property().getProperty("userName"));
                break;
            case "invalid user name":
                loginRequestModel.setUserName(faker.superhero().name());
                break;
        }

        switch (loginRequestModelList.get(0).getPassword()) {
            case "valid password":
                loginRequestModel.setPassword(Helper.property().getProperty("password"));
                break;
            case "invalid password":
                loginRequestModel.setPassword(faker.superhero().name());
                break;

        }
        webDriverStart();
        driver.findElement(By.id(LoginPage.userName)).sendKeys(loginRequestModel.getUserName());
        driver.findElement(By.id(LoginPage.password)).sendKeys(loginRequestModel.getPassword());
    }

    @And("^User clicks on login button on Swaglabs login page$")
    public void userClicksOnLoginButtonOnSwaglabsLoginPage() {
        driver.findElement(By.id(LoginPage.loginButton)).click();
    }

    @Then("^User should be login in Swaglabs successfully and able to see the inventory$")
    public void userShouldBeLoginInSwaglabsSuccessfullyAndAbleToSeeTheInventory() {
        verifyInventoryPage = driver.findElement(By.xpath(productPage)).getText();
        log.info("User is on: {}", verifyInventoryPage.toLowerCase());
        Assert.assertEquals("products", verifyInventoryPage.toLowerCase());
        webDriverQuit();
    }

    @Then("^User should not be login in Swaglabs successfully and should be error validation message$")
    public void userShouldNotBeLoginInSwaglabsSuccessfullyAndShouldBeErrorValidationMessage(List<String> errorList) {
        try {
            errorMessage = driver.findElement(By.xpath(errorBox)).getText();
            Assert.assertEquals(errorMessage, errorList.get(i));
            log.info("Assertion Passed Successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            i++;
            webDriverQuit();
        }
    }

    @When("^User logins into Swaglabs system with valid credentials$")
    public void userLoginsIntoSwaglabsSystemWithValidCredentials() {
        webDriverStart();
        driver.findElement(By.id(LoginPage.userName)).sendKeys(Helper.property().getProperty("userName"));
        driver.findElement(By.id(LoginPage.password)).sendKeys(Helper.property().getProperty("password"));
        driver.findElement(By.id(LoginPage.loginButton)).click();
    }
}
