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
 * The abstract condition-query of NOONNIGHT.
 * @author DBFlute(AutoGenerator)
 */
public abstract class AbstractBsNoonnightCQ extends AbstractConditionQuery {

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public AbstractBsNoonnightCQ(ConditionQuery referrerQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
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
        return "NOONNIGHT";
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====
    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * NOONNIGHT_CODE: {PK, NotNull, VARCHAR(20), classification=Noonnight}
     * @param noonnightCode The value of noonnightCode as equal. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    protected void setNoonnightCode_Equal(String noonnightCode) {
        doSetNoonnightCode_Equal(fRES(noonnightCode));
    }

    /**
     * Equal(=). As Noonnight. And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * NOONNIGHT_CODE: {PK, NotNull, VARCHAR(20), classification=Noonnight} <br>
     * 昼夜
     * @param cdef The instance of classification definition (as ENUM type). (basically NotNull: error as default, or no condition as option)
     */
    public void setNoonnightCode_Equal_AsNoonnight(CDef.Noonnight cdef) {
        doSetNoonnightCode_Equal(cdef != null ? cdef.code() : null);
    }

    /**
     * Equal(=). As 夜 (NIGHT). And OnlyOnceRegistered. <br>
     * 夜
     */
    public void setNoonnightCode_Equal_夜() {
        setNoonnightCode_Equal_AsNoonnight(CDef.Noonnight.夜);
    }

    /**
     * Equal(=). As 昼 (NOON). And OnlyOnceRegistered. <br>
     * 昼
     */
    public void setNoonnightCode_Equal_昼() {
        setNoonnightCode_Equal_AsNoonnight(CDef.Noonnight.昼);
    }

    protected void doSetNoonnightCode_Equal(String noonnightCode) {
        regNoonnightCode(CK_EQ, noonnightCode);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * NOONNIGHT_CODE: {PK, NotNull, VARCHAR(20), classification=Noonnight}
     * @param noonnightCode The value of noonnightCode as notEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    protected void setNoonnightCode_NotEqual(String noonnightCode) {
        doSetNoonnightCode_NotEqual(fRES(noonnightCode));
    }

    /**
     * NotEqual(&lt;&gt;). As Noonnight. And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * NOONNIGHT_CODE: {PK, NotNull, VARCHAR(20), classification=Noonnight} <br>
     * 昼夜
     * @param cdef The instance of classification definition (as ENUM type). (basically NotNull: error as default, or no condition as option)
     */
    public void setNoonnightCode_NotEqual_AsNoonnight(CDef.Noonnight cdef) {
        doSetNoonnightCode_NotEqual(cdef != null ? cdef.code() : null);
    }

    /**
     * NotEqual(&lt;&gt;). As 夜 (NIGHT). And OnlyOnceRegistered. <br>
     * 夜
     */
    public void setNoonnightCode_NotEqual_夜() {
        setNoonnightCode_NotEqual_AsNoonnight(CDef.Noonnight.夜);
    }

    /**
     * NotEqual(&lt;&gt;). As 昼 (NOON). And OnlyOnceRegistered. <br>
     * 昼
     */
    public void setNoonnightCode_NotEqual_昼() {
        setNoonnightCode_NotEqual_AsNoonnight(CDef.Noonnight.昼);
    }

    protected void doSetNoonnightCode_NotEqual(String noonnightCode) {
        regNoonnightCode(CK_NES, noonnightCode);
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * NOONNIGHT_CODE: {PK, NotNull, VARCHAR(20), classification=Noonnight}
     * @param noonnightCodeList The collection of noonnightCode as inScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    protected void setNoonnightCode_InScope(Collection<String> noonnightCodeList) {
        doSetNoonnightCode_InScope(noonnightCodeList);
    }

    /**
     * InScope {in ('a', 'b')}. As Noonnight. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * NOONNIGHT_CODE: {PK, NotNull, VARCHAR(20), classification=Noonnight} <br>
     * 昼夜
     * @param cdefList The list of classification definition (as ENUM type). (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setNoonnightCode_InScope_AsNoonnight(Collection<CDef.Noonnight> cdefList) {
        doSetNoonnightCode_InScope(cTStrL(cdefList));
    }

    protected void doSetNoonnightCode_InScope(Collection<String> noonnightCodeList) {
        regINS(CK_INS, cTL(noonnightCodeList), xgetCValueNoonnightCode(), "NOONNIGHT_CODE");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * NOONNIGHT_CODE: {PK, NotNull, VARCHAR(20), classification=Noonnight}
     * @param noonnightCodeList The collection of noonnightCode as notInScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    protected void setNoonnightCode_NotInScope(Collection<String> noonnightCodeList) {
        doSetNoonnightCode_NotInScope(noonnightCodeList);
    }

    /**
     * NotInScope {not in ('a', 'b')}. As Noonnight. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * NOONNIGHT_CODE: {PK, NotNull, VARCHAR(20), classification=Noonnight} <br>
     * 昼夜
     * @param cdefList The list of classification definition (as ENUM type). (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setNoonnightCode_NotInScope_AsNoonnight(Collection<CDef.Noonnight> cdefList) {
        doSetNoonnightCode_NotInScope(cTStrL(cdefList));
    }

    protected void doSetNoonnightCode_NotInScope(Collection<String> noonnightCodeList) {
        regINS(CK_NINS, cTL(noonnightCodeList), xgetCValueNoonnightCode(), "NOONNIGHT_CODE");
    }

    /**
     * Set up ExistsReferrer (correlated sub-query). <br>
     * {exists (select NOONNIGHT_CODE from VILLAGE_DAY where ...)} <br>
     * VILLAGE_DAY by NOONNIGHT_CODE, named 'villageDayAsOne'.
     * <pre>
     * cb.query().<span style="color: #CC4747">existsVillageDay</span>(dayCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     dayCB.query().set...
     * });
     * </pre>
     * @param subCBLambda The callback for sub-query of VillageDayList for 'exists'. (NotNull)
     */
    public void existsVillageDay(SubQuery<VillageDayCB> subCBLambda) {
        assertObjectNotNull("subCBLambda", subCBLambda);
        VillageDayCB cb = new VillageDayCB(); cb.xsetupForExistsReferrer(this);
        lockCall(() -> subCBLambda.query(cb)); String pp = keepNoonnightCode_ExistsReferrer_VillageDayList(cb.query());
        registerExistsReferrer(cb.query(), "NOONNIGHT_CODE", "NOONNIGHT_CODE", pp, "villageDayList");
    }
    public abstract String keepNoonnightCode_ExistsReferrer_VillageDayList(VillageDayCQ sq);

    /**
     * Set up NotExistsReferrer (correlated sub-query). <br>
     * {not exists (select NOONNIGHT_CODE from VILLAGE_DAY where ...)} <br>
     * VILLAGE_DAY by NOONNIGHT_CODE, named 'villageDayAsOne'.
     * <pre>
     * cb.query().<span style="color: #CC4747">notExistsVillageDay</span>(dayCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     dayCB.query().set...
     * });
     * </pre>
     * @param subCBLambda The callback for sub-query of NoonnightCode_NotExistsReferrer_VillageDayList for 'not exists'. (NotNull)
     */
    public void notExistsVillageDay(SubQuery<VillageDayCB> subCBLambda) {
        assertObjectNotNull("subCBLambda", subCBLambda);
        VillageDayCB cb = new VillageDayCB(); cb.xsetupForExistsReferrer(this);
        lockCall(() -> subCBLambda.query(cb)); String pp = keepNoonnightCode_NotExistsReferrer_VillageDayList(cb.query());
        registerNotExistsReferrer(cb.query(), "NOONNIGHT_CODE", "NOONNIGHT_CODE", pp, "villageDayList");
    }
    public abstract String keepNoonnightCode_NotExistsReferrer_VillageDayList(VillageDayCQ sq);

    public void xsderiveVillageDayList(String fn, SubQuery<VillageDayCB> sq, String al, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        VillageDayCB cb = new VillageDayCB(); cb.xsetupForDerivedReferrer(this);
        lockCall(() -> sq.query(cb)); String pp = keepNoonnightCode_SpecifyDerivedReferrer_VillageDayList(cb.query());
        registerSpecifyDerivedReferrer(fn, cb.query(), "NOONNIGHT_CODE", "NOONNIGHT_CODE", pp, "villageDayList", al, op);
    }
    public abstract String keepNoonnightCode_SpecifyDerivedReferrer_VillageDayList(VillageDayCQ sq);

    /**
     * Prepare for (Query)DerivedReferrer (correlated sub-query). <br>
     * {FOO &lt;= (select max(BAR) from VILLAGE_DAY where ...)} <br>
     * VILLAGE_DAY by NOONNIGHT_CODE, named 'villageDayAsOne'.
     * <pre>
     * cb.query().<span style="color: #CC4747">derivedVillageDay()</span>.<span style="color: #CC4747">max</span>(dayCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     dayCB.specify().<span style="color: #CC4747">columnFoo...</span> <span style="color: #3F7E5E">// derived column by function</span>
     *     dayCB.query().setBar... <span style="color: #3F7E5E">// referrer condition</span>
     * }).<span style="color: #CC4747">greaterEqual</span>(123); <span style="color: #3F7E5E">// condition to derived column</span>
     * </pre>
     * @return The object to set up a function for referrer table. (NotNull)
     */
    public HpQDRFunction<VillageDayCB> derivedVillageDay() {
        return xcreateQDRFunctionVillageDayList();
    }
    protected HpQDRFunction<VillageDayCB> xcreateQDRFunctionVillageDayList() {
        return xcQDRFunc((fn, sq, rd, vl, op) -> xqderiveVillageDayList(fn, sq, rd, vl, op));
    }
    public void xqderiveVillageDayList(String fn, SubQuery<VillageDayCB> sq, String rd, Object vl, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        VillageDayCB cb = new VillageDayCB(); cb.xsetupForDerivedReferrer(this);
        lockCall(() -> sq.query(cb)); String sqpp = keepNoonnightCode_QueryDerivedReferrer_VillageDayList(cb.query()); String prpp = keepNoonnightCode_QueryDerivedReferrer_VillageDayListParameter(vl);
        registerQueryDerivedReferrer(fn, cb.query(), "NOONNIGHT_CODE", "NOONNIGHT_CODE", sqpp, "villageDayList", rd, vl, prpp, op);
    }
    public abstract String keepNoonnightCode_QueryDerivedReferrer_VillageDayList(VillageDayCQ sq);
    public abstract String keepNoonnightCode_QueryDerivedReferrer_VillageDayListParameter(Object vl);

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br>
     * NOONNIGHT_CODE: {PK, NotNull, VARCHAR(20), classification=Noonnight}
     */
    public void setNoonnightCode_IsNull() { regNoonnightCode(CK_ISN, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br>
     * NOONNIGHT_CODE: {PK, NotNull, VARCHAR(20), classification=Noonnight}
     */
    public void setNoonnightCode_IsNotNull() { regNoonnightCode(CK_ISNN, DOBJ); }

    protected void regNoonnightCode(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueNoonnightCode(), "NOONNIGHT_CODE"); }
    protected abstract ConditionValue xgetCValueNoonnightCode();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * NOONNIGHT_NAME: {NotNull, VARCHAR(20)}
     * @param noonnightName The value of noonnightName as equal. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setNoonnightName_Equal(String noonnightName) {
        doSetNoonnightName_Equal(fRES(noonnightName));
    }

    protected void doSetNoonnightName_Equal(String noonnightName) {
        regNoonnightName(CK_EQ, noonnightName);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * NOONNIGHT_NAME: {NotNull, VARCHAR(20)}
     * @param noonnightName The value of noonnightName as notEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setNoonnightName_NotEqual(String noonnightName) {
        doSetNoonnightName_NotEqual(fRES(noonnightName));
    }

    protected void doSetNoonnightName_NotEqual(String noonnightName) {
        regNoonnightName(CK_NES, noonnightName);
    }

    /**
     * GreaterThan(&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * NOONNIGHT_NAME: {NotNull, VARCHAR(20)}
     * @param noonnightName The value of noonnightName as greaterThan. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setNoonnightName_GreaterThan(String noonnightName) {
        regNoonnightName(CK_GT, fRES(noonnightName));
    }

    /**
     * LessThan(&lt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * NOONNIGHT_NAME: {NotNull, VARCHAR(20)}
     * @param noonnightName The value of noonnightName as lessThan. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setNoonnightName_LessThan(String noonnightName) {
        regNoonnightName(CK_LT, fRES(noonnightName));
    }

    /**
     * GreaterEqual(&gt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * NOONNIGHT_NAME: {NotNull, VARCHAR(20)}
     * @param noonnightName The value of noonnightName as greaterEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setNoonnightName_GreaterEqual(String noonnightName) {
        regNoonnightName(CK_GE, fRES(noonnightName));
    }

    /**
     * LessEqual(&lt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * NOONNIGHT_NAME: {NotNull, VARCHAR(20)}
     * @param noonnightName The value of noonnightName as lessEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setNoonnightName_LessEqual(String noonnightName) {
        regNoonnightName(CK_LE, fRES(noonnightName));
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * NOONNIGHT_NAME: {NotNull, VARCHAR(20)}
     * @param noonnightNameList The collection of noonnightName as inScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setNoonnightName_InScope(Collection<String> noonnightNameList) {
        doSetNoonnightName_InScope(noonnightNameList);
    }

    protected void doSetNoonnightName_InScope(Collection<String> noonnightNameList) {
        regINS(CK_INS, cTL(noonnightNameList), xgetCValueNoonnightName(), "NOONNIGHT_NAME");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * NOONNIGHT_NAME: {NotNull, VARCHAR(20)}
     * @param noonnightNameList The collection of noonnightName as notInScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setNoonnightName_NotInScope(Collection<String> noonnightNameList) {
        doSetNoonnightName_NotInScope(noonnightNameList);
    }

    protected void doSetNoonnightName_NotInScope(Collection<String> noonnightNameList) {
        regINS(CK_NINS, cTL(noonnightNameList), xgetCValueNoonnightName(), "NOONNIGHT_NAME");
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * NOONNIGHT_NAME: {NotNull, VARCHAR(20)} <br>
     * <pre>e.g. setNoonnightName_LikeSearch("xxx", op <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> op.<span style="color: #CC4747">likeContain()</span>);</pre>
     * @param noonnightName The value of noonnightName as likeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setNoonnightName_LikeSearch(String noonnightName, ConditionOptionCall<LikeSearchOption> opLambda) {
        setNoonnightName_LikeSearch(noonnightName, xcLSOP(opLambda));
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * NOONNIGHT_NAME: {NotNull, VARCHAR(20)} <br>
     * <pre>e.g. setNoonnightName_LikeSearch("xxx", new <span style="color: #CC4747">LikeSearchOption</span>().likeContain());</pre>
     * @param noonnightName The value of noonnightName as likeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    protected void setNoonnightName_LikeSearch(String noonnightName, LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(noonnightName), xgetCValueNoonnightName(), "NOONNIGHT_NAME", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * NOONNIGHT_NAME: {NotNull, VARCHAR(20)}
     * @param noonnightName The value of noonnightName as notLikeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setNoonnightName_NotLikeSearch(String noonnightName, ConditionOptionCall<LikeSearchOption> opLambda) {
        setNoonnightName_NotLikeSearch(noonnightName, xcLSOP(opLambda));
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * NOONNIGHT_NAME: {NotNull, VARCHAR(20)}
     * @param noonnightName The value of noonnightName as notLikeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    protected void setNoonnightName_NotLikeSearch(String noonnightName, LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(noonnightName), xgetCValueNoonnightName(), "NOONNIGHT_NAME", likeSearchOption);
    }

    protected void regNoonnightName(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueNoonnightName(), "NOONNIGHT_NAME"); }
    protected abstract ConditionValue xgetCValueNoonnightName();

    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br>
     * DISP_ORDER: {NotNull, INT UNSIGNED(10)}
     * @param dispOrder The value of dispOrder as equal. (basically NotNull: error as default, or no condition as option)
     */
    public void setDispOrder_Equal(Integer dispOrder) {
        doSetDispOrder_Equal(dispOrder);
    }

    protected void doSetDispOrder_Equal(Integer dispOrder) {
        regDispOrder(CK_EQ, dispOrder);
    }

    /**
     * NotEqual(&lt;&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * DISP_ORDER: {NotNull, INT UNSIGNED(10)}
     * @param dispOrder The value of dispOrder as notEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setDispOrder_NotEqual(Integer dispOrder) {
        doSetDispOrder_NotEqual(dispOrder);
    }

    protected void doSetDispOrder_NotEqual(Integer dispOrder) {
        regDispOrder(CK_NES, dispOrder);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * DISP_ORDER: {NotNull, INT UNSIGNED(10)}
     * @param dispOrder The value of dispOrder as greaterThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setDispOrder_GreaterThan(Integer dispOrder) {
        regDispOrder(CK_GT, dispOrder);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br>
     * DISP_ORDER: {NotNull, INT UNSIGNED(10)}
     * @param dispOrder The value of dispOrder as lessThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setDispOrder_LessThan(Integer dispOrder) {
        regDispOrder(CK_LT, dispOrder);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * DISP_ORDER: {NotNull, INT UNSIGNED(10)}
     * @param dispOrder The value of dispOrder as greaterEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setDispOrder_GreaterEqual(Integer dispOrder) {
        regDispOrder(CK_GE, dispOrder);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * DISP_ORDER: {NotNull, INT UNSIGNED(10)}
     * @param dispOrder The value of dispOrder as lessEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setDispOrder_LessEqual(Integer dispOrder) {
        regDispOrder(CK_LE, dispOrder);
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * DISP_ORDER: {NotNull, INT UNSIGNED(10)}
     * @param minNumber The min number of dispOrder. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param maxNumber The max number of dispOrder. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param opLambda The callback for option of range-of. (NotNull)
     */
    public void setDispOrder_RangeOf(Integer minNumber, Integer maxNumber, ConditionOptionCall<RangeOfOption> opLambda) {
        setDispOrder_RangeOf(minNumber, maxNumber, xcROOP(opLambda));
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * DISP_ORDER: {NotNull, INT UNSIGNED(10)}
     * @param minNumber The min number of dispOrder. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param maxNumber The max number of dispOrder. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    protected void setDispOrder_RangeOf(Integer minNumber, Integer maxNumber, RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, xgetCValueDispOrder(), "DISP_ORDER", rangeOfOption);
    }

    /**
     * InScope {in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * DISP_ORDER: {NotNull, INT UNSIGNED(10)}
     * @param dispOrderList The collection of dispOrder as inScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setDispOrder_InScope(Collection<Integer> dispOrderList) {
        doSetDispOrder_InScope(dispOrderList);
    }

    protected void doSetDispOrder_InScope(Collection<Integer> dispOrderList) {
        regINS(CK_INS, cTL(dispOrderList), xgetCValueDispOrder(), "DISP_ORDER");
    }

    /**
     * NotInScope {not in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * DISP_ORDER: {NotNull, INT UNSIGNED(10)}
     * @param dispOrderList The collection of dispOrder as notInScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setDispOrder_NotInScope(Collection<Integer> dispOrderList) {
        doSetDispOrder_NotInScope(dispOrderList);
    }

    protected void doSetDispOrder_NotInScope(Collection<Integer> dispOrderList) {
        regINS(CK_NINS, cTL(dispOrderList), xgetCValueDispOrder(), "DISP_ORDER");
    }

    protected void regDispOrder(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueDispOrder(), "DISP_ORDER"); }
    protected abstract ConditionValue xgetCValueDispOrder();

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
    public HpSLCFunction<NoonnightCB> scalar_Equal() {
        return xcreateSLCFunction(CK_EQ, NoonnightCB.class);
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
    public HpSLCFunction<NoonnightCB> scalar_NotEqual() {
        return xcreateSLCFunction(CK_NES, NoonnightCB.class);
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
    public HpSLCFunction<NoonnightCB> scalar_GreaterThan() {
        return xcreateSLCFunction(CK_GT, NoonnightCB.class);
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
    public HpSLCFunction<NoonnightCB> scalar_LessThan() {
        return xcreateSLCFunction(CK_LT, NoonnightCB.class);
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
    public HpSLCFunction<NoonnightCB> scalar_GreaterEqual() {
        return xcreateSLCFunction(CK_GE, NoonnightCB.class);
    }

    /**
     * Prepare ScalarCondition as lessEqual. <br>
     * {where FOO &lt;= (select max(BAR) from ...)}
     * <pre>
     * cb.query().<span style="color: #CC4747">scalar_LessEqual()</span>.max(new SubQuery&lt;NoonnightCB&gt;() {
     *     public void query(NoonnightCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSLCFunction<NoonnightCB> scalar_LessEqual() {
        return xcreateSLCFunction(CK_LE, NoonnightCB.class);
    }

    @SuppressWarnings("unchecked")
    protected <CB extends ConditionBean> void xscalarCondition(String fn, SubQuery<CB> sq, String rd, HpSLCCustomized<CB> cs, ScalarConditionOption op) {
        assertObjectNotNull("subQuery", sq);
        NoonnightCB cb = xcreateScalarConditionCB(); sq.query((CB)cb);
        String pp = keepScalarCondition(cb.query()); // for saving query-value
        cs.setPartitionByCBean((CB)xcreateScalarConditionPartitionByCB()); // for using partition-by
        registerScalarCondition(fn, cb.query(), pp, rd, cs, op);
    }
    public abstract String keepScalarCondition(NoonnightCQ sq);

    protected NoonnightCB xcreateScalarConditionCB() {
        NoonnightCB cb = newMyCB(); cb.xsetupForScalarCondition(this); return cb;
    }

    protected NoonnightCB xcreateScalarConditionPartitionByCB() {
        NoonnightCB cb = newMyCB(); cb.xsetupForScalarConditionPartitionBy(this); return cb;
    }

    // ===================================================================================
    //                                                                       MyselfDerived
    //                                                                       =============
    public void xsmyselfDerive(String fn, SubQuery<NoonnightCB> sq, String al, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        NoonnightCB cb = new NoonnightCB(); cb.xsetupForDerivedReferrer(this);
        lockCall(() -> sq.query(cb)); String pp = keepSpecifyMyselfDerived(cb.query()); String pk = "NOONNIGHT_CODE";
        registerSpecifyMyselfDerived(fn, cb.query(), pk, pk, pp, "myselfDerived", al, op);
    }
    public abstract String keepSpecifyMyselfDerived(NoonnightCQ sq);

    /**
     * Prepare for (Query)MyselfDerived (correlated sub-query).
     * @return The object to set up a function for myself table. (NotNull)
     */
    public HpQDRFunction<NoonnightCB> myselfDerived() {
        return xcreateQDRFunctionMyselfDerived(NoonnightCB.class);
    }
    @SuppressWarnings("unchecked")
    protected <CB extends ConditionBean> void xqderiveMyselfDerived(String fn, SubQuery<CB> sq, String rd, Object vl, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        NoonnightCB cb = new NoonnightCB(); cb.xsetupForDerivedReferrer(this); sq.query((CB)cb);
        String pk = "NOONNIGHT_CODE";
        String sqpp = keepQueryMyselfDerived(cb.query()); // for saving query-value.
        String prpp = keepQueryMyselfDerivedParameter(vl);
        registerQueryMyselfDerived(fn, cb.query(), pk, pk, sqpp, "myselfDerived", rd, vl, prpp, op);
    }
    public abstract String keepQueryMyselfDerived(NoonnightCQ sq);
    public abstract String keepQueryMyselfDerivedParameter(Object vl);

    // ===================================================================================
    //                                                                        MyselfExists
    //                                                                        ============
    /**
     * Prepare for MyselfExists (correlated sub-query).
     * @param subCBLambda The implementation of sub-query. (NotNull)
     */
    public void myselfExists(SubQuery<NoonnightCB> subCBLambda) {
        assertObjectNotNull("subCBLambda", subCBLambda);
        NoonnightCB cb = new NoonnightCB(); cb.xsetupForMyselfExists(this);
        lockCall(() -> subCBLambda.query(cb)); String pp = keepMyselfExists(cb.query());
        registerMyselfExists(cb.query(), pp);
    }
    public abstract String keepMyselfExists(NoonnightCQ sq);

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
    protected NoonnightCB newMyCB() {
        return new NoonnightCB();
    }
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xabUDT() { return Date.class.getName(); }
    protected String xabCQ() { return NoonnightCQ.class.getName(); }
    protected String xabLSO() { return LikeSearchOption.class.getName(); }
    protected String xabSLCS() { return HpSLCSetupper.class.getName(); }
    protected String xabSCP() { return SubQuery.class.getName(); }
}
