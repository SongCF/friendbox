package com.scys.friendbox.biz.makefriends.impl;

import com.scys.friendbox.biz.makefriends.FriendBoxManager;
import com.scys.friendbox.biz.makefriends.model.BoxModel;
import com.scys.friendbox.dal.params.BoxQuery;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author dx
 * @version : FriendBoxManager.java, v 0.1 2021年10月11日 3:45 下午 dx Exp $
 */
@Service
public class FriendBoxManagerImpl implements FriendBoxManager {
    @Override
    public Long createBox(BoxModel boxModel) {
        return null;
    }

    @Override
    public BoxModel openOneBox(BoxQuery boxQuery) {
        return null;
    }

    @Override
    public List<BoxModel> getOpenedBoxHistory(int pageNum, int pageSize) {
        return null;
    }
}