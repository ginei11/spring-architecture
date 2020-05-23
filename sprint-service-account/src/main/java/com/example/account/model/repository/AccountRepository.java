package com.example.account.model.repository;

import com.example.account.model.entity.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Account , Integer> {
}
