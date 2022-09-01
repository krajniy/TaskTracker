import Evaluator.Evaluator;
import Parser.Commands;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class EvaluatorTests {
    @Test
    void testEvaluate() {
        Evaluator evaluator = new Evaluator();
        evaluator.evaluate(new HashMap<String, Object>() {
            {
                put("Command", Commands.ADD);
                put("string", "�����-�� ���� �� �������� �����");
            }
        });
        assert ( evaluator.getList().size() == 1 && evaluator.getList().contains("�����-�� ���� �� �������� �����"));

    }

    @Test
    void testEvaluate2() {
        Evaluator evaluator = new Evaluator();
        evaluator.evaluate(new HashMap<String, Object>() {
            {
                put("Command", Commands.ADD);
                put("id", "0");
                put("string", "�����-�� ���� �� �������� �����");
            }
        });
        assert ( evaluator.getList().size() == 1 && evaluator.getList().get(0).equals("�����-�� ���� �� �������� �����"));
    }
    @Test
    void testEvaluate3() {
        Evaluator evaluator = new Evaluator();
        Assertions.assertThrows(IndexOutOfBoundsException.class, () ->
                evaluator.evaluate(new HashMap<String, Object>() {
                    {
                        put("Command", Commands.ADD);
                        put("id", "1");
                        put("string", "�����-�� ���� �� �������� �����");
                    }
                }));

    }
}
