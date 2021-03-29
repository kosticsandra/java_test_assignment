package com.alasdoo.tests.course.delete;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.alasdoo.pages.CoursePage;
import com.alasdoo.tests.FunctionalTest;

/***
 * Tests deleting a course
 */

public class DeleteCourseTest extends FunctionalTest {

	@Test
	public void deleteCourse() throws InterruptedException {

		// open landing page on UI
		driver.get("http://localhost:3000/student");

		// initialize course page
		CoursePage deleteCoursePage = new CoursePage(driver);

		// verify if page is opened
		Assertions.assertTrue(deleteCoursePage.isInitialized());

		// fill the course table
		deleteCoursePage.getAllCourses();

		// wait for table to get filled
		Thread.sleep(4000);

		// click on the selected course
		deleteCoursePage.selectCourse();

		// verify if form is opened
		String isDeleteCourseForm = driver.getCurrentUrl();
		Assertions.assertEquals(isDeleteCourseForm, "http://localhost:3000/course/1");

		// perform click on delete button
		deleteCoursePage.delete();

		// wait for response to verify if the course has been deleted
		Thread.sleep(2000);

		// verify if adding the course has been canceled
		String isCourseAddedUrl = driver.getCurrentUrl();
		Assertions.assertEquals(isCourseAddedUrl, "http://localhost:3000/course");
	}

}
