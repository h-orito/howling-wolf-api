package com.ort.dbflute.bsentity;

import java.util.List;
import java.util.ArrayList;

import org.dbflute.dbmeta.DBMeta;
import org.dbflute.dbmeta.AbstractEntity;
import org.dbflute.dbmeta.accessory.DomainEntity;
import com.ort.dbflute.allcommon.DBMetaInstanceHandler;
import com.ort.dbflute.exentity.*;

/**
 * The entity of RANDOM_KEYWORD as TABLE. <br>
 * ランダムキーワード
 * <pre>
 * [primary-key]
 *     RANDOM_KEYWORD_ID
 *
 * [column]
 *     RANDOM_KEYWORD_ID, KEYWORD
 *
 * [sequence]
 *     
 *
 * [identity]
 *     RANDOM_KEYWORD_ID
 *
 * [version-no]
 *     
 *
 * [foreign table]
 *     
 *
 * [referrer table]
 *     RANDOM_CONTENT
 *
 * [foreign property]
 *     
 *
 * [referrer property]
 *     randomContentList
 *
 * [get/set template]
 * /= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
 * Integer randomKeywordId = entity.getRandomKeywordId();
 * String keyword = entity.getKeyword();
 * entity.setRandomKeywordId(randomKeywordId);
 * entity.setKeyword(keyword);
 * = = = = = = = = = =/
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsRandomKeyword extends AbstractEntity implements DomainEntity {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** The serial version UID for object serialization. (Default) */
    private static final long serialVersionUID = 1L;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /** RANDOM_KEYWORD_ID: {PK, ID, NotNull, INT UNSIGNED(10)} */
    protected Integer _randomKeywordId;

    /** KEYWORD: {UQ, NotNull, VARCHAR(10)} */
    protected String _keyword;

    // ===================================================================================
    //                                                                             DB Meta
    //                                                                             =======
    /** {@inheritDoc} */
    public DBMeta asDBMeta() {
        return DBMetaInstanceHandler.findDBMeta(asTableDbName());
    }

    /** {@inheritDoc} */
    public String asTableDbName() {
        return "random_keyword";
    }

    // ===================================================================================
    //                                                                        Key Handling
    //                                                                        ============
    /** {@inheritDoc} */
    public boolean hasPrimaryKeyValue() {
        if (_randomKeywordId == null) { return false; }
        return true;
    }

    /**
     * To be unique by the unique column. <br>
     * You can update the entity by the key when entity update (NOT batch update).
     * @param keyword : UQ, NotNull, VARCHAR(10). (NotNull)
     */
    public void uniqueBy(String keyword) {
        __uniqueDrivenProperties.clear();
        __uniqueDrivenProperties.addPropertyName("keyword");
        setKeyword(keyword);
    }

    // ===================================================================================
    //                                                                    Foreign Property
    //                                                                    ================
    // ===================================================================================
    //                                                                   Referrer Property
    //                                                                   =================
    /** RANDOM_CONTENT by RANDOM_KEYWORD_ID, named 'randomContentList'. */
    protected List<RandomContent> _randomContentList;

    /**
     * [get] RANDOM_CONTENT by RANDOM_KEYWORD_ID, named 'randomContentList'.
     * @return The entity list of referrer property 'randomContentList'. (NotNull: even if no loading, returns empty list)
     */
    public List<RandomContent> getRandomContentList() {
        if (_randomContentList == null) { _randomContentList = newReferrerList(); }
        return _randomContentList;
    }

    /**
     * [set] RANDOM_CONTENT by RANDOM_KEYWORD_ID, named 'randomContentList'.
     * @param randomContentList The entity list of referrer property 'randomContentList'. (NullAllowed)
     */
    public void setRandomContentList(List<RandomContent> randomContentList) {
        _randomContentList = randomContentList;
    }

    protected <ELEMENT> List<ELEMENT> newReferrerList() { // overriding to import
        return new ArrayList<ELEMENT>();
    }

    // ===================================================================================
    //                                                                      Basic Override
    //                                                                      ==============
    @Override
    protected boolean doEquals(Object obj) {
        if (obj instanceof BsRandomKeyword) {
            BsRandomKeyword other = (BsRandomKeyword)obj;
            if (!xSV(_randomKeywordId, other._randomKeywordId)) { return false; }
            return true;
        } else {
            return false;
        }
    }

    @Override
    protected int doHashCode(int initial) {
        int hs = initial;
        hs = xCH(hs, asTableDbName());
        hs = xCH(hs, _randomKeywordId);
        return hs;
    }

    @Override
    protected String doBuildStringWithRelation(String li) {
        StringBuilder sb = new StringBuilder();
        if (_randomContentList != null) { for (RandomContent et : _randomContentList)
        { if (et != null) { sb.append(li).append(xbRDS(et, "randomContentList")); } } }
        return sb.toString();
    }

    @Override
    protected String doBuildColumnString(String dm) {
        StringBuilder sb = new StringBuilder();
        sb.append(dm).append(xfND(_randomKeywordId));
        sb.append(dm).append(xfND(_keyword));
        if (sb.length() > dm.length()) {
            sb.delete(0, dm.length());
        }
        sb.insert(0, "{").append("}");
        return sb.toString();
    }

    @Override
    protected String doBuildRelationString(String dm) {
        StringBuilder sb = new StringBuilder();
        if (_randomContentList != null && !_randomContentList.isEmpty())
        { sb.append(dm).append("randomContentList"); }
        if (sb.length() > dm.length()) {
            sb.delete(0, dm.length()).insert(0, "(").append(")");
        }
        return sb.toString();
    }

    @Override
    public RandomKeyword clone() {
        return (RandomKeyword)super.clone();
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    /**
     * [get] RANDOM_KEYWORD_ID: {PK, ID, NotNull, INT UNSIGNED(10)} <br>
     * ランダムキーワードID
     * @return The value of the column 'RANDOM_KEYWORD_ID'. (basically NotNull if selected: for the constraint)
     */
    public Integer getRandomKeywordId() {
        checkSpecifiedProperty("randomKeywordId");
        return _randomKeywordId;
    }

    /**
     * [set] RANDOM_KEYWORD_ID: {PK, ID, NotNull, INT UNSIGNED(10)} <br>
     * ランダムキーワードID
     * @param randomKeywordId The value of the column 'RANDOM_KEYWORD_ID'. (basically NotNull if update: for the constraint)
     */
    public void setRandomKeywordId(Integer randomKeywordId) {
        registerModifiedProperty("randomKeywordId");
        _randomKeywordId = randomKeywordId;
    }

    /**
     * [get] KEYWORD: {UQ, NotNull, VARCHAR(10)} <br>
     * キーワード
     * @return The value of the column 'KEYWORD'. (basically NotNull if selected: for the constraint)
     */
    public String getKeyword() {
        checkSpecifiedProperty("keyword");
        return convertEmptyToNull(_keyword);
    }

    /**
     * [set] KEYWORD: {UQ, NotNull, VARCHAR(10)} <br>
     * キーワード
     * @param keyword The value of the column 'KEYWORD'. (basically NotNull if update: for the constraint)
     */
    public void setKeyword(String keyword) {
        registerModifiedProperty("keyword");
        _keyword = keyword;
    }
}
