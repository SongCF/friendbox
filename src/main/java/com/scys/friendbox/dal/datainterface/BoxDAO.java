package com.scys.friendbox.dal.datainterface;

import com.scys.friendbox.dal.dataobject.BoxDO;
import com.scys.friendbox.dal.dataobject.UserDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.LockModeType;

/**
 * 盲盒数据
 */
public interface BoxDAO extends JpaRepository<BoxDO, Long> {

    //没有cnt>0的了也可以开箱保底，所以先按cnt desc排序
    @Query("select t from BoxDO t order by t.cnt desc t.gmtCreate desc limit 1")
    BoxDO queryOneBox();

    @Modifying
    @Query("update BoxDO t set t.cnt=t.cnt-1 where t.id=?1")
    int subCntById(Long id);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select t from BoxDO t where id = ?1")
    BoxDO lockById(Long id);
}