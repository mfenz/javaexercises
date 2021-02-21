package model;

public class Entry {
    public enum AgeGroup {
        U65, // under 65
        AB65, // above
    }
    public enum Gender {
        MALE,
        FEMALE
    }
    int year;
    int kw;
    AgeGroup ageGroup;
    Gender gender;
    int deaths;

    public Entry(int year, int kw, AgeGroup ageGroup, Gender gender, int deaths) {
        this.year = year;
        this.kw = kw;
        this.ageGroup = ageGroup;
        this.gender = gender;
        this.deaths = deaths;
    }

    public int getYear() {
        return year;
    }

    public int getKw() {
        return kw;
    }

    public AgeGroup getAgeGroup() {
        return ageGroup;
    }

    public Gender getGender() {
        return gender;
    }

    public int getDeaths() {
        return deaths;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "year=" + year +
                ", kw=" + kw +
                ", ageGroup=" + ageGroup +
                ", gender=" + gender +
                ", deaths=" + deaths +
                '}';
    }
}
