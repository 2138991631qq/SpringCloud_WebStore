package com.itheima.controller;

/**
 * Created by itcast on 2019/10/31.
 */
import com.itheima.b2b.commonmodule.model.Cart;
import com.itheima.b2b.commonmodule.model.Goods;
import com.itheima.b2b.commonmodule.model.User;
import com.itheima.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@Controller
@RequestMapping("/goods")
public class GoodsController {

    /**上传地址*/
    @Value("${file.upload.path}")
    private String filePath;


    @Autowired
    GoodsService goodsService;

    //退出登录并跳转回登录页面
    @GetMapping(value = "quit")
    public String quit(HttpSession session) {
        session.removeAttribute("uaccount");
        return "redirect:http://localhost:8893/admin/tologin";
    }

    //首页查询全部商品并分类显示
    @GetMapping(value = "/getAll")
    public String getAll(HttpServletRequest request, String uaccount,
                         String upassword, String uname, HttpSession session) {
        session.setAttribute("uaccount", uaccount);
        session.setAttribute("uname",uname);
        session.setAttribute("upassword",upassword);
        List<Goods> goods1 = new ArrayList<>();
        List<Goods> goods2 = new ArrayList<>();
        List<Goods> goods3 = new ArrayList<>();
        List<Goods> goods4 = new ArrayList<>();
        List<Goods> goods5 = new ArrayList<>();

        List<Goods> oldgoods = goodsService.getAllgoods();
        for (Goods newgoods : oldgoods) {
            System.out.print(newgoods.getTypes());
            if (newgoods.getTypes().equals(1)) {
                goods1.add(newgoods);
            }
            if (newgoods.getTypes().equals(2)) {
                goods2.add(newgoods);
            }
            if (newgoods.getTypes().equals(0)) {
                goods3.add(newgoods);
            }
            if (newgoods.getTypes().equals(3)) {
                goods4.add(newgoods);
            }
            if (newgoods.getTypes().equals(4)) {
                goods5.add(newgoods);
            }
        }
        request.setAttribute("goods1", goods1);
        request.setAttribute("goods2", goods2);
        request.setAttribute("goods3", goods3);
        request.setAttribute("goods4", goods4);
        request.setAttribute("goods5", goods5);
        return "index";
    }


    //跳转到8893的toupdateuser
    @GetMapping(value = "/toupdateuserinfo")
    public String toupdateuserinfo(HttpSession session,HttpServletRequest request) {
        String a = (String)session.getAttribute("uaccount");
        System.out.println("a+"+a);
        return "redirect:http://localhost:8893/admin/toupdateuserinfo?uaccount="+a;
    }



    //跳转到管理员的管理商品信息的界面并展示出所有商品
    @GetMapping(value = "/togoodsinfo")
    public String togoodsinfo(HttpSession session,HttpServletRequest request) {
        String a = (String)session.getAttribute("uaccount");
        List<Goods> goods = goodsService.getAllgoods();
        request.setAttribute("goods",goods);
        System.out.println(request.getAttribute("goods"));
        return "goodsinfo";
    }



    //goodsinfo界面点击新增商品，跳转到insertgoods.html
    @GetMapping(value = "/toinsertgoods")
    public String toinsertgoods(HttpSession session,HttpServletRequest request) {
        String a = (String)session.getAttribute("uaccount");

        System.out.println();

        return "uploadimg";
    }


    @GetMapping(value = "/imgtoinsertgoods")
    public String imgtoinsertgoods(HttpSession session,HttpServletRequest request,String filename) {
        String a = (String)session.getAttribute("uaccount");


        System.out.println(a);


        request.setAttribute("filename",filename);

        return "insertgoods";
    }



