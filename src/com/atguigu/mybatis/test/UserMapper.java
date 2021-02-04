package com.atguigu.mybatis.test;

import org.apache.ibatis.annotations.MapKey;

import java.util.List;
import java.util.Map;

public interface UserMapper {
        public User queryUserById(Integer id);

        public List<User> queryUsers();

        public int insertUser(User user);

        public int deleteUserById(Integer id);

        public int updateUser(User user);

        @MapKey("id")
        public Map<Integer,User> queryUsersForMap();


}
