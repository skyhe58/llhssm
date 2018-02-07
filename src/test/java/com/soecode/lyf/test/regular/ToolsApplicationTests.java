package com.soecode.lyf.test.regular;

import org.junit.Test;

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

}
