package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("books")
public class BookController {
    @Autowired
    BookService bookService;

    // One example controller, make the rest by yourself
    @PostMapping("/create-book")
    public ResponseEntity<Book> createBook(@RequestBody Book book){
        Book newbook = bookService.createBook(book);
        return new ResponseEntity<>(newbook, HttpStatus.CREATED);
    }

    @GetMapping("/get-book-by-id/{id}")
    public ResponseEntity<Book> findBookById(@PathVariable String id){
        Book newbook = bookService.findBookById(id);
        return new ResponseEntity<>(newbook, HttpStatus.ACCEPTED);
    }

    @GetMapping("/get-all-books")
    public ResponseEntity<List<Book>> findAllBooks(){
        List<Book> allbooks = bookService.findAllBooks();
        return new ResponseEntity<>(allbooks,HttpStatus.ACCEPTED);
    }

    @GetMapping("/get-books-by-author")
    public ResponseEntity<List<Book>> findBooksByAuthor(@RequestParam("author") String author){
        List<Book> authorBooks = bookService.findBooksByAuthor(author);
        return new ResponseEntity<>(authorBooks,HttpStatus.ACCEPTED);
    }

    @GetMapping("/get-books-by-genre")
    public ResponseEntity<List<Book>> findBooksByGenre(@RequestParam("genre") String genre){
        List<Book> genreBooks = bookService.findBooksByGenre(genre);
        return new ResponseEntity<>(genreBooks,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete-book-by-id/{id}")
    public ResponseEntity<String> deleteBookById(@PathVariable String id){
        bookService.deleteBookById(id);
        return new ResponseEntity<>("sucess",HttpStatus.OK);
    }

    @DeleteMapping("/delete-all-books")
    public ResponseEntity<String> deleteAllBooks(){
        bookService.deleteAllBooks();
        return new ResponseEntity<>("sucess",HttpStatus.OK);
    }


}
