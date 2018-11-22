import com.study.chap02.quiz.Quiz1;
import com.study.chap02.quiz.Quiz2;
import com.study.chap03.*;
import com.study.chap03.quiz.Quiz;

/**
 * Created by MHLab on 14/11/2018..
 */

public class Main {
    public static void main(String[] args) {
        chap03();
    }

    public static void chap03() {
//        new PredicateExam().runCode();
//        new ConsumerExam().runCode();
//        new FunctionExam().runCode();
//        new ConstructorReferExam().runCode();
//        new Quiz().runCode();
//        new ComparatorExam().runCode();
//        new ConstructorReferExam().runCode(); //3.7
//        new LambdaMethodReferExam().runCode(); //3.8
        new LambdaUtilExam().runCode(); //3.9
    }


    public static void chap02() {
        Quiz1.runQuiz();
        new Quiz2().doIt();
    }
}
