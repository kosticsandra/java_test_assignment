package com.alasdoo.tests.student.add;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.alasdoo.pages.StudentPage;
import com.alasdoo.tests.FunctionalTest;

/***
 * Tests adding a student into an empty table
 */
public class AddStudentBlankTableTest extends FunctionalTest {

	@Test
	public void addStudentBlankTable() throws InterruptedException {

		// open landing page on UI
		driver.get("http://localhost:3000/student");

		// initialize student page
		StudentPage addStudentPage = new StudentPage(driver);

		// verify if page is opened
		Assertions.assertTrue(addStudentPage.isInitialized());

		// open add student form
		addStudentPage.openAddStudentForm();

		// verify if form is opened
		String isAddStudentForm = driver.getCurrentUrl();
		Assertions.assertEquals(isAddStudentForm, "http://localhost:3000/student/new");

		// fill form data
		addStudentPage.enterStudentData("Jane", "Doe", "JaneD", "janedoe@test.com", 112233);

		// perform click on save button
		addStudentPage.save();

		// wait for response to verify if the student has been added
		Thread.sleep(2000);

		// verify added student, if it's added to the table
		String isStudentAddedUrl = driver.getCurrentUrl();
		Assertions.assertEquals(isStudentAddedUrl, "http://localhost:3000/student/1");

		// perform click on Cancel(x) icon
		addStudentPage.exitForm();
	}

}
