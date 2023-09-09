package com.example.GrowSkill.Repository;

import com.example.GrowSkill.Models.Class;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CLassRepository extends JpaRepository<Class,Integer> {
}
