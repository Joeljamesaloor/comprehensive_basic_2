package questionanswers;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class QuestionOneTest {

    @Test(priority = 1, enabled = true, timeOut = 30000)
    public void testReadExcelData() {
        // Provide the correct path to your Excel file
        String filePath = "src/main/resources/data.xlsx";

        // Call the static method from questionOne and store the result
        List<questionOne.CourseInfo> courses = questionOne.readExcelData(filePath);

        // Print out the results for each CourseInfo object
        for (questionOne.CourseInfo course : courses) {
            System.out.println("Course: " + course.getCourse());
            System.out.println("Name: " + course.getName());
            System.out.println("Fee: " + course.getFee());
            System.out.println("---------------");
        }

        // Perform assertions
        Assert.assertNotNull(courses, "The course list should not be null.");
        Assert.assertFalse(courses.isEmpty(), "The course list should not be empty.");

        // Additional assertions can be made to validate the correctness of the data
        // For example, you can check if the first course has the expected values
        // Assert.assertEquals(courses.get(0).getCourseName(), "Expected Course Name");
    }
}
