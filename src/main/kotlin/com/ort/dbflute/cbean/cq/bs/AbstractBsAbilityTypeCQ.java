package com.ort.dbflute.cbean.cq.bs;

import java.util.*;

import org.dbflute.cbean.*;
import org.dbflute.cbean.chelper.*;
import org.dbflute.cbean.ckey.*;
import org.dbflute.cbean.coption.*;
import org.dbflute.cbean.cvalue.ConditionValue;
import org.dbflute.cbean.ordering.*;
import org.dbflute.cbean.scoping.*;
import org.dbflute.cbean.sqlclause.SqlClause;
import org.dbflute.dbmeta.DBMetaProvider;
import com.ort.dbflute.allcommon.*;
import com.ort.dbflute.cbean.*;
import com.ort.dbflute.cbean.cq.*;

/**
 * The abstract condition-query of ability_type.
 * @author DBFlute(AutoGenerator)
 */
public abstract class AbstractBsAbilityTypeCQ extends AbstractConditionQuery {

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public AbstractBsAbilityTypeCQ(ConditionQuery referrerQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
        super(referrerQuery, sqlClause, aliasName, nestLevel);
    }

    // ===================================================================================
    //                                                                             DB Meta
    //                                                                             =======
    @Override
    protected DBMetaProvider xgetDBMetaProvider() {
        return DBMetaInstanceHandler.getProvider();
    }

