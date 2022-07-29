package com.schfr.ToDoList.repository;

import com.schfr.ToDoList.model.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Long>
{
}
