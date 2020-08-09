package com.ort.dbflute.cbean.cq.ciq;

import java.util.Map;
import org.dbflute.cbean.*;
import org.dbflute.cbean.ckey.*;
import org.dbflute.cbean.coption.ConditionOption;
import org.dbflute.cbean.cvalue.ConditionValue;
import org.dbflute.cbean.sqlclause.SqlClause;
import org.dbflute.exception.IllegalConditionBeanOperationException;
import com.ort.dbflute.cbean.*;
import com.ort.dbflute.cbean.cq.bs.*;
import com.ort.dbflute.cbean.cq.*;

/**
 * The condition-query for in-line of village_player.
 * @author DBFlute(AutoGenerator)
 */
public class VillagePlayerCIQ extends AbstractBsVillagePlayerCQ {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected BsVillagePlayerCQ _myCQ;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public VillagePlayerCIQ(ConditionQuery referrerQuery, SqlClause sqlClause
                        , String aliasName, int nestLevel, BsVillagePlayerCQ myCQ) {
        super(referrerQuery, sqlClause, aliasName, nestLevel);
        _myCQ = myCQ;
        _foreignPropertyName = _myCQ.xgetForeignPropertyName(); // accept foreign property name
        _relationPath = _myCQ.xgetRelationPath(); // accept relation path
        _inline = true;
    }

    // ===================================================================================
    //                                                             Override about Register
    //                                                             =======================
    protected void reflectRelationOnUnionQuery(ConditionQuery bq, ConditionQuery uq)
    { throw new IllegalConditionBeanOperationException("InlineView cannot use Union: " + bq + " : " + uq); }

    @Override
    protected void setupConditionValueAndRegisterWhereClause(ConditionKey k, Object v, ConditionValue cv, String col)
    { regIQ(k, v, cv, col); }

    @Override
    protected void setupConditionValueAndRegisterWhereClause(ConditionKey k, Object v, ConditionValue cv, String col, ConditionOption op)
    { regIQ(k, v, cv, col, op); }

    @Override
    protected void registerWhereClause(String wc)
    { registerInlineWhereClause(wc); }

    @Override
    protected boolean isInScopeRelationSuppressLocalAliasName() {
        if (_onClause) { throw new IllegalConditionBeanOperationException("InScopeRelation on OnClause is unsupported."); }
        return true;
    }

