import java.io.FileWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class zadanie_4_laba10 {
    public static void main(String[] args) throws IOException{
        String fileName = "C:\\Users\\muzbe\\OneDrive\\Рабочий стол\\aboba\\files\\t4.txt";
        FileWriter fwr = new FileWriter(fileName,true);
        String regex = "\\b(\\w+)([-]\\w+)?\\b";
        Pattern pattern = Pattern.compile(regex);
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;
        fwr.write("\nOUT\n");
        while ((line = br.readLine()) != null) {
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {
                fwr.write(matcher.group()+"\n");
            }
        }
        fwr.flush();
        fwr.close();
    }
}

