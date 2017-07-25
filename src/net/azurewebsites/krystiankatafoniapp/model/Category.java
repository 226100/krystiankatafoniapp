package net.azurewebsites.krystiankatafoniapp.model;

import java.util.Objects;

/**
 * Shop class is a model class of one category This model is correspond with the
 * data about category in database
 * 
 * @author Krystian Katafoni
 * @version 1.0
 * @since 2017-06-5
 */
public class Category {
	/* Category id in db */
	Long id;
	private String categoryname;
	/* Id of user, who add this category */
	private Long userId;

	public Category() {
	};

	public Category(Category category) {
		this.id = category.id;
		this.categoryname = category.categoryname;
		this.userId = category.userId;
	}

	public Category(Long id, String categoryname, Long userId) {
		this.id = id;
		this.categoryname = categoryname;
		this.userId = userId;
	}

	public long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", categoryname=" + categoryname + ", userId=" + userId + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.id, this.categoryname, this.userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Category) {
			Category category = (Category) obj;
			return Objects.equals(this.id, category.id) && Objects.equals(this.categoryname, category.categoryname)
					&& Objects.equals(this.userId, category.userId);
		}
		return false;
	}

}
