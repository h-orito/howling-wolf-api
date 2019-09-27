package com.ort.dbflute.exentity;

import com.ort.dbflute.bsentity.BsVillage;

/**
 * The entity of VILLAGE.
 * <p>
 * You can implement your original methods here.
 * This class remains when re-generating.
 * </p>
 * @author DBFlute(AutoGenerator)
 */
public class Village extends BsVillage {

    /** The serial version UID for object serialization. (Default) */
    private static final long serialVersionUID = 1L;

    /** PARTICIPANT_COUNT: Derived Referrer Alias. */
    public static final String ALIAS_participantCount = "PARTICIPANT_COUNT";
    /** PARTICIPANT_COUNT: (Derived Referrer) */
    protected Integer _participantCount;

    /**
     * [get] PARTICIPANT_COUNT: (Derived Referrer)
     * @return The value of the column 'PARTICIPANT_COUNT'. (NullAllowed)
     */
    public Integer getParticipantCount() {
        return _participantCount;
    }

    /**
     * [set] PARTICIPANT_COUNT: (Derived Referrer)
     * @param participantCount The value of the column 'PARTICIPANT_COUNT'. (NullAllowed)
     */
    public void setParticipantCount(Integer participantCount) {
        _participantCount = participantCount;
    }

    /** VISITOR_COUNT: Derived Referrer Alias. */
    public static final String ALIAS_visitorCount = "VISITOR_COUNT";
    /** VISITOR_COUNT: (Derived Referrer) */
    protected Integer _visitorCount;

    /**
     * [get] VISITOR_COUNT: (Derived Referrer)
     * @return The value of the column 'VISITOR_COUNT'. (NullAllowed)
     */
    public Integer getVisitorCount() {
        return _visitorCount;
    }

    /**
     * [set] VISITOR_COUNT: (Derived Referrer)
     * @param visitorCount The value of the column 'VISITOR_COUNT'. (NullAllowed)
     */
    public void setVisitorCount(Integer visitorCount) {
        _visitorCount = visitorCount;
    }
}
