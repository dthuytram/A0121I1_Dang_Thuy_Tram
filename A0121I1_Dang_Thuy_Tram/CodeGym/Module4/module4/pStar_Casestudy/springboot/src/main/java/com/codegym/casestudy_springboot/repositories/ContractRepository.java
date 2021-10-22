package com.codegym.casestudy_springboot.repositories;

import com.codegym.casestudy_springboot.models.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ContractRepository extends JpaRepository<Contract,Integer> {
    Page<Contract> findAll(Pageable pageable);

    void deleteAllByCustomer_Id(int id);
}
