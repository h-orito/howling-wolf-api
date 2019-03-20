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
 * The abstract condition-query of allowed_secret_say.
 * @author DBFlute(AutoGenerator)
 */
public abstract class AbstractBsAllowedSecretSayCQ extends AbstractConditionQuery {

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public AbstractBsAllowedSecretSayCQ(ConditionQuery referrerQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
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
        return "allowed_secret_say";
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====
    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * ALLOWED_SECRET_SAY_CODE: {PK, NotNull, VARCHAR(20), classification=AllowedSecretSay}
     * @param allowedSecretSayCode The value of allowedSecretSayCode as equal. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    protected void setAllowedSecretSayCode_Equal(String allowedSecretSayCode) {
        doSetAllowedSecretSayCode_Equal(fRES(allowedSecretSayCode));
    }

    /**
     * Equal(=). As AllowedSecretSay. And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * ALLOWED_SECRET_SAY_CODE: {PK, NotNull, VARCHAR(20), classification=AllowedSecretSay} <br>
     * 秘話可能範囲
     * @param cdef The instance of classification definition (as ENUM type). (basically NotNull: error as default, or no condition as option)
     */
    public void setAllowedSecretSayCode_Equal_AsAllowedSecretSay(CDef.AllowedSecretSay cdef) {
        doSetAllowedSecretSayCode_Equal(cdef != null ? cdef.code() : null);
    }

    /**
     * Equal(=). As 全員 (EVERYTHING). And OnlyOnceRegistered. <br>
     * 全員
     */
    public void setAllowedSecretSayCode_Equal_全員() {
        setAllowedSecretSayCode_Equal_AsAllowedSecretSay(CDef.AllowedSecretSay.全員);
    }

    /**
     * Equal(=). As なし (NOTHING). And OnlyOnceRegistered. <br>
     * なし
     */
    public void setAllowedSecretSayCode_Equal_なし() {
        setAllowedSecretSayCode_Equal_AsAllowedSecretSay(CDef.AllowedSecretSay.なし);
    }

    /**
     * Equal(=). As 村建てとのみ (ONLY_CREATOR). And OnlyOnceRegistered. <br>
     * 村建てとのみ
     */
    public void setAllowedSecretSayCode_Equal_村建てとのみ() {
        setAllowedSecretSayCode_Equal_AsAllowedSecretSay(CDef.AllowedSecretSay.村建てとのみ);
    }

    protected void doSetAllowedSecretSayCode_Equal(String allowedSecretSayCode) {
        regAllowedSecretSayCode(CK_EQ, allowedSecretSayCode);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * ALLOWED_SECRET_SAY_CODE: {PK, NotNull, VARCHAR(20), classification=AllowedSecretSay}
     * @param allowedSecretSayCode The value of allowedSecretSayCode as notEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    protected void setAllowedSecretSayCode_NotEqual(String allowedSecretSayCode) {
        doSetAllowedSecretSayCode_NotEqual(fRES(allowedSecretSayCode));
    }

    /**
     * NotEqual(&lt;&gt;). As AllowedSecretSay. And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * ALLOWED_SECRET_SAY_CODE: {PK, NotNull, VARCHAR(20), classification=AllowedSecretSay} <br>
     * 秘話可能範囲
     * @param cdef The instance of classification definition (as ENUM type). (basically NotNull: error as default, or no condition as option)
     */
    public void setAllowedSecretSayCode_NotEqual_AsAllowedSecretSay(CDef.AllowedSecretSay cdef) {
        doSetAllowedSecretSayCode_NotEqual(cdef != null ? cdef.code() : null);
    }

    /**
     * NotEqual(&lt;&gt;). As 全員 (EVERYTHING). And OnlyOnceRegistered. <br>
     * 全員
     */
    public void setAllowedSecretSayCode_NotEqual_全員() {
        setAllowedSecretSayCode_NotEqual_AsAllowedSecretSay(CDef.AllowedSecretSay.全員);
    }

    /**
     * NotEqual(&lt;&gt;). As なし (NOTHING). And OnlyOnceRegistered. <br>
     * なし
     */
    public void setAllowedSecretSayCode_NotEqual_なし() {
        setAllowedSecretSayCode_NotEqual_AsAllowedSecretSay(CDef.AllowedSecretSay.なし);
    }

    /**
     * NotEqual(&lt;&gt;). As 村建てとのみ (ONLY_CREATOR). And OnlyOnceRegistered. <br>
     * 村建てとのみ
     */
    public void setAllowedSecretSayCode_NotEqual_村建てとのみ() {
        setAllowedSecretSayCode_NotEqual_AsAllowedSecretSay(CDef.AllowedSecretSay.村建てとのみ);
    }

    protected void doSetAllowedSecretSayCode_NotEqual(String allowedSecretSayCode) {
        regAllowedSecretSayCode(CK_NES, allowedSecretSayCode);
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * ALLOWED_SECRET_SAY_CODE: {PK, NotNull, VARCHAR(20), classification=AllowedSecretSay}
     * @param allowedSecretSayCodeList The collection of allowedSecretSayCode as inScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    protected void setAllowedSecretSayCode_InScope(Collection<String> allowedSecretSayCodeList) {
        doSetAllowedSecretSayCode_InScope(allowedSecretSayCodeList);
    }

    /**
     * InScope {in ('a', 'b')}. As AllowedSecretSay. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * ALLOWED_SECRET_SAY_CODE: {PK, NotNull, VARCHAR(20), classification=AllowedSecretSay} <br>
     * 秘話可能範囲
     * @param cdefList The list of classification definition (as ENUM type). (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setAllowedSecretSayCode_InScope_AsAllowedSecretSay(Collection<CDef.AllowedSecretSay> cdefList) {
        doSetAllowedSecretSayCode_InScope(cTStrL(cdefList));
    }

    protected void doSetAllowedSecretSayCode_InScope(Collection<String> allowedSecretSayCodeList) {
        regINS(CK_INS, cTL(allowedSecretSayCodeList), xgetCValueAllowedSecretSayCode(), "ALLOWED_SECRET_SAY_CODE");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * ALLOWED_SECRET_SAY_CODE: {PK, NotNull, VARCHAR(20), classification=AllowedSecretSay}
     * @param allowedSecretSayCodeList The collection of allowedSecretSayCode as notInScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    protected void setAllowedSecretSayCode_NotInScope(Collection<String> allowedSecretSayCodeList) {
        doSetAllowedSecretSayCode_NotInScope(allowedSecretSayCodeList);
    }

    /**
     * NotInScope {not in ('a', 'b')}. As AllowedSecretSay. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * ALLOWED_SECRET_SAY_CODE: {PK, NotNull, VARCHAR(20), classification=AllowedSecretSay} <br>
     * 秘話可能範囲
     * @param cdefList The list of classification definition (as ENUM type). (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setAllowedSecretSayCode_NotInScope_AsAllowedSecretSay(Collection<CDef.AllowedSecretSay> cdefList) {
        doSetAllowedSecretSayCode_NotInScope(cTStrL(cdefList));
    }

    protected void doSetAllowedSecretSayCode_NotInScope(Collection<String> allowedSecretSayCodeList) {
        regINS(CK_NINS, cTL(allowedSecretSayCodeList), xgetCValueAllowedSecretSayCode(), "ALLOWED_SECRET_SAY_CODE");
    }

    /**
     * Set up ExistsReferrer (correlated sub-query). <br>
     * {exists (select ALLOWED_SECRET_SAY_CODE from village_settings where ...)} <br>
     * village_settings by ALLOWED_SECRET_SAY_CODE, named 'villageSettingsAsOne'.
     * <pre>
     * cb.query().<span style="color: #CC4747">existsVillageSettings</span>(settingsCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     settingsCB.query().set...
     * });
     * </pre>
     * @param subCBLambda The callback for sub-query of VillageSettingsList for 'exists'. (NotNull)
     */
    public void existsVillageSettings(SubQuery<VillageSettingsCB> subCBLambda) {
        assertObjectNotNull("subCBLambda", subCBLambda);
        VillageSettingsCB cb = new VillageSettingsCB(); cb.xsetupForExistsReferrer(this);
        lockCall(() -> subCBLambda.query(cb)); String pp = keepAllowedSecretSayCode_ExistsReferrer_VillageSettingsList(cb.query());
        registerExistsReferrer(cb.query(), "ALLOWED_SECRET_SAY_CODE", "ALLOWED_SECRET_SAY_CODE", pp, "villageSettingsList");
    }
    public abstract String keepAllowedSecretSayCode_ExistsReferrer_VillageSettingsList(VillageSettingsCQ sq);

    /**
     * Set up NotExistsReferrer (correlated sub-query). <br>
     * {not exists (select ALLOWED_SECRET_SAY_CODE from village_settings where ...)} <br>
     * village_settings by ALLOWED_SECRET_SAY_CODE, named 'villageSettingsAsOne'.
     * <pre>
     * cb.query().<span style="color: #CC4747">notExistsVillageSettings</span>(settingsCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     settingsCB.query().set...
     * });
     * </pre>
     * @param subCBLambda The callback for sub-query of AllowedSecretSayCode_NotExistsReferrer_VillageSettingsList for 'not exists'. (NotNull)
     */
    public void notExistsVillageSettings(SubQuery<VillageSettingsCB> subCBLambda) {
        assertObjectNotNull("subCBLambda", subCBLambda);
        VillageSettingsCB cb = new VillageSettingsCB(); cb.xsetupForExistsReferrer(this);
        lockCall(() -> subCBLambda.query(cb)); String pp = keepAllowedSecretSayCode_NotExistsReferrer_VillageSettingsList(cb.query());
        registerNotExistsReferrer(cb.query(), "ALLOWED_SECRET_SAY_CODE", "ALLOWED_SECRET_SAY_CODE", pp, "villageSettingsList");
    }
    public abstract String keepAllowedSecretSayCode_NotExistsReferrer_VillageSettingsList(VillageSettingsCQ sq);

    public void xsderiveVillageSettingsList(String fn, SubQuery<VillageSettingsCB> sq, String al, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        VillageSettingsCB cb = new VillageSettingsCB(); cb.xsetupForDerivedReferrer(this);
        lockCall(() -> sq.query(cb)); String pp = keepAllowedSecretSayCode_SpecifyDerivedReferrer_VillageSettingsList(cb.query());
        registerSpecifyDerivedReferrer(fn, cb.query(), "ALLOWED_SECRET_SAY_CODE", "ALLOWED_SECRET_SAY_CODE", pp, "villageSettingsList", al, op);
    }
    public abstract String keepAllowedSecretSayCode_SpecifyDerivedReferrer_VillageSettingsList(VillageSettingsCQ sq);

    /**
     * Prepare for (Query)DerivedReferrer (correlated sub-query). <br>
     * {FOO &lt;= (select max(BAR) from village_settings where ...)} <br>
     * village_settings by ALLOWED_SECRET_SAY_CODE, named 'villageSettingsAsOne'.
     * <pre>
     * cb.query().<span style="color: #CC4747">derivedVillageSettings()</span>.<span style="color: #CC4747">max</span>(settingsCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     settingsCB.specify().<span style="color: #CC4747">columnFoo...</span> <span style="color: #3F7E5E">// derived column by function</span>
     *     settingsCB.query().setBar... <span style="color: #3F7E5E">// referrer condition</span>
     * }).<span style="color: #CC4747">greaterEqual</span>(123); <span style="color: #3F7E5E">// condition to derived column</span>
     * </pre>
     * @return The object to set up a function for referrer table. (NotNull)
     */
    public HpQDRFunction<VillageSettingsCB> derivedVillageSettings() {
        return xcreateQDRFunctionVillageSettingsList();
    }
    protected HpQDRFunction<VillageSettingsCB> xcreateQDRFunctionVillageSettingsList() {
        return xcQDRFunc((fn, sq, rd, vl, op) -> xqderiveVillageSettingsList(fn, sq, rd, vl, op));
    }
    public void xqderiveVillageSettingsList(String fn, SubQuery<VillageSettingsCB> sq, String rd, Object vl, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        VillageSettingsCB cb = new VillageSettingsCB(); cb.xsetupForDerivedReferrer(this);
        lockCall(() -> sq.query(cb)); String sqpp = keepAllowedSecretSayCode_QueryDerivedReferrer_VillageSettingsList(cb.query()); String prpp = keepAllowedSecretSayCode_QueryDerivedReferrer_VillageSettingsListParameter(vl);
        registerQueryDerivedReferrer(fn, cb.query(), "ALLOWED_SECRET_SAY_CODE", "ALLOWED_SECRET_SAY_CODE", sqpp, "villageSettingsList", rd, vl, prpp, op);
    }
    public abstract String keepAllowedSecretSayCode_QueryDerivedReferrer_VillageSettingsList(VillageSettingsCQ sq);
    public abstract String keepAllowedSecretSayCode_QueryDerivedReferrer_VillageSettingsListParameter(Object vl);

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br>
     * ALLOWED_SECRET_SAY_CODE: {PK, NotNull, VARCHAR(20), classification=AllowedSecretSay}
     */
    public void setAllowedSecretSayCode_IsNull() { regAllowedSecretSayCode(CK_ISN, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br>
     * ALLOWED_SECRET_SAY_CODE: {PK, NotNull, VARCHAR(20), classification=AllowedSecretSay}
     */
    public void setAllowedSecretSayCode_IsNotNull() { regAllowedSecretSayCode(CK_ISNN, DOBJ); }

    protected void regAllowedSecretSayCode(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueAllowedSecretSayCode(), "ALLOWED_SECRET_SAY_CODE"); }
    protected abstract ConditionValue xgetCValueAllowedSecretSayCode();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * ALLOWED_SECRET_SAY_NAME: {NotNull, VARCHAR(20)}
     * @param allowedSecretSayName The value of allowedSecretSayName as equal. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setAllowedSecretSayName_Equal(String allowedSecretSayName) {
        doSetAllowedSecretSayName_Equal(fRES(allowedSecretSayName));
    }

    protected void doSetAllowedSecretSayName_Equal(String allowedSecretSayName) {
        regAllowedSecretSayName(CK_EQ, allowedSecretSayName);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * ALLOWED_SECRET_SAY_NAME: {NotNull, VARCHAR(20)}
     * @param allowedSecretSayName The value of allowedSecretSayName as notEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setAllowedSecretSayName_NotEqual(String allowedSecretSayName) {
        doSetAllowedSecretSayName_NotEqual(fRES(allowedSecretSayName));
    }

    protected void doSetAllowedSecretSayName_NotEqual(String allowedSecretSayName) {
        regAllowedSecretSayName(CK_NES, allowedSecretSayName);
    }

    /**
     * GreaterThan(&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * ALLOWED_SECRET_SAY_NAME: {NotNull, VARCHAR(20)}
     * @param allowedSecretSayName The value of allowedSecretSayName as greaterThan. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setAllowedSecretSayName_GreaterThan(String allowedSecretSayName) {
        regAllowedSecretSayName(CK_GT, fRES(allowedSecretSayName));
    }

    /**
     * LessThan(&lt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * ALLOWED_SECRET_SAY_NAME: {NotNull, VARCHAR(20)}
     * @param allowedSecretSayName The value of allowedSecretSayName as lessThan. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setAllowedSecretSayName_LessThan(String allowedSecretSayName) {
        regAllowedSecretSayName(CK_LT, fRES(allowedSecretSayName));
    }

    /**
     * GreaterEqual(&gt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * ALLOWED_SECRET_SAY_NAME: {NotNull, VARCHAR(20)}
     * @param allowedSecretSayName The value of allowedSecretSayName as greaterEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setAllowedSecretSayName_GreaterEqual(String allowedSecretSayName) {
        regAllowedSecretSayName(CK_GE, fRES(allowedSecretSayName));
    }

    /**
     * LessEqual(&lt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * ALLOWED_SECRET_SAY_NAME: {NotNull, VARCHAR(20)}
     * @param allowedSecretSayName The value of allowedSecretSayName as lessEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setAllowedSecretSayName_LessEqual(String allowedSecretSayName) {
        regAllowedSecretSayName(CK_LE, fRES(allowedSecretSayName));
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * ALLOWED_SECRET_SAY_NAME: {NotNull, VARCHAR(20)}
     * @param allowedSecretSayNameList The collection of allowedSecretSayName as inScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setAllowedSecretSayName_InScope(Collection<String> allowedSecretSayNameList) {
        doSetAllowedSecretSayName_InScope(allowedSecretSayNameList);
    }

    protected void doSetAllowedSecretSayName_InScope(Collection<String> allowedSecretSayNameList) {
        regINS(CK_INS, cTL(allowedSecretSayNameList), xgetCValueAllowedSecretSayName(), "ALLOWED_SECRET_SAY_NAME");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * ALLOWED_SECRET_SAY_NAME: {NotNull, VARCHAR(20)}
     * @param allowedSecretSayNameList The collection of allowedSecretSayName as notInScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setAllowedSecretSayName_NotInScope(Collection<String> allowedSecretSayNameList) {
        doSetAllowedSecretSayName_NotInScope(allowedSecretSayNameList);
    }

    protected void doSetAllowedSecretSayName_NotInScope(Collection<String> allowedSecretSayNameList) {
        regINS(CK_NINS, cTL(allowedSecretSayNameList), xgetCValueAllowedSecretSayName(), "ALLOWED_SECRET_SAY_NAME");
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * ALLOWED_SECRET_SAY_NAME: {NotNull, VARCHAR(20)} <br>
     * <pre>e.g. setAllowedSecretSayName_LikeSearch("xxx", op <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> op.<span style="color: #CC4747">likeContain()</span>);</pre>
     * @param allowedSecretSayName The value of allowedSecretSayName as likeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setAllowedSecretSayName_LikeSearch(String allowedSecretSayName, ConditionOptionCall<LikeSearchOption> opLambda) {
        setAllowedSecretSayName_LikeSearch(allowedSecretSayName, xcLSOP(opLambda));
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * ALLOWED_SECRET_SAY_NAME: {NotNull, VARCHAR(20)} <br>
     * <pre>e.g. setAllowedSecretSayName_LikeSearch("xxx", new <span style="color: #CC4747">LikeSearchOption</span>().likeContain());</pre>
     * @param allowedSecretSayName The value of allowedSecretSayName as likeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    protected void setAllowedSecretSayName_LikeSearch(String allowedSecretSayName, LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(allowedSecretSayName), xgetCValueAllowedSecretSayName(), "ALLOWED_SECRET_SAY_NAME", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * ALLOWED_SECRET_SAY_NAME: {NotNull, VARCHAR(20)}
     * @param allowedSecretSayName The value of allowedSecretSayName as notLikeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setAllowedSecretSayName_NotLikeSearch(String allowedSecretSayName, ConditionOptionCall<LikeSearchOption> opLambda) {
        setAllowedSecretSayName_NotLikeSearch(allowedSecretSayName, xcLSOP(opLambda));
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * ALLOWED_SECRET_SAY_NAME: {NotNull, VARCHAR(20)}
     * @param allowedSecretSayName The value of allowedSecretSayName as notLikeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    protected void setAllowedSecretSayName_NotLikeSearch(String allowedSecretSayName, LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(allowedSecretSayName), xgetCValueAllowedSecretSayName(), "ALLOWED_SECRET_SAY_NAME", likeSearchOption);
    }

    protected void regAllowedSecretSayName(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueAllowedSecretSayName(), "ALLOWED_SECRET_SAY_NAME"); }
    protected abstract ConditionValue xgetCValueAllowedSecretSayName();

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
    public HpSLCFunction<AllowedSecretSayCB> scalar_Equal() {
        return xcreateSLCFunction(CK_EQ, AllowedSecretSayCB.class);
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
    public HpSLCFunction<AllowedSecretSayCB> scalar_NotEqual() {
        return xcreateSLCFunction(CK_NES, AllowedSecretSayCB.class);
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
    public HpSLCFunction<AllowedSecretSayCB> scalar_GreaterThan() {
        return xcreateSLCFunction(CK_GT, AllowedSecretSayCB.class);
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
    public HpSLCFunction<AllowedSecretSayCB> scalar_LessThan() {
        return xcreateSLCFunction(CK_LT, AllowedSecretSayCB.class);
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
    public HpSLCFunction<AllowedSecretSayCB> scalar_GreaterEqual() {
        return xcreateSLCFunction(CK_GE, AllowedSecretSayCB.class);
    }

    /**
     * Prepare ScalarCondition as lessEqual. <br>
     * {where FOO &lt;= (select max(BAR) from ...)}
     * <pre>
     * cb.query().<span style="color: #CC4747">scalar_LessEqual()</span>.max(new SubQuery&lt;AllowedSecretSayCB&gt;() {
     *     public void query(AllowedSecretSayCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSLCFunction<AllowedSecretSayCB> scalar_LessEqual() {
        return xcreateSLCFunction(CK_LE, AllowedSecretSayCB.class);
    }

    @SuppressWarnings("unchecked")
    protected <CB extends ConditionBean> void xscalarCondition(String fn, SubQuery<CB> sq, String rd, HpSLCCustomized<CB> cs, ScalarConditionOption op) {
        assertObjectNotNull("subQuery", sq);
        AllowedSecretSayCB cb = xcreateScalarConditionCB(); sq.query((CB)cb);
        String pp = keepScalarCondition(cb.query()); // for saving query-value
        cs.setPartitionByCBean((CB)xcreateScalarConditionPartitionByCB()); // for using partition-by
        registerScalarCondition(fn, cb.query(), pp, rd, cs, op);
    }
    public abstract String keepScalarCondition(AllowedSecretSayCQ sq);

    protected AllowedSecretSayCB xcreateScalarConditionCB() {
        AllowedSecretSayCB cb = newMyCB(); cb.xsetupForScalarCondition(this); return cb;
    }

    protected AllowedSecretSayCB xcreateScalarConditionPartitionByCB() {
        AllowedSecretSayCB cb = newMyCB(); cb.xsetupForScalarConditionPartitionBy(this); return cb;
    }

    // ===================================================================================
    //                                                                       MyselfDerived
    //                                                                       =============
    public void xsmyselfDerive(String fn, SubQuery<AllowedSecretSayCB> sq, String al, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        AllowedSecretSayCB cb = new AllowedSecretSayCB(); cb.xsetupForDerivedReferrer(this);
        lockCall(() -> sq.query(cb)); String pp = keepSpecifyMyselfDerived(cb.query()); String pk = "ALLOWED_SECRET_SAY_CODE";
        registerSpecifyMyselfDerived(fn, cb.query(), pk, pk, pp, "myselfDerived", al, op);
    }
    public abstract String keepSpecifyMyselfDerived(AllowedSecretSayCQ sq);

    /**
     * Prepare for (Query)MyselfDerived (correlated sub-query).
     * @return The object to set up a function for myself table. (NotNull)
     */
    public HpQDRFunction<AllowedSecretSayCB> myselfDerived() {
        return xcreateQDRFunctionMyselfDerived(AllowedSecretSayCB.class);
    }
    @SuppressWarnings("unchecked")
    protected <CB extends ConditionBean> void xqderiveMyselfDerived(String fn, SubQuery<CB> sq, String rd, Object vl, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        AllowedSecretSayCB cb = new AllowedSecretSayCB(); cb.xsetupForDerivedReferrer(this); sq.query((CB)cb);
        String pk = "ALLOWED_SECRET_SAY_CODE";
        String sqpp = keepQueryMyselfDerived(cb.query()); // for saving query-value.
        String prpp = keepQueryMyselfDerivedParameter(vl);
        registerQueryMyselfDerived(fn, cb.query(), pk, pk, sqpp, "myselfDerived", rd, vl, prpp, op);
    }
    public abstract String keepQueryMyselfDerived(AllowedSecretSayCQ sq);
    public abstract String keepQueryMyselfDerivedParameter(Object vl);

    // ===================================================================================
    //                                                                        MyselfExists
    //                                                                        ============
    /**
     * Prepare for MyselfExists (correlated sub-query).
     * @param subCBLambda The implementation of sub-query. (NotNull)
     */
    public void myselfExists(SubQuery<AllowedSecretSayCB> subCBLambda) {
        assertObjectNotNull("subCBLambda", subCBLambda);
        AllowedSecretSayCB cb = new AllowedSecretSayCB(); cb.xsetupForMyselfExists(this);
        lockCall(() -> subCBLambda.query(cb)); String pp = keepMyselfExists(cb.query());
        registerMyselfExists(cb.query(), pp);
    }
    public abstract String keepMyselfExists(AllowedSecretSayCQ sq);

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
    protected AllowedSecretSayCB newMyCB() {
        return new AllowedSecretSayCB();
    }
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xabUDT() { return Date.class.getName(); }
    protected String xabCQ() { return AllowedSecretSayCQ.class.getName(); }
    protected String xabLSO() { return LikeSearchOption.class.getName(); }
    protected String xabSLCS() { return HpSLCSetupper.class.getName(); }
    protected String xabSCP() { return SubQuery.class.getName(); }
}
