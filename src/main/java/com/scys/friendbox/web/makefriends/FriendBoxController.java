package com.scys.friendbox.web.makefriends;

//import com.alibaba.fastjson.JSONObject;
import com.scys.friendbox.biz.makefriends.FriendBoxManager;
import com.scys.friendbox.biz.makefriends.model.BoxModel;
import com.scys.friendbox.utils.error.Result;
import com.scys.friendbox.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

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
    //public ModelMap createBox(@RequestBody String data) {
    //    BoxModel boxModel = JSONObject.parseObject(data, BoxModel.class);
        Result<Long> ret = friendBoxManager.createBox(boxModel);
        ModelMap modelMap = new ModelMap();
        saveResult(ret, modelMap);
        return modelMap;
    }

    @GetMapping("/openBox.json")
    public ModelMap openBox() {
        ModelMap modelMap = new ModelMap();
        modelMap.put("success", true);
        modelMap.put("data", "ok");
        return modelMap;
    }

    @GetMapping("/openedHistory.json")
    public String openedHistory() {
        return "hello";
    }

}