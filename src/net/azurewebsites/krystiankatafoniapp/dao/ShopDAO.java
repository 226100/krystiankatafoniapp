package net.azurewebsites.krystiankatafoniapp.dao;

import java.util.List;

import net.azurewebsites.krystiankatafoniapp.model.Shop;
import net.azurewebsites.krystiankatafoniapp.wrapper.ShopOccWrapper;

public interface ShopDAO extends GenericDAO<Shop, Long>{
	List<Shop> getAll(Long userId);
	int amountOfAllShops(Long userId);
	public List<ShopOccWrapper> getWrappedShops(long userId);
}
