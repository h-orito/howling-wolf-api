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
 * The abstract condition-query of village_status.
 * @author DBFlute(AutoGenerator)
 */
public abstract class AbstractBsVillageStatusCQ extends AbstractConditionQuery {

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public AbstractBsVillageStatusCQ(ConditionQuery referrerQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
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
        return "village_status";
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====
    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * VILLAGE_STATUS_CODE: {PK, NotNull, VARCHAR(20), classification=VillageStatus}
     * @param villageStatusCode The value of villageStatusCode as equal. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    protected void setVillageStatusCode_Equal(String villageStatusCode) {
        doSetVillageStatusCode_Equal(fRES(villageStatusCode));
    }

    /**
     * Equal(=). As VillageStatus. And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * VILLAGE_STATUS_CODE: {PK, NotNull, VARCHAR(20), classification=VillageStatus} <br>
     * 村ステータス
     * @param cdef The instance of classification definition (as ENUM type). (basically NotNull: error as default, or no condition as option)
     */
    public void setVillageStatusCode_Equal_AsVillageStatus(CDef.VillageStatus cdef) {
        doSetVillageStatusCode_Equal(cdef != null ? cdef.code() : null);
    }

    /**
     * Equal(=). As 廃村 (CANCEL). And OnlyOnceRegistered. <br>
     * 廃村
     */
    public void setVillageStatusCode_Equal_廃村() {
        setVillageStatusCode_Equal_AsVillageStatus(CDef.VillageStatus.廃村);
    }

    /**
     * Equal(=). As 終了 (COMPLETED). And OnlyOnceRegistered. <br>
     * 終了
     */
    public void setVillageStatusCode_Equal_終了() {
        setVillageStatusCode_Equal_AsVillageStatus(CDef.VillageStatus.終了);
    }

    /**
     * Equal(=). As エピローグ (EPILOGUE). And OnlyOnceRegistered. <br>
     * エピローグ
     */
    public void setVillageStatusCode_Equal_エピローグ() {
        setVillageStatusCode_Equal_AsVillageStatus(CDef.VillageStatus.エピローグ);
    }

    /**
     * Equal(=). As 募集中 (IN_PREPARATION). And OnlyOnceRegistered. <br>
     * 募集中
     */
    public void setVillageStatusCode_Equal_募集中() {
        setVillageStatusCode_Equal_AsVillageStatus(CDef.VillageStatus.募集中);
    }

    /**
     * Equal(=). As 進行中 (IN_PROGRESS). And OnlyOnceRegistered. <br>
     * 進行中
     */
    public void setVillageStatusCode_Equal_進行中() {
        setVillageStatusCode_Equal_AsVillageStatus(CDef.VillageStatus.進行中);
    }

    /**
     * Equal(=). As 開始待ち (WAITING). And OnlyOnceRegistered. <br>
     * 開始待ち
     */
    public void setVillageStatusCode_Equal_開始待ち() {
        setVillageStatusCode_Equal_AsVillageStatus(CDef.VillageStatus.開始待ち);
    }

    protected void doSetVillageStatusCode_Equal(String villageStatusCode) {
        regVillageStatusCode(CK_EQ, villageStatusCode);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * VILLAGE_STATUS_CODE: {PK, NotNull, VARCHAR(20), classification=VillageStatus}
     * @param villageStatusCode The value of villageStatusCode as notEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    protected void setVillageStatusCode_NotEqual(String villageStatusCode) {
        doSetVillageStatusCode_NotEqual(fRES(villageStatusCode));
    }

    /**
     * NotEqual(&lt;&gt;). As VillageStatus. And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * VILLAGE_STATUS_CODE: {PK, NotNull, VARCHAR(20), classification=VillageStatus} <br>
     * 村ステータス
     * @param cdef The instance of classification definition (as ENUM type). (basically NotNull: error as default, or no condition as option)
     */
    public void setVillageStatusCode_NotEqual_AsVillageStatus(CDef.VillageStatus cdef) {
        doSetVillageStatusCode_NotEqual(cdef != null ? cdef.code() : null);
    }

    /**
     * NotEqual(&lt;&gt;). As 廃村 (CANCEL). And OnlyOnceRegistered. <br>
     * 廃村
     */
    public void setVillageStatusCode_NotEqual_廃村() {
        setVillageStatusCode_NotEqual_AsVillageStatus(CDef.VillageStatus.廃村);
    }

    /**
     * NotEqual(&lt;&gt;). As 終了 (COMPLETED). And OnlyOnceRegistered. <br>
     * 終了
     */
    public void setVillageStatusCode_NotEqual_終了() {
        setVillageStatusCode_NotEqual_AsVillageStatus(CDef.VillageStatus.終了);
    }

    /**
     * NotEqual(&lt;&gt;). As エピローグ (EPILOGUE). And OnlyOnceRegistered. <br>
     * エピローグ
     */
    public void setVillageStatusCode_NotEqual_エピローグ() {
        setVillageStatusCode_NotEqual_AsVillageStatus(CDef.VillageStatus.エピローグ);
    }

    /**
     * NotEqual(&lt;&gt;). As 募集中 (IN_PREPARATION). And OnlyOnceRegistered. <br>
     * 募集中
     */
    public void setVillageStatusCode_NotEqual_募集中() {
        setVillageStatusCode_NotEqual_AsVillageStatus(CDef.VillageStatus.募集中);
    }

    /**
     * NotEqual(&lt;&gt;). As 進行中 (IN_PROGRESS). And OnlyOnceRegistered. <br>
     * 進行中
     */
    public void setVillageStatusCode_NotEqual_進行中() {
        setVillageStatusCode_NotEqual_AsVillageStatus(CDef.VillageStatus.進行中);
    }

    /**
     * NotEqual(&lt;&gt;). As 開始待ち (WAITING). And OnlyOnceRegistered. <br>
     * 開始待ち
     */
    public void setVillageStatusCode_NotEqual_開始待ち() {
        setVillageStatusCode_NotEqual_AsVillageStatus(CDef.VillageStatus.開始待ち);
    }

    protected void doSetVillageStatusCode_NotEqual(String villageStatusCode) {
        regVillageStatusCode(CK_NES, villageStatusCode);
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * VILLAGE_STATUS_CODE: {PK, NotNull, VARCHAR(20), classification=VillageStatus}
     * @param villageStatusCodeList The collection of villageStatusCode as inScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    protected void setVillageStatusCode_InScope(Collection<String> villageStatusCodeList) {
        doSetVillageStatusCode_InScope(villageStatusCodeList);
    }

    /**
     * InScope {in ('a', 'b')}. As VillageStatus. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * VILLAGE_STATUS_CODE: {PK, NotNull, VARCHAR(20), classification=VillageStatus} <br>
     * 村ステータス
     * @param cdefList The list of classification definition (as ENUM type). (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setVillageStatusCode_InScope_AsVillageStatus(Collection<CDef.VillageStatus> cdefList) {
        doSetVillageStatusCode_InScope(cTStrL(cdefList));
    }

    protected void doSetVillageStatusCode_InScope(Collection<String> villageStatusCodeList) {
        regINS(CK_INS, cTL(villageStatusCodeList), xgetCValueVillageStatusCode(), "VILLAGE_STATUS_CODE");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * VILLAGE_STATUS_CODE: {PK, NotNull, VARCHAR(20), classification=VillageStatus}
     * @param villageStatusCodeList The collection of villageStatusCode as notInScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    protected void setVillageStatusCode_NotInScope(Collection<String> villageStatusCodeList) {
        doSetVillageStatusCode_NotInScope(villageStatusCodeList);
    }

    /**
     * NotInScope {not in ('a', 'b')}. As VillageStatus. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * VILLAGE_STATUS_CODE: {PK, NotNull, VARCHAR(20), classification=VillageStatus} <br>
     * 村ステータス
     * @param cdefList The list of classification definition (as ENUM type). (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setVillageStatusCode_NotInScope_AsVillageStatus(Collection<CDef.VillageStatus> cdefList) {
        doSetVillageStatusCode_NotInScope(cTStrL(cdefList));
    }

    protected void doSetVillageStatusCode_NotInScope(Collection<String> villageStatusCodeList) {
        regINS(CK_NINS, cTL(villageStatusCodeList), xgetCValueVillageStatusCode(), "VILLAGE_STATUS_CODE");
    }

    /**
     * Set up ExistsReferrer (correlated sub-query). <br>
     * {exists (select VILLAGE_STATUS_CODE from village where ...)} <br>
     * village by VILLAGE_STATUS_CODE, named 'villageAsOne'.
     * <pre>
     * cb.query().<span style="color: #CC4747">existsVillage</span>(villageCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     villageCB.query().set...
     * });
     * </pre>
     * @param subCBLambda The callback for sub-query of VillageList for 'exists'. (NotNull)
     */
    public void existsVillage(SubQuery<VillageCB> subCBLambda) {
        assertObjectNotNull("subCBLambda", subCBLambda);
        VillageCB cb = new VillageCB(); cb.xsetupForExistsReferrer(this);
        lockCall(() -> subCBLambda.query(cb)); String pp = keepVillageStatusCode_ExistsReferrer_VillageList(cb.query());
        registerExistsReferrer(cb.query(), "VILLAGE_STATUS_CODE", "VILLAGE_STATUS_CODE", pp, "villageList");
    }
    public abstract String keepVillageStatusCode_ExistsReferrer_VillageList(VillageCQ sq);

    /**
     * Set up NotExistsReferrer (correlated sub-query). <br>
     * {not exists (select VILLAGE_STATUS_CODE from village where ...)} <br>
     * village by VILLAGE_STATUS_CODE, named 'villageAsOne'.
     * <pre>
     * cb.query().<span style="color: #CC4747">notExistsVillage</span>(villageCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     villageCB.query().set...
     * });
     * </pre>
     * @param subCBLambda The callback for sub-query of VillageStatusCode_NotExistsReferrer_VillageList for 'not exists'. (NotNull)
     */
    public void notExistsVillage(SubQuery<VillageCB> subCBLambda) {
        assertObjectNotNull("subCBLambda", subCBLambda);
        VillageCB cb = new VillageCB(); cb.xsetupForExistsReferrer(this);
        lockCall(() -> subCBLambda.query(cb)); String pp = keepVillageStatusCode_NotExistsReferrer_VillageList(cb.query());
        registerNotExistsReferrer(cb.query(), "VILLAGE_STATUS_CODE", "VILLAGE_STATUS_CODE", pp, "villageList");
    }
    public abstract String keepVillageStatusCode_NotExistsReferrer_VillageList(VillageCQ sq);

    public void xsderiveVillageList(String fn, SubQuery<VillageCB> sq, String al, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        VillageCB cb = new VillageCB(); cb.xsetupForDerivedReferrer(this);
        lockCall(() -> sq.query(cb)); String pp = keepVillageStatusCode_SpecifyDerivedReferrer_VillageList(cb.query());
        registerSpecifyDerivedReferrer(fn, cb.query(), "VILLAGE_STATUS_CODE", "VILLAGE_STATUS_CODE", pp, "villageList", al, op);
    }
    public abstract String keepVillageStatusCode_SpecifyDerivedReferrer_VillageList(VillageCQ sq);

    /**
     * Prepare for (Query)DerivedReferrer (correlated sub-query). <br>
     * {FOO &lt;= (select max(BAR) from village where ...)} <br>
     * village by VILLAGE_STATUS_CODE, named 'villageAsOne'.
     * <pre>
     * cb.query().<span style="color: #CC4747">derivedVillage()</span>.<span style="color: #CC4747">max</span>(villageCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     villageCB.specify().<span style="color: #CC4747">columnFoo...</span> <span style="color: #3F7E5E">// derived column by function</span>
     *     villageCB.query().setBar... <span style="color: #3F7E5E">// referrer condition</span>
     * }).<span style="color: #CC4747">greaterEqual</span>(123); <span style="color: #3F7E5E">// condition to derived column</span>
     * </pre>
     * @return The object to set up a function for referrer table. (NotNull)
     */
    public HpQDRFunction<VillageCB> derivedVillage() {
        return xcreateQDRFunctionVillageList();
    }
    protected HpQDRFunction<VillageCB> xcreateQDRFunctionVillageList() {
        return xcQDRFunc((fn, sq, rd, vl, op) -> xqderiveVillageList(fn, sq, rd, vl, op));
    }
    public void xqderiveVillageList(String fn, SubQuery<VillageCB> sq, String rd, Object vl, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        VillageCB cb = new VillageCB(); cb.xsetupForDerivedReferrer(this);
        lockCall(() -> sq.query(cb)); String sqpp = keepVillageStatusCode_QueryDerivedReferrer_VillageList(cb.query()); String prpp = keepVillageStatusCode_QueryDerivedReferrer_VillageListParameter(vl);
        registerQueryDerivedReferrer(fn, cb.query(), "VILLAGE_STATUS_CODE", "VILLAGE_STATUS_CODE", sqpp, "villageList", rd, vl, prpp, op);
    }
    public abstract String keepVillageStatusCode_QueryDerivedReferrer_VillageList(VillageCQ sq);
    public abstract String keepVillageStatusCode_QueryDerivedReferrer_VillageListParameter(Object vl);

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br>
     * VILLAGE_STATUS_CODE: {PK, NotNull, VARCHAR(20), classification=VillageStatus}
     */
    public void setVillageStatusCode_IsNull() { regVillageStatusCode(CK_ISN, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br>
     * VILLAGE_STATUS_CODE: {PK, NotNull, VARCHAR(20), classification=VillageStatus}
     */
    public void setVillageStatusCode_IsNotNull() { regVillageStatusCode(CK_ISNN, DOBJ); }

    protected void regVillageStatusCode(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueVillageStatusCode(), "VILLAGE_STATUS_CODE"); }
    protected abstract ConditionValue xgetCValueVillageStatusCode();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * VILLAGE_STATUS_NAME: {NotNull, VARCHAR(20)}
     * @param villageStatusName The value of villageStatusName as equal. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setVillageStatusName_Equal(String villageStatusName) {
        doSetVillageStatusName_Equal(fRES(villageStatusName));
    }

    protected void doSetVillageStatusName_Equal(String villageStatusName) {
        regVillageStatusName(CK_EQ, villageStatusName);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * VILLAGE_STATUS_NAME: {NotNull, VARCHAR(20)}
     * @param villageStatusName The value of villageStatusName as notEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setVillageStatusName_NotEqual(String villageStatusName) {
        doSetVillageStatusName_NotEqual(fRES(villageStatusName));
    }

    protected void doSetVillageStatusName_NotEqual(String villageStatusName) {
        regVillageStatusName(CK_NES, villageStatusName);
    }

    /**
     * GreaterThan(&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * VILLAGE_STATUS_NAME: {NotNull, VARCHAR(20)}
     * @param villageStatusName The value of villageStatusName as greaterThan. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setVillageStatusName_GreaterThan(String villageStatusName) {
        regVillageStatusName(CK_GT, fRES(villageStatusName));
    }

    /**
     * LessThan(&lt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * VILLAGE_STATUS_NAME: {NotNull, VARCHAR(20)}
     * @param villageStatusName The value of villageStatusName as lessThan. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setVillageStatusName_LessThan(String villageStatusName) {
        regVillageStatusName(CK_LT, fRES(villageStatusName));
    }

    /**
     * GreaterEqual(&gt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * VILLAGE_STATUS_NAME: {NotNull, VARCHAR(20)}
     * @param villageStatusName The value of villageStatusName as greaterEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setVillageStatusName_GreaterEqual(String villageStatusName) {
        regVillageStatusName(CK_GE, fRES(villageStatusName));
    }

    /**
     * LessEqual(&lt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * VILLAGE_STATUS_NAME: {NotNull, VARCHAR(20)}
     * @param villageStatusName The value of villageStatusName as lessEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setVillageStatusName_LessEqual(String villageStatusName) {
        regVillageStatusName(CK_LE, fRES(villageStatusName));
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * VILLAGE_STATUS_NAME: {NotNull, VARCHAR(20)}
     * @param villageStatusNameList The collection of villageStatusName as inScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setVillageStatusName_InScope(Collection<String> villageStatusNameList) {
        doSetVillageStatusName_InScope(villageStatusNameList);
    }

    protected void doSetVillageStatusName_InScope(Collection<String> villageStatusNameList) {
        regINS(CK_INS, cTL(villageStatusNameList), xgetCValueVillageStatusName(), "VILLAGE_STATUS_NAME");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * VILLAGE_STATUS_NAME: {NotNull, VARCHAR(20)}
     * @param villageStatusNameList The collection of villageStatusName as notInScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setVillageStatusName_NotInScope(Collection<String> villageStatusNameList) {
        doSetVillageStatusName_NotInScope(villageStatusNameList);
    }

    protected void doSetVillageStatusName_NotInScope(Collection<String> villageStatusNameList) {
        regINS(CK_NINS, cTL(villageStatusNameList), xgetCValueVillageStatusName(), "VILLAGE_STATUS_NAME");
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * VILLAGE_STATUS_NAME: {NotNull, VARCHAR(20)} <br>
     * <pre>e.g. setVillageStatusName_LikeSearch("xxx", op <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> op.<span style="color: #CC4747">likeContain()</span>);</pre>
     * @param villageStatusName The value of villageStatusName as likeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setVillageStatusName_LikeSearch(String villageStatusName, ConditionOptionCall<LikeSearchOption> opLambda) {
        setVillageStatusName_LikeSearch(villageStatusName, xcLSOP(opLambda));
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * VILLAGE_STATUS_NAME: {NotNull, VARCHAR(20)} <br>
     * <pre>e.g. setVillageStatusName_LikeSearch("xxx", new <span style="color: #CC4747">LikeSearchOption</span>().likeContain());</pre>
     * @param villageStatusName The value of villageStatusName as likeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    protected void setVillageStatusName_LikeSearch(String villageStatusName, LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(villageStatusName), xgetCValueVillageStatusName(), "VILLAGE_STATUS_NAME", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * VILLAGE_STATUS_NAME: {NotNull, VARCHAR(20)}
     * @param villageStatusName The value of villageStatusName as notLikeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setVillageStatusName_NotLikeSearch(String villageStatusName, ConditionOptionCall<LikeSearchOption> opLambda) {
        setVillageStatusName_NotLikeSearch(villageStatusName, xcLSOP(opLambda));
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * VILLAGE_STATUS_NAME: {NotNull, VARCHAR(20)}
     * @param villageStatusName The value of villageStatusName as notLikeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    protected void setVillageStatusName_NotLikeSearch(String villageStatusName, LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(villageStatusName), xgetCValueVillageStatusName(), "VILLAGE_STATUS_NAME", likeSearchOption);
    }

    protected void regVillageStatusName(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueVillageStatusName(), "VILLAGE_STATUS_NAME"); }
    protected abstract ConditionValue xgetCValueVillageStatusName();

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
    public HpSLCFunction<VillageStatusCB> scalar_Equal() {
        return xcreateSLCFunction(CK_EQ, VillageStatusCB.class);
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
    public HpSLCFunction<VillageStatusCB> scalar_NotEqual() {
        return xcreateSLCFunction(CK_NES, VillageStatusCB.class);
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
    public HpSLCFunction<VillageStatusCB> scalar_GreaterThan() {
        return xcreateSLCFunction(CK_GT, VillageStatusCB.class);
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
    public HpSLCFunction<VillageStatusCB> scalar_LessThan() {
        return xcreateSLCFunction(CK_LT, VillageStatusCB.class);
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
    public HpSLCFunction<VillageStatusCB> scalar_GreaterEqual() {
        return xcreateSLCFunction(CK_GE, VillageStatusCB.class);
    }

    /**
     * Prepare ScalarCondition as lessEqual. <br>
     * {where FOO &lt;= (select max(BAR) from ...)}
     * <pre>
     * cb.query().<span style="color: #CC4747">scalar_LessEqual()</span>.max(new SubQuery&lt;VillageStatusCB&gt;() {
     *     public void query(VillageStatusCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSLCFunction<VillageStatusCB> scalar_LessEqual() {
        return xcreateSLCFunction(CK_LE, VillageStatusCB.class);
    }

    @SuppressWarnings("unchecked")
    protected <CB extends ConditionBean> void xscalarCondition(String fn, SubQuery<CB> sq, String rd, HpSLCCustomized<CB> cs, ScalarConditionOption op) {
        assertObjectNotNull("subQuery", sq);
        VillageStatusCB cb = xcreateScalarConditionCB(); sq.query((CB)cb);
        String pp = keepScalarCondition(cb.query()); // for saving query-value
        cs.setPartitionByCBean((CB)xcreateScalarConditionPartitionByCB()); // for using partition-by
        registerScalarCondition(fn, cb.query(), pp, rd, cs, op);
    }
    public abstract String keepScalarCondition(VillageStatusCQ sq);

    protected VillageStatusCB xcreateScalarConditionCB() {
        VillageStatusCB cb = newMyCB(); cb.xsetupForScalarCondition(this); return cb;
    }

    protected VillageStatusCB xcreateScalarConditionPartitionByCB() {
        VillageStatusCB cb = newMyCB(); cb.xsetupForScalarConditionPartitionBy(this); return cb;
    }

    // ===================================================================================
    //                                                                       MyselfDerived
    //                                                                       =============
    public void xsmyselfDerive(String fn, SubQuery<VillageStatusCB> sq, String al, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        VillageStatusCB cb = new VillageStatusCB(); cb.xsetupForDerivedReferrer(this);
        lockCall(() -> sq.query(cb)); String pp = keepSpecifyMyselfDerived(cb.query()); String pk = "VILLAGE_STATUS_CODE";
        registerSpecifyMyselfDerived(fn, cb.query(), pk, pk, pp, "myselfDerived", al, op);
    }
    public abstract String keepSpecifyMyselfDerived(VillageStatusCQ sq);

    /**
     * Prepare for (Query)MyselfDerived (correlated sub-query).
     * @return The object to set up a function for myself table. (NotNull)
     */
    public HpQDRFunction<VillageStatusCB> myselfDerived() {
        return xcreateQDRFunctionMyselfDerived(VillageStatusCB.class);
    }
    @SuppressWarnings("unchecked")
    protected <CB extends ConditionBean> void xqderiveMyselfDerived(String fn, SubQuery<CB> sq, String rd, Object vl, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        VillageStatusCB cb = new VillageStatusCB(); cb.xsetupForDerivedReferrer(this); sq.query((CB)cb);
        String pk = "VILLAGE_STATUS_CODE";
        String sqpp = keepQueryMyselfDerived(cb.query()); // for saving query-value.
        String prpp = keepQueryMyselfDerivedParameter(vl);
        registerQueryMyselfDerived(fn, cb.query(), pk, pk, sqpp, "myselfDerived", rd, vl, prpp, op);
    }
    public abstract String keepQueryMyselfDerived(VillageStatusCQ sq);
    public abstract String keepQueryMyselfDerivedParameter(Object vl);

    // ===================================================================================
    //                                                                        MyselfExists
    //                                                                        ============
    /**
     * Prepare for MyselfExists (correlated sub-query).
     * @param subCBLambda The implementation of sub-query. (NotNull)
     */
    public void myselfExists(SubQuery<VillageStatusCB> subCBLambda) {
        assertObjectNotNull("subCBLambda", subCBLambda);
        VillageStatusCB cb = new VillageStatusCB(); cb.xsetupForMyselfExists(this);
        lockCall(() -> subCBLambda.query(cb)); String pp = keepMyselfExists(cb.query());
        registerMyselfExists(cb.query(), pp);
    }
    public abstract String keepMyselfExists(VillageStatusCQ sq);

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
    protected VillageStatusCB newMyCB() {
        return new VillageStatusCB();
    }
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xabUDT() { return Date.class.getName(); }
    protected String xabCQ() { return VillageStatusCQ.class.getName(); }
    protected String xabLSO() { return LikeSearchOption.class.getName(); }
    protected String xabSLCS() { return HpSLCSetupper.class.getName(); }
    protected String xabSCP() { return SubQuery.class.getName(); }
}
