package net.azurewebsites.krystiankatafoniapp.wrapper;

import java.util.Objects;

import net.azurewebsites.krystiankatafoniapp.model.Shop;

/**
 * This class is a wrapper for class Shop. Object of this class contain object
 * of type Shop, occNumber - number which told how many time exact shop object
 * occurs in purchases, percent - percent value, ratio
 * occNumber/allShopsInPurchases
 * 
 * @author Krystian Katafoni
 * @version 1.0
 * @since 2017-07-16
 */
public class ShopOccWrapper {
	/* Shop object */
	private Shop shop;
	/* Number of occurrences shops in purchases */
	private int occNumber;
	/*
	 * Number of occurrences shops in purchases divide by number of all shops
	 * which occurs in purchases
	 */
	private float percent;

	/* Getters and Setters */

	public float getPercent() {
		return percent;
	}

	public void setPercent(float percent) {
		this.percent = percent;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public int getOccNumber() {
		return occNumber;
	}

	public void setOccNumber(int occNumber) {
		this.occNumber = occNumber;
	}

	/* Constructors */
	public ShopOccWrapper() {
	};

	public ShopOccWrapper(Shop shop, int num) {
		this.shop = shop;
		this.occNumber = num;
	};

	/* Equals method */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ShopOccWrapper) {
			ShopOccWrapper shopWrapper = (ShopOccWrapper) obj;
			return Objects.equals(this.shop, shopWrapper.shop) && Objects.equals(this.occNumber, shopWrapper.occNumber)
					&& Objects.equals(this.percent, shopWrapper.percent);
		}
		return false;
	}

	/* Method generating hash code */
	@Override
	public int hashCode() {
		return Objects.hash(this.shop, this.occNumber, this.percent);
	}
}