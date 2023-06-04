import java.io.*;
import java.util.*;

class KVNTeam {
    String city;
    boolean isUniversityTeam;
    String university;
    String league;
    String teamName;
    int captainAge;
    int numberOfMembers;
    int numberOfMembersUnder21;
    int numberOfMembersWithMusicEducation;
    int numberOfMembersWithTheaterEducation;
    int numberOfMembersCurrentlyStudying;
    int numberOfMusicalInstruments;
    double averageSponsorshipAmount;
    double averageAnnualIncome;
}

public class zadanie_9_laba10 {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\muzbe\\OneDrive\\Рабочий стол\\aboba\\files\\t9.txt");
        FileWriter fwr = new FileWriter(file, true);
        BufferedReader fread = new BufferedReader(new FileReader(file));
        fwr.write("\n\nВЫВОД\n\n");
        List<KVNTeam> teams = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            KVNTeam team = new KVNTeam();
            String[] input = fread.readLine().split(";\\s*");
            System.out.println(Arrays.toString(input));
            team.city = input[0];
            team.isUniversityTeam = Boolean.parseBoolean(input[1]);
            team.university = input[2];
            team.league = input[3];
            team.teamName = input[4];
            team.captainAge = Integer.parseInt(input[5]);
            team.numberOfMembers = Integer.parseInt(input[6]);
            team.numberOfMembersUnder21 = Integer.parseInt(input[7]);
            team.numberOfMembersWithMusicEducation = Integer.parseInt(input[8]);
            team.numberOfMembersWithTheaterEducation = Integer.parseInt(input[9]);
            team.numberOfMembersCurrentlyStudying = Integer.parseInt(input[10]);
            team.numberOfMusicalInstruments = Integer.parseInt(input[11]);
            team.averageSponsorshipAmount = Double.parseDouble(input[12]);
            team.averageAnnualIncome = Double.parseDouble(input[13]);
            teams.add(team);
        }
        int countTeamsByCity = 0;
        int countTeamsByUniversity = 0;
        for (KVNTeam team : teams) {
            if (team.numberOfMembersCurrentlyStudying > team.numberOfMembers * 0.5 && team.averageAnnualIncome > 3_000_000) {
                countTeamsByCity++;
            }
            if (team.isUniversityTeam && (team.numberOfMembersWithMusicEducation > 0 || team.numberOfMembersWithTheaterEducation > 0) && team.averageSponsorshipAmount < team.averageAnnualIncome) {
                countTeamsByUniversity++;
            }
        }
        fwr.write("Количество команд по лигам относящихся к 1 городу, в которых более 50 % участников на настоящий момент получают образование, а средний доход команды от выступлений за год превышает 3 млн. руб.: " + countTeamsByCity+ "\n");
        fwr.write("Количество команд по городам, которые относятся к ВУЗам, в которых есть участники с музыкальным и театральным образованием, а средняя сумма спонсорских взносов меньше суммы доходов команды от выступлений: " + countTeamsByUniversity+"\n");
        fwr.flush();
        fwr.close();
    }
}
