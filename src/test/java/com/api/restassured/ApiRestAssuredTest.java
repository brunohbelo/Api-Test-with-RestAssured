package com.api.restassured;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.post;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class ApiRestAssuredTest {
    
    @BeforeAll
    public static void setBaseURI() {
        RestAssured.baseURI = "https://cat-fact.herokuapp.com";
        
    }

    @Test
    public void validCatFactShouldReturnSuccess(){
        String text = get("/facts/58e008800aac31001185ed07").then().assertThat().statusCode(200).extract().path("text");
        assertEquals("Wikipedia has a recording of a cat meowing, because why not?", text);
    }

    @Test
    public void invalidRouteShouldReturnError(){
        get("/SuperFacts").then().assertThat().statusCode(404);
    }
}