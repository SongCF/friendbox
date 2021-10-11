package com.scys.friendbox.biz.makefriends.impl;

import com.scys.friendbox.biz.makefriends.FriendBoxManager;
import com.scys.friendbox.biz.makefriends.model.BoxModel;
import com.scys.friendbox.dal.datainterface.BoxDAO;
import com.scys.friendbox.dal.datainterface.UserDAO;
import com.scys.friendbox.dal.dataobject.UserDO;
import com.scys.friendbox.dal.params.BoxQuery;
import com.scys.friendbox.utils.error.Result;
import com.scys.friendbox.utils.template.BizEventBO;
import com.scys.friendbox.utils.template.HandleCallback;
import com.scys.friendbox.utils.template.TransTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author dx
 * @version : FriendBoxManager.java, v 0.1 2021年10月11日 3:45 下午 dx Exp $
 */
@Service
public class FriendBoxManagerImpl implements FriendBoxManager {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private BoxDAO boxDAO;

    @Autowired
    private TransTemplate transTemplate;

    @Override
    public Result<Long> createBox(BoxModel boxModel) {
        Result<Long> result = new Result<>();

        transTemplate.execute(result, new BizEventBO(), new HandleCallback() {
            @Override
            public void process() {
                Optional<UserDO> user = userDAO.findById(1L);
                throw new RuntimeException(user.get().getId().toString());
            }
        });

        return result;
    }

    @Override
    public Result<BoxModel> openOneBox(BoxQuery boxQuery) {
        return null;
    }

    @Override
    public Result<List<BoxModel>> getOpenedBoxHistory(int pageNum, int pageSize) {
        return null;
    }
}