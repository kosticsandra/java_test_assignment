package com.alasdoo.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/***
 * StudentPage class for Student Tests
 */
public class StudentPage extends PageObject {

	/***
	 * WebElement creation of the elements located on http://localhost:3000/student
	 */

	// WebElement for add button
	@FindBy(xpath = "//*[@id=\"root\"]/div/main/div[2]/button")
	private WebElement addButton;

	// Settings
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div/nav/a[4]")
	private WebElement settingsButton;

	// Start button inside the Settings
	@FindBy(xpath = "//*[@id=\"root\"]/div/main/div[2]/div/div/button")
	private WebElement insertAllStudentsButton;

	// Students
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div/nav/a[1]")
	private WebElement studentButton;

	// Elements from the form
	@FindBy(name = "name")
	private WebElement name;

	@FindBy(name = "surname")
	private WebElement surname;

	@FindBy(name = "accountName")
	private WebElement accountName;

	@FindBy(name = "email")
	private WebElement email;

	@FindBy(name = "bankCardNumber")
	private WebElement bankCardNumber;

	// WebElement for a selected student, in this case, the first student
	// in the table
	@FindBy(xpath = "//*[@id=\"root\"]/div/main/div[2]/div[1]/div/div/div[2]/div[2]/div/div/div/div/div/div[1]")
	private WebElement selectedStudent;
	
	//Toggle courses button
	@FindBy(xpath = "//*[@id=\"root\"]/div/main/div[2]/div[2]/form/div[6]/button")
	private WebElement toggleCoursesButton;

	// Save button from the form
	@FindBy(xpath = "//*[@data-test-id='save']")
	private WebElement saveButton;

	// Delete button from the form
	@FindBy(xpath = "//*[@data-test-id='delete']")
	private WebElement deleteButton;

	// X icon from the form
	@FindBy(xpath = "//*[@id=\"root\"]/div/main/div[2]/div[2]/div/button")
	protected WebElement exitButton;

	public StudentPage(WebDriver driver) {
		super(driver);
	}

	// A method that fills the student's table with 20 entities (Settings page on
	// UI)
	public void getAllStudents() {
		this.settingsButton.click();
		this.insertAllStudentsButton.click();
		// wait for the table to be filled
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.studentButton.click();

	}

	// Open add student form
	public void openAddStudentForm() {
		this.addButton.click();
	}

	// A method that fills the empty form with student's data
	public void enterStudentData(String name, String surname, String accountName, String email,
			Integer bankCardNumber) {

		this.name.clear();
		this.name.sendKeys(name);

		this.surname.clear();
		this.surname.sendKeys(surname);

		this.accountName.clear();
		this.accountName.sendKeys(accountName);

		this.email.clear();
		this.email.sendKeys(email);

		this.bankCardNumber.clear();
		this.bankCardNumber.sendKeys(String.valueOf(bankCardNumber));
	}

	// Method that selects a student from the list
	public void selectStudent() {
		this.selectedStudent.click();
	}

	// Method that saves the new student and he is shown in the table
	public void save() {
		this.saveButton.click();
	}

	// Method that erases text from the line
	private void eraseLine(WebElement line) {
		line.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
	}

	// Method that updates only the student's name
	public void updateStudentsFirstName(String name) {
		eraseLine(this.name);
		this.name.sendKeys(name);
	}

	// Method that updates only the student's surname
	public void updateStudentsSurname(String surname) {
		eraseLine(this.surname);
		this.surname.sendKeys(surname);
	}

	// A method that updates only the student's email
	public void updateStudentsEmail(String email) {
		eraseLine(this.email);
		this.email.sendKeys(email);
	}

	// Method that updates all the student's data accessible for update
	public void updateAllElementsOfStudent(String name, String surname, String email) {
		updateStudentsFirstName(name);
		updateStudentsSurname(surname);
		updateStudentsEmail(email);
	}
	
	//Method for toggling courses
	public void toggleCourses() {
		this.toggleCoursesButton.click();
	}

	// Method that deletes a student
	public void delete() {
		this.deleteButton.click();
	}

	// Method that exits the form by clicking on the Cancel (x) icon
	public void exitForm() {
		this.exitButton.click();
	}

	@Override
	public boolean isInitialized() {
		return this.addButton.isDisplayed();
	}

}
