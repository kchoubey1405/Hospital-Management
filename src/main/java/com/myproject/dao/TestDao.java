package com.myproject.dao;

import com.myproject.entity.MedicineDo;
import com.myproject.entity.TestDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestDao extends JpaRepository<TestDo, Long> {

}
