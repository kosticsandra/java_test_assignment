package com.alasdoo.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/***
 * TeacherPage class for Teacher tests
 */

public class TeacherPage extends PageObject {

	/***
	 * WebElement creation of the elements located on http://localhost:3000/teacher
	 */

	// WebElement for add button
	@FindBy(xpath = "//*[@id=\"root\"]/div/main/div[2]/button")
	private WebElement addButton;

	// Settings
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div/nav/a[4]")
	private WebElement settingsButton;

	// Start button inside the Settings
	@FindBy(xpath = "//*[@id=\"root\"]/div/main/div[2]/div/div/button")
	private WebElement insertAllTeachersButton;

	// Teachers
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div/nav/a[2]")
	private WebElement teacherButton;

	// Elements from the form
	@FindBy(name = "teacherName")
	private WebElement teacherName;

	@FindBy(name = "teacherSurname")
	private WebElement teacherSurname;

	@FindBy(name = "teacherEmail")
	private WebElement teacherEmail;

	// Creating WebElement for a selected teacher, in this case, the first teacher
	// in the table
	@FindBy(xpath = "//*[@id=\"root\"]/div/main/div[2]/div[1]/div/div/div[2]/div[2]/div/div/div/div/div/div[1]")
	private WebElement selectedTeacher;

	// Toggle courses button
	@FindBy(xpath = "//*[@id=\"root\"]/div/main/div[2]/div[2]/form/div[4]/button")
	private WebElement toggleCoursesButton;

	// Save button from the form
	@FindBy(xpath = "//*[@data-test-id='save']")
	private WebElement saveButton;

	// Delete button from the form
	@FindBy(xpath = "//*[@data-test-id='delete']")
	private WebElement deleteButton;

	// X icon from the form
	@FindBy(xpath = "//*[@id=\"root\"]/div/main/div[2]/div[2]/div/button")
	private WebElement exitButton;

	public TeacherPage(WebDriver driver) {
		super(driver);
	}

	public void goToTeacherPage() {
		this.teacherButton.click();
	}

	// Method that selects a teacher from the list
	public void selectTeacher() {
		this.selectedTeacher.click();
	}

	// Open add teacher form
	public void openAddTeacherForm() {
		this.addButton.click();
	}

	// A method that fills the teacher's table with 20 entities (Settings page on
	// UI)
	public void getAllTeachers() {
		this.settingsButton.click();
		this.insertAllTeachersButton.click();
		// wait for the table to be filled
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.teacherButton.click();

	}

	// A method that fills the empty form with teacher's data
	public void enterTeacherData(String name, String surname, String email) {

		this.teacherName.clear();
		this.teacherName.sendKeys(name);

		this.teacherSurname.clear();
		this.teacherSurname.sendKeys(surname);

		this.teacherEmail.clear();
		this.teacherEmail.sendKeys(email);

	}

	// Method that erases text from the line
	private void eraseLine(WebElement line) {
		line.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
	}

	// Method that updates only the teacher's name
	public void updateTeacherFirstName(String teacherName) {
		eraseLine(this.teacherName);
		this.teacherName.sendKeys(teacherName);
	}

	// Method that updates only the teacher's surname
	public void updateTeacherSurname(String teacherSurname) {
		eraseLine(this.teacherSurname);
		this.teacherSurname.sendKeys(teacherSurname);
	}

	// A method that updates only the teacher's email
	public void updateTeacherEmail(String teacherEmail) {
		eraseLine(this.teacherEmail);
		this.teacherEmail.sendKeys(teacherEmail);
	}

	// Method that updates all the teacher's data
	public void updateAllElementsOfTeacher(String teacherName, String teacherSurname, String teacherEmail) {
		updateTeacherFirstName(teacherName);
		updateTeacherSurname(teacherSurname);
		updateTeacherEmail(teacherEmail);
	}

	// Method for toggling courses
	public void toggleCourses() {
		this.toggleCoursesButton.click();
	}

	// Method that saves the new teacher and he is shown in the table
	public void save() {
		this.saveButton.click();
	}

	// Method that deletes a teacher
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
