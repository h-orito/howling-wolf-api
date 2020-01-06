package com.ort.dbflute.cbean.nss;

import com.ort.dbflute.cbean.cq.AbilityCQ;

/**
 * The nest select set-upper of ability.
 * @author DBFlute(AutoGenerator)
 */
public class AbilityNss {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected final AbilityCQ _query;
    public AbilityNss(AbilityCQ query) { _query = query; }
    public boolean hasConditionQuery() { return _query != null; }

    // ===================================================================================
    //                                                                     Nested Relation
    //                                                                     ===============
    /**
     * With nested relation columns to select clause. <br>
     * ABILITY_TYPE by my ABILITY_TYPE_CODE, named 'abilityType'.
     */
    public void withAbilityType() {
        _query.xdoNss(() -> _query.queryAbilityType());
    }
    /**
     * With nested relation columns to select clause. <br>
     * VILLAGE_PLAYER by my TARGET_VILLAGE_PLAYER_ID, named 'villagePlayerByTargetVillagePlayerId'.
     * @return The set-upper of more nested relation. {...with[nested-relation].with[more-nested-relation]} (NotNull)
     */
    public VillagePlayerNss withVillagePlayerByTargetVillagePlayerId() {
        _query.xdoNss(() -> _query.queryVillagePlayerByTargetVillagePlayerId());
        return new VillagePlayerNss(_query.queryVillagePlayerByTargetVillagePlayerId());
    }
    /**
     * With nested relation columns to select clause. <br>
     * VILLAGE_DAY by my VILLAGE_DAY_ID, named 'villageDay'.
     * @return The set-upper of more nested relation. {...with[nested-relation].with[more-nested-relation]} (NotNull)
     */
    public VillageDayNss withVillageDay() {
        _query.xdoNss(() -> _query.queryVillageDay());
        return new VillageDayNss(_query.queryVillageDay());
    }
    /**
     * With nested relation columns to select clause. <br>
     * VILLAGE_PLAYER by my VILLAGE_PLAYER_ID, named 'villagePlayerByVillagePlayerId'.
     * @return The set-upper of more nested relation. {...with[nested-relation].with[more-nested-relation]} (NotNull)
     */
    public VillagePlayerNss withVillagePlayerByVillagePlayerId() {
        _query.xdoNss(() -> _query.queryVillagePlayerByVillagePlayerId());
        return new VillagePlayerNss(_query.queryVillagePlayerByVillagePlayerId());
    }
}
