package com.myproject.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myproject.entity.MedicineDo;

@Repository
public interface MedicineDao extends JpaRepository<MedicineDo, Long> {

}
