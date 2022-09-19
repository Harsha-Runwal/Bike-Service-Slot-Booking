package com.bssb.entity;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="SERVICE_PLAN")
public class Plan {
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PLAN_ID")
	private int id;
	private String name;
	private String description;
	private String image;
	private float cost;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="SERVICE_CENTER_ID")
	private ServiceCenter serviceCenterId;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Operations> operationList;

	public Plan() {
	
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	

	public Set<Operations> getOperationList() {
		return operationList;
	}

	public void setOperationList(Set<Operations> operationList) {
		this.operationList = operationList;
	}
	
	
	
	
	

}
