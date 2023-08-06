
public class Cats extends DomesticAnimals {
    Cats(String animal_name, String birthdate, String executed_commands) {
        super(animal_name, birthdate, executed_commands);
    }

    String getAnimalName() {
        return this.animal_name;
    }

    String getBirthdate() {
        return this.birthdate;
    }

    String getExecutedCommands() {
        return this.executed_commands;
    }

    void setAnimalName(String animal_name) {
        this.animal_name = animal_name;
    }

    void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    void setExecutedCommands(String executed_commands) {
        this.executed_commands = executed_commands;
    }
}
