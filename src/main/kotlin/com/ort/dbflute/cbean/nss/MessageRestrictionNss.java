package com.ort.dbflute.cbean.nss;

import com.ort.dbflute.cbean.cq.MessageRestrictionCQ;

/**
 * The nest select set-upper of message_restriction.
 * @author DBFlute(AutoGenerator)
 */
public class MessageRestrictionNss {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected final MessageRestrictionCQ _query;
    public MessageRestrictionNss(MessageRestrictionCQ query) { _query = query; }
    public boolean hasConditionQuery() { return _query != null; }

    // ===================================================================================
    //                                                                     Nested Relation
    //                                                                     ===============
    /**
     * With nested relation columns to select clause. <br>
     * MESSAGE_TYPE by my MESSAGE_TYPE_CODE, named 'messageType'.
     */
    public void withMessageType() {
        _query.xdoNss(() -> _query.queryMessageType());
    }
    /**
     * With nested relation columns to select clause. <br>
     * SKILL by my SKILL_CODE, named 'skill'.
     * @return The set-upper of more nested relation. {...with[nested-relation].with[more-nested-relation]} (NotNull)
     */
    public SkillNss withSkill() {
        _query.xdoNss(() -> _query.querySkill());
        return new SkillNss(_query.querySkill());
    }
    /**
     * With nested relation columns to select clause. <br>
     * VILLAGE by my VILLAGE_ID, named 'village'.
     * @return The set-upper of more nested relation. {...with[nested-relation].with[more-nested-relation]} (NotNull)
     */
    public VillageNss withVillage() {
        _query.xdoNss(() -> _query.queryVillage());
        return new VillageNss(_query.queryVillage());
    }
}
