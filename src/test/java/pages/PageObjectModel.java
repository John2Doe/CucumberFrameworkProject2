package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class PageObjectModel {
    public PageObjectModel(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "ctl00_MainContent_username")
    public WebElement userName;

    @FindBy(id = "ctl00_MainContent_password")
    public WebElement password;

    @FindBy(id = "ctl00_MainContent_login_button")
    public WebElement login;

    @FindBy(xpath = "//span[@class='error']")
    public WebElement message;

    @FindBy(xpath = "//ul[@id='ctl00_menu']/li")
    public List<WebElement> menuItems;

    @FindBy(id = "ctl00_MainContent_btnCheckAll")
    public WebElement checkAll;

    @FindBy(id = "ctl00_MainContent_btnUncheckAll")
    public WebElement unCheckAll;

    @FindBy(xpath = "//input[@type='checkbox']")
    public List<WebElement> checkBoxes;

    @FindBy(xpath = "//a[@href='Process.aspx']")
    public WebElement order;

    @FindBy(id = "ctl00_MainContent_fmwOrder_ddlProduct")
    public WebElement selectProduct;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtQuantity")
    public WebElement quantityInput;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtName")
    public WebElement customerName;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox2")
    public WebElement streetName;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox3")
    public WebElement cityName;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox4")
    public WebElement state;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox5")
    public WebElement zipCode;

    @FindBy(id = "ctl00_MainContent_fmwOrder_cardList_1")
    public WebElement cardOption;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox6")
    public WebElement cardNumber;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox1")
    public WebElement expireDate;

    @FindBy(id = "ctl00_MainContent_fmwOrder_InsertButton")
    public WebElement process;

    @FindBy(xpath = "//table/tbody/tr[2]")
    public WebElement orderInfos;

    public String setOrderInfos(List<WebElement> elements){
        int num = Integer.parseInt(null);
        List<WebElement> newElements = new ArrayList<>();
        for (int i = 0; i < elements.size(); i++) {
            num = i;
            if (elements.get(i).getText().length() > 0) {
                newElements.add(elements.get(i));
            }
        }
        return newElements.get(num) + "";
    }

    @FindBy(xpath = "//table/tbody/tr[2]/td")
    public List<WebElement> elementList;

    @FindBy(id = "ctl00_MainContent_btnDelete")
    public WebElement deleteAll;

    @FindBy(id = "ctl00_MainContent_orderMessage")
    public WebElement listOfOrderMessage;

}
