package com.my.challenge.repository;

import com.my.challenge.entity.CategoryModule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CategoryModuleRepository extends JpaRepository<CategoryModule, Integer>{
    List<CategoryModule> findByRoleIdAndActiveTrueOrderByModuleOrderAsc(int id);

}
