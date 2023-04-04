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
    /**
     * With nested relation columns to select clause. <br>
     * player_detail by PLAYER_ID, named 'playerDetailAsOne'.
     * @return The set-upper of more nested relation. {...with[nested-relation].with[more-nested-relation]} (NotNull)
     */
    public PlayerDetailNss withPlayerDetailAsOne() {
        _query.xdoNss(() -> _query.queryPlayerDetailAsOne());
        return new PlayerDetailNss(_query.queryPlayerDetailAsOne());
    }
    /**
     * With nested relation columns to select clause. <br>
     * twitter_user by player_id, named 'twitterUserAsOne'.
     * @return The set-upper of more nested relation. {...with[nested-relation].with[more-nested-relation]} (NotNull)
     */
    public TwitterUserNss withTwitterUserAsOne() {
        _query.xdoNss(() -> _query.queryTwitterUserAsOne());
        return new TwitterUserNss(_query.queryTwitterUserAsOne());
    }
}
