package com.ort.dbflute.cbean.nss;

import com.ort.dbflute.cbean.cq.CharaGroupCQ;

/**
 * The nest select set-upper of CHARA_GROUP.
 * @author DBFlute(AutoGenerator)
 */
public class CharaGroupNss {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected final CharaGroupCQ _query;
    public CharaGroupNss(CharaGroupCQ query) { _query = query; }
    public boolean hasConditionQuery() { return _query != null; }

    // ===================================================================================
    //                                                                     Nested Relation
    //                                                                     ===============
    /**
     * With nested relation columns to select clause. <br>
     * DESIGNER by my DESIGNER_ID, named 'designer'.
     */
    public void withDesigner() {
        _query.xdoNss(() -> _query.queryDesigner());
    }
}
