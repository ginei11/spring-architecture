package com.carlos.withdrawal.service;

import com.carlos.withdrawal.domain.Withdrawal;

public interface IWithdrawalService {
    public Withdrawal findById(Integer id);
    public Withdrawal save(Withdrawal withdrawal);

}
