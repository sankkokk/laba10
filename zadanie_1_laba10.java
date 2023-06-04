import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class zadanie_1_laba10 {
    public static void main(String[] args) throws IOException{
        File file = new File("C:\\Users\\muzbe\\OneDrive\\Рабочий стол\\aboba\\files\\t1.txt");
        FileWriter fwr = new FileWriter(file, true);
        BufferedReader br = new BufferedReader(new FileReader(file));
        fwr.write("\n");
        String str = br.readLine();
        int cnt1 = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isLowerCase(c) && Character.UnicodeBlock.of(c) == Character.UnicodeBlock.CYRILLIC) {
                cnt1++;
            }
        }
        fwr.write("Количество строчных русских букв: " + cnt1 + "\n");
        char searchChar = 'a';
        int cnt2 = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == searchChar) {
                cnt2++;
            }
        }
        if (cnt2 > 0) {
            fwr.write("Символ " + searchChar + " встречается " + cnt2 + " раз"+ "\n");
        } else {
            fwr.write("Символ " + searchChar + " не найден"+ "\n");
        }
        char searchDigit = '1';
        boolean flag = false;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i)) && str.charAt(i) == searchDigit) {
                flag = true;
                break;
            }
        }
        if (flag) {
            fwr.write("Среди символов есть 2 и более цифры, входящие в цифру " + searchDigit+ "\n");
        } else {
            fwr.write("Среди символов нет 2 и более цифр, входящих в цифру " + searchDigit+ "\n");
        }
        boolean flag1 = false;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(' || c == ')' || c == '{' || c == '}' || c == '[' || c == ']') {
                flag1 = true;
                break;
            }
        }
        if (flag1) {
            boolean flag3 = true;
            int cntBraket1 = 0;
            int cntBraket2 = 0;
            int cntBraket3 = 0;
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c == '(') {
                    cntBraket1++;
                } else if (c == ')') {
                    cntBraket1--;
                } else if (c == '{') {
                    cntBraket2++;
                } else if (c == '}') {
                    cntBraket2--;
                } else if (c == '[') {
                    cntBraket3++;
                } else if (c == ']') {
                    cntBraket3--;
                }
                if (cntBraket1 < 0 || cntBraket2 < 0 || cntBraket3 < 0) {
                    flag3 = false;
                    break;
                }
            }
            if (flag3 && cntBraket1 == 0 && cntBraket2 == 0 && cntBraket3 == 0) {
                fwr.write("Среди символов есть пара соседствующих скобок и все пары закрыты"+ "\n");
            } else {
                fwr.write("Среди символов есть пара соседствующих скобок, но не все пары закрыты"+ "\n");
            }
        } else {
            fwr.write("Среди символов нет пары соседствующих скобок");
        }
        boolean flag4 = false;
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == ' ' && str.charAt(i + 1) == ' ') {
                flag4 = true;
                break;
            }
        }
        if (flag4) {
            fwr.write("Среди символов есть более двух подряд идущих пробелов"+ "\n");
        } else {
            fwr.write("Среди символов нет более двух подряд идущих пробелов"+ "\n");
        }
        boolean flagE = false;
        for (int i = 0; i < str.length() - 3; i++) {
            if (Character.isDigit(str.charAt(i)) && Character.isDigit(str.charAt(i + 1)) && Character.isDigit(str.charAt(i + 2)) && Character.isDigit(str.charAt(i + 3))) {
                int a = Character.getNumericValue(str.charAt(i));
                int b = Character.getNumericValue(str.charAt(i + 1));
                int c = Character.getNumericValue(str.charAt(i + 2));
                int d = Character.getNumericValue(str.charAt(i + 3));
                if (a > b && b > c && c < d) {
                    flagE = true;
                    break;
                }
            }
        }
        if (flagE) {
            fwr.write("Среди символов есть последовательность, удовлетворяющая условию"+ "\n");
        } else {
            fwr.write("Среди символов нет последовательности, удовлетворяющей условию"+ "\n");
        }
        fwr.flush();
        fwr.close();
    }
}
