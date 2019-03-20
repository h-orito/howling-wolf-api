package com.ort.dbflute.cbean.nss;

import com.ort.dbflute.cbean.cq.VillageCQ;

/**
 * The nest select set-upper of village.
 * @author DBFlute(AutoGenerator)
 */
public class VillageNss {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected final VillageCQ _query;
    public VillageNss(VillageCQ query) { _query = query; }
    public boolean hasConditionQuery() { return _query != null; }

    // ===================================================================================
    //                                                                     Nested Relation
    //                                                                     ===============
    /**
     * With nested relation columns to select clause. <br>
     * VILLAGE_STATUS by my VILLAGE_STATUS_CODE, named 'villageStatus'.
     */
    public void withVillageStatus() {
        _query.xdoNss(() -> _query.queryVillageStatus());
    }
    /**
     * With nested relation columns to select clause. <br>
     * CAMP by my WIN_CAMP_CODE, named 'camp'.
     */
    public void withCamp() {
        _query.xdoNss(() -> _query.queryCamp());
    }
    /**
     * With nested relation columns to select clause. <br>
     * village_settings by VILLAGE_ID, named 'villageSettingsAsOne'.
     * @return The set-upper of more nested relation. {...with[nested-relation].with[more-nested-relation]} (NotNull)
     */
    public VillageSettingsNss withVillageSettingsAsOne() {
        _query.xdoNss(() -> _query.queryVillageSettingsAsOne());
        return new VillageSettingsNss(_query.queryVillageSettingsAsOne());
    }
}
