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
 * The abstract condition-query of PLAYER_DETAIL.
 * @author DBFlute(AutoGenerator)
 */
public abstract class AbstractBsPlayerDetailCQ extends AbstractConditionQuery {

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public AbstractBsPlayerDetailCQ(ConditionQuery referrerQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
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
        return "PLAYER_DETAIL";
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====
    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br>
     * PLAYER_ID: {PK, NotNull, INT UNSIGNED(10), FK to PLAYER}
     * @param playerId The value of playerId as equal. (basically NotNull: error as default, or no condition as option)
     */
    public void setPlayerId_Equal(Integer playerId) {
        doSetPlayerId_Equal(playerId);
    }

    protected void doSetPlayerId_Equal(Integer playerId) {
        regPlayerId(CK_EQ, playerId);
    }

    /**
     * NotEqual(&lt;&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * PLAYER_ID: {PK, NotNull, INT UNSIGNED(10), FK to PLAYER}
     * @param playerId The value of playerId as notEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setPlayerId_NotEqual(Integer playerId) {
        doSetPlayerId_NotEqual(playerId);
    }

    protected void doSetPlayerId_NotEqual(Integer playerId) {
        regPlayerId(CK_NES, playerId);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * PLAYER_ID: {PK, NotNull, INT UNSIGNED(10), FK to PLAYER}
     * @param playerId The value of playerId as greaterThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setPlayerId_GreaterThan(Integer playerId) {
        regPlayerId(CK_GT, playerId);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br>
     * PLAYER_ID: {PK, NotNull, INT UNSIGNED(10), FK to PLAYER}
     * @param playerId The value of playerId as lessThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setPlayerId_LessThan(Integer playerId) {
        regPlayerId(CK_LT, playerId);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * PLAYER_ID: {PK, NotNull, INT UNSIGNED(10), FK to PLAYER}
     * @param playerId The value of playerId as greaterEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setPlayerId_GreaterEqual(Integer playerId) {
        regPlayerId(CK_GE, playerId);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * PLAYER_ID: {PK, NotNull, INT UNSIGNED(10), FK to PLAYER}
     * @param playerId The value of playerId as lessEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setPlayerId_LessEqual(Integer playerId) {
        regPlayerId(CK_LE, playerId);
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * PLAYER_ID: {PK, NotNull, INT UNSIGNED(10), FK to PLAYER}
     * @param minNumber The min number of playerId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param maxNumber The max number of playerId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param opLambda The callback for option of range-of. (NotNull)
     */
    public void setPlayerId_RangeOf(Integer minNumber, Integer maxNumber, ConditionOptionCall<RangeOfOption> opLambda) {
        setPlayerId_RangeOf(minNumber, maxNumber, xcROOP(opLambda));
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * PLAYER_ID: {PK, NotNull, INT UNSIGNED(10), FK to PLAYER}
     * @param minNumber The min number of playerId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param maxNumber The max number of playerId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    protected void setPlayerId_RangeOf(Integer minNumber, Integer maxNumber, RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, xgetCValuePlayerId(), "PLAYER_ID", rangeOfOption);
    }

    /**
     * InScope {in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * PLAYER_ID: {PK, NotNull, INT UNSIGNED(10), FK to PLAYER}
     * @param playerIdList The collection of playerId as inScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setPlayerId_InScope(Collection<Integer> playerIdList) {
        doSetPlayerId_InScope(playerIdList);
    }

    protected void doSetPlayerId_InScope(Collection<Integer> playerIdList) {
        regINS(CK_INS, cTL(playerIdList), xgetCValuePlayerId(), "PLAYER_ID");
    }

    /**
     * NotInScope {not in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * PLAYER_ID: {PK, NotNull, INT UNSIGNED(10), FK to PLAYER}
     * @param playerIdList The collection of playerId as notInScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setPlayerId_NotInScope(Collection<Integer> playerIdList) {
        doSetPlayerId_NotInScope(playerIdList);
    }

    protected void doSetPlayerId_NotInScope(Collection<Integer> playerIdList) {
        regINS(CK_NINS, cTL(playerIdList), xgetCValuePlayerId(), "PLAYER_ID");
    }

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br>
     * PLAYER_ID: {PK, NotNull, INT UNSIGNED(10), FK to PLAYER}
     */
    public void setPlayerId_IsNull() { regPlayerId(CK_ISN, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br>
     * PLAYER_ID: {PK, NotNull, INT UNSIGNED(10), FK to PLAYER}
     */
    public void setPlayerId_IsNotNull() { regPlayerId(CK_ISNN, DOBJ); }

    protected void regPlayerId(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValuePlayerId(), "PLAYER_ID"); }
    protected abstract ConditionValue xgetCValuePlayerId();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * OTHER_SITE_NAME: {VARCHAR(20)}
     * @param otherSiteName The value of otherSiteName as equal. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setOtherSiteName_Equal(String otherSiteName) {
        doSetOtherSiteName_Equal(fRES(otherSiteName));
    }

    protected void doSetOtherSiteName_Equal(String otherSiteName) {
        regOtherSiteName(CK_EQ, otherSiteName);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * OTHER_SITE_NAME: {VARCHAR(20)}
     * @param otherSiteName The value of otherSiteName as notEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setOtherSiteName_NotEqual(String otherSiteName) {
        doSetOtherSiteName_NotEqual(fRES(otherSiteName));
    }

    protected void doSetOtherSiteName_NotEqual(String otherSiteName) {
        regOtherSiteName(CK_NES, otherSiteName);
    }

    /**
     * GreaterThan(&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * OTHER_SITE_NAME: {VARCHAR(20)}
     * @param otherSiteName The value of otherSiteName as greaterThan. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setOtherSiteName_GreaterThan(String otherSiteName) {
        regOtherSiteName(CK_GT, fRES(otherSiteName));
    }

    /**
     * LessThan(&lt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * OTHER_SITE_NAME: {VARCHAR(20)}
     * @param otherSiteName The value of otherSiteName as lessThan. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setOtherSiteName_LessThan(String otherSiteName) {
        regOtherSiteName(CK_LT, fRES(otherSiteName));
    }

    /**
     * GreaterEqual(&gt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * OTHER_SITE_NAME: {VARCHAR(20)}
     * @param otherSiteName The value of otherSiteName as greaterEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setOtherSiteName_GreaterEqual(String otherSiteName) {
        regOtherSiteName(CK_GE, fRES(otherSiteName));
    }

    /**
     * LessEqual(&lt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * OTHER_SITE_NAME: {VARCHAR(20)}
     * @param otherSiteName The value of otherSiteName as lessEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setOtherSiteName_LessEqual(String otherSiteName) {
        regOtherSiteName(CK_LE, fRES(otherSiteName));
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * OTHER_SITE_NAME: {VARCHAR(20)}
     * @param otherSiteNameList The collection of otherSiteName as inScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setOtherSiteName_InScope(Collection<String> otherSiteNameList) {
        doSetOtherSiteName_InScope(otherSiteNameList);
    }

    protected void doSetOtherSiteName_InScope(Collection<String> otherSiteNameList) {
        regINS(CK_INS, cTL(otherSiteNameList), xgetCValueOtherSiteName(), "OTHER_SITE_NAME");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * OTHER_SITE_NAME: {VARCHAR(20)}
     * @param otherSiteNameList The collection of otherSiteName as notInScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setOtherSiteName_NotInScope(Collection<String> otherSiteNameList) {
        doSetOtherSiteName_NotInScope(otherSiteNameList);
    }

    protected void doSetOtherSiteName_NotInScope(Collection<String> otherSiteNameList) {
        regINS(CK_NINS, cTL(otherSiteNameList), xgetCValueOtherSiteName(), "OTHER_SITE_NAME");
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * OTHER_SITE_NAME: {VARCHAR(20)} <br>
     * <pre>e.g. setOtherSiteName_LikeSearch("xxx", op <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> op.<span style="color: #CC4747">likeContain()</span>);</pre>
     * @param otherSiteName The value of otherSiteName as likeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setOtherSiteName_LikeSearch(String otherSiteName, ConditionOptionCall<LikeSearchOption> opLambda) {
        setOtherSiteName_LikeSearch(otherSiteName, xcLSOP(opLambda));
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * OTHER_SITE_NAME: {VARCHAR(20)} <br>
     * <pre>e.g. setOtherSiteName_LikeSearch("xxx", new <span style="color: #CC4747">LikeSearchOption</span>().likeContain());</pre>
     * @param otherSiteName The value of otherSiteName as likeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    protected void setOtherSiteName_LikeSearch(String otherSiteName, LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(otherSiteName), xgetCValueOtherSiteName(), "OTHER_SITE_NAME", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * OTHER_SITE_NAME: {VARCHAR(20)}
     * @param otherSiteName The value of otherSiteName as notLikeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setOtherSiteName_NotLikeSearch(String otherSiteName, ConditionOptionCall<LikeSearchOption> opLambda) {
        setOtherSiteName_NotLikeSearch(otherSiteName, xcLSOP(opLambda));
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * OTHER_SITE_NAME: {VARCHAR(20)}
     * @param otherSiteName The value of otherSiteName as notLikeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    protected void setOtherSiteName_NotLikeSearch(String otherSiteName, LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(otherSiteName), xgetCValueOtherSiteName(), "OTHER_SITE_NAME", likeSearchOption);
    }

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br>
     * OTHER_SITE_NAME: {VARCHAR(20)}
     */
    public void setOtherSiteName_IsNull() { regOtherSiteName(CK_ISN, DOBJ); }

    /**
     * IsNullOrEmpty {is null or empty}. And OnlyOnceRegistered. <br>
     * OTHER_SITE_NAME: {VARCHAR(20)}
     */
    public void setOtherSiteName_IsNullOrEmpty() { regOtherSiteName(CK_ISNOE, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br>
     * OTHER_SITE_NAME: {VARCHAR(20)}
     */
    public void setOtherSiteName_IsNotNull() { regOtherSiteName(CK_ISNN, DOBJ); }

    protected void regOtherSiteName(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueOtherSiteName(), "OTHER_SITE_NAME"); }
    protected abstract ConditionValue xgetCValueOtherSiteName();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * INTRODUCTION: {VARCHAR(2000)}
     * @param introduction The value of introduction as equal. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setIntroduction_Equal(String introduction) {
        doSetIntroduction_Equal(fRES(introduction));
    }

    protected void doSetIntroduction_Equal(String introduction) {
        regIntroduction(CK_EQ, introduction);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * INTRODUCTION: {VARCHAR(2000)}
     * @param introduction The value of introduction as notEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setIntroduction_NotEqual(String introduction) {
        doSetIntroduction_NotEqual(fRES(introduction));
    }

    protected void doSetIntroduction_NotEqual(String introduction) {
        regIntroduction(CK_NES, introduction);
    }

    /**
     * GreaterThan(&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * INTRODUCTION: {VARCHAR(2000)}
     * @param introduction The value of introduction as greaterThan. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setIntroduction_GreaterThan(String introduction) {
        regIntroduction(CK_GT, fRES(introduction));
    }

    /**
     * LessThan(&lt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * INTRODUCTION: {VARCHAR(2000)}
     * @param introduction The value of introduction as lessThan. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setIntroduction_LessThan(String introduction) {
        regIntroduction(CK_LT, fRES(introduction));
    }

    /**
     * GreaterEqual(&gt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * INTRODUCTION: {VARCHAR(2000)}
     * @param introduction The value of introduction as greaterEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setIntroduction_GreaterEqual(String introduction) {
        regIntroduction(CK_GE, fRES(introduction));
    }

    /**
     * LessEqual(&lt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * INTRODUCTION: {VARCHAR(2000)}
     * @param introduction The value of introduction as lessEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setIntroduction_LessEqual(String introduction) {
        regIntroduction(CK_LE, fRES(introduction));
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * INTRODUCTION: {VARCHAR(2000)}
     * @param introductionList The collection of introduction as inScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setIntroduction_InScope(Collection<String> introductionList) {
        doSetIntroduction_InScope(introductionList);
    }

    protected void doSetIntroduction_InScope(Collection<String> introductionList) {
        regINS(CK_INS, cTL(introductionList), xgetCValueIntroduction(), "INTRODUCTION");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * INTRODUCTION: {VARCHAR(2000)}
     * @param introductionList The collection of introduction as notInScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setIntroduction_NotInScope(Collection<String> introductionList) {
        doSetIntroduction_NotInScope(introductionList);
    }

    protected void doSetIntroduction_NotInScope(Collection<String> introductionList) {
        regINS(CK_NINS, cTL(introductionList), xgetCValueIntroduction(), "INTRODUCTION");
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * INTRODUCTION: {VARCHAR(2000)} <br>
     * <pre>e.g. setIntroduction_LikeSearch("xxx", op <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> op.<span style="color: #CC4747">likeContain()</span>);</pre>
     * @param introduction The value of introduction as likeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setIntroduction_LikeSearch(String introduction, ConditionOptionCall<LikeSearchOption> opLambda) {
        setIntroduction_LikeSearch(introduction, xcLSOP(opLambda));
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * INTRODUCTION: {VARCHAR(2000)} <br>
     * <pre>e.g. setIntroduction_LikeSearch("xxx", new <span style="color: #CC4747">LikeSearchOption</span>().likeContain());</pre>
     * @param introduction The value of introduction as likeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    protected void setIntroduction_LikeSearch(String introduction, LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(introduction), xgetCValueIntroduction(), "INTRODUCTION", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * INTRODUCTION: {VARCHAR(2000)}
     * @param introduction The value of introduction as notLikeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setIntroduction_NotLikeSearch(String introduction, ConditionOptionCall<LikeSearchOption> opLambda) {
        setIntroduction_NotLikeSearch(introduction, xcLSOP(opLambda));
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * INTRODUCTION: {VARCHAR(2000)}
     * @param introduction The value of introduction as notLikeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    protected void setIntroduction_NotLikeSearch(String introduction, LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(introduction), xgetCValueIntroduction(), "INTRODUCTION", likeSearchOption);
    }

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br>
     * INTRODUCTION: {VARCHAR(2000)}
     */
    public void setIntroduction_IsNull() { regIntroduction(CK_ISN, DOBJ); }

    /**
     * IsNullOrEmpty {is null or empty}. And OnlyOnceRegistered. <br>
     * INTRODUCTION: {VARCHAR(2000)}
     */
    public void setIntroduction_IsNullOrEmpty() { regIntroduction(CK_ISNOE, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br>
     * INTRODUCTION: {VARCHAR(2000)}
     */
    public void setIntroduction_IsNotNull() { regIntroduction(CK_ISNN, DOBJ); }

    protected void regIntroduction(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueIntroduction(), "INTRODUCTION"); }
    protected abstract ConditionValue xgetCValueIntroduction();

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
    public HpSLCFunction<PlayerDetailCB> scalar_Equal() {
        return xcreateSLCFunction(CK_EQ, PlayerDetailCB.class);
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
    public HpSLCFunction<PlayerDetailCB> scalar_NotEqual() {
        return xcreateSLCFunction(CK_NES, PlayerDetailCB.class);
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
    public HpSLCFunction<PlayerDetailCB> scalar_GreaterThan() {
        return xcreateSLCFunction(CK_GT, PlayerDetailCB.class);
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
    public HpSLCFunction<PlayerDetailCB> scalar_LessThan() {
        return xcreateSLCFunction(CK_LT, PlayerDetailCB.class);
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
    public HpSLCFunction<PlayerDetailCB> scalar_GreaterEqual() {
        return xcreateSLCFunction(CK_GE, PlayerDetailCB.class);
    }

    /**
     * Prepare ScalarCondition as lessEqual. <br>
     * {where FOO &lt;= (select max(BAR) from ...)}
     * <pre>
     * cb.query().<span style="color: #CC4747">scalar_LessEqual()</span>.max(new SubQuery&lt;PlayerDetailCB&gt;() {
     *     public void query(PlayerDetailCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSLCFunction<PlayerDetailCB> scalar_LessEqual() {
        return xcreateSLCFunction(CK_LE, PlayerDetailCB.class);
    }

    @SuppressWarnings("unchecked")
    protected <CB extends ConditionBean> void xscalarCondition(String fn, SubQuery<CB> sq, String rd, HpSLCCustomized<CB> cs, ScalarConditionOption op) {
        assertObjectNotNull("subQuery", sq);
        PlayerDetailCB cb = xcreateScalarConditionCB(); sq.query((CB)cb);
        String pp = keepScalarCondition(cb.query()); // for saving query-value
        cs.setPartitionByCBean((CB)xcreateScalarConditionPartitionByCB()); // for using partition-by
        registerScalarCondition(fn, cb.query(), pp, rd, cs, op);
    }
    public abstract String keepScalarCondition(PlayerDetailCQ sq);

    protected PlayerDetailCB xcreateScalarConditionCB() {
        PlayerDetailCB cb = newMyCB(); cb.xsetupForScalarCondition(this); return cb;
    }

    protected PlayerDetailCB xcreateScalarConditionPartitionByCB() {
        PlayerDetailCB cb = newMyCB(); cb.xsetupForScalarConditionPartitionBy(this); return cb;
    }

    // ===================================================================================
    //                                                                       MyselfDerived
    //                                                                       =============
    public void xsmyselfDerive(String fn, SubQuery<PlayerDetailCB> sq, String al, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        PlayerDetailCB cb = new PlayerDetailCB(); cb.xsetupForDerivedReferrer(this);
        lockCall(() -> sq.query(cb)); String pp = keepSpecifyMyselfDerived(cb.query()); String pk = "PLAYER_ID";
        registerSpecifyMyselfDerived(fn, cb.query(), pk, pk, pp, "myselfDerived", al, op);
    }
    public abstract String keepSpecifyMyselfDerived(PlayerDetailCQ sq);

    /**
     * Prepare for (Query)MyselfDerived (correlated sub-query).
     * @return The object to set up a function for myself table. (NotNull)
     */
    public HpQDRFunction<PlayerDetailCB> myselfDerived() {
        return xcreateQDRFunctionMyselfDerived(PlayerDetailCB.class);
    }
    @SuppressWarnings("unchecked")
    protected <CB extends ConditionBean> void xqderiveMyselfDerived(String fn, SubQuery<CB> sq, String rd, Object vl, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        PlayerDetailCB cb = new PlayerDetailCB(); cb.xsetupForDerivedReferrer(this); sq.query((CB)cb);
        String pk = "PLAYER_ID";
        String sqpp = keepQueryMyselfDerived(cb.query()); // for saving query-value.
        String prpp = keepQueryMyselfDerivedParameter(vl);
        registerQueryMyselfDerived(fn, cb.query(), pk, pk, sqpp, "myselfDerived", rd, vl, prpp, op);
    }
    public abstract String keepQueryMyselfDerived(PlayerDetailCQ sq);
    public abstract String keepQueryMyselfDerivedParameter(Object vl);

    // ===================================================================================
    //                                                                        MyselfExists
    //                                                                        ============
    /**
     * Prepare for MyselfExists (correlated sub-query).
     * @param subCBLambda The implementation of sub-query. (NotNull)
     */
    public void myselfExists(SubQuery<PlayerDetailCB> subCBLambda) {
        assertObjectNotNull("subCBLambda", subCBLambda);
        PlayerDetailCB cb = new PlayerDetailCB(); cb.xsetupForMyselfExists(this);
        lockCall(() -> subCBLambda.query(cb)); String pp = keepMyselfExists(cb.query());
        registerMyselfExists(cb.query(), pp);
    }
    public abstract String keepMyselfExists(PlayerDetailCQ sq);

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
    protected PlayerDetailCB newMyCB() {
        return new PlayerDetailCB();
    }
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xabUDT() { return Date.class.getName(); }
    protected String xabCQ() { return PlayerDetailCQ.class.getName(); }
    protected String xabLSO() { return LikeSearchOption.class.getName(); }
    protected String xabSLCS() { return HpSLCSetupper.class.getName(); }
    protected String xabSCP() { return SubQuery.class.getName(); }
}
