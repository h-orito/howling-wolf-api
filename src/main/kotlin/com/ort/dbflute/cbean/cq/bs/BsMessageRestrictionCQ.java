package com.ort.dbflute.cbean.cq.bs;

import java.util.Map;

import org.dbflute.cbean.*;
import org.dbflute.cbean.chelper.*;
import org.dbflute.cbean.coption.*;
import org.dbflute.cbean.cvalue.ConditionValue;
import org.dbflute.cbean.sqlclause.SqlClause;
import org.dbflute.exception.IllegalConditionBeanOperationException;
import com.ort.dbflute.cbean.cq.ciq.*;
import com.ort.dbflute.cbean.*;
import com.ort.dbflute.cbean.cq.*;

/**
 * The base condition-query of message_restriction.
 * @author DBFlute(AutoGenerator)
 */
public class BsMessageRestrictionCQ extends AbstractBsMessageRestrictionCQ {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected MessageRestrictionCIQ _inlineQuery;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public BsMessageRestrictionCQ(ConditionQuery referrerQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
        super(referrerQuery, sqlClause, aliasName, nestLevel);
    }

    // ===================================================================================
    //                                                                 InlineView/OrClause
    //                                                                 ===================
    /**
     * Prepare InlineView query. <br>
     * {select ... from ... left outer join (select * from message_restriction) where FOO = [value] ...}
     * <pre>
     * cb.query().queryMemberStatus().<span style="color: #CC4747">inline()</span>.setFoo...;
     * </pre>
     * @return The condition-query for InlineView query. (NotNull)
     */
    public MessageRestrictionCIQ inline() {
        if (_inlineQuery == null) { _inlineQuery = xcreateCIQ(); }
        _inlineQuery.xsetOnClause(false); return _inlineQuery;
    }

    protected MessageRestrictionCIQ xcreateCIQ() {
        MessageRestrictionCIQ ciq = xnewCIQ();
        ciq.xsetBaseCB(_baseCB);
        return ciq;
    }

    protected MessageRestrictionCIQ xnewCIQ() {
        return new MessageRestrictionCIQ(xgetReferrerQuery(), xgetSqlClause(), xgetAliasName(), xgetNestLevel(), this);
    }

