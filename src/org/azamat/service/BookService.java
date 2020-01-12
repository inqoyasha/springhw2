package org.azamat.service;

import org.azamat.model.Book;
import org.azamat.projections.book.BookNameAndCost;
import org.azamat.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> findAll() {
        return bookRepository.findAll();
    }
    public void removeById(int id) {
        bookRepository.deleteById(id);
    }
    public void add(Book book) {
        bookRepository.save(book);
    }
    public Book findById(int id) {
        Optional<Book> optional = bookRepository.findById(id);
        return optional.orElse(new Book());
    }
    public List<Book> updateById(int id, double cost, int quantity, String storage) {
        List<Book> list = bookRepository.findAll();
        for (Book book: list) {
            if (id == book.getBook_id()) {
                book.setCost(cost);
                book.setQuantity(quantity);
                book.setStorage(storage);
            }
        }

        return list;
    }
    public List<Book> fullUpdateById(int id, Book book) {
        List<Book> list = bookRepository.findAll();
        for (Book b: list) {
            if (id == b.getBook_id()) {
                b.setBook_id(id);
                b.setBookName(book.getBookName());
                b.setCost(book.getCost());
                b.setQuantity(book.getQuantity());
                b.setStorage(book.getStorage());
            }
        }

        return list;
    }
    public List<BookNameAndCost> findAllBooks() {
        return bookRepository.findAllBooks();
    }
    public List<BookNameAndCost> findBookNameAndCostByBookNameLikeOrCostGreaterThan(String bookname, Double cost){
        return bookRepository.findBookNameAndCostByBookNameLikeOrCostGreaterThan(bookname, cost);
    }
}
