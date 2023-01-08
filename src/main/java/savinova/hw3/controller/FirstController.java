package savinova.hw3.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {
    @GetMapping
    public String firstPage(){
        return "Приложение запущено удачно";
    }
    @GetMapping("/info")
    public String info(){
        return
                "Савинова Екатерина \n" +
                        "Курс 3 - проект Книга Рецептов \n"+
                        "дата начала 08.01.2023 \n"+
                        "проект, который пока не знаю о чем, но буду скоро знать \n";
    }

}
