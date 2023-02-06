package com.teamdex.teamdex.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teamdex.teamdex.entity.DemoModel;

@Repository
public interface DemoRepository extends JpaRepository<DemoModel, Long> {

    List<DemoModel> findAll();

}
