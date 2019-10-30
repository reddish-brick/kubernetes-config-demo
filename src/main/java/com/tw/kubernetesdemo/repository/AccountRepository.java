package com.tw.kubernetesdemo.repository;

import com.tw.kubernetesdemo.models.Account;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;

@Transactional
public interface AccountRepository extends CrudRepository<Account, Long> {

  Account findById(long id);

  List<Account> findAll();
}
