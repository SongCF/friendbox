package com.scys.friendbox.web.makefriends;

import com.scys.friendbox.biz.makefriends.FriendBoxManager;
import com.scys.friendbox.biz.makefriends.model.BoxModel;
import com.scys.friendbox.dal.params.BoxQuery;
import com.scys.friendbox.utils.error.Result;
import com.scys.friendbox.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author dx
 * @version : BaseController.java, v 0.1 2021年10月10日 9:49 下午 dx Exp $
 */
@RestController
@RequestMapping("/friendbox")
public class FriendBoxController extends BaseController {

    @Autowired
    private FriendBoxManager friendBoxManager;

    @PostMapping("/createBox.json")
    public ModelMap createBox(@RequestBody BoxModel boxModel) {
        Result<Long> ret = friendBoxManager.createBox(boxModel);
        ModelMap modelMap = new ModelMap();
        saveResult(ret, modelMap);
        return modelMap;
    }

    @GetMapping("/openBox.json")
    public ModelMap openBox(BoxQuery boxQuery) {
        Result<BoxModel> ret = friendBoxManager.openOneBox(boxQuery);
        ModelMap modelMap = new ModelMap();
        saveResult(ret, modelMap);
        return modelMap;
    }

    @GetMapping("/openedHistory.json")
    public ModelMap openedHistory(int pageNum, int pageSize) {
        Result<List<BoxModel>> ret = friendBoxManager.queryOpenedBoxHistory(pageNum, pageSize);
        ModelMap modelMap = new ModelMap();
        saveResult(ret, modelMap);
        return modelMap;
    }

}