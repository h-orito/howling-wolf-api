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
 * The condition-query for in-line of noonnight.
 * @author DBFlute(AutoGenerator)
 */
public class NoonnightCIQ extends AbstractBsNoonnightCQ {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected BsNoonnightCQ _myCQ;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public NoonnightCIQ(ConditionQuery referrerQuery, SqlClause sqlClause
                        , String aliasName, int nestLevel, BsNoonnightCQ myCQ) {
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
    protected ConditionValue xgetCValueNoonnightCode() { return _myCQ.xdfgetNoonnightCode(); }
    public String keepNoonnightCode_ExistsReferrer_VillageDayList(VillageDayCQ sq)
    { throwIICBOE("ExistsReferrer"); return null; }
    public String keepNoonnightCode_NotExistsReferrer_VillageDayList(VillageDayCQ sq)
    { throwIICBOE("NotExistsReferrer"); return null; }
    public String keepNoonnightCode_SpecifyDerivedReferrer_VillageDayList(VillageDayCQ sq)
    { throwIICBOE("(Specify)DerivedReferrer"); return null; }
    public String keepNoonnightCode_QueryDerivedReferrer_VillageDayList(VillageDayCQ sq)
    { throwIICBOE("(Query)DerivedReferrer"); return null; }
    public String keepNoonnightCode_QueryDerivedReferrer_VillageDayListParameter(Object vl)
    { throwIICBOE("(Query)DerivedReferrer"); return null; }
    protected ConditionValue xgetCValueNoonnightName() { return _myCQ.xdfgetNoonnightName(); }
    protected ConditionValue xgetCValueDispOrder() { return _myCQ.xdfgetDispOrder(); }
    protected Map<String, Object> xfindFixedConditionDynamicParameterMap(String pp) { return null; }
    public String keepScalarCondition(NoonnightCQ sq)
    { throwIICBOE("ScalarCondition"); return null; }
    public String keepSpecifyMyselfDerived(NoonnightCQ sq)
    { throwIICBOE("(Specify)MyselfDerived"); return null;}
    public String keepQueryMyselfDerived(NoonnightCQ sq)
    { throwIICBOE("(Query)MyselfDerived"); return null;}
    public String keepQueryMyselfDerivedParameter(Object vl)
    { throwIICBOE("(Query)MyselfDerived"); return null;}
    public String keepMyselfExists(NoonnightCQ sq)
    { throwIICBOE("MyselfExists"); return null;}

    protected void throwIICBOE(String name)
    { throw new IllegalConditionBeanOperationException(name + " at InlineView is unsupported."); }

    // ===================================================================================
    //                                                                       Very Internal
    //                                                                       =============
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xinCB() { return NoonnightCB.class.getName(); }
    protected String xinCQ() { return NoonnightCQ.class.getName(); }
}
