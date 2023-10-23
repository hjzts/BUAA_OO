import jdk.nashorn.internal.ir.FunctionCall;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

/**
 * 指令处理方法集合
 * 2023/10/23 21:43
 *
 * @author hugo
 */
public class CommandUtil<K> {
    private Map<K, Function> map;

    public CommandUtil(Map<K, Function> map) {
        this.map = map;
    }

    public CommandUtil<K> add(K key, Function function) {
        this.map.put(key, function);
        return this;
    }

    public void execute(K key) {
        if (this.map.containsKey(key)) {
            map.get(key).invoke();
        }
    }
    public static void printHugo() {
        System.out.println("hugo yyds!!");
    }
}
