package com.library.step_definitions;

import com.library.utilities.DB_Util;
import com.library.utilities.QueryReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class US_4_StepDef {

    String actualPopularUser;

    @When("I execute query to find most popular user")
    public void i_execute_query_to_find_most_popular_user() {
       /* String query = "SELECT full_name, COUNT(*) AS countofreadbooks\n" +
                "FROM users u\n" +
                "         INNER JOIN book_borrow bb ON u.id = bb.user_id\n" +
                "GROUP BY full_name\n" +
                "ORDER BY countofreadbooks DESC";
        DB_Util.runQuery(query);

        */

        DB_Util.runQuery(QueryReader.read("us4_popular_user"));
        actualPopularUser = DB_Util.getFirstRowFirstColumn();
        // DB_Util.getCellValue(1, 1);
    }

    @Then("verify {string} is the user who reads the most")
    public void verify_is_the_user_who_reads_the_most(String expectedPopularUser) {
        Assert.assertEquals(expectedPopularUser, actualPopularUser);
    }
}