package com.scys.friendbox.biz.makefriends.impl;

import com.scys.friendbox.biz.makefriends.FriendBoxManager;
import com.scys.friendbox.biz.makefriends.model.BoxModel;
import com.scys.friendbox.dal.datainterface.BoxDAO;
import com.scys.friendbox.dal.datainterface.UserDAO;
import com.scys.friendbox.dal.dataobject.BoxDO;
import com.scys.friendbox.dal.dataobject.UserDO;
import com.scys.friendbox.dal.enums.UserGenderEnum;
import com.scys.friendbox.dal.params.BoxQuery;
import com.scys.friendbox.utils.context.LoginUserUtil;
import com.scys.friendbox.utils.error.Result;
import com.scys.friendbox.utils.exception.AssertUtil;
import com.scys.friendbox.utils.exception.ResultCode;
import com.scys.friendbox.utils.template.BizEventBO;
import com.scys.friendbox.utils.template.HandleCallback;
import com.scys.friendbox.utils.template.TransTemplate;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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

    /**
     * 最小日期
     */
    private static final Date MIN_DATE = new GregorianCalendar(1900, Calendar.JANUARY, 1).getTime();
    private static final Date MAX_DATE = new GregorianCalendar(2010, Calendar.JANUARY, 1).getTime();

    @Override
    public Result<Long> createBox(BoxModel boxModel) {
        Result<Long> result = new Result<>();

        transTemplate.execute(result, new BizEventBO(), new HandleCallback() {

            UserDO userDO;

            @Override
            public void checkParams() {
                //检查参数
                AssertUtil.isLessEqualZero(boxModel.getCnt(), "无效的次数");
                AssertUtil.notBlank(boxModel.getName(), "无效的昵称");
                AssertUtil.isTrue(boxModel.getBirthday() != null
                        && boxModel.getBirthday().after(MIN_DATE)
                        && boxModel.getBirthday().before(MAX_DATE), "无效的出生日期");
                AssertUtil.isTrue(UserGenderEnum.getByCode(boxModel.getGender()) != null, "无效的性别");
                AssertUtil.notBlank(boxModel.getChatNumber(), "无效的联系方式");
                AssertUtil.notBlank(boxModel.getCity(), "无效的地址");
                AssertUtil.notBlank(boxModel.getDsc(), "无效的个人描述信息");

                //检查用户信息
                String userIdStr = LoginUserUtil.getLoginUser().getId();
                AssertUtil.isLessEqualZero(userIdStr, "Not Login");
                long userId = NumberUtils.toLong(userIdStr);
                Optional<UserDO> user = userDAO.findById(userId);
                AssertUtil.isTrue(user != null && user.get() != null, "Invalid User");
                userDO = user.get();
                AssertUtil.isLessEqualZero(userDO.getCnt(), ResultCode.USER_CNT_NOT_ENOUGH.getDesc());

                AssertUtil.isTrue(userDO.getCnt() >= boxModel.getCnt(), ResultCode.USER_CNT_NOT_ENOUGH.getDesc());
                boxModel.setUserId(userId);
                boxModel.setGmtCreate(new Date());
                boxModel.setGmtModify(new Date());
            }

            @Override
            public void doLock() {
                userDO = userDAO.lockById(userDO.getId());
            }

            @Override
            public void process() {
                userDAO.updateCntById(userDO.getId(), userDO.getCnt() - boxModel.getCnt());

                BoxDO boxDO = new BoxDO();
                BeanUtils.copyProperties(boxModel, boxDO);
                boxDAO.save(boxDO);
            }
        });

        return result;
    }

    @Override
    public Result<BoxModel> openOneBox(BoxQuery boxQuery) {
        return null;
    }

    @Override
    public Result<List<BoxModel>> queryOpenedBoxHistory(int pageNum, int pageSize) {
        return null;
    }
}