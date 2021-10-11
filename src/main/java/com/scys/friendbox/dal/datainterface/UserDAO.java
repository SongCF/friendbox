package com.scys.friendbox.dal.datainterface;

import com.scys.friendbox.dal.dataobject.UserDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

/**
 * @author dx
 * @version : UserRepository.java, v 0.1 2021年10月10日 10:27 下午 dx Exp $
 */
public interface UserDAO extends JpaRepository<UserDO, Long> {

    //自定义SQL ： https://www.jianshu.com/p/8b61ef1f01bf

    @Query("select t from UserDO t where t.name=?1")
    UserDO getUserByName(String name);

    @Transactional
    @Modifying
    @Query("update UserDO t set t.name=?2 where t.id=?1")
    int setNameById(Long id, String name);

}