package com.ort.dbflute.cbean.nss;

import com.ort.dbflute.cbean.cq.ComingOutCQ;

/**
 * The nest select set-upper of COMING_OUT.
 * @author DBFlute(AutoGenerator)
 */
public class ComingOutNss {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected final ComingOutCQ _query;
    public ComingOutNss(ComingOutCQ query) { _query = query; }
    public boolean hasConditionQuery() { return _query != null; }

    // ===================================================================================
    //                                                                     Nested Relation
    //                                                                     ===============
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
     * VILLAGE_PLAYER by my VILLAGE_PLAYER_ID, named 'villagePlayer'.
     * @return The set-upper of more nested relation. {...with[nested-relation].with[more-nested-relation]} (NotNull)
     */
    public VillagePlayerNss withVillagePlayer() {
        _query.xdoNss(() -> _query.queryVillagePlayer());
        return new VillagePlayerNss(_query.queryVillagePlayer());
    }
}
