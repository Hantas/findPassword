package com.example.demo.service;

import com.example.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 10742 on 2018/1/1.
 */
@Service
public interface StudentRepository extends JpaRepository<Student, String>{

    Student findById(String id);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update stu set password =?1 where id = ?2",nativeQuery = true)
    void updatePasswordById(String password, String id);
}
