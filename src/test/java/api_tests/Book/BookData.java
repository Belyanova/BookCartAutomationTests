package api_tests.Book;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BookData {
    private final Integer bookId;
    private final  String title;
    private final  String author;
    private final  String category;
    private final Double price;
    private final String coverFileName;

    @JsonCreator
    public BookData(@JsonProperty("bookId") Integer bookId, @JsonProperty("title") String title,
                    @JsonProperty("author") String author, @JsonProperty("category") String category,
                    @JsonProperty("price") Double price, @JsonProperty("coverFileName") String coverFileName) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.category = category;
        this.price = price;
        this.coverFileName = coverFileName;
    }

    public Integer getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategory() {
        return category;
    }

    public Double getPrice() {
        return price;
    }

    public String getCoverFileName() {
        return coverFileName;
    }
}