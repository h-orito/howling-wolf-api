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
 * The abstract condition-query of random_keyword.
 * @author DBFlute(AutoGenerator)
 */
public abstract class AbstractBsRandomKeywordCQ extends AbstractConditionQuery {

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public AbstractBsRandomKeywordCQ(ConditionQuery referrerQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
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
        return "random_keyword";
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====
    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br>
     * RANDOM_KEYWORD_ID: {PK, ID, NotNull, INT UNSIGNED(10)}
     * @param randomKeywordId The value of randomKeywordId as equal. (basically NotNull: error as default, or no condition as option)
     */
    public void setRandomKeywordId_Equal(Integer randomKeywordId) {
        doSetRandomKeywordId_Equal(randomKeywordId);
    }

    protected void doSetRandomKeywordId_Equal(Integer randomKeywordId) {
        regRandomKeywordId(CK_EQ, randomKeywordId);
    }

    /**
     * NotEqual(&lt;&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * RANDOM_KEYWORD_ID: {PK, ID, NotNull, INT UNSIGNED(10)}
     * @param randomKeywordId The value of randomKeywordId as notEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setRandomKeywordId_NotEqual(Integer randomKeywordId) {
        doSetRandomKeywordId_NotEqual(randomKeywordId);
    }

    protected void doSetRandomKeywordId_NotEqual(Integer randomKeywordId) {
        regRandomKeywordId(CK_NES, randomKeywordId);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * RANDOM_KEYWORD_ID: {PK, ID, NotNull, INT UNSIGNED(10)}
     * @param randomKeywordId The value of randomKeywordId as greaterThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setRandomKeywordId_GreaterThan(Integer randomKeywordId) {
        regRandomKeywordId(CK_GT, randomKeywordId);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br>
     * RANDOM_KEYWORD_ID: {PK, ID, NotNull, INT UNSIGNED(10)}
     * @param randomKeywordId The value of randomKeywordId as lessThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setRandomKeywordId_LessThan(Integer randomKeywordId) {
        regRandomKeywordId(CK_LT, randomKeywordId);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * RANDOM_KEYWORD_ID: {PK, ID, NotNull, INT UNSIGNED(10)}
     * @param randomKeywordId The value of randomKeywordId as greaterEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setRandomKeywordId_GreaterEqual(Integer randomKeywordId) {
        regRandomKeywordId(CK_GE, randomKeywordId);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * RANDOM_KEYWORD_ID: {PK, ID, NotNull, INT UNSIGNED(10)}
     * @param randomKeywordId The value of randomKeywordId as lessEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setRandomKeywordId_LessEqual(Integer randomKeywordId) {
        regRandomKeywordId(CK_LE, randomKeywordId);
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * RANDOM_KEYWORD_ID: {PK, ID, NotNull, INT UNSIGNED(10)}
     * @param minNumber The min number of randomKeywordId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param maxNumber The max number of randomKeywordId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param opLambda The callback for option of range-of. (NotNull)
     */
    public void setRandomKeywordId_RangeOf(Integer minNumber, Integer maxNumber, ConditionOptionCall<RangeOfOption> opLambda) {
        setRandomKeywordId_RangeOf(minNumber, maxNumber, xcROOP(opLambda));
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * RANDOM_KEYWORD_ID: {PK, ID, NotNull, INT UNSIGNED(10)}
     * @param minNumber The min number of randomKeywordId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param maxNumber The max number of randomKeywordId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    protected void setRandomKeywordId_RangeOf(Integer minNumber, Integer maxNumber, RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, xgetCValueRandomKeywordId(), "RANDOM_KEYWORD_ID", rangeOfOption);
    }

    /**
     * InScope {in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * RANDOM_KEYWORD_ID: {PK, ID, NotNull, INT UNSIGNED(10)}
     * @param randomKeywordIdList The collection of randomKeywordId as inScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setRandomKeywordId_InScope(Collection<Integer> randomKeywordIdList) {
        doSetRandomKeywordId_InScope(randomKeywordIdList);
    }

    protected void doSetRandomKeywordId_InScope(Collection<Integer> randomKeywordIdList) {
        regINS(CK_INS, cTL(randomKeywordIdList), xgetCValueRandomKeywordId(), "RANDOM_KEYWORD_ID");
    }

    /**
     * NotInScope {not in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * RANDOM_KEYWORD_ID: {PK, ID, NotNull, INT UNSIGNED(10)}
     * @param randomKeywordIdList The collection of randomKeywordId as notInScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setRandomKeywordId_NotInScope(Collection<Integer> randomKeywordIdList) {
        doSetRandomKeywordId_NotInScope(randomKeywordIdList);
    }

    protected void doSetRandomKeywordId_NotInScope(Collection<Integer> randomKeywordIdList) {
        regINS(CK_NINS, cTL(randomKeywordIdList), xgetCValueRandomKeywordId(), "RANDOM_KEYWORD_ID");
    }

    /**
     * Set up ExistsReferrer (correlated sub-query). <br>
     * {exists (select RANDOM_KEYWORD_ID from random_content where ...)} <br>
     * random_content by RANDOM_KEYWORD_ID, named 'randomContentAsOne'.
     * <pre>
     * cb.query().<span style="color: #CC4747">existsRandomContent</span>(contentCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     contentCB.query().set...
     * });
     * </pre>
     * @param subCBLambda The callback for sub-query of RandomContentList for 'exists'. (NotNull)
     */
    public void existsRandomContent(SubQuery<RandomContentCB> subCBLambda) {
        assertObjectNotNull("subCBLambda", subCBLambda);
        RandomContentCB cb = new RandomContentCB(); cb.xsetupForExistsReferrer(this);
        lockCall(() -> subCBLambda.query(cb)); String pp = keepRandomKeywordId_ExistsReferrer_RandomContentList(cb.query());
        registerExistsReferrer(cb.query(), "RANDOM_KEYWORD_ID", "RANDOM_KEYWORD_ID", pp, "randomContentList");
    }
    public abstract String keepRandomKeywordId_ExistsReferrer_RandomContentList(RandomContentCQ sq);

    /**
     * Set up NotExistsReferrer (correlated sub-query). <br>
     * {not exists (select RANDOM_KEYWORD_ID from random_content where ...)} <br>
     * random_content by RANDOM_KEYWORD_ID, named 'randomContentAsOne'.
     * <pre>
     * cb.query().<span style="color: #CC4747">notExistsRandomContent</span>(contentCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     contentCB.query().set...
     * });
     * </pre>
     * @param subCBLambda The callback for sub-query of RandomKeywordId_NotExistsReferrer_RandomContentList for 'not exists'. (NotNull)
     */
    public void notExistsRandomContent(SubQuery<RandomContentCB> subCBLambda) {
        assertObjectNotNull("subCBLambda", subCBLambda);
        RandomContentCB cb = new RandomContentCB(); cb.xsetupForExistsReferrer(this);
        lockCall(() -> subCBLambda.query(cb)); String pp = keepRandomKeywordId_NotExistsReferrer_RandomContentList(cb.query());
        registerNotExistsReferrer(cb.query(), "RANDOM_KEYWORD_ID", "RANDOM_KEYWORD_ID", pp, "randomContentList");
    }
    public abstract String keepRandomKeywordId_NotExistsReferrer_RandomContentList(RandomContentCQ sq);

    public void xsderiveRandomContentList(String fn, SubQuery<RandomContentCB> sq, String al, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        RandomContentCB cb = new RandomContentCB(); cb.xsetupForDerivedReferrer(this);
        lockCall(() -> sq.query(cb)); String pp = keepRandomKeywordId_SpecifyDerivedReferrer_RandomContentList(cb.query());
        registerSpecifyDerivedReferrer(fn, cb.query(), "RANDOM_KEYWORD_ID", "RANDOM_KEYWORD_ID", pp, "randomContentList", al, op);
    }
    public abstract String keepRandomKeywordId_SpecifyDerivedReferrer_RandomContentList(RandomContentCQ sq);

    /**
     * Prepare for (Query)DerivedReferrer (correlated sub-query). <br>
     * {FOO &lt;= (select max(BAR) from random_content where ...)} <br>
     * random_content by RANDOM_KEYWORD_ID, named 'randomContentAsOne'.
     * <pre>
     * cb.query().<span style="color: #CC4747">derivedRandomContent()</span>.<span style="color: #CC4747">max</span>(contentCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     contentCB.specify().<span style="color: #CC4747">columnFoo...</span> <span style="color: #3F7E5E">// derived column by function</span>
     *     contentCB.query().setBar... <span style="color: #3F7E5E">// referrer condition</span>
     * }).<span style="color: #CC4747">greaterEqual</span>(123); <span style="color: #3F7E5E">// condition to derived column</span>
     * </pre>
     * @return The object to set up a function for referrer table. (NotNull)
     */
    public HpQDRFunction<RandomContentCB> derivedRandomContent() {
        return xcreateQDRFunctionRandomContentList();
    }
    protected HpQDRFunction<RandomContentCB> xcreateQDRFunctionRandomContentList() {
        return xcQDRFunc((fn, sq, rd, vl, op) -> xqderiveRandomContentList(fn, sq, rd, vl, op));
    }
    public void xqderiveRandomContentList(String fn, SubQuery<RandomContentCB> sq, String rd, Object vl, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        RandomContentCB cb = new RandomContentCB(); cb.xsetupForDerivedReferrer(this);
        lockCall(() -> sq.query(cb)); String sqpp = keepRandomKeywordId_QueryDerivedReferrer_RandomContentList(cb.query()); String prpp = keepRandomKeywordId_QueryDerivedReferrer_RandomContentListParameter(vl);
        registerQueryDerivedReferrer(fn, cb.query(), "RANDOM_KEYWORD_ID", "RANDOM_KEYWORD_ID", sqpp, "randomContentList", rd, vl, prpp, op);
    }
    public abstract String keepRandomKeywordId_QueryDerivedReferrer_RandomContentList(RandomContentCQ sq);
    public abstract String keepRandomKeywordId_QueryDerivedReferrer_RandomContentListParameter(Object vl);

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br>
     * RANDOM_KEYWORD_ID: {PK, ID, NotNull, INT UNSIGNED(10)}
     */
    public void setRandomKeywordId_IsNull() { regRandomKeywordId(CK_ISN, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br>
     * RANDOM_KEYWORD_ID: {PK, ID, NotNull, INT UNSIGNED(10)}
     */
    public void setRandomKeywordId_IsNotNull() { regRandomKeywordId(CK_ISNN, DOBJ); }

    protected void regRandomKeywordId(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueRandomKeywordId(), "RANDOM_KEYWORD_ID"); }
    protected abstract ConditionValue xgetCValueRandomKeywordId();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * KEYWORD: {UQ, NotNull, VARCHAR(10)}
     * @param keyword The value of keyword as equal. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setKeyword_Equal(String keyword) {
        doSetKeyword_Equal(fRES(keyword));
    }

    protected void doSetKeyword_Equal(String keyword) {
        regKeyword(CK_EQ, keyword);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * KEYWORD: {UQ, NotNull, VARCHAR(10)}
     * @param keyword The value of keyword as notEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setKeyword_NotEqual(String keyword) {
        doSetKeyword_NotEqual(fRES(keyword));
    }

    protected void doSetKeyword_NotEqual(String keyword) {
        regKeyword(CK_NES, keyword);
    }

    /**
     * GreaterThan(&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * KEYWORD: {UQ, NotNull, VARCHAR(10)}
     * @param keyword The value of keyword as greaterThan. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setKeyword_GreaterThan(String keyword) {
        regKeyword(CK_GT, fRES(keyword));
    }

    /**
     * LessThan(&lt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * KEYWORD: {UQ, NotNull, VARCHAR(10)}
     * @param keyword The value of keyword as lessThan. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setKeyword_LessThan(String keyword) {
        regKeyword(CK_LT, fRES(keyword));
    }

    /**
     * GreaterEqual(&gt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * KEYWORD: {UQ, NotNull, VARCHAR(10)}
     * @param keyword The value of keyword as greaterEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setKeyword_GreaterEqual(String keyword) {
        regKeyword(CK_GE, fRES(keyword));
    }

    /**
     * LessEqual(&lt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * KEYWORD: {UQ, NotNull, VARCHAR(10)}
     * @param keyword The value of keyword as lessEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setKeyword_LessEqual(String keyword) {
        regKeyword(CK_LE, fRES(keyword));
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * KEYWORD: {UQ, NotNull, VARCHAR(10)}
     * @param keywordList The collection of keyword as inScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setKeyword_InScope(Collection<String> keywordList) {
        doSetKeyword_InScope(keywordList);
    }

    protected void doSetKeyword_InScope(Collection<String> keywordList) {
        regINS(CK_INS, cTL(keywordList), xgetCValueKeyword(), "KEYWORD");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * KEYWORD: {UQ, NotNull, VARCHAR(10)}
     * @param keywordList The collection of keyword as notInScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setKeyword_NotInScope(Collection<String> keywordList) {
        doSetKeyword_NotInScope(keywordList);
    }

    protected void doSetKeyword_NotInScope(Collection<String> keywordList) {
        regINS(CK_NINS, cTL(keywordList), xgetCValueKeyword(), "KEYWORD");
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * KEYWORD: {UQ, NotNull, VARCHAR(10)} <br>
     * <pre>e.g. setKeyword_LikeSearch("xxx", op <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> op.<span style="color: #CC4747">likeContain()</span>);</pre>
     * @param keyword The value of keyword as likeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setKeyword_LikeSearch(String keyword, ConditionOptionCall<LikeSearchOption> opLambda) {
        setKeyword_LikeSearch(keyword, xcLSOP(opLambda));
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * KEYWORD: {UQ, NotNull, VARCHAR(10)} <br>
     * <pre>e.g. setKeyword_LikeSearch("xxx", new <span style="color: #CC4747">LikeSearchOption</span>().likeContain());</pre>
     * @param keyword The value of keyword as likeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    protected void setKeyword_LikeSearch(String keyword, LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(keyword), xgetCValueKeyword(), "KEYWORD", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * KEYWORD: {UQ, NotNull, VARCHAR(10)}
     * @param keyword The value of keyword as notLikeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setKeyword_NotLikeSearch(String keyword, ConditionOptionCall<LikeSearchOption> opLambda) {
        setKeyword_NotLikeSearch(keyword, xcLSOP(opLambda));
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * KEYWORD: {UQ, NotNull, VARCHAR(10)}
     * @param keyword The value of keyword as notLikeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    protected void setKeyword_NotLikeSearch(String keyword, LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(keyword), xgetCValueKeyword(), "KEYWORD", likeSearchOption);
    }

    protected void regKeyword(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueKeyword(), "KEYWORD"); }
    protected abstract ConditionValue xgetCValueKeyword();

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
    public HpSLCFunction<RandomKeywordCB> scalar_Equal() {
        return xcreateSLCFunction(CK_EQ, RandomKeywordCB.class);
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
    public HpSLCFunction<RandomKeywordCB> scalar_NotEqual() {
        return xcreateSLCFunction(CK_NES, RandomKeywordCB.class);
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
    public HpSLCFunction<RandomKeywordCB> scalar_GreaterThan() {
        return xcreateSLCFunction(CK_GT, RandomKeywordCB.class);
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
    public HpSLCFunction<RandomKeywordCB> scalar_LessThan() {
        return xcreateSLCFunction(CK_LT, RandomKeywordCB.class);
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
    public HpSLCFunction<RandomKeywordCB> scalar_GreaterEqual() {
        return xcreateSLCFunction(CK_GE, RandomKeywordCB.class);
    }

    /**
     * Prepare ScalarCondition as lessEqual. <br>
     * {where FOO &lt;= (select max(BAR) from ...)}
     * <pre>
     * cb.query().<span style="color: #CC4747">scalar_LessEqual()</span>.max(new SubQuery&lt;RandomKeywordCB&gt;() {
     *     public void query(RandomKeywordCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSLCFunction<RandomKeywordCB> scalar_LessEqual() {
        return xcreateSLCFunction(CK_LE, RandomKeywordCB.class);
    }

    @SuppressWarnings("unchecked")
    protected <CB extends ConditionBean> void xscalarCondition(String fn, SubQuery<CB> sq, String rd, HpSLCCustomized<CB> cs, ScalarConditionOption op) {
        assertObjectNotNull("subQuery", sq);
        RandomKeywordCB cb = xcreateScalarConditionCB(); sq.query((CB)cb);
        String pp = keepScalarCondition(cb.query()); // for saving query-value
        cs.setPartitionByCBean((CB)xcreateScalarConditionPartitionByCB()); // for using partition-by
        registerScalarCondition(fn, cb.query(), pp, rd, cs, op);
    }
    public abstract String keepScalarCondition(RandomKeywordCQ sq);

    protected RandomKeywordCB xcreateScalarConditionCB() {
        RandomKeywordCB cb = newMyCB(); cb.xsetupForScalarCondition(this); return cb;
    }

    protected RandomKeywordCB xcreateScalarConditionPartitionByCB() {
        RandomKeywordCB cb = newMyCB(); cb.xsetupForScalarConditionPartitionBy(this); return cb;
    }

    // ===================================================================================
    //                                                                       MyselfDerived
    //                                                                       =============
    public void xsmyselfDerive(String fn, SubQuery<RandomKeywordCB> sq, String al, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        RandomKeywordCB cb = new RandomKeywordCB(); cb.xsetupForDerivedReferrer(this);
        lockCall(() -> sq.query(cb)); String pp = keepSpecifyMyselfDerived(cb.query()); String pk = "RANDOM_KEYWORD_ID";
        registerSpecifyMyselfDerived(fn, cb.query(), pk, pk, pp, "myselfDerived", al, op);
    }
    public abstract String keepSpecifyMyselfDerived(RandomKeywordCQ sq);

    /**
     * Prepare for (Query)MyselfDerived (correlated sub-query).
     * @return The object to set up a function for myself table. (NotNull)
     */
    public HpQDRFunction<RandomKeywordCB> myselfDerived() {
        return xcreateQDRFunctionMyselfDerived(RandomKeywordCB.class);
    }
    @SuppressWarnings("unchecked")
    protected <CB extends ConditionBean> void xqderiveMyselfDerived(String fn, SubQuery<CB> sq, String rd, Object vl, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        RandomKeywordCB cb = new RandomKeywordCB(); cb.xsetupForDerivedReferrer(this); sq.query((CB)cb);
        String pk = "RANDOM_KEYWORD_ID";
        String sqpp = keepQueryMyselfDerived(cb.query()); // for saving query-value.
        String prpp = keepQueryMyselfDerivedParameter(vl);
        registerQueryMyselfDerived(fn, cb.query(), pk, pk, sqpp, "myselfDerived", rd, vl, prpp, op);
    }
    public abstract String keepQueryMyselfDerived(RandomKeywordCQ sq);
    public abstract String keepQueryMyselfDerivedParameter(Object vl);

    // ===================================================================================
    //                                                                        MyselfExists
    //                                                                        ============
    /**
     * Prepare for MyselfExists (correlated sub-query).
     * @param subCBLambda The implementation of sub-query. (NotNull)
     */
    public void myselfExists(SubQuery<RandomKeywordCB> subCBLambda) {
        assertObjectNotNull("subCBLambda", subCBLambda);
        RandomKeywordCB cb = new RandomKeywordCB(); cb.xsetupForMyselfExists(this);
        lockCall(() -> subCBLambda.query(cb)); String pp = keepMyselfExists(cb.query());
        registerMyselfExists(cb.query(), pp);
    }
    public abstract String keepMyselfExists(RandomKeywordCQ sq);

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
    protected RandomKeywordCB newMyCB() {
        return new RandomKeywordCB();
    }
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xabUDT() { return Date.class.getName(); }
    protected String xabCQ() { return RandomKeywordCQ.class.getName(); }
    protected String xabLSO() { return LikeSearchOption.class.getName(); }
    protected String xabSLCS() { return HpSLCSetupper.class.getName(); }
    protected String xabSCP() { return SubQuery.class.getName(); }
}
