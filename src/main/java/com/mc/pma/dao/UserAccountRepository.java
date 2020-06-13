package com.mc.pma.dao;

import org.springframework.data.repository.CrudRepository;

import com.mc.pma.entities.UserAccount;

public interface UserAccountRepository extends CrudRepository<UserAccount, Long> {

}
