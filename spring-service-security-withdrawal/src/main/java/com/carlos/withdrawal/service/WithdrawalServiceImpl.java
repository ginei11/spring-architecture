package com.carlos.withdrawal.service;

import com.carlos.withdrawal.dao.WithdrawalDao;
import com.carlos.withdrawal.domain.Withdrawal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WithdrawalServiceImpl implements IWithdrawalService {

@Autowired
private WithdrawalDao withdrawalDao;

    @Override
    @Transactional(readOnly=true)
    public Withdrawal findById(Integer id) {
        return withdrawalDao.findById(id).orElse(null);
    }

    @Override
    public Withdrawal save(Withdrawal withdrawal) {
        return withdrawalDao.save(withdrawal);
    }
}
