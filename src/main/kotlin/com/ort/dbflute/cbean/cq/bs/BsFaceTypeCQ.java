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
 * The base condition-query of face_type.
 * @author DBFlute(AutoGenerator)
 */
public class BsFaceTypeCQ extends AbstractBsFaceTypeCQ {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected FaceTypeCIQ _inlineQuery;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public BsFaceTypeCQ(ConditionQuery referrerQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
        super(referrerQuery, sqlClause, aliasName, nestLevel);
    }

    // ===================================================================================
    //                                                                 InlineView/OrClause
    //                                                                 ===================
    /**
     * Prepare InlineView query. <br>
     * {select ... from ... left outer join (select * from face_type) where FOO = [value] ...}
     * <pre>
     * cb.query().queryMemberStatus().<span style="color: #CC4747">inline()</span>.setFoo...;
     * </pre>
     * @return The condition-query for InlineView query. (NotNull)
     */
    public FaceTypeCIQ inline() {
        if (_inlineQuery == null) { _inlineQuery = xcreateCIQ(); }
        _inlineQuery.xsetOnClause(false); return _inlineQuery;
    }

    protected FaceTypeCIQ xcreateCIQ() {
        FaceTypeCIQ ciq = xnewCIQ();
        ciq.xsetBaseCB(_baseCB);
        return ciq;
    }

    protected FaceTypeCIQ xnewCIQ() {
        return new FaceTypeCIQ(xgetReferrerQuery(), xgetSqlClause(), xgetAliasName(), xgetNestLevel(), this);
    }

