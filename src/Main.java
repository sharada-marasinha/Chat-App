public class Main {
    public static void main(String[] args) {
        MassageObservable massageObservable = MassageObservable.getInstance();
        massageObservable.addMassageCom(new MassageComponent("Sender 01"));
        massageObservable.addMassageCom(new MassageComponent("Sender 02"));
        massageObservable.addMassageCom(new MassageComponent("Sender 03"));
        massageObservable.addMassageCom(new MassageComponent("Sender 04"));
    }
}