import Evaluator.Evaluator;
import Parser.Parser;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Parser parser = new Parser(" ", "\\d(.+)?");
        Evaluator evaluator = new Evaluator();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            try {
                evaluator.evaluate(parser.parse(scanner.nextLine()));
            } catch (IndexOutOfBoundsException e){
                System.out.println("No such index, please, try smaller index");
            }
        }
    }
}
