package co.grandcircus.lab.entity;

public class Grade {

	private Long id;
	private String name;
	private String score;
	private Double total;

	public Grade() {
	}

	public Grade(Long id, String name, String score, Double total) {
		super();
		this.id = id;
		this.name = name;
		this.score = score;
		this.total = total;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Room [id=" + id + ", name=" + name + ", score="
				+ score + ", total=" + total + "]";
	}

}
