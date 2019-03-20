package com.ort.dbflute.cbean.nss;

import com.ort.dbflute.cbean.cq.CommitCQ;

/**
 * The nest select set-upper of commit.
 * @author DBFlute(AutoGenerator)
 */
public class CommitNss {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected final CommitCQ _query;
    public CommitNss(CommitCQ query) { _query = query; }
    public boolean hasConditionQuery() { return _query != null; }

    // ===================================================================================
    //                                                                     Nested Relation
    //                                                                     ===============
    /**
     * With nested relation columns to select clause. <br>
     * VILLAGE_DAY by my VILLAGE_ID, DAY, named 'villageDay'.
     * @return The set-upper of more nested relation. {...with[nested-relation].with[more-nested-relation]} (NotNull)
     */
    public VillageDayNss withVillageDay() {
        _query.xdoNss(() -> _query.queryVillageDay());
        return new VillageDayNss(_query.queryVillageDay());
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
