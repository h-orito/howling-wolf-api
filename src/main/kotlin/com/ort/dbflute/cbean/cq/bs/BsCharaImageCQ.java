package com.ort.dbflute.cbean.cq.bs;

import java.util.Map;

import org.dbflute.cbean.*;
import org.dbflute.cbean.chelper.*;
import org.dbflute.cbean.coption.*;
import org.dbflute.cbean.cvalue.ConditionValue;
import org.dbflute.cbean.sqlclause.SqlClause;
import org.dbflute.exception.IllegalConditionBeanOperationException;
import com.ort.dbflute.cbean.cq.ciq.*;
import com.ort.dbflute.cbean.*;
import com.ort.dbflute.cbean.cq.*;

/**
 * The base condition-query of chara_image.
 * @author DBFlute(AutoGenerator)
 */
public class BsCharaImageCQ extends AbstractBsCharaImageCQ {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected CharaImageCIQ _inlineQuery;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public BsCharaImageCQ(ConditionQuery referrerQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
        super(referrerQuery, sqlClause, aliasName, nestLevel);
    }

    // ===================================================================================
    //                                                                 InlineView/OrClause
    //                                                                 ===================
    /**
     * Prepare InlineView query. <br>
     * {select ... from ... left outer join (select * from chara_image) where FOO = [value] ...}
     * <pre>
     * cb.query().queryMemberStatus().<span style="color: #CC4747">inline()</span>.setFoo...;
     * </pre>
     * @return The condition-query for InlineView query. (NotNull)
     */
    public CharaImageCIQ inline() {
        if (_inlineQuery == null) { _inlineQuery = xcreateCIQ(); }
        _inlineQuery.xsetOnClause(false); return _inlineQuery;
    }

    protected CharaImageCIQ xcreateCIQ() {
        CharaImageCIQ ciq = xnewCIQ();
        ciq.xsetBaseCB(_baseCB);
        return ciq;
    }

    protected CharaImageCIQ xnewCIQ() {
        return new CharaImageCIQ(xgetReferrerQuery(), xgetSqlClause(), xgetAliasName(), xgetNestLevel(), this);
    }

