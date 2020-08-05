package com.mapper.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.daiso.security.Account;

@Mapper
public interface AccountMapper {
    @Select("SELECT * FROM USER WHERE id=#{id}")
    Account readAccount(String id);

    @Select("SELECT authority_name FROM AUTHORITY WHERE username=#{m_userid}")
    List<String> readAutorities(String id);

    @Insert("INSERT INTO USER VALUES(#{account.id},#{account.password},#{account.isAccountNonExpired},#{account.isAccountNonLocked},#{account.isCredentialsNonExpired},#{account.isEnabled},#{account.nickname},#{account.email})")
    void insertUser(@Param("account") Account account);

    @Insert("INSERT INTO AUTHORITY VALUES(#{id},#{autority})")
    void insertUserAutority(@Param("id") String id, @Param("autority") String autority);

    @Select("SELECT* FROM USER")
    List readAllUsers();
}