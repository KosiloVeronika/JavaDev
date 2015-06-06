package com.epam.newyeargift.dao;

import com.epam.newyeargift.entity.GiftBox;

public interface DataAccessDao {
	public GiftBox getGiftFromSource(Object ... args) throws DaoException;
}
