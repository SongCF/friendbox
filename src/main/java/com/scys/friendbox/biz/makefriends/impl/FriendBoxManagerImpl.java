package com.scys.friendbox.biz.makefriends.impl;

import com.scys.friendbox.biz.makefriends.FriendBoxManager;
import com.scys.friendbox.biz.makefriends.model.BoxModel;
import com.scys.friendbox.biz.makefriends.model.UserInfo;
import com.scys.friendbox.dal.datainterface.BoxDAO;
import com.scys.friendbox.dal.datainterface.UserDAO;
import com.scys.friendbox.dal.dataobject.BoxDO;
import com.scys.friendbox.dal.dataobject.UserDO;
import com.scys.friendbox.biz.makefriends.enums.GenderEnum;
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
 * 盲盒管理
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
            long userId;
            UserDO userDO;

            @Override
            public void checkParams() {
                //检查参数
                AssertUtil.isLessEqualZero(boxModel.getCnt(), "无效的次数");
                UserInfo userInfo = boxModel.getUserInfo();
                AssertUtil.notNull(userInfo, "无效的用户信息");

                AssertUtil.notBlank(userInfo.getName(), "无效的昵称");
                AssertUtil.isTrue(GenderEnum.getByCode(userInfo.getGender()) != null, "无效的性别");
                AssertUtil.notBlank(userInfo.getCity(), "无效的地址");
                AssertUtil.isTrue(userInfo.getBirthday() != null
                        && userInfo.getBirthday().after(MIN_DATE)
                        && userInfo.getBirthday().before(MAX_DATE), "无效的出生日期");
                AssertUtil.isTrue(userInfo.getHeight() > 100 && userInfo.getHeight() < 300, "无效的身高");
                AssertUtil.isTrue(userInfo.getWeight() > 30 && userInfo.getHeight() < 200, "无效的体重");
//                AssertUtil.notBlank(userInfo.getProfession(), "无效的职业");
//                AssertUtil.isTrue(SalaryEnum.getByCode(userInfo.getSalary()) != null, "无效的年薪");
//                AssertUtil.isTrue(HouseAndCarEnum.getByCode(userInfo.getHouseAndCar()) != null, "无效的车房情况");
//                AssertUtil.isTrue(EducationEnum.getByCode(userInfo.getEducation()) != null, "无效的学历");
                AssertUtil.notBlank(userInfo.getChatNum(), "无效的联系方式");
                AssertUtil.notBlank(userInfo.getDsc(), "无效的个人描述信息");

                //检查用户信息
                String userIdStr = LoginUserUtil.getLoginUser().getId();
                AssertUtil.isLessEqualZero(userIdStr, "Not Login");
                userId = NumberUtils.toLong(userIdStr);
            }

            @Override
            public void doLock() {
                userDO = userDAO.lockById(userId);
            }

            @Override
            public void process() {
                AssertUtil.isTrue(userDO != null, "Invalid User");
                AssertUtil.isTrue(userDO.getCnt() >= boxModel.getCnt(), ResultCode.USER_CNT_NOT_ENOUGH.getDesc());
                //
                //更新数据
                //
                //1.user-cnt数量
                userDAO.updateCntById(userDO.getId(), userDO.getCnt() - boxModel.getCnt());
                //2.添加box
                boxModel.setUserId(userDO.getId());
                boxModel.setGmtCreate(new Date());
                boxModel.setGmtModify(new Date());
                BoxDO boxDO = new BoxDO();
                BeanUtils.copyProperties(boxModel, boxDO);
                boxDAO.save(boxDO);
            }
        });

        return result;
    }

    @Override
    public Result<BoxModel> openOneBox(BoxQuery boxQuery) {
        Result<BoxModel> result = new Result<>();

        transTemplate.execute(result, new BizEventBO(), new HandleCallback() {

            @Override
            public void checkParams() {
            }

            @Override
            public void doLock() {
            }

            @Override
            public void process() {

            }
        });

        return result;
    }

    @Override
    public Result<List<BoxModel>> queryOpenedBoxHistory(int pageNum, int pageSize) {
        return null;
    }
}