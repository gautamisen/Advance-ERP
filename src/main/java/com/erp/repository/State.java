package com.erp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erp.model.States;

public interface State extends JpaRepository<States, Integer>{

}
