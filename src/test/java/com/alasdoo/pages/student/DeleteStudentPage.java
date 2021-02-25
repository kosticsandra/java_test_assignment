package com.alasdoo.pages.student;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/***
 * Delete student page
 */
public class DeleteStudentPage extends StudentPage {

	// WebElement for a selected student, in this case, the first student
	// in the table
	@FindBy(xpath = "//*[@id=\"root\"]/div/main/div[2]/div[1]/div/div/div[2]/div[2]/div/div/div/div/div/div[1]")
	private WebElement selectedStudent;

	public DeleteStudentPage(WebDriver driver) {
		super(driver);
	}

	// A method that fills the student's table with 20 entities (Settings page on
	// UI)
	public void getAllStudents() {
		this.settingsButton.click();
		this.insertAllStudentsButton.click();
		this.studentButton.click();

	}

	// Method that selects a student from the list
	public void selectStudent() {
		this.selectedStudent.click();
	}

	// Method that deletes the student who was selected to be deleted
	@Override
	public void delete() {
		this.selectedStudent.click();
		this.deleteButton.click();
	}

	@Override
	public boolean isInitialized() {
		return this.addButton.isDisplayed();
	}

}
