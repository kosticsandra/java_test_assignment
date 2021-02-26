package com.alasdoo.tests.course.add;

import org.junit.Assert;
import org.junit.Test;

import com.alasdoo.pages.CoursePage;
import com.alasdoo.tests.FunctionalTest;

/***
* Tests adding a course, but deleting it instead
*/

public class AddButDeleteCourseTest extends FunctionalTest {
	
	@Test
	public void addButDeleteCourse() throws InterruptedException {

		// open landing page on UI
		driver.get("http://localhost:3000/student");

		// initialize course page
		CoursePage addCoursePage = new CoursePage(driver);

		// verify if page is opened
		Assert.assertTrue(addCoursePage.isInitialized());

		//open course page
		addCoursePage.goToCoursePage();

		// open add course form
		addCoursePage.openAddCourseForm();

		// verify if form is opened
		String isAddCourseForm = driver.getCurrentUrl();
		Assert.assertEquals(isAddCourseForm, "http://localhost:3000/course/new");

		// fill form data
		addCoursePage.enterCourseData("vim ei", 80, 6);

		// perform click on delete button
		addCoursePage.delete();

		// wait for response to verify if the course has been deleted
		Thread.sleep(2000);

		// verify if adding the course has been canceled
		String isCourseAddedUrl = driver.getCurrentUrl();
		Assert.assertEquals(isCourseAddedUrl, "http://localhost:3000/course");
	}


}
