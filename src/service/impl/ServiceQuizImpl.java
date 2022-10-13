package service.impl;

import service.ServiceQuiz;

import java.util.*;

public class ServiceQuizImpl implements ServiceQuiz {
    Map<String, String> data = new HashMap<>();
    List<String>countries=new ArrayList<>();
    List<String>cities=new ArrayList<>();

    Map<String,Boolean>capitalCity=new HashMap<>();
    @Override
    public void getMap() {
        data.put("Кыргызстан", "Бишкек");
        data.put("Англия", "Лондон");
        data.put("Испания", "Мадрид");
        data.put("Финляндия", "Осло");
        data.put("Австралия", "Канберра");
        data.put("Австрия", "Вена");
        data.put("Новая Зеландия", "Велингтон");
        data.put("Хорватия", "Загреб");
        data.put("Румыния", "Бухарест");
        data.put("Албания", "Тиран");
        data.put("Венгрия", "Будапешт");
        data.put("Турция", "Анкара");
        data.put("Сербия", "Белград");
        data.put("Литва", "Вильнюс");
        data.put("Латвия", "Рига");
        for (Map.Entry<String,String> item: data.entrySet()) {
        countries.add(item.getKey());
        cities.add(item.getValue());

            Collections.shuffle(countries);
            Collections.shuffle(cities);
        }
    }

    @Override
    public HashMap getQuestions() {
        HashMap<String,HashMap<String,Boolean>>question=new HashMap<>();
        String country=countries.get(3);
        countries.remove(3);
        Collections.shuffle(cities);
        String city=data.get(country);

        HashMap<String,Boolean>options=new HashMap<>();
        options.put(city,true);
        for (int i = 0; i < 3; i++) {
            options.put(cities.get(i),false);
        }
        question.put(country,options);
        Collections.shuffle(countries);
        return question;

    }


}
