package com.alasdoo.tests.teacher.update;

import org.junit.Assert;
import org.junit.Test;

import com.alasdoo.pages.TeacherPage;
import com.alasdoo.tests.FunctionalTest;

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
		Assert.assertTrue(updateTeacherPage.isInitialized());

		// perform click actions
		updateTeacherPage.getAllTeachers();

		// perform click on teacher action
		updateTeacherPage.selectTeacher();

		// verify if form is opened
		String isUpdateStudentForm = driver.getCurrentUrl();
		Assert.assertEquals(isUpdateStudentForm, "http://localhost:3000/teacher/1");

		// fill form data
		updateTeacherPage.updateAllElementsOfTeacher("Gregory", "Smith", "gregory.smith@gmail.com");

		// perform click on delete button
		updateTeacherPage.delete();

		// wait for response to verify if the teacher has been deleted
		Thread.sleep(2000);

		// verify if the teacher has been deleted
		String isTeacherUpdatedUrl = driver.getCurrentUrl();
		Assert.assertEquals(isTeacherUpdatedUrl, "http://localhost:3000/teacher");
	}

}
