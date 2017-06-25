package net.azurewebsites.krystiankatafoniapp.dao;

import java.util.List;

import net.azurewebsites.krystiankatafoniapp.model.Purchase;

public interface PurchaseDAO extends GenericDAO<Purchase,Long> {
	List<Purchase> getAll(Long userId);
	Purchase getPurchaseByUserIdCategoryIdShopId(long userId,long CategoryId, long ShopId);
}
