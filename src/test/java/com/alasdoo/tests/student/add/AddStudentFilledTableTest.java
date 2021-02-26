package com.alasdoo.tests.student.add;

import org.junit.Assert;
import org.junit.Test;

import com.alasdoo.pages.StudentPage;
import com.alasdoo.tests.FunctionalTest;

/***
 * Tests adding a student into an filled table
 */
public class AddStudentFilledTableTest extends FunctionalTest {

	
	@Test
	public void addStudentFilledTable() throws InterruptedException {

		// open landing page on UI
		driver.get("http://localhost:3000/student");

		// initialize student page
		StudentPage addStudentPage = new StudentPage(driver);

		// verify if page is opened
		Assert.assertTrue(addStudentPage.isInitialized());

		// perform click actions
		addStudentPage.getAllStudents();

		// open add student form
		addStudentPage.openAddStudentForm();

		// verify if form is opened
		String isAddStudentForm = driver.getCurrentUrl();
		Assert.assertEquals(isAddStudentForm, "http://localhost:3000/student/new");

		// fill form data
		addStudentPage.enterStudentData("John", "Doe", "JohnD", "johndoe@test.com", 445566);

		// perform click on save button
		addStudentPage.save();

		// wait for response to verify if the student has been added
		Thread.sleep(5000);

		// verify added student, if it's added to the table
		String isStudentAddedUrl = driver.getCurrentUrl();
		Assert.assertEquals(isStudentAddedUrl, "http://localhost:3000/student/21");

		// perform click on Cancel(x) icon
		addStudentPage.exitForm();

	}

}
