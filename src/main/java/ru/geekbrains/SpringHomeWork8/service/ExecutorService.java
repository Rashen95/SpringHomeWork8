package ru.geekbrains.SpringHomeWork8.service;

import org.springframework.stereotype.Service;
import ru.geekbrains.SpringHomeWork8.dto.ExecutorDTO;
import ru.geekbrains.SpringHomeWork8.entity.Executor;
import ru.geekbrains.SpringHomeWork8.loger.TrackUserAction;
import ru.geekbrains.SpringHomeWork8.repository.ExecutorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ExecutorService {
    private final ExecutorRepository executorRepository;

    public ExecutorService(ExecutorRepository executorRepository) {
        this.executorRepository = executorRepository;
    }

    @TrackUserAction
    public Executor add(ExecutorDTO dto) {
        return executorRepository.save(new Executor(dto.getFirstName(), dto.getLastName()));
    }

    @TrackUserAction
    public List<Executor> findAll() {
        return executorRepository.findAll();
    }

    @TrackUserAction
    public Optional<Executor> findById(long id) {
        return executorRepository.findById(id);
    }

    @TrackUserAction
    public Optional<Executor> deleteById(long id) {
        Optional<Executor> executor = executorRepository.findById(id);
        if (executor.isPresent()) {
            executorRepository.deleteById(id);
        }
        return executor;
    }
}