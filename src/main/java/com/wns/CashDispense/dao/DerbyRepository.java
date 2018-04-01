package com.wns.CashDispense.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wns.CashDispense.model.CashModel;

@Repository
public interface DerbyRepository extends CrudRepository<CashModel,String> {

}
