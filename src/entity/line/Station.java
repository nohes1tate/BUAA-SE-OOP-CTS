package entity.line;

public class Station implements Comparable {
    private String stationName;
    private int mile;

    public Station(String arg1, String arg2) {
        stationName = arg1;
        mile = Integer.parseInt(arg2);
    }

    public int getStationMile() {
        return mile;
    }

    public String getStationName() {
        return stationName;
    }


    @Override
    public int compareTo(Object newStation) {
        return Integer.compare(this.mile, ((Station) newStation).getStationMile());
    }
}
