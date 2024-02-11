package ru.geekbrains.SpringHomeWork8.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.SpringHomeWork8.entity.Executor;

@Repository
public interface ExecutorRepository extends JpaRepository<Executor, Long> {
}