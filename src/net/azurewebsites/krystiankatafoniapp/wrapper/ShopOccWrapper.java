package net.azurewebsites.krystiankatafoniapp.wrapper;

import java.util.Objects;

import net.azurewebsites.krystiankatafoniapp.model.Shop;

/*This class is a wrapper for class Shop. Object of this class cointain object of type Shop, occNumber - number which told how many time 
 * exact shop object occurs in purchases, percent - percent value, ratio occNumber/allShopsInPurchases
 *  */
public class ShopOccWrapper {
	private Shop shop;//shop object
	private int occNumber;// number of occurrences shops in purchases
	private float percent;//number of occurences shops in purchases divide by number of all shops which occurs in purchases

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

	public ShopOccWrapper() {
	};

	public ShopOccWrapper(Shop shop, int num) {
		this.shop = shop;
		this.occNumber = num;
	};

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ShopOccWrapper) {
			ShopOccWrapper shopWrapper = (ShopOccWrapper) obj;
			return Objects.equals(this.shop, shopWrapper.shop) && Objects.equals(this.occNumber, shopWrapper.occNumber)
					&& Objects.equals(this.percent, shopWrapper.percent);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.shop, this.occNumber, this.percent);
	}
}
