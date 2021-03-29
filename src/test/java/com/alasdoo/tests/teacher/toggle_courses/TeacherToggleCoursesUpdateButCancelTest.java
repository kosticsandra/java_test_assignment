package com.alasdoo.tests.teacher.toggle_courses;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.alasdoo.pages.TeacherPage;
import com.alasdoo.pages.ToggleCoursesPage;
import com.alasdoo.tests.FunctionalTest;

/***
 * Tests updating a course from the teacher's list of courses but canceling
 */

public class TeacherToggleCoursesUpdateButCancelTest extends FunctionalTest {

	@Test
	public void cancelUpdateTeacherCourse() throws InterruptedException {

		// open landing page on UI
		driver.get("http://localhost:3000/student");

		// initialize teacher page
		TeacherPage cancelUpdateTeacherCourse = new TeacherPage(driver);

		// Initialize ToggleCourse
		ToggleCoursesPage toggleCoursePage = new ToggleCoursesPage(driver);

		// verify if page is opened
		Assertions.assertTrue(cancelUpdateTeacherCourse.isInitialized());

		// perform click actions
		cancelUpdateTeacherCourse.getAllTeachers();

		// select a teacher from the table
		cancelUpdateTeacherCourse.selectTeacher();

		// verify if form is opened
		String isCanceledTeacherCourseForm = driver.getCurrentUrl();
		Assertions.assertEquals(isCanceledTeacherCourseForm, "http://localhost:3000/teacher/1");

		// toggle courses
		cancelUpdateTeacherCourse.toggleCourses();

		// adding course
		toggleCoursePage.selectCourse();

		// cancel the action
		toggleCoursePage.cancelAction();

		// wait for response to verify if the action was canceled
		Thread.sleep(5000);

		// verify selected course, if the action is canceled
		String isCourseCanceledUrl = driver.getCurrentUrl();
		Assertions.assertEquals(isCourseCanceledUrl, "http://localhost:3000/teacher/1/courses");

		// perform click on Cancel(x) icon
		cancelUpdateTeacherCourse.exitForm();

	}

}
