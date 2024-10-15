package com.IJSE.POS_Spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.IJSE.POS_Spring.Entity.Pos;

public interface PosRepository extends JpaRepository<Pos,Long> {
    
}
