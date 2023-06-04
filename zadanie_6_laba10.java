import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class zadanie_6_laba10 {
    public static void main(String[] args) throws IOException{
        File file = new File("C:\\Users\\muzbe\\OneDrive\\Рабочий стол\\aboba\\files\\t6.txt");
        File file1 = new File("C:\\Users\\muzbe\\OneDrive\\Рабочий стол\\aboba\\files\\t6.1.txt");
        Map<String, Integer> excellentMathStudentsByClass = new HashMap<>();
        Map<String, Integer> examAttemptsBySubject = new HashMap<>();
        Map<String, Double> totalScoreBySubject = new HashMap<>();
        BufferedReader fread = new BufferedReader(new FileReader(file));
        BufferedWriter fwr = new BufferedWriter(new FileWriter(file1, true));
        String line;
        while ((line = fread.readLine()) != null) {
            String[] data = line.split(", ");
            String studentClass = data[0];
            String subject = data[2];
            int attempts = Integer.parseInt(data[3]);
            double averageScore = Double.parseDouble(data[4]);
            int bestResult = Integer.parseInt(data[5]);
            if (subject.equals("математика") && attempts == 1 && bestResult >= 5) {
                excellentMathStudentsByClass.put(studentClass, excellentMathStudentsByClass.getOrDefault(studentClass, 0) + 1);
            }
            examAttemptsBySubject.put(subject, examAttemptsBySubject.getOrDefault(subject, 0) + attempts);
            totalScoreBySubject.put(subject, totalScoreBySubject.getOrDefault(subject, 0.0) + averageScore);
        }
        for (Map.Entry<String, Integer> entry : excellentMathStudentsByClass.entrySet()) {
            fwr.write("Класс " + entry.getKey() + ": " + entry.getValue() + " учеников сдали математику с первого раза на отлично\n");
        }
        for (Map.Entry<String, Integer> entry : examAttemptsBySubject.entrySet()) {
            String subject = entry.getKey();
            int attempts = entry.getValue();
            double averageScore = totalScoreBySubject.get(subject) / attempts;
            fwr.write("Предмет " + subject + ": сдавали " + attempts + " раз, средний балл " + averageScore + "\n");
        }
        fwr.flush();
        fwr.close();
    }
}
