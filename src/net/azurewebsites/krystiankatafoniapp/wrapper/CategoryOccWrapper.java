package net.azurewebsites.krystiankatafoniapp.wrapper;

import java.util.Objects;

import net.azurewebsites.krystiankatafoniapp.model.Category;

/**
 * This class is a wrapper for class Category. Object of this class contain
 * object of type Category 
 * occNumber - number which told how many time exact
 * category object occurs in purchases
 * percent - percent value, ratio occNumber/allCategoriesInPurchases
 * 
 * @author Krystian Katafoni
 * @version 1.0
 * @since 2017-07-16
 */

public class CategoryOccWrapper {
	
	/*Shop Object*/
	private Category category;
	/* Number of occurrences categories in purchases */
	private int occNumber;
	/*
	 * Number of occurrences categories in purchases divide by number of all categories
	 * which occurs in purchases
	 */
	private float percent;
	
	/*Getters and Setters*/
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
	
	/*Constructors*/
	public CategoryOccWrapper() {
		this.percent=0.0f;
	};

	public CategoryOccWrapper(Category category, int num) {
		this.category = category;
		this.occNumber = num;
		this.percent=0.0f;
	};
	/*Method equals*/
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
	/*Method which return hash Code*/
	@Override
	public int hashCode() {
		return Objects.hash(this.category, this.occNumber, this.percent);
	}
}
