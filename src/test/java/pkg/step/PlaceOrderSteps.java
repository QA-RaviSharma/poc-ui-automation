package pkg.step;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import pkg.page.PlaceOrderPage;

import static pkg.helpers.Helper.*;
import static pkg.page.PlaceOrderPage.*;

public class PlaceOrderSteps {
    private String finishPage = null;

    @When("^User clicks on add to cart button on inventory page$")
    public void userClicksOnAddToCartButtonOnInventoryPage() {
        driver.findElement(By.id(addToCartButton)).click();
    }

    @When("^User clicks on cart button on inventory page$")
    public void userClicksOnCartButtonOnInventoryPage() {
        driver.findElement(By.id(cartButton)).click();

    }

    @When("^User clicks on checkout button the cart page$")
    public void userClicksOnCheckoutButtonTheCartPage() {
        driver.findElement(By.id(checkoutButton)).click();

    }

    @When("^User enters all details in the checkout information fields and clicks on continue button$")
    public void userEntersAllDetailsInTheCheckoutInformationFieldsAndClicksOnContinueButton() {
        driver.findElement(By.id(firstName)).sendKeys(faker.name().firstName());
        driver.findElement(By.id(lastName)).sendKeys(faker.name().lastName());
        driver.findElement(By.id(postalCode)).sendKeys(faker.address().zipCode());
        driver.findElement(By.id(continueButton)).click();

    }

    @When("^User overviews the order and clicks on finish button on the checkout overview page$")
    public void userOverviewsTheOrderAndClicksOnFinishButtonOnTheCheckoutOverviewPage() {
        driver.findElement(By.id(finishButton)).click();

    }

    @Then("^User should be land on checkout finish page successfully$")
    public void userShouldBeLandOnCheckoutFinishPageSuccessfully() {
        try {
            finishPage = driver.findElement(By.xpath(finishPageText)).getText();
            Assert.assertEquals("THANK YOU FOR YOUR ORDER", finishPage);
            log.info("Assertion passed successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            webDriverQuit();
        }

    }
}
