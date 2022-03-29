package com.facto.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Data
@TableName("user")
public class User implements Serializable, UserDetails {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String username;
    private String nickname;
    private String password;
    private Boolean enabled;
    private String email;
    private String userface;

    @TableField(value = "create_time")//字段名与数据库字段名不一致时采用该形式进行映射
    private Date createTime;

    @TableField(value = "update_time")//字段名与数据库字段名不一致时采用该形式进行映射
    private Date updateTime;


    /**
     * 账号是否失效，true:账号有效，false账号失效。
     * @return
     */
    @Override
    @JsonIgnore//在json序列化时将pojo中的一些属性忽略掉，标记在属性或者方法上，返回的json数据即不包含该属性。
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 号是否被锁，true:账号没被锁，可用；false：账号被锁，不可用
     * @return
     */
    @Override
    @JsonIgnore//在json序列化时将pojo中的一些属性忽略掉，标记在属性或者方法上，返回的json数据即不包含该属性。
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 号认证是否过期，true:没过期，可用；false：过期，不可用
     * @return
     */
    @Override
    @JsonIgnore//在json序列化时将pojo中的一些属性忽略掉，标记在属性或者方法上，返回的json数据即不包含该属性。
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 账号是否可用，true:可用，false:不可用
     * @return
     */
    @Override
    @JsonIgnore//在json序列化时将pojo中的一些属性忽略掉，标记在属性或者方法上，返回的json数据即不包含该属性。
    public boolean isEnabled() {
        return this.enabled;
    }

    //如果没有设置权限的话，这里直接返回null即可
    @Override
    @JsonIgnore//在json序列化时将pojo中的一些属性忽略掉，标记在属性或者方法上，返回的json数据即不包含该属性。
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    @JsonIgnore//在json序列化时将pojo中的一些属性忽略掉，标记在属性或者方法上，返回的json数据即不包含该属性。
    public String getPassword() {
        return this.password;
    }

    @Override
    @JsonIgnore//在json序列化时将pojo中的一些属性忽略掉，标记在属性或者方法上，返回的json数据即不包含该属性。
    public String getUsername() {
        return this.username;
    }
}
