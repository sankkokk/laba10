import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;

import static java.lang.Math.*;
public class zadanie_7_laba10 {
    public static void main(String[] args) throws IOException {
        File file1 = new File("C:\\Users\\muzbe\\OneDrive\\Рабочий стол\\aboba\\files\\t7.txt");
        FileWriter fwr = new FileWriter(file1);
        fwr.write("Постановка задачи\n\nx >= -3 && x <= 3; x += 0.5\nесли x >= 0, то f(x) = (x-3)^2\nиначе f(x) = sin(x)-cos(x)\n\nВЫВОД\n\n"
                +"Функция\t\s\s\s\sЗначение f(x)\n\n");
        DecimalFormat d = new DecimalFormat("#.#");
        double x = -3;
        while (x <= 3){
            if (x >= 0) fwr.write( "f(" + x + ")\t=\t" + d.format(pow(x-3,2)) + "\n");
            else fwr.write("f(" + x + ")\t=\t" + d.format(sin(x)-cos(x)) + "\n");
            x += 0.5;
        }
        fwr.flush();
        fwr.close();
    }
}

