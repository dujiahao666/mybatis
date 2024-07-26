import java.lang.annotation.Target;

/**
 * @author 杜嘉豪
 * @create 2024/3/31 21:57
 * @description:
 */

public enum Jk {
    LEG(176, "极品少女"),
    XIONG(36, "极品少女"),
    PIGU(65, "美艳少妇");


    private int lang;
    private String name;


    private Jk() {
    }

    private Jk(int lang, String name) {
        this.lang=lang;
        this.name=name;
    }

    public int getLang() {
        return lang;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Jk{" +
                "lang=" + lang +
                ", name='" + name + '\'' +
                '}';
    }
}


class T1{
    public static void main(String[] args) {
        Jk xiong = Jk.XIONG;
        System.out.println(xiong);
        Jk[] values = xiong.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
        }
    }
}
