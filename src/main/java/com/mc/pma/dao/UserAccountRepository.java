package com.mc.pma.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.mc.pma.entities.UserAccount;

public interface UserAccountRepository extends PagingAndSortingRepository<UserAccount, Long> {

}
