package com.ort.dbflute.cbean.nss;

import com.ort.dbflute.cbean.cq.CharaImageCQ;

/**
 * The nest select set-upper of chara_image.
 * @author DBFlute(AutoGenerator)
 */
public class CharaImageNss {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected final CharaImageCQ _query;
    public CharaImageNss(CharaImageCQ query) { _query = query; }
    public boolean hasConditionQuery() { return _query != null; }

    // ===================================================================================
    //                                                                     Nested Relation
    //                                                                     ===============
    /**
     * With nested relation columns to select clause. <br>
     * CHARA by my CHARA_ID, named 'chara'.
     * @return The set-upper of more nested relation. {...with[nested-relation].with[more-nested-relation]} (NotNull)
     */
    public CharaNss withChara() {
        _query.xdoNss(() -> _query.queryChara());
        return new CharaNss(_query.queryChara());
    }
    /**
     * With nested relation columns to select clause. <br>
     * FACE_TYPE by my FACE_TYPE_CODE, named 'faceType'.
     */
    public void withFaceType() {
        _query.xdoNss(() -> _query.queryFaceType());
    }
}
