package net.azurewebsites.krystiankatafoniapp.wrapper;

import java.util.Objects;

import net.azurewebsites.krystiankatafoniapp.model.Category;

/*This class is a wrapper for class Category. Object of this class contain object of type Category, occNumber - number which told how many time 
 * exact category object occurs in purchases, percent - percent value, ratio occNumber/allCategoriesInPurchases
 *  */

public class CategoryOccWrapper {
	private Category category;
	private int occNumber;// number of occurrences categories in purchases
	private float percent;// number of occurrences categories in purchases divide
							// by number of all categories which occurs in
							// purchases

	public float getPercent() {
		return percent;
	}

	public void setPercent(float percent) {
		this.percent = percent;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public int getOccNumber() {
		return occNumber;
	}

	public void setOccNumber(int occNumber) {
		this.occNumber = occNumber;
	}

	public CategoryOccWrapper() {
	};

	public CategoryOccWrapper(Category category, int num) {
		this.category = category;
		this.occNumber = num;
	};

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof CategoryOccWrapper) {
			CategoryOccWrapper categoryWrapper = (CategoryOccWrapper) obj;
			return Objects.equals(this.category, categoryWrapper.category)
					&& Objects.equals(this.occNumber, categoryWrapper.occNumber)
					&& Objects.equals(this.percent, categoryWrapper.percent);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.category, this.occNumber, this.percent);
	}
}
