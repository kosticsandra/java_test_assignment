package com.alasdoo.tests.teacher.add;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.alasdoo.pages.TeacherPage;
import com.alasdoo.tests.FunctionalTest;

/***
 * Tests adding a teacher, but deleting it instead
 */
public class AddButDeleteTeacherTest extends FunctionalTest {
	
	@Test
	public void addButDeleteTeacher() throws InterruptedException {

		// open landing page on UI
		driver.get("http://localhost:3000/student");

		// initialize teacher page
		TeacherPage addTeacherPage = new TeacherPage(driver);

		// verify if page is opened
		Assertions.assertTrue(addTeacherPage.isInitialized());
		
		//open teacher page
		addTeacherPage.goToTeacherPage();

		// open add teacher form
		addTeacherPage.openAddTeacherForm();

		// verify if form is opened
		String isAddTeacherForm = driver.getCurrentUrl();
		Assertions.assertEquals(isAddTeacherForm, "http://localhost:3000/teacher/new");

		// fill form data
		addTeacherPage.enterTeacherData("Bella", "Gray", "bela.gray@gmail.com");

		// perform click on delete button
		addTeacherPage.delete();

		// wait for response to verify if the teacher has been added
		Thread.sleep(2000);

		// verify if adding the teacher has been canceled
		String isTeacherAddedUrl = driver.getCurrentUrl();
		Assertions.assertEquals(isTeacherAddedUrl, "http://localhost:3000/teacher");
	}

}
