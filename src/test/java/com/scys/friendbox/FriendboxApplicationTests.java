package com.scys.friendbox;

import com.scys.friendbox.dal.datainterface.UserDAO;
import com.scys.friendbox.dal.dataobject.UserDO;
import com.scys.friendbox.dal.enums.UserGenderEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.Optional;

@SpringBootTest
class FriendboxApplicationTests {

	@Autowired
	private UserDAO userDAO;

	@Test
	void contextLoads() {
	}

	@Test
	public void testUser() {
		{
			UserDO user = new UserDO();
			user.setName("test1");
			user.setBirthday(new Date());
			user.setGender(UserGenderEnum.MALE.getCode());
			user = userDAO.save(user);
			assert user.getId() != null;
		}
		{
			Optional<UserDO> user = userDAO.findById(1L);
			assert user.isPresent();
		}
	}
}
