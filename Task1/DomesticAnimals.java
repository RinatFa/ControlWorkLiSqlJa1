
public class DomesticAnimals {
    protected String animal_name;
    protected String birthdate;
    protected String executed_commands;

    DomesticAnimals(String animal_name, String birthdate, String executed_commands) {
        this.animal_name = animal_name;
        this.birthdate = birthdate;
        this.executed_commands = executed_commands;
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

    public String toString() {
        String sStr = "";
        sStr += getAnimalName() + "  дата рожд.: " +
                getBirthdate() + "  команды: " + getExecutedCommands();
        return sStr;
    }
}
