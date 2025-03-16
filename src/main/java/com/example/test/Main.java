package com.example.test;

import com.example.test.controller.Controller;
import com.example.test.entity.Author;
import com.example.test.entity.Book;


public class Main {

    private static final Controller<Book, Integer> BOOK_CONTROLLER = Controller.forType(Book.class);
    private static final Controller<Author, Integer> AUTHOR_CONTROLLER = Controller.forType(Author.class);

    public static void main(String[] args) {
//        Book bookWithDate = new Book("Book with date saved by Hibernate", new BigDecimal(11000), LocalDate.now());
//        BOOK_CONTROLLER.saveAndPrint(bookWithDate);
//
//        Book book = new Book("Book saved by Hibernate", new BigDecimal(100));
//        BOOK_CONTROLLER.saveAndPrint(book);

        BOOK_CONTROLLER.findAllAndPrint();
        AUTHOR_CONTROLLER.findAllAndPrint();
    }
}
