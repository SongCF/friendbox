package com.scys.friendbox.dal.datainterface;

import com.scys.friendbox.dal.dataobject.BoxDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

/**
 * 盲盒数据
 */
public interface BoxDAO extends JpaRepository<BoxDO, Long> {

}