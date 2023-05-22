package src;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Application {
    static TodoList tdl = new TodoList();

    public void start() {
        Pattern listButton = Pattern.compile("(?i)LIST");
        Pattern addButton = Pattern.compile("(?i)ADD");
        Pattern editButton = Pattern.compile("(?i)EDIT");
        Pattern deleteButton = Pattern.compile("(?i)DELETE");

        System.out.println("Введите команду: ADD, LIST, EDIT, DELETE");

        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String input = sc.nextLine();
            String[] parts = tdl.parseInput(input);


            Matcher listMatcher = listButton.matcher(parts[0]);
            Matcher addMatcher = addButton.matcher(parts[0]);
            Matcher editMatcher = editButton.matcher(parts[0]);
            Matcher deleteMatcher = deleteButton.matcher(parts[0]);

            if (listMatcher.matches()) {
                tdl.listMatcher();
            } else if (addMatcher.matches()) {
                tdl.addMatcher(parts[1] + " " + parts[2]);
            } else if (editMatcher.matches()) {
                tdl.editMatcher(Integer.parseInt(parts[1]), parts[2]);
            } else if (deleteMatcher.matches()) {
                tdl.deleteMatcher(Integer.parseInt(parts[1]));
            } else if (addMatcher.matches()){
                tdl.addMatcherIndex(parts[1], Integer.parseInt(parts[1]));
            } else  {
                tdl.showError();
            }
        }
    }
}