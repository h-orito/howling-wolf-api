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
 * The abstract condition-query of dead_reason.
 * @author DBFlute(AutoGenerator)
 */
public abstract class AbstractBsDeadReasonCQ extends AbstractConditionQuery {

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public AbstractBsDeadReasonCQ(ConditionQuery referrerQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
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
        return "dead_reason";
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====
    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * DEAD_REASON_CODE: {PK, NotNull, VARCHAR(20), classification=DeadReason}
     * @param deadReasonCode The value of deadReasonCode as equal. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    protected void setDeadReasonCode_Equal(String deadReasonCode) {
        doSetDeadReasonCode_Equal(fRES(deadReasonCode));
    }

    /**
     * Equal(=). As DeadReason. And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * DEAD_REASON_CODE: {PK, NotNull, VARCHAR(20), classification=DeadReason} <br>
     * 死亡理由
     * @param cdef The instance of classification definition (as ENUM type). (basically NotNull: error as default, or no condition as option)
     */
    public void setDeadReasonCode_Equal_AsDeadReason(CDef.DeadReason cdef) {
        doSetDeadReasonCode_Equal(cdef != null ? cdef.code() : null);
    }

    /**
     * Equal(=). As 襲撃 (ATTACK). And OnlyOnceRegistered. <br>
     * 襲撃
     */
    public void setDeadReasonCode_Equal_襲撃() {
        setDeadReasonCode_Equal_AsDeadReason(CDef.DeadReason.襲撃);
    }

    /**
     * Equal(=). As 呪殺 (DIVINED). And OnlyOnceRegistered. <br>
     * 呪殺
     */
    public void setDeadReasonCode_Equal_呪殺() {
        setDeadReasonCode_Equal_AsDeadReason(CDef.DeadReason.呪殺);
    }

    /**
     * Equal(=). As 処刑 (EXECUTE). And OnlyOnceRegistered. <br>
     * 処刑
     */
    public void setDeadReasonCode_Equal_処刑() {
        setDeadReasonCode_Equal_AsDeadReason(CDef.DeadReason.処刑);
    }

    /**
     * Equal(=). As 突然 (SUDDON). And OnlyOnceRegistered. <br>
     * 突然
     */
    public void setDeadReasonCode_Equal_突然() {
        setDeadReasonCode_Equal_AsDeadReason(CDef.DeadReason.突然);
    }

    protected void doSetDeadReasonCode_Equal(String deadReasonCode) {
        regDeadReasonCode(CK_EQ, deadReasonCode);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * DEAD_REASON_CODE: {PK, NotNull, VARCHAR(20), classification=DeadReason}
     * @param deadReasonCode The value of deadReasonCode as notEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    protected void setDeadReasonCode_NotEqual(String deadReasonCode) {
        doSetDeadReasonCode_NotEqual(fRES(deadReasonCode));
    }

    /**
     * NotEqual(&lt;&gt;). As DeadReason. And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * DEAD_REASON_CODE: {PK, NotNull, VARCHAR(20), classification=DeadReason} <br>
     * 死亡理由
     * @param cdef The instance of classification definition (as ENUM type). (basically NotNull: error as default, or no condition as option)
     */
    public void setDeadReasonCode_NotEqual_AsDeadReason(CDef.DeadReason cdef) {
        doSetDeadReasonCode_NotEqual(cdef != null ? cdef.code() : null);
    }

    /**
     * NotEqual(&lt;&gt;). As 襲撃 (ATTACK). And OnlyOnceRegistered. <br>
     * 襲撃
     */
    public void setDeadReasonCode_NotEqual_襲撃() {
        setDeadReasonCode_NotEqual_AsDeadReason(CDef.DeadReason.襲撃);
    }

    /**
     * NotEqual(&lt;&gt;). As 呪殺 (DIVINED). And OnlyOnceRegistered. <br>
     * 呪殺
     */
    public void setDeadReasonCode_NotEqual_呪殺() {
        setDeadReasonCode_NotEqual_AsDeadReason(CDef.DeadReason.呪殺);
    }

    /**
     * NotEqual(&lt;&gt;). As 処刑 (EXECUTE). And OnlyOnceRegistered. <br>
     * 処刑
     */
    public void setDeadReasonCode_NotEqual_処刑() {
        setDeadReasonCode_NotEqual_AsDeadReason(CDef.DeadReason.処刑);
    }

    /**
     * NotEqual(&lt;&gt;). As 突然 (SUDDON). And OnlyOnceRegistered. <br>
     * 突然
     */
    public void setDeadReasonCode_NotEqual_突然() {
        setDeadReasonCode_NotEqual_AsDeadReason(CDef.DeadReason.突然);
    }

    protected void doSetDeadReasonCode_NotEqual(String deadReasonCode) {
        regDeadReasonCode(CK_NES, deadReasonCode);
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * DEAD_REASON_CODE: {PK, NotNull, VARCHAR(20), classification=DeadReason}
     * @param deadReasonCodeList The collection of deadReasonCode as inScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    protected void setDeadReasonCode_InScope(Collection<String> deadReasonCodeList) {
        doSetDeadReasonCode_InScope(deadReasonCodeList);
    }

    /**
     * InScope {in ('a', 'b')}. As DeadReason. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * DEAD_REASON_CODE: {PK, NotNull, VARCHAR(20), classification=DeadReason} <br>
     * 死亡理由
     * @param cdefList The list of classification definition (as ENUM type). (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setDeadReasonCode_InScope_AsDeadReason(Collection<CDef.DeadReason> cdefList) {
        doSetDeadReasonCode_InScope(cTStrL(cdefList));
    }

    protected void doSetDeadReasonCode_InScope(Collection<String> deadReasonCodeList) {
        regINS(CK_INS, cTL(deadReasonCodeList), xgetCValueDeadReasonCode(), "DEAD_REASON_CODE");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * DEAD_REASON_CODE: {PK, NotNull, VARCHAR(20), classification=DeadReason}
     * @param deadReasonCodeList The collection of deadReasonCode as notInScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    protected void setDeadReasonCode_NotInScope(Collection<String> deadReasonCodeList) {
        doSetDeadReasonCode_NotInScope(deadReasonCodeList);
    }

    /**
     * NotInScope {not in ('a', 'b')}. As DeadReason. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * DEAD_REASON_CODE: {PK, NotNull, VARCHAR(20), classification=DeadReason} <br>
     * 死亡理由
     * @param cdefList The list of classification definition (as ENUM type). (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setDeadReasonCode_NotInScope_AsDeadReason(Collection<CDef.DeadReason> cdefList) {
        doSetDeadReasonCode_NotInScope(cTStrL(cdefList));
    }

    protected void doSetDeadReasonCode_NotInScope(Collection<String> deadReasonCodeList) {
        regINS(CK_NINS, cTL(deadReasonCodeList), xgetCValueDeadReasonCode(), "DEAD_REASON_CODE");
    }

    /**
     * Set up ExistsReferrer (correlated sub-query). <br>
     * {exists (select DEAD_REASON_CODE from village_player where ...)} <br>
     * village_player by DEAD_REASON_CODE, named 'villagePlayerAsOne'.
     * <pre>
     * cb.query().<span style="color: #CC4747">existsVillagePlayer</span>(playerCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     playerCB.query().set...
     * });
     * </pre>
     * @param subCBLambda The callback for sub-query of VillagePlayerList for 'exists'. (NotNull)
     */
    public void existsVillagePlayer(SubQuery<VillagePlayerCB> subCBLambda) {
        assertObjectNotNull("subCBLambda", subCBLambda);
        VillagePlayerCB cb = new VillagePlayerCB(); cb.xsetupForExistsReferrer(this);
        lockCall(() -> subCBLambda.query(cb)); String pp = keepDeadReasonCode_ExistsReferrer_VillagePlayerList(cb.query());
        registerExistsReferrer(cb.query(), "DEAD_REASON_CODE", "DEAD_REASON_CODE", pp, "villagePlayerList");
    }
    public abstract String keepDeadReasonCode_ExistsReferrer_VillagePlayerList(VillagePlayerCQ sq);

    /**
     * Set up NotExistsReferrer (correlated sub-query). <br>
     * {not exists (select DEAD_REASON_CODE from village_player where ...)} <br>
     * village_player by DEAD_REASON_CODE, named 'villagePlayerAsOne'.
     * <pre>
     * cb.query().<span style="color: #CC4747">notExistsVillagePlayer</span>(playerCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     playerCB.query().set...
     * });
     * </pre>
     * @param subCBLambda The callback for sub-query of DeadReasonCode_NotExistsReferrer_VillagePlayerList for 'not exists'. (NotNull)
     */
    public void notExistsVillagePlayer(SubQuery<VillagePlayerCB> subCBLambda) {
        assertObjectNotNull("subCBLambda", subCBLambda);
        VillagePlayerCB cb = new VillagePlayerCB(); cb.xsetupForExistsReferrer(this);
        lockCall(() -> subCBLambda.query(cb)); String pp = keepDeadReasonCode_NotExistsReferrer_VillagePlayerList(cb.query());
        registerNotExistsReferrer(cb.query(), "DEAD_REASON_CODE", "DEAD_REASON_CODE", pp, "villagePlayerList");
    }
    public abstract String keepDeadReasonCode_NotExistsReferrer_VillagePlayerList(VillagePlayerCQ sq);

    public void xsderiveVillagePlayerList(String fn, SubQuery<VillagePlayerCB> sq, String al, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        VillagePlayerCB cb = new VillagePlayerCB(); cb.xsetupForDerivedReferrer(this);
        lockCall(() -> sq.query(cb)); String pp = keepDeadReasonCode_SpecifyDerivedReferrer_VillagePlayerList(cb.query());
        registerSpecifyDerivedReferrer(fn, cb.query(), "DEAD_REASON_CODE", "DEAD_REASON_CODE", pp, "villagePlayerList", al, op);
    }
    public abstract String keepDeadReasonCode_SpecifyDerivedReferrer_VillagePlayerList(VillagePlayerCQ sq);

    /**
     * Prepare for (Query)DerivedReferrer (correlated sub-query). <br>
     * {FOO &lt;= (select max(BAR) from village_player where ...)} <br>
     * village_player by DEAD_REASON_CODE, named 'villagePlayerAsOne'.
     * <pre>
     * cb.query().<span style="color: #CC4747">derivedVillagePlayer()</span>.<span style="color: #CC4747">max</span>(playerCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     playerCB.specify().<span style="color: #CC4747">columnFoo...</span> <span style="color: #3F7E5E">// derived column by function</span>
     *     playerCB.query().setBar... <span style="color: #3F7E5E">// referrer condition</span>
     * }).<span style="color: #CC4747">greaterEqual</span>(123); <span style="color: #3F7E5E">// condition to derived column</span>
     * </pre>
     * @return The object to set up a function for referrer table. (NotNull)
     */
    public HpQDRFunction<VillagePlayerCB> derivedVillagePlayer() {
        return xcreateQDRFunctionVillagePlayerList();
    }
    protected HpQDRFunction<VillagePlayerCB> xcreateQDRFunctionVillagePlayerList() {
        return xcQDRFunc((fn, sq, rd, vl, op) -> xqderiveVillagePlayerList(fn, sq, rd, vl, op));
    }
    public void xqderiveVillagePlayerList(String fn, SubQuery<VillagePlayerCB> sq, String rd, Object vl, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        VillagePlayerCB cb = new VillagePlayerCB(); cb.xsetupForDerivedReferrer(this);
        lockCall(() -> sq.query(cb)); String sqpp = keepDeadReasonCode_QueryDerivedReferrer_VillagePlayerList(cb.query()); String prpp = keepDeadReasonCode_QueryDerivedReferrer_VillagePlayerListParameter(vl);
        registerQueryDerivedReferrer(fn, cb.query(), "DEAD_REASON_CODE", "DEAD_REASON_CODE", sqpp, "villagePlayerList", rd, vl, prpp, op);
    }
    public abstract String keepDeadReasonCode_QueryDerivedReferrer_VillagePlayerList(VillagePlayerCQ sq);
    public abstract String keepDeadReasonCode_QueryDerivedReferrer_VillagePlayerListParameter(Object vl);

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br>
     * DEAD_REASON_CODE: {PK, NotNull, VARCHAR(20), classification=DeadReason}
     */
    public void setDeadReasonCode_IsNull() { regDeadReasonCode(CK_ISN, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br>
     * DEAD_REASON_CODE: {PK, NotNull, VARCHAR(20), classification=DeadReason}
     */
    public void setDeadReasonCode_IsNotNull() { regDeadReasonCode(CK_ISNN, DOBJ); }

    protected void regDeadReasonCode(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueDeadReasonCode(), "DEAD_REASON_CODE"); }
    protected abstract ConditionValue xgetCValueDeadReasonCode();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * DEAD_REASON_NAME: {NotNull, VARCHAR(20)}
     * @param deadReasonName The value of deadReasonName as equal. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setDeadReasonName_Equal(String deadReasonName) {
        doSetDeadReasonName_Equal(fRES(deadReasonName));
    }

    protected void doSetDeadReasonName_Equal(String deadReasonName) {
        regDeadReasonName(CK_EQ, deadReasonName);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * DEAD_REASON_NAME: {NotNull, VARCHAR(20)}
     * @param deadReasonName The value of deadReasonName as notEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setDeadReasonName_NotEqual(String deadReasonName) {
        doSetDeadReasonName_NotEqual(fRES(deadReasonName));
    }

    protected void doSetDeadReasonName_NotEqual(String deadReasonName) {
        regDeadReasonName(CK_NES, deadReasonName);
    }

    /**
     * GreaterThan(&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * DEAD_REASON_NAME: {NotNull, VARCHAR(20)}
     * @param deadReasonName The value of deadReasonName as greaterThan. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setDeadReasonName_GreaterThan(String deadReasonName) {
        regDeadReasonName(CK_GT, fRES(deadReasonName));
    }

    /**
     * LessThan(&lt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * DEAD_REASON_NAME: {NotNull, VARCHAR(20)}
     * @param deadReasonName The value of deadReasonName as lessThan. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setDeadReasonName_LessThan(String deadReasonName) {
        regDeadReasonName(CK_LT, fRES(deadReasonName));
    }

    /**
     * GreaterEqual(&gt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * DEAD_REASON_NAME: {NotNull, VARCHAR(20)}
     * @param deadReasonName The value of deadReasonName as greaterEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setDeadReasonName_GreaterEqual(String deadReasonName) {
        regDeadReasonName(CK_GE, fRES(deadReasonName));
    }

    /**
     * LessEqual(&lt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * DEAD_REASON_NAME: {NotNull, VARCHAR(20)}
     * @param deadReasonName The value of deadReasonName as lessEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setDeadReasonName_LessEqual(String deadReasonName) {
        regDeadReasonName(CK_LE, fRES(deadReasonName));
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * DEAD_REASON_NAME: {NotNull, VARCHAR(20)}
     * @param deadReasonNameList The collection of deadReasonName as inScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setDeadReasonName_InScope(Collection<String> deadReasonNameList) {
        doSetDeadReasonName_InScope(deadReasonNameList);
    }

    protected void doSetDeadReasonName_InScope(Collection<String> deadReasonNameList) {
        regINS(CK_INS, cTL(deadReasonNameList), xgetCValueDeadReasonName(), "DEAD_REASON_NAME");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * DEAD_REASON_NAME: {NotNull, VARCHAR(20)}
     * @param deadReasonNameList The collection of deadReasonName as notInScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setDeadReasonName_NotInScope(Collection<String> deadReasonNameList) {
        doSetDeadReasonName_NotInScope(deadReasonNameList);
    }

    protected void doSetDeadReasonName_NotInScope(Collection<String> deadReasonNameList) {
        regINS(CK_NINS, cTL(deadReasonNameList), xgetCValueDeadReasonName(), "DEAD_REASON_NAME");
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * DEAD_REASON_NAME: {NotNull, VARCHAR(20)} <br>
     * <pre>e.g. setDeadReasonName_LikeSearch("xxx", op <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> op.<span style="color: #CC4747">likeContain()</span>);</pre>
     * @param deadReasonName The value of deadReasonName as likeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setDeadReasonName_LikeSearch(String deadReasonName, ConditionOptionCall<LikeSearchOption> opLambda) {
        setDeadReasonName_LikeSearch(deadReasonName, xcLSOP(opLambda));
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * DEAD_REASON_NAME: {NotNull, VARCHAR(20)} <br>
     * <pre>e.g. setDeadReasonName_LikeSearch("xxx", new <span style="color: #CC4747">LikeSearchOption</span>().likeContain());</pre>
     * @param deadReasonName The value of deadReasonName as likeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    protected void setDeadReasonName_LikeSearch(String deadReasonName, LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(deadReasonName), xgetCValueDeadReasonName(), "DEAD_REASON_NAME", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * DEAD_REASON_NAME: {NotNull, VARCHAR(20)}
     * @param deadReasonName The value of deadReasonName as notLikeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setDeadReasonName_NotLikeSearch(String deadReasonName, ConditionOptionCall<LikeSearchOption> opLambda) {
        setDeadReasonName_NotLikeSearch(deadReasonName, xcLSOP(opLambda));
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * DEAD_REASON_NAME: {NotNull, VARCHAR(20)}
     * @param deadReasonName The value of deadReasonName as notLikeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    protected void setDeadReasonName_NotLikeSearch(String deadReasonName, LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(deadReasonName), xgetCValueDeadReasonName(), "DEAD_REASON_NAME", likeSearchOption);
    }

    protected void regDeadReasonName(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueDeadReasonName(), "DEAD_REASON_NAME"); }
    protected abstract ConditionValue xgetCValueDeadReasonName();

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
    public HpSLCFunction<DeadReasonCB> scalar_Equal() {
        return xcreateSLCFunction(CK_EQ, DeadReasonCB.class);
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
    public HpSLCFunction<DeadReasonCB> scalar_NotEqual() {
        return xcreateSLCFunction(CK_NES, DeadReasonCB.class);
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
    public HpSLCFunction<DeadReasonCB> scalar_GreaterThan() {
        return xcreateSLCFunction(CK_GT, DeadReasonCB.class);
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
    public HpSLCFunction<DeadReasonCB> scalar_LessThan() {
        return xcreateSLCFunction(CK_LT, DeadReasonCB.class);
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
    public HpSLCFunction<DeadReasonCB> scalar_GreaterEqual() {
        return xcreateSLCFunction(CK_GE, DeadReasonCB.class);
    }

    /**
     * Prepare ScalarCondition as lessEqual. <br>
     * {where FOO &lt;= (select max(BAR) from ...)}
     * <pre>
     * cb.query().<span style="color: #CC4747">scalar_LessEqual()</span>.max(new SubQuery&lt;DeadReasonCB&gt;() {
     *     public void query(DeadReasonCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSLCFunction<DeadReasonCB> scalar_LessEqual() {
        return xcreateSLCFunction(CK_LE, DeadReasonCB.class);
    }

    @SuppressWarnings("unchecked")
    protected <CB extends ConditionBean> void xscalarCondition(String fn, SubQuery<CB> sq, String rd, HpSLCCustomized<CB> cs, ScalarConditionOption op) {
        assertObjectNotNull("subQuery", sq);
        DeadReasonCB cb = xcreateScalarConditionCB(); sq.query((CB)cb);
        String pp = keepScalarCondition(cb.query()); // for saving query-value
        cs.setPartitionByCBean((CB)xcreateScalarConditionPartitionByCB()); // for using partition-by
        registerScalarCondition(fn, cb.query(), pp, rd, cs, op);
    }
    public abstract String keepScalarCondition(DeadReasonCQ sq);

    protected DeadReasonCB xcreateScalarConditionCB() {
        DeadReasonCB cb = newMyCB(); cb.xsetupForScalarCondition(this); return cb;
    }

    protected DeadReasonCB xcreateScalarConditionPartitionByCB() {
        DeadReasonCB cb = newMyCB(); cb.xsetupForScalarConditionPartitionBy(this); return cb;
    }

    // ===================================================================================
    //                                                                       MyselfDerived
    //                                                                       =============
    public void xsmyselfDerive(String fn, SubQuery<DeadReasonCB> sq, String al, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        DeadReasonCB cb = new DeadReasonCB(); cb.xsetupForDerivedReferrer(this);
        lockCall(() -> sq.query(cb)); String pp = keepSpecifyMyselfDerived(cb.query()); String pk = "DEAD_REASON_CODE";
        registerSpecifyMyselfDerived(fn, cb.query(), pk, pk, pp, "myselfDerived", al, op);
    }
    public abstract String keepSpecifyMyselfDerived(DeadReasonCQ sq);

    /**
     * Prepare for (Query)MyselfDerived (correlated sub-query).
     * @return The object to set up a function for myself table. (NotNull)
     */
    public HpQDRFunction<DeadReasonCB> myselfDerived() {
        return xcreateQDRFunctionMyselfDerived(DeadReasonCB.class);
    }
    @SuppressWarnings("unchecked")
    protected <CB extends ConditionBean> void xqderiveMyselfDerived(String fn, SubQuery<CB> sq, String rd, Object vl, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        DeadReasonCB cb = new DeadReasonCB(); cb.xsetupForDerivedReferrer(this); sq.query((CB)cb);
        String pk = "DEAD_REASON_CODE";
        String sqpp = keepQueryMyselfDerived(cb.query()); // for saving query-value.
        String prpp = keepQueryMyselfDerivedParameter(vl);
        registerQueryMyselfDerived(fn, cb.query(), pk, pk, sqpp, "myselfDerived", rd, vl, prpp, op);
    }
    public abstract String keepQueryMyselfDerived(DeadReasonCQ sq);
    public abstract String keepQueryMyselfDerivedParameter(Object vl);

    // ===================================================================================
    //                                                                        MyselfExists
    //                                                                        ============
    /**
     * Prepare for MyselfExists (correlated sub-query).
     * @param subCBLambda The implementation of sub-query. (NotNull)
     */
    public void myselfExists(SubQuery<DeadReasonCB> subCBLambda) {
        assertObjectNotNull("subCBLambda", subCBLambda);
        DeadReasonCB cb = new DeadReasonCB(); cb.xsetupForMyselfExists(this);
        lockCall(() -> subCBLambda.query(cb)); String pp = keepMyselfExists(cb.query());
        registerMyselfExists(cb.query(), pp);
    }
    public abstract String keepMyselfExists(DeadReasonCQ sq);

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
    protected DeadReasonCB newMyCB() {
        return new DeadReasonCB();
    }
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xabUDT() { return Date.class.getName(); }
    protected String xabCQ() { return DeadReasonCQ.class.getName(); }
    protected String xabLSO() { return LikeSearchOption.class.getName(); }
    protected String xabSLCS() { return HpSLCSetupper.class.getName(); }
    protected String xabSCP() { return SubQuery.class.getName(); }
}
