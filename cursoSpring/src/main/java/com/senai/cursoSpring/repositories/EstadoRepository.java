package com.senai.cursoSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senai.cursoSpring.domain.Estado;



@Repository
public interface  EstadoRepository extends JpaRepository<Estado,Integer>{

}
