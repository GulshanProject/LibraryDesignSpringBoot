package com.example.LMSbackend.Service;


import com.example.LMSbackend.Convertors.BookConvertor;
import com.example.LMSbackend.Models.Author;
import com.example.LMSbackend.Models.Book;
import com.example.LMSbackend.Repository.AuthorRepository;
import com.example.LMSbackend.Repository.BookRepository;
import com.example.LMSbackend.RequestDto.BookRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    BookRepository bookRepository;
    public String createBook(BookRequestDto bookRequestDto){
          Book book= BookConvertor.convertDtoToEntity(bookRequestDto);
          // I need to set author Entity
        int authorId= bookRequestDto.getAuthorId();

        // Getting the author entity
        Author author= authorRepository.findById(authorId).get();
        book.setAuthor(author);
        // that booklist also need to updated
        List<Book> currentListOfBooks=author.getBooksWritten();
        currentListOfBooks.add(book);
        author.setBooksWritten(currentListOfBooks);

        // save the author
         authorRepository.save(author);
        // save the book
            bookRepository.save(book);


   return "successfully added book";
    }
}
