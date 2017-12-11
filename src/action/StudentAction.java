package action;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.RequestAware;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

import entities.Student;
import service.StudentService;

@Controller
public class StudentAction extends ActionSupport implements RequestAware, ModelDriven<Student>, Preparable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3547167288811425468L;

	@Resource
	private StudentService studentService;

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	private Map<String, Object> request;

	@Override
	public void setRequest(Map<String, Object> arg0) {
		this.request = arg0;
	}

	public String list() {
		String lastName = model.getLastName();
		String firstName = model.getFirstName();
		String age = model.getAge();
		if (lastName == null) {
			lastName = "";
		}
		if (firstName == null) {
			firstName = "";
		}
		if (age == null) {
			age = "";
		}
		List<Student> students = studentService.query(lastName, firstName, age);
		System.out.println(students);
		request.put("students", students);
		return "list";
	}

	private Integer id;

	public void setId(Integer id) {
		this.id = id;
	}

	public String delete() {
		try {
			studentService.delete(id);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}

	}

	public String save() {
		try {
			if (model == null) {
				return ERROR;
			} else {
				studentService.add(model);
				return SUCCESS;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	public String input() {
		request.put("students", studentService.getAll());
		return INPUT;
	}

	public String excel() {
		return "download";
	}

	public InputStream getDownloadFile() {
		return studentService.getInputStream();
	}

	private Student model;

	@Override
	public Student getModel() {
		return model;
	}

	@Override
	public void prepare() throws Exception {

	}

	public void prepareInput() {
		if (id != null) {
			model = studentService.get(id);
		}
	}

	public void prepareSave() {
		if (id == null) {
			model = new Student();
		} else {
			model = studentService.get(id);
		}

	}

	public void prepareList() {
		model = new Student();
	}

}
