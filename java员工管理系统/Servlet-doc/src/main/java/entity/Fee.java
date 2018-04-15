package entity;

public class Fee {
	
	private int id;
	private String name;
	private int base_duration;
	private double base_cost;
	private double unit_cost;
	private String status;
	private String descr;
	private String creatime;
	private String startime;
	private String cost_type;
	@Override
	public String toString() {
		return "Fee [id=" + id + ", name=" + name + ", base_duration=" + base_duration + ", base_cost=" + base_cost
				+ ", unit_cost=" + unit_cost + ", status=" + status + ", descr=" + descr + ", creatime=" + creatime
				+ ", startime=" + startime + ", cost_type=" + cost_type + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBase_duration() {
		return base_duration;
	}
	public void setBase_duration(int base_duration) {
		this.base_duration = base_duration;
	}
	public double getBase_cost() {
		return base_cost;
	}
	public void setBase_cost(double base_cost) {
		this.base_cost = base_cost;
	}
	public double getUnit_cost() {
		return unit_cost;
	}
	public void setUnit_cost(double unit_cost) {
		this.unit_cost = unit_cost;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	public String getCreatime() {
		return creatime;
	}
	public void setCreatime(String creatime) {
		this.creatime = creatime;
	}
	public String getStartime() {
		return startime;
	}
	public void setStartime(String startime) {
		this.startime = startime;
	}
	public String getCost_type() {
		return cost_type;
	}
	public void setCost_type(String cost_type) {
		this.cost_type = cost_type;
	}
	
}
