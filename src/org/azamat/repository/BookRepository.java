package org.azamat.repository;

import org.azamat.model.Book;
import org.azamat.projections.book.BookNameAndCost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {
    @Query(value = "SELECT b.bookname as bookname, b.cost as cost FROM book as b", nativeQuery = true)
    List<BookNameAndCost> findAllBooks();
    List<BookNameAndCost> findBookNameAndCostByBookNameLikeOrCostGreaterThan(String bookname, Double cost);
}
