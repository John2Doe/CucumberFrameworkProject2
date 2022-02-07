package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.PageObjectModel;
import texts.ExpectedText;
import utilities.Driver;
import utilities.Waiter;

import java.util.List;

public class smartBearSoftware {
    public WebDriver driver;
    public PageObjectModel pageObjectModel;
    public Select select;

    @Before
    public void setUp(){
        driver = Driver.getDriver();
        pageObjectModel = new PageObjectModel(driver);
    }

    @Given("user is on {string}")
    public void userIsOn(String url) {
        driver.get(url);
    }

    @When("user enters username as {string}")
    public void userEntersUsernameAs(String email) {
        String str = null;
        switch (email){
            case "Tester":
                str = email;
                break;
            case "abcd":
                str = email;
                break;
            default:
                throw new NotFoundException();
        }
        pageObjectModel.userName.sendKeys(str);
    }

    @And("user enters password as {string}")
    public void userEntersPasswordAs(String password) {
        String str = null;
        switch (password){
            case "test":
                str = password;
                break;
            case "abcd1234":
                str = password;
                break;
            default:
                throw new NotFoundException();
        }
        pageObjectModel.password.sendKeys(str);
    }

    @And("user clicks on Login button")
    public void userClicksOnLoginButton() {
        pageObjectModel.login.click();
        Waiter.pause(3);
    }

    @Then("user should see {string} Message")
    public void userShouldSeeMessage(String message) {
        Assert.assertEquals(message, pageObjectModel.message.getText());
        Waiter.pause(3);
    }

    @Then("user should be routed to {string}")
    public void userShouldBeRoutedTo(String url) {
        Assert.assertEquals(url, driver.getCurrentUrl());
    }

    @And("validate below menu items are displayed")
    public void validateBelowMenuItemsAreDisplayed(DataTable dataTable) {
        List<String> expectedText = dataTable.asList();
        for (int i = 0; i < pageObjectModel.menuItems.size(); i++) {
            Assert.assertEquals(expectedText.get(i), pageObjectModel.menuItems.get(i).getText());
        }
    }

    @When("user clicks on {string} button")
    public void userClicksOnButton(String str) {
        WebElement element = null;
        switch (str){
            case "Check All":
                element = pageObjectModel.checkAll;
                break;
            case "Delete Selected":
                element = pageObjectModel.deleteAll;
                break;
            case "Process":
                element = pageObjectModel.process;
                break;
            case "Uncheck All":
                element = pageObjectModel.unCheckAll;
                break;
            default:
                throw new NotFoundException();
        }
        element.click();
    }

    @Then("all rows should be checked")
    public void allRowsShouldBeChecked() {
        for (int i = 0; i < pageObjectModel.checkBoxes.size(); i++) {
            Assert.assertTrue(pageObjectModel.checkBoxes.get(i).isSelected());
        }
    }

    @Then("all rows should be unchecked")
    public void allRowsShouldBeUnchecked() {
        for (int i = 0; i < pageObjectModel.checkBoxes.size(); i++) {
            Assert.assertFalse(pageObjectModel.checkBoxes.get(i).isSelected());
        }
    }

    @When("user clicks on {string} menu item")
    public void userClicksOnMenuItem(String str) {
        WebElement element = null;
        switch (str){
            case "Order":
                element = pageObjectModel.menuItems.get(2);
                break;
            case "View all orders":
                element = pageObjectModel.menuItems.get(0);
                break;
            default:
                throw new NotFoundException();
        }
        element.click();
    }

    @And("user selects {string} as product")
    public void userSelectsAsProduct(String arg0) {
        select = new Select(pageObjectModel.selectProduct);
        select.selectByIndex(1);
    }

    @And("user enters {int} as quantity")
    public void userEntersAsQuantity(int number) {
        pageObjectModel.quantityInput.sendKeys(number + "");
    }

    @And("user enters all address information")
    public void userEntersAllAddressInformation() {
        pageObjectModel.customerName.sendKeys(ExpectedText.name);
        pageObjectModel.streetName.sendKeys(ExpectedText.streetAdress);
        pageObjectModel.cityName.sendKeys(ExpectedText.city);
        pageObjectModel.state.sendKeys(ExpectedText.state);
        pageObjectModel.zipCode.sendKeys(ExpectedText.zipCode);
    }

    @And("user enters all payment information")
    public void userEntersAllPaymentInformation() {
        pageObjectModel.cardOption.click();
        pageObjectModel.cardNumber.sendKeys(ExpectedText.cardNumber);
        pageObjectModel.expireDate.sendKeys(ExpectedText.expireDate);
    }

    @Then("user should see their order displayed in the {string} table")
    public void userShouldSeeTheirOrderDisplayedInTheTable(String arg0) {
        Assert.assertTrue(pageObjectModel.orderInfos.isDisplayed());
    }

    @And("validate all information entered displayed correct with the order")
    public void validateAllInformationEnteredDisplayedCorrectWithTheOrder() {
        for (int i = 0; i < ExpectedText.orderInfos.size(); i++) {
            Assert.assertEquals(ExpectedText.orderInfos.get(i), pageObjectModel.setOrderInfos(pageObjectModel.elementList));
        }
    }

    @Then("validate all orders are deleted from the {string}")
    public void validateAllOrdersAreDeletedFromThe(String arg0) {
        for (int i = 0; i < pageObjectModel.checkBoxes.size(); i++) {
            Assert.assertFalse(pageObjectModel.checkBoxes.get(i).isSelected());
        }
    }

    @And("validate user sees {string} Message")
    public void validateUserSeesMessage(String message) {
        Assert.assertEquals(message, pageObjectModel.listOfOrderMessage.getText());
    }
}
