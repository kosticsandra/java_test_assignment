package com.alasdoo.tests.student;

import org.junit.Assert;
import org.junit.Test;

import com.alasdoo.pages.student.DeleteStudentPage;
import com.alasdoo.tests.FunctionalTest;

/***
 * Tests deleting a student from the table
 */
public class DeleteStudentTest extends FunctionalTest {

	@Test
	public void deleteAStudent() throws InterruptedException {
		// open landing page on UI
		driver.get("http://localhost:3000/student");

		// initialize student page
		DeleteStudentPage deleteStudent = new DeleteStudentPage(driver);

		// verify if page is opened
		Assert.assertTrue(deleteStudent.isInitialized());

		// perform click actions
		deleteStudent.getAllStudents();

		// perform click on student action
		deleteStudent.selectStudent();

		// verify if form is opened
		String isDeleteStudentForm = driver.getCurrentUrl();
		Assert.assertEquals(isDeleteStudentForm, "http://localhost:3000/student/1");

		// perform click on delete button
		deleteStudent.delete();

		// wait for response to verify if the student has been added
		Thread.sleep(2000);

		// verify if adding the student has been canceled
		String isStudentAddedUrl = driver.getCurrentUrl();
		Assert.assertEquals(isStudentAddedUrl, "http://localhost:3000/student");
	}

}
