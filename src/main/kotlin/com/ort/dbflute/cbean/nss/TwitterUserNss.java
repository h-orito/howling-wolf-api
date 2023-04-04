package com.ort.dbflute.cbean.nss;

import com.ort.dbflute.cbean.cq.TwitterUserCQ;

/**
 * The nest select set-upper of twitter_user.
 * @author DBFlute(AutoGenerator)
 */
public class TwitterUserNss {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected final TwitterUserCQ _query;
    public TwitterUserNss(TwitterUserCQ query) { _query = query; }
    public boolean hasConditionQuery() { return _query != null; }

    // ===================================================================================
    //                                                                     Nested Relation
    //                                                                     ===============
    /**
     * With nested relation columns to select clause. <br>
     * PLAYER by my player_id, named 'player'.
     * @return The set-upper of more nested relation. {...with[nested-relation].with[more-nested-relation]} (NotNull)
     */
    public PlayerNss withPlayer() {
        _query.xdoNss(() -> _query.queryPlayer());
        return new PlayerNss(_query.queryPlayer());
    }
}
