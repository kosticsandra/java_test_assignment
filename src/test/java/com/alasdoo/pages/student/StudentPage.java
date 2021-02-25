package com.alasdoo.pages.student;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.alasdoo.pages.PageObject;

/***
 * An abstract class StudentPage extended by AddStudentPage, UpdateStudentPage,
 * DeleteStudentPage classes
 */
public abstract class StudentPage extends PageObject {

	/***
	 * WebElement creation of the elements located on http://localhost:3000/student
	 */
	
	// WebElement for add button
	@FindBy(xpath = "//*[@id=\"root\"]/div/main/div[2]/button")
	protected WebElement addButton;
	
	// Settings
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div/nav/a[4]")
	protected WebElement settingsButton;

	// Start button inside the Settings
	@FindBy(xpath = "//*[@id=\"root\"]/div/main/div[2]/div/div/button")
	protected WebElement insertAllStudentsButton;

	// Students
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div/nav/a[1]")
	protected WebElement studentButton;

	// Elements from the form
	@FindBy(name = "name")
	protected WebElement name;

	@FindBy(name = "surname")
	protected WebElement surname;

	@FindBy(name = "accountName")
	protected WebElement accountName;

	@FindBy(name = "email")
	protected WebElement email;

	@FindBy(name = "bankCardNumber")
	protected WebElement bankCardNumber;

	// Save button from the form
	@FindBy(xpath = "//*[@data-test-id='save']")
	protected WebElement saveButton;

	// Delete button from the form
	@FindBy(xpath = "//*[@data-test-id='delete']")
	protected WebElement deleteButton;

	// X icon from the form
	@FindBy(xpath = "//*[@id=\"root\"]/div/main/div[2]/div[2]/div/button")
	protected WebElement exitButton;

	public StudentPage(WebDriver driver) {
		super(driver);
	}

	// abstract method for deleting a student, which all classes have in
	// common
	public abstract void delete();


}
