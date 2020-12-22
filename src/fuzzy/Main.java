package fuzzy;
import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.rule.FuzzyRuleSet;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            String fileName = "E:/agh/5s/AI/lab2 Fuzzy (zbiory rozmyte) !/Projekt/src/fuzzy/fcl/tipper.fcl";
            FIS fis = FIS.load(fileName,true);

           // int poziomNatezenia = Integer.parseInt(args[1]);
            // int poraDnia = Integer.parseInt(args[2]);
            System.out.println("WELCOME TO STEROWNIK KOTKIEM");
            System.out.print("ilość snu (1-20h) = ");
            int sen = in.nextInt();
            System.out.print("ilość jedzenia (0-10) = ");
            int jedzenie = in.nextInt();
            System.out.print("ilość atencji (0-10) = ");
            int atencja = in.nextInt();


//wyswietl wykresy funkcji fuzyfikacji i defuzyfikacji
            FuzzyRuleSet fuzzyRuleSet = fis.getFuzzyRuleSet();
            fuzzyRuleSet.chart();

//zadaj wartosci wejsciowe
            fuzzyRuleSet.setVariable("sen", sen);
            fuzzyRuleSet.setVariable("jedzenie", jedzenie);
            fuzzyRuleSet.setVariable("atencja", atencja);
//logika sterownika
            fuzzyRuleSet.evaluate();

//graficzna prezentacja wyjscia
            fuzzyRuleSet.getVariable("zachowanie").chartDefuzzifier(true);

//System.out.println(fuzzyRuleSet);

        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
}
