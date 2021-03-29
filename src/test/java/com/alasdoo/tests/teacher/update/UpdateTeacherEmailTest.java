package com.alasdoo.tests.teacher.update;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.alasdoo.pages.TeacherPage;
import com.alasdoo.tests.FunctionalTest;

/***
 * Tests updating teacher's email
 */ 

public class UpdateTeacherEmailTest extends FunctionalTest {
	
	@Test
	public void updateTeacherEmail() throws InterruptedException {
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
		updateTeacherPage.updateTeacherEmail("devon.dems@gmail.com");

		// perform click on save button
		updateTeacherPage.save();

		// wait for response to verify if the teacher has been updated
		Thread.sleep(2000);

		// verify if the teacher has been updated
		String isTeacherUpdatedUrl = driver.getCurrentUrl();
		Assertions.assertEquals(isTeacherUpdatedUrl, "http://localhost:3000/teacher/1");

		// perform click on Cancel(x) icon
		updateTeacherPage.exitForm();
	}


}
