package com.ln;

import com.ln.entity.UserModel;
import com.ln.mapper.UserMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description
 * @Author HeZhipeng
 * @Date 2022/2/20 22:57
 **/
@SpringBootApplication
@MapperScan(basePackages = "com.ln.mapper")
public class ShardingSphereApplication {


    public static void main(String[] args){
        SpringApplication.run(ShardingSphereApplication.class, args);
    }





    @RestController
    class TestController{

        @Resource
        UserMapper userMapper;

        @GetMapping("/add")
        public Object add(){

            UserModel model = new UserModel();
            //model.setId(2);
            model.setName("test2");
            model.setAge(1);
            userMapper.insert(model);
            return "ok";
        }


        @GetMapping("/list")
        public Object list(){

            return userMapper.selectAll();
        }


        @GetMapping("/like")
        public Object like(){

            return userMapper.selectLike("%2%");
        }

        @GetMapping("/page")
        public Object page(){

            return userMapper.selectLikePage("%2%");
        }

    }

    
    
}
