package com.facto.mapper;


import com.facto.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import java.util.List;

@Mapper
@Repository
public interface RoleMapper {
    /**
     * 通过用户id获取用户角色集合
     *
     * @param userId 用户id
     * @return List<Role> 角色集合
     */
    @Select("select * from role r,user_role ur where r.id = ur.rid and ur.uid = #{userId}")
    List<Role> getRolesByUserId(Integer userId);
}
