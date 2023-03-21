package com.example;

// import com.example.htmlremover;

public class Application {
    public static void main(String[] args) {
        String url = args[0];
        PageDownloadingUtility downloader = new PageDownloadingUtility();
        String textWithHtml = downloader.download(url);
        
        StringHtmlCleaner remover = new StringHtmlCleaner();
        String textWithoutHtml = remover.cleanText(textWithHtml);
        System.out.println(textWithoutHtml);
    }
}
