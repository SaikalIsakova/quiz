package service.impl;

import service.MainService;
import service.ServiceQuiz;

import java.util.*;

public class MainServiceImpl implements MainService {

    ServiceQuiz service=new ServiceQuizImpl();
    Scanner sc=new Scanner(System.in);

    @Override
    public void test(int countOfQuestion) {
        service.getMap();
        int countOfCorrect=0;
        int questionNum=1;

        System.out.println("Угадай столицу! ");

        for( int i=0;i<countOfQuestion;i++){
            HashMap<String,HashMap<String,Boolean>> params=service.getQuestions();

            for (Map.Entry<String,HashMap<String,Boolean>> item:params.entrySet()){
                System.out.println("Номер вопроса "+questionNum);
                questionNum++;
                System.out.println("Страна "+item.getKey());

                ArrayList<String> cities=new ArrayList<>();
                for (Map.Entry<String,Boolean> option:item.getValue().entrySet()){
                    cities.add(option.getKey());
                }
                Collections.shuffle(cities);
                int cityNum=1;
                for (String city:cities){
                    System.out.println(cityNum+":"+city);
                    cityNum++;
                }
                System.out.println("Выберите номер ответа ");
                int answer=sc.nextInt();
                if (item.getValue().get(cities.get(answer-1))){
                    countOfCorrect++;
                }
            }
        }
        int percent=countOfCorrect*100/countOfQuestion;
        System.out.println("Правильных ответов "+countOfCorrect+" из "+countOfQuestion);
        System.out.println("Уровень вашего знания "+percent+"% из 100%");
    }
}
