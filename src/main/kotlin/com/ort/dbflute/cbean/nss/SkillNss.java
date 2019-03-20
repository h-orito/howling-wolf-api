package com.ort.dbflute.cbean.nss;

import com.ort.dbflute.cbean.cq.SkillCQ;

/**
 * The nest select set-upper of skill.
 * @author DBFlute(AutoGenerator)
 */
public class SkillNss {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected final SkillCQ _query;
    public SkillNss(SkillCQ query) { _query = query; }
    public boolean hasConditionQuery() { return _query != null; }

    // ===================================================================================
    //                                                                     Nested Relation
    //                                                                     ===============
    /**
     * With nested relation columns to select clause. <br>
     * CAMP by my CAMP_CODE, named 'camp'.
     */
    public void withCamp() {
        _query.xdoNss(() -> _query.queryCamp());
    }
}
