package com.taotao.manage.controller;


import com.taotao.manage.pojo.ItemCat;
import com.taotao.manage.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by liwenhong on 15/10/15.
 */
@Controller
@RequestMapping("/item/cat")
public class ItemCatController {
    @Autowired
    private ItemCatService itemCatService;
    //查询所有的商品类目
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<ItemCat>> queryItemList(@RequestParam(value = "id",defaultValue = "0")Long parentId){
       try {
           //查询所有的商品类目
           List<ItemCat> itemCats = itemCatService.queryItemCatList(parentId);
           //如果没有找到就返回404
           if(itemCats==null&&itemCats.size()==0){
               //返回404
               System.err.println("===========");
               return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
           }
           //返回list集合
           return ResponseEntity.ok(itemCats);
       }catch (Exception e){
           e.printStackTrace();
       }
        //出异常 返回500 内部错误
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
}
