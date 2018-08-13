package pl.coderslab.models;

public enum Status {

    ACCEPTED("Przyjęty"),
    APPROVED_EXPENSES("Zatwierdzone koszty naprawy"),
    REPAIR_IN_PROGRESS("W naprawie"),
    REPAIR_COMPLETE("Gotowy do odbioru"),
    RESIGNATION("Rezygnacja");

    private String description;

    Status(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
