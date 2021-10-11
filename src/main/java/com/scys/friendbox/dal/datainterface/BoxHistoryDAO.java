package com.scys.friendbox.dal.datainterface;

import com.scys.friendbox.dal.dataobject.BoxHistoryDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

/**
 * @author dx
 * @version : UserRepository.java, v 0.1 2021年10月10日 10:27 下午 dx Exp $
 */
public interface BoxHistoryDAO extends JpaRepository<BoxHistoryDO, Long> {


}