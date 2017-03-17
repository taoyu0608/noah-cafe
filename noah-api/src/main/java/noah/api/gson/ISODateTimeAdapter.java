package noah.api.gson;

import org.joda.time.format.ISODateTimeFormat;


/**
 * The ISO 8601 data elements and interchange formats adapter.<br>
 * <br>
 * 
 * format sample: 2012-12-05T10:55:41.063+08:00
 * 
 * refer: http://en.wikipedia.org/wiki/ISO_8601
 * 
 * @author dennis_yen
 * 
 */
public class ISODateTimeAdapter extends AbstractDateTimeTypeAdapter {

    public ISODateTimeAdapter() {
        super(ISODateTimeFormat.dateTime());
    }

}
