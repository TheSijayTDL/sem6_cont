package lv.venta.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import lv.venta.services.IFilteringService;

@Controller
public class FilterController {
	
	@Autowired
	private IFilteringService filterService;
	
	@GetMapping("/info/showAllStudents") // localhost:8080/info/showAllStudents
	public String getAllStudents(Model model) {
		model.addAttribute("students", filterService.retrieveAllStudents());
		return "all-students-page";
	}
	
	@GetMapping("/info/showAllProfessors") // localhost:8080/info/showAllProfessors
	public String getAllProfessors(Model model) {
		model.addAttribute("professors", filterService.retrieveAllProfessors());
		return "all-professors-page";
	}
	
	@GetMapping("/info/showAllGrades") // localhost:8080/info/showAllGrades
	public String getAllGrades(Model model) {
		model.addAttribute("grades", filterService.retrieveAllGrades());
		return "all-grades-page";
	}
	
	@GetMapping("/info/showAllCourses") // localhost:8080/info/showAllCourses
	public String getAllCourses(Model model) {
		model.addAttribute("courses", filterService.retrieveAllCourses());
		return "all-courses-page";
	}
	
	@GetMapping("/info/showAllGradesByStudent/{id}") // localhost:8080/info/showAllGradesByStudent/1
	public String getAllGradesByStudent(@PathVariable("id") long id, Model model) {
		try {
			model.addAttribute("grades", filterService.retrieveGradesByStudentId(id));
			return "all-grades-page";
		} catch (Exception e) {
			model.addAttribute("msg", e.getMessage());
			return "error-page";
		}
	}
	
	@GetMapping("/info/showAllCoursesByStudent/{id}") // localhost:8080/info/showAllCoursesByStudent/1
	public String getAllCoursesByStudent(@PathVariable("id") long id, Model model) {
		try {
			model.addAttribute("courses", filterService.retrieveAllCoursesByStudentId(id));
			return "all-courses-page";
		} catch (Exception e) {
			model.addAttribute("msg", e.getMessage());
			return "error-page";
		}
	}
	
	@GetMapping("/info/showAllCoursesByProfessor/{id}") // localhost:8080/info/showAllCoursesByProfessor/1
	public String getAllCoursesByProfessor(@PathVariable("id") long id, Model model) {
		try {
			model.addAttribute("courses", filterService.retrieveAllCoursesByProfessorId(id));
			return "all-courses-page";
		} catch (Exception e) {
			model.addAttribute("msg", e.getMessage());
			return "error-page";
		}
	}
}
