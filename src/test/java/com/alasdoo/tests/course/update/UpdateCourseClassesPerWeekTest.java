package com.alasdoo.tests.course.update;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.alasdoo.pages.CoursePage;
import com.alasdoo.tests.FunctionalTest;

/***
 * Tests updating the course's classes per week
 */

public class UpdateCourseClassesPerWeekTest extends FunctionalTest {
	
	@Test
	public void updateCourseClassesPerWeek() throws InterruptedException {
		// open landing page on UI
		driver.get("http://localhost:3000/student");

		// initialize teacher page
		CoursePage updateCoursePage = new CoursePage(driver);

		// verify if page is opened
		Assertions.assertTrue(updateCoursePage.isInitialized());

		// perform click actions
		updateCoursePage.getAllCourses();

		// perform click on course action
		updateCoursePage.selectCourse();

		// verify if form is opened
		String isUpdateButDeleteCourseForm = driver.getCurrentUrl();
		Assertions.assertEquals(isUpdateButDeleteCourseForm, "http://localhost:3000/course/1");

		// fill form data
		updateCoursePage.updateCoursesClassesPerWeek(9);

		// perform click on save button
		updateCoursePage.save();

		// wait for response to verify if the course was updated
		Thread.sleep(2000);

		// verify if the course is updated
		String isCourseClassesPerWeekUpdatedUrl = driver.getCurrentUrl();
		Assertions.assertEquals(isCourseClassesPerWeekUpdatedUrl, "http://localhost:3000/course/1");

		// perform click on Cancel(x) icon
		updateCoursePage.exitForm();
	}


}
