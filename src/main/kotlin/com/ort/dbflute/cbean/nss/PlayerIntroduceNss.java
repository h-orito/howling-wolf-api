package com.ort.dbflute.cbean.nss;

import com.ort.dbflute.cbean.cq.PlayerIntroduceCQ;

/**
 * The nest select set-upper of player_introduce.
 * @author DBFlute(AutoGenerator)
 */
public class PlayerIntroduceNss {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected final PlayerIntroduceCQ _query;
    public PlayerIntroduceNss(PlayerIntroduceCQ query) { _query = query; }
    public boolean hasConditionQuery() { return _query != null; }

    // ===================================================================================
    //                                                                     Nested Relation
    //                                                                     ===============
    /**
     * With nested relation columns to select clause. <br>
     * PLAYER by my FROM_PLAYER_ID, named 'playerByFromPlayerId'.
     * @return The set-upper of more nested relation. {...with[nested-relation].with[more-nested-relation]} (NotNull)
     */
    public PlayerNss withPlayerByFromPlayerId() {
        _query.xdoNss(() -> _query.queryPlayerByFromPlayerId());
        return new PlayerNss(_query.queryPlayerByFromPlayerId());
    }
    /**
     * With nested relation columns to select clause. <br>
     * PLAYER by my TO_PLAYER_ID, named 'playerByToPlayerId'.
     * @return The set-upper of more nested relation. {...with[nested-relation].with[more-nested-relation]} (NotNull)
     */
    public PlayerNss withPlayerByToPlayerId() {
        _query.xdoNss(() -> _query.queryPlayerByToPlayerId());
        return new PlayerNss(_query.queryPlayerByToPlayerId());
    }
}
