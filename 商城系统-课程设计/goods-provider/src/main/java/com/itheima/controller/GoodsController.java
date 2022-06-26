package com.itheima.controller;

/**
 * Created by itcast on 2019/10/31.
 */
import com.itheima.b2b.commonmodule.model.Goods;
import com.itheima.b2b.commonmodule.model.User;
import com.itheima.dao.GoodsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
public class GoodsController {
    @Autowired
    GoodsDao goodsDao;


    @RequestMapping(value = "/getAllgoods",method = RequestMethod.GET)
    public List<Goods> getAllgoods(){
        return goodsDao.getAllgoods();
    };




    @RequestMapping(value = "/getOnegoods",method = RequestMethod.GET)
    public List<Goods> getOnegoods(@RequestParam(value = "gname")String gname){
        return goodsDao.getOnegoods(gname);
    }
    @RequestMapping(value = "/getOnegid",method = RequestMethod.GET)
    public Goods getOnegid(@RequestParam(value = "gid")int gid){
        return goodsDao.getOnegid(gid);
    }
    @RequestMapping(value = "/insertGoods",method = RequestMethod.GET)
    public int insertGoods(@RequestParam(value = "gname") String gname, @RequestParam(value = "gremain") String gremain, @RequestParam(value = "gdetails")String gdetails,@RequestParam(value = "gprice")int gprice,@RequestParam(value = "types")int types){
        return goodsDao.insertGoods(gname,gremain,gdetails,gprice,types);
    }

    @RequestMapping(value = "/updateGoods",method = RequestMethod.GET)
    public int updateGoods(@RequestParam(value = "gname") String gname, @RequestParam(value = "gremain") String gremain, @RequestParam(value = "gdetails")String gdetails,@RequestParam(value = "gprice")int gprice,@RequestParam(value = "types")int types,@RequestParam(value = "gid")int gid){
        return goodsDao.updateGoods(gname,gremain,gdetails,gprice,types,gid);
    }

    @RequestMapping(value = "/deleteGoods",method = RequestMethod.GET)
    public int deleteGoods(@RequestParam(value = "gid")int gid){
        return goodsDao.deleteGoods(gid);
    }



}
