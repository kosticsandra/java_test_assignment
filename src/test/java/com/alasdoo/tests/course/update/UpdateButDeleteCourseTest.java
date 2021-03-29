package com.alasdoo.tests.course.update;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.alasdoo.pages.CoursePage;
import com.alasdoo.tests.FunctionalTest;

/***
 * Tests updating a course but deleting it instead
 */

public class UpdateButDeleteCourseTest extends FunctionalTest {

	@Test
	public void updateButDeleteCourse() throws InterruptedException {
		// open landing page on UI
		driver.get("http://localhost:3000/student");

		// initialize teacher page
		CoursePage updateButDeleteCoursePage = new CoursePage(driver);

		// verify if page is opened
		Assertions.assertTrue(updateButDeleteCoursePage.isInitialized());

		// perform click actions
		updateButDeleteCoursePage.getAllCourses();

		// perform click on course action
		updateButDeleteCoursePage.selectCourse();

		// verify if form is opened
		String isUpdateButDeleteCourseForm = driver.getCurrentUrl();
		Assertions.assertEquals(isUpdateButDeleteCourseForm, "http://localhost:3000/course/1");

		// fill form data
		updateButDeleteCoursePage.updateAllCourseData("Neque porro", 66, 5);

		// perform click on delete button
		updateButDeleteCoursePage.delete();

		// wait for response to verify if the course was updated
		Thread.sleep(2000);

		// verify if the course is updated
		String isCourseUpdatedButDeletedUrl = driver.getCurrentUrl();
		Assertions.assertEquals(isCourseUpdatedButDeletedUrl, "http://localhost:3000/course");
	}

}
