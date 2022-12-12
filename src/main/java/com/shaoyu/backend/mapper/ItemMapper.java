package com.shaoyu.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.shaoyu.backend.model.Item;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ItemMapper extends BaseMapper<Item> {

    List<Item> selectItemsByFilters(String keyword, List<String> regions, List<String> categories);

    List<Item> selectItemsByFiltersTest(String keyword);


    List<Item> selectItemByName(String name);

    List<Item> getAllItems();

    Item selectItemById(Integer id);

    List<Item> selectItemsByRegion(Integer personId);

//    @Insert("insert into items (name,description,region,imageBase64,price,status,quantity,id) values(#{name},#{description},#{region},#{imageBase64},#{price},#{status},#{quantity},null)")

    void uploadItem(String name, String description, String region, String imageBase64, double price, boolean status, int quantity);
    void updateItem(String name, String description, String region, String imageBase64, double price, boolean status, int quantity);


    List<Item> selectItemByYear(@Param("minYear") int minYear, @Param("maxYear") int maxYear);


}
