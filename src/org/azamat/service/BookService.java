package org.azamat.service;

import org.azamat.model.Book;
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
//        int listId = id-1;
        List<Book> list = bookRepository.findAll();
        Book b = list.get(id);
        b.setCost(cost);
        b.setQuantity(quantity);
        b.setStorage(storage);
        list.set(id,b);

        return list;
    }
    public List<Book> fullUpdateById(int id, Book book) {
//        int listId = id-1;
        List<Book> list = bookRepository.findAll();
        list.remove(id);
        list.add(id, book);

        return list;
    }
    public List<Book> findByNameAndCost(String name, double cost) {
        return bookRepository.findByNameAndCost(name,cost);
    }
}
