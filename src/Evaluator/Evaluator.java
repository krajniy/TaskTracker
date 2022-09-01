package Evaluator;

import Parser.Commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Evaluator {

    List<String> list = new ArrayList<>();

    public List<String> getList() {
        return list;
    }

    public void evaluate(Map<String, Object> map) {
        switch (Commands.valueOf(map.get("Command").toString())) {
            case LIST -> System.out.println(list);
            case ADD -> {
                if (map.containsKey("id")) {
                    if (Integer.parseInt(map.get("id").toString()) <= list.size()) {
                        list.add(Integer.parseInt((String) map.get("id")), (String) map.get("string"));
                    } else throw new IndexOutOfBoundsException("No such index "+ map.get("key"));
                } else {
                    list.add((String) map.get("string"));
                }
            }
            case EDIT -> {
                if (map.containsKey("id")) {
                    list.set(Integer.parseInt((String) map.get("id")), (String) map.get("string"));
                } else {
                    System.out.println("Wrong arguments");
                }
            }
            case DELETE -> {
                if (map.containsKey("id")) {
                    list.remove(Integer.parseInt((String) map.get("id")));
                } else {
                    System.out.println("Wrong arguments");
                }
            }
            case EXIT -> {
                System.exit(1);
            }
            default -> throw new IllegalStateException("Unexpected value: " + map.get("Command"));
        }
    }
}
