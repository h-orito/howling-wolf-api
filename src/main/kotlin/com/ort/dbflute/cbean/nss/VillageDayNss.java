package com.ort.dbflute.cbean.nss;

import com.ort.dbflute.cbean.cq.VillageDayCQ;

/**
 * The nest select set-upper of village_day.
 * @author DBFlute(AutoGenerator)
 */
public class VillageDayNss {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected final VillageDayCQ _query;
    public VillageDayNss(VillageDayCQ query) { _query = query; }
    public boolean hasConditionQuery() { return _query != null; }

    // ===================================================================================
    //                                                                     Nested Relation
    //                                                                     ===============
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
