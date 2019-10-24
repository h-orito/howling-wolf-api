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
 * The condition-query for in-line of skill.
 * @author DBFlute(AutoGenerator)
 */
public class SkillCIQ extends AbstractBsSkillCQ {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected BsSkillCQ _myCQ;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public SkillCIQ(ConditionQuery referrerQuery, SqlClause sqlClause
                        , String aliasName, int nestLevel, BsSkillCQ myCQ) {
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
    protected ConditionValue xgetCValueSkillCode() { return _myCQ.xdfgetSkillCode(); }
    public String keepSkillCode_ExistsReferrer_MessageRestrictionList(MessageRestrictionCQ sq)
    { throwIICBOE("ExistsReferrer"); return null; }
    public String keepSkillCode_ExistsReferrer_VillagePlayerByRequestSkillCodeList(VillagePlayerCQ sq)
    { throwIICBOE("ExistsReferrer"); return null; }
    public String keepSkillCode_ExistsReferrer_VillagePlayerBySecondRequestSkillCodeList(VillagePlayerCQ sq)
    { throwIICBOE("ExistsReferrer"); return null; }
    public String keepSkillCode_ExistsReferrer_VillagePlayerBySkillCodeList(VillagePlayerCQ sq)
    { throwIICBOE("ExistsReferrer"); return null; }
    public String keepSkillCode_NotExistsReferrer_MessageRestrictionList(MessageRestrictionCQ sq)
    { throwIICBOE("NotExistsReferrer"); return null; }
    public String keepSkillCode_NotExistsReferrer_VillagePlayerByRequestSkillCodeList(VillagePlayerCQ sq)
    { throwIICBOE("NotExistsReferrer"); return null; }
    public String keepSkillCode_NotExistsReferrer_VillagePlayerBySecondRequestSkillCodeList(VillagePlayerCQ sq)
    { throwIICBOE("NotExistsReferrer"); return null; }
    public String keepSkillCode_NotExistsReferrer_VillagePlayerBySkillCodeList(VillagePlayerCQ sq)
    { throwIICBOE("NotExistsReferrer"); return null; }
    public String keepSkillCode_SpecifyDerivedReferrer_MessageRestrictionList(MessageRestrictionCQ sq)
    { throwIICBOE("(Specify)DerivedReferrer"); return null; }
    public String keepSkillCode_SpecifyDerivedReferrer_VillagePlayerByRequestSkillCodeList(VillagePlayerCQ sq)
    { throwIICBOE("(Specify)DerivedReferrer"); return null; }
    public String keepSkillCode_SpecifyDerivedReferrer_VillagePlayerBySecondRequestSkillCodeList(VillagePlayerCQ sq)
    { throwIICBOE("(Specify)DerivedReferrer"); return null; }
    public String keepSkillCode_SpecifyDerivedReferrer_VillagePlayerBySkillCodeList(VillagePlayerCQ sq)
    { throwIICBOE("(Specify)DerivedReferrer"); return null; }
    public String keepSkillCode_QueryDerivedReferrer_MessageRestrictionList(MessageRestrictionCQ sq)
    { throwIICBOE("(Query)DerivedReferrer"); return null; }
    public String keepSkillCode_QueryDerivedReferrer_MessageRestrictionListParameter(Object vl)
    { throwIICBOE("(Query)DerivedReferrer"); return null; }
    public String keepSkillCode_QueryDerivedReferrer_VillagePlayerByRequestSkillCodeList(VillagePlayerCQ sq)
    { throwIICBOE("(Query)DerivedReferrer"); return null; }
    public String keepSkillCode_QueryDerivedReferrer_VillagePlayerByRequestSkillCodeListParameter(Object vl)
    { throwIICBOE("(Query)DerivedReferrer"); return null; }
    public String keepSkillCode_QueryDerivedReferrer_VillagePlayerBySecondRequestSkillCodeList(VillagePlayerCQ sq)
    { throwIICBOE("(Query)DerivedReferrer"); return null; }
    public String keepSkillCode_QueryDerivedReferrer_VillagePlayerBySecondRequestSkillCodeListParameter(Object vl)
    { throwIICBOE("(Query)DerivedReferrer"); return null; }
    public String keepSkillCode_QueryDerivedReferrer_VillagePlayerBySkillCodeList(VillagePlayerCQ sq)
    { throwIICBOE("(Query)DerivedReferrer"); return null; }
    public String keepSkillCode_QueryDerivedReferrer_VillagePlayerBySkillCodeListParameter(Object vl)
    { throwIICBOE("(Query)DerivedReferrer"); return null; }
    protected ConditionValue xgetCValueSkillName() { return _myCQ.xdfgetSkillName(); }
    protected ConditionValue xgetCValueSkillShortName() { return _myCQ.xdfgetSkillShortName(); }
    protected ConditionValue xgetCValueCampCode() { return _myCQ.xdfgetCampCode(); }
    protected ConditionValue xgetCValueDispOrder() { return _myCQ.xdfgetDispOrder(); }
    protected Map<String, Object> xfindFixedConditionDynamicParameterMap(String pp) { return null; }
    public String keepScalarCondition(SkillCQ sq)
    { throwIICBOE("ScalarCondition"); return null; }
    public String keepSpecifyMyselfDerived(SkillCQ sq)
    { throwIICBOE("(Specify)MyselfDerived"); return null;}
    public String keepQueryMyselfDerived(SkillCQ sq)
    { throwIICBOE("(Query)MyselfDerived"); return null;}
    public String keepQueryMyselfDerivedParameter(Object vl)
    { throwIICBOE("(Query)MyselfDerived"); return null;}
    public String keepMyselfExists(SkillCQ sq)
    { throwIICBOE("MyselfExists"); return null;}

    protected void throwIICBOE(String name)
    { throw new IllegalConditionBeanOperationException(name + " at InlineView is unsupported."); }

    // ===================================================================================
    //                                                                       Very Internal
    //                                                                       =============
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xinCB() { return SkillCB.class.getName(); }
    protected String xinCQ() { return SkillCQ.class.getName(); }
}
