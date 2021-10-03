package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DictionaryVietnamese {
    @GetMapping("/dic")
    public String dictionary() {
        return "index";
    }

    @PostMapping("/dic")
    public String dictionaryq(String wordEng, Model model) {
        String[] stringsVn = {"xin chào", "tạm biệt", "người yêu"};
        String[] stringsEn = {"hello", "bye", "honey"};
        int count = 0;
        String result="",message="";
        for (int i = 0; i < stringsEn.length; i++) {
            if (stringsEn[i].equals(wordEng)) {
                result = stringsVn[i];
                count++;
            }
        }
        if(count==0){
            message="Not find key word";
        }
        model.addAttribute("result",result);
        model.addAttribute("wordEng",wordEng);
        model.addAttribute("message",message);
        return "index";
    }
}
