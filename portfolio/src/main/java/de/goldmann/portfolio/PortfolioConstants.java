package de.goldmann.portfolio;

import static java.time.format.DateTimeFormatter.ofPattern;

import java.time.format.DateTimeFormatter;

public final class PortfolioConstants {

    public static final boolean APPLICATION_MANAGED_TRANSACTIONS = true;
    public static final boolean DETACHED_ENTITIES = false;
    public static final boolean COMPOSITE_ITEMS = false;
    public static final int     BATCH_SIZE_LAZYQUERYCONTAINER    = 500;
    public static final String   TEMPLATES_FOLDER    = "templates/";
    public static final DateTimeFormatter FORMATTER = ofPattern("dd-MM-yyyy");
    // private final Set<Integer> PARTS_TO_SKIP = new HashSet<>(Arrays.asList(1,
    // 2, 5, 6));

    PortfolioConstants() {}

    public static final String CSV_SEPERATOR     = ",";
    static final String        JS_PATH           = "vaadin://themes/reindeer/layouts/app/js/";
    static final String        VENDOR_PATH       = "vaadin://themes/reindeer/layouts/vendor/";
    static final String        JQUERY_PATH       = "jquery/";
    static final String        FASTCLICK_PATH    = "fastclick/";
    static final String        MODERNIZER_PATH   = "modernizr/";
    static final String        BOOTSTRAP_PATH    = "bootstrap/";
    static final String        CHOSEN_PATH       = "chosen/";
    static final String        SLIDER_PATH       = "slider/";
    static final String        FILESTYLE_PATH    = "filestyle/";
    static final String        ANIMO_PATH        = "animo/";
    static final String        SPARKLINES_PATH   = "sparklines/";
    static final String        SLIMSCROLL_PATH   = "slimscroll/";
    static final String        STORE_PATH        = "store/";
    static final String        FONTAWESOME_PATH  = "fontawesome/";
    static final String        CSSSPINNER_PATH   = "csspinner/";
    static final String        DATETIMEPICKER_PATH = "datetimepicker/";
    static final String        MOMENT_PATH         = "moment/";

    static final String        CLASSYLOADER_PATH = "classyloader/";

    static final String        CSS_PATH          = "vaadin://themes/reindeer/layouts/app/css/";
    public static final String URL_LOGINUI       = "/login";
}