    // ===================================================================================
    //                                                                Override about Query
    //                                                                ====================
    protected ConditionValue xgetCValueVillagePlayerId() { return _myCQ.xdfgetVillagePlayerId(); }
    public String keepVillagePlayerId_ExistsReferrer_AbilityByTargetVillagePlayerIdList(AbilityCQ sq)
    { throwIICBOE("ExistsReferrer"); return null; }
    public String keepVillagePlayerId_ExistsReferrer_AbilityByVillagePlayerIdList(AbilityCQ sq)
    { throwIICBOE("ExistsReferrer"); return null; }
    public String keepVillagePlayerId_ExistsReferrer_ComingOutList(ComingOutCQ sq)
    { throwIICBOE("ExistsReferrer"); return null; }
    public String keepVillagePlayerId_ExistsReferrer_CommitList(CommitCQ sq)
    { throwIICBOE("ExistsReferrer"); return null; }
    public String keepVillagePlayerId_ExistsReferrer_VoteByTargetVillagePlayerIdList(VoteCQ sq)
    { throwIICBOE("ExistsReferrer"); return null; }
    public String keepVillagePlayerId_ExistsReferrer_VoteByVillagePlayerIdList(VoteCQ sq)
    { throwIICBOE("ExistsReferrer"); return null; }
    public String keepVillagePlayerId_NotExistsReferrer_AbilityByTargetVillagePlayerIdList(AbilityCQ sq)
    { throwIICBOE("NotExistsReferrer"); return null; }
    public String keepVillagePlayerId_NotExistsReferrer_AbilityByVillagePlayerIdList(AbilityCQ sq)
    { throwIICBOE("NotExistsReferrer"); return null; }
    public String keepVillagePlayerId_NotExistsReferrer_ComingOutList(ComingOutCQ sq)
    { throwIICBOE("NotExistsReferrer"); return null; }
    public String keepVillagePlayerId_NotExistsReferrer_CommitList(CommitCQ sq)
    { throwIICBOE("NotExistsReferrer"); return null; }
    public String keepVillagePlayerId_NotExistsReferrer_VoteByTargetVillagePlayerIdList(VoteCQ sq)
    { throwIICBOE("NotExistsReferrer"); return null; }
    public String keepVillagePlayerId_NotExistsReferrer_VoteByVillagePlayerIdList(VoteCQ sq)
    { throwIICBOE("NotExistsReferrer"); return null; }
    public String keepVillagePlayerId_SpecifyDerivedReferrer_AbilityByTargetVillagePlayerIdList(AbilityCQ sq)
    { throwIICBOE("(Specify)DerivedReferrer"); return null; }
    public String keepVillagePlayerId_SpecifyDerivedReferrer_AbilityByVillagePlayerIdList(AbilityCQ sq)
    { throwIICBOE("(Specify)DerivedReferrer"); return null; }
    public String keepVillagePlayerId_SpecifyDerivedReferrer_ComingOutList(ComingOutCQ sq)
    { throwIICBOE("(Specify)DerivedReferrer"); return null; }
    public String keepVillagePlayerId_SpecifyDerivedReferrer_CommitList(CommitCQ sq)
    { throwIICBOE("(Specify)DerivedReferrer"); return null; }
    public String keepVillagePlayerId_SpecifyDerivedReferrer_VoteByTargetVillagePlayerIdList(VoteCQ sq)
    { throwIICBOE("(Specify)DerivedReferrer"); return null; }
    public String keepVillagePlayerId_SpecifyDerivedReferrer_VoteByVillagePlayerIdList(VoteCQ sq)
    { throwIICBOE("(Specify)DerivedReferrer"); return null; }
    public String keepVillagePlayerId_QueryDerivedReferrer_AbilityByTargetVillagePlayerIdList(AbilityCQ sq)
    { throwIICBOE("(Query)DerivedReferrer"); return null; }
    public String keepVillagePlayerId_QueryDerivedReferrer_AbilityByTargetVillagePlayerIdListParameter(Object vl)
    { throwIICBOE("(Query)DerivedReferrer"); return null; }
    public String keepVillagePlayerId_QueryDerivedReferrer_AbilityByVillagePlayerIdList(AbilityCQ sq)
    { throwIICBOE("(Query)DerivedReferrer"); return null; }
    public String keepVillagePlayerId_QueryDerivedReferrer_AbilityByVillagePlayerIdListParameter(Object vl)
    { throwIICBOE("(Query)DerivedReferrer"); return null; }
    public String keepVillagePlayerId_QueryDerivedReferrer_ComingOutList(ComingOutCQ sq)
    { throwIICBOE("(Query)DerivedReferrer"); return null; }
    public String keepVillagePlayerId_QueryDerivedReferrer_ComingOutListParameter(Object vl)
    { throwIICBOE("(Query)DerivedReferrer"); return null; }
    public String keepVillagePlayerId_QueryDerivedReferrer_CommitList(CommitCQ sq)
    { throwIICBOE("(Query)DerivedReferrer"); return null; }
    public String keepVillagePlayerId_QueryDerivedReferrer_CommitListParameter(Object vl)
    { throwIICBOE("(Query)DerivedReferrer"); return null; }
    public String keepVillagePlayerId_QueryDerivedReferrer_VoteByTargetVillagePlayerIdList(VoteCQ sq)
    { throwIICBOE("(Query)DerivedReferrer"); return null; }
    public String keepVillagePlayerId_QueryDerivedReferrer_VoteByTargetVillagePlayerIdListParameter(Object vl)
    { throwIICBOE("(Query)DerivedReferrer"); return null; }
    public String keepVillagePlayerId_QueryDerivedReferrer_VoteByVillagePlayerIdList(VoteCQ sq)
    { throwIICBOE("(Query)DerivedReferrer"); return null; }
    public String keepVillagePlayerId_QueryDerivedReferrer_VoteByVillagePlayerIdListParameter(Object vl)
    { throwIICBOE("(Query)DerivedReferrer"); return null; }
    protected ConditionValue xgetCValueVillageId() { return _myCQ.xdfgetVillageId(); }
    protected ConditionValue xgetCValuePlayerId() { return _myCQ.xdfgetPlayerId(); }
    protected ConditionValue xgetCValueCharaId() { return _myCQ.xdfgetCharaId(); }
    protected ConditionValue xgetCValueSkillCode() { return _myCQ.xdfgetSkillCode(); }
    protected ConditionValue xgetCValueRequestSkillCode() { return _myCQ.xdfgetRequestSkillCode(); }
    protected ConditionValue xgetCValueSecondRequestSkillCode() { return _myCQ.xdfgetSecondRequestSkillCode(); }
    protected ConditionValue xgetCValueIsDead() { return _myCQ.xdfgetIsDead(); }
    protected ConditionValue xgetCValueIsSpectator() { return _myCQ.xdfgetIsSpectator(); }
    protected ConditionValue xgetCValueDeadReasonCode() { return _myCQ.xdfgetDeadReasonCode(); }
    protected ConditionValue xgetCValueDeadVillageDayId() { return _myCQ.xdfgetDeadVillageDayId(); }
    protected ConditionValue xgetCValueIsGone() { return _myCQ.xdfgetIsGone(); }
    protected ConditionValue xgetCValueRegisterDatetime() { return _myCQ.xdfgetRegisterDatetime(); }
    protected ConditionValue xgetCValueRegisterTrace() { return _myCQ.xdfgetRegisterTrace(); }
    protected ConditionValue xgetCValueUpdateDatetime() { return _myCQ.xdfgetUpdateDatetime(); }
    protected ConditionValue xgetCValueUpdateTrace() { return _myCQ.xdfgetUpdateTrace(); }
    protected Map<String, Object> xfindFixedConditionDynamicParameterMap(String pp) { return null; }
    public String keepScalarCondition(VillagePlayerCQ sq)
    { throwIICBOE("ScalarCondition"); return null; }
    public String keepSpecifyMyselfDerived(VillagePlayerCQ sq)
    { throwIICBOE("(Specify)MyselfDerived"); return null;}
    public String keepQueryMyselfDerived(VillagePlayerCQ sq)
    { throwIICBOE("(Query)MyselfDerived"); return null;}
    public String keepQueryMyselfDerivedParameter(Object vl)
    { throwIICBOE("(Query)MyselfDerived"); return null;}
    public String keepMyselfExists(VillagePlayerCQ sq)
    { throwIICBOE("MyselfExists"); return null;}

    protected void throwIICBOE(String name)
    { throw new IllegalConditionBeanOperationException(name + " at InlineView is unsupported."); }

    // ===================================================================================
    //                                                                       Very Internal
    //                                                                       =============
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xinCB() { return VillagePlayerCB.class.getName(); }
    protected String xinCQ() { return VillagePlayerCQ.class.getName(); }
}
