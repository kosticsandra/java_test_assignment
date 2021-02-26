package com.alasdoo.tests.teacher.add;

import org.junit.Assert;
import org.junit.Test;

import com.alasdoo.pages.TeacherPage;
import com.alasdoo.tests.FunctionalTest;

/***
 * Tests adding a teacher into a filled table
 */

public class AddTeacherFilledTableTest extends FunctionalTest {
	
	@Test
	public void addTeacherFilledTable() throws InterruptedException {

		// open landing page on UI
		driver.get("http://localhost:3000/student");

		// initialize teacher page
		TeacherPage addTeacherPage = new TeacherPage(driver);

		// verify if page is opened
		Assert.assertTrue(addTeacherPage.isInitialized());

		// fill the table with teachers
		addTeacherPage.getAllTeachers();
		
		// wait for the table to be filled
		Thread.sleep(2000);

		// open add teacher form
		addTeacherPage.openAddTeacherForm();

		// verify if form is opened
		String isAddTeacherForm = driver.getCurrentUrl();
		Assert.assertEquals(isAddTeacherForm, "http://localhost:3000/teacher/new");

		// fill form data
		addTeacherPage.enterTeacherData("Cillian", "Murphy", "cillian.murphy@gmail.com");

		// perform click on save button
		addTeacherPage.save();

		// wait for response to verify if the teacher has been added
		Thread.sleep(2000);

		// verify if adding the teacher has been successful
		String isTeacherAddedUrl = driver.getCurrentUrl();
		Assert.assertEquals(isTeacherAddedUrl, "http://localhost:3000/teacher/21");

		// perform click on Cancel(x) icon
		addTeacherPage.exitForm();
	}

}
