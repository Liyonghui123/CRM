package com.douyu.controller;

import com.douyu.dao.UserMapper;
import com.douyu.pojo.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



/**
 * @description:
 * @author: Dangerous
 * @time: 2020/3/7 11:56
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserMapper userMapper;

    /**
     * 新增客户
     * @param user
     * @return
     */
    @ApiOperation(value = "saveUser",notes = "添加用户")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> saveUser(User user){
        try {
            userMapper.insert(user);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

    /**
     * 更新客户
     * @param user
     * @return
     */

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Void> updateUser(User user){
        try {
            userMapper.updateByPrimaryKey(user);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

    /**
     * 删除客户
     * @param
     * @return
     */
    @ApiOperation(value = "deleteUser",notes = "删除用户")
    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteUser(@RequestParam(value = "id",defaultValue = "0")Long id ){
        try {
            if(id.intValue()==0){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
            userMapper.deleteByPrimaryKey(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

    /**
     * 查询客户
     * @param id
     * @return
     */
    @ApiOperation(value = "queryUser",notes = "查询用户")
    @RequestMapping(value="{id}",method = RequestMethod.GET)
    public ResponseEntity<User> queryUser(@PathVariable Long id ){
        try {
            User user = userMapper.selectByPrimaryKey(id);
            if(null==user){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            return ResponseEntity.ok(user);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }


}
