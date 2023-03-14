package com.example;

// import com.example.htmlremover;

public class Application {
    public static void main(String[] args) {
        StringHtmlCleaner remover = new StringHtmlCleaner();
        String textWithHtml = "<h1>Hello, <i>world</i>!</h1>";
        String textWithoutHtml = remover.cleanText(textWithHtml);
        System.out.println(textWithoutHtml);
    }
}
