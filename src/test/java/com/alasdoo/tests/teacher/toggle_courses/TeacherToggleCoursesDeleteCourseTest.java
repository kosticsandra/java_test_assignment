package com.alasdoo.tests.teacher.toggle_courses;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.alasdoo.pages.TeacherPage;
import com.alasdoo.pages.ToggleCoursesPage;
import com.alasdoo.tests.FunctionalTest;

/***
 * Tests deleting a course from the teacher's list of courses
 */

public class TeacherToggleCoursesDeleteCourseTest extends FunctionalTest {

	@Test
	public void deleteTeacherCourse() throws InterruptedException {

		// open landing page on UI
		driver.get("http://localhost:3000/student");

		// initialize teacher page
		TeacherPage deleteTeacherCoursePage = new TeacherPage(driver);

		// Initialize ToggleCourse
		ToggleCoursesPage toggleCoursePage = new ToggleCoursesPage(driver);

		// verify if page is opened
		Assertions.assertTrue(deleteTeacherCoursePage.isInitialized());

		// perform click actions
		deleteTeacherCoursePage.getAllTeachers();

		// select a teacher from the table
		deleteTeacherCoursePage.selectTeacher();

		// verify if form is opened
		String isDeleteTeacherCourseForm = driver.getCurrentUrl();
		Assertions.assertEquals(isDeleteTeacherCourseForm, "http://localhost:3000/teacher/1");

		// toggle courses
		deleteTeacherCoursePage.toggleCourses();

		// adding course
		toggleCoursePage.selectCourse();

		// delete the selected course
		toggleCoursePage.deleteCourse();

		// wait for response to verify if the course has been deleted
		Thread.sleep(5000);

		// verify selected course, if it's deleted from
		String isCourseDeletedUrl = driver.getCurrentUrl();
		Assertions.assertEquals(isCourseDeletedUrl, "http://localhost:3000/teacher/1/courses");

		// perform click on Cancel(x) icon
		deleteTeacherCoursePage.exitForm();

	}
}
