package asciiart.asciiartGenerator.mapper;

import java.util.HashMap;
import java.util.Map;

public class CharToImageNameMapper {
    private final Map<Character, String> map;

    public CharToImageNameMapper() {
        map = new HashMap<>();
        map.put('$', "dollar");
        map.put('@', "at");
        map.put('B', "b");
        map.put('%', "percent");
        map.put('8', "eight");
        map.put('&', "and");
        map.put('W', "w");
        map.put('M', "m");
        map.put('#', "sharp");
        map.put('*', "star");
        map.put('o', "small_o");
        map.put('a', "small_a");
        map.put('h', "small_h");
        map.put('k', "small_k");
        map.put('b', "small_b");
        map.put('d', "small_d");
        map.put('p', "small_p");
        map.put('q', "small_q");
        map.put('w', "small_w");
        map.put('m', "small_m");
        map.put('Z', "z");
        map.put('O', "q");
        map.put('0', "zero");
        map.put('Q', "q");
        map.put('L', "l");
        map.put('C', "c");
        map.put('J', "j");
        map.put('U', "u");
        map.put('Y', "y");
        map.put('X', "x");
        map.put('z', "small_z");
        map.put('c', "small_c");
        map.put('v', "small_v");
        map.put('u', "small_u");
        map.put('n', "small_n");
        map.put('x', "small_x");
        map.put('r', "small_r");
        map.put('j', "small_j");
        map.put('f', "small_f");
        map.put('t', "small_t");
        map.put('/', "slash");
        map.put('\\', "back_slash");
        map.put('|', "narrow_slash");
        map.put('(', "left_bracket");
        map.put('{', "left_composed_bracket");
        map.put('[', "left_sharp_bracket");
        map.put('1', "one");
        map.put('?', "question_mark");
        map.put('-', "mark");
        map.put('_', "underscore");
        map.put('+', "plus");
        map.put('~', "tilda");
        map.put('<', "less_than");
        map.put('>', "more_than");
        map.put(';', "semi_colon");
        map.put(':', "double_colon");
        map.put(',', "coma");
        map.put('"', "quote");
        map.put('^', "power");
        map.put('`', "exant");
        map.put('\'', "single_quote");
        map.put('.', "dot");
        map.put(' ', "empty");
    }
    public String getImageName(char key) {
        return map.get(key);
    }
}
