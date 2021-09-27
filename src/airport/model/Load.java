package airport.model;

public class Load {
    private int amount;
    private LoadType type;

    public Load(int amount, LoadType type) {
        this.amount = amount;
        this.type = type;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public LoadType getType() {
        return type;
    }

    public void setType(LoadType type) {
        this.type = type;
    }
}
//
//interface Loadable {
//     boolean load(Airplane airplane,Load load) {
//        if (load.getAmount() > airplane.getMaximumNumberOfLoad()) {
//            return false;
//        } else {
//            airplane.setCurrentNumberOfLoad(load.getAmount());
//            return true;
//        }
//    }
//
//    ;
//}
//
//interface Unloadable {
//    default void unload(Airplane airplane,Load load) {
//        load.setAmount(0);
//        airplane.setCurrentNumberOfLoad(load.getAmount());
//    }
//
//    ;
//}