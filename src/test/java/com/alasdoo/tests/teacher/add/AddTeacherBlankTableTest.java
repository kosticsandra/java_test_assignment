package com.alasdoo.tests.teacher.add;

import org.junit.Assert;
import org.junit.Test;

import com.alasdoo.pages.TeacherPage;
import com.alasdoo.tests.FunctionalTest;

/***
 * Tests adding a teacher into an empty table
 */

public class AddTeacherBlankTableTest extends FunctionalTest {

	@Test
	public void addTeacherBlankTable() throws InterruptedException {

		// open landing page on UI
		driver.get("http://localhost:3000/student");

		// initialize teacher page
		TeacherPage addTeacherPage = new TeacherPage(driver);

		// verify if page is opened
		Assert.assertTrue(addTeacherPage.isInitialized());

		// open teacher page
		addTeacherPage.goToTeacherPage();

		// open add teacher form
		addTeacherPage.openAddTeacherForm();

		// verify if form is opened
		String isAddTeacherForm = driver.getCurrentUrl();
		Assert.assertEquals(isAddTeacherForm, "http://localhost:3000/teacher/new");

		// fill form data
		addTeacherPage.enterTeacherData("Bella", "Gray", "bela.gray@gmail.com");

		// perform click on save button
		addTeacherPage.save();

		// wait for response to verify if the teacher has been added
		Thread.sleep(2000);

		// verify if adding the teacher has been successful
		String isTeacherAddedUrl = driver.getCurrentUrl();
		Assert.assertEquals(isTeacherAddedUrl, "http://localhost:3000/teacher/1");

		// perform click on Cancel(x) icon
		addTeacherPage.exitForm();
	}

}
