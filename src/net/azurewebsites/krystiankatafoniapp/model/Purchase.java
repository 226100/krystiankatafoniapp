package net.azurewebsites.krystiankatafoniapp.model;

import java.sql.Timestamp;
import java.util.Objects;
/**
 * Purchase class is a model class of one purchase
 * This model is correspond with the data
 * about purchase in database
 * This model has user,category,shop objects, not only id
 * because it's easier in view layer to get access to 
 * displayed data
 * @author Krystian Katafoni
 * @version 1.0
 * @since 2017-06-5
 */
public class Purchase {
	/* Purchase id in db*/
	private Long id;
	/* Name of purchase*/
	private String purchasename;
	/* Object of user, who add this shop*/
	private User user;
	/* Category object assign to this purchase */
	private Category category;
	/* Shop object assign to this purchase*/
	private Shop shop;
	/* Price of purchase */
	private Float price;
	/* Time of added purchase to database */
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
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
