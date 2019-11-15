package com.lp.ssm.web.controller;

import com.lp.ssm.model.Items;
import com.lp.ssm.service.ItemsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("items")
public class ItemsController {

    private static final Logger logger = LoggerFactory.getLogger(ItemsController.class);
    @Autowired
    private ItemsService itemsService;

    @RequestMapping("list")
    public String list(Model model){
        logger.info("---------获取商品列表--------info-----");
        logger.debug("---------获取商品列表--------debug-----");
        logger.error("---------获取商品列表--------error-----");
        //查数据
        List<Items> itemsList = itemsService.findAllItems();
        //2.存数据
        model.addAttribute("itemsList",itemsList);
        return "items/list";
    }

    @RequestMapping("add")
    public String add(){
        return "items/add";
    }

    @RequestMapping("save")
    public String save(Items items){
        //保存数据
        itemsService.saveOrUpdate(items);
        return "redirect:list.do";
    }

    @RequestMapping("delete")
    public String delete(int id){
        itemsService.delete(id);
        return "forward:list.do";
    }

    @RequestMapping("update")
    public String update(Items items){

        itemsService.saveOrUpdate(items);
        return "redirect:list.do";
    }
    @RequestMapping("edit")
    public String edit(int id,Model model){

        //通过id找到商品
        Items items = itemsService.findItemsById(id);
        if (items != null){
            model.addAttribute("items",items);
        }
        return "items/edit";
    }
}
