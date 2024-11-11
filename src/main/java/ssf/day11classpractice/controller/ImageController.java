package ssf.day11classpractice.controller;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class ImageController {

    @GetMapping(path = {"/", "/index.html"})
    public String getImage(Model model) {
        File images = new File("src/main/resources/static/images");
        File[] imgDir = images.listFiles(new FilenameFilter() {
            @Override 
            public boolean accept(File images, String name) {
                return name.toLowerCase().contains(".jpg");
            }
        });
        Random rand = new Random();
        File imgOfDay = imgDir[rand.nextInt(imgDir.length)];
        String imgPath = imgOfDay.getPath().substring(26);
        model.addAttribute("imgPath", imgPath);
        return "pictureoftheday"; // return html page to display
    }
    
}