    /**
     * Prepare OnClause query. <br>
     * {select ... from ... left outer join chara_image on ... and FOO = [value] ...}
     * <pre>
     * cb.query().queryMemberStatus().<span style="color: #CC4747">on()</span>.setFoo...;
     * </pre>
     * @return The condition-query for OnClause query. (NotNull)
     * @throws IllegalConditionBeanOperationException When this condition-query is base query.
     */
    public CharaImageCIQ on() {
        if (isBaseQuery()) { throw new IllegalConditionBeanOperationException("OnClause for local table is unavailable!"); }
        CharaImageCIQ inlineQuery = inline(); inlineQuery.xsetOnClause(true); return inlineQuery;
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====
    protected ConditionValue _charaId;
    public ConditionValue xdfgetCharaId()
    { if (_charaId == null) { _charaId = nCV(); }
      return _charaId; }
    protected ConditionValue xgetCValueCharaId() { return xdfgetCharaId(); }

    /**
     * Add order-by as ascend. <br>
     * CHARA_ID: {PK, NotNull, INT UNSIGNED(10), FK to chara}
     * @return this. (NotNull)
     */
    public BsCharaImageCQ addOrderBy_CharaId_Asc() { regOBA("CHARA_ID"); return this; }

    /**
     * Add order-by as descend. <br>
     * CHARA_ID: {PK, NotNull, INT UNSIGNED(10), FK to chara}
     * @return this. (NotNull)
     */
    public BsCharaImageCQ addOrderBy_CharaId_Desc() { regOBD("CHARA_ID"); return this; }

    protected ConditionValue _faceTypeCode;
    public ConditionValue xdfgetFaceTypeCode()
    { if (_faceTypeCode == null) { _faceTypeCode = nCV(); }
      return _faceTypeCode; }
    protected ConditionValue xgetCValueFaceTypeCode() { return xdfgetFaceTypeCode(); }

    /**
     * Add order-by as ascend. <br>
     * FACE_TYPE_CODE: {PK, IX, NotNull, VARCHAR(20), FK to face_type, classification=FaceType}
     * @return this. (NotNull)
     */
    public BsCharaImageCQ addOrderBy_FaceTypeCode_Asc() { regOBA("FACE_TYPE_CODE"); return this; }

    /**
     * Add order-by as descend. <br>
     * FACE_TYPE_CODE: {PK, IX, NotNull, VARCHAR(20), FK to face_type, classification=FaceType}
     * @return this. (NotNull)
     */
    public BsCharaImageCQ addOrderBy_FaceTypeCode_Desc() { regOBD("FACE_TYPE_CODE"); return this; }

    protected ConditionValue _charaImgUrl;
    public ConditionValue xdfgetCharaImgUrl()
    { if (_charaImgUrl == null) { _charaImgUrl = nCV(); }
      return _charaImgUrl; }
    protected ConditionValue xgetCValueCharaImgUrl() { return xdfgetCharaImgUrl(); }

    /**
     * Add order-by as ascend. <br>
     * CHARA_IMG_URL: {NotNull, VARCHAR(100)}
     * @return this. (NotNull)
     */
    public BsCharaImageCQ addOrderBy_CharaImgUrl_Asc() { regOBA("CHARA_IMG_URL"); return this; }

    /**
     * Add order-by as descend. <br>
     * CHARA_IMG_URL: {NotNull, VARCHAR(100)}
     * @return this. (NotNull)
     */
    public BsCharaImageCQ addOrderBy_CharaImgUrl_Desc() { regOBD("CHARA_IMG_URL"); return this; }

    // ===================================================================================
    //                                                             SpecifiedDerivedOrderBy
    //                                                             =======================
    /**
     * Add order-by for specified derived column as ascend.
     * <pre>
     * cb.specify().derivedPurchaseList().max(new SubQuery&lt;PurchaseCB&gt;() {
     *     public void query(PurchaseCB subCB) {
     *         subCB.specify().columnPurchaseDatetime();
     *     }
     * }, <span style="color: #CC4747">aliasName</span>);
     * <span style="color: #3F7E5E">// order by [alias-name] asc</span>
     * cb.<span style="color: #CC4747">addSpecifiedDerivedOrderBy_Asc</span>(<span style="color: #CC4747">aliasName</span>);
     * </pre>
     * @param aliasName The alias name specified at (Specify)DerivedReferrer. (NotNull)
     * @return this. (NotNull)
     */
    public BsCharaImageCQ addSpecifiedDerivedOrderBy_Asc(String aliasName) { registerSpecifiedDerivedOrderBy_Asc(aliasName); return this; }

    /**
     * Add order-by for specified derived column as descend.
     * <pre>
     * cb.specify().derivedPurchaseList().max(new SubQuery&lt;PurchaseCB&gt;() {
     *     public void query(PurchaseCB subCB) {
     *         subCB.specify().columnPurchaseDatetime();
     *     }
     * }, <span style="color: #CC4747">aliasName</span>);
     * <span style="color: #3F7E5E">// order by [alias-name] desc</span>
     * cb.<span style="color: #CC4747">addSpecifiedDerivedOrderBy_Desc</span>(<span style="color: #CC4747">aliasName</span>);
     * </pre>
     * @param aliasName The alias name specified at (Specify)DerivedReferrer. (NotNull)
     * @return this. (NotNull)
     */
    public BsCharaImageCQ addSpecifiedDerivedOrderBy_Desc(String aliasName) { registerSpecifiedDerivedOrderBy_Desc(aliasName); return this; }

    // ===================================================================================
    //                                                                         Union Query
    //                                                                         ===========
    public void reflectRelationOnUnionQuery(ConditionQuery bqs, ConditionQuery uqs) {
        CharaImageCQ bq = (CharaImageCQ)bqs;
        CharaImageCQ uq = (CharaImageCQ)uqs;
        if (bq.hasConditionQueryChara()) {
            uq.queryChara().reflectRelationOnUnionQuery(bq.queryChara(), uq.queryChara());
        }
        if (bq.hasConditionQueryFaceType()) {
            uq.queryFaceType().reflectRelationOnUnionQuery(bq.queryFaceType(), uq.queryFaceType());
        }
    }

    // ===================================================================================
    //                                                                       Foreign Query
    //                                                                       =============
    /**
     * Get the condition-query for relation table. <br>
     * CHARA by my CHARA_ID, named 'chara'.
     * @return The instance of condition-query. (NotNull)
     */
    public CharaCQ queryChara() {
        return xdfgetConditionQueryChara();
    }
    public CharaCQ xdfgetConditionQueryChara() {
        String prop = "chara";
        if (!xhasQueRlMap(prop)) { xregQueRl(prop, xcreateQueryChara()); xsetupOuterJoinChara(); }
        return xgetQueRlMap(prop);
    }
    protected CharaCQ xcreateQueryChara() {
        String nrp = xresolveNRP("chara_image", "chara"); String jan = xresolveJAN(nrp, xgetNNLvl());
        return xinitRelCQ(new CharaCQ(this, xgetSqlClause(), jan, xgetNNLvl()), _baseCB, "chara", nrp);
    }
    protected void xsetupOuterJoinChara() { xregOutJo("chara"); }
    public boolean hasConditionQueryChara() { return xhasQueRlMap("chara"); }

    /**
     * Get the condition-query for relation table. <br>
     * FACE_TYPE by my FACE_TYPE_CODE, named 'faceType'.
     * @return The instance of condition-query. (NotNull)
     */
    public FaceTypeCQ queryFaceType() {
        return xdfgetConditionQueryFaceType();
    }
    public FaceTypeCQ xdfgetConditionQueryFaceType() {
        String prop = "faceType";
        if (!xhasQueRlMap(prop)) { xregQueRl(prop, xcreateQueryFaceType()); xsetupOuterJoinFaceType(); }
        return xgetQueRlMap(prop);
    }
    protected FaceTypeCQ xcreateQueryFaceType() {
        String nrp = xresolveNRP("chara_image", "faceType"); String jan = xresolveJAN(nrp, xgetNNLvl());
        return xinitRelCQ(new FaceTypeCQ(this, xgetSqlClause(), jan, xgetNNLvl()), _baseCB, "faceType", nrp);
    }
    protected void xsetupOuterJoinFaceType() { xregOutJo("faceType"); }
    public boolean hasConditionQueryFaceType() { return xhasQueRlMap("faceType"); }

    protected Map<String, Object> xfindFixedConditionDynamicParameterMap(String property) {
        return null;
    }

    // ===================================================================================
    //                                                                     ScalarCondition
    //                                                                     ===============
    public Map<String, CharaImageCQ> xdfgetScalarCondition() { return xgetSQueMap("scalarCondition"); }
    public String keepScalarCondition(CharaImageCQ sq) { return xkeepSQue("scalarCondition", sq); }

    // ===================================================================================
    //                                                                       Very Internal
    //                                                                       =============
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xCB() { return CharaImageCB.class.getName(); }
    protected String xCQ() { return CharaImageCQ.class.getName(); }
    protected String xCHp() { return HpQDRFunction.class.getName(); }
    protected String xCOp() { return ConditionOption.class.getName(); }
    protected String xMap() { return Map.class.getName(); }
}
