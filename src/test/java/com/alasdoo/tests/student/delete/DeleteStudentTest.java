package com.alasdoo.tests.student.delete;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.alasdoo.pages.StudentPage;
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
		StudentPage deleteStudent = new StudentPage(driver);

		// verify if page is opened
		Assertions.assertTrue(deleteStudent.isInitialized());

		// perform click actions
		deleteStudent.getAllStudents();

		// perform click on student action
		deleteStudent.selectStudent();

		// verify if form is opened
		String isDeleteStudentForm = driver.getCurrentUrl();
		Assertions.assertEquals(isDeleteStudentForm, "http://localhost:3000/student/1");

		// perform click on delete button
		deleteStudent.delete();

		// wait for response to verify if the student has been added
		Thread.sleep(2000);

		// verify if adding the student has been deleted
		String isStudentDeletedUrl = driver.getCurrentUrl();
		Assertions.assertEquals(isStudentDeletedUrl, "http://localhost:3000/student");
	}

}
