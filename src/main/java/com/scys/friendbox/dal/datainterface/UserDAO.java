package com.scys.friendbox.dal.datainterface;

import com.scys.friendbox.dal.dataobject.UserDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.LockModeType;

/**
 * @author dx
 * @version : UserRepository.java, v 0.1 2021年10月10日 10:27 下午 dx Exp $
 */
public interface UserDAO extends JpaRepository<UserDO, Long> {

    //自定义SQL ： https://www.jianshu.com/p/8b61ef1f01bf

    @Query("select t from UserDO t where t.name=?1")
    UserDO getUserByName(String name);

    @Modifying
    @Query("update UserDO t set t.cnt=?2 where t.id=?1")
    int updateCntById(Long id, Integer cnt);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select t from UserDO t where id = ?1")
    UserDO lockById(Long id);
}