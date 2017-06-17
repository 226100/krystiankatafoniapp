package net.azurewebsites.krystiankatafoniapp.model;

import java.util.Objects;

public class Purchase {
	private String purchasename;
	private long userId;
	private long shopId;
	private long categoryId;

	Purchase() {
	};

	Purchase(Purchase purchase) {
		this.purchasename = purchase.purchasename;
		this.userId = purchase.userId;
		this.shopId = purchase.shopId;
		this.categoryId = purchase.categoryId;
	}

	public String getPurchasename() {
		return purchasename;
	}

	public void setPurchasename(String purchasename) {
		this.purchasename = purchasename;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getShopId() {
		return shopId;
	}

	public void setShopId(long shopId) {
		this.shopId = shopId;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	@Override
	public String toString() {
		return "Purchase [purchasename=" + purchasename + ", userId=" + userId + ", shopId=" + shopId + ", categoryId="
				+ categoryId + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.purchasename, this.userId, this.shopId, this.categoryId);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Purchase) {
			Purchase purchase = (Purchase) obj;
			return Objects.equals(this.purchasename, purchase.purchasename) && Objects.equals(this.userId, purchase.userId)
					&& Objects.equals(this.shopId, purchase.shopId) && Objects.equals(this.categoryId, purchase.categoryId);
		}
		return false;
	}
}
