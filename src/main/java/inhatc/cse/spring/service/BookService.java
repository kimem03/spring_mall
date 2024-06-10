package inhatc.cse.spring.service;

import inhatc.cse.spring.dto.BookDto;
import inhatc.cse.spring.dto.MemberDto;
import inhatc.cse.spring.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public int save(BookDto bookDto) {
        return bookRepository.save(bookDto);
    }

    public List<BookDto> findAll() {
        return bookRepository.findAll();
    }

    public BookDto findById(int id) {
        return bookRepository.findById(id);
    }
}
