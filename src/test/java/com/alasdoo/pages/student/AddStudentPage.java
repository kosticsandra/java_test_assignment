package com.alasdoo.pages.student;

import org.openqa.selenium.WebDriver;

/***
 * Add student page
 */
public class AddStudentPage extends StudentPage {

	public AddStudentPage(WebDriver driver) {
		super(driver);
	}

	// A method that fills the student's table with 20 entities (Settings page on
	// UI)
	public void getAllStudents() {
		this.settingsButton.click();
		this.insertAllStudentsButton.click();
		this.studentButton.click();

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

	// Method that saves the new student and he is shown in the table
	public void save() {
		this.saveButton.click();
	}

	// Method that behaves the same as the Cancel(x) icon, it leaves the form and
	// since the student wasn't added, he wasn't saved either
	public void delete() {
		this.deleteButton.click();
	}

	// Method that exits the form by clicking on the Cancel (x) icon
	public void exitForm() {
		this.exitButton.click();
	}

	// Open add student form
	public void openAddStudentForm() {
		this.addButton.click();
	}

	@Override
	public boolean isInitialized() {
		return this.addButton.isDisplayed();
	}

}
