package com.alasdoo.tests.student.toggle_courses;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.alasdoo.pages.StudentPage;
import com.alasdoo.pages.ToggleCoursesPage;
import com.alasdoo.tests.FunctionalTest;

/***
 * Tests adding a course into the student's list of courses
 */

public class StudentToggleCourseAddNewCourseTest extends FunctionalTest {

	@Test
	public void addNewCourseToStudentTable() throws InterruptedException {

		// open landing page on UI
		driver.get("http://localhost:3000/student");

		// initialize student page
		StudentPage addStudentCoursePage = new StudentPage(driver);

		// Initialize ToggleCourse
		ToggleCoursesPage toggleCoursePage = new ToggleCoursesPage(driver);

		// verify if page is opened
		Assertions.assertTrue(addStudentCoursePage.isInitialized());

		// perform click actions
		addStudentCoursePage.getAllStudents();

		// select a student from the table
		addStudentCoursePage.selectStudent();

		// verify if form is opened
		String isAddStudentCourseForm = driver.getCurrentUrl();
		Assertions.assertEquals(isAddStudentCourseForm, "http://localhost:3000/student/1");

		// toggle courses
		addStudentCoursePage.toggleCourses();

		// adding course
		toggleCoursePage.addCourseToList(4);

		// saving the new course
		toggleCoursePage.saveCourse();

		// wait for response to verify if the course has been added to the table
		Thread.sleep(5000);

		// verify added course, if it's added to the table
		String isCourseAddedUrl = driver.getCurrentUrl();
		Assertions.assertEquals(isCourseAddedUrl, "http://localhost:3000/student/1/courses");

		// perform click on Cancel(x) icon
		addStudentCoursePage.exitForm();

	}

}
