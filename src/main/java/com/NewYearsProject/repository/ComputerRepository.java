package com.NewYearsProject.repository;

import com.NewYearsProject.Model.Book;
import com.NewYearsProject.Model.Computer;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ComputerRepository extends ElasticsearchRepository<Computer,Long> {


    List<Computer> findAll();

    List<Computer> findByMarka(String marka);
    List<Computer> findByModel(String model);

    List<Computer> findAllByFiyatGreaterThanEqualAndFiyatLessThanEqual(int startFiyat, int endFiyat);

}
