// SoilAnalysis.java
import java.util.ArrayList;
import java.util.List;


public class SoilAnalysis {
    private String farmerId;
    private String districtName;
    private double nitrogenLevel;
    private double phosphorusLevel;
    private double potassiumLevel;
    private String cropType;

    // Constants for nutrient range checks
    private static final int MIN_BALANCED = 20;
    private static final int MAX_BALANCED = 100;

    /**
     * Constructor to initialize all fields for a SoilAnalysis object.
     * @param farmerId The farmer's unique identifier.
     * @param districtName The district where the sample was taken.
     * @param nitrogenLevel The level of Nitrogen (N) in ppm.
     * @param phosphorusLevel The level of Phosphorus (P) in ppm.
     * @param potassiumLevel The level of Potassium (K) in ppm.
     * @param cropType The type of crop to be grown.
     * @throws IllegalArgumentException if any nutrient reading is 0 or negative.
     */
    public SoilAnalysis(String farmerId, String districtName, double nitrogenLevel, 
                        double phosphorusLevel, double potassiumLevel, String cropType) 
                        throws IllegalArgumentException {


        if (nitrogenLevel <= 0 || phosphorusLevel <= 0 || potassiumLevel <= 0) {
            throw new IllegalArgumentException("Invalid nutrient reading");
        }

        this.farmerId = farmerId;
        this.districtName = districtName;
        this.nitrogenLevel = nitrogenLevel;
        this.phosphorusLevel = phosphorusLevel;
        this.potassiumLevel = potassiumLevel;
        this.cropType = cropType;
    }

    /**
     * @return true if balanced, false otherwise.
     */
    public boolean isBalanced() {
        return (nitrogenLevel >= MIN_BALANCED && nitrogenLevel <= MAX_BALANCED) &&
               (phosphorusLevel >= MIN_BALANCED && phosphorusLevel <= MAX_BALANCED) &&
               (potassiumLevel >= MIN_BALANCED && potassiumLevel <= MAX_BALANCED);
    }

    /**
     
     * @return A string containing the fertilizer recommendation.
     */
    public String calculateFertilizerNeeded() {
        

        if (isBalanced()) {
            return "OPTIMAL - Maintenance fertilizer only";
        }

       
        List<String> deficientNutrients = new ArrayList<>();
        if (nitrogenLevel < MIN_BALANCED) deficientNutrients.add("Nitrogen");
        if (phosphorusLevel < MIN_BALANCED) deficientNutrients.add("Phosphorus");
        if (potassiumLevel < MIN_BALANCED) deficientNutrients.add("Potassium");

        if (!deficientNutrients.isEmpty()) {
            String nutrientNames = String.join(" and ", deficientNutrients);
            return "DEFICIENT - High application needed for " + nutrientNames;
        }

       
        List<String> excessNutrients = new ArrayList<>();
        if (nitrogenLevel > MAX_BALANCED) excessNutrients.add("Nitrogen");
        if (phosphorusLevel > MAX_BALANCED) excessNutrients.add("Phosphorus");
        if (potassiumLevel > MAX_BALANCED) excessNutrients.add("Potassium");
        
        if (!excessNutrients.isEmpty()) {
             String nutrientNames = String.join(" and ", excessNutrients);
             return "EXCESS - Reduce " + nutrientNames + " application";
        }

       
        return "Analysis result unclear - review nutrient levels.";
    }

 
    
    public String getFarmerId() {
        return farmerId;
    }

    public String getDistrictName() {
        return districtName;
    }

    public double getNitrogenLevel() {
        return nitrogenLevel;
    }

    public double getPhosphorusLevel() {
        return phosphorusLevel;
    }

    public double getPotassiumLevel() {
        return potassiumLevel;
    }

    public String getCropType() {
        return cropType;
    }
    
 
    public String getReport() {
        return "Farmer ID: " + farmerId + "\n" +
               "District: " + districtName + "\n" +
               "Crop Type: " + cropType + "\n" +
               "Recommendation: " + calculateFertilizerNeeded() + "\n" +
               "--------------------------------------------------";
    }
}