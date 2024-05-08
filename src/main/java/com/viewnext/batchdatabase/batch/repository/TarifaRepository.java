package com.viewnext.batchdatabase.batch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.viewnext.batchdatabase.model.TarifaPL;

@Repository
public interface TarifaRepository extends JpaRepository<TarifaPL, Integer> {

}
