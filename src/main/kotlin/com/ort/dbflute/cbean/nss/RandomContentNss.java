package com.ort.dbflute.cbean.nss;

import com.ort.dbflute.cbean.cq.RandomContentCQ;

/**
 * The nest select set-upper of random_content.
 * @author DBFlute(AutoGenerator)
 */
public class RandomContentNss {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected final RandomContentCQ _query;
    public RandomContentNss(RandomContentCQ query) { _query = query; }
    public boolean hasConditionQuery() { return _query != null; }

    // ===================================================================================
    //                                                                     Nested Relation
    //                                                                     ===============
    /**
     * With nested relation columns to select clause. <br>
     * RANDOM_KEYWORD by my RANDOM_KEYWORD_ID, named 'randomKeyword'.
     */
    public void withRandomKeyword() {
        _query.xdoNss(() -> _query.queryRandomKeyword());
    }
}
