package net.azurewebsites.krystiankatafoniapp.model;

import java.sql.Timestamp;
import java.util.Objects;

public class Purchase {
	private long id;
	private String purchasename;
	private User user;
	private Category category;
	private Shop shop;
	private float price;
	private Timestamp timestamp;

	public Purchase() {
	};

	public Purchase(Purchase purchase) {
		this.id = purchase.id;
		this.purchasename = purchase.purchasename;
		this.user = purchase.user;
		this.shop = purchase.shop;
		this.category = purchase.category;
		this.price = purchase.price;
		this.timestamp = purchase.timestamp;
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public String getPurchasename() {
		return purchasename;
	}

	public void setPurchasename(String purchasename) {
		this.purchasename = purchasename;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.id, this.purchasename, this.user, this.shop, this.category, this.price,
				this.timestamp);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Purchase) {
			Purchase purchase = (Purchase) obj;
			return Objects.equals(this.id, purchase.id) && Objects.equals(this.purchasename, purchase.purchasename)
					&& Objects.equals(this.user, purchase.user) && Objects.equals(this.shop, purchase.shop)
					&& Objects.equals(this.category, purchase.category)
					&& Objects.equals(this.price, purchase.price)&& Objects.equals(this.timestamp, purchase.timestamp);
		}
		return false;
	}
}
