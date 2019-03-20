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
 * The abstract condition-query of random_content.
 * @author DBFlute(AutoGenerator)
 */
public abstract class AbstractBsRandomContentCQ extends AbstractConditionQuery {

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public AbstractBsRandomContentCQ(ConditionQuery referrerQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
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
        return "random_content";
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====
    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br>
     * RANDOM_CONTENT_ID: {PK, ID, NotNull, INT UNSIGNED(10)}
     * @param randomContentId The value of randomContentId as equal. (basically NotNull: error as default, or no condition as option)
     */
    public void setRandomContentId_Equal(Integer randomContentId) {
        doSetRandomContentId_Equal(randomContentId);
    }

    protected void doSetRandomContentId_Equal(Integer randomContentId) {
        regRandomContentId(CK_EQ, randomContentId);
    }

    /**
     * NotEqual(&lt;&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * RANDOM_CONTENT_ID: {PK, ID, NotNull, INT UNSIGNED(10)}
     * @param randomContentId The value of randomContentId as notEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setRandomContentId_NotEqual(Integer randomContentId) {
        doSetRandomContentId_NotEqual(randomContentId);
    }

    protected void doSetRandomContentId_NotEqual(Integer randomContentId) {
        regRandomContentId(CK_NES, randomContentId);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * RANDOM_CONTENT_ID: {PK, ID, NotNull, INT UNSIGNED(10)}
     * @param randomContentId The value of randomContentId as greaterThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setRandomContentId_GreaterThan(Integer randomContentId) {
        regRandomContentId(CK_GT, randomContentId);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br>
     * RANDOM_CONTENT_ID: {PK, ID, NotNull, INT UNSIGNED(10)}
     * @param randomContentId The value of randomContentId as lessThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setRandomContentId_LessThan(Integer randomContentId) {
        regRandomContentId(CK_LT, randomContentId);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * RANDOM_CONTENT_ID: {PK, ID, NotNull, INT UNSIGNED(10)}
     * @param randomContentId The value of randomContentId as greaterEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setRandomContentId_GreaterEqual(Integer randomContentId) {
        regRandomContentId(CK_GE, randomContentId);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * RANDOM_CONTENT_ID: {PK, ID, NotNull, INT UNSIGNED(10)}
     * @param randomContentId The value of randomContentId as lessEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setRandomContentId_LessEqual(Integer randomContentId) {
        regRandomContentId(CK_LE, randomContentId);
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * RANDOM_CONTENT_ID: {PK, ID, NotNull, INT UNSIGNED(10)}
     * @param minNumber The min number of randomContentId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param maxNumber The max number of randomContentId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param opLambda The callback for option of range-of. (NotNull)
     */
    public void setRandomContentId_RangeOf(Integer minNumber, Integer maxNumber, ConditionOptionCall<RangeOfOption> opLambda) {
        setRandomContentId_RangeOf(minNumber, maxNumber, xcROOP(opLambda));
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * RANDOM_CONTENT_ID: {PK, ID, NotNull, INT UNSIGNED(10)}
     * @param minNumber The min number of randomContentId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param maxNumber The max number of randomContentId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    protected void setRandomContentId_RangeOf(Integer minNumber, Integer maxNumber, RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, xgetCValueRandomContentId(), "RANDOM_CONTENT_ID", rangeOfOption);
    }

    /**
     * InScope {in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * RANDOM_CONTENT_ID: {PK, ID, NotNull, INT UNSIGNED(10)}
     * @param randomContentIdList The collection of randomContentId as inScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setRandomContentId_InScope(Collection<Integer> randomContentIdList) {
        doSetRandomContentId_InScope(randomContentIdList);
    }

    protected void doSetRandomContentId_InScope(Collection<Integer> randomContentIdList) {
        regINS(CK_INS, cTL(randomContentIdList), xgetCValueRandomContentId(), "RANDOM_CONTENT_ID");
    }

    /**
     * NotInScope {not in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * RANDOM_CONTENT_ID: {PK, ID, NotNull, INT UNSIGNED(10)}
     * @param randomContentIdList The collection of randomContentId as notInScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setRandomContentId_NotInScope(Collection<Integer> randomContentIdList) {
        doSetRandomContentId_NotInScope(randomContentIdList);
    }

    protected void doSetRandomContentId_NotInScope(Collection<Integer> randomContentIdList) {
        regINS(CK_NINS, cTL(randomContentIdList), xgetCValueRandomContentId(), "RANDOM_CONTENT_ID");
    }

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br>
     * RANDOM_CONTENT_ID: {PK, ID, NotNull, INT UNSIGNED(10)}
     */
    public void setRandomContentId_IsNull() { regRandomContentId(CK_ISN, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br>
     * RANDOM_CONTENT_ID: {PK, ID, NotNull, INT UNSIGNED(10)}
     */
    public void setRandomContentId_IsNotNull() { regRandomContentId(CK_ISNN, DOBJ); }

    protected void regRandomContentId(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueRandomContentId(), "RANDOM_CONTENT_ID"); }
    protected abstract ConditionValue xgetCValueRandomContentId();

    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br>
     * RANDOM_KEYWORD_ID: {IX, NotNull, INT UNSIGNED(10), FK to random_keyword}
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
     * RANDOM_KEYWORD_ID: {IX, NotNull, INT UNSIGNED(10), FK to random_keyword}
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
     * RANDOM_KEYWORD_ID: {IX, NotNull, INT UNSIGNED(10), FK to random_keyword}
     * @param randomKeywordId The value of randomKeywordId as greaterThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setRandomKeywordId_GreaterThan(Integer randomKeywordId) {
        regRandomKeywordId(CK_GT, randomKeywordId);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br>
     * RANDOM_KEYWORD_ID: {IX, NotNull, INT UNSIGNED(10), FK to random_keyword}
     * @param randomKeywordId The value of randomKeywordId as lessThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setRandomKeywordId_LessThan(Integer randomKeywordId) {
        regRandomKeywordId(CK_LT, randomKeywordId);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * RANDOM_KEYWORD_ID: {IX, NotNull, INT UNSIGNED(10), FK to random_keyword}
     * @param randomKeywordId The value of randomKeywordId as greaterEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setRandomKeywordId_GreaterEqual(Integer randomKeywordId) {
        regRandomKeywordId(CK_GE, randomKeywordId);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * RANDOM_KEYWORD_ID: {IX, NotNull, INT UNSIGNED(10), FK to random_keyword}
     * @param randomKeywordId The value of randomKeywordId as lessEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setRandomKeywordId_LessEqual(Integer randomKeywordId) {
        regRandomKeywordId(CK_LE, randomKeywordId);
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * RANDOM_KEYWORD_ID: {IX, NotNull, INT UNSIGNED(10), FK to random_keyword}
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
     * RANDOM_KEYWORD_ID: {IX, NotNull, INT UNSIGNED(10), FK to random_keyword}
     * @param minNumber The min number of randomKeywordId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param maxNumber The max number of randomKeywordId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    protected void setRandomKeywordId_RangeOf(Integer minNumber, Integer maxNumber, RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, xgetCValueRandomKeywordId(), "RANDOM_KEYWORD_ID", rangeOfOption);
    }

    /**
     * InScope {in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * RANDOM_KEYWORD_ID: {IX, NotNull, INT UNSIGNED(10), FK to random_keyword}
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
     * RANDOM_KEYWORD_ID: {IX, NotNull, INT UNSIGNED(10), FK to random_keyword}
     * @param randomKeywordIdList The collection of randomKeywordId as notInScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setRandomKeywordId_NotInScope(Collection<Integer> randomKeywordIdList) {
        doSetRandomKeywordId_NotInScope(randomKeywordIdList);
    }

    protected void doSetRandomKeywordId_NotInScope(Collection<Integer> randomKeywordIdList) {
        regINS(CK_NINS, cTL(randomKeywordIdList), xgetCValueRandomKeywordId(), "RANDOM_KEYWORD_ID");
    }

    protected void regRandomKeywordId(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueRandomKeywordId(), "RANDOM_KEYWORD_ID"); }
    protected abstract ConditionValue xgetCValueRandomKeywordId();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * RANDOM_MESSAGE: {NotNull, VARCHAR(20)}
     * @param randomMessage The value of randomMessage as equal. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setRandomMessage_Equal(String randomMessage) {
        doSetRandomMessage_Equal(fRES(randomMessage));
    }

    protected void doSetRandomMessage_Equal(String randomMessage) {
        regRandomMessage(CK_EQ, randomMessage);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * RANDOM_MESSAGE: {NotNull, VARCHAR(20)}
     * @param randomMessage The value of randomMessage as notEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setRandomMessage_NotEqual(String randomMessage) {
        doSetRandomMessage_NotEqual(fRES(randomMessage));
    }

    protected void doSetRandomMessage_NotEqual(String randomMessage) {
        regRandomMessage(CK_NES, randomMessage);
    }

    /**
     * GreaterThan(&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * RANDOM_MESSAGE: {NotNull, VARCHAR(20)}
     * @param randomMessage The value of randomMessage as greaterThan. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setRandomMessage_GreaterThan(String randomMessage) {
        regRandomMessage(CK_GT, fRES(randomMessage));
    }

    /**
     * LessThan(&lt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * RANDOM_MESSAGE: {NotNull, VARCHAR(20)}
     * @param randomMessage The value of randomMessage as lessThan. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setRandomMessage_LessThan(String randomMessage) {
        regRandomMessage(CK_LT, fRES(randomMessage));
    }

    /**
     * GreaterEqual(&gt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * RANDOM_MESSAGE: {NotNull, VARCHAR(20)}
     * @param randomMessage The value of randomMessage as greaterEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setRandomMessage_GreaterEqual(String randomMessage) {
        regRandomMessage(CK_GE, fRES(randomMessage));
    }

    /**
     * LessEqual(&lt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * RANDOM_MESSAGE: {NotNull, VARCHAR(20)}
     * @param randomMessage The value of randomMessage as lessEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setRandomMessage_LessEqual(String randomMessage) {
        regRandomMessage(CK_LE, fRES(randomMessage));
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * RANDOM_MESSAGE: {NotNull, VARCHAR(20)}
     * @param randomMessageList The collection of randomMessage as inScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setRandomMessage_InScope(Collection<String> randomMessageList) {
        doSetRandomMessage_InScope(randomMessageList);
    }

    protected void doSetRandomMessage_InScope(Collection<String> randomMessageList) {
        regINS(CK_INS, cTL(randomMessageList), xgetCValueRandomMessage(), "RANDOM_MESSAGE");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * RANDOM_MESSAGE: {NotNull, VARCHAR(20)}
     * @param randomMessageList The collection of randomMessage as notInScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setRandomMessage_NotInScope(Collection<String> randomMessageList) {
        doSetRandomMessage_NotInScope(randomMessageList);
    }

    protected void doSetRandomMessage_NotInScope(Collection<String> randomMessageList) {
        regINS(CK_NINS, cTL(randomMessageList), xgetCValueRandomMessage(), "RANDOM_MESSAGE");
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * RANDOM_MESSAGE: {NotNull, VARCHAR(20)} <br>
     * <pre>e.g. setRandomMessage_LikeSearch("xxx", op <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> op.<span style="color: #CC4747">likeContain()</span>);</pre>
     * @param randomMessage The value of randomMessage as likeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setRandomMessage_LikeSearch(String randomMessage, ConditionOptionCall<LikeSearchOption> opLambda) {
        setRandomMessage_LikeSearch(randomMessage, xcLSOP(opLambda));
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * RANDOM_MESSAGE: {NotNull, VARCHAR(20)} <br>
     * <pre>e.g. setRandomMessage_LikeSearch("xxx", new <span style="color: #CC4747">LikeSearchOption</span>().likeContain());</pre>
     * @param randomMessage The value of randomMessage as likeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    protected void setRandomMessage_LikeSearch(String randomMessage, LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(randomMessage), xgetCValueRandomMessage(), "RANDOM_MESSAGE", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * RANDOM_MESSAGE: {NotNull, VARCHAR(20)}
     * @param randomMessage The value of randomMessage as notLikeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setRandomMessage_NotLikeSearch(String randomMessage, ConditionOptionCall<LikeSearchOption> opLambda) {
        setRandomMessage_NotLikeSearch(randomMessage, xcLSOP(opLambda));
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * RANDOM_MESSAGE: {NotNull, VARCHAR(20)}
     * @param randomMessage The value of randomMessage as notLikeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    protected void setRandomMessage_NotLikeSearch(String randomMessage, LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(randomMessage), xgetCValueRandomMessage(), "RANDOM_MESSAGE", likeSearchOption);
    }

    protected void regRandomMessage(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueRandomMessage(), "RANDOM_MESSAGE"); }
    protected abstract ConditionValue xgetCValueRandomMessage();

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
    public HpSLCFunction<RandomContentCB> scalar_Equal() {
        return xcreateSLCFunction(CK_EQ, RandomContentCB.class);
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
    public HpSLCFunction<RandomContentCB> scalar_NotEqual() {
        return xcreateSLCFunction(CK_NES, RandomContentCB.class);
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
    public HpSLCFunction<RandomContentCB> scalar_GreaterThan() {
        return xcreateSLCFunction(CK_GT, RandomContentCB.class);
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
    public HpSLCFunction<RandomContentCB> scalar_LessThan() {
        return xcreateSLCFunction(CK_LT, RandomContentCB.class);
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
    public HpSLCFunction<RandomContentCB> scalar_GreaterEqual() {
        return xcreateSLCFunction(CK_GE, RandomContentCB.class);
    }

    /**
     * Prepare ScalarCondition as lessEqual. <br>
     * {where FOO &lt;= (select max(BAR) from ...)}
     * <pre>
     * cb.query().<span style="color: #CC4747">scalar_LessEqual()</span>.max(new SubQuery&lt;RandomContentCB&gt;() {
     *     public void query(RandomContentCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSLCFunction<RandomContentCB> scalar_LessEqual() {
        return xcreateSLCFunction(CK_LE, RandomContentCB.class);
    }

    @SuppressWarnings("unchecked")
    protected <CB extends ConditionBean> void xscalarCondition(String fn, SubQuery<CB> sq, String rd, HpSLCCustomized<CB> cs, ScalarConditionOption op) {
        assertObjectNotNull("subQuery", sq);
        RandomContentCB cb = xcreateScalarConditionCB(); sq.query((CB)cb);
        String pp = keepScalarCondition(cb.query()); // for saving query-value
        cs.setPartitionByCBean((CB)xcreateScalarConditionPartitionByCB()); // for using partition-by
        registerScalarCondition(fn, cb.query(), pp, rd, cs, op);
    }
    public abstract String keepScalarCondition(RandomContentCQ sq);

    protected RandomContentCB xcreateScalarConditionCB() {
        RandomContentCB cb = newMyCB(); cb.xsetupForScalarCondition(this); return cb;
    }

    protected RandomContentCB xcreateScalarConditionPartitionByCB() {
        RandomContentCB cb = newMyCB(); cb.xsetupForScalarConditionPartitionBy(this); return cb;
    }

    // ===================================================================================
    //                                                                       MyselfDerived
    //                                                                       =============
    public void xsmyselfDerive(String fn, SubQuery<RandomContentCB> sq, String al, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        RandomContentCB cb = new RandomContentCB(); cb.xsetupForDerivedReferrer(this);
        lockCall(() -> sq.query(cb)); String pp = keepSpecifyMyselfDerived(cb.query()); String pk = "RANDOM_CONTENT_ID";
        registerSpecifyMyselfDerived(fn, cb.query(), pk, pk, pp, "myselfDerived", al, op);
    }
    public abstract String keepSpecifyMyselfDerived(RandomContentCQ sq);

    /**
     * Prepare for (Query)MyselfDerived (correlated sub-query).
     * @return The object to set up a function for myself table. (NotNull)
     */
    public HpQDRFunction<RandomContentCB> myselfDerived() {
        return xcreateQDRFunctionMyselfDerived(RandomContentCB.class);
    }
    @SuppressWarnings("unchecked")
    protected <CB extends ConditionBean> void xqderiveMyselfDerived(String fn, SubQuery<CB> sq, String rd, Object vl, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        RandomContentCB cb = new RandomContentCB(); cb.xsetupForDerivedReferrer(this); sq.query((CB)cb);
        String pk = "RANDOM_CONTENT_ID";
        String sqpp = keepQueryMyselfDerived(cb.query()); // for saving query-value.
        String prpp = keepQueryMyselfDerivedParameter(vl);
        registerQueryMyselfDerived(fn, cb.query(), pk, pk, sqpp, "myselfDerived", rd, vl, prpp, op);
    }
    public abstract String keepQueryMyselfDerived(RandomContentCQ sq);
    public abstract String keepQueryMyselfDerivedParameter(Object vl);

    // ===================================================================================
    //                                                                        MyselfExists
    //                                                                        ============
    /**
     * Prepare for MyselfExists (correlated sub-query).
     * @param subCBLambda The implementation of sub-query. (NotNull)
     */
    public void myselfExists(SubQuery<RandomContentCB> subCBLambda) {
        assertObjectNotNull("subCBLambda", subCBLambda);
        RandomContentCB cb = new RandomContentCB(); cb.xsetupForMyselfExists(this);
        lockCall(() -> subCBLambda.query(cb)); String pp = keepMyselfExists(cb.query());
        registerMyselfExists(cb.query(), pp);
    }
    public abstract String keepMyselfExists(RandomContentCQ sq);

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
    protected RandomContentCB newMyCB() {
        return new RandomContentCB();
    }
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xabUDT() { return Date.class.getName(); }
    protected String xabCQ() { return RandomContentCQ.class.getName(); }
    protected String xabLSO() { return LikeSearchOption.class.getName(); }
    protected String xabSLCS() { return HpSLCSetupper.class.getName(); }
    protected String xabSCP() { return SubQuery.class.getName(); }
}
