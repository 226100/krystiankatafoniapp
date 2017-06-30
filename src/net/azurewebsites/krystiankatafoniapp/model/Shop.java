package net.azurewebsites.krystiankatafoniapp.model;

import java.util.Objects;

public class Shop {
	private long id;
	private String shopname;
	private long userId;

	public Shop() {
	};

	public Shop(Shop shop) {
		this.id=shop.id;
		this.shopname = shop.shopname;
		this.userId = shop.userId;
	}
	public Shop(long id, String shopname, long userId){
		this.id=id;
		this.shopname=shopname;
		this.userId=userId;
	}
	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public void setUserId(long userId) {
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