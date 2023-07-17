package org.example.services;

import jakarta.transaction.Transactional;
import org.example.models.Bank;
import org.example.repositories.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

@Service
public class BankService {
    private final BankRepository bankRepository;

    @Autowired
    public BankService(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    public List<Bank> getBanks() {
        return (List<Bank>) bankRepository.findAll();
    }

    public void printBanks(List<Bank> banks) {
        for (Bank b : banks) {
            System.out.println(b);
        }
    }

    @Transactional
    public void setBanksName(PersonService personService, String banksName) {
        try {
            personService.getPersons();
            bankRepository.updateBankByName(banksName);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
    }
}
