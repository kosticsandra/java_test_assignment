package com.alasdoo.tests.teacher.toggle_courses;

import org.junit.Assert;
import org.junit.Test;

import com.alasdoo.pages.TeacherPage;
import com.alasdoo.pages.ToggleCoursesPage;
import com.alasdoo.tests.FunctionalTest;

/***
 * Tests assigning a course into the teacher's list of courses but canceling in
 * the end
 */
public class TeacherToggleCoursesAssignNewCourseButCancelTest extends FunctionalTest {

	@Test
	public void assignTeacherNewCourseButCancel() throws InterruptedException {

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

		// canceling everything
		toggleCoursePage.cancelAction();

		// wait for response to verify if the course has been assigned but canceled
		Thread.sleep(5000);

		// verify added course, if it's added to the table
		String isCourseAssignedButCanceledUrl = driver.getCurrentUrl();
		Assert.assertEquals(isCourseAssignedButCanceledUrl, "http://localhost:3000/teacher/1");

		// perform click on Cancel(x) icon
		assignTeacherCoursePage.exitForm();

	}

}
