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
 * The abstract condition-query of camp.
 * @author DBFlute(AutoGenerator)
 */
public abstract class AbstractBsCampCQ extends AbstractConditionQuery {

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public AbstractBsCampCQ(ConditionQuery referrerQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
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
        return "camp";
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====
    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * CAMP_CODE: {PK, NotNull, VARCHAR(20), classification=Camp}
     * @param campCode The value of campCode as equal. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    protected void setCampCode_Equal(String campCode) {
        doSetCampCode_Equal(fRES(campCode));
    }

    /**
     * Equal(=). As Camp. And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * CAMP_CODE: {PK, NotNull, VARCHAR(20), classification=Camp} <br>
     * 陣営
     * @param cdef The instance of classification definition (as ENUM type). (basically NotNull: error as default, or no condition as option)
     */
    public void setCampCode_Equal_AsCamp(CDef.Camp cdef) {
        doSetCampCode_Equal(cdef != null ? cdef.code() : null);
    }

    /**
     * Equal(=). As 狐陣営 (FOX). And OnlyOnceRegistered. <br>
     * 狐陣営
     */
    public void setCampCode_Equal_狐陣営() {
        setCampCode_Equal_AsCamp(CDef.Camp.狐陣営);
    }

    /**
     * Equal(=). As 村人陣営 (VILLAGER). And OnlyOnceRegistered. <br>
     * 村人陣営
     */
    public void setCampCode_Equal_村人陣営() {
        setCampCode_Equal_AsCamp(CDef.Camp.村人陣営);
    }

    /**
     * Equal(=). As 人狼陣営 (WEREWOLF). And OnlyOnceRegistered. <br>
     * 人狼陣営
     */
    public void setCampCode_Equal_人狼陣営() {
        setCampCode_Equal_AsCamp(CDef.Camp.人狼陣営);
    }

    protected void doSetCampCode_Equal(String campCode) {
        regCampCode(CK_EQ, campCode);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * CAMP_CODE: {PK, NotNull, VARCHAR(20), classification=Camp}
     * @param campCode The value of campCode as notEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    protected void setCampCode_NotEqual(String campCode) {
        doSetCampCode_NotEqual(fRES(campCode));
    }

    /**
     * NotEqual(&lt;&gt;). As Camp. And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * CAMP_CODE: {PK, NotNull, VARCHAR(20), classification=Camp} <br>
     * 陣営
     * @param cdef The instance of classification definition (as ENUM type). (basically NotNull: error as default, or no condition as option)
     */
    public void setCampCode_NotEqual_AsCamp(CDef.Camp cdef) {
        doSetCampCode_NotEqual(cdef != null ? cdef.code() : null);
    }

    /**
     * NotEqual(&lt;&gt;). As 狐陣営 (FOX). And OnlyOnceRegistered. <br>
     * 狐陣営
     */
    public void setCampCode_NotEqual_狐陣営() {
        setCampCode_NotEqual_AsCamp(CDef.Camp.狐陣営);
    }

    /**
     * NotEqual(&lt;&gt;). As 村人陣営 (VILLAGER). And OnlyOnceRegistered. <br>
     * 村人陣営
     */
    public void setCampCode_NotEqual_村人陣営() {
        setCampCode_NotEqual_AsCamp(CDef.Camp.村人陣営);
    }

    /**
     * NotEqual(&lt;&gt;). As 人狼陣営 (WEREWOLF). And OnlyOnceRegistered. <br>
     * 人狼陣営
     */
    public void setCampCode_NotEqual_人狼陣営() {
        setCampCode_NotEqual_AsCamp(CDef.Camp.人狼陣営);
    }

    protected void doSetCampCode_NotEqual(String campCode) {
        regCampCode(CK_NES, campCode);
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * CAMP_CODE: {PK, NotNull, VARCHAR(20), classification=Camp}
     * @param campCodeList The collection of campCode as inScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    protected void setCampCode_InScope(Collection<String> campCodeList) {
        doSetCampCode_InScope(campCodeList);
    }

    /**
     * InScope {in ('a', 'b')}. As Camp. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * CAMP_CODE: {PK, NotNull, VARCHAR(20), classification=Camp} <br>
     * 陣営
     * @param cdefList The list of classification definition (as ENUM type). (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setCampCode_InScope_AsCamp(Collection<CDef.Camp> cdefList) {
        doSetCampCode_InScope(cTStrL(cdefList));
    }

    protected void doSetCampCode_InScope(Collection<String> campCodeList) {
        regINS(CK_INS, cTL(campCodeList), xgetCValueCampCode(), "CAMP_CODE");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * CAMP_CODE: {PK, NotNull, VARCHAR(20), classification=Camp}
     * @param campCodeList The collection of campCode as notInScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    protected void setCampCode_NotInScope(Collection<String> campCodeList) {
        doSetCampCode_NotInScope(campCodeList);
    }

    /**
     * NotInScope {not in ('a', 'b')}. As Camp. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * CAMP_CODE: {PK, NotNull, VARCHAR(20), classification=Camp} <br>
     * 陣営
     * @param cdefList The list of classification definition (as ENUM type). (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setCampCode_NotInScope_AsCamp(Collection<CDef.Camp> cdefList) {
        doSetCampCode_NotInScope(cTStrL(cdefList));
    }

    protected void doSetCampCode_NotInScope(Collection<String> campCodeList) {
        regINS(CK_NINS, cTL(campCodeList), xgetCValueCampCode(), "CAMP_CODE");
    }

    /**
     * Set up ExistsReferrer (correlated sub-query). <br>
     * {exists (select CAMP_CODE from skill where ...)} <br>
     * skill by CAMP_CODE, named 'skillAsOne'.
     * <pre>
     * cb.query().<span style="color: #CC4747">existsSkill</span>(skillCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     skillCB.query().set...
     * });
     * </pre>
     * @param subCBLambda The callback for sub-query of SkillList for 'exists'. (NotNull)
     */
    public void existsSkill(SubQuery<SkillCB> subCBLambda) {
        assertObjectNotNull("subCBLambda", subCBLambda);
        SkillCB cb = new SkillCB(); cb.xsetupForExistsReferrer(this);
        lockCall(() -> subCBLambda.query(cb)); String pp = keepCampCode_ExistsReferrer_SkillList(cb.query());
        registerExistsReferrer(cb.query(), "CAMP_CODE", "CAMP_CODE", pp, "skillList");
    }
    public abstract String keepCampCode_ExistsReferrer_SkillList(SkillCQ sq);

    /**
     * Set up ExistsReferrer (correlated sub-query). <br>
     * {exists (select WIN_CAMP_CODE from village where ...)} <br>
     * village by WIN_CAMP_CODE, named 'villageAsOne'.
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
        lockCall(() -> subCBLambda.query(cb)); String pp = keepCampCode_ExistsReferrer_VillageList(cb.query());
        registerExistsReferrer(cb.query(), "CAMP_CODE", "WIN_CAMP_CODE", pp, "villageList");
    }
    public abstract String keepCampCode_ExistsReferrer_VillageList(VillageCQ sq);

    /**
     * Set up NotExistsReferrer (correlated sub-query). <br>
     * {not exists (select CAMP_CODE from skill where ...)} <br>
     * skill by CAMP_CODE, named 'skillAsOne'.
     * <pre>
     * cb.query().<span style="color: #CC4747">notExistsSkill</span>(skillCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     skillCB.query().set...
     * });
     * </pre>
     * @param subCBLambda The callback for sub-query of CampCode_NotExistsReferrer_SkillList for 'not exists'. (NotNull)
     */
    public void notExistsSkill(SubQuery<SkillCB> subCBLambda) {
        assertObjectNotNull("subCBLambda", subCBLambda);
        SkillCB cb = new SkillCB(); cb.xsetupForExistsReferrer(this);
        lockCall(() -> subCBLambda.query(cb)); String pp = keepCampCode_NotExistsReferrer_SkillList(cb.query());
        registerNotExistsReferrer(cb.query(), "CAMP_CODE", "CAMP_CODE", pp, "skillList");
    }
    public abstract String keepCampCode_NotExistsReferrer_SkillList(SkillCQ sq);

    /**
     * Set up NotExistsReferrer (correlated sub-query). <br>
     * {not exists (select WIN_CAMP_CODE from village where ...)} <br>
     * village by WIN_CAMP_CODE, named 'villageAsOne'.
     * <pre>
     * cb.query().<span style="color: #CC4747">notExistsVillage</span>(villageCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     villageCB.query().set...
     * });
     * </pre>
     * @param subCBLambda The callback for sub-query of CampCode_NotExistsReferrer_VillageList for 'not exists'. (NotNull)
     */
    public void notExistsVillage(SubQuery<VillageCB> subCBLambda) {
        assertObjectNotNull("subCBLambda", subCBLambda);
        VillageCB cb = new VillageCB(); cb.xsetupForExistsReferrer(this);
        lockCall(() -> subCBLambda.query(cb)); String pp = keepCampCode_NotExistsReferrer_VillageList(cb.query());
        registerNotExistsReferrer(cb.query(), "CAMP_CODE", "WIN_CAMP_CODE", pp, "villageList");
    }
    public abstract String keepCampCode_NotExistsReferrer_VillageList(VillageCQ sq);

    public void xsderiveSkillList(String fn, SubQuery<SkillCB> sq, String al, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        SkillCB cb = new SkillCB(); cb.xsetupForDerivedReferrer(this);
        lockCall(() -> sq.query(cb)); String pp = keepCampCode_SpecifyDerivedReferrer_SkillList(cb.query());
        registerSpecifyDerivedReferrer(fn, cb.query(), "CAMP_CODE", "CAMP_CODE", pp, "skillList", al, op);
    }
    public abstract String keepCampCode_SpecifyDerivedReferrer_SkillList(SkillCQ sq);

    public void xsderiveVillageList(String fn, SubQuery<VillageCB> sq, String al, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        VillageCB cb = new VillageCB(); cb.xsetupForDerivedReferrer(this);
        lockCall(() -> sq.query(cb)); String pp = keepCampCode_SpecifyDerivedReferrer_VillageList(cb.query());
        registerSpecifyDerivedReferrer(fn, cb.query(), "CAMP_CODE", "WIN_CAMP_CODE", pp, "villageList", al, op);
    }
    public abstract String keepCampCode_SpecifyDerivedReferrer_VillageList(VillageCQ sq);

    /**
     * Prepare for (Query)DerivedReferrer (correlated sub-query). <br>
     * {FOO &lt;= (select max(BAR) from skill where ...)} <br>
     * skill by CAMP_CODE, named 'skillAsOne'.
     * <pre>
     * cb.query().<span style="color: #CC4747">derivedSkill()</span>.<span style="color: #CC4747">max</span>(skillCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     skillCB.specify().<span style="color: #CC4747">columnFoo...</span> <span style="color: #3F7E5E">// derived column by function</span>
     *     skillCB.query().setBar... <span style="color: #3F7E5E">// referrer condition</span>
     * }).<span style="color: #CC4747">greaterEqual</span>(123); <span style="color: #3F7E5E">// condition to derived column</span>
     * </pre>
     * @return The object to set up a function for referrer table. (NotNull)
     */
    public HpQDRFunction<SkillCB> derivedSkill() {
        return xcreateQDRFunctionSkillList();
    }
    protected HpQDRFunction<SkillCB> xcreateQDRFunctionSkillList() {
        return xcQDRFunc((fn, sq, rd, vl, op) -> xqderiveSkillList(fn, sq, rd, vl, op));
    }
    public void xqderiveSkillList(String fn, SubQuery<SkillCB> sq, String rd, Object vl, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        SkillCB cb = new SkillCB(); cb.xsetupForDerivedReferrer(this);
        lockCall(() -> sq.query(cb)); String sqpp = keepCampCode_QueryDerivedReferrer_SkillList(cb.query()); String prpp = keepCampCode_QueryDerivedReferrer_SkillListParameter(vl);
        registerQueryDerivedReferrer(fn, cb.query(), "CAMP_CODE", "CAMP_CODE", sqpp, "skillList", rd, vl, prpp, op);
    }
    public abstract String keepCampCode_QueryDerivedReferrer_SkillList(SkillCQ sq);
    public abstract String keepCampCode_QueryDerivedReferrer_SkillListParameter(Object vl);

    /**
     * Prepare for (Query)DerivedReferrer (correlated sub-query). <br>
     * {FOO &lt;= (select max(BAR) from village where ...)} <br>
     * village by WIN_CAMP_CODE, named 'villageAsOne'.
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
        lockCall(() -> sq.query(cb)); String sqpp = keepCampCode_QueryDerivedReferrer_VillageList(cb.query()); String prpp = keepCampCode_QueryDerivedReferrer_VillageListParameter(vl);
        registerQueryDerivedReferrer(fn, cb.query(), "CAMP_CODE", "WIN_CAMP_CODE", sqpp, "villageList", rd, vl, prpp, op);
    }
    public abstract String keepCampCode_QueryDerivedReferrer_VillageList(VillageCQ sq);
    public abstract String keepCampCode_QueryDerivedReferrer_VillageListParameter(Object vl);

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br>
     * CAMP_CODE: {PK, NotNull, VARCHAR(20), classification=Camp}
     */
    public void setCampCode_IsNull() { regCampCode(CK_ISN, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br>
     * CAMP_CODE: {PK, NotNull, VARCHAR(20), classification=Camp}
     */
    public void setCampCode_IsNotNull() { regCampCode(CK_ISNN, DOBJ); }

    protected void regCampCode(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueCampCode(), "CAMP_CODE"); }
    protected abstract ConditionValue xgetCValueCampCode();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * CAMP_NAME: {NotNull, VARCHAR(20)}
     * @param campName The value of campName as equal. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setCampName_Equal(String campName) {
        doSetCampName_Equal(fRES(campName));
    }

    protected void doSetCampName_Equal(String campName) {
        regCampName(CK_EQ, campName);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * CAMP_NAME: {NotNull, VARCHAR(20)}
     * @param campName The value of campName as notEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setCampName_NotEqual(String campName) {
        doSetCampName_NotEqual(fRES(campName));
    }

    protected void doSetCampName_NotEqual(String campName) {
        regCampName(CK_NES, campName);
    }

    /**
     * GreaterThan(&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * CAMP_NAME: {NotNull, VARCHAR(20)}
     * @param campName The value of campName as greaterThan. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setCampName_GreaterThan(String campName) {
        regCampName(CK_GT, fRES(campName));
    }

    /**
     * LessThan(&lt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * CAMP_NAME: {NotNull, VARCHAR(20)}
     * @param campName The value of campName as lessThan. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setCampName_LessThan(String campName) {
        regCampName(CK_LT, fRES(campName));
    }

    /**
     * GreaterEqual(&gt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * CAMP_NAME: {NotNull, VARCHAR(20)}
     * @param campName The value of campName as greaterEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setCampName_GreaterEqual(String campName) {
        regCampName(CK_GE, fRES(campName));
    }

    /**
     * LessEqual(&lt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * CAMP_NAME: {NotNull, VARCHAR(20)}
     * @param campName The value of campName as lessEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setCampName_LessEqual(String campName) {
        regCampName(CK_LE, fRES(campName));
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * CAMP_NAME: {NotNull, VARCHAR(20)}
     * @param campNameList The collection of campName as inScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setCampName_InScope(Collection<String> campNameList) {
        doSetCampName_InScope(campNameList);
    }

    protected void doSetCampName_InScope(Collection<String> campNameList) {
        regINS(CK_INS, cTL(campNameList), xgetCValueCampName(), "CAMP_NAME");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * CAMP_NAME: {NotNull, VARCHAR(20)}
     * @param campNameList The collection of campName as notInScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setCampName_NotInScope(Collection<String> campNameList) {
        doSetCampName_NotInScope(campNameList);
    }

    protected void doSetCampName_NotInScope(Collection<String> campNameList) {
        regINS(CK_NINS, cTL(campNameList), xgetCValueCampName(), "CAMP_NAME");
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * CAMP_NAME: {NotNull, VARCHAR(20)} <br>
     * <pre>e.g. setCampName_LikeSearch("xxx", op <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> op.<span style="color: #CC4747">likeContain()</span>);</pre>
     * @param campName The value of campName as likeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setCampName_LikeSearch(String campName, ConditionOptionCall<LikeSearchOption> opLambda) {
        setCampName_LikeSearch(campName, xcLSOP(opLambda));
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * CAMP_NAME: {NotNull, VARCHAR(20)} <br>
     * <pre>e.g. setCampName_LikeSearch("xxx", new <span style="color: #CC4747">LikeSearchOption</span>().likeContain());</pre>
     * @param campName The value of campName as likeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    protected void setCampName_LikeSearch(String campName, LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(campName), xgetCValueCampName(), "CAMP_NAME", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * CAMP_NAME: {NotNull, VARCHAR(20)}
     * @param campName The value of campName as notLikeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setCampName_NotLikeSearch(String campName, ConditionOptionCall<LikeSearchOption> opLambda) {
        setCampName_NotLikeSearch(campName, xcLSOP(opLambda));
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * CAMP_NAME: {NotNull, VARCHAR(20)}
     * @param campName The value of campName as notLikeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    protected void setCampName_NotLikeSearch(String campName, LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(campName), xgetCValueCampName(), "CAMP_NAME", likeSearchOption);
    }

    protected void regCampName(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueCampName(), "CAMP_NAME"); }
    protected abstract ConditionValue xgetCValueCampName();

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
    public HpSLCFunction<CampCB> scalar_Equal() {
        return xcreateSLCFunction(CK_EQ, CampCB.class);
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
    public HpSLCFunction<CampCB> scalar_NotEqual() {
        return xcreateSLCFunction(CK_NES, CampCB.class);
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
    public HpSLCFunction<CampCB> scalar_GreaterThan() {
        return xcreateSLCFunction(CK_GT, CampCB.class);
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
    public HpSLCFunction<CampCB> scalar_LessThan() {
        return xcreateSLCFunction(CK_LT, CampCB.class);
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
    public HpSLCFunction<CampCB> scalar_GreaterEqual() {
        return xcreateSLCFunction(CK_GE, CampCB.class);
    }

    /**
     * Prepare ScalarCondition as lessEqual. <br>
     * {where FOO &lt;= (select max(BAR) from ...)}
     * <pre>
     * cb.query().<span style="color: #CC4747">scalar_LessEqual()</span>.max(new SubQuery&lt;CampCB&gt;() {
     *     public void query(CampCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSLCFunction<CampCB> scalar_LessEqual() {
        return xcreateSLCFunction(CK_LE, CampCB.class);
    }

    @SuppressWarnings("unchecked")
    protected <CB extends ConditionBean> void xscalarCondition(String fn, SubQuery<CB> sq, String rd, HpSLCCustomized<CB> cs, ScalarConditionOption op) {
        assertObjectNotNull("subQuery", sq);
        CampCB cb = xcreateScalarConditionCB(); sq.query((CB)cb);
        String pp = keepScalarCondition(cb.query()); // for saving query-value
        cs.setPartitionByCBean((CB)xcreateScalarConditionPartitionByCB()); // for using partition-by
        registerScalarCondition(fn, cb.query(), pp, rd, cs, op);
    }
    public abstract String keepScalarCondition(CampCQ sq);

    protected CampCB xcreateScalarConditionCB() {
        CampCB cb = newMyCB(); cb.xsetupForScalarCondition(this); return cb;
    }

    protected CampCB xcreateScalarConditionPartitionByCB() {
        CampCB cb = newMyCB(); cb.xsetupForScalarConditionPartitionBy(this); return cb;
    }

    // ===================================================================================
    //                                                                       MyselfDerived
    //                                                                       =============
    public void xsmyselfDerive(String fn, SubQuery<CampCB> sq, String al, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        CampCB cb = new CampCB(); cb.xsetupForDerivedReferrer(this);
        lockCall(() -> sq.query(cb)); String pp = keepSpecifyMyselfDerived(cb.query()); String pk = "CAMP_CODE";
        registerSpecifyMyselfDerived(fn, cb.query(), pk, pk, pp, "myselfDerived", al, op);
    }
    public abstract String keepSpecifyMyselfDerived(CampCQ sq);

    /**
     * Prepare for (Query)MyselfDerived (correlated sub-query).
     * @return The object to set up a function for myself table. (NotNull)
     */
    public HpQDRFunction<CampCB> myselfDerived() {
        return xcreateQDRFunctionMyselfDerived(CampCB.class);
    }
    @SuppressWarnings("unchecked")
    protected <CB extends ConditionBean> void xqderiveMyselfDerived(String fn, SubQuery<CB> sq, String rd, Object vl, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        CampCB cb = new CampCB(); cb.xsetupForDerivedReferrer(this); sq.query((CB)cb);
        String pk = "CAMP_CODE";
        String sqpp = keepQueryMyselfDerived(cb.query()); // for saving query-value.
        String prpp = keepQueryMyselfDerivedParameter(vl);
        registerQueryMyselfDerived(fn, cb.query(), pk, pk, sqpp, "myselfDerived", rd, vl, prpp, op);
    }
    public abstract String keepQueryMyselfDerived(CampCQ sq);
    public abstract String keepQueryMyselfDerivedParameter(Object vl);

    // ===================================================================================
    //                                                                        MyselfExists
    //                                                                        ============
    /**
     * Prepare for MyselfExists (correlated sub-query).
     * @param subCBLambda The implementation of sub-query. (NotNull)
     */
    public void myselfExists(SubQuery<CampCB> subCBLambda) {
        assertObjectNotNull("subCBLambda", subCBLambda);
        CampCB cb = new CampCB(); cb.xsetupForMyselfExists(this);
        lockCall(() -> subCBLambda.query(cb)); String pp = keepMyselfExists(cb.query());
        registerMyselfExists(cb.query(), pp);
    }
    public abstract String keepMyselfExists(CampCQ sq);

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
    protected CampCB newMyCB() {
        return new CampCB();
    }
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xabUDT() { return Date.class.getName(); }
    protected String xabCQ() { return CampCQ.class.getName(); }
    protected String xabLSO() { return LikeSearchOption.class.getName(); }
    protected String xabSLCS() { return HpSLCSetupper.class.getName(); }
    protected String xabSCP() { return SubQuery.class.getName(); }
}
