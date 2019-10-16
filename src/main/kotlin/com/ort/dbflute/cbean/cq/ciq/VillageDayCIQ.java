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
 * The condition-query for in-line of village_day.
 * @author DBFlute(AutoGenerator)
 */
public class VillageDayCIQ extends AbstractBsVillageDayCQ {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected BsVillageDayCQ _myCQ;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public VillageDayCIQ(ConditionQuery referrerQuery, SqlClause sqlClause
                        , String aliasName, int nestLevel, BsVillageDayCQ myCQ) {
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
    protected ConditionValue xgetCValueVillageDayId() { return _myCQ.xdfgetVillageDayId(); }
    public String keepVillageDayId_ExistsReferrer_AbilityList(AbilityCQ sq)
    { throwIICBOE("ExistsReferrer"); return null; }
    public String keepVillageDayId_ExistsReferrer_CommitList(CommitCQ sq)
    { throwIICBOE("ExistsReferrer"); return null; }
    public String keepVillageDayId_ExistsReferrer_VoteList(VoteCQ sq)
    { throwIICBOE("ExistsReferrer"); return null; }
    public String keepVillageDayId_NotExistsReferrer_AbilityList(AbilityCQ sq)
    { throwIICBOE("NotExistsReferrer"); return null; }
    public String keepVillageDayId_NotExistsReferrer_CommitList(CommitCQ sq)
    { throwIICBOE("NotExistsReferrer"); return null; }
    public String keepVillageDayId_NotExistsReferrer_VoteList(VoteCQ sq)
    { throwIICBOE("NotExistsReferrer"); return null; }
    public String keepVillageDayId_SpecifyDerivedReferrer_AbilityList(AbilityCQ sq)
    { throwIICBOE("(Specify)DerivedReferrer"); return null; }
    public String keepVillageDayId_SpecifyDerivedReferrer_CommitList(CommitCQ sq)
    { throwIICBOE("(Specify)DerivedReferrer"); return null; }
    public String keepVillageDayId_SpecifyDerivedReferrer_VoteList(VoteCQ sq)
    { throwIICBOE("(Specify)DerivedReferrer"); return null; }
    public String keepVillageDayId_QueryDerivedReferrer_AbilityList(AbilityCQ sq)
    { throwIICBOE("(Query)DerivedReferrer"); return null; }
    public String keepVillageDayId_QueryDerivedReferrer_AbilityListParameter(Object vl)
    { throwIICBOE("(Query)DerivedReferrer"); return null; }
    public String keepVillageDayId_QueryDerivedReferrer_CommitList(CommitCQ sq)
    { throwIICBOE("(Query)DerivedReferrer"); return null; }
    public String keepVillageDayId_QueryDerivedReferrer_CommitListParameter(Object vl)
    { throwIICBOE("(Query)DerivedReferrer"); return null; }
    public String keepVillageDayId_QueryDerivedReferrer_VoteList(VoteCQ sq)
    { throwIICBOE("(Query)DerivedReferrer"); return null; }
    public String keepVillageDayId_QueryDerivedReferrer_VoteListParameter(Object vl)
    { throwIICBOE("(Query)DerivedReferrer"); return null; }
    protected ConditionValue xgetCValueVillageId() { return _myCQ.xdfgetVillageId(); }
    protected ConditionValue xgetCValueDay() { return _myCQ.xdfgetDay(); }
    protected ConditionValue xgetCValueNoonnightCode() { return _myCQ.xdfgetNoonnightCode(); }
    protected ConditionValue xgetCValueDaychangeDatetime() { return _myCQ.xdfgetDaychangeDatetime(); }
    protected ConditionValue xgetCValueIsUpdating() { return _myCQ.xdfgetIsUpdating(); }
    protected ConditionValue xgetCValueRegisterDatetime() { return _myCQ.xdfgetRegisterDatetime(); }
    protected ConditionValue xgetCValueRegisterTrace() { return _myCQ.xdfgetRegisterTrace(); }
    protected ConditionValue xgetCValueUpdateDatetime() { return _myCQ.xdfgetUpdateDatetime(); }
    protected ConditionValue xgetCValueUpdateTrace() { return _myCQ.xdfgetUpdateTrace(); }
    protected Map<String, Object> xfindFixedConditionDynamicParameterMap(String pp) { return null; }
    public String keepScalarCondition(VillageDayCQ sq)
    { throwIICBOE("ScalarCondition"); return null; }
    public String keepSpecifyMyselfDerived(VillageDayCQ sq)
    { throwIICBOE("(Specify)MyselfDerived"); return null;}
    public String keepQueryMyselfDerived(VillageDayCQ sq)
    { throwIICBOE("(Query)MyselfDerived"); return null;}
    public String keepQueryMyselfDerivedParameter(Object vl)
    { throwIICBOE("(Query)MyselfDerived"); return null;}
    public String keepMyselfExists(VillageDayCQ sq)
    { throwIICBOE("MyselfExists"); return null;}

    protected void throwIICBOE(String name)
    { throw new IllegalConditionBeanOperationException(name + " at InlineView is unsupported."); }

    // ===================================================================================
    //                                                                       Very Internal
    //                                                                       =============
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xinCB() { return VillageDayCB.class.getName(); }
    protected String xinCQ() { return VillageDayCQ.class.getName(); }
}
