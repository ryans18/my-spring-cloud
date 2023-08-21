package com.ryans.mapper;

import com.ryans.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface UserMapper {

    List<User> getListAll();
    User getUser(Long id);
    boolean save(User user);
    boolean delete(User user);
}
