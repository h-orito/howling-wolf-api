package com.ort.dbflute.cbean.nss;

import com.ort.dbflute.cbean.cq.PlayerCQ;

/**
 * The nest select set-upper of player.
 * @author DBFlute(AutoGenerator)
 */
public class PlayerNss {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected final PlayerCQ _query;
    public PlayerNss(PlayerCQ query) { _query = query; }
    public boolean hasConditionQuery() { return _query != null; }

    // ===================================================================================
    //                                                                     Nested Relation
    //                                                                     ===============
    /**
     * With nested relation columns to select clause. <br>
     * AUTHORITY by my AUTHORITY_CODE, named 'authority'.
     */
    public void withAuthority() {
        _query.xdoNss(() -> _query.queryAuthority());
    }
}
