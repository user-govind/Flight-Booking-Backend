package com.cdac.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdac.entity.UserInfo;


@Repository
public interface GenericRepositoryUser extends JpaRepository<UserInfo, Integer> {

	public UserInfo findByEmailAndUserPassword(String email,String password);
}
