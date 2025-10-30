// SmartFertilizerAdvisory.java
import java.util.ArrayList;
import java.util.List;

public class SmartFertilizerAdvisory {

    public static void processSamples(List<SoilAnalysis> samples) {
        System.out.println("==================================================");
        System.out.println("SMART AGRICULTURE PROGRAMME - ADVISORY REPORT");
        System.out.println("==================================================");

        int balancedCount = 0;
        int deficientCount = 0;

        for (SoilAnalysis sample : samples) {
            try {
                System.out.println(sample.getReport());

                String recommendation = sample.calculateFertilizerNeeded();
                if (recommendation.startsWith("OPTIMAL")) {
                    balancedCount++;
                } else if (recommendation.startsWith("DEFICIENT")) {
                    deficientCount++;
                }

            } catch (Exception e) {
                // Catch exceptions thrown by the SoilAnalysis constructor
                System.out.println("Error for Farmer ID " + sample.getFarmerId() + ": " + e.getMessage());
                System.out.println("--------------------------------------------------");
            }
        }

        System.out.println("\nSUMMARY REPORT");
        System.out.println("Balanced Samples: " + balancedCount);
        System.out.println("Deficient Samples: " + deficientCount);
        System.out.println("==================================================");
    }

    public static void main(String[] args) {

        List<SoilAnalysis> samplesToProcess = new ArrayList<>();

        try {
            SoilAnalysis s1 = new SoilAnalysis("F001", "Kirehe", 45, 80, 55, "Maize");
            samplesToProcess.add(s1);
        } catch (IllegalArgumentException e) {}

        try {
            SoilAnalysis s2 = new SoilAnalysis("F002", "Bugesera", 15, 60, 40, "Rice");
            samplesToProcess.add(s2);
        } catch (IllegalArgumentException e) {}

        try {
            SoilAnalysis s3 = new SoilAnalysis("F003", "Nyagatare", 110, 50, 60, "Beans");
            samplesToProcess.add(s3);
        } catch (IllegalArgumentException e) {}

        try {
            SoilAnalysis s4 = new SoilAnalysis("F004", "Gatsibo", 30, 0, 50, "Sorghum");
            samplesToProcess.add(s4);
        } catch (IllegalArgumentException e) {
            System.out.println("Error creating F004: " + e.getMessage());
        }

        try {
            SoilAnalysis s5 = new SoilAnalysis("F005", "Huye", 15, 15, 18, "Rice");
            samplesToProcess.add(s5);
        } catch (IllegalArgumentException e) {}

        try {
            SoilAnalysis s6 = new SoilAnalysis("F006", "Rwamagana", 10, 60, 150, "Coffee");
            samplesToProcess.add(s6);
        } catch (IllegalArgumentException e) {}

        // Run the processing function
        processSamples(samplesToProcess);
    }
}
