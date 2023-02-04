package com.project.MerryMeal.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "deliver_tb")
public class Deliver {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order orderid;
	@ManyToOne
	@JoinColumn(name = "member_id")
	private User riderid;
	private Date datetime;
	private boolean status;
	private boolean delivered;
	
	public Deliver() {}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Order getOrderid() {
		return orderid;
	}
	public void setOrderid(Order orderid) {
		this.orderid = orderid;
	}
	public User getRiderid() {
		return riderid;
	}
	public void setRiderid(User riderid) {
		this.riderid = riderid;
	}
	public Date getDatetime() {
		return datetime;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public boolean isDelivered() {
		return delivered;
	}
	public void setDelivered(boolean delivered) {
		this.delivered = delivered;
	}
	
}
