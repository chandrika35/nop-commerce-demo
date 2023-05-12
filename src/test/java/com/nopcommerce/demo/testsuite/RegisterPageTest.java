package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.RegisterPage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterPageTest extends BaseTest {
    HomePage homePage;
    RegisterPage registerPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        registerPage = new RegisterPage();
    }

    @Test(groups = {"Sanity", "Regression"})
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        homePage.clickingOnRegisterLink();
        registerPage.isRegisterTextDisplayed();
    }

    @Test(groups = {"Smoke", "Regression"})
    public void verifyThatFirstNameLastNameEmailPasswordAndConfirmPasswordFieldsAreMandatory() {
        homePage.clickingOnRegisterLink();
        registerPage.clickingOnRegisterButton();
        registerPage.isFirstNameRequiredTextDisplayed();
        registerPage.isLastNameRequiredTextDisplayed();
        registerPage.isEmailRequiredTextDisplayed();
        registerPage.isPasswordRequiredTextDisplayed();
        registerPage.isConfirmedPasswordRequiredTextDisplayed();
    }

    @Test(groups = "Regression")
    public void VerifyThatUserShouldCreateAccountSuccessfully() {
        homePage.clickingOnRegisterLink();
        registerPage.selectingFemaleRadioButton();
        registerPage.enteringFirstNameInToFirstNameField("Sita");
        registerPage.enteringLastNameInToLastNameField("Ram");
        registerPage.selectingDayOfBirthFromDropDown("1");
        registerPage.selectingMonthOfBirthFromDropDown("February");
        registerPage.selectingYearOfBirthFromDropDown("1988");
        registerPage.enteringEmailToEmailField("sitaram123@gmail.com");
        registerPage.enteringPasswordToPasswordField("Sita_ram123");
        registerPage.enteringPasswordToConfirmPasswordField("Sita_ram123");
        registerPage.clickingOnRegisterButton();
        registerPage.isYourRegistrationCompleteTextDisplayed();
        registerPage.clickingOnContinueButton();
    }
}
