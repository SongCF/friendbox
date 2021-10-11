package com.scys.friendbox.biz.makefriends;

import com.scys.friendbox.biz.makefriends.model.BoxModel;
import com.scys.friendbox.dal.params.BoxQuery;

import java.util.List;

/**
 *
 * @author dx
 * @version : FriendBoxManager.java, v 0.1 2021年10月11日 3:45 下午 dx Exp $
 */
public interface FriendBoxManager {

    /**
     * 添加盲盒
     * @return
     */
    Long createBox(BoxModel boxModel);

    /**
     * 抽取一个盲盒
     * @return
     */
    BoxModel openOneBox(BoxQuery boxQuery);

    /**
     * 获取我抽取的盲盒历史
     * @return
     */
    List<BoxModel> getOpenedBoxHistory(int pageNum, int pageSize);
}