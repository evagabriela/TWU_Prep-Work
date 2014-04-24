package com.twu.biblioteca;

/**
 * Created by evazamudio on 2014-04-24.
 */
public class Book {
    private  String title;
    private  String author;
    private boolean availableBook = true;


    public Book(String title, String author){
        this.title = title;
        this.author = author;
    }

   public String getAuthor(){
       return author;
   }

   public void setAuthor(String author){
       this.author = author;
   }

   public String getTitle(){
       return title;
   }

   public boolean isAvailableBook(){
       return availableBook;
   }

   public void setAvailableBook(boolean availableBook){
       this.availableBook = availableBook;
   }

}
