package inhatc.cse.spring.controller;

import inhatc.cse.spring.dto.BookDto;
import inhatc.cse.spring.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
@CrossOrigin
@Slf4j
public class BookController {

    private final BookService bookService;

    @PostMapping("/save")
    public ResponseEntity<?> saveBook(@RequestBody BookDto bookDto) {
        int result = bookService.save(bookDto);
        if (result > 0) {
            return new ResponseEntity<>("Book saved successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to save book", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<BookDto>> getAllBooks() {
        List<BookDto> books = bookService.findAll();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<BookDto> getBookById(@PathVariable int id) {
        BookDto bookDto = bookService.findById(id);
        if (bookDto != null) {
            return new ResponseEntity<>(bookDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}