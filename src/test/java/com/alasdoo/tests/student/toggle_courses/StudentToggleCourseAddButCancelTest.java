package com.alasdoo.tests.student.toggle_courses;

import org.junit.Assert;
import org.junit.Test;

import com.alasdoo.pages.StudentPage;
import com.alasdoo.pages.ToggleCoursesPage;
import com.alasdoo.tests.FunctionalTest;

/***
 * Tests adding a course into the student's list of courses but canceling in the
 * end
 */

public class StudentToggleCourseAddButCancelTest extends FunctionalTest {

	@Test
	public void addNewCourseToStudentTable() throws InterruptedException {

		// open landing page on UI
		driver.get("http://localhost:3000/student");

		// initialize student page
		StudentPage addStudentCoursePage = new StudentPage(driver);

		// Initialize ToggleCourse
		ToggleCoursesPage toggleCoursePage = new ToggleCoursesPage(driver);

		// verify if page is opened
		Assert.assertTrue(addStudentCoursePage.isInitialized());

		// perform click actions
		addStudentCoursePage.getAllStudents();

		// select a student from the table
		addStudentCoursePage.selectStudent();

		// verify if form is opened
		String isAddStudentCourseForm = driver.getCurrentUrl();
		Assert.assertEquals(isAddStudentCourseForm, "http://localhost:3000/student/1");

		// toggle courses
		addStudentCoursePage.toggleCourses();

		// adding course
		toggleCoursePage.addCourseToList(4);

		// canceling everything
		toggleCoursePage.cancelAction();

		// wait for response to verify if the course has been added but canceled
		Thread.sleep(5000);

		// verify added course, if it's added to the table
		String isCourseAddedUrl = driver.getCurrentUrl();
		Assert.assertEquals(isCourseAddedUrl, "http://localhost:3000/student/1/courses");

		// perform click on Cancel(x) icon
		addStudentCoursePage.exitForm();

	}

}
