package com.alasdoo.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/***
 * CoursePage class for Course tests
 */

public class CoursePage extends PageObject {

	/***
	 * WebElement 
	 * creation of the elements
	 *  located on 
	 *  http://localhost:3000/course
	 */

	// WebElement for add button
	@FindBy(xpath = "//*[@id=\"root\"]/div/main/div[2]/button")
	private WebElement addButton;

	// Settings
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div/nav/a[4]")
	private WebElement settingsButton;

	// Start button inside the Settings
	@FindBy(xpath = "//*[@id=\"root\"]/div/main/div[2]/div/div/button")
	private WebElement insertAllCoursesButton;

	// Courses
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div/nav/a[3]")
	private WebElement courseButton;

	// Elements from the form
	@FindBy(name = "developerCourseName")
	private WebElement developerCourseName;

	@FindBy(name = "costPerClass")
	private WebElement costPerClass;

	@FindBy(name = "classesPerWeek")
	private WebElement classesPerWeek;

	// Creating WebElement for a selected course, in this case, the first course
	// in the table
	@FindBy(xpath = "//*[@id=\"root\"]/div/main/div[2]/div[1]/div/div/div[2]/div[2]/div/div/div/div/div/div[1]")
	private WebElement selectedCourse;

	// Save button from the form
	@FindBy(xpath = "//*[@data-test-id='save']")
	private WebElement saveButton;

	// Delete button from the form
	@FindBy(xpath = "//*[@data-test-id='delete']")
	private WebElement deleteButton;

	// X icon from the form
	@FindBy(xpath = "//*[@id=\"root\"]/div/main/div[2]/div[2]/div/button")
	private WebElement exitButton;

	public CoursePage(WebDriver driver) {
		super(driver);
	}

	// A method that fills the course's table with 20 entities (Settings page on
	// UI)
	public void getAllCourses() {
		this.settingsButton.click();
		this.insertAllCoursesButton.click();
		// wait for the table to be filled
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.courseButton.click();
	
	}

	// Method that selects a course from the list
	public void selectCourse() {
		this.selectedCourse.click();
	}

	// A method that fills the empty form with course data
	public void enterCourseData(String developerCourseName, Integer costPerClass, Integer classesPerWeek) {

		this.developerCourseName.clear();
		this.developerCourseName.sendKeys(developerCourseName);

		this.costPerClass.clear();
		this.costPerClass.sendKeys(String.valueOf(costPerClass));

		this.classesPerWeek.clear();
		this.classesPerWeek.sendKeys(String.valueOf(classesPerWeek));

	}

	// Method that erases text from the line
	private void eraseLine(WebElement line) {
		line.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
	}

	// Method that updates course's name
	public void updateCourseName(String developerCourseName) {
		eraseLine(this.developerCourseName);
		this.developerCourseName.sendKeys(developerCourseName);
	}

	// Method that updates course's cost per class
	public void updateCourseCostPerClass(Integer costPerClass) {
		eraseLine(this.costPerClass);
		this.costPerClass.sendKeys(String.valueOf(costPerClass));
	}

	// A method that updates course's amount of classes per week
	public void updateCoursesClassesPerWeek(Integer classesPerWeek) {
		eraseLine(this.classesPerWeek);
		this.classesPerWeek.sendKeys(String.valueOf(classesPerWeek));
	}

	// Method that updates all the course's data
	public void updateAllCourseData(String developerCourseName, Integer costPerClass, Integer classesPerWeek) {
		updateCourseName(developerCourseName);
		updateCourseCostPerClass(costPerClass);
		updateCoursesClassesPerWeek(classesPerWeek);
	}

	// Method that opens Courses(on UI)
	public void goToCoursePage() {
		this.courseButton.click();
	}

	// Open add course form
	public void openAddCourseForm() {
		this.addButton.click();
	}

	// Method that saves the new course and it is shown in the table
	public void save() {
		this.saveButton.click();
	}

	// Method that deletes a course
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
