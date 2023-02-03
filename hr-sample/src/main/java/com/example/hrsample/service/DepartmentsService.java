package com.example.hrsample.service;

import com.example.hrsample.dao.DepartmentsDao;
import com.example.hrsample.entity.Departments;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
@Transactional
public class DepartmentsService {
    @Autowired
    private DepartmentsDao departmentsDao;

    public Page<Departments> getAllAndPage(Pageable page) {
        return departmentsDao.findAll(page);
    }

    public List<Departments>getAll(){
        return departmentsDao.findAll();
    }
}
