package ro.pub.cs.systems.eim.practicaltest01;

public interface Constants {
    public static final String LEFT_COUNT = "left_count";
    public static final String RIGHT_COUNT = "right_count";
    public static final String SUM = "sum";
    public static final String CANCELED = "canceled";
    public static final String OK = "ok";
    public static final int SECONDARY_ACTIVITY_REQUEST_CODE = 1;

    final public static String[] actionTypes = {
            "ro.pub.cs.systems.eim.practicaltest01.arithmeticmean",
            "ro.pub.cs.systems.eim.practicaltest01.geometricmean"
    };

    final public static int NUMBER_OF_CLICKS_THRESHOLD = 5;
    final public static int SERVICE_STOPPED = 0;
    final public static int SERVICE_STARTED = 1;

    final public static String PROCESSING_THREAD_TAG = "[Processing Thread]";

    final public static String BROADCAST_RECEIVER_EXTRA = "message";
    final public static String BROADCAST_RECEIVER_TAG = "[Message]";

}
