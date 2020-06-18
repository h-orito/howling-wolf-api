package com.ort.dbflute.cbean.nss;

import com.ort.dbflute.cbean.cq.CharaCQ;

/**
 * The nest select set-upper of CHARA.
 * @author DBFlute(AutoGenerator)
 */
public class CharaNss {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected final CharaCQ _query;
    public CharaNss(CharaCQ query) { _query = query; }
    public boolean hasConditionQuery() { return _query != null; }

    // ===================================================================================
    //                                                                     Nested Relation
    //                                                                     ===============
    /**
     * With nested relation columns to select clause. <br>
     * CHARA_GROUP by my CHARA_GROUP_ID, named 'charaGroup'.
     * @return The set-upper of more nested relation. {...with[nested-relation].with[more-nested-relation]} (NotNull)
     */
    public CharaGroupNss withCharaGroup() {
        _query.xdoNss(() -> _query.queryCharaGroup());
        return new CharaGroupNss(_query.queryCharaGroup());
    }
}
