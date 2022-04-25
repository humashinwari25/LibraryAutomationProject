package com.library.step_definitions;

import com.library.pages.BookPage;
import com.library.pages.CommonAreaPage;
import com.library.utilities.BrowserUtil;
import com.library.utilities.DB_Util;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class US_5_StepDef {

    CommonAreaPage commonAreaPage = new CommonAreaPage();
    BookPage bookPage = new BookPage();

    @When("I navigate to {string} page")
    public void i_navigate_to_page(String module) {
        new CommonAreaPage().navigateModule(module);
    }

    String book;

    @When("I open a book called {string}")
    public void i_open_a_book_called(String bookName) {
        book = bookName;
        new BookPage().search.sendKeys(bookName);
        BrowserUtil.waitFor(3);
    }

    @When("I execute query to get the book information from books table")
    public void i_execute_query_to_get_the_book_information_from_books_table() {
        String query = "SELECT name, author, year\n" +
                "FROM books\n" +
                "WHERE name = '" + book + "'";
        DB_Util.runQuery(query);
    }

    @Then("verify book DB and UI information must match")
    public void verify_book_db_and_ui_information_must_match() {
        BookPage bookPage = new BookPage();
        //from ui
        String actualYear = bookPage.year.getText();
        String actualAuthorName = bookPage.authorName.getText();
        String actualBookName = bookPage.bookName.getText();

        // from DB
        String expectedBookName = DB_Util.getCellValue(1, 1);
        String expectedAuthorName = DB_Util.getCellValue(1, 2);
        String expectedYear = DB_Util.getCellValue(1, 3);
        //compare ui and DB
        Assert.assertEquals(expectedBookName, actualBookName);
        Assert.assertEquals(expectedAuthorName, actualAuthorName);
        Assert.assertEquals(expectedYear, actualYear);

    }
}