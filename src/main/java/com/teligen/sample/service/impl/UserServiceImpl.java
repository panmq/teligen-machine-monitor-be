package com.teligen.sample.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.teligen.sample.domain.User;
import com.teligen.sample.repository.UserJPARepository;
//import com.teligen.sample.repository.UserQBERepository;
import com.teligen.sample.service.UserService;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserJPARepository userJPARepo;

//	@Inject
//	private UserQBERepository userQBERepo;

	@Override
	public User sampleService() {

		// -- JPA usage -- //
		Iterable<User> userList = userJPARepo.findAll();
		Page<User> usersByPage = userJPARepo.findAll(new PageRequest(1, 20));

		// -- QBE usage -- //
		User example = new User();
		example.setUsername("panmq");
//		List<User> userList2 = userQBERepo.find(example);

		User user = new User();
		user.setId(Long.valueOf(111));
		user.setUsername("panmq");
		user.setPassword("123456");
		return user;
	}

}
