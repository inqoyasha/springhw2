package org.azamat.controller;

import org.azamat.model.Book;
import org.azamat.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/create")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createBook(@RequestBody Book book){
        bookService.add(book);
    }

    @GetMapping ("/find")
    public ResponseEntity<Book> findById(@RequestParam int id){
        Book book = bookService.findById(id);

        if (book == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            return ResponseEntity.ok(book);
        }
    }

    @DeleteMapping ("/delete/{id}")
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public void deleteBook(@PathVariable int id){
        bookService.removeById(id);
    }

    @PutMapping("/replace/{id}")
    public ResponseEntity<Book> replaceBook(@PathVariable int id,
                                            @RequestBody Book book){
        bookService.fullUpdateById(id, book);


        if (bookService.findById(id) == null){
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
        else {
            return ResponseEntity.ok(bookService.findById(id));
        }

    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable int id,
                                           @RequestParam Double cost,
                                           @RequestParam int quantity,
                                           @RequestParam String storage){

        bookService.updateById(id, cost, quantity, storage);

        if (bookService.findById(id) == null){
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
        else {
            return ResponseEntity.ok(bookService.findById(id));
        }

    }

    @GetMapping("/find/all")
    public List<Book> findAll() {
        return bookService.findAll();
    }


}
