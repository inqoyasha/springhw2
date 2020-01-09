package org.azamat.repository;

import org.azamat.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {
    @Query(value = "SELECT b.bookname, b.cost FROM  book AS b", nativeQuery = true)
    List<Book> findByNameAndCost(@Param("bookname") String name, @Param("cost") double cost);
}
