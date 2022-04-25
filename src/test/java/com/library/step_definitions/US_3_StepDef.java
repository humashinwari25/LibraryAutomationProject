package com.library.step_definitions;

import com.library.utilities.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class US_3_StepDef {

    String actualBookGenre;

    @Given("Establish the database connection")
    public void establish_the_database_connection() {
        System.out.println("Database Connection is don inside the Hooks");
    }

    @When("I execute query to find most popular book genre")
    public void i_execute_query_to_find_most_popular_book_genre() {
        String query = "SELECT book_categories.name, COUNT(*) AS countofbookcategories\n" +
                "FROM book_borrow\n" +
                "         INNER JOIN books\n" +
                "             ON book_borrow.book_id = books.id\n" +
                "         INNER JOIN book_categories\n" +
                "             ON books.book_category_id = book_categories.id\n" +
                "GROUP BY book_categories.name\n" +
                "ORDER BY countofbookcategories DESC";

        DB_Util.runQuery(query);
        actualBookGenre = DB_Util.getCellValue(1, 1);

    }

    @Then("verify {string} is the most popular book genre.")
    public void verify_is_the_most_popular_book_genre(String expectedBookGenre) {
        Assert.assertEquals(expectedBookGenre, actualBookGenre);
    }
}
