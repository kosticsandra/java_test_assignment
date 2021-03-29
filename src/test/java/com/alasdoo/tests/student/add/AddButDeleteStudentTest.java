package com.alasdoo.tests.student.add;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.alasdoo.pages.StudentPage;
import com.alasdoo.tests.FunctionalTest;

/***
 * Tests adding a student, but deleting it instead
 */
public class AddButDeleteStudentTest extends FunctionalTest {

	@Test
	public void addButDeleteStudent() throws InterruptedException {

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
		addStudentPage.enterStudentData("Jean", "Doe", "JeanD", "jeandoe@test.com", 123456);

		// perform click on delete button
		addStudentPage.delete();

		// wait for response to verify if the student has been added
		Thread.sleep(2000);

		// verify if adding the student has been canceled
		String isStudentAddedUrl = driver.getCurrentUrl();
		Assertions.assertEquals(isStudentAddedUrl, "http://localhost:3000/student");
	}

}
