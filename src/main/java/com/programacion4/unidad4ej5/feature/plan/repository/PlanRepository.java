package com.programacion4.unidad4ej5.feature.plan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.programacion4.unidad4ej5.feature.plan.model.Plan;

@Repository
public interface PlanRepository extends JpaRepository<Plan, Long> {
}
