package org.example.repositories;

import org.example.models.Bank;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends CrudRepository<Bank, Integer> {
    @Modifying
    @Query("update Bank set name = :banksName")
    void updateBankByName(@Param("banksName") String banksName);
}
