package questionanswers;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class questionOne {

    public static class CourseInfo {
        private String name;
        private String course;
        private String fee;

        public CourseInfo(String name, String course, String fee) {
            this.name = name;
            this.course = course;
            this.fee = fee;
        }

        // Getters for the properties
        public String getName() {
            return name;
        }

        public String getCourse() {
            return course;
        }

        public String getFee() {
            return fee;
        }

        @Override
        public String toString() {
            return "CourseInfo{" +
                    "name='" + name + '\'' +
                    ", course='" + course + '\'' +
                    ", fee='" + fee + '\'' +
                    '}';
        }
    }

    public static List<CourseInfo> readExcelData(String filePath) {
        List<CourseInfo> courseInfos = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(new File(filePath));
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet firstSheet = workbook.getSheetAt(0);
            for (int i = 1; i <= firstSheet.getLastRowNum(); i++) {
                Row row = firstSheet.getRow(i);
                String name = row.getCell(0).getStringCellValue();
                String course = row.getCell(1).getStringCellValue();
                String fee = row.getCell(2).getStringCellValue();
                courseInfos.add(new CourseInfo(name, course, fee));
            }
            workbook.close();
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return courseInfos;
    }

    public static void main(String[] args) {
        String filePath = "src/main/resources/data.xlsx";
        List<CourseInfo> courses = readExcelData(filePath);
        for (CourseInfo course : courses) {
            System.out.println(course);
        }
    }
}
