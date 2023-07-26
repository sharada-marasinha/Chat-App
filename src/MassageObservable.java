
public class MassageObservable {
    private MassageObserver[] massageObserversArray = new MassageObserver[0];

    private static MassageObservable instance = null;

    private String text;

    private String title;

    private MassageObservable() {

    }

    public void addMassageCom(MassageObserver observer) {
        extendArray();
        massageObserversArray[massageObserversArray.length - 1] = observer;



    }

    private void extendArray() {
        MassageObserver[] temp = new MassageObserver[massageObserversArray.length + 1];
        for (int i = 0; i < massageObserversArray.length; i++) {
            temp[i] = massageObserversArray[i];

        }
        massageObserversArray = temp;

    }

    public void getMassage(String title,String text) {
        if (text != null && !text.isEmpty()) {
            this.text = text;
            this.title= title;
            notifyMassage();
        }
    }

    public void notifyMassage() {
        for (int i = 0; i < massageObserversArray.length; i++) {
            massageObserversArray[i].update(this.text,this.title);
        }
    }

    public static MassageObservable getInstance() {

        if (instance == null) {
            instance = new MassageObservable();
        }
        return instance;
    }
}
