package com.lp.ssm.service;

import com.lp.ssm.model.Items;

import java.util.List;

public interface ItemsService {
    public List<Items> findAllItems();
    public Items findItemsById(int id);
    public void saveOrUpdate(Items items);
    public void delete(int id);
}
