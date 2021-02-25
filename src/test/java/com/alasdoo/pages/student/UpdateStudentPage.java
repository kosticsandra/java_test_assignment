package com.alasdoo.pages.student;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/***
 * Update student page
 */
public class UpdateStudentPage extends StudentPage {

	// Creating WebElement for a selected student, in this case, the first student
	// in the table
	@FindBy(xpath = "//*[@id=\"root\"]/div/main/div[2]/div[1]/div/div/div[2]/div[2]/div/div/div/div/div/div[1]")
	private WebElement selectedStudent;

	public UpdateStudentPage(WebDriver driver) {
		super(driver);
	}

	// Method that fills the student's table with 20 entities (Settings page on
	// UI)
	public void getAllStudents() {
		this.settingsButton.click();
		this.insertAllStudentsButton.click();
		this.studentButton.click();
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

	// Method that selects a student from the list
	public void selectStudent() {
		this.selectedStudent.click();
	}

	// Method that saves the new student and he is shown in the table
	public void save() {
		this.saveButton.click();
	}

	// Method that deletes the student who was selected to be updated
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
