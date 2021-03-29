package com.alasdoo.tests.student.toggle_courses;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.alasdoo.pages.StudentPage;
import com.alasdoo.pages.ToggleCoursesPage;
import com.alasdoo.tests.FunctionalTest;

/***
 * Tests deleting a course from student's course list
 */

public class StudentToggleCourseDeleteCourseTest extends FunctionalTest {

	@Test
	public void addNewCourseToStudentTable() throws InterruptedException {

		// open landing page on UI
		driver.get("http://localhost:3000/student");

		// initialize student page
		StudentPage deleteStudentCoursePage = new StudentPage(driver);

		// Initialize ToggleCourse
		ToggleCoursesPage toggleCoursePage = new ToggleCoursesPage(driver);

		// verify if page is opened
		Assertions.assertTrue(deleteStudentCoursePage.isInitialized());

		// perform click actions
		deleteStudentCoursePage.getAllStudents();

		// open add student form
		deleteStudentCoursePage.selectStudent();

		// verify if form is opened
		String isAddStudentCourseForm = driver.getCurrentUrl();
		Assertions.assertEquals(isAddStudentCourseForm, "http://localhost:3000/student/1");

		// toggle courses
		deleteStudentCoursePage.toggleCourses();

		// select course from the list
		toggleCoursePage.selectCourse();

		// adding course
		toggleCoursePage.deleteCourse();

		// wait for response to verify if the course has been deleted
		Thread.sleep(5000);

		// verify if the course was deleted from the table
		String isCourseDeletedUrl = driver.getCurrentUrl();
		Assertions.assertEquals(isCourseDeletedUrl, "http://localhost:3000/student/1/courses");

		// perform click on Cancel(x) icon
		deleteStudentCoursePage.exitForm();

	}

}
