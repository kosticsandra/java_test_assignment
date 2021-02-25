package com.alasdoo.tests.student.update;

import org.junit.Assert;
import org.junit.Test;

import com.alasdoo.pages.student.UpdateStudentPage;
import com.alasdoo.tests.FunctionalTest;

/***
 * Tests updating a student's surname
 */
public class UpdateStudentSurnameTest extends FunctionalTest {

	@Test
	public void updateStudentSurname() throws InterruptedException {
		// open landing page on UI
		driver.get("http://localhost:3000/student");

		// initialize student page
		UpdateStudentPage updateStudentPage = new UpdateStudentPage(driver);

		// verify if page is opened
		Assert.assertTrue(updateStudentPage.isInitialized());

		// perform click actions
		updateStudentPage.getAllStudents();

		// perform click on student action
		updateStudentPage.selectStudent();

		// verify if form is opened
		String isUpdateStudentForm = driver.getCurrentUrl();
		Assert.assertEquals(isUpdateStudentForm, "http://localhost:3000/student/1");

		// fill form data
		updateStudentPage.updateStudentsSurname("Black");
		// perform click on save button
		updateStudentPage.save();

		// wait for response to verify if the student has been updated
		Thread.sleep(2000);

		// verify if the student has been updated
		String isStudentAddedUrl = driver.getCurrentUrl();
		Assert.assertEquals(isStudentAddedUrl, "http://localhost:3000/student/1");

		// perform click on Cancel(x) icon
		updateStudentPage.exitForm();
	}

}
