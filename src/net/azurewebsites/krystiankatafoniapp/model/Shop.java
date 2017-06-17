package net.azurewebsites.krystiankatafoniapp.model;

import java.util.Objects;

public class Shop {
	private String shopname;
	private long userId;

	public Shop() {
	};

	public Shop(Shop shop) {
		this.shopname = shop.shopname;
		this.userId = shop.userId;
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
		return "Shop [shopname=" + shopname + ", userId=" + userId + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.shopname, this.userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Shop) {
			Shop shop = (Shop) obj;
			return Objects.equals(this.shopname, shop.shopname) && Objects.equals(this.userId, shop.userId);
		}
		return false;
	}
}