package com.example.carlocation.repositories;

import com.example.carlocation.models.entities.Option;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OptionRepository extends JpaRepository<Option,Long> {

    @Query(value = "SELECT o FROM Option o WHERE o.optionName in (:options)")
    List<Option> findAllByOptionNameContains(@Param("options") List<String> options);
}
