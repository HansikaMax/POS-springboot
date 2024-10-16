package com.IJSE.POS_Spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.IJSE.POS_Spring.Entity.Pos;
import com.IJSE.POS_Spring.repository.PosRepository;

@Service
public class PosServiceImpl implements PosService {

    @Autowired
    private PosRepository posRepository;

    @Override
    public List<Pos> getAllPoss() {
        return posRepository.findAll();
    }

    @Override
    public Pos createPos(Pos pos) {
        return posRepository.save(pos);
    }

    @Override
    public Pos getPosById(Long id) {
        return posRepository.findById(id).orElse(null);
    }

}
