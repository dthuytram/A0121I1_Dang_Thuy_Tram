package com.codegym.casestudy_springboot.repositories;

import com.codegym.casestudy_springboot.models.employee.Division;
import com.codegym.casestudy_springboot.models.employee.EducationDegree;
import com.codegym.casestudy_springboot.models.employee.Employee;
import com.codegym.casestudy_springboot.models.employee.Position;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    Page<Employee> findAll(Pageable pageable);
    @Query("select pt from Position pt")
    List<Position> findAllPositon();
    @Query("select ed from EducationDegree ed")
    List<EducationDegree> findAllEduDegree();
    @Query("select dv from Division dv")
    List<Division> findAllDivision();
}
