package service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.annotation.Resource;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Service;

import dao.StudentDao;
import entities.Student;

@Service
public class StudentService {

	@Resource
	private StudentDao studentDao;

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	public List<Student> getAll() {
		System.out.println(studentDao.getAll());
		return studentDao.getAll();
	}

	public void delete(Integer id) {
		studentDao.delete(id);
	}

	public void add(Student student) {
		studentDao.add(student);
	}

	public Student get(Integer id) {
		return studentDao.get(id);
	}

	public List<Student> query(String lastName, String firstName, String age) {
		return studentDao.query(lastName, firstName, age);
	}

	public InputStream getInputStream() {

		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("sheet1");
		HSSFRow row = sheet.createRow(0);

		HSSFCell cell = row.createCell((short) 0);
		cell.setCellValue(new HSSFRichTextString("ÐòºÅ"));

		cell = row.createCell((short) 2);
		cell.setCellValue(new HSSFRichTextString("ÐÕ"));

		cell = row.createCell((short) 3);
		cell.setCellValue(new HSSFRichTextString("Ãû"));

		cell = row.createCell((short) 4);
		cell.setCellValue(new HSSFRichTextString("ÄêÁä"));

		List<Student> list = studentDao.getAll();
		for (int i = 0; i < list.size(); ++i) {
			Student student = list.get(i);

			row = sheet.createRow(i + 1);

			cell = row.createCell((short) 0);
			cell.setCellValue(new HSSFRichTextString(String.valueOf(student.getId())));

			cell = row.createCell((short) 2);
			cell.setCellValue(new HSSFRichTextString(student.getFirstName()));

			cell = row.createCell((short) 3);
			cell.setCellValue(new HSSFRichTextString(student.getLastName()));

			cell = row.createCell((short) 4);
			cell.setCellValue(new HSSFRichTextString(String.valueOf(student.getAge())));
		}

		ByteArrayOutputStream os = new ByteArrayOutputStream();

		try {
			wb.write(os);
		} catch (IOException e) {
			e.printStackTrace();
		}
		byte[] content = os.toByteArray();

		InputStream is = new ByteArrayInputStream(content);

		return is;
	}
}
