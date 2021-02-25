package com.alasdoo.tests.student.add;

import org.junit.Assert;
import org.junit.Test;

import com.alasdoo.pages.student.AddStudentPage;
import com.alasdoo.tests.FunctionalTest;

/***
 * Tests adding a student into an empty table
 */
public class AddStudentBlankTableTest extends FunctionalTest {

	@Test
	public void addStudentBlankTable() throws InterruptedException {

		// open landing page on UI
		driver.get("http://localhost:3000/student");

		// initialize student page
		AddStudentPage addStudentPage = new AddStudentPage(driver);

		// verify if page is opened
		Assert.assertTrue(addStudentPage.isInitialized());

		// open add student form
		addStudentPage.openAddStudentForm();

		// verify if form is opened
		String isAddStudentForm = driver.getCurrentUrl();
		Assert.assertEquals(isAddStudentForm, "http://localhost:3000/student/new");

		// fill form data
		addStudentPage.enterStudentData("Jane", "Doe", "JaneD", "janedoe@test.com", 112233);

		// perform click on save button
		addStudentPage.save();

		// wait for response to verify if the student has been added
		Thread.sleep(2000);

		// verify added student, if it's added to the table
		String isStudentAddedUrl = driver.getCurrentUrl();
		Assert.assertEquals(isStudentAddedUrl, "http://localhost:3000/student/1");

		// perform click on Cancel(x) icon
		addStudentPage.exitForm();
	}

}
