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
 * The abstract condition-query of authority.
 * @author DBFlute(AutoGenerator)
 */
public abstract class AbstractBsAuthorityCQ extends AbstractConditionQuery {

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public AbstractBsAuthorityCQ(ConditionQuery referrerQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
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
        return "authority";
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====
    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * AUTHORITY_CODE: {PK, NotNull, VARCHAR(20), classification=Authority}
     * @param authorityCode The value of authorityCode as equal. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    protected void setAuthorityCode_Equal(String authorityCode) {
        doSetAuthorityCode_Equal(fRES(authorityCode));
    }

    /**
     * Equal(=). As Authority. And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * AUTHORITY_CODE: {PK, NotNull, VARCHAR(20), classification=Authority} <br>
     * 権限
     * @param cdef The instance of classification definition (as ENUM type). (basically NotNull: error as default, or no condition as option)
     */
    public void setAuthorityCode_Equal_AsAuthority(CDef.Authority cdef) {
        doSetAuthorityCode_Equal(cdef != null ? cdef.code() : null);
    }

    /**
     * Equal(=). As 管理者 (ROLE_ADMIN). And OnlyOnceRegistered. <br>
     * 管理者
     */
    public void setAuthorityCode_Equal_管理者() {
        setAuthorityCode_Equal_AsAuthority(CDef.Authority.管理者);
    }

    /**
     * Equal(=). As プレイヤー (ROLE_PLAYER). And OnlyOnceRegistered. <br>
     * プレイヤー
     */
    public void setAuthorityCode_Equal_プレイヤー() {
        setAuthorityCode_Equal_AsAuthority(CDef.Authority.プレイヤー);
    }

    protected void doSetAuthorityCode_Equal(String authorityCode) {
        regAuthorityCode(CK_EQ, authorityCode);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * AUTHORITY_CODE: {PK, NotNull, VARCHAR(20), classification=Authority}
     * @param authorityCode The value of authorityCode as notEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    protected void setAuthorityCode_NotEqual(String authorityCode) {
        doSetAuthorityCode_NotEqual(fRES(authorityCode));
    }

    /**
     * NotEqual(&lt;&gt;). As Authority. And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * AUTHORITY_CODE: {PK, NotNull, VARCHAR(20), classification=Authority} <br>
     * 権限
     * @param cdef The instance of classification definition (as ENUM type). (basically NotNull: error as default, or no condition as option)
     */
    public void setAuthorityCode_NotEqual_AsAuthority(CDef.Authority cdef) {
        doSetAuthorityCode_NotEqual(cdef != null ? cdef.code() : null);
    }

    /**
     * NotEqual(&lt;&gt;). As 管理者 (ROLE_ADMIN). And OnlyOnceRegistered. <br>
     * 管理者
     */
    public void setAuthorityCode_NotEqual_管理者() {
        setAuthorityCode_NotEqual_AsAuthority(CDef.Authority.管理者);
    }

    /**
     * NotEqual(&lt;&gt;). As プレイヤー (ROLE_PLAYER). And OnlyOnceRegistered. <br>
     * プレイヤー
     */
    public void setAuthorityCode_NotEqual_プレイヤー() {
        setAuthorityCode_NotEqual_AsAuthority(CDef.Authority.プレイヤー);
    }

    protected void doSetAuthorityCode_NotEqual(String authorityCode) {
        regAuthorityCode(CK_NES, authorityCode);
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * AUTHORITY_CODE: {PK, NotNull, VARCHAR(20), classification=Authority}
     * @param authorityCodeList The collection of authorityCode as inScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    protected void setAuthorityCode_InScope(Collection<String> authorityCodeList) {
        doSetAuthorityCode_InScope(authorityCodeList);
    }

    /**
     * InScope {in ('a', 'b')}. As Authority. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * AUTHORITY_CODE: {PK, NotNull, VARCHAR(20), classification=Authority} <br>
     * 権限
     * @param cdefList The list of classification definition (as ENUM type). (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setAuthorityCode_InScope_AsAuthority(Collection<CDef.Authority> cdefList) {
        doSetAuthorityCode_InScope(cTStrL(cdefList));
    }

    protected void doSetAuthorityCode_InScope(Collection<String> authorityCodeList) {
        regINS(CK_INS, cTL(authorityCodeList), xgetCValueAuthorityCode(), "AUTHORITY_CODE");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * AUTHORITY_CODE: {PK, NotNull, VARCHAR(20), classification=Authority}
     * @param authorityCodeList The collection of authorityCode as notInScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    protected void setAuthorityCode_NotInScope(Collection<String> authorityCodeList) {
        doSetAuthorityCode_NotInScope(authorityCodeList);
    }

    /**
     * NotInScope {not in ('a', 'b')}. As Authority. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * AUTHORITY_CODE: {PK, NotNull, VARCHAR(20), classification=Authority} <br>
     * 権限
     * @param cdefList The list of classification definition (as ENUM type). (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setAuthorityCode_NotInScope_AsAuthority(Collection<CDef.Authority> cdefList) {
        doSetAuthorityCode_NotInScope(cTStrL(cdefList));
    }

    protected void doSetAuthorityCode_NotInScope(Collection<String> authorityCodeList) {
        regINS(CK_NINS, cTL(authorityCodeList), xgetCValueAuthorityCode(), "AUTHORITY_CODE");
    }

    /**
     * Set up ExistsReferrer (correlated sub-query). <br>
     * {exists (select AUTHORITY_CODE from player where ...)} <br>
     * player by AUTHORITY_CODE, named 'playerAsOne'.
     * <pre>
     * cb.query().<span style="color: #CC4747">existsPlayer</span>(playerCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     playerCB.query().set...
     * });
     * </pre>
     * @param subCBLambda The callback for sub-query of PlayerList for 'exists'. (NotNull)
     */
    public void existsPlayer(SubQuery<PlayerCB> subCBLambda) {
        assertObjectNotNull("subCBLambda", subCBLambda);
        PlayerCB cb = new PlayerCB(); cb.xsetupForExistsReferrer(this);
        lockCall(() -> subCBLambda.query(cb)); String pp = keepAuthorityCode_ExistsReferrer_PlayerList(cb.query());
        registerExistsReferrer(cb.query(), "AUTHORITY_CODE", "AUTHORITY_CODE", pp, "playerList");
    }
    public abstract String keepAuthorityCode_ExistsReferrer_PlayerList(PlayerCQ sq);

    /**
     * Set up NotExistsReferrer (correlated sub-query). <br>
     * {not exists (select AUTHORITY_CODE from player where ...)} <br>
     * player by AUTHORITY_CODE, named 'playerAsOne'.
     * <pre>
     * cb.query().<span style="color: #CC4747">notExistsPlayer</span>(playerCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     playerCB.query().set...
     * });
     * </pre>
     * @param subCBLambda The callback for sub-query of AuthorityCode_NotExistsReferrer_PlayerList for 'not exists'. (NotNull)
     */
    public void notExistsPlayer(SubQuery<PlayerCB> subCBLambda) {
        assertObjectNotNull("subCBLambda", subCBLambda);
        PlayerCB cb = new PlayerCB(); cb.xsetupForExistsReferrer(this);
        lockCall(() -> subCBLambda.query(cb)); String pp = keepAuthorityCode_NotExistsReferrer_PlayerList(cb.query());
        registerNotExistsReferrer(cb.query(), "AUTHORITY_CODE", "AUTHORITY_CODE", pp, "playerList");
    }
    public abstract String keepAuthorityCode_NotExistsReferrer_PlayerList(PlayerCQ sq);

    public void xsderivePlayerList(String fn, SubQuery<PlayerCB> sq, String al, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        PlayerCB cb = new PlayerCB(); cb.xsetupForDerivedReferrer(this);
        lockCall(() -> sq.query(cb)); String pp = keepAuthorityCode_SpecifyDerivedReferrer_PlayerList(cb.query());
        registerSpecifyDerivedReferrer(fn, cb.query(), "AUTHORITY_CODE", "AUTHORITY_CODE", pp, "playerList", al, op);
    }
    public abstract String keepAuthorityCode_SpecifyDerivedReferrer_PlayerList(PlayerCQ sq);

    /**
     * Prepare for (Query)DerivedReferrer (correlated sub-query). <br>
     * {FOO &lt;= (select max(BAR) from player where ...)} <br>
     * player by AUTHORITY_CODE, named 'playerAsOne'.
     * <pre>
     * cb.query().<span style="color: #CC4747">derivedPlayer()</span>.<span style="color: #CC4747">max</span>(playerCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     playerCB.specify().<span style="color: #CC4747">columnFoo...</span> <span style="color: #3F7E5E">// derived column by function</span>
     *     playerCB.query().setBar... <span style="color: #3F7E5E">// referrer condition</span>
     * }).<span style="color: #CC4747">greaterEqual</span>(123); <span style="color: #3F7E5E">// condition to derived column</span>
     * </pre>
     * @return The object to set up a function for referrer table. (NotNull)
     */
    public HpQDRFunction<PlayerCB> derivedPlayer() {
        return xcreateQDRFunctionPlayerList();
    }
    protected HpQDRFunction<PlayerCB> xcreateQDRFunctionPlayerList() {
        return xcQDRFunc((fn, sq, rd, vl, op) -> xqderivePlayerList(fn, sq, rd, vl, op));
    }
    public void xqderivePlayerList(String fn, SubQuery<PlayerCB> sq, String rd, Object vl, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        PlayerCB cb = new PlayerCB(); cb.xsetupForDerivedReferrer(this);
        lockCall(() -> sq.query(cb)); String sqpp = keepAuthorityCode_QueryDerivedReferrer_PlayerList(cb.query()); String prpp = keepAuthorityCode_QueryDerivedReferrer_PlayerListParameter(vl);
        registerQueryDerivedReferrer(fn, cb.query(), "AUTHORITY_CODE", "AUTHORITY_CODE", sqpp, "playerList", rd, vl, prpp, op);
    }
    public abstract String keepAuthorityCode_QueryDerivedReferrer_PlayerList(PlayerCQ sq);
    public abstract String keepAuthorityCode_QueryDerivedReferrer_PlayerListParameter(Object vl);

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br>
     * AUTHORITY_CODE: {PK, NotNull, VARCHAR(20), classification=Authority}
     */
    public void setAuthorityCode_IsNull() { regAuthorityCode(CK_ISN, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br>
     * AUTHORITY_CODE: {PK, NotNull, VARCHAR(20), classification=Authority}
     */
    public void setAuthorityCode_IsNotNull() { regAuthorityCode(CK_ISNN, DOBJ); }

    protected void regAuthorityCode(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueAuthorityCode(), "AUTHORITY_CODE"); }
    protected abstract ConditionValue xgetCValueAuthorityCode();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * AUTHORITY_NAME: {NotNull, VARCHAR(20)}
     * @param authorityName The value of authorityName as equal. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setAuthorityName_Equal(String authorityName) {
        doSetAuthorityName_Equal(fRES(authorityName));
    }

    protected void doSetAuthorityName_Equal(String authorityName) {
        regAuthorityName(CK_EQ, authorityName);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * AUTHORITY_NAME: {NotNull, VARCHAR(20)}
     * @param authorityName The value of authorityName as notEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setAuthorityName_NotEqual(String authorityName) {
        doSetAuthorityName_NotEqual(fRES(authorityName));
    }

    protected void doSetAuthorityName_NotEqual(String authorityName) {
        regAuthorityName(CK_NES, authorityName);
    }

    /**
     * GreaterThan(&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * AUTHORITY_NAME: {NotNull, VARCHAR(20)}
     * @param authorityName The value of authorityName as greaterThan. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setAuthorityName_GreaterThan(String authorityName) {
        regAuthorityName(CK_GT, fRES(authorityName));
    }

    /**
     * LessThan(&lt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * AUTHORITY_NAME: {NotNull, VARCHAR(20)}
     * @param authorityName The value of authorityName as lessThan. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setAuthorityName_LessThan(String authorityName) {
        regAuthorityName(CK_LT, fRES(authorityName));
    }

    /**
     * GreaterEqual(&gt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * AUTHORITY_NAME: {NotNull, VARCHAR(20)}
     * @param authorityName The value of authorityName as greaterEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setAuthorityName_GreaterEqual(String authorityName) {
        regAuthorityName(CK_GE, fRES(authorityName));
    }

    /**
     * LessEqual(&lt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * AUTHORITY_NAME: {NotNull, VARCHAR(20)}
     * @param authorityName The value of authorityName as lessEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setAuthorityName_LessEqual(String authorityName) {
        regAuthorityName(CK_LE, fRES(authorityName));
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * AUTHORITY_NAME: {NotNull, VARCHAR(20)}
     * @param authorityNameList The collection of authorityName as inScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setAuthorityName_InScope(Collection<String> authorityNameList) {
        doSetAuthorityName_InScope(authorityNameList);
    }

    protected void doSetAuthorityName_InScope(Collection<String> authorityNameList) {
        regINS(CK_INS, cTL(authorityNameList), xgetCValueAuthorityName(), "AUTHORITY_NAME");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * AUTHORITY_NAME: {NotNull, VARCHAR(20)}
     * @param authorityNameList The collection of authorityName as notInScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setAuthorityName_NotInScope(Collection<String> authorityNameList) {
        doSetAuthorityName_NotInScope(authorityNameList);
    }

    protected void doSetAuthorityName_NotInScope(Collection<String> authorityNameList) {
        regINS(CK_NINS, cTL(authorityNameList), xgetCValueAuthorityName(), "AUTHORITY_NAME");
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * AUTHORITY_NAME: {NotNull, VARCHAR(20)} <br>
     * <pre>e.g. setAuthorityName_LikeSearch("xxx", op <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> op.<span style="color: #CC4747">likeContain()</span>);</pre>
     * @param authorityName The value of authorityName as likeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setAuthorityName_LikeSearch(String authorityName, ConditionOptionCall<LikeSearchOption> opLambda) {
        setAuthorityName_LikeSearch(authorityName, xcLSOP(opLambda));
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * AUTHORITY_NAME: {NotNull, VARCHAR(20)} <br>
     * <pre>e.g. setAuthorityName_LikeSearch("xxx", new <span style="color: #CC4747">LikeSearchOption</span>().likeContain());</pre>
     * @param authorityName The value of authorityName as likeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    protected void setAuthorityName_LikeSearch(String authorityName, LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(authorityName), xgetCValueAuthorityName(), "AUTHORITY_NAME", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * AUTHORITY_NAME: {NotNull, VARCHAR(20)}
     * @param authorityName The value of authorityName as notLikeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setAuthorityName_NotLikeSearch(String authorityName, ConditionOptionCall<LikeSearchOption> opLambda) {
        setAuthorityName_NotLikeSearch(authorityName, xcLSOP(opLambda));
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * AUTHORITY_NAME: {NotNull, VARCHAR(20)}
     * @param authorityName The value of authorityName as notLikeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    protected void setAuthorityName_NotLikeSearch(String authorityName, LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(authorityName), xgetCValueAuthorityName(), "AUTHORITY_NAME", likeSearchOption);
    }

    protected void regAuthorityName(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueAuthorityName(), "AUTHORITY_NAME"); }
    protected abstract ConditionValue xgetCValueAuthorityName();

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
    public HpSLCFunction<AuthorityCB> scalar_Equal() {
        return xcreateSLCFunction(CK_EQ, AuthorityCB.class);
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
    public HpSLCFunction<AuthorityCB> scalar_NotEqual() {
        return xcreateSLCFunction(CK_NES, AuthorityCB.class);
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
    public HpSLCFunction<AuthorityCB> scalar_GreaterThan() {
        return xcreateSLCFunction(CK_GT, AuthorityCB.class);
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
    public HpSLCFunction<AuthorityCB> scalar_LessThan() {
        return xcreateSLCFunction(CK_LT, AuthorityCB.class);
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
    public HpSLCFunction<AuthorityCB> scalar_GreaterEqual() {
        return xcreateSLCFunction(CK_GE, AuthorityCB.class);
    }

    /**
     * Prepare ScalarCondition as lessEqual. <br>
     * {where FOO &lt;= (select max(BAR) from ...)}
     * <pre>
     * cb.query().<span style="color: #CC4747">scalar_LessEqual()</span>.max(new SubQuery&lt;AuthorityCB&gt;() {
     *     public void query(AuthorityCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSLCFunction<AuthorityCB> scalar_LessEqual() {
        return xcreateSLCFunction(CK_LE, AuthorityCB.class);
    }

    @SuppressWarnings("unchecked")
    protected <CB extends ConditionBean> void xscalarCondition(String fn, SubQuery<CB> sq, String rd, HpSLCCustomized<CB> cs, ScalarConditionOption op) {
        assertObjectNotNull("subQuery", sq);
        AuthorityCB cb = xcreateScalarConditionCB(); sq.query((CB)cb);
        String pp = keepScalarCondition(cb.query()); // for saving query-value
        cs.setPartitionByCBean((CB)xcreateScalarConditionPartitionByCB()); // for using partition-by
        registerScalarCondition(fn, cb.query(), pp, rd, cs, op);
    }
    public abstract String keepScalarCondition(AuthorityCQ sq);

    protected AuthorityCB xcreateScalarConditionCB() {
        AuthorityCB cb = newMyCB(); cb.xsetupForScalarCondition(this); return cb;
    }

    protected AuthorityCB xcreateScalarConditionPartitionByCB() {
        AuthorityCB cb = newMyCB(); cb.xsetupForScalarConditionPartitionBy(this); return cb;
    }

    // ===================================================================================
    //                                                                       MyselfDerived
    //                                                                       =============
    public void xsmyselfDerive(String fn, SubQuery<AuthorityCB> sq, String al, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        AuthorityCB cb = new AuthorityCB(); cb.xsetupForDerivedReferrer(this);
        lockCall(() -> sq.query(cb)); String pp = keepSpecifyMyselfDerived(cb.query()); String pk = "AUTHORITY_CODE";
        registerSpecifyMyselfDerived(fn, cb.query(), pk, pk, pp, "myselfDerived", al, op);
    }
    public abstract String keepSpecifyMyselfDerived(AuthorityCQ sq);

    /**
     * Prepare for (Query)MyselfDerived (correlated sub-query).
     * @return The object to set up a function for myself table. (NotNull)
     */
    public HpQDRFunction<AuthorityCB> myselfDerived() {
        return xcreateQDRFunctionMyselfDerived(AuthorityCB.class);
    }
    @SuppressWarnings("unchecked")
    protected <CB extends ConditionBean> void xqderiveMyselfDerived(String fn, SubQuery<CB> sq, String rd, Object vl, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        AuthorityCB cb = new AuthorityCB(); cb.xsetupForDerivedReferrer(this); sq.query((CB)cb);
        String pk = "AUTHORITY_CODE";
        String sqpp = keepQueryMyselfDerived(cb.query()); // for saving query-value.
        String prpp = keepQueryMyselfDerivedParameter(vl);
        registerQueryMyselfDerived(fn, cb.query(), pk, pk, sqpp, "myselfDerived", rd, vl, prpp, op);
    }
    public abstract String keepQueryMyselfDerived(AuthorityCQ sq);
    public abstract String keepQueryMyselfDerivedParameter(Object vl);

    // ===================================================================================
    //                                                                        MyselfExists
    //                                                                        ============
    /**
     * Prepare for MyselfExists (correlated sub-query).
     * @param subCBLambda The implementation of sub-query. (NotNull)
     */
    public void myselfExists(SubQuery<AuthorityCB> subCBLambda) {
        assertObjectNotNull("subCBLambda", subCBLambda);
        AuthorityCB cb = new AuthorityCB(); cb.xsetupForMyselfExists(this);
        lockCall(() -> subCBLambda.query(cb)); String pp = keepMyselfExists(cb.query());
        registerMyselfExists(cb.query(), pp);
    }
    public abstract String keepMyselfExists(AuthorityCQ sq);

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
    protected AuthorityCB newMyCB() {
        return new AuthorityCB();
    }
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xabUDT() { return Date.class.getName(); }
    protected String xabCQ() { return AuthorityCQ.class.getName(); }
    protected String xabLSO() { return LikeSearchOption.class.getName(); }
    protected String xabSLCS() { return HpSLCSetupper.class.getName(); }
    protected String xabSCP() { return SubQuery.class.getName(); }
}
