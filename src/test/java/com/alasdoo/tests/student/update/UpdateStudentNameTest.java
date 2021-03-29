package com.alasdoo.tests.student.update;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.alasdoo.pages.StudentPage;
import com.alasdoo.tests.FunctionalTest;

/***
 * Tests updating a student's name
 */
public class UpdateStudentNameTest extends FunctionalTest {

	@Test
	public void updateStudentName() throws InterruptedException {
		// open landing page on UI
		driver.get("http://localhost:3000/student");

		// initialize student page
		StudentPage updateStudentPage = new StudentPage(driver);

		// verify if page is opened
		Assertions.assertTrue(updateStudentPage.isInitialized());

		// perform click actions
		updateStudentPage.getAllStudents();

		// perform click on student action
		updateStudentPage.selectStudent();

		// verify if form is opened
		String isUpdateStudentForm = driver.getCurrentUrl();
		Assertions.assertEquals(isUpdateStudentForm, "http://localhost:3000/student/1");

		// fill form data
		updateStudentPage.updateStudentsFirstName("Julia");
		// perform click on save button
		updateStudentPage.save();

		// wait for response to verify if the student has been updated
		Thread.sleep(2000);

		// verify if the student has been updated
		String isStudentUpdatedUrl = driver.getCurrentUrl();
		Assertions.assertEquals(isStudentUpdatedUrl, "http://localhost:3000/student/1");

		// perform click on Cancel(x) icon
		updateStudentPage.exitForm();
	}

}
