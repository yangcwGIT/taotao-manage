package com.taotao.manage.service;

import com.taotao.manage.mapper.ItemCatMapper;
import com.taotao.manage.pojo.ItemCat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * itemcat的service，用来对itemcat表进行业务逻辑处理
 * Created by liwenhong on 15/10/15.
 */
@Service
public class ItemCatService {
    @Autowired
    private ItemCatMapper itemCatMapper;
    //查询itemcat的所有父节点 并且返回
    public List<ItemCat> queryItemCatList(Long parentId) {
        ItemCat itemCat=new ItemCat();
        itemCat.setParentId(parentId);
        return this.itemCatMapper.select(itemCat);

    }
}
