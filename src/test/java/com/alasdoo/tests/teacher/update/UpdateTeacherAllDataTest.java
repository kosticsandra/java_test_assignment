package com.alasdoo.tests.teacher.update;

import org.junit.Assert;
import org.junit.Test;

import com.alasdoo.pages.TeacherPage;
import com.alasdoo.tests.FunctionalTest;

/***
 * Tests updating all the teacher's data
 */

public class UpdateTeacherAllDataTest extends FunctionalTest {

	@Test
	public void updateTeacherData() throws InterruptedException {
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

		// perform click on save button
		updateTeacherPage.save();

		// wait for response to verify if the teacher has been updated
		Thread.sleep(2000);

		// verify if the teacher has been updated
		String isTeacherUpdatedUrl = driver.getCurrentUrl();
		Assert.assertEquals(isTeacherUpdatedUrl, "http://localhost:3000/teacher/1");

		// perform click on Cancel(x) icon
		updateTeacherPage.exitForm();
	}

}
