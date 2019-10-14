package com.ort.dbflute.cbean.nss;

import com.ort.dbflute.cbean.cq.VillageSettingCQ;

/**
 * The nest select set-upper of village_setting.
 * @author DBFlute(AutoGenerator)
 */
public class VillageSettingNss {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected final VillageSettingCQ _query;
    public VillageSettingNss(VillageSettingCQ query) { _query = query; }
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
    /**
     * With nested relation columns to select clause. <br>
     * VILLAGE_SETTING_ITEM by my VILLAGE_SETTING_ITEM_CODE, named 'villageSettingItem'.
     */
    public void withVillageSettingItem() {
        _query.xdoNss(() -> _query.queryVillageSettingItem());
    }
}
