package com.miaoubich.vegestore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vegetables")
public class Vegetable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private long price;
	private long quantity;
	private String fridge;
	
	public Vegetable() {}
	public Vegetable(int id, String name, long price, long quantity, String fridge) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.fridge = fridge;
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
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	public String getFridge() {
		return fridge;
	}
	public void setFridge(String fridge) {
		this.fridge = fridge;
	}
	
	@Override
	public String toString() {
		return "Vegetable [id=" + id + ", name=" + name + ", price=" + price + ", quantity=" + quantity + ", fridge="
				+ fridge + "]";
	}
}
