package com.alasdoo.tests.course.add;

import com.alasdoo.pages.CoursePage;
import com.alasdoo.tests.FunctionalTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/***
 * Tests adding a course into a blank table
 */

public class AddCourseBlankTableTest extends FunctionalTest {

	@Test
	public void addBlankTableCourse() throws InterruptedException {

		// open landing page on UI
		driver.get("http://localhost:3000/student");

		// initialize course page
		CoursePage addCoursePage = new CoursePage(driver);

		// verify if page is opened
		Assertions.assertTrue(addCoursePage.isInitialized());

		// open course page
		addCoursePage.goToCoursePage();

		// open add course form
		addCoursePage.openAddCourseForm();

		// verify if form is opened
		String isAddCourseForm = driver.getCurrentUrl();
		Assertions.assertEquals(isAddCourseForm, "http://localhost:3000/course/new");

		// fill form data
		addCoursePage.enterCourseData("dolorem ipsum", 70, 7);

		// perform click on save button
		addCoursePage.save();

		// wait for response to verify if the course has been added
		Thread.sleep(2000);

		// verify if adding the course has been successful
		String isCourseAddedUrl = driver.getCurrentUrl();
		Assertions.assertEquals(isCourseAddedUrl, "http://localhost:3000/course/1");

		// perform click on Cancel(x) icon
		addCoursePage.exitForm();
	}

}
