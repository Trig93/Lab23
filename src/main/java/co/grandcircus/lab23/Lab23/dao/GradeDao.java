package co.grandcircus.lab23.Lab23.dao;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import co.grandcircus.lab.entity.Grade;


@Repository
public class GradeDao {
	
	
	@Autowired
	private JdbcTemplate jdbc;

	public List<Grade> findAll() {
		
		return jdbc.query("SELECT * FROM grade", new BeanPropertyRowMapper<>(Grade.class));
	}
	
	public Grade findById(Long id) {
		 
		Grade match = jdbc.queryForObject("SELECT * FROM grade WHERE id = ?", new BeanPropertyRowMapper<>(Grade.class), id);
		
		return match;
	}
	
	public void update(Grade grade) {
		String sql = "UPDATE grade SET name = ?, score = ?, total = ? WHERE id = ?";
		
		jdbc.update(sql, grade.getName(), grade.getScore(), grade.getTotal(), grade.getId());
	}
	
	public void create(Grade grade) {
		String sql = "INSERT INTO grade (name, total, score) VALUES (?, ?, ?)";
		jdbc.update(sql, grade.getName(), grade.getScore(), grade.getTotal());
	}
	
	public void delete(Long id) {
		String sql = "DELETE FROM grade WHERE id = ?";
		jdbc.update(sql, id);
	}
	
}
