package com.library.step_definitions;

import com.library.pages.BookPage;
import com.library.utilities.BrowserUtil;
import com.library.utilities.DB_Util;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class US_6_StepDef {

    List<String> actualBookCategories;
    @When("I take all book categories in webpage")
    public void i_take_all_book_categories_in_webpage() {
        actualBookCategories = BrowserUtil.getAllSelectOptions(new BookPage().mainCategoryElement);
        actualBookCategories.remove(0);
    }
    @When("I execute query to get book categories")
    public void i_execute_query_to_get_book_categories() {
        String query="SELECT name\n" +
                "FROM book_categories";
        DB_Util.runQuery(query);


    }
    @Then("verify book categories must match book_categories table from db")
    public void verify_book_categories_must_match_book_categories_table_from_db() {
        List<String> expectedBookCategories = DB_Util.getColumnDataAsList(1);
        Assert.assertEquals(expectedBookCategories, actualBookCategories);
    }


}


