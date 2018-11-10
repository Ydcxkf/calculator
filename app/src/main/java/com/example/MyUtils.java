package com.example;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.math.*;
/**
 * @Title: MyUtils.java
 * @Desc: 计算器工具类
 */

public class MyUtils {
    public static final int FORMAT_MAX_LENGTH = 500;// 表达式最大长度限制
    public static final int RESULT_DECIMAL_MAX_LENGTH = 8;// 结果小数点最大长度限制
    public static final Map<Character, Integer> symLvMap = new HashMap<Character, Integer>();// 符号优先级map
    static {
        symLvMap.put('=', 0);
        symLvMap.put('-', 1);
        symLvMap.put('+', 1);
        symLvMap.put('x', 2);
        symLvMap.put('/', 2);
        symLvMap.put('(', 4);
        symLvMap.put(')', 1);
        symLvMap.put('^', 3);
        symLvMap.put('s', 3);
        symLvMap.put('c', 3);
        symLvMap.put('t', 3);
        symLvMap.put('g', 3);
        symLvMap.put('n', 3);
        symLvMap.put('!', 3);
        symLvMap.put('%', 2);
        symLvMap.put('√',3);
    }
    /**
     *
     * @Title: checkFormat
     * @Desc: 检查表达式格式是否正确
     *
     * @return true表达式正确，false表达式错误
     *
     */
    public static boolean checkFormat(String str) {
        // 校验开头是否为数字或者“(”
        if (!(isCharNum(str.charAt(0)))) {
            return false;
        }
        char c;
        // 校验
        for (int i = 1; i < str.length() - 1; i++) {
            c = str.charAt(i);
            if (!(isCharNum(c))) {
                if (c == '-' || c == '+' || c == 'x' || c == '/'|| c == '%'|| c == '^'
                        || c == '!'|| c=='m' ||c == '√') {
                    if (!(isCharNum(str.charAt(i - 1)) || str.charAt(i - 1) == ')')) {// 若符号前一个不是数字或者“）”时
                        return false;
                    }
                }
                if (c == 'Π' && isCharNum(str.charAt(i-1))&& isCharNum(str.charAt(i+1))){//若Π前后是数字时
                    return false;
                }
                if (c == '.') {
                    if (!isCharNum(str.charAt(i - 1)) || !isCharNum(str.charAt(i + 1))) {// 校验“.”的前后是否位数字
                        return false;
                    }
                }
            }
        }
        return isBracketCouple(str);// 校验括号是否配对
    }
    /**
     *
     * @Title: change2StandardFormat
     * @Desc: 处理表达式格式为标准格式，如2(-1+2)(3+4)改为2*(0-1+2)*(3+4)
     *
     * @param str
     * @return 标准表达式
     *
     */
    public static String change2StandardFormat(String str) {
        StringBuilder sb = new StringBuilder();
        char c;
        boolean single=false;
        for (int i = 0; i < str.length(); i++) {
            c = str.charAt(i);
            //转换Π，sin,cos,tan,mod,log,ln
            if(c == 's'||c == 'i'||c == 'n'||c == 'c'||c == 'o'||c == 't'||c == 'a'||c == 'Π'||
                    c == 'm'||c == 'd'||c == 'l'||c == 'g'){
                if(c=='Π'){//Π
                    sb.append("3.14159265");
                }
                if(c=='d'){//mod
                    sb.append("%");
                }
                if(c=='g'){//log
                    sb.append("10g");
                }
                if(c=='s'&&str.charAt(i-1) == 'o'){//cos
                    sb.append("1c");
                }
                if(c=='n'){
                    if(str.charAt(i-1) == 'i'){//sin
                        sb.append("1s");
                    }
                    if(str.charAt(i-1) == 'a'){//tan
                        sb.append("1t");
                    }
                    if(str.charAt(i-1) == 'l'){//ln
                        sb.append("1n");
                    }
                }
                continue;
            }
            if (i != 0 && c == '(' && (isCharNum(str.charAt(i - 1)) || str.charAt(i - 1) == ')')) {
                sb.append("x(");
                continue;
            }
            if (c == '-' && str.charAt(i - 1) == '(') {
                sb.append("0-");
                continue;
            }
            if (c == '%' && str.charAt(i + 1) == ')') {
                sb.append("x0.01");
                continue;
            }
            if (c == 'l' && str.charAt(i - 1) != 'x') {
                sb.append("xl");
                continue;
            }
            if (c == 's' && str.charAt(i + 1) == 'i'&& str.charAt(i - 1) != 'x') {
                sb.append("xs");
                continue;
            }
            if (c == 'c' && str.charAt(i + 1) == '0'&& str.charAt(i - 1) != 'x') {
                sb.append("xc");
                continue;
            }
            if (c == 't' && str.charAt(i + 1) == 'a'&& str.charAt(i - 1) != 'x') {
                sb.append("xt");
                continue;
            }
            if (c == '!') {
                sb.append("!1");
                continue;
            }
            sb.append(c);
        }
        return sb.toString();
    }
    /**
     *
     * @Title: isBracketCouple
     * @Desc: 校验括号是否配对
     * @param str
     * @return 参数
     *
     */
    public static boolean isBracketCouple(String str) {
        LinkedList<Character> stack = new LinkedList<>();
        for (char c : str.toCharArray()) {
            if (c == '(') {
                stack.add(c);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.removeLast();
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
    /**
     *
     * @Title: formatResult
     * @Desc: 处理计算结果的显示
     *
     * @param str计算结果
     * @return 规范的计算结果
     *
     */
    public static String formatResult(String str) {
        String[] ss = str.split("\\.");
        if (Integer.parseInt(ss[1]) == 0) {
            return ss[0];// 整数
        }
        String s1 = new StringBuilder(ss[1]).reverse().toString();
        int start = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != '0') {
                start = i;
                break;
            }
        }
        return ss[0] + "." + new StringBuilder(s1.substring(start, s1.length())).reverse();
    }
    /**
     *
     * @Title: isCharNum
     * @Desc: 判断是否为数字
     *
     * @param c
     * @return
     *
     */
    public static boolean isCharNum(Character c) {
        if (c >= '0' && c <= '9') {
            return true;
        }
        return false;
    }
    /**
     *
     * @Title: plus
     * @Desc: 加
     *
     * @param num1
     * @param num2
     * @return 计算结果
     *
     */
    public static double plus(double num1, double num2) {
        return num1 + num2;
    }
    /**
     *
     * @Title: reduce
     * @Desc: 减
     *
     * @param num1
     * @param num2
     * @return 计算结果
     *
     */
    public static double reduce(double num1, double num2) {
        return num1 - num2;
    }
    /**
     *
     * @Title: multiply
     * @Desc: 乘
     *
     * @param num1
     * @param num2
     * @return 计算结果
     *
     */
    public static double multiply(double num1, double num2) {
        return num1 * num2;
    }
    /**
     *
     * @Title: divide
     * @Desc: 除
     *
     * @param num1
     * @param num2
     * @return 计算结果
     *
     */
    public static double divide(double num1, double num2) {
        return num1 / num2;
    }
    /**
     *
     * @Title: power
     * @Desc: n次方
     *
     * @param num1
     * @param num2
     * @return 计算结果
     *
     */
    public static double power(double num1, double num2) {
        double sum=1;
        if(num2 > 0) {
            for(int i = 0 ; i < num2 ; i++ )
                sum *= num1;
        }else if(num2 < 0) {
            for(int i = 0 ; i < num2 ; i++ )
                sum /= num1;
        }
        return sum;
    }
    /**
     *
     * @Title: remedial
     * @Desc: 求余
     *
     * @param num1
     * @param num2
     * @return 计算结果
     *
     */
    public static double remedial(double num1, double num2) {
        return num1%num2;
    }
    /**
     *
     * @Title: factorial
     * @Desc: 阶乘
     *
     * @param num1
     * @param num2
     * @return 计算结果
     *
     */
    public static double factorial(double num1, double num2) {
        double i=1,j=1;
        do{
           j*=i;
           i++;
        }while(num1>=i);
        return j;
    }
    /**
     *
     * @Title: sin
     * @Desc: sin
     *
     * @param num1
     * @param num2
     * @return 计算结果
     *
     */
    public static double sin(double num1, double num2) {
        return Math.sin(Math.toRadians(num2)); }
    /**
     *
     * @Title: cos
     * @Desc: cos
     *
     * @param num1
     * @param num2
     * @return 计算结果
     *
     */
    public static double cos(double num1, double num2) {
        return Math.cos(Math.toRadians(num2)); }
    /**
     *
     * @Title: tan
     * @Desc: tan
     *
     * @param num1
     * @param num2
     * @return 计算结果
     *
     */
    public static double tan(double num1, double num2) {
        return Math.tan(Math.toRadians(num2)); }
    /**
     *
     * @Title: ln
     * @Desc: ln
     *
     * @param num1
     * @param num2
     * @return 计算结果
     *
     */
    public static double ln(double num1, double num2) {
        return Math.log(num2); }
    /**
     *
     * @Title: log
     * @Desc: log
     *
     * @param num1
     * @param num2
     * @return 计算结果
     *
     */
    public static double log(double num1, double num2) {
        return Math.log(num2)/Math.log(num1); }
    /**
     *
     * @Title: 根号
     * @Desc: radical
     *
     * @param num1
     * @param num2
     * @return 计算结果
     *
     */
    public static double radical(double num1, double num2) {
        if(num1==2){
        return Math.sqrt(num2);
        }else if(num1==3){
            return Math.cbrt(num2);
        }else{
            return Math.pow(num2,1/num1);
        }
    }
}

