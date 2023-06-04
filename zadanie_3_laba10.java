import java.io.*;

public class zadanie_3_laba10 {
    public static void main(String[] args) throws IOException{
        File file = new File("C:\\Users\\muzbe\\OneDrive\\Рабочий стол\\aboba\\files\\t3.txt");
        BufferedReader fread = new BufferedReader(new FileReader(file));
        FileWriter fwr = new FileWriter(file,true);
        String line;
        fwr.write("\nOUT\n");
        while ((line = fread.readLine()) != null) {
            String[] words = line.split("\\s+");
            for (String word : words) {
                if (word.matches(".*\\d.*") && word.matches("\\b\\d.*\\d\\b")) {
                    fwr.write(word+ "\n");
                }
            }
        }
        fwr.flush();
        fwr.close();
        fread.close();
    }
}

