package api_tests.Book;

import api_tests.Specifications.Specifications;
import io.qameta.allure.restassured.AllureRestAssured;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertyReader;
import java.util.List;

import static io.restassured.RestAssured.given;

public class BookApiTests {
    private final static String url = PropertyReader.getURL();

    @Test(description = "Check Title And Cover File Name For Books Api Test", alwaysRun = true)
    public void checkTitleAndCoverFileNameForBooksGetApiTest(){
        Specifications.installSpecification(Specifications.requestSpecification(url),
                Specifications.responseSpecificationOK200());
        List<BookData> books = given()
                .filter(new AllureRestAssured())
                .when()
                .get("/api/Book")
                .then().log().all()
                .extract().body().jsonPath().getList(".", BookData.class);

        Assert.assertTrue(books.get(0).getCoverFileName().contains(books.get(0).getTitle()));
        Assert.assertTrue(books.get(3).getCoverFileName().contains(books.get(3).getTitle()));
        Assert.assertTrue(books.stream().allMatch(x -> x.getCoverFileName().endsWith(".jpg")));
    }
}