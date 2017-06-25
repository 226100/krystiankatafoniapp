package net.azurewebsites.krystiankatafoniapp.model;

import java.util.Objects;

public class Category {
	long id;
	private String categoryname;
	private long userId;
	
	public Category(){};
	public Category(Category category){
		this.id=category.id;
		this.categoryname=category.categoryname;
		this.userId=category.userId;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	public void setUserId(long userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "Category [id="+ id + ", categoryname=" + categoryname + ", userId=" + userId + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(this.id, this.categoryname, this.userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Category) {
			Category category = (Category) obj;
			return Objects.equals(this.id, category.id)&&Objects.equals(this.categoryname, category.categoryname) && Objects.equals(this.userId, category.userId);
		}
		return false;
	}

}
