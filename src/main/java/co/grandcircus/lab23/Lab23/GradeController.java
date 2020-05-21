package co.grandcircus.lab23.Lab23;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.grandcircus.lab.entity.Grade;
import co.grandcircus.lab23.Lab23.dao.GradeDao;

@Controller
public class GradeController {
	
	
	@Autowired
	private GradeDao gradeDao;
	
	@RequestMapping("/")
	public String index() {
		return "redirect:/grade";
	}
	
	@RequestMapping("/grade")
	public String list(Model model) {
		List<Grade> grade = gradeDao.findAll();
		model.addAttribute("grade", grade);
		return "list";
	}
	
	
	@RequestMapping("/grade/detail")
	public String gradeDetails(@RequestParam("id") Long id, Model model) {
		Grade grade = gradeDao.findById(id);
		model.addAttribute("grade", grade);
		return "detail";
	}
	
	@RequestMapping("/grade/add")
	public String showAddForm() {
		return "add";
	}
	
	@PostMapping("/grade/add")
	public String submitAddForm(Grade grade) {
		gradeDao.create(grade);
		return "redirect:/grade";
	}
	
	@RequestMapping("/grade/delete")
	public String deleteGrade(@RequestParam("id") Long id) {
		gradeDao.delete(id);
		return "redirect:/grade";
	}
	
	@RequestMapping("/grade/edit")
	public String edit(@RequestParam("id") Long id, Model model) {
		Grade grade = gradeDao.findById(id);
		model.addAttribute("grade", grade);
		return "edit";
	}
	
	@PostMapping("/grade/edit")
	public String save(Grade grade) {
		gradeDao.update(grade);
		return "redirect:/grade/detail?id=" + grade.getId();
	}
}


