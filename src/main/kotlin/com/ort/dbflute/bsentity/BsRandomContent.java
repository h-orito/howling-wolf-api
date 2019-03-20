package com.ort.dbflute.bsentity;

import java.util.List;
import java.util.ArrayList;

import org.dbflute.Entity;
import org.dbflute.dbmeta.DBMeta;
import org.dbflute.dbmeta.AbstractEntity;
import org.dbflute.dbmeta.accessory.DomainEntity;
import org.dbflute.optional.OptionalEntity;
import com.ort.dbflute.allcommon.DBMetaInstanceHandler;
import com.ort.dbflute.exentity.*;

/**
 * The entity of RANDOM_CONTENT as TABLE. <br>
 * ランダム変換内容
 * <pre>
 * [primary-key]
 *     RANDOM_CONTENT_ID
 *
 * [column]
 *     RANDOM_CONTENT_ID, RANDOM_KEYWORD_ID, RANDOM_MESSAGE
 *
 * [sequence]
 *     
 *
 * [identity]
 *     RANDOM_CONTENT_ID
 *
 * [version-no]
 *     
 *
 * [foreign table]
 *     RANDOM_KEYWORD
 *
 * [referrer table]
 *     
 *
 * [foreign property]
 *     randomKeyword
 *
 * [referrer property]
 *     
 *
 * [get/set template]
 * /= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
 * Integer randomContentId = entity.getRandomContentId();
 * Integer randomKeywordId = entity.getRandomKeywordId();
 * String randomMessage = entity.getRandomMessage();
 * entity.setRandomContentId(randomContentId);
 * entity.setRandomKeywordId(randomKeywordId);
 * entity.setRandomMessage(randomMessage);
 * = = = = = = = = = =/
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsRandomContent extends AbstractEntity implements DomainEntity {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** The serial version UID for object serialization. (Default) */
    private static final long serialVersionUID = 1L;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /** RANDOM_CONTENT_ID: {PK, ID, NotNull, INT UNSIGNED(10)} */
    protected Integer _randomContentId;

    /** RANDOM_KEYWORD_ID: {IX, NotNull, INT UNSIGNED(10), FK to random_keyword} */
    protected Integer _randomKeywordId;

    /** RANDOM_MESSAGE: {NotNull, VARCHAR(20)} */
    protected String _randomMessage;

    // ===================================================================================
    //                                                                             DB Meta
    //                                                                             =======
    /** {@inheritDoc} */
    public DBMeta asDBMeta() {
        return DBMetaInstanceHandler.findDBMeta(asTableDbName());
    }

    /** {@inheritDoc} */
    public String asTableDbName() {
        return "random_content";
    }

    // ===================================================================================
    //                                                                        Key Handling
    //                                                                        ============
    /** {@inheritDoc} */
    public boolean hasPrimaryKeyValue() {
        if (_randomContentId == null) { return false; }
        return true;
    }

    // ===================================================================================
    //                                                                    Foreign Property
    //                                                                    ================
    /** RANDOM_KEYWORD by my RANDOM_KEYWORD_ID, named 'randomKeyword'. */
    protected OptionalEntity<RandomKeyword> _randomKeyword;

    /**
     * [get] RANDOM_KEYWORD by my RANDOM_KEYWORD_ID, named 'randomKeyword'. <br>
     * Optional: alwaysPresent(), ifPresent().orElse(), get(), ...
     * @return The entity of foreign property 'randomKeyword'. (NotNull, EmptyAllowed: when e.g. null FK column, no setupSelect)
     */
    public OptionalEntity<RandomKeyword> getRandomKeyword() {
        if (_randomKeyword == null) { _randomKeyword = OptionalEntity.relationEmpty(this, "randomKeyword"); }
        return _randomKeyword;
    }

    /**
     * [set] RANDOM_KEYWORD by my RANDOM_KEYWORD_ID, named 'randomKeyword'.
     * @param randomKeyword The entity of foreign property 'randomKeyword'. (NullAllowed)
     */
    public void setRandomKeyword(OptionalEntity<RandomKeyword> randomKeyword) {
        _randomKeyword = randomKeyword;
    }

    // ===================================================================================
    //                                                                   Referrer Property
    //                                                                   =================
    protected <ELEMENT> List<ELEMENT> newReferrerList() { // overriding to import
        return new ArrayList<ELEMENT>();
    }

    // ===================================================================================
    //                                                                      Basic Override
    //                                                                      ==============
    @Override
    protected boolean doEquals(Object obj) {
        if (obj instanceof BsRandomContent) {
            BsRandomContent other = (BsRandomContent)obj;
            if (!xSV(_randomContentId, other._randomContentId)) { return false; }
            return true;
        } else {
            return false;
        }
    }

    @Override
    protected int doHashCode(int initial) {
        int hs = initial;
        hs = xCH(hs, asTableDbName());
        hs = xCH(hs, _randomContentId);
        return hs;
    }

    @Override
    protected String doBuildStringWithRelation(String li) {
        StringBuilder sb = new StringBuilder();
        if (_randomKeyword != null && _randomKeyword.isPresent())
        { sb.append(li).append(xbRDS(_randomKeyword, "randomKeyword")); }
        return sb.toString();
    }
    protected <ET extends Entity> String xbRDS(org.dbflute.optional.OptionalEntity<ET> et, String name) { // buildRelationDisplayString()
        return et.get().buildDisplayString(name, true, true);
    }

    @Override
    protected String doBuildColumnString(String dm) {
        StringBuilder sb = new StringBuilder();
        sb.append(dm).append(xfND(_randomContentId));
        sb.append(dm).append(xfND(_randomKeywordId));
        sb.append(dm).append(xfND(_randomMessage));
        if (sb.length() > dm.length()) {
            sb.delete(0, dm.length());
        }
        sb.insert(0, "{").append("}");
        return sb.toString();
    }

    @Override
    protected String doBuildRelationString(String dm) {
        StringBuilder sb = new StringBuilder();
        if (_randomKeyword != null && _randomKeyword.isPresent())
        { sb.append(dm).append("randomKeyword"); }
        if (sb.length() > dm.length()) {
            sb.delete(0, dm.length()).insert(0, "(").append(")");
        }
        return sb.toString();
    }

    @Override
    public RandomContent clone() {
        return (RandomContent)super.clone();
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    /**
     * [get] RANDOM_CONTENT_ID: {PK, ID, NotNull, INT UNSIGNED(10)} <br>
     * ランダム変換内容ID
     * @return The value of the column 'RANDOM_CONTENT_ID'. (basically NotNull if selected: for the constraint)
     */
    public Integer getRandomContentId() {
        checkSpecifiedProperty("randomContentId");
        return _randomContentId;
    }

    /**
     * [set] RANDOM_CONTENT_ID: {PK, ID, NotNull, INT UNSIGNED(10)} <br>
     * ランダム変換内容ID
     * @param randomContentId The value of the column 'RANDOM_CONTENT_ID'. (basically NotNull if update: for the constraint)
     */
    public void setRandomContentId(Integer randomContentId) {
        registerModifiedProperty("randomContentId");
        _randomContentId = randomContentId;
    }

    /**
     * [get] RANDOM_KEYWORD_ID: {IX, NotNull, INT UNSIGNED(10), FK to random_keyword} <br>
     * ランダムキーワードID
     * @return The value of the column 'RANDOM_KEYWORD_ID'. (basically NotNull if selected: for the constraint)
     */
    public Integer getRandomKeywordId() {
        checkSpecifiedProperty("randomKeywordId");
        return _randomKeywordId;
    }

    /**
     * [set] RANDOM_KEYWORD_ID: {IX, NotNull, INT UNSIGNED(10), FK to random_keyword} <br>
     * ランダムキーワードID
     * @param randomKeywordId The value of the column 'RANDOM_KEYWORD_ID'. (basically NotNull if update: for the constraint)
     */
    public void setRandomKeywordId(Integer randomKeywordId) {
        registerModifiedProperty("randomKeywordId");
        _randomKeywordId = randomKeywordId;
    }

    /**
     * [get] RANDOM_MESSAGE: {NotNull, VARCHAR(20)} <br>
     * ランダム変換内容文字列
     * @return The value of the column 'RANDOM_MESSAGE'. (basically NotNull if selected: for the constraint)
     */
    public String getRandomMessage() {
        checkSpecifiedProperty("randomMessage");
        return convertEmptyToNull(_randomMessage);
    }

    /**
     * [set] RANDOM_MESSAGE: {NotNull, VARCHAR(20)} <br>
     * ランダム変換内容文字列
     * @param randomMessage The value of the column 'RANDOM_MESSAGE'. (basically NotNull if update: for the constraint)
     */
    public void setRandomMessage(String randomMessage) {
        registerModifiedProperty("randomMessage");
        _randomMessage = randomMessage;
    }
}
