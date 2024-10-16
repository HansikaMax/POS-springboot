package com.IJSE.POS_Spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.IJSE.POS_Spring.Entity.Pos;

@Service
public interface PosService {
    

    List<Pos> getAllPoss();  
    Pos createPos (Pos pos);
    Pos getPosById(Long id);

}
