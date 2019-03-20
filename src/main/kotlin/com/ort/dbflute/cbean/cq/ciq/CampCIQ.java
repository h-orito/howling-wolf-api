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
 * The condition-query for in-line of camp.
 * @author DBFlute(AutoGenerator)
 */
public class CampCIQ extends AbstractBsCampCQ {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected BsCampCQ _myCQ;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public CampCIQ(ConditionQuery referrerQuery, SqlClause sqlClause
                        , String aliasName, int nestLevel, BsCampCQ myCQ) {
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
    protected ConditionValue xgetCValueCampCode() { return _myCQ.xdfgetCampCode(); }
    public String keepCampCode_ExistsReferrer_SkillList(SkillCQ sq)
    { throwIICBOE("ExistsReferrer"); return null; }
    public String keepCampCode_ExistsReferrer_VillageList(VillageCQ sq)
    { throwIICBOE("ExistsReferrer"); return null; }
    public String keepCampCode_NotExistsReferrer_SkillList(SkillCQ sq)
    { throwIICBOE("NotExistsReferrer"); return null; }
    public String keepCampCode_NotExistsReferrer_VillageList(VillageCQ sq)
    { throwIICBOE("NotExistsReferrer"); return null; }
    public String keepCampCode_SpecifyDerivedReferrer_SkillList(SkillCQ sq)
    { throwIICBOE("(Specify)DerivedReferrer"); return null; }
    public String keepCampCode_SpecifyDerivedReferrer_VillageList(VillageCQ sq)
    { throwIICBOE("(Specify)DerivedReferrer"); return null; }
    public String keepCampCode_QueryDerivedReferrer_SkillList(SkillCQ sq)
    { throwIICBOE("(Query)DerivedReferrer"); return null; }
    public String keepCampCode_QueryDerivedReferrer_SkillListParameter(Object vl)
    { throwIICBOE("(Query)DerivedReferrer"); return null; }
    public String keepCampCode_QueryDerivedReferrer_VillageList(VillageCQ sq)
    { throwIICBOE("(Query)DerivedReferrer"); return null; }
    public String keepCampCode_QueryDerivedReferrer_VillageListParameter(Object vl)
    { throwIICBOE("(Query)DerivedReferrer"); return null; }
    protected ConditionValue xgetCValueCampName() { return _myCQ.xdfgetCampName(); }
    protected Map<String, Object> xfindFixedConditionDynamicParameterMap(String pp) { return null; }
    public String keepScalarCondition(CampCQ sq)
    { throwIICBOE("ScalarCondition"); return null; }
    public String keepSpecifyMyselfDerived(CampCQ sq)
    { throwIICBOE("(Specify)MyselfDerived"); return null;}
    public String keepQueryMyselfDerived(CampCQ sq)
    { throwIICBOE("(Query)MyselfDerived"); return null;}
    public String keepQueryMyselfDerivedParameter(Object vl)
    { throwIICBOE("(Query)MyselfDerived"); return null;}
    public String keepMyselfExists(CampCQ sq)
    { throwIICBOE("MyselfExists"); return null;}

    protected void throwIICBOE(String name)
    { throw new IllegalConditionBeanOperationException(name + " at InlineView is unsupported."); }

    // ===================================================================================
    //                                                                       Very Internal
    //                                                                       =============
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xinCB() { return CampCB.class.getName(); }
    protected String xinCQ() { return CampCQ.class.getName(); }
}
