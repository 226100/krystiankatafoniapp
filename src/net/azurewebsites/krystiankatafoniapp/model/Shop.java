package net.azurewebsites.krystiankatafoniapp.model;

import java.util.Objects;
/**
 * Shop class is a model class of one shop
 * This model is correspond with the data
 * about shop in database
 * @author Krystian Katafoni
 * @version 1.0
 * @since 2017-06-5
 */
public class Shop {
	/* Shop id in db */
	private Long id;
	private String shopname;
	/* Id of user, who add this shop  */
	private Long userId;

	public Shop() {
	};

	public Shop(Shop shop) {
		this.id=shop.id;
		this.shopname = shop.shopname;
		this.userId = shop.userId;
	}
	public Shop(Long id, String shopname, Long userId){
		this.id=id;
		this.shopname=shopname;
		this.userId=userId;
	}
	public long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getShopname() {
		return shopname;
	}

	public void setShopname(String shopname) {
		this.shopname = shopname;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}



	@Override
	public String toString() {
		return "Shop [id=" + id + ", shopname=" + shopname + ", userId=" + userId + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.id,this.shopname, this.userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Shop) {
			Shop shop = (Shop) obj;
			return Objects.equals(this.id, shop.id)&&Objects.equals(this.shopname, shop.shopname) && Objects.equals(this.userId, shop.userId);
		}
		return false;
	}
}