package Parser;

import java.util.HashMap;
import java.util.Map;

public class Parser {

    String del;
    String regExpId;

    public Parser(String del, String regExpId) {
        this.del = del;
        this.regExpId = regExpId;
    }


    public Map<String, Object> parse(String s) {
        Map<String, Object> map = new HashMap<>();
        if (s.contains(del)) {
            Commands c = Commands.valueOf((s.substring(0, s.indexOf(del)).toUpperCase()));
            map.put("Command", c);
            s = s.substring(s.indexOf(del) + 1);
            if (s.matches(regExpId)) {
                if (s.contains(del)) {
                    map.put("id", s.substring(0, s.indexOf(del)));
                    map.put("string", s.substring(s.indexOf(del)+1));
                } else {
                    map.put("id", s);
                }
            } else {
                map.put("string", s);
            }
        } else {
            map.put("Command", Commands.valueOf(s.toUpperCase()));
        }
        return map;
    }
}
