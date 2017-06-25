package net.azurewebsites.krystiankatafoniapp.dao;

import java.util.List;

import net.azurewebsites.krystiankatafoniapp.model.Shop;

public interface ShopDAO extends GenericDAO<Shop, Long>{
	List<Shop> getAll(Long userId);
	
}
