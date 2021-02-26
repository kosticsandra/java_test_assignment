package com.alasdoo.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ToggleCoursesPage extends PageObject {

	// WebElement for add new course button
	@FindBy(xpath = "//*[@id=\"root\"]/div/main/div[2]/div[3]/div[1]/button")
	private WebElement addNewCourseButton;

	// Course *
	@FindBy(xpath = "//*[@id=\"root\"]/div/main/div[2]/div[3]/div[1]/form/div[1]")
	private WebElement courseDropdown;

	@FindBy(xpath = "//*[@id=\"menu-developerCourseId\"]/div[3]/ul/li[1]")
	private WebElement selectCourseFromDropdown;

	// Classes bought*
	@FindBy(name = "classesBought")
	private WebElement classesBought;

	// save button
	@FindBy(xpath = "//*[@data-test-id='save']")
	private WebElement saveButton;

	// cancel button
	@FindBy(xpath = "//*[@data-test-id='cancel']")
	private WebElement cancelButton;

	// delete button
	@FindBy(xpath = "//*[@data-test-id='delete']")
	private WebElement deleteButton;

	// select first element from course table to change classes bought
	@FindBy(xpath = "//*[@id=\"root\"]/div/main/div[2]/div[3]/div[2]/div/div[2]/div[2]/div/div/div/div/div/div[1]/div[1]")
	private WebElement selectCourseFromTable;

	public ToggleCoursesPage(WebDriver driver) {
		super(driver);
	}

	// Method for selecting a course from the table
	public void selectCourse() {
		this.selectCourseFromTable.click();
	}

	// Method that erases text from the line
	private void eraseLine(WebElement line) {
		line.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
	}

	// Method that adds new course to student's list of courses
	public void addCourseToList(Integer classesBought) {
		this.addNewCourseButton.click();
		this.courseDropdown.click();
		this.selectCourseFromDropdown.click();
		this.classesBought.sendKeys(String.valueOf(classesBought));
	}

	// Method that assigns new course to teacher's list of courses
	public void assignCourseToList() {
		this.addNewCourseButton.click();
		this.courseDropdown.click();
		this.selectCourseFromDropdown.click();
	}

	// Method that updates existing course from student's list of courses
	public void updateCourse(Integer classesBought) {
		this.selectCourseFromTable.click();
		eraseLine(this.classesBought);
		this.classesBought.sendKeys(String.valueOf(classesBought));
	}

	// Method that saves the course (updated or added)
	public void saveCourse() {
		this.saveButton.click();
	}

	// Method that cancels the action of adding or updating a course
	public void cancelAction() {
		this.cancelButton.click();
	}

	// Method that deletes a course from student's list of courses
	public void deleteCourse() {
		this.deleteButton.click();
	}

	@Override
	public boolean isInitialized() {
		return this.addNewCourseButton.isDisplayed();
	}

}
