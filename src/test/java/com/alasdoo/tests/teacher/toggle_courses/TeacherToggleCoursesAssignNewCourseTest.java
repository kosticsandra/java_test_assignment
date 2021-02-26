package com.alasdoo.tests.teacher.toggle_courses;

import org.junit.Assert;
import org.junit.Test;

import com.alasdoo.pages.TeacherPage;
import com.alasdoo.pages.ToggleCoursesPage;
import com.alasdoo.tests.FunctionalTest;

/***
 * Tests assigning a course into the teacher's list of courses
 */

public class TeacherToggleCoursesAssignNewCourseTest extends FunctionalTest {

	@Test
	public void assignTeacherNewCourse() throws InterruptedException {

		// open landing page on UI
		driver.get("http://localhost:3000/student");

		// initialize teacher page
		TeacherPage assignTeacherCoursePage = new TeacherPage(driver);

		// Initialize ToggleCourse
		ToggleCoursesPage toggleCoursePage = new ToggleCoursesPage(driver);

		// verify if page is opened
		Assert.assertTrue(assignTeacherCoursePage.isInitialized());

		// perform click actions
		assignTeacherCoursePage.getAllTeachers();

		// select a teacher from the table
		assignTeacherCoursePage.selectTeacher();

		// verify if form is opened
		String isAddTeacherCourseForm = driver.getCurrentUrl();
		Assert.assertEquals(isAddTeacherCourseForm, "http://localhost:3000/teacher/1");

		// toggle courses
		assignTeacherCoursePage.toggleCourses();

		// adding course
		toggleCoursePage.assignCourseToList();

		// save the assigned course
		toggleCoursePage.saveCourse();

		// wait for response to verify if the course has been assigned
		Thread.sleep(5000);

		// verify added course, if it's added to the table
		String isCourseAssignedUrl = driver.getCurrentUrl();
		Assert.assertEquals(isCourseAssignedUrl, "http://localhost:3000/teacher/1/courses");

		// perform click on Cancel(x) icon
		assignTeacherCoursePage.exitForm();

	}

}
