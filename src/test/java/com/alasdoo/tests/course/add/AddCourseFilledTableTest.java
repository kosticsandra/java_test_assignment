package com.alasdoo.tests.course.add;

import org.junit.Assert;
import org.junit.Test;

import com.alasdoo.pages.CoursePage;
import com.alasdoo.tests.FunctionalTest;

/***
 * Tests adding a course into a filled table
 */

public class AddCourseFilledTableTest extends FunctionalTest {

	@Test
	public void addFilledTableCourse() throws InterruptedException {

		// open landing page on UI
		driver.get("http://localhost:3000/student");

		// initialize course page
		CoursePage addCoursePage = new CoursePage(driver);

		// verify if page is opened
		Assert.assertTrue(addCoursePage.isInitialized());

		// fill the course table
		addCoursePage.getAllCourses();

		// wait for table to get filled
		Thread.sleep(4000);

		// open add course form
		addCoursePage.openAddCourseForm();

		// verify if form is opened
		String isAddCourseForm = driver.getCurrentUrl();
		Assert.assertEquals(isAddCourseForm, "http://localhost:3000/course/new");

		// fill form data
		addCoursePage.enterCourseData(" amet, consectetur", 71, 8);

		// perform click on save button
		addCoursePage.save();

		// wait for response to verify if the course has been added
		Thread.sleep(2000);

		// verify if adding the course has been successful
		String isCourseAddedUrl = driver.getCurrentUrl();
		Assert.assertEquals(isCourseAddedUrl, "http://localhost:3000/course/21");

		// perform click on Cancel(x) icon
		addCoursePage.exitForm();
	}

}
