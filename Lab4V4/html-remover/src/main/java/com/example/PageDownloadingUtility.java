package com.example;

import org.jsoup.Jsoup;
import java.io.IOException;

public class PageDownloadingUtility {
    public static String download(String url) {
        try {
            return Jsoup.connect(url).get().html();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
