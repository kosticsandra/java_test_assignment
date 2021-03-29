package com.alasdoo.tests.student.toggle_courses;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.alasdoo.pages.StudentPage;
import com.alasdoo.pages.ToggleCoursesPage;
import com.alasdoo.tests.FunctionalTest;

/***
 * Tests updating a course from student's course list
 */

public class StudentToggleCourseUpdateCourse extends FunctionalTest {

	@Test
	public void addNewCourseToStudentTable() throws InterruptedException {

		// open landing page on UI
		driver.get("http://localhost:3000/student");

		// initialize student page
		StudentPage updateStudentPage = new StudentPage(driver);

		// Initialize ToggleCourse
		ToggleCoursesPage toggleCoursePage = new ToggleCoursesPage(driver);

		// verify if page is opened
		Assertions.assertTrue(updateStudentPage.isInitialized());

		// perform click actions
		updateStudentPage.getAllStudents();

		// open add student form
		updateStudentPage.selectStudent();

		// verify if form is opened
		String isAddStudentCourseForm = driver.getCurrentUrl();
		Assertions.assertEquals(isAddStudentCourseForm, "http://localhost:3000/student/1");

		// toggle courses
		updateStudentPage.toggleCourses();

		// select course from the list
		toggleCoursePage.selectCourse();

		// adding course
		toggleCoursePage.updateCourse(7);

		// saving the updated course
		toggleCoursePage.saveCourse();

		// wait for response to verify if the course has been updated
		Thread.sleep(5000);

		// verify if the course was updated
		String isCourseUpdatedUrl = driver.getCurrentUrl();
		Assertions.assertEquals(isCourseUpdatedUrl, "http://localhost:3000/student/1/courses");

		// perform click on Cancel(x) icon
		updateStudentPage.exitForm();

	}

}