    public String asTableDbName() {
        return "ability_type";
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====
    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * ABILITY_TYPE_CODE: {PK, NotNull, VARCHAR(20), classification=AbilityType}
     * @param abilityTypeCode The value of abilityTypeCode as equal. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    protected void setAbilityTypeCode_Equal(String abilityTypeCode) {
        doSetAbilityTypeCode_Equal(fRES(abilityTypeCode));
    }

    /**
     * Equal(=). As AbilityType. And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * ABILITY_TYPE_CODE: {PK, NotNull, VARCHAR(20), classification=AbilityType} <br>
     * 能力種別
     * @param cdef The instance of classification definition (as ENUM type). (basically NotNull: error as default, or no condition as option)
     */
    public void setAbilityTypeCode_Equal_AsAbilityType(CDef.AbilityType cdef) {
        doSetAbilityTypeCode_Equal(cdef != null ? cdef.code() : null);
    }

    /**
     * Equal(=). As 襲撃 (ATTACK). And OnlyOnceRegistered. <br>
     * 襲撃
     */
    public void setAbilityTypeCode_Equal_襲撃() {
        setAbilityTypeCode_Equal_AsAbilityType(CDef.AbilityType.襲撃);
    }

    /**
     * Equal(=). As 占い (DIVINE). And OnlyOnceRegistered. <br>
     * 占い
     */
    public void setAbilityTypeCode_Equal_占い() {
        setAbilityTypeCode_Equal_AsAbilityType(CDef.AbilityType.占い);
    }

    /**
     * Equal(=). As 護衛 (GUARD). And OnlyOnceRegistered. <br>
     * 護衛
     */
    public void setAbilityTypeCode_Equal_護衛() {
        setAbilityTypeCode_Equal_AsAbilityType(CDef.AbilityType.護衛);
    }

    /**
     * Equal(=). As 捜査 (INVESTIGATE). And OnlyOnceRegistered. <br>
     * 捜査
     */
    public void setAbilityTypeCode_Equal_捜査() {
        setAbilityTypeCode_Equal_AsAbilityType(CDef.AbilityType.捜査);
    }

    protected void doSetAbilityTypeCode_Equal(String abilityTypeCode) {
        regAbilityTypeCode(CK_EQ, abilityTypeCode);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * ABILITY_TYPE_CODE: {PK, NotNull, VARCHAR(20), classification=AbilityType}
     * @param abilityTypeCode The value of abilityTypeCode as notEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    protected void setAbilityTypeCode_NotEqual(String abilityTypeCode) {
        doSetAbilityTypeCode_NotEqual(fRES(abilityTypeCode));
    }

    /**
     * NotEqual(&lt;&gt;). As AbilityType. And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * ABILITY_TYPE_CODE: {PK, NotNull, VARCHAR(20), classification=AbilityType} <br>
     * 能力種別
     * @param cdef The instance of classification definition (as ENUM type). (basically NotNull: error as default, or no condition as option)
     */
    public void setAbilityTypeCode_NotEqual_AsAbilityType(CDef.AbilityType cdef) {
        doSetAbilityTypeCode_NotEqual(cdef != null ? cdef.code() : null);
    }

    /**
     * NotEqual(&lt;&gt;). As 襲撃 (ATTACK). And OnlyOnceRegistered. <br>
     * 襲撃
     */
    public void setAbilityTypeCode_NotEqual_襲撃() {
        setAbilityTypeCode_NotEqual_AsAbilityType(CDef.AbilityType.襲撃);
    }

    /**
     * NotEqual(&lt;&gt;). As 占い (DIVINE). And OnlyOnceRegistered. <br>
     * 占い
     */
    public void setAbilityTypeCode_NotEqual_占い() {
        setAbilityTypeCode_NotEqual_AsAbilityType(CDef.AbilityType.占い);
    }

    /**
     * NotEqual(&lt;&gt;). As 護衛 (GUARD). And OnlyOnceRegistered. <br>
     * 護衛
     */
    public void setAbilityTypeCode_NotEqual_護衛() {
        setAbilityTypeCode_NotEqual_AsAbilityType(CDef.AbilityType.護衛);
    }

    /**
     * NotEqual(&lt;&gt;). As 捜査 (INVESTIGATE). And OnlyOnceRegistered. <br>
     * 捜査
     */
    public void setAbilityTypeCode_NotEqual_捜査() {
        setAbilityTypeCode_NotEqual_AsAbilityType(CDef.AbilityType.捜査);
    }

    protected void doSetAbilityTypeCode_NotEqual(String abilityTypeCode) {
        regAbilityTypeCode(CK_NES, abilityTypeCode);
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * ABILITY_TYPE_CODE: {PK, NotNull, VARCHAR(20), classification=AbilityType}
     * @param abilityTypeCodeList The collection of abilityTypeCode as inScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    protected void setAbilityTypeCode_InScope(Collection<String> abilityTypeCodeList) {
        doSetAbilityTypeCode_InScope(abilityTypeCodeList);
    }

    /**
     * InScope {in ('a', 'b')}. As AbilityType. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * ABILITY_TYPE_CODE: {PK, NotNull, VARCHAR(20), classification=AbilityType} <br>
     * 能力種別
     * @param cdefList The list of classification definition (as ENUM type). (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setAbilityTypeCode_InScope_AsAbilityType(Collection<CDef.AbilityType> cdefList) {
        doSetAbilityTypeCode_InScope(cTStrL(cdefList));
    }

    protected void doSetAbilityTypeCode_InScope(Collection<String> abilityTypeCodeList) {
        regINS(CK_INS, cTL(abilityTypeCodeList), xgetCValueAbilityTypeCode(), "ABILITY_TYPE_CODE");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * ABILITY_TYPE_CODE: {PK, NotNull, VARCHAR(20), classification=AbilityType}
     * @param abilityTypeCodeList The collection of abilityTypeCode as notInScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    protected void setAbilityTypeCode_NotInScope(Collection<String> abilityTypeCodeList) {
        doSetAbilityTypeCode_NotInScope(abilityTypeCodeList);
    }

    /**
     * NotInScope {not in ('a', 'b')}. As AbilityType. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * ABILITY_TYPE_CODE: {PK, NotNull, VARCHAR(20), classification=AbilityType} <br>
     * 能力種別
     * @param cdefList The list of classification definition (as ENUM type). (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setAbilityTypeCode_NotInScope_AsAbilityType(Collection<CDef.AbilityType> cdefList) {
        doSetAbilityTypeCode_NotInScope(cTStrL(cdefList));
    }

    protected void doSetAbilityTypeCode_NotInScope(Collection<String> abilityTypeCodeList) {
        regINS(CK_NINS, cTL(abilityTypeCodeList), xgetCValueAbilityTypeCode(), "ABILITY_TYPE_CODE");
    }

    /**
     * Set up ExistsReferrer (correlated sub-query). <br>
     * {exists (select ABILITY_TYPE_CODE from ability where ...)} <br>
     * ability by ABILITY_TYPE_CODE, named 'abilityAsOne'.
     * <pre>
     * cb.query().<span style="color: #CC4747">existsAbility</span>(abilityCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     abilityCB.query().set...
     * });
     * </pre>
     * @param subCBLambda The callback for sub-query of AbilityList for 'exists'. (NotNull)
     */
    public void existsAbility(SubQuery<AbilityCB> subCBLambda) {
        assertObjectNotNull("subCBLambda", subCBLambda);
        AbilityCB cb = new AbilityCB(); cb.xsetupForExistsReferrer(this);
        lockCall(() -> subCBLambda.query(cb)); String pp = keepAbilityTypeCode_ExistsReferrer_AbilityList(cb.query());
        registerExistsReferrer(cb.query(), "ABILITY_TYPE_CODE", "ABILITY_TYPE_CODE", pp, "abilityList");
    }
    public abstract String keepAbilityTypeCode_ExistsReferrer_AbilityList(AbilityCQ sq);

    /**
     * Set up NotExistsReferrer (correlated sub-query). <br>
     * {not exists (select ABILITY_TYPE_CODE from ability where ...)} <br>
     * ability by ABILITY_TYPE_CODE, named 'abilityAsOne'.
     * <pre>
     * cb.query().<span style="color: #CC4747">notExistsAbility</span>(abilityCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     abilityCB.query().set...
     * });
     * </pre>
     * @param subCBLambda The callback for sub-query of AbilityTypeCode_NotExistsReferrer_AbilityList for 'not exists'. (NotNull)
     */
    public void notExistsAbility(SubQuery<AbilityCB> subCBLambda) {
        assertObjectNotNull("subCBLambda", subCBLambda);
        AbilityCB cb = new AbilityCB(); cb.xsetupForExistsReferrer(this);
        lockCall(() -> subCBLambda.query(cb)); String pp = keepAbilityTypeCode_NotExistsReferrer_AbilityList(cb.query());
        registerNotExistsReferrer(cb.query(), "ABILITY_TYPE_CODE", "ABILITY_TYPE_CODE", pp, "abilityList");
    }
    public abstract String keepAbilityTypeCode_NotExistsReferrer_AbilityList(AbilityCQ sq);

    public void xsderiveAbilityList(String fn, SubQuery<AbilityCB> sq, String al, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        AbilityCB cb = new AbilityCB(); cb.xsetupForDerivedReferrer(this);
        lockCall(() -> sq.query(cb)); String pp = keepAbilityTypeCode_SpecifyDerivedReferrer_AbilityList(cb.query());
        registerSpecifyDerivedReferrer(fn, cb.query(), "ABILITY_TYPE_CODE", "ABILITY_TYPE_CODE", pp, "abilityList", al, op);
    }
    public abstract String keepAbilityTypeCode_SpecifyDerivedReferrer_AbilityList(AbilityCQ sq);

    /**
     * Prepare for (Query)DerivedReferrer (correlated sub-query). <br>
     * {FOO &lt;= (select max(BAR) from ability where ...)} <br>
     * ability by ABILITY_TYPE_CODE, named 'abilityAsOne'.
     * <pre>
     * cb.query().<span style="color: #CC4747">derivedAbility()</span>.<span style="color: #CC4747">max</span>(abilityCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     abilityCB.specify().<span style="color: #CC4747">columnFoo...</span> <span style="color: #3F7E5E">// derived column by function</span>
     *     abilityCB.query().setBar... <span style="color: #3F7E5E">// referrer condition</span>
     * }).<span style="color: #CC4747">greaterEqual</span>(123); <span style="color: #3F7E5E">// condition to derived column</span>
     * </pre>
     * @return The object to set up a function for referrer table. (NotNull)
     */
    public HpQDRFunction<AbilityCB> derivedAbility() {
        return xcreateQDRFunctionAbilityList();
    }
    protected HpQDRFunction<AbilityCB> xcreateQDRFunctionAbilityList() {
        return xcQDRFunc((fn, sq, rd, vl, op) -> xqderiveAbilityList(fn, sq, rd, vl, op));
    }
    public void xqderiveAbilityList(String fn, SubQuery<AbilityCB> sq, String rd, Object vl, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        AbilityCB cb = new AbilityCB(); cb.xsetupForDerivedReferrer(this);
        lockCall(() -> sq.query(cb)); String sqpp = keepAbilityTypeCode_QueryDerivedReferrer_AbilityList(cb.query()); String prpp = keepAbilityTypeCode_QueryDerivedReferrer_AbilityListParameter(vl);
        registerQueryDerivedReferrer(fn, cb.query(), "ABILITY_TYPE_CODE", "ABILITY_TYPE_CODE", sqpp, "abilityList", rd, vl, prpp, op);
    }
    public abstract String keepAbilityTypeCode_QueryDerivedReferrer_AbilityList(AbilityCQ sq);
    public abstract String keepAbilityTypeCode_QueryDerivedReferrer_AbilityListParameter(Object vl);

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br>
     * ABILITY_TYPE_CODE: {PK, NotNull, VARCHAR(20), classification=AbilityType}
     */
    public void setAbilityTypeCode_IsNull() { regAbilityTypeCode(CK_ISN, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br>
     * ABILITY_TYPE_CODE: {PK, NotNull, VARCHAR(20), classification=AbilityType}
     */
    public void setAbilityTypeCode_IsNotNull() { regAbilityTypeCode(CK_ISNN, DOBJ); }

    protected void regAbilityTypeCode(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueAbilityTypeCode(), "ABILITY_TYPE_CODE"); }
    protected abstract ConditionValue xgetCValueAbilityTypeCode();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * ABILITY_TYPE_NAME: {NotNull, VARCHAR(20)}
     * @param abilityTypeName The value of abilityTypeName as equal. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setAbilityTypeName_Equal(String abilityTypeName) {
        doSetAbilityTypeName_Equal(fRES(abilityTypeName));
    }

    protected void doSetAbilityTypeName_Equal(String abilityTypeName) {
        regAbilityTypeName(CK_EQ, abilityTypeName);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * ABILITY_TYPE_NAME: {NotNull, VARCHAR(20)}
     * @param abilityTypeName The value of abilityTypeName as notEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setAbilityTypeName_NotEqual(String abilityTypeName) {
        doSetAbilityTypeName_NotEqual(fRES(abilityTypeName));
    }

    protected void doSetAbilityTypeName_NotEqual(String abilityTypeName) {
        regAbilityTypeName(CK_NES, abilityTypeName);
    }

    /**
     * GreaterThan(&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * ABILITY_TYPE_NAME: {NotNull, VARCHAR(20)}
     * @param abilityTypeName The value of abilityTypeName as greaterThan. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setAbilityTypeName_GreaterThan(String abilityTypeName) {
        regAbilityTypeName(CK_GT, fRES(abilityTypeName));
    }

    /**
     * LessThan(&lt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * ABILITY_TYPE_NAME: {NotNull, VARCHAR(20)}
     * @param abilityTypeName The value of abilityTypeName as lessThan. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setAbilityTypeName_LessThan(String abilityTypeName) {
        regAbilityTypeName(CK_LT, fRES(abilityTypeName));
    }

    /**
     * GreaterEqual(&gt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * ABILITY_TYPE_NAME: {NotNull, VARCHAR(20)}
     * @param abilityTypeName The value of abilityTypeName as greaterEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setAbilityTypeName_GreaterEqual(String abilityTypeName) {
        regAbilityTypeName(CK_GE, fRES(abilityTypeName));
    }

    /**
     * LessEqual(&lt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * ABILITY_TYPE_NAME: {NotNull, VARCHAR(20)}
     * @param abilityTypeName The value of abilityTypeName as lessEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setAbilityTypeName_LessEqual(String abilityTypeName) {
        regAbilityTypeName(CK_LE, fRES(abilityTypeName));
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * ABILITY_TYPE_NAME: {NotNull, VARCHAR(20)}
     * @param abilityTypeNameList The collection of abilityTypeName as inScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setAbilityTypeName_InScope(Collection<String> abilityTypeNameList) {
        doSetAbilityTypeName_InScope(abilityTypeNameList);
    }

    protected void doSetAbilityTypeName_InScope(Collection<String> abilityTypeNameList) {
        regINS(CK_INS, cTL(abilityTypeNameList), xgetCValueAbilityTypeName(), "ABILITY_TYPE_NAME");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * ABILITY_TYPE_NAME: {NotNull, VARCHAR(20)}
     * @param abilityTypeNameList The collection of abilityTypeName as notInScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setAbilityTypeName_NotInScope(Collection<String> abilityTypeNameList) {
        doSetAbilityTypeName_NotInScope(abilityTypeNameList);
    }

    protected void doSetAbilityTypeName_NotInScope(Collection<String> abilityTypeNameList) {
        regINS(CK_NINS, cTL(abilityTypeNameList), xgetCValueAbilityTypeName(), "ABILITY_TYPE_NAME");
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * ABILITY_TYPE_NAME: {NotNull, VARCHAR(20)} <br>
     * <pre>e.g. setAbilityTypeName_LikeSearch("xxx", op <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> op.<span style="color: #CC4747">likeContain()</span>);</pre>
     * @param abilityTypeName The value of abilityTypeName as likeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setAbilityTypeName_LikeSearch(String abilityTypeName, ConditionOptionCall<LikeSearchOption> opLambda) {
        setAbilityTypeName_LikeSearch(abilityTypeName, xcLSOP(opLambda));
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * ABILITY_TYPE_NAME: {NotNull, VARCHAR(20)} <br>
     * <pre>e.g. setAbilityTypeName_LikeSearch("xxx", new <span style="color: #CC4747">LikeSearchOption</span>().likeContain());</pre>
     * @param abilityTypeName The value of abilityTypeName as likeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    protected void setAbilityTypeName_LikeSearch(String abilityTypeName, LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(abilityTypeName), xgetCValueAbilityTypeName(), "ABILITY_TYPE_NAME", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * ABILITY_TYPE_NAME: {NotNull, VARCHAR(20)}
     * @param abilityTypeName The value of abilityTypeName as notLikeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setAbilityTypeName_NotLikeSearch(String abilityTypeName, ConditionOptionCall<LikeSearchOption> opLambda) {
        setAbilityTypeName_NotLikeSearch(abilityTypeName, xcLSOP(opLambda));
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * ABILITY_TYPE_NAME: {NotNull, VARCHAR(20)}
     * @param abilityTypeName The value of abilityTypeName as notLikeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    protected void setAbilityTypeName_NotLikeSearch(String abilityTypeName, LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(abilityTypeName), xgetCValueAbilityTypeName(), "ABILITY_TYPE_NAME", likeSearchOption);
    }

    protected void regAbilityTypeName(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueAbilityTypeName(), "ABILITY_TYPE_NAME"); }
    protected abstract ConditionValue xgetCValueAbilityTypeName();

    // ===================================================================================
    //                                                                     ScalarCondition
    //                                                                     ===============
    /**
     * Prepare ScalarCondition as equal. <br>
     * {where FOO = (select max(BAR) from ...)}
     * <pre>
     * cb.query().scalar_Equal().<span style="color: #CC4747">avg</span>(<span style="color: #553000">purchaseCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">purchaseCB</span>.specify().<span style="color: #CC4747">columnPurchasePrice</span>(); <span style="color: #3F7E5E">// *Point!</span>
     *     <span style="color: #553000">purchaseCB</span>.query().setPaymentCompleteFlg_Equal_True();
     * });
     * </pre> 
     * @return The object to set up a function. (NotNull)
     */
    public HpSLCFunction<AbilityTypeCB> scalar_Equal() {
        return xcreateSLCFunction(CK_EQ, AbilityTypeCB.class);
    }

    /**
     * Prepare ScalarCondition as equal. <br>
     * {where FOO &lt;&gt; (select max(BAR) from ...)}
     * <pre>
     * cb.query().scalar_Equal().<span style="color: #CC4747">avg</span>(<span style="color: #553000">purchaseCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">purchaseCB</span>.specify().<span style="color: #CC4747">columnPurchasePrice</span>(); <span style="color: #3F7E5E">// *Point!</span>
     *     <span style="color: #553000">purchaseCB</span>.query().setPaymentCompleteFlg_Equal_True();
     * });
     * </pre> 
     * @return The object to set up a function. (NotNull)
     */
    public HpSLCFunction<AbilityTypeCB> scalar_NotEqual() {
        return xcreateSLCFunction(CK_NES, AbilityTypeCB.class);
    }

    /**
     * Prepare ScalarCondition as greaterThan. <br>
     * {where FOO &gt; (select max(BAR) from ...)}
     * <pre>
     * cb.query().scalar_Equal().<span style="color: #CC4747">avg</span>(<span style="color: #553000">purchaseCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">purchaseCB</span>.specify().<span style="color: #CC4747">columnPurchasePrice</span>(); <span style="color: #3F7E5E">// *Point!</span>
     *     <span style="color: #553000">purchaseCB</span>.query().setPaymentCompleteFlg_Equal_True();
     * });
     * </pre> 
     * @return The object to set up a function. (NotNull)
     */
    public HpSLCFunction<AbilityTypeCB> scalar_GreaterThan() {
        return xcreateSLCFunction(CK_GT, AbilityTypeCB.class);
    }

    /**
     * Prepare ScalarCondition as lessThan. <br>
     * {where FOO &lt; (select max(BAR) from ...)}
     * <pre>
     * cb.query().scalar_Equal().<span style="color: #CC4747">avg</span>(<span style="color: #553000">purchaseCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">purchaseCB</span>.specify().<span style="color: #CC4747">columnPurchasePrice</span>(); <span style="color: #3F7E5E">// *Point!</span>
     *     <span style="color: #553000">purchaseCB</span>.query().setPaymentCompleteFlg_Equal_True();
     * });
     * </pre> 
     * @return The object to set up a function. (NotNull)
     */
    public HpSLCFunction<AbilityTypeCB> scalar_LessThan() {
        return xcreateSLCFunction(CK_LT, AbilityTypeCB.class);
    }

    /**
     * Prepare ScalarCondition as greaterEqual. <br>
     * {where FOO &gt;= (select max(BAR) from ...)}
     * <pre>
     * cb.query().scalar_Equal().<span style="color: #CC4747">avg</span>(<span style="color: #553000">purchaseCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">purchaseCB</span>.specify().<span style="color: #CC4747">columnPurchasePrice</span>(); <span style="color: #3F7E5E">// *Point!</span>
     *     <span style="color: #553000">purchaseCB</span>.query().setPaymentCompleteFlg_Equal_True();
     * });
     * </pre> 
     * @return The object to set up a function. (NotNull)
     */
    public HpSLCFunction<AbilityTypeCB> scalar_GreaterEqual() {
        return xcreateSLCFunction(CK_GE, AbilityTypeCB.class);
    }

    /**
     * Prepare ScalarCondition as lessEqual. <br>
     * {where FOO &lt;= (select max(BAR) from ...)}
     * <pre>
     * cb.query().<span style="color: #CC4747">scalar_LessEqual()</span>.max(new SubQuery&lt;AbilityTypeCB&gt;() {
     *     public void query(AbilityTypeCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSLCFunction<AbilityTypeCB> scalar_LessEqual() {
        return xcreateSLCFunction(CK_LE, AbilityTypeCB.class);
    }

    @SuppressWarnings("unchecked")
    protected <CB extends ConditionBean> void xscalarCondition(String fn, SubQuery<CB> sq, String rd, HpSLCCustomized<CB> cs, ScalarConditionOption op) {
        assertObjectNotNull("subQuery", sq);
        AbilityTypeCB cb = xcreateScalarConditionCB(); sq.query((CB)cb);
        String pp = keepScalarCondition(cb.query()); // for saving query-value
        cs.setPartitionByCBean((CB)xcreateScalarConditionPartitionByCB()); // for using partition-by
        registerScalarCondition(fn, cb.query(), pp, rd, cs, op);
    }
    public abstract String keepScalarCondition(AbilityTypeCQ sq);

    protected AbilityTypeCB xcreateScalarConditionCB() {
        AbilityTypeCB cb = newMyCB(); cb.xsetupForScalarCondition(this); return cb;
    }

    protected AbilityTypeCB xcreateScalarConditionPartitionByCB() {
        AbilityTypeCB cb = newMyCB(); cb.xsetupForScalarConditionPartitionBy(this); return cb;
    }

    // ===================================================================================
    //                                                                       MyselfDerived
    //                                                                       =============
    public void xsmyselfDerive(String fn, SubQuery<AbilityTypeCB> sq, String al, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        AbilityTypeCB cb = new AbilityTypeCB(); cb.xsetupForDerivedReferrer(this);
        lockCall(() -> sq.query(cb)); String pp = keepSpecifyMyselfDerived(cb.query()); String pk = "ABILITY_TYPE_CODE";
        registerSpecifyMyselfDerived(fn, cb.query(), pk, pk, pp, "myselfDerived", al, op);
    }
    public abstract String keepSpecifyMyselfDerived(AbilityTypeCQ sq);

    /**
     * Prepare for (Query)MyselfDerived (correlated sub-query).
     * @return The object to set up a function for myself table. (NotNull)
     */
    public HpQDRFunction<AbilityTypeCB> myselfDerived() {
        return xcreateQDRFunctionMyselfDerived(AbilityTypeCB.class);
    }
    @SuppressWarnings("unchecked")
    protected <CB extends ConditionBean> void xqderiveMyselfDerived(String fn, SubQuery<CB> sq, String rd, Object vl, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        AbilityTypeCB cb = new AbilityTypeCB(); cb.xsetupForDerivedReferrer(this); sq.query((CB)cb);
        String pk = "ABILITY_TYPE_CODE";
        String sqpp = keepQueryMyselfDerived(cb.query()); // for saving query-value.
        String prpp = keepQueryMyselfDerivedParameter(vl);
        registerQueryMyselfDerived(fn, cb.query(), pk, pk, sqpp, "myselfDerived", rd, vl, prpp, op);
    }
    public abstract String keepQueryMyselfDerived(AbilityTypeCQ sq);
    public abstract String keepQueryMyselfDerivedParameter(Object vl);

    // ===================================================================================
    //                                                                        MyselfExists
    //                                                                        ============
    /**
     * Prepare for MyselfExists (correlated sub-query).
     * @param subCBLambda The implementation of sub-query. (NotNull)
     */
    public void myselfExists(SubQuery<AbilityTypeCB> subCBLambda) {
        assertObjectNotNull("subCBLambda", subCBLambda);
        AbilityTypeCB cb = new AbilityTypeCB(); cb.xsetupForMyselfExists(this);
        lockCall(() -> subCBLambda.query(cb)); String pp = keepMyselfExists(cb.query());
        registerMyselfExists(cb.query(), pp);
    }
    public abstract String keepMyselfExists(AbilityTypeCQ sq);

    // ===================================================================================
    //                                                                        Manual Order
    //                                                                        ============
    /**
     * Order along manual ordering information.
     * <pre>
     * cb.query().addOrderBy_Birthdate_Asc().<span style="color: #CC4747">withManualOrder</span>(<span style="color: #553000">op</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">op</span>.<span style="color: #CC4747">when_GreaterEqual</span>(priorityDate); <span style="color: #3F7E5E">// e.g. 2000/01/01</span>
     * });
     * <span style="color: #3F7E5E">// order by </span>
     * <span style="color: #3F7E5E">//   case</span>
     * <span style="color: #3F7E5E">//     when BIRTHDATE &gt;= '2000/01/01' then 0</span>
     * <span style="color: #3F7E5E">//     else 1</span>
     * <span style="color: #3F7E5E">//   end asc, ...</span>
     *
     * cb.query().addOrderBy_MemberStatusCode_Asc().<span style="color: #CC4747">withManualOrder</span>(<span style="color: #553000">op</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">op</span>.<span style="color: #CC4747">when_GreaterEqual</span>(priorityDate); <span style="color: #3F7E5E">// e.g. 2000/01/01</span>
     *     <span style="color: #553000">op</span>.<span style="color: #CC4747">when_Equal</span>(CDef.MemberStatus.Withdrawal);
     *     <span style="color: #553000">op</span>.<span style="color: #CC4747">when_Equal</span>(CDef.MemberStatus.Formalized);
     *     <span style="color: #553000">op</span>.<span style="color: #CC4747">when_Equal</span>(CDef.MemberStatus.Provisional);
     * });
     * <span style="color: #3F7E5E">// order by </span>
     * <span style="color: #3F7E5E">//   case</span>
     * <span style="color: #3F7E5E">//     when MEMBER_STATUS_CODE = 'WDL' then 0</span>
     * <span style="color: #3F7E5E">//     when MEMBER_STATUS_CODE = 'FML' then 1</span>
     * <span style="color: #3F7E5E">//     when MEMBER_STATUS_CODE = 'PRV' then 2</span>
     * <span style="color: #3F7E5E">//     else 3</span>
     * <span style="color: #3F7E5E">//   end asc, ...</span>
     * </pre>
     * <p>This function with Union is unsupported!</p>
     * <p>The order values are bound (treated as bind parameter).</p>
     * @param opLambda The callback for option of manual-order containing order values. (NotNull)
     */
    public void withManualOrder(ManualOrderOptionCall opLambda) { // is user public!
        xdoWithManualOrder(cMOO(opLambda));
    }

    // ===================================================================================
    //                                                                    Small Adjustment
    //                                                                    ================
    // ===================================================================================
    //                                                                       Very Internal
    //                                                                       =============
    protected AbilityTypeCB newMyCB() {
        return new AbilityTypeCB();
    }
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xabUDT() { return Date.class.getName(); }
    protected String xabCQ() { return AbilityTypeCQ.class.getName(); }
    protected String xabLSO() { return LikeSearchOption.class.getName(); }
    protected String xabSLCS() { return HpSLCSetupper.class.getName(); }
    protected String xabSCP() { return SubQuery.class.getName(); }
}
