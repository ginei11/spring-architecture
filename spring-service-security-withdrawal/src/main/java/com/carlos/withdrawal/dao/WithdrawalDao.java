package com.carlos.withdrawal.dao;

import com.carlos.withdrawal.domain.Withdrawal;
import org.springframework.data.repository.CrudRepository;

public interface WithdrawalDao extends CrudRepository <Withdrawal, Integer> {
}
