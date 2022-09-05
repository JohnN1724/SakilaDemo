package com.sakila.jnuttall.scraper;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class TestSelenium {
    public static void main(String[] args) throws IOException {
        BufferedImage image = ImageIO.read(new URL("https://prod-wombo-paint.s3.amazonaws.com/exports/62864546-2843-49e7-b1b6-beccea85b324/blank_tradingcard.jpg?AWSAccessKeyId=AKIAWGXQXQ6WCOB7PP5J&Signature=LVFb1hXCC0PQR%2FnC6HaOv%2BN8N0s%3D&Expires=1669891673"));
        File outputFile = new File("cards/saved.png");
        ImageIO.write(image, "png", outputFile);
    }
}
