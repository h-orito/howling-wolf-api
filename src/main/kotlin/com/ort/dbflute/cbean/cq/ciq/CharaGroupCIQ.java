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
 * The condition-query for in-line of chara_group.
 * @author DBFlute(AutoGenerator)
 */
public class CharaGroupCIQ extends AbstractBsCharaGroupCQ {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected BsCharaGroupCQ _myCQ;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public CharaGroupCIQ(ConditionQuery referrerQuery, SqlClause sqlClause
                        , String aliasName, int nestLevel, BsCharaGroupCQ myCQ) {
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
    protected ConditionValue xgetCValueCharaGroupId() { return _myCQ.xdfgetCharaGroupId(); }
    public String keepCharaGroupId_ExistsReferrer_CharaList(CharaCQ sq)
    { throwIICBOE("ExistsReferrer"); return null; }
    public String keepCharaGroupId_ExistsReferrer_VillageSettingsList(VillageSettingsCQ sq)
    { throwIICBOE("ExistsReferrer"); return null; }
    public String keepCharaGroupId_NotExistsReferrer_CharaList(CharaCQ sq)
    { throwIICBOE("NotExistsReferrer"); return null; }
    public String keepCharaGroupId_NotExistsReferrer_VillageSettingsList(VillageSettingsCQ sq)
    { throwIICBOE("NotExistsReferrer"); return null; }
    public String keepCharaGroupId_SpecifyDerivedReferrer_CharaList(CharaCQ sq)
    { throwIICBOE("(Specify)DerivedReferrer"); return null; }
    public String keepCharaGroupId_SpecifyDerivedReferrer_VillageSettingsList(VillageSettingsCQ sq)
    { throwIICBOE("(Specify)DerivedReferrer"); return null; }
    public String keepCharaGroupId_QueryDerivedReferrer_CharaList(CharaCQ sq)
    { throwIICBOE("(Query)DerivedReferrer"); return null; }
    public String keepCharaGroupId_QueryDerivedReferrer_CharaListParameter(Object vl)
    { throwIICBOE("(Query)DerivedReferrer"); return null; }
    public String keepCharaGroupId_QueryDerivedReferrer_VillageSettingsList(VillageSettingsCQ sq)
    { throwIICBOE("(Query)DerivedReferrer"); return null; }
    public String keepCharaGroupId_QueryDerivedReferrer_VillageSettingsListParameter(Object vl)
    { throwIICBOE("(Query)DerivedReferrer"); return null; }
    protected ConditionValue xgetCValueCharaGroupName() { return _myCQ.xdfgetCharaGroupName(); }
    protected ConditionValue xgetCValueDesignerId() { return _myCQ.xdfgetDesignerId(); }
    protected ConditionValue xgetCValueDescriptionUrl() { return _myCQ.xdfgetDescriptionUrl(); }
    protected ConditionValue xgetCValueRegisterDatetime() { return _myCQ.xdfgetRegisterDatetime(); }
    protected ConditionValue xgetCValueRegisterTrace() { return _myCQ.xdfgetRegisterTrace(); }
    protected ConditionValue xgetCValueUpdateDatetime() { return _myCQ.xdfgetUpdateDatetime(); }
    protected ConditionValue xgetCValueUpdateTrace() { return _myCQ.xdfgetUpdateTrace(); }
    protected Map<String, Object> xfindFixedConditionDynamicParameterMap(String pp) { return null; }
    public String keepScalarCondition(CharaGroupCQ sq)
    { throwIICBOE("ScalarCondition"); return null; }
    public String keepSpecifyMyselfDerived(CharaGroupCQ sq)
    { throwIICBOE("(Specify)MyselfDerived"); return null;}
    public String keepQueryMyselfDerived(CharaGroupCQ sq)
    { throwIICBOE("(Query)MyselfDerived"); return null;}
    public String keepQueryMyselfDerivedParameter(Object vl)
    { throwIICBOE("(Query)MyselfDerived"); return null;}
    public String keepMyselfExists(CharaGroupCQ sq)
    { throwIICBOE("MyselfExists"); return null;}

    protected void throwIICBOE(String name)
    { throw new IllegalConditionBeanOperationException(name + " at InlineView is unsupported."); }

    // ===================================================================================
    //                                                                       Very Internal
    //                                                                       =============
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xinCB() { return CharaGroupCB.class.getName(); }
    protected String xinCQ() { return CharaGroupCQ.class.getName(); }
}
