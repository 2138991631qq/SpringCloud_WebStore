package com.itheima.dao;

/**
 * Created by itcast on 2019/10/31.
 */
import com.itheima.b2b.commonmodule.model.Goods;
import com.itheima.b2b.commonmodule.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@Mapper
public interface GoodsDao {
    //查询所有商品
    List<Goods> getAllgoods();


    //根据商品名称模糊查找
    List<Goods> getOnegoods(@Param(value = "gname")String gname);
    //根据id查询单个商品详情
    Goods getOnegid(@Param(value = "gid")int gid);

    //insert到goods表里数据
    int insertGoods(@Param(value = "gname") String gname, @Param(value = "gremain") String gremain, @Param(value = "gdetails")String gdetails, @Param(value = "gprice")int gprice, @Param(value = "types")int types);

    int updateGoods(@Param(value = "gname") String gname, @Param(value = "gremain") String gremain, @Param(value = "gdetails")String gdetails, @Param(value = "gprice")int gprice, @Param(value = "types")int types, @Param(value = "gid")int gid);

    int deleteGoods(@Param(value = "gid") int gid);
}