    // 跳转上传页面
    @RequestMapping("/tupian")
    public String test() {
        return "uploadimg";
    }
    //测试图片上传
    @GetMapping(value = "/imgupload")
    public String imgupload(@RequestParam("file") MultipartFile file, Model model) {
        // 获取上传文件名
        String filename = file.getOriginalFilename();
        // 定义上传文件保存路径
        String path = filePath+"rotPhoto/";
        // 新建文件
        File filepath = new File(path, filename);
        // 判断路径是否存在，如果不存在就创建一个
        if (!filepath.getParentFile().exists()) {
            filepath.getParentFile().mkdirs();
        }
        try {
            // 写入文件
            file.transferTo(new File(path + File.separator + filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 将src路径发送至html页面
        model.addAttribute("filename", "/img/rotPhoto/"+filename);
        return "index";
    }




    //goodsinfo界面点击修改商品，跳转到updategoods.html
    @GetMapping(value = "/toupdategoods")
    public String toupdategoods(HttpSession session,HttpServletRequest request,String gid) {
        String a = (String)session.getAttribute("uaccount");
        Goods good  = goodsService.getOnegid(Integer.parseInt(gid));
        System.out.println(good);
        request.setAttribute("good",good);
        return "updategoods";
    }


    //goodsinfo界面点击新增商品，跳转到insertgoods.html
    @GetMapping(value = "/insertgoods")
    public String insertgoods(HttpSession session,HttpServletRequest request,
           String gname,String gremain,String gdetails,String gprice,String types ) {
        String a = (String)session.getAttribute("uaccount");
        System.out.println(gname+";"+gremain+";"+gdetails+";"+gprice+";"+types);
        int  i  = goodsService.insertGoods(gname,gremain,gdetails,Integer.parseInt(gprice),Integer.parseInt(types));
        System.out.println(i+"若为1则insert成功");
        if (i>0){
            return "redirect:/goods/togoodsinfo";
        }else {
            return "insertgoodserror";
        }
    }


    //goodsinfo界面点击修改商品，跳转到updategoods.html
    @GetMapping(value = "/updategoods")
    public String updategoods(HttpSession session,HttpServletRequest request,
                            String gid,  String gname,String gremain,String gdetails,String gprice,String types ) {
        String a = (String)session.getAttribute("uaccount");
        System.out.println(gname+";"+gremain+";"+gdetails+";"+gprice+";"+types);
        int  i  = goodsService.updateGoods(gname,gremain,gdetails,Integer.parseInt(gprice),Integer.parseInt(types),Integer.parseInt(gid));
        System.out.println(i+"若为1则update成功");
        if (i>0){
            return "redirect:/goods/togoodsinfo";
        }else {
            return "insertgoodserror";
        }
    }


    @GetMapping(value = "/deleteGoods")
    public String deleteGoods(HttpSession session,HttpServletRequest request,String gid){

        System.out.println(gid);
        int i = goodsService.deleteGoods(Integer.parseInt(gid));

        System.out.println(i);

        return "redirect:/goods/togoodsinfo";
    }










    //商品详情-即根据ID查询单个商品
    @GetMapping(value = "/detail")
    public String detail(HttpServletRequest request,int gid) {
        request.setAttribute("detail", goodsService.getOnegid(gid));

        return "detail";

    }

    //商品首页搜索-根据名称模糊查找商品
    @GetMapping(value = "/getOne")
    public String getOne(HttpServletRequest request, String name) {
        List<Goods> goods1 = new ArrayList<>();
        List<Goods> goods2 = new ArrayList<>();
        List<Goods> goods3 = new ArrayList<>();
        List<Goods> goods4 = new ArrayList<>();
        List<Goods> oldgoods = goodsService.getOnegoods(name);
        for (Goods newgoods : oldgoods) {
            System.out.print(newgoods.getTypes());
            if (newgoods.getTypes().equals(1)) {
                goods1.add(newgoods);
            }
            if (newgoods.getTypes().equals(2)) {
                goods2.add(newgoods);
            }
            if (newgoods.getTypes().equals(0)) {
                goods3.add(newgoods);
            }
            if (newgoods.getTypes().equals(3)) {
                goods4.add(newgoods);
            }
        }
        request.setAttribute("goods1", goods1);
        request.setAttribute("goods2", goods2);
        request.setAttribute("goods3", goods3);
        request.setAttribute("goods4", goods4);
        return "index";
    }

    //加入购物车-将商品加入购物车并查询出全部商品如果有商品修改商品数量
    @GetMapping(value = "cart")
    public  String cart(HttpServletRequest request,String name,String price,String che,String number,HttpSession session){


        String uid = (String)session.getAttribute("uaccount");

        System.out.println(uid);

        System.out.println("name+number+che+price"+name+"数量"+number+"车"+che+"价格"+price);

        List<Cart> usercart= goodsService.getAllcart(Integer.parseInt(uid));
        int n = Integer.parseInt(price);
        for (int i=0;i<usercart.size();i++){
            if (usercart.get(i).getGoodid()==Integer.parseInt(che)){
                goodsService.updateCart(Integer.parseInt(number),usercart.get(i).getId());
                return  "redirect:/goods/cartAll";
            }
        }
        goodsService.intcart(name, Integer.parseInt(number),n,Integer.parseInt(che),Integer.parseInt(uid));
        return "redirect:/goods/cartAll";
//        return "a";
    }
    // 查询购物车全部商品
    @GetMapping(value = "cartAll")
    public  String cartAll(HttpServletRequest request,HttpSession session){
        String uid = (String) session.getAttribute("uaccount");
        List<Cart> cart =  goodsService.getAllcart(Integer.parseInt(uid));
        List<Goods> goods =  new ArrayList<>();
        for(Cart cart1 : cart ){
            System.out.println(cart);
            int gid =  cart1.getGoodid();
            Goods good = goodsService.getOnegid(gid);
            goods.add(good);
            System.out.println(goods);
        }

        int totalprice = 0;
        for(Cart cart2:cart){
            int n = cart2.getPrice();
            totalprice = totalprice+n;
        }
        System.out.println("总价为"+totalprice);

        int num = goods.size();
        System.out.println("goods长度为"+goods.size());
        request.setAttribute("goods",goods);
        request.setAttribute("carts",
                cart);
        request.setAttribute("totalprice",totalprice);
        request.setAttribute("num",num);

        return "Settle";

    }


    //删除购物车，根据id删除购物车商品
    @GetMapping(value = "deleteCart")
    public String deleteCart(HttpServletRequest request,String did){
        goodsService.deleteCart(Integer.parseInt(did));
        return "redirect:/goods/cartAll";
    }
    //添加订单并调用删除购物车（即购买之后删除购物车商品）
    @GetMapping(value = "/paygoods")
    public String paygoods(HttpServletRequest request,String[] goodid,String[] numaa,HttpSession session,String[] id){
        String uid = (String) session.getAttribute("uaccount");
        if (goodid.length == 0||numaa.length== 0||id.length == 0){
            return  "redirect:/goods/cartAll";
        }else {
            for (int i = 0; i < goodid.length; i++) {
                goodsService.insertOrder(
                        goodsService.getOnegid(Integer.parseInt(goodid[i])).gname, Integer.parseInt(numaa[i]), Integer.parseInt(numaa[i])* goodsService.getOnegid(Integer.parseInt(goodid[i])).gprice, Integer.parseInt(uid));
                goodsService.deleteCart
                        (goodsService.deleteCart(Integer.parseInt(id[i])));
            }
            request.setAttribute("mag3", "购买失败");
            return "redirect:/goods/getAllorder";
            //项目完成后可以修改跳转到订单页面return "redirect:/goods/getAllorder";
        }
    }


    //details页面确认数量form核算总共价格
    @GetMapping(value = "/confirmmun")
    public String confirmmun(HttpServletRequest request,HttpSession session,String number,String gid){

        System.out.println(number);
        System.out.println(gid);


        Goods good = goodsService.getOnegid(Integer.parseInt(gid));
        System.out.println(good.gprice);

        int totalMoney = Integer.parseInt(number)* good.gprice;

        System.out.println(totalMoney);

        request.setAttribute("gid",gid);

        int id = Integer.parseInt(gid);

        request.setAttribute("totalMoney",totalMoney);
        request.setAttribute("detail", goodsService.getOnegid(id));

        request.setAttribute("number",number);
        return "detail";


//        return "redirect:http://localhost:8896/goods/detail?gid="+Integer.parseInt(gid)+"&totalMoney="+totalMoney;
//        return "a";
    }



    //根据用户查询登陆者的历史购买记录
    @GetMapping(value = "/getAllorder")
    public String getAllorder(HttpServletRequest request,HttpSession session){
        String uid = (String) session.getAttribute("uaccount");
        request.setAttribute("order",goodsService.getAllorder(Integer.parseInt(uid)));
        if (uid.equals(null)){
            return "redirect:http://localhost:8893/admin/tologin";
        }
        return "order";
    }


}