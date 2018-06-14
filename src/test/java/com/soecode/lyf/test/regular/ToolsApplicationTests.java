package com.soecode.lyf.test.regular;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class ToolsApplicationTests {

    @Test
    public void contextLoads() {
        String pattern = "('\\w+[\\u4e00-\\u9fa5]*'![A-Z]+[0-9]+.*?)";
        Pattern pattern1 = Pattern.compile(pattern);
        String str = "=IF('A105040专项用途财政性资金纳税调整表'!A34 + 'A105041专项用途财政性资金纳税调整表'!A2 >0+ 'A5041专项用途财政性资金纳税调整表'!A2 haha";
        Matcher matcher = pattern1.matcher(str);
        while (matcher.find()) {
            System.out.println(matcher.group(1));
        }

    }
    /**去掉末尾0，当小数点后面全0时保留2位0*/
    @Test
    public void testStripTrailingZeros(){
        String str = "00v0001000022000002000000000000";
        str = str.replaceAll("0+$", "");

        str = str.replaceAll("([.]|[0-9])$", ".00");
        // 成对去掉0
//        String t = str.replaceAll("(00){1,}$", "%");
        System.out.println("str="+str);
    }


    @org.junit.Test
    public void Stringtest(){
        String str = "*树木*林业产品*杨木";
        String[] arrChmc = str.split("[*]");
        List<String> list = Arrays.asList(arrChmc);
        str = str.replaceAll("([\\s\\S]*)"+list.get(1)+"(\\*)","");
        System.out.println("cutStr="+str);
    }
}
