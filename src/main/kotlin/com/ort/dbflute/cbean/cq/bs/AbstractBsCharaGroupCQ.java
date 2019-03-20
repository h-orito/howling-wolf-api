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
 * The abstract condition-query of chara_group.
 * @author DBFlute(AutoGenerator)
 */
public abstract class AbstractBsCharaGroupCQ extends AbstractConditionQuery {

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public AbstractBsCharaGroupCQ(ConditionQuery referrerQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
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
        return "chara_group";
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====
    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br>
     * CHARA_GROUP_ID: {PK, ID, NotNull, INT UNSIGNED(10)}
     * @param charaGroupId The value of charaGroupId as equal. (basically NotNull: error as default, or no condition as option)
     */
    public void setCharaGroupId_Equal(Integer charaGroupId) {
        doSetCharaGroupId_Equal(charaGroupId);
    }

    protected void doSetCharaGroupId_Equal(Integer charaGroupId) {
        regCharaGroupId(CK_EQ, charaGroupId);
    }

    /**
     * NotEqual(&lt;&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * CHARA_GROUP_ID: {PK, ID, NotNull, INT UNSIGNED(10)}
     * @param charaGroupId The value of charaGroupId as notEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setCharaGroupId_NotEqual(Integer charaGroupId) {
        doSetCharaGroupId_NotEqual(charaGroupId);
    }

    protected void doSetCharaGroupId_NotEqual(Integer charaGroupId) {
        regCharaGroupId(CK_NES, charaGroupId);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * CHARA_GROUP_ID: {PK, ID, NotNull, INT UNSIGNED(10)}
     * @param charaGroupId The value of charaGroupId as greaterThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setCharaGroupId_GreaterThan(Integer charaGroupId) {
        regCharaGroupId(CK_GT, charaGroupId);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br>
     * CHARA_GROUP_ID: {PK, ID, NotNull, INT UNSIGNED(10)}
     * @param charaGroupId The value of charaGroupId as lessThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setCharaGroupId_LessThan(Integer charaGroupId) {
        regCharaGroupId(CK_LT, charaGroupId);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * CHARA_GROUP_ID: {PK, ID, NotNull, INT UNSIGNED(10)}
     * @param charaGroupId The value of charaGroupId as greaterEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setCharaGroupId_GreaterEqual(Integer charaGroupId) {
        regCharaGroupId(CK_GE, charaGroupId);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * CHARA_GROUP_ID: {PK, ID, NotNull, INT UNSIGNED(10)}
     * @param charaGroupId The value of charaGroupId as lessEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setCharaGroupId_LessEqual(Integer charaGroupId) {
        regCharaGroupId(CK_LE, charaGroupId);
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * CHARA_GROUP_ID: {PK, ID, NotNull, INT UNSIGNED(10)}
     * @param minNumber The min number of charaGroupId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param maxNumber The max number of charaGroupId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param opLambda The callback for option of range-of. (NotNull)
     */
    public void setCharaGroupId_RangeOf(Integer minNumber, Integer maxNumber, ConditionOptionCall<RangeOfOption> opLambda) {
        setCharaGroupId_RangeOf(minNumber, maxNumber, xcROOP(opLambda));
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * CHARA_GROUP_ID: {PK, ID, NotNull, INT UNSIGNED(10)}
     * @param minNumber The min number of charaGroupId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param maxNumber The max number of charaGroupId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    protected void setCharaGroupId_RangeOf(Integer minNumber, Integer maxNumber, RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, xgetCValueCharaGroupId(), "CHARA_GROUP_ID", rangeOfOption);
    }

    /**
     * InScope {in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * CHARA_GROUP_ID: {PK, ID, NotNull, INT UNSIGNED(10)}
     * @param charaGroupIdList The collection of charaGroupId as inScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setCharaGroupId_InScope(Collection<Integer> charaGroupIdList) {
        doSetCharaGroupId_InScope(charaGroupIdList);
    }

    protected void doSetCharaGroupId_InScope(Collection<Integer> charaGroupIdList) {
        regINS(CK_INS, cTL(charaGroupIdList), xgetCValueCharaGroupId(), "CHARA_GROUP_ID");
    }

    /**
     * NotInScope {not in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * CHARA_GROUP_ID: {PK, ID, NotNull, INT UNSIGNED(10)}
     * @param charaGroupIdList The collection of charaGroupId as notInScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setCharaGroupId_NotInScope(Collection<Integer> charaGroupIdList) {
        doSetCharaGroupId_NotInScope(charaGroupIdList);
    }

    protected void doSetCharaGroupId_NotInScope(Collection<Integer> charaGroupIdList) {
        regINS(CK_NINS, cTL(charaGroupIdList), xgetCValueCharaGroupId(), "CHARA_GROUP_ID");
    }

    /**
     * Set up ExistsReferrer (correlated sub-query). <br>
     * {exists (select CHARA_GROUP_ID from chara where ...)} <br>
     * chara by CHARA_GROUP_ID, named 'charaAsOne'.
     * <pre>
     * cb.query().<span style="color: #CC4747">existsChara</span>(charaCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     charaCB.query().set...
     * });
     * </pre>
     * @param subCBLambda The callback for sub-query of CharaList for 'exists'. (NotNull)
     */
    public void existsChara(SubQuery<CharaCB> subCBLambda) {
        assertObjectNotNull("subCBLambda", subCBLambda);
        CharaCB cb = new CharaCB(); cb.xsetupForExistsReferrer(this);
        lockCall(() -> subCBLambda.query(cb)); String pp = keepCharaGroupId_ExistsReferrer_CharaList(cb.query());
        registerExistsReferrer(cb.query(), "CHARA_GROUP_ID", "CHARA_GROUP_ID", pp, "charaList");
    }
    public abstract String keepCharaGroupId_ExistsReferrer_CharaList(CharaCQ sq);

    /**
     * Set up ExistsReferrer (correlated sub-query). <br>
     * {exists (select CHARACTER_GROUP_ID from village_settings where ...)} <br>
     * village_settings by CHARACTER_GROUP_ID, named 'villageSettingsAsOne'.
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
        lockCall(() -> subCBLambda.query(cb)); String pp = keepCharaGroupId_ExistsReferrer_VillageSettingsList(cb.query());
        registerExistsReferrer(cb.query(), "CHARA_GROUP_ID", "CHARACTER_GROUP_ID", pp, "villageSettingsList");
    }
    public abstract String keepCharaGroupId_ExistsReferrer_VillageSettingsList(VillageSettingsCQ sq);

    /**
     * Set up NotExistsReferrer (correlated sub-query). <br>
     * {not exists (select CHARA_GROUP_ID from chara where ...)} <br>
     * chara by CHARA_GROUP_ID, named 'charaAsOne'.
     * <pre>
     * cb.query().<span style="color: #CC4747">notExistsChara</span>(charaCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     charaCB.query().set...
     * });
     * </pre>
     * @param subCBLambda The callback for sub-query of CharaGroupId_NotExistsReferrer_CharaList for 'not exists'. (NotNull)
     */
    public void notExistsChara(SubQuery<CharaCB> subCBLambda) {
        assertObjectNotNull("subCBLambda", subCBLambda);
        CharaCB cb = new CharaCB(); cb.xsetupForExistsReferrer(this);
        lockCall(() -> subCBLambda.query(cb)); String pp = keepCharaGroupId_NotExistsReferrer_CharaList(cb.query());
        registerNotExistsReferrer(cb.query(), "CHARA_GROUP_ID", "CHARA_GROUP_ID", pp, "charaList");
    }
    public abstract String keepCharaGroupId_NotExistsReferrer_CharaList(CharaCQ sq);

    /**
     * Set up NotExistsReferrer (correlated sub-query). <br>
     * {not exists (select CHARACTER_GROUP_ID from village_settings where ...)} <br>
     * village_settings by CHARACTER_GROUP_ID, named 'villageSettingsAsOne'.
     * <pre>
     * cb.query().<span style="color: #CC4747">notExistsVillageSettings</span>(settingsCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     settingsCB.query().set...
     * });
     * </pre>
     * @param subCBLambda The callback for sub-query of CharaGroupId_NotExistsReferrer_VillageSettingsList for 'not exists'. (NotNull)
     */
    public void notExistsVillageSettings(SubQuery<VillageSettingsCB> subCBLambda) {
        assertObjectNotNull("subCBLambda", subCBLambda);
        VillageSettingsCB cb = new VillageSettingsCB(); cb.xsetupForExistsReferrer(this);
        lockCall(() -> subCBLambda.query(cb)); String pp = keepCharaGroupId_NotExistsReferrer_VillageSettingsList(cb.query());
        registerNotExistsReferrer(cb.query(), "CHARA_GROUP_ID", "CHARACTER_GROUP_ID", pp, "villageSettingsList");
    }
    public abstract String keepCharaGroupId_NotExistsReferrer_VillageSettingsList(VillageSettingsCQ sq);

    public void xsderiveCharaList(String fn, SubQuery<CharaCB> sq, String al, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        CharaCB cb = new CharaCB(); cb.xsetupForDerivedReferrer(this);
        lockCall(() -> sq.query(cb)); String pp = keepCharaGroupId_SpecifyDerivedReferrer_CharaList(cb.query());
        registerSpecifyDerivedReferrer(fn, cb.query(), "CHARA_GROUP_ID", "CHARA_GROUP_ID", pp, "charaList", al, op);
    }
    public abstract String keepCharaGroupId_SpecifyDerivedReferrer_CharaList(CharaCQ sq);

    public void xsderiveVillageSettingsList(String fn, SubQuery<VillageSettingsCB> sq, String al, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        VillageSettingsCB cb = new VillageSettingsCB(); cb.xsetupForDerivedReferrer(this);
        lockCall(() -> sq.query(cb)); String pp = keepCharaGroupId_SpecifyDerivedReferrer_VillageSettingsList(cb.query());
        registerSpecifyDerivedReferrer(fn, cb.query(), "CHARA_GROUP_ID", "CHARACTER_GROUP_ID", pp, "villageSettingsList", al, op);
    }
    public abstract String keepCharaGroupId_SpecifyDerivedReferrer_VillageSettingsList(VillageSettingsCQ sq);

    /**
     * Prepare for (Query)DerivedReferrer (correlated sub-query). <br>
     * {FOO &lt;= (select max(BAR) from chara where ...)} <br>
     * chara by CHARA_GROUP_ID, named 'charaAsOne'.
     * <pre>
     * cb.query().<span style="color: #CC4747">derivedChara()</span>.<span style="color: #CC4747">max</span>(charaCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     charaCB.specify().<span style="color: #CC4747">columnFoo...</span> <span style="color: #3F7E5E">// derived column by function</span>
     *     charaCB.query().setBar... <span style="color: #3F7E5E">// referrer condition</span>
     * }).<span style="color: #CC4747">greaterEqual</span>(123); <span style="color: #3F7E5E">// condition to derived column</span>
     * </pre>
     * @return The object to set up a function for referrer table. (NotNull)
     */
    public HpQDRFunction<CharaCB> derivedChara() {
        return xcreateQDRFunctionCharaList();
    }
    protected HpQDRFunction<CharaCB> xcreateQDRFunctionCharaList() {
        return xcQDRFunc((fn, sq, rd, vl, op) -> xqderiveCharaList(fn, sq, rd, vl, op));
    }
    public void xqderiveCharaList(String fn, SubQuery<CharaCB> sq, String rd, Object vl, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        CharaCB cb = new CharaCB(); cb.xsetupForDerivedReferrer(this);
        lockCall(() -> sq.query(cb)); String sqpp = keepCharaGroupId_QueryDerivedReferrer_CharaList(cb.query()); String prpp = keepCharaGroupId_QueryDerivedReferrer_CharaListParameter(vl);
        registerQueryDerivedReferrer(fn, cb.query(), "CHARA_GROUP_ID", "CHARA_GROUP_ID", sqpp, "charaList", rd, vl, prpp, op);
    }
    public abstract String keepCharaGroupId_QueryDerivedReferrer_CharaList(CharaCQ sq);
    public abstract String keepCharaGroupId_QueryDerivedReferrer_CharaListParameter(Object vl);

    /**
     * Prepare for (Query)DerivedReferrer (correlated sub-query). <br>
     * {FOO &lt;= (select max(BAR) from village_settings where ...)} <br>
     * village_settings by CHARACTER_GROUP_ID, named 'villageSettingsAsOne'.
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
        lockCall(() -> sq.query(cb)); String sqpp = keepCharaGroupId_QueryDerivedReferrer_VillageSettingsList(cb.query()); String prpp = keepCharaGroupId_QueryDerivedReferrer_VillageSettingsListParameter(vl);
        registerQueryDerivedReferrer(fn, cb.query(), "CHARA_GROUP_ID", "CHARACTER_GROUP_ID", sqpp, "villageSettingsList", rd, vl, prpp, op);
    }
    public abstract String keepCharaGroupId_QueryDerivedReferrer_VillageSettingsList(VillageSettingsCQ sq);
    public abstract String keepCharaGroupId_QueryDerivedReferrer_VillageSettingsListParameter(Object vl);

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br>
     * CHARA_GROUP_ID: {PK, ID, NotNull, INT UNSIGNED(10)}
     */
    public void setCharaGroupId_IsNull() { regCharaGroupId(CK_ISN, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br>
     * CHARA_GROUP_ID: {PK, ID, NotNull, INT UNSIGNED(10)}
     */
    public void setCharaGroupId_IsNotNull() { regCharaGroupId(CK_ISNN, DOBJ); }

    protected void regCharaGroupId(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueCharaGroupId(), "CHARA_GROUP_ID"); }
    protected abstract ConditionValue xgetCValueCharaGroupId();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * CHARA_GROUP_NAME: {NotNull, VARCHAR(40)}
     * @param charaGroupName The value of charaGroupName as equal. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setCharaGroupName_Equal(String charaGroupName) {
        doSetCharaGroupName_Equal(fRES(charaGroupName));
    }

    protected void doSetCharaGroupName_Equal(String charaGroupName) {
        regCharaGroupName(CK_EQ, charaGroupName);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * CHARA_GROUP_NAME: {NotNull, VARCHAR(40)}
     * @param charaGroupName The value of charaGroupName as notEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setCharaGroupName_NotEqual(String charaGroupName) {
        doSetCharaGroupName_NotEqual(fRES(charaGroupName));
    }

    protected void doSetCharaGroupName_NotEqual(String charaGroupName) {
        regCharaGroupName(CK_NES, charaGroupName);
    }

    /**
     * GreaterThan(&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * CHARA_GROUP_NAME: {NotNull, VARCHAR(40)}
     * @param charaGroupName The value of charaGroupName as greaterThan. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setCharaGroupName_GreaterThan(String charaGroupName) {
        regCharaGroupName(CK_GT, fRES(charaGroupName));
    }

    /**
     * LessThan(&lt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * CHARA_GROUP_NAME: {NotNull, VARCHAR(40)}
     * @param charaGroupName The value of charaGroupName as lessThan. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setCharaGroupName_LessThan(String charaGroupName) {
        regCharaGroupName(CK_LT, fRES(charaGroupName));
    }

    /**
     * GreaterEqual(&gt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * CHARA_GROUP_NAME: {NotNull, VARCHAR(40)}
     * @param charaGroupName The value of charaGroupName as greaterEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setCharaGroupName_GreaterEqual(String charaGroupName) {
        regCharaGroupName(CK_GE, fRES(charaGroupName));
    }

    /**
     * LessEqual(&lt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * CHARA_GROUP_NAME: {NotNull, VARCHAR(40)}
     * @param charaGroupName The value of charaGroupName as lessEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setCharaGroupName_LessEqual(String charaGroupName) {
        regCharaGroupName(CK_LE, fRES(charaGroupName));
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * CHARA_GROUP_NAME: {NotNull, VARCHAR(40)}
     * @param charaGroupNameList The collection of charaGroupName as inScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setCharaGroupName_InScope(Collection<String> charaGroupNameList) {
        doSetCharaGroupName_InScope(charaGroupNameList);
    }

    protected void doSetCharaGroupName_InScope(Collection<String> charaGroupNameList) {
        regINS(CK_INS, cTL(charaGroupNameList), xgetCValueCharaGroupName(), "CHARA_GROUP_NAME");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * CHARA_GROUP_NAME: {NotNull, VARCHAR(40)}
     * @param charaGroupNameList The collection of charaGroupName as notInScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setCharaGroupName_NotInScope(Collection<String> charaGroupNameList) {
        doSetCharaGroupName_NotInScope(charaGroupNameList);
    }

    protected void doSetCharaGroupName_NotInScope(Collection<String> charaGroupNameList) {
        regINS(CK_NINS, cTL(charaGroupNameList), xgetCValueCharaGroupName(), "CHARA_GROUP_NAME");
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * CHARA_GROUP_NAME: {NotNull, VARCHAR(40)} <br>
     * <pre>e.g. setCharaGroupName_LikeSearch("xxx", op <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> op.<span style="color: #CC4747">likeContain()</span>);</pre>
     * @param charaGroupName The value of charaGroupName as likeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setCharaGroupName_LikeSearch(String charaGroupName, ConditionOptionCall<LikeSearchOption> opLambda) {
        setCharaGroupName_LikeSearch(charaGroupName, xcLSOP(opLambda));
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * CHARA_GROUP_NAME: {NotNull, VARCHAR(40)} <br>
     * <pre>e.g. setCharaGroupName_LikeSearch("xxx", new <span style="color: #CC4747">LikeSearchOption</span>().likeContain());</pre>
     * @param charaGroupName The value of charaGroupName as likeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    protected void setCharaGroupName_LikeSearch(String charaGroupName, LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(charaGroupName), xgetCValueCharaGroupName(), "CHARA_GROUP_NAME", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * CHARA_GROUP_NAME: {NotNull, VARCHAR(40)}
     * @param charaGroupName The value of charaGroupName as notLikeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setCharaGroupName_NotLikeSearch(String charaGroupName, ConditionOptionCall<LikeSearchOption> opLambda) {
        setCharaGroupName_NotLikeSearch(charaGroupName, xcLSOP(opLambda));
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * CHARA_GROUP_NAME: {NotNull, VARCHAR(40)}
     * @param charaGroupName The value of charaGroupName as notLikeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    protected void setCharaGroupName_NotLikeSearch(String charaGroupName, LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(charaGroupName), xgetCValueCharaGroupName(), "CHARA_GROUP_NAME", likeSearchOption);
    }

    protected void regCharaGroupName(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueCharaGroupName(), "CHARA_GROUP_NAME"); }
    protected abstract ConditionValue xgetCValueCharaGroupName();

    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br>
     * DESIGNER_ID: {IX, NotNull, INT UNSIGNED(10), FK to designer}
     * @param designerId The value of designerId as equal. (basically NotNull: error as default, or no condition as option)
     */
    public void setDesignerId_Equal(Integer designerId) {
        doSetDesignerId_Equal(designerId);
    }

    protected void doSetDesignerId_Equal(Integer designerId) {
        regDesignerId(CK_EQ, designerId);
    }

    /**
     * NotEqual(&lt;&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * DESIGNER_ID: {IX, NotNull, INT UNSIGNED(10), FK to designer}
     * @param designerId The value of designerId as notEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setDesignerId_NotEqual(Integer designerId) {
        doSetDesignerId_NotEqual(designerId);
    }

    protected void doSetDesignerId_NotEqual(Integer designerId) {
        regDesignerId(CK_NES, designerId);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * DESIGNER_ID: {IX, NotNull, INT UNSIGNED(10), FK to designer}
     * @param designerId The value of designerId as greaterThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setDesignerId_GreaterThan(Integer designerId) {
        regDesignerId(CK_GT, designerId);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br>
     * DESIGNER_ID: {IX, NotNull, INT UNSIGNED(10), FK to designer}
     * @param designerId The value of designerId as lessThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setDesignerId_LessThan(Integer designerId) {
        regDesignerId(CK_LT, designerId);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * DESIGNER_ID: {IX, NotNull, INT UNSIGNED(10), FK to designer}
     * @param designerId The value of designerId as greaterEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setDesignerId_GreaterEqual(Integer designerId) {
        regDesignerId(CK_GE, designerId);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * DESIGNER_ID: {IX, NotNull, INT UNSIGNED(10), FK to designer}
     * @param designerId The value of designerId as lessEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setDesignerId_LessEqual(Integer designerId) {
        regDesignerId(CK_LE, designerId);
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * DESIGNER_ID: {IX, NotNull, INT UNSIGNED(10), FK to designer}
     * @param minNumber The min number of designerId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param maxNumber The max number of designerId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param opLambda The callback for option of range-of. (NotNull)
     */
    public void setDesignerId_RangeOf(Integer minNumber, Integer maxNumber, ConditionOptionCall<RangeOfOption> opLambda) {
        setDesignerId_RangeOf(minNumber, maxNumber, xcROOP(opLambda));
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * DESIGNER_ID: {IX, NotNull, INT UNSIGNED(10), FK to designer}
     * @param minNumber The min number of designerId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param maxNumber The max number of designerId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    protected void setDesignerId_RangeOf(Integer minNumber, Integer maxNumber, RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, xgetCValueDesignerId(), "DESIGNER_ID", rangeOfOption);
    }

    /**
     * InScope {in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * DESIGNER_ID: {IX, NotNull, INT UNSIGNED(10), FK to designer}
     * @param designerIdList The collection of designerId as inScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setDesignerId_InScope(Collection<Integer> designerIdList) {
        doSetDesignerId_InScope(designerIdList);
    }

    protected void doSetDesignerId_InScope(Collection<Integer> designerIdList) {
        regINS(CK_INS, cTL(designerIdList), xgetCValueDesignerId(), "DESIGNER_ID");
    }

    /**
     * NotInScope {not in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * DESIGNER_ID: {IX, NotNull, INT UNSIGNED(10), FK to designer}
     * @param designerIdList The collection of designerId as notInScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setDesignerId_NotInScope(Collection<Integer> designerIdList) {
        doSetDesignerId_NotInScope(designerIdList);
    }

    protected void doSetDesignerId_NotInScope(Collection<Integer> designerIdList) {
        regINS(CK_NINS, cTL(designerIdList), xgetCValueDesignerId(), "DESIGNER_ID");
    }

    protected void regDesignerId(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueDesignerId(), "DESIGNER_ID"); }
    protected abstract ConditionValue xgetCValueDesignerId();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * DESCRIPTION_URL: {TEXT(65535)}
     * @param descriptionUrl The value of descriptionUrl as equal. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setDescriptionUrl_Equal(String descriptionUrl) {
        doSetDescriptionUrl_Equal(fRES(descriptionUrl));
    }

    protected void doSetDescriptionUrl_Equal(String descriptionUrl) {
        regDescriptionUrl(CK_EQ, descriptionUrl);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * DESCRIPTION_URL: {TEXT(65535)}
     * @param descriptionUrl The value of descriptionUrl as notEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setDescriptionUrl_NotEqual(String descriptionUrl) {
        doSetDescriptionUrl_NotEqual(fRES(descriptionUrl));
    }

    protected void doSetDescriptionUrl_NotEqual(String descriptionUrl) {
        regDescriptionUrl(CK_NES, descriptionUrl);
    }

    /**
     * GreaterThan(&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * DESCRIPTION_URL: {TEXT(65535)}
     * @param descriptionUrl The value of descriptionUrl as greaterThan. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setDescriptionUrl_GreaterThan(String descriptionUrl) {
        regDescriptionUrl(CK_GT, fRES(descriptionUrl));
    }

    /**
     * LessThan(&lt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * DESCRIPTION_URL: {TEXT(65535)}
     * @param descriptionUrl The value of descriptionUrl as lessThan. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setDescriptionUrl_LessThan(String descriptionUrl) {
        regDescriptionUrl(CK_LT, fRES(descriptionUrl));
    }

    /**
     * GreaterEqual(&gt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * DESCRIPTION_URL: {TEXT(65535)}
     * @param descriptionUrl The value of descriptionUrl as greaterEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setDescriptionUrl_GreaterEqual(String descriptionUrl) {
        regDescriptionUrl(CK_GE, fRES(descriptionUrl));
    }

    /**
     * LessEqual(&lt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * DESCRIPTION_URL: {TEXT(65535)}
     * @param descriptionUrl The value of descriptionUrl as lessEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setDescriptionUrl_LessEqual(String descriptionUrl) {
        regDescriptionUrl(CK_LE, fRES(descriptionUrl));
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * DESCRIPTION_URL: {TEXT(65535)}
     * @param descriptionUrlList The collection of descriptionUrl as inScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setDescriptionUrl_InScope(Collection<String> descriptionUrlList) {
        doSetDescriptionUrl_InScope(descriptionUrlList);
    }

    protected void doSetDescriptionUrl_InScope(Collection<String> descriptionUrlList) {
        regINS(CK_INS, cTL(descriptionUrlList), xgetCValueDescriptionUrl(), "DESCRIPTION_URL");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * DESCRIPTION_URL: {TEXT(65535)}
     * @param descriptionUrlList The collection of descriptionUrl as notInScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setDescriptionUrl_NotInScope(Collection<String> descriptionUrlList) {
        doSetDescriptionUrl_NotInScope(descriptionUrlList);
    }

    protected void doSetDescriptionUrl_NotInScope(Collection<String> descriptionUrlList) {
        regINS(CK_NINS, cTL(descriptionUrlList), xgetCValueDescriptionUrl(), "DESCRIPTION_URL");
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * DESCRIPTION_URL: {TEXT(65535)} <br>
     * <pre>e.g. setDescriptionUrl_LikeSearch("xxx", op <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> op.<span style="color: #CC4747">likeContain()</span>);</pre>
     * @param descriptionUrl The value of descriptionUrl as likeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setDescriptionUrl_LikeSearch(String descriptionUrl, ConditionOptionCall<LikeSearchOption> opLambda) {
        setDescriptionUrl_LikeSearch(descriptionUrl, xcLSOP(opLambda));
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * DESCRIPTION_URL: {TEXT(65535)} <br>
     * <pre>e.g. setDescriptionUrl_LikeSearch("xxx", new <span style="color: #CC4747">LikeSearchOption</span>().likeContain());</pre>
     * @param descriptionUrl The value of descriptionUrl as likeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    protected void setDescriptionUrl_LikeSearch(String descriptionUrl, LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(descriptionUrl), xgetCValueDescriptionUrl(), "DESCRIPTION_URL", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * DESCRIPTION_URL: {TEXT(65535)}
     * @param descriptionUrl The value of descriptionUrl as notLikeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setDescriptionUrl_NotLikeSearch(String descriptionUrl, ConditionOptionCall<LikeSearchOption> opLambda) {
        setDescriptionUrl_NotLikeSearch(descriptionUrl, xcLSOP(opLambda));
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * DESCRIPTION_URL: {TEXT(65535)}
     * @param descriptionUrl The value of descriptionUrl as notLikeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    protected void setDescriptionUrl_NotLikeSearch(String descriptionUrl, LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(descriptionUrl), xgetCValueDescriptionUrl(), "DESCRIPTION_URL", likeSearchOption);
    }

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br>
     * DESCRIPTION_URL: {TEXT(65535)}
     */
    public void setDescriptionUrl_IsNull() { regDescriptionUrl(CK_ISN, DOBJ); }

    /**
     * IsNullOrEmpty {is null or empty}. And OnlyOnceRegistered. <br>
     * DESCRIPTION_URL: {TEXT(65535)}
     */
    public void setDescriptionUrl_IsNullOrEmpty() { regDescriptionUrl(CK_ISNOE, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br>
     * DESCRIPTION_URL: {TEXT(65535)}
     */
    public void setDescriptionUrl_IsNotNull() { regDescriptionUrl(CK_ISNN, DOBJ); }

    protected void regDescriptionUrl(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueDescriptionUrl(), "DESCRIPTION_URL"); }
    protected abstract ConditionValue xgetCValueDescriptionUrl();

    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br>
     * REGISTER_DATETIME: {NotNull, DATETIME(19)}
     * @param registerDatetime The value of registerDatetime as equal. (basically NotNull: error as default, or no condition as option)
     */
    public void setRegisterDatetime_Equal(java.time.LocalDateTime registerDatetime) {
        regRegisterDatetime(CK_EQ,  registerDatetime);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * REGISTER_DATETIME: {NotNull, DATETIME(19)}
     * @param registerDatetime The value of registerDatetime as greaterThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setRegisterDatetime_GreaterThan(java.time.LocalDateTime registerDatetime) {
        regRegisterDatetime(CK_GT,  registerDatetime);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br>
     * REGISTER_DATETIME: {NotNull, DATETIME(19)}
     * @param registerDatetime The value of registerDatetime as lessThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setRegisterDatetime_LessThan(java.time.LocalDateTime registerDatetime) {
        regRegisterDatetime(CK_LT,  registerDatetime);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * REGISTER_DATETIME: {NotNull, DATETIME(19)}
     * @param registerDatetime The value of registerDatetime as greaterEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setRegisterDatetime_GreaterEqual(java.time.LocalDateTime registerDatetime) {
        regRegisterDatetime(CK_GE,  registerDatetime);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * REGISTER_DATETIME: {NotNull, DATETIME(19)}
     * @param registerDatetime The value of registerDatetime as lessEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setRegisterDatetime_LessEqual(java.time.LocalDateTime registerDatetime) {
        regRegisterDatetime(CK_LE, registerDatetime);
    }

    /**
     * FromTo with various options. (versatile) {(default) fromDatetime &lt;= column &lt;= toDatetime} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * REGISTER_DATETIME: {NotNull, DATETIME(19)}
     * <pre>e.g. setRegisterDatetime_FromTo(fromDate, toDate, op <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> op.<span style="color: #CC4747">compareAsDate()</span>);</pre>
     * @param fromDatetime The from-datetime(yyyy/MM/dd HH:mm:ss.SSS) of registerDatetime. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param toDatetime The to-datetime(yyyy/MM/dd HH:mm:ss.SSS) of registerDatetime. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param opLambda The callback for option of from-to. (NotNull)
     */
    public void setRegisterDatetime_FromTo(java.time.LocalDateTime fromDatetime, java.time.LocalDateTime toDatetime, ConditionOptionCall<FromToOption> opLambda) {
        setRegisterDatetime_FromTo(fromDatetime, toDatetime, xcFTOP(opLambda));
    }

    /**
     * FromTo with various options. (versatile) {(default) fromDatetime &lt;= column &lt;= toDatetime} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * REGISTER_DATETIME: {NotNull, DATETIME(19)}
     * <pre>e.g. setRegisterDatetime_FromTo(fromDate, toDate, new <span style="color: #CC4747">FromToOption</span>().compareAsDate());</pre>
     * @param fromDatetime The from-datetime(yyyy/MM/dd HH:mm:ss.SSS) of registerDatetime. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param toDatetime The to-datetime(yyyy/MM/dd HH:mm:ss.SSS) of registerDatetime. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param fromToOption The option of from-to. (NotNull)
     */
    protected void setRegisterDatetime_FromTo(java.time.LocalDateTime fromDatetime, java.time.LocalDateTime toDatetime, FromToOption fromToOption) {
        String nm = "REGISTER_DATETIME"; FromToOption op = fromToOption;
        regFTQ(xfFTHD(fromDatetime, nm, op), xfFTHD(toDatetime, nm, op), xgetCValueRegisterDatetime(), nm, op);
    }

    protected void regRegisterDatetime(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueRegisterDatetime(), "REGISTER_DATETIME"); }
    protected abstract ConditionValue xgetCValueRegisterDatetime();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * REGISTER_TRACE: {NotNull, VARCHAR(64)}
     * @param registerTrace The value of registerTrace as equal. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setRegisterTrace_Equal(String registerTrace) {
        doSetRegisterTrace_Equal(fRES(registerTrace));
    }

    protected void doSetRegisterTrace_Equal(String registerTrace) {
        regRegisterTrace(CK_EQ, registerTrace);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * REGISTER_TRACE: {NotNull, VARCHAR(64)}
     * @param registerTrace The value of registerTrace as notEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setRegisterTrace_NotEqual(String registerTrace) {
        doSetRegisterTrace_NotEqual(fRES(registerTrace));
    }

    protected void doSetRegisterTrace_NotEqual(String registerTrace) {
        regRegisterTrace(CK_NES, registerTrace);
    }

    /**
     * GreaterThan(&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * REGISTER_TRACE: {NotNull, VARCHAR(64)}
     * @param registerTrace The value of registerTrace as greaterThan. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setRegisterTrace_GreaterThan(String registerTrace) {
        regRegisterTrace(CK_GT, fRES(registerTrace));
    }

    /**
     * LessThan(&lt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * REGISTER_TRACE: {NotNull, VARCHAR(64)}
     * @param registerTrace The value of registerTrace as lessThan. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setRegisterTrace_LessThan(String registerTrace) {
        regRegisterTrace(CK_LT, fRES(registerTrace));
    }

    /**
     * GreaterEqual(&gt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * REGISTER_TRACE: {NotNull, VARCHAR(64)}
     * @param registerTrace The value of registerTrace as greaterEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setRegisterTrace_GreaterEqual(String registerTrace) {
        regRegisterTrace(CK_GE, fRES(registerTrace));
    }

    /**
     * LessEqual(&lt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * REGISTER_TRACE: {NotNull, VARCHAR(64)}
     * @param registerTrace The value of registerTrace as lessEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setRegisterTrace_LessEqual(String registerTrace) {
        regRegisterTrace(CK_LE, fRES(registerTrace));
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * REGISTER_TRACE: {NotNull, VARCHAR(64)}
     * @param registerTraceList The collection of registerTrace as inScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setRegisterTrace_InScope(Collection<String> registerTraceList) {
        doSetRegisterTrace_InScope(registerTraceList);
    }

    protected void doSetRegisterTrace_InScope(Collection<String> registerTraceList) {
        regINS(CK_INS, cTL(registerTraceList), xgetCValueRegisterTrace(), "REGISTER_TRACE");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * REGISTER_TRACE: {NotNull, VARCHAR(64)}
     * @param registerTraceList The collection of registerTrace as notInScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setRegisterTrace_NotInScope(Collection<String> registerTraceList) {
        doSetRegisterTrace_NotInScope(registerTraceList);
    }

    protected void doSetRegisterTrace_NotInScope(Collection<String> registerTraceList) {
        regINS(CK_NINS, cTL(registerTraceList), xgetCValueRegisterTrace(), "REGISTER_TRACE");
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * REGISTER_TRACE: {NotNull, VARCHAR(64)} <br>
     * <pre>e.g. setRegisterTrace_LikeSearch("xxx", op <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> op.<span style="color: #CC4747">likeContain()</span>);</pre>
     * @param registerTrace The value of registerTrace as likeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setRegisterTrace_LikeSearch(String registerTrace, ConditionOptionCall<LikeSearchOption> opLambda) {
        setRegisterTrace_LikeSearch(registerTrace, xcLSOP(opLambda));
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * REGISTER_TRACE: {NotNull, VARCHAR(64)} <br>
     * <pre>e.g. setRegisterTrace_LikeSearch("xxx", new <span style="color: #CC4747">LikeSearchOption</span>().likeContain());</pre>
     * @param registerTrace The value of registerTrace as likeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    protected void setRegisterTrace_LikeSearch(String registerTrace, LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(registerTrace), xgetCValueRegisterTrace(), "REGISTER_TRACE", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * REGISTER_TRACE: {NotNull, VARCHAR(64)}
     * @param registerTrace The value of registerTrace as notLikeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setRegisterTrace_NotLikeSearch(String registerTrace, ConditionOptionCall<LikeSearchOption> opLambda) {
        setRegisterTrace_NotLikeSearch(registerTrace, xcLSOP(opLambda));
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * REGISTER_TRACE: {NotNull, VARCHAR(64)}
     * @param registerTrace The value of registerTrace as notLikeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    protected void setRegisterTrace_NotLikeSearch(String registerTrace, LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(registerTrace), xgetCValueRegisterTrace(), "REGISTER_TRACE", likeSearchOption);
    }

    protected void regRegisterTrace(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueRegisterTrace(), "REGISTER_TRACE"); }
    protected abstract ConditionValue xgetCValueRegisterTrace();

    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br>
     * UPDATE_DATETIME: {NotNull, DATETIME(19)}
     * @param updateDatetime The value of updateDatetime as equal. (basically NotNull: error as default, or no condition as option)
     */
    public void setUpdateDatetime_Equal(java.time.LocalDateTime updateDatetime) {
        regUpdateDatetime(CK_EQ,  updateDatetime);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * UPDATE_DATETIME: {NotNull, DATETIME(19)}
     * @param updateDatetime The value of updateDatetime as greaterThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setUpdateDatetime_GreaterThan(java.time.LocalDateTime updateDatetime) {
        regUpdateDatetime(CK_GT,  updateDatetime);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br>
     * UPDATE_DATETIME: {NotNull, DATETIME(19)}
     * @param updateDatetime The value of updateDatetime as lessThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setUpdateDatetime_LessThan(java.time.LocalDateTime updateDatetime) {
        regUpdateDatetime(CK_LT,  updateDatetime);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * UPDATE_DATETIME: {NotNull, DATETIME(19)}
     * @param updateDatetime The value of updateDatetime as greaterEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setUpdateDatetime_GreaterEqual(java.time.LocalDateTime updateDatetime) {
        regUpdateDatetime(CK_GE,  updateDatetime);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * UPDATE_DATETIME: {NotNull, DATETIME(19)}
     * @param updateDatetime The value of updateDatetime as lessEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setUpdateDatetime_LessEqual(java.time.LocalDateTime updateDatetime) {
        regUpdateDatetime(CK_LE, updateDatetime);
    }

    /**
     * FromTo with various options. (versatile) {(default) fromDatetime &lt;= column &lt;= toDatetime} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * UPDATE_DATETIME: {NotNull, DATETIME(19)}
     * <pre>e.g. setUpdateDatetime_FromTo(fromDate, toDate, op <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> op.<span style="color: #CC4747">compareAsDate()</span>);</pre>
     * @param fromDatetime The from-datetime(yyyy/MM/dd HH:mm:ss.SSS) of updateDatetime. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param toDatetime The to-datetime(yyyy/MM/dd HH:mm:ss.SSS) of updateDatetime. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param opLambda The callback for option of from-to. (NotNull)
     */
    public void setUpdateDatetime_FromTo(java.time.LocalDateTime fromDatetime, java.time.LocalDateTime toDatetime, ConditionOptionCall<FromToOption> opLambda) {
        setUpdateDatetime_FromTo(fromDatetime, toDatetime, xcFTOP(opLambda));
    }

    /**
     * FromTo with various options. (versatile) {(default) fromDatetime &lt;= column &lt;= toDatetime} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * UPDATE_DATETIME: {NotNull, DATETIME(19)}
     * <pre>e.g. setUpdateDatetime_FromTo(fromDate, toDate, new <span style="color: #CC4747">FromToOption</span>().compareAsDate());</pre>
     * @param fromDatetime The from-datetime(yyyy/MM/dd HH:mm:ss.SSS) of updateDatetime. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param toDatetime The to-datetime(yyyy/MM/dd HH:mm:ss.SSS) of updateDatetime. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param fromToOption The option of from-to. (NotNull)
     */
    protected void setUpdateDatetime_FromTo(java.time.LocalDateTime fromDatetime, java.time.LocalDateTime toDatetime, FromToOption fromToOption) {
        String nm = "UPDATE_DATETIME"; FromToOption op = fromToOption;
        regFTQ(xfFTHD(fromDatetime, nm, op), xfFTHD(toDatetime, nm, op), xgetCValueUpdateDatetime(), nm, op);
    }

    protected void regUpdateDatetime(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueUpdateDatetime(), "UPDATE_DATETIME"); }
    protected abstract ConditionValue xgetCValueUpdateDatetime();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * UPDATE_TRACE: {NotNull, VARCHAR(64)}
     * @param updateTrace The value of updateTrace as equal. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setUpdateTrace_Equal(String updateTrace) {
        doSetUpdateTrace_Equal(fRES(updateTrace));
    }

    protected void doSetUpdateTrace_Equal(String updateTrace) {
        regUpdateTrace(CK_EQ, updateTrace);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * UPDATE_TRACE: {NotNull, VARCHAR(64)}
     * @param updateTrace The value of updateTrace as notEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setUpdateTrace_NotEqual(String updateTrace) {
        doSetUpdateTrace_NotEqual(fRES(updateTrace));
    }

    protected void doSetUpdateTrace_NotEqual(String updateTrace) {
        regUpdateTrace(CK_NES, updateTrace);
    }

    /**
     * GreaterThan(&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * UPDATE_TRACE: {NotNull, VARCHAR(64)}
     * @param updateTrace The value of updateTrace as greaterThan. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setUpdateTrace_GreaterThan(String updateTrace) {
        regUpdateTrace(CK_GT, fRES(updateTrace));
    }

    /**
     * LessThan(&lt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * UPDATE_TRACE: {NotNull, VARCHAR(64)}
     * @param updateTrace The value of updateTrace as lessThan. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setUpdateTrace_LessThan(String updateTrace) {
        regUpdateTrace(CK_LT, fRES(updateTrace));
    }

    /**
     * GreaterEqual(&gt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * UPDATE_TRACE: {NotNull, VARCHAR(64)}
     * @param updateTrace The value of updateTrace as greaterEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setUpdateTrace_GreaterEqual(String updateTrace) {
        regUpdateTrace(CK_GE, fRES(updateTrace));
    }

    /**
     * LessEqual(&lt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * UPDATE_TRACE: {NotNull, VARCHAR(64)}
     * @param updateTrace The value of updateTrace as lessEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setUpdateTrace_LessEqual(String updateTrace) {
        regUpdateTrace(CK_LE, fRES(updateTrace));
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * UPDATE_TRACE: {NotNull, VARCHAR(64)}
     * @param updateTraceList The collection of updateTrace as inScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setUpdateTrace_InScope(Collection<String> updateTraceList) {
        doSetUpdateTrace_InScope(updateTraceList);
    }

    protected void doSetUpdateTrace_InScope(Collection<String> updateTraceList) {
        regINS(CK_INS, cTL(updateTraceList), xgetCValueUpdateTrace(), "UPDATE_TRACE");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * UPDATE_TRACE: {NotNull, VARCHAR(64)}
     * @param updateTraceList The collection of updateTrace as notInScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setUpdateTrace_NotInScope(Collection<String> updateTraceList) {
        doSetUpdateTrace_NotInScope(updateTraceList);
    }

    protected void doSetUpdateTrace_NotInScope(Collection<String> updateTraceList) {
        regINS(CK_NINS, cTL(updateTraceList), xgetCValueUpdateTrace(), "UPDATE_TRACE");
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * UPDATE_TRACE: {NotNull, VARCHAR(64)} <br>
     * <pre>e.g. setUpdateTrace_LikeSearch("xxx", op <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> op.<span style="color: #CC4747">likeContain()</span>);</pre>
     * @param updateTrace The value of updateTrace as likeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setUpdateTrace_LikeSearch(String updateTrace, ConditionOptionCall<LikeSearchOption> opLambda) {
        setUpdateTrace_LikeSearch(updateTrace, xcLSOP(opLambda));
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * UPDATE_TRACE: {NotNull, VARCHAR(64)} <br>
     * <pre>e.g. setUpdateTrace_LikeSearch("xxx", new <span style="color: #CC4747">LikeSearchOption</span>().likeContain());</pre>
     * @param updateTrace The value of updateTrace as likeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    protected void setUpdateTrace_LikeSearch(String updateTrace, LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(updateTrace), xgetCValueUpdateTrace(), "UPDATE_TRACE", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * UPDATE_TRACE: {NotNull, VARCHAR(64)}
     * @param updateTrace The value of updateTrace as notLikeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setUpdateTrace_NotLikeSearch(String updateTrace, ConditionOptionCall<LikeSearchOption> opLambda) {
        setUpdateTrace_NotLikeSearch(updateTrace, xcLSOP(opLambda));
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * UPDATE_TRACE: {NotNull, VARCHAR(64)}
     * @param updateTrace The value of updateTrace as notLikeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    protected void setUpdateTrace_NotLikeSearch(String updateTrace, LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(updateTrace), xgetCValueUpdateTrace(), "UPDATE_TRACE", likeSearchOption);
    }

    protected void regUpdateTrace(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueUpdateTrace(), "UPDATE_TRACE"); }
    protected abstract ConditionValue xgetCValueUpdateTrace();

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
    public HpSLCFunction<CharaGroupCB> scalar_Equal() {
        return xcreateSLCFunction(CK_EQ, CharaGroupCB.class);
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
    public HpSLCFunction<CharaGroupCB> scalar_NotEqual() {
        return xcreateSLCFunction(CK_NES, CharaGroupCB.class);
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
    public HpSLCFunction<CharaGroupCB> scalar_GreaterThan() {
        return xcreateSLCFunction(CK_GT, CharaGroupCB.class);
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
    public HpSLCFunction<CharaGroupCB> scalar_LessThan() {
        return xcreateSLCFunction(CK_LT, CharaGroupCB.class);
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
    public HpSLCFunction<CharaGroupCB> scalar_GreaterEqual() {
        return xcreateSLCFunction(CK_GE, CharaGroupCB.class);
    }

    /**
     * Prepare ScalarCondition as lessEqual. <br>
     * {where FOO &lt;= (select max(BAR) from ...)}
     * <pre>
     * cb.query().<span style="color: #CC4747">scalar_LessEqual()</span>.max(new SubQuery&lt;CharaGroupCB&gt;() {
     *     public void query(CharaGroupCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSLCFunction<CharaGroupCB> scalar_LessEqual() {
        return xcreateSLCFunction(CK_LE, CharaGroupCB.class);
    }

    @SuppressWarnings("unchecked")
    protected <CB extends ConditionBean> void xscalarCondition(String fn, SubQuery<CB> sq, String rd, HpSLCCustomized<CB> cs, ScalarConditionOption op) {
        assertObjectNotNull("subQuery", sq);
        CharaGroupCB cb = xcreateScalarConditionCB(); sq.query((CB)cb);
        String pp = keepScalarCondition(cb.query()); // for saving query-value
        cs.setPartitionByCBean((CB)xcreateScalarConditionPartitionByCB()); // for using partition-by
        registerScalarCondition(fn, cb.query(), pp, rd, cs, op);
    }
    public abstract String keepScalarCondition(CharaGroupCQ sq);

    protected CharaGroupCB xcreateScalarConditionCB() {
        CharaGroupCB cb = newMyCB(); cb.xsetupForScalarCondition(this); return cb;
    }

    protected CharaGroupCB xcreateScalarConditionPartitionByCB() {
        CharaGroupCB cb = newMyCB(); cb.xsetupForScalarConditionPartitionBy(this); return cb;
    }

    // ===================================================================================
    //                                                                       MyselfDerived
    //                                                                       =============
    public void xsmyselfDerive(String fn, SubQuery<CharaGroupCB> sq, String al, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        CharaGroupCB cb = new CharaGroupCB(); cb.xsetupForDerivedReferrer(this);
        lockCall(() -> sq.query(cb)); String pp = keepSpecifyMyselfDerived(cb.query()); String pk = "CHARA_GROUP_ID";
        registerSpecifyMyselfDerived(fn, cb.query(), pk, pk, pp, "myselfDerived", al, op);
    }
    public abstract String keepSpecifyMyselfDerived(CharaGroupCQ sq);

    /**
     * Prepare for (Query)MyselfDerived (correlated sub-query).
     * @return The object to set up a function for myself table. (NotNull)
     */
    public HpQDRFunction<CharaGroupCB> myselfDerived() {
        return xcreateQDRFunctionMyselfDerived(CharaGroupCB.class);
    }
    @SuppressWarnings("unchecked")
    protected <CB extends ConditionBean> void xqderiveMyselfDerived(String fn, SubQuery<CB> sq, String rd, Object vl, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        CharaGroupCB cb = new CharaGroupCB(); cb.xsetupForDerivedReferrer(this); sq.query((CB)cb);
        String pk = "CHARA_GROUP_ID";
        String sqpp = keepQueryMyselfDerived(cb.query()); // for saving query-value.
        String prpp = keepQueryMyselfDerivedParameter(vl);
        registerQueryMyselfDerived(fn, cb.query(), pk, pk, sqpp, "myselfDerived", rd, vl, prpp, op);
    }
    public abstract String keepQueryMyselfDerived(CharaGroupCQ sq);
    public abstract String keepQueryMyselfDerivedParameter(Object vl);

    // ===================================================================================
    //                                                                        MyselfExists
    //                                                                        ============
    /**
     * Prepare for MyselfExists (correlated sub-query).
     * @param subCBLambda The implementation of sub-query. (NotNull)
     */
    public void myselfExists(SubQuery<CharaGroupCB> subCBLambda) {
        assertObjectNotNull("subCBLambda", subCBLambda);
        CharaGroupCB cb = new CharaGroupCB(); cb.xsetupForMyselfExists(this);
        lockCall(() -> subCBLambda.query(cb)); String pp = keepMyselfExists(cb.query());
        registerMyselfExists(cb.query(), pp);
    }
    public abstract String keepMyselfExists(CharaGroupCQ sq);

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
    protected CharaGroupCB newMyCB() {
        return new CharaGroupCB();
    }
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xabUDT() { return Date.class.getName(); }
    protected String xabCQ() { return CharaGroupCQ.class.getName(); }
    protected String xabLSO() { return LikeSearchOption.class.getName(); }
    protected String xabSLCS() { return HpSLCSetupper.class.getName(); }
    protected String xabSCP() { return SubQuery.class.getName(); }
}
