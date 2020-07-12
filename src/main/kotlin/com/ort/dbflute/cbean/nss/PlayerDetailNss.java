package com.ort.dbflute.cbean.nss;

import com.ort.dbflute.cbean.cq.PlayerDetailCQ;

/**
 * The nest select set-upper of player_detail.
 * @author DBFlute(AutoGenerator)
 */
public class PlayerDetailNss {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected final PlayerDetailCQ _query;
    public PlayerDetailNss(PlayerDetailCQ query) { _query = query; }
    public boolean hasConditionQuery() { return _query != null; }

    // ===================================================================================
    //                                                                     Nested Relation
    //                                                                     ===============
    /**
     * With nested relation columns to select clause. <br>
     * PLAYER by my PLAYER_ID, named 'player'.
     * @return The set-upper of more nested relation. {...with[nested-relation].with[more-nested-relation]} (NotNull)
     */
    public PlayerNss withPlayer() {
        _query.xdoNss(() -> _query.queryPlayer());
        return new PlayerNss(_query.queryPlayer());
    }
}
