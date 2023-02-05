package com.NewYearsProject.repository;


import com.NewYearsProject.Model.Book;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface BookRepository extends ElasticsearchRepository<Book, Long> {

    List<Book> findAll();

    List<Book> findByIsmi(String ismi);
    List<Book> findByYazari(String yazari);
    List<Book> findByYayinyili(String yayinyili);

    List<Book> findAllByZamanGreaterThanEqualAndZamanLessThanEqual(LocalDateTime startDate, LocalDateTime endDate);


//    List<Book> findAllByZamanGreaterThanEqualAndZamanLessThanEqual(LocalDateTime startDate, LocalDateTime endDate);

}
