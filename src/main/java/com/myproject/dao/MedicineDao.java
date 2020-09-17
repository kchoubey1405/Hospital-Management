package com.myproject.dao;

import java.util.List;

import com.myproject.entity.MedicineDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicineDao extends JpaRepository<MedicineDo, Long> {

//    @Query("select * from MedicineDo")
//    List<MedicineDo> getAllMedicines();
}
