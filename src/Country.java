/**
 * Created by joshuakeough on 9/11/16.
 */
public class Country {
    private String abbreviation;
    private String name;

    public Country(String abbreviation, String name) {
        this.abbreviation = abbreviation;
        this.name = name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("Country: %s Abbreviation: %s\n", name, abbreviation);
    }
}
