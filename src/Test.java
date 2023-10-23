import java.util.HashMap;

/**
 * 测试
 * 2023/10/23 23:18
 *
 * @author hugo
 */
public class Test {
    public static void main(String[] args) {
        CommandUtil<Integer> commandUtil = new CommandUtil<>(new HashMap<>(27));
        commandUtil.add(1,()->System.out.println("apple"))
                .add(2,()->System.out.println("banana"))
                .add(3, CommandUtil::printHugo);
        commandUtil.execute(1);
        commandUtil.execute(3);


    }

}
