import java.io.*;

public class zadanie_5_laba10 {
    public static void main(String[] args)throws IOException{
        BufferedReader fread = new BufferedReader(new FileReader("C:\\Users\\muzbe\\OneDrive\\Рабочий стол\\aboba\\files\\t5.1.txt"));
        BufferedWriter fwr = new BufferedWriter(new FileWriter("C:\\Users\\muzbe\\OneDrive\\Рабочий стол\\aboba\\files\\t5.2.txt", true));
        String line;
        boolean flag = true;
        fwr.write("\nOUT\n");
        while ((line = fread.readLine()) != null) {
            for(int i = 0; i <= 9; i++){
                flag = line.contains(String.valueOf(i));

            }
            if (flag) {
                fwr.write(line);
            }
        }
        fread.close();
        fwr.flush();
        fwr.close();
    }
}
