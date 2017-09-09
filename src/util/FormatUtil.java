package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FormatUtil {

    /**
     * 输入时的整体匹配
     * 其中润年的月份天数也能匹配
     * @param input
     * @return
     */
    public static boolean inputFormat(String input) {
        String regx = "U(\\d){3} " +
                "((([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29))[ ]"
                +"((([0-1][0-9])|2[0-3]):00~(([0-1][0-9])|2[0-3]):00)([ ][A-Z]|[ ][A-Z][ ][A-Z])";

        Pattern pattern = Pattern.compile(regx);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

}
