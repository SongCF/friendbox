package com.scys.friendbox.biz.makefriends;

import com.scys.friendbox.biz.makefriends.model.BoxModel;
import com.scys.friendbox.dal.params.BoxQuery;
import com.scys.friendbox.utils.error.Result;

import java.util.List;

/**
 * 盲盒管理
 */
public interface FriendBoxManager {

    /**
     * 添加盲盒
     * @return
     */
    Result<Long> createBox(BoxModel boxModel);

    /**
     * 抽取一个盲盒
     * @return
     */
    Result<BoxModel> openOneBox(BoxQuery boxQuery);

    /**
     * 获取我抽取的盲盒历史
     * @return
     */
    Result<List<BoxModel>> queryOpenedBoxHistory(int pageNum, int pageSize);
}