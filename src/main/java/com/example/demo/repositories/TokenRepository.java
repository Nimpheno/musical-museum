package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;

import ch.qos.logback.core.subst.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TokenRepository extends JpaRepository<Token, Integer> {

}
