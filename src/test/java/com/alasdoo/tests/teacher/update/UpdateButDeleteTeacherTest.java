package com.alasdoo.tests.teacher.update;

import com.alasdoo.pages.TeacherPage;
import com.alasdoo.tests.FunctionalTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/***
 * Tests updating a teacher but deleting it instead
 */
public class UpdateButDeleteTeacherTest extends FunctionalTest {

	@Test
	public void updateButDeleteTeacher() throws InterruptedException {
		// open landing page on UI
		driver.get("http://localhost:3000/student");

		// initialize teacher page
		TeacherPage updateTeacherPage = new TeacherPage(driver);

		// verify if page is opened
		Assertions.assertTrue(updateTeacherPage.isInitialized());

		// perform click actions
		updateTeacherPage.getAllTeachers();

		// perform click on teacher action
		updateTeacherPage.selectTeacher();

		// verify if form is opened
		String isUpdateStudentForm = driver.getCurrentUrl();
		Assertions.assertEquals(isUpdateStudentForm, "http://localhost:3000/teacher/1");

		// fill form data
		updateTeacherPage.updateAllElementsOfTeacher("Gregory", "Smith", "gregory.smith@gmail.com");

		// perform click on delete button
		updateTeacherPage.delete();

		// wait for response to verify if the teacher has been deleted
		Thread.sleep(2000);

		// verify if the teacher has been deleted
		String isTeacherUpdatedUrl = driver.getCurrentUrl();
		Assertions.assertEquals(isTeacherUpdatedUrl, "http://localhost:3000/teacher");
	}

}
