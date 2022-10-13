import service.MainService;
import service.ServiceQuiz;
import service.impl.MainServiceImpl;
import service.impl.ServiceQuizImpl;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        ServiceQuiz serviceQuiz=new ServiceQuizImpl();
        MainService mainService=new MainServiceImpl();
        mainService.test(4);

    }
}