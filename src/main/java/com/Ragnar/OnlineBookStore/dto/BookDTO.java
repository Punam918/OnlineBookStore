package com.Ragnar.OnlineBookStore.dto;

import lombok.Data;

@Data
public class BookDTO {
    private String title;
    private String author;
    private String description;
    private double price;
    private int quantity;
}