    /**
     * Prepare OnClause query. <br>
     * {select ... from ... left outer join face_type on ... and FOO = [value] ...}
     * <pre>
     * cb.query().queryMemberStatus().<span style="color: #CC4747">on()</span>.setFoo...;
     * </pre>
     * @return The condition-query for OnClause query. (NotNull)
     * @throws IllegalConditionBeanOperationException When this condition-query is base query.
     */
    public FaceTypeCIQ on() {
        if (isBaseQuery()) { throw new IllegalConditionBeanOperationException("OnClause for local table is unavailable!"); }
        FaceTypeCIQ inlineQuery = inline(); inlineQuery.xsetOnClause(true); return inlineQuery;
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====
    protected ConditionValue _faceTypeCode;
    public ConditionValue xdfgetFaceTypeCode()
    { if (_faceTypeCode == null) { _faceTypeCode = nCV(); }
      return _faceTypeCode; }
    protected ConditionValue xgetCValueFaceTypeCode() { return xdfgetFaceTypeCode(); }

    public Map<String, CharaImageCQ> xdfgetFaceTypeCode_ExistsReferrer_CharaImageList() { return xgetSQueMap("faceTypeCode_ExistsReferrer_CharaImageList"); }
    public String keepFaceTypeCode_ExistsReferrer_CharaImageList(CharaImageCQ sq) { return xkeepSQue("faceTypeCode_ExistsReferrer_CharaImageList", sq); }

    public Map<String, CharaImageCQ> xdfgetFaceTypeCode_NotExistsReferrer_CharaImageList() { return xgetSQueMap("faceTypeCode_NotExistsReferrer_CharaImageList"); }
    public String keepFaceTypeCode_NotExistsReferrer_CharaImageList(CharaImageCQ sq) { return xkeepSQue("faceTypeCode_NotExistsReferrer_CharaImageList", sq); }

    public Map<String, CharaImageCQ> xdfgetFaceTypeCode_SpecifyDerivedReferrer_CharaImageList() { return xgetSQueMap("faceTypeCode_SpecifyDerivedReferrer_CharaImageList"); }
    public String keepFaceTypeCode_SpecifyDerivedReferrer_CharaImageList(CharaImageCQ sq) { return xkeepSQue("faceTypeCode_SpecifyDerivedReferrer_CharaImageList", sq); }

    public Map<String, CharaImageCQ> xdfgetFaceTypeCode_QueryDerivedReferrer_CharaImageList() { return xgetSQueMap("faceTypeCode_QueryDerivedReferrer_CharaImageList"); }
    public String keepFaceTypeCode_QueryDerivedReferrer_CharaImageList(CharaImageCQ sq) { return xkeepSQue("faceTypeCode_QueryDerivedReferrer_CharaImageList", sq); }
    public Map<String, Object> xdfgetFaceTypeCode_QueryDerivedReferrer_CharaImageListParameter() { return xgetSQuePmMap("faceTypeCode_QueryDerivedReferrer_CharaImageList"); }
    public String keepFaceTypeCode_QueryDerivedReferrer_CharaImageListParameter(Object pm) { return xkeepSQuePm("faceTypeCode_QueryDerivedReferrer_CharaImageList", pm); }

    /**
     * Add order-by as ascend. <br>
     * FACE_TYPE_CODE: {PK, NotNull, VARCHAR(20), classification=FaceType}
     * @return this. (NotNull)
     */
    public BsFaceTypeCQ addOrderBy_FaceTypeCode_Asc() { regOBA("FACE_TYPE_CODE"); return this; }

    /**
     * Add order-by as descend. <br>
     * FACE_TYPE_CODE: {PK, NotNull, VARCHAR(20), classification=FaceType}
     * @return this. (NotNull)
     */
    public BsFaceTypeCQ addOrderBy_FaceTypeCode_Desc() { regOBD("FACE_TYPE_CODE"); return this; }

    protected ConditionValue _faceTypeName;
    public ConditionValue xdfgetFaceTypeName()
    { if (_faceTypeName == null) { _faceTypeName = nCV(); }
      return _faceTypeName; }
    protected ConditionValue xgetCValueFaceTypeName() { return xdfgetFaceTypeName(); }

    /**
     * Add order-by as ascend. <br>
     * FACE_TYPE_NAME: {NotNull, VARCHAR(20)}
     * @return this. (NotNull)
     */
    public BsFaceTypeCQ addOrderBy_FaceTypeName_Asc() { regOBA("FACE_TYPE_NAME"); return this; }

    /**
     * Add order-by as descend. <br>
     * FACE_TYPE_NAME: {NotNull, VARCHAR(20)}
     * @return this. (NotNull)
     */
    public BsFaceTypeCQ addOrderBy_FaceTypeName_Desc() { regOBD("FACE_TYPE_NAME"); return this; }

    protected ConditionValue _dispOrder;
    public ConditionValue xdfgetDispOrder()
    { if (_dispOrder == null) { _dispOrder = nCV(); }
      return _dispOrder; }
    protected ConditionValue xgetCValueDispOrder() { return xdfgetDispOrder(); }

    /**
     * Add order-by as ascend. <br>
     * DISP_ORDER: {NotNull, INT UNSIGNED(10)}
     * @return this. (NotNull)
     */
    public BsFaceTypeCQ addOrderBy_DispOrder_Asc() { regOBA("DISP_ORDER"); return this; }

    /**
     * Add order-by as descend. <br>
     * DISP_ORDER: {NotNull, INT UNSIGNED(10)}
     * @return this. (NotNull)
     */
    public BsFaceTypeCQ addOrderBy_DispOrder_Desc() { regOBD("DISP_ORDER"); return this; }

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
    public BsFaceTypeCQ addSpecifiedDerivedOrderBy_Asc(String aliasName) { registerSpecifiedDerivedOrderBy_Asc(aliasName); return this; }

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
    public BsFaceTypeCQ addSpecifiedDerivedOrderBy_Desc(String aliasName) { registerSpecifiedDerivedOrderBy_Desc(aliasName); return this; }

    // ===================================================================================
    //                                                                         Union Query
    //                                                                         ===========
    public void reflectRelationOnUnionQuery(ConditionQuery bqs, ConditionQuery uqs) {
    }

    // ===================================================================================
    //                                                                       Foreign Query
    //                                                                       =============
    protected Map<String, Object> xfindFixedConditionDynamicParameterMap(String property) {
        return null;
    }

    // ===================================================================================
    //                                                                     ScalarCondition
    //                                                                     ===============
    public Map<String, FaceTypeCQ> xdfgetScalarCondition() { return xgetSQueMap("scalarCondition"); }
    public String keepScalarCondition(FaceTypeCQ sq) { return xkeepSQue("scalarCondition", sq); }

    // ===================================================================================
    //                                                                       MyselfDerived
    //                                                                       =============
    public Map<String, FaceTypeCQ> xdfgetSpecifyMyselfDerived() { return xgetSQueMap("specifyMyselfDerived"); }
    public String keepSpecifyMyselfDerived(FaceTypeCQ sq) { return xkeepSQue("specifyMyselfDerived", sq); }

    public Map<String, FaceTypeCQ> xdfgetQueryMyselfDerived() { return xgetSQueMap("queryMyselfDerived"); }
    public String keepQueryMyselfDerived(FaceTypeCQ sq) { return xkeepSQue("queryMyselfDerived", sq); }
    public Map<String, Object> xdfgetQueryMyselfDerivedParameter() { return xgetSQuePmMap("queryMyselfDerived"); }
    public String keepQueryMyselfDerivedParameter(Object pm) { return xkeepSQuePm("queryMyselfDerived", pm); }

    // ===================================================================================
    //                                                                        MyselfExists
    //                                                                        ============
    protected Map<String, FaceTypeCQ> _myselfExistsMap;
    public Map<String, FaceTypeCQ> xdfgetMyselfExists() { return xgetSQueMap("myselfExists"); }
    public String keepMyselfExists(FaceTypeCQ sq) { return xkeepSQue("myselfExists", sq); }

    // ===================================================================================
    //                                                                       MyselfInScope
    //                                                                       =============
    public Map<String, FaceTypeCQ> xdfgetMyselfInScope() { return xgetSQueMap("myselfInScope"); }
    public String keepMyselfInScope(FaceTypeCQ sq) { return xkeepSQue("myselfInScope", sq); }

    // ===================================================================================
    //                                                                       Very Internal
    //                                                                       =============
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xCB() { return FaceTypeCB.class.getName(); }
    protected String xCQ() { return FaceTypeCQ.class.getName(); }
    protected String xCHp() { return HpQDRFunction.class.getName(); }
    protected String xCOp() { return ConditionOption.class.getName(); }
    protected String xMap() { return Map.class.getName(); }
}