    /**
     * Prepare OnClause query. <br>
     * {select ... from ... left outer join message_restriction on ... and FOO = [value] ...}
     * <pre>
     * cb.query().queryMemberStatus().<span style="color: #CC4747">on()</span>.setFoo...;
     * </pre>
     * @return The condition-query for OnClause query. (NotNull)
     * @throws IllegalConditionBeanOperationException When this condition-query is base query.
     */
    public MessageRestrictionCIQ on() {
        if (isBaseQuery()) { throw new IllegalConditionBeanOperationException("OnClause for local table is unavailable!"); }
        MessageRestrictionCIQ inlineQuery = inline(); inlineQuery.xsetOnClause(true); return inlineQuery;
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====
    protected ConditionValue _villageId;
    public ConditionValue xdfgetVillageId()
    { if (_villageId == null) { _villageId = nCV(); }
      return _villageId; }
    protected ConditionValue xgetCValueVillageId() { return xdfgetVillageId(); }

    /** 
     * Add order-by as ascend. <br>
     * VILLAGE_ID: {PK, NotNull, INT UNSIGNED(10), FK to village}
     * @return this. (NotNull)
     */
    public BsMessageRestrictionCQ addOrderBy_VillageId_Asc() { regOBA("VILLAGE_ID"); return this; }

    /**
     * Add order-by as descend. <br>
     * VILLAGE_ID: {PK, NotNull, INT UNSIGNED(10), FK to village}
     * @return this. (NotNull)
     */
    public BsMessageRestrictionCQ addOrderBy_VillageId_Desc() { regOBD("VILLAGE_ID"); return this; }

    protected ConditionValue _skillCode;
    public ConditionValue xdfgetSkillCode()
    { if (_skillCode == null) { _skillCode = nCV(); }
      return _skillCode; }
    protected ConditionValue xgetCValueSkillCode() { return xdfgetSkillCode(); }

    /** 
     * Add order-by as ascend. <br>
     * SKILL_CODE: {PK, IX, NotNull, VARCHAR(20), FK to skill, classification=Skill}
     * @return this. (NotNull)
     */
    public BsMessageRestrictionCQ addOrderBy_SkillCode_Asc() { regOBA("SKILL_CODE"); return this; }

    /**
     * Add order-by as descend. <br>
     * SKILL_CODE: {PK, IX, NotNull, VARCHAR(20), FK to skill, classification=Skill}
     * @return this. (NotNull)
     */
    public BsMessageRestrictionCQ addOrderBy_SkillCode_Desc() { regOBD("SKILL_CODE"); return this; }

    protected ConditionValue _messageTypeCode;
    public ConditionValue xdfgetMessageTypeCode()
    { if (_messageTypeCode == null) { _messageTypeCode = nCV(); }
      return _messageTypeCode; }
    protected ConditionValue xgetCValueMessageTypeCode() { return xdfgetMessageTypeCode(); }

    /** 
     * Add order-by as ascend. <br>
     * MESSAGE_TYPE_CODE: {PK, IX, NotNull, VARCHAR(20), FK to message_type, classification=MessageType}
     * @return this. (NotNull)
     */
    public BsMessageRestrictionCQ addOrderBy_MessageTypeCode_Asc() { regOBA("MESSAGE_TYPE_CODE"); return this; }

    /**
     * Add order-by as descend. <br>
     * MESSAGE_TYPE_CODE: {PK, IX, NotNull, VARCHAR(20), FK to message_type, classification=MessageType}
     * @return this. (NotNull)
     */
    public BsMessageRestrictionCQ addOrderBy_MessageTypeCode_Desc() { regOBD("MESSAGE_TYPE_CODE"); return this; }

    protected ConditionValue _messageMaxNum;
    public ConditionValue xdfgetMessageMaxNum()
    { if (_messageMaxNum == null) { _messageMaxNum = nCV(); }
      return _messageMaxNum; }
    protected ConditionValue xgetCValueMessageMaxNum() { return xdfgetMessageMaxNum(); }

    /** 
     * Add order-by as ascend. <br>
     * MESSAGE_MAX_NUM: {NotNull, INT UNSIGNED(10)}
     * @return this. (NotNull)
     */
    public BsMessageRestrictionCQ addOrderBy_MessageMaxNum_Asc() { regOBA("MESSAGE_MAX_NUM"); return this; }

    /**
     * Add order-by as descend. <br>
     * MESSAGE_MAX_NUM: {NotNull, INT UNSIGNED(10)}
     * @return this. (NotNull)
     */
    public BsMessageRestrictionCQ addOrderBy_MessageMaxNum_Desc() { regOBD("MESSAGE_MAX_NUM"); return this; }

    protected ConditionValue _messageMaxLength;
    public ConditionValue xdfgetMessageMaxLength()
    { if (_messageMaxLength == null) { _messageMaxLength = nCV(); }
      return _messageMaxLength; }
    protected ConditionValue xgetCValueMessageMaxLength() { return xdfgetMessageMaxLength(); }

    /** 
     * Add order-by as ascend. <br>
     * MESSAGE_MAX_LENGTH: {NotNull, INT UNSIGNED(10)}
     * @return this. (NotNull)
     */
    public BsMessageRestrictionCQ addOrderBy_MessageMaxLength_Asc() { regOBA("MESSAGE_MAX_LENGTH"); return this; }

    /**
     * Add order-by as descend. <br>
     * MESSAGE_MAX_LENGTH: {NotNull, INT UNSIGNED(10)}
     * @return this. (NotNull)
     */
    public BsMessageRestrictionCQ addOrderBy_MessageMaxLength_Desc() { regOBD("MESSAGE_MAX_LENGTH"); return this; }

    protected ConditionValue _registerDatetime;
    public ConditionValue xdfgetRegisterDatetime()
    { if (_registerDatetime == null) { _registerDatetime = nCV(); }
      return _registerDatetime; }
    protected ConditionValue xgetCValueRegisterDatetime() { return xdfgetRegisterDatetime(); }

    /** 
     * Add order-by as ascend. <br>
     * REGISTER_DATETIME: {NotNull, DATETIME(19)}
     * @return this. (NotNull)
     */
    public BsMessageRestrictionCQ addOrderBy_RegisterDatetime_Asc() { regOBA("REGISTER_DATETIME"); return this; }

    /**
     * Add order-by as descend. <br>
     * REGISTER_DATETIME: {NotNull, DATETIME(19)}
     * @return this. (NotNull)
     */
    public BsMessageRestrictionCQ addOrderBy_RegisterDatetime_Desc() { regOBD("REGISTER_DATETIME"); return this; }

    protected ConditionValue _registerTrace;
    public ConditionValue xdfgetRegisterTrace()
    { if (_registerTrace == null) { _registerTrace = nCV(); }
      return _registerTrace; }
    protected ConditionValue xgetCValueRegisterTrace() { return xdfgetRegisterTrace(); }

    /** 
     * Add order-by as ascend. <br>
     * REGISTER_TRACE: {NotNull, VARCHAR(64)}
     * @return this. (NotNull)
     */
    public BsMessageRestrictionCQ addOrderBy_RegisterTrace_Asc() { regOBA("REGISTER_TRACE"); return this; }

    /**
     * Add order-by as descend. <br>
     * REGISTER_TRACE: {NotNull, VARCHAR(64)}
     * @return this. (NotNull)
     */
    public BsMessageRestrictionCQ addOrderBy_RegisterTrace_Desc() { regOBD("REGISTER_TRACE"); return this; }

    protected ConditionValue _updateDatetime;
    public ConditionValue xdfgetUpdateDatetime()
    { if (_updateDatetime == null) { _updateDatetime = nCV(); }
      return _updateDatetime; }
    protected ConditionValue xgetCValueUpdateDatetime() { return xdfgetUpdateDatetime(); }

    /** 
     * Add order-by as ascend. <br>
     * UPDATE_DATETIME: {NotNull, DATETIME(19)}
     * @return this. (NotNull)
     */
    public BsMessageRestrictionCQ addOrderBy_UpdateDatetime_Asc() { regOBA("UPDATE_DATETIME"); return this; }

    /**
     * Add order-by as descend. <br>
     * UPDATE_DATETIME: {NotNull, DATETIME(19)}
     * @return this. (NotNull)
     */
    public BsMessageRestrictionCQ addOrderBy_UpdateDatetime_Desc() { regOBD("UPDATE_DATETIME"); return this; }

    protected ConditionValue _updateTrace;
    public ConditionValue xdfgetUpdateTrace()
    { if (_updateTrace == null) { _updateTrace = nCV(); }
      return _updateTrace; }
    protected ConditionValue xgetCValueUpdateTrace() { return xdfgetUpdateTrace(); }

    /** 
     * Add order-by as ascend. <br>
     * UPDATE_TRACE: {NotNull, VARCHAR(64)}
     * @return this. (NotNull)
     */
    public BsMessageRestrictionCQ addOrderBy_UpdateTrace_Asc() { regOBA("UPDATE_TRACE"); return this; }

    /**
     * Add order-by as descend. <br>
     * UPDATE_TRACE: {NotNull, VARCHAR(64)}
     * @return this. (NotNull)
     */
    public BsMessageRestrictionCQ addOrderBy_UpdateTrace_Desc() { regOBD("UPDATE_TRACE"); return this; }

    // ===================================================================================
    //                                                             SpecifiedDerivedOrderBy
    //                                                             =======================
    /**
     * Add order-by for specified derived column as ascend.
     * <pre>
     * cb.specify().derivedPurchaseList().max(new SubQuery&lt;PurchaseCB&gt;() {
     *     public void query(PurchaseCB subCB) {
     *         subCB.specify().columnPurchaseDatetime();
     *     }
     * }, <span style="color: #CC4747">aliasName</span>);
     * <span style="color: #3F7E5E">// order by [alias-name] asc</span>
     * cb.<span style="color: #CC4747">addSpecifiedDerivedOrderBy_Asc</span>(<span style="color: #CC4747">aliasName</span>);
     * </pre>
     * @param aliasName The alias name specified at (Specify)DerivedReferrer. (NotNull)
     * @return this. (NotNull)
     */
    public BsMessageRestrictionCQ addSpecifiedDerivedOrderBy_Asc(String aliasName) { registerSpecifiedDerivedOrderBy_Asc(aliasName); return this; }

    /**
     * Add order-by for specified derived column as descend.
     * <pre>
     * cb.specify().derivedPurchaseList().max(new SubQuery&lt;PurchaseCB&gt;() {
     *     public void query(PurchaseCB subCB) {
     *         subCB.specify().columnPurchaseDatetime();
     *     }
     * }, <span style="color: #CC4747">aliasName</span>);
     * <span style="color: #3F7E5E">// order by [alias-name] desc</span>
     * cb.<span style="color: #CC4747">addSpecifiedDerivedOrderBy_Desc</span>(<span style="color: #CC4747">aliasName</span>);
     * </pre>
     * @param aliasName The alias name specified at (Specify)DerivedReferrer. (NotNull)
     * @return this. (NotNull)
     */
    public BsMessageRestrictionCQ addSpecifiedDerivedOrderBy_Desc(String aliasName) { registerSpecifiedDerivedOrderBy_Desc(aliasName); return this; }

    // ===================================================================================
    //                                                                         Union Query
    //                                                                         ===========
    public void reflectRelationOnUnionQuery(ConditionQuery bqs, ConditionQuery uqs) {
        MessageRestrictionCQ bq = (MessageRestrictionCQ)bqs;
        MessageRestrictionCQ uq = (MessageRestrictionCQ)uqs;
        if (bq.hasConditionQueryMessageType()) {
            uq.queryMessageType().reflectRelationOnUnionQuery(bq.queryMessageType(), uq.queryMessageType());
        }
        if (bq.hasConditionQuerySkill()) {
            uq.querySkill().reflectRelationOnUnionQuery(bq.querySkill(), uq.querySkill());
        }
        if (bq.hasConditionQueryVillage()) {
            uq.queryVillage().reflectRelationOnUnionQuery(bq.queryVillage(), uq.queryVillage());
        }
    }

    // ===================================================================================
    //                                                                       Foreign Query
    //                                                                       =============
    /**
     * Get the condition-query for relation table. <br>
     * MESSAGE_TYPE by my MESSAGE_TYPE_CODE, named 'messageType'.
     * @return The instance of condition-query. (NotNull)
     */
    public MessageTypeCQ queryMessageType() {
        return xdfgetConditionQueryMessageType();
    }
    public MessageTypeCQ xdfgetConditionQueryMessageType() {
        String prop = "messageType";
        if (!xhasQueRlMap(prop)) { xregQueRl(prop, xcreateQueryMessageType()); xsetupOuterJoinMessageType(); }
        return xgetQueRlMap(prop);
    }
    protected MessageTypeCQ xcreateQueryMessageType() {
        String nrp = xresolveNRP("message_restriction", "messageType"); String jan = xresolveJAN(nrp, xgetNNLvl());
        return xinitRelCQ(new MessageTypeCQ(this, xgetSqlClause(), jan, xgetNNLvl()), _baseCB, "messageType", nrp);
    }
    protected void xsetupOuterJoinMessageType() { xregOutJo("messageType"); }
    public boolean hasConditionQueryMessageType() { return xhasQueRlMap("messageType"); }

    /**
     * Get the condition-query for relation table. <br>
     * SKILL by my SKILL_CODE, named 'skill'.
     * @return The instance of condition-query. (NotNull)
     */
    public SkillCQ querySkill() {
        return xdfgetConditionQuerySkill();
    }
    public SkillCQ xdfgetConditionQuerySkill() {
        String prop = "skill";
        if (!xhasQueRlMap(prop)) { xregQueRl(prop, xcreateQuerySkill()); xsetupOuterJoinSkill(); }
        return xgetQueRlMap(prop);
    }
    protected SkillCQ xcreateQuerySkill() {
        String nrp = xresolveNRP("message_restriction", "skill"); String jan = xresolveJAN(nrp, xgetNNLvl());
        return xinitRelCQ(new SkillCQ(this, xgetSqlClause(), jan, xgetNNLvl()), _baseCB, "skill", nrp);
    }
    protected void xsetupOuterJoinSkill() { xregOutJo("skill"); }
    public boolean hasConditionQuerySkill() { return xhasQueRlMap("skill"); }

    /**
     * Get the condition-query for relation table. <br>
     * VILLAGE by my VILLAGE_ID, named 'village'.
     * @return The instance of condition-query. (NotNull)
     */
    public VillageCQ queryVillage() {
        return xdfgetConditionQueryVillage();
    }
    public VillageCQ xdfgetConditionQueryVillage() {
        String prop = "village";
        if (!xhasQueRlMap(prop)) { xregQueRl(prop, xcreateQueryVillage()); xsetupOuterJoinVillage(); }
        return xgetQueRlMap(prop);
    }
    protected VillageCQ xcreateQueryVillage() {
        String nrp = xresolveNRP("message_restriction", "village"); String jan = xresolveJAN(nrp, xgetNNLvl());
        return xinitRelCQ(new VillageCQ(this, xgetSqlClause(), jan, xgetNNLvl()), _baseCB, "village", nrp);
    }
    protected void xsetupOuterJoinVillage() { xregOutJo("village"); }
    public boolean hasConditionQueryVillage() { return xhasQueRlMap("village"); }

    protected Map<String, Object> xfindFixedConditionDynamicParameterMap(String property) {
        return null;
    }

    // ===================================================================================
    //                                                                     ScalarCondition
    //                                                                     ===============
    public Map<String, MessageRestrictionCQ> xdfgetScalarCondition() { return xgetSQueMap("scalarCondition"); }
    public String keepScalarCondition(MessageRestrictionCQ sq) { return xkeepSQue("scalarCondition", sq); }

    // ===================================================================================
    //                                                                       Very Internal
    //                                                                       =============
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xCB() { return MessageRestrictionCB.class.getName(); }
    protected String xCQ() { return MessageRestrictionCQ.class.getName(); }
    protected String xCHp() { return HpQDRFunction.class.getName(); }
    protected String xCOp() { return ConditionOption.class.getName(); }
    protected String xMap() { return Map.class.getName(); }
}
