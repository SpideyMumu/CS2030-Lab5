import java.util.Optional;
import java.util.Map;

class Module implements Keyable {
    private final String module;
    private final ImmutableMap<String, Assessment> mapOfAssessments; 

    Module(String string, ImmutableMap<String, Assessment> map) {
        this.module = string;
        this.mapOfAssessments = map;
    }
    
    Module(String string) {
        this(string, new ImmutableMap<String, Assessment>()); 
    }

    public String getKey() {
        return this.module;
    }
    
    Module put(Assessment a) {
        return new Module(this.module, 
                this.mapOfAssessments.put(a.getKey(), a)); 
    }

    Optional<Assessment> get(String key) {
        return this.mapOfAssessments.get(key);
    }
    
    public String toString() {
        if (this.mapOfAssessments.isEmpty()) {
            return String.format("%s: {}", this.module);
        } else {
            String output = "";
            for (Map.Entry<String, Assessment> e: mapOfAssessments) {
                output += e.getValue() + ", ";
            }
            return String.format("%s: {%s}", 
                    this.module, 
                    output.substring(0, output.length() - 2));
        }
    }
 
}
