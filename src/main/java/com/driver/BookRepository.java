package com.driver;
import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {

    public BookRepository(){
        
    }
    private int a;
    Map<Integer,Book> bookMap = new HashMap<>();

    public Book save(Book book){
        a++;
        book.setId(a);
        bookMap.put(a,book);
        return bookMap.get(a);
    }

    public Book findBookById(int id){
        return bookMap.get(id);
    }

    public List<Book> findAll(){
        List<Book> allBooks = new ArrayList<>();
        for(Integer i: bookMap.keySet()){
            allBooks.add(bookMap.get(i));
        }
        return allBooks;
    }

    public void deleteBookById(int id){
        bookMap.remove(id);
    }

    public void deleteAll(){
        bookMap.clear();
    }

    public List<Book> findBooksByAuthor(String author){
        List<Book> authorBooks = new ArrayList<>();
        for(Book b: bookMap.values()){
            if(b.getAuthor().equals(author))
                authorBooks.add(b);
        }
        return authorBooks;
    }

    public List<Book> findBooksByGenre(String genre){
        List<Book> genreBooks = new ArrayList<>();
        for(Book b: bookMap.values()){
            if(b.getGenre().equals(genre))
                genreBooks.add(b);
        }
        return genreBooks;
    }
}
