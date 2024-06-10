package inhatc.cse.spring.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookDto {
    private int id;
    private String title;
    private String author;
    private String publisher;
    private String image;
}
