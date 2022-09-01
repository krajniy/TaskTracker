import Parser.Parser;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class ParserTests {
    @Test
    void testParserOne() {
        Parser parse = new Parser(" ", "\\d\\s.+");
        Map<String, Object> map = parse.parse("ADD 4 �����-�� ���� �� �������� �����");
        assert (map.entrySet().size() == 3);

    }
}
