package com.alasdoo.tests.teacher.delete;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.alasdoo.pages.TeacherPage;
import com.alasdoo.tests.FunctionalTest;

/***
 * Tests deleting a teacher from the table
 */

public class DeleteTeacherTest extends FunctionalTest {

	@Test
	public void deleteATeacher() throws InterruptedException {

		// open landing page on UI
		driver.get("http://localhost:3000/student");

		// initialize teacher page
		TeacherPage deleteTeacher = new TeacherPage(driver);

		// verify if page is opened
		Assertions.assertTrue(deleteTeacher.isInitialized());

		// perform click actions
		deleteTeacher.getAllTeachers();
		
		// wait for the table to be filled
		Thread.sleep(4000);

		// perform click on teacher action
		deleteTeacher.selectTeacher();

		// verify if form is opened
		String isDeleteStudentForm = driver.getCurrentUrl();
		Assertions.assertEquals(isDeleteStudentForm, "http://localhost:3000/teacher/1");

		// perform click on delete button
		deleteTeacher.delete();

		// wait for response to verify if the teacher has been added
		Thread.sleep(2000);

		// verify if adding the teacher has been deleted
		String isTeacherDeletedUrl = driver.getCurrentUrl();
		Assertions.assertEquals(isTeacherDeletedUrl, "http://localhost:3000/teacher");
	}
}
