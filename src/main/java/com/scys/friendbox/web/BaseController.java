package com.scys.friendbox.web;

import com.scys.friendbox.dal.dataobject.UserDO;
import com.scys.friendbox.dal.datainterface.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dx
 * @version : BaseController.java, v 0.1 2021年10月10日 9:49 下午 dx Exp $
 */
@RestController
public class BaseController {

    @Autowired
    private UserDAO userDAO;

    @GetMapping("/add")
    public String add() {
        UserDO userDO = new UserDO();
        userDO.setId(1L);
        userDO.setName("test1");
        Object ret = userDAO.save(userDO);
        return ret.toString();
    }

    @GetMapping("/find/{name}")
    public String update(@PathVariable String name) {
        Object ret = userDAO.getUserByName(name);
        return ret.toString();
    }

    @GetMapping("/update/{id}/{name}")
    public String update(@PathVariable String name, @PathVariable Long id) {
        Object ret = userDAO.setNameById(id, name);
        return ret.toString();
    }

}