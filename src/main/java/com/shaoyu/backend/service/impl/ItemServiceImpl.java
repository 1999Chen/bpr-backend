package com.shaoyu.backend.service.impl;

import com.shaoyu.backend.connection.MyBatisConnection;
import com.shaoyu.backend.mapper.ItemMapper;
import com.shaoyu.backend.model.Item;
import com.shaoyu.backend.service.IItemService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ItemServiceImpl implements IItemService {

    ItemMapper itemMapper;

    public ItemServiceImpl()  {
        SqlSession ss = MyBatisConnection.getConnection();
        itemMapper = ss.getMapper(ItemMapper.class);
    }

    @Override
    public Item getItemByName(String name) {
        List<Item>list  =itemMapper.selectItemByName(name);

        return list.get(0);
    }

    @Override
    public List<Item> getItemsByFilters(String keyword,List<String> regions, List<String>  categories) {
        List<Item> list = itemMapper.selectItemsByFilters("%"+keyword+"%",regions,categories);
        System.out.println("getitems by filters "+list);
        return list;
    }


    @Override
    public Item getItemById(int id) throws SQLException, ClassNotFoundException {
        Item Item = itemMapper.selectItemById(id);
        return  Item;
    }

    @Override
    public List<Item> getAllItems() throws ClassNotFoundException, SQLException {
        List<Item>list = itemMapper.getAllItems();
        System.out.println("get all items : "+list.size());
        System.out.println("get all items : "+list);
        return list;


    }

    @Override
    public String uploadItem(Item item) {
        System.out.println("user mapper start");
        System.out.println("info is "+item.getName());
//        User user = new User(username,password,nickname);
//        userMapper.insertAUser(new User(username,password,nickname));
        itemMapper.uploadItem(item.getName(),item.getDescription(),item.getRegion(),item.getImageBase64(),item.getPrice(),item.getStatus(),item.getQuantity());
        System.out.println("user mapper finished ");

        return "upload";
    }

    @Override
    public List<Item> getPrediction(int userId) {
        return null;
    }


    @Override
    public String updateItemInfo(Item item) {
        itemMapper.updateItem(item.getName(),item.getDescription(),item.getRegion(),item.getImageBase64(),item.getCategory(),item.getPrice(),
                item.getStatus(),item.getQuantity(),item.getId());
        return null;
    }

    @Override
    public void  removeItem(String itemName) throws SQLException, ClassNotFoundException {
        itemMapper.removeItem(itemName);
    }

    @Override
    public void  removeItems(String itemNames)  {
        itemMapper.removeItems(itemNames);
    }

    @Override
    public String removeItemsFromCart(List<String> itemNames) {
        return null;
    }

}
