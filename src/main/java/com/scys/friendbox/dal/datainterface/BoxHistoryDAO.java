package com.scys.friendbox.dal.datainterface;

import com.scys.friendbox.dal.dataobject.BoxHistoryDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

/**
 * 盲盒历史数据
 */
public interface BoxHistoryDAO extends JpaRepository<BoxHistoryDO, Long> {


}