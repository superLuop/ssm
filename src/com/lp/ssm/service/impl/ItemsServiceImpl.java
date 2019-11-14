package com.lp.ssm.service.impl;

import com.lp.ssm.mapper.ItemsMapper;
import com.lp.ssm.model.Items;
import com.lp.ssm.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ItemsServiceImpl implements ItemsService {
    @Autowired
    private ItemsMapper itemsMapper;
    @Override
    public List<Items> findAllItems() {
        return itemsMapper.findAllItems();
    }

    @Override
    public Items findItemsById(int id) {
        return itemsMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveOrUpdate(Items items) {

        if (items.getId() == null){
            itemsMapper.insert(items);
//            int i = 10 / 0;
        }else {
            itemsMapper.updateByPrimaryKeySelective(items);
        }
    }

    @Override
    public void delete(int id) {

        itemsMapper.deleteByPrimaryKey(id);
    }
}
