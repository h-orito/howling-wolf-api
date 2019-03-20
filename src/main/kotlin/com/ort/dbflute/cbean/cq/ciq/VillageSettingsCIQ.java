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
 * The condition-query for in-line of village_settings.
 * @author DBFlute(AutoGenerator)
 */
public class VillageSettingsCIQ extends AbstractBsVillageSettingsCQ {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected BsVillageSettingsCQ _myCQ;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public VillageSettingsCIQ(ConditionQuery referrerQuery, SqlClause sqlClause
                        , String aliasName, int nestLevel, BsVillageSettingsCQ myCQ) {
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
    protected ConditionValue xgetCValueVillageId() { return _myCQ.xdfgetVillageId(); }
    protected ConditionValue xgetCValueDummyCharaId() { return _myCQ.xdfgetDummyCharaId(); }
    protected ConditionValue xgetCValueStartPersonMinNum() { return _myCQ.xdfgetStartPersonMinNum(); }
    protected ConditionValue xgetCValuePersonMaxNum() { return _myCQ.xdfgetPersonMaxNum(); }
    protected ConditionValue xgetCValueStartDatetime() { return _myCQ.xdfgetStartDatetime(); }
    protected ConditionValue xgetCValueDayChangeIntervalSeconds() { return _myCQ.xdfgetDayChangeIntervalSeconds(); }
    protected ConditionValue xgetCValueIsOpenVote() { return _myCQ.xdfgetIsOpenVote(); }
    protected ConditionValue xgetCValueIsPossibleSkillRequest() { return _myCQ.xdfgetIsPossibleSkillRequest(); }
    protected ConditionValue xgetCValueIsAvailableSpectate() { return _myCQ.xdfgetIsAvailableSpectate(); }
    protected ConditionValue xgetCValueIsAvailableSameWolfAttack() { return _myCQ.xdfgetIsAvailableSameWolfAttack(); }
    protected ConditionValue xgetCValueIsOpenSkillInGrave() { return _myCQ.xdfgetIsOpenSkillInGrave(); }
    protected ConditionValue xgetCValueIsVisibleGraveSpectateMessage() { return _myCQ.xdfgetIsVisibleGraveSpectateMessage(); }
    protected ConditionValue xgetCValueIsAvailableSuddonlyDeath() { return _myCQ.xdfgetIsAvailableSuddonlyDeath(); }
    protected ConditionValue xgetCValueIsAvailableCommit() { return _myCQ.xdfgetIsAvailableCommit(); }
    protected ConditionValue xgetCValueIsAvailableGuardSameTarget() { return _myCQ.xdfgetIsAvailableGuardSameTarget(); }
    protected ConditionValue xgetCValueCharacterGroupId() { return _myCQ.xdfgetCharacterGroupId(); }
    protected ConditionValue xgetCValueJoinPassword() { return _myCQ.xdfgetJoinPassword(); }
    protected ConditionValue xgetCValueOrganize() { return _myCQ.xdfgetOrganize(); }
    protected ConditionValue xgetCValueAllowedSecretSayCode() { return _myCQ.xdfgetAllowedSecretSayCode(); }
    protected ConditionValue xgetCValueRegisterDatetime() { return _myCQ.xdfgetRegisterDatetime(); }
    protected ConditionValue xgetCValueRegisterTrace() { return _myCQ.xdfgetRegisterTrace(); }
    protected ConditionValue xgetCValueUpdateDatetime() { return _myCQ.xdfgetUpdateDatetime(); }
    protected ConditionValue xgetCValueUpdateTrace() { return _myCQ.xdfgetUpdateTrace(); }
    protected Map<String, Object> xfindFixedConditionDynamicParameterMap(String pp) { return null; }
    public String keepScalarCondition(VillageSettingsCQ sq)
    { throwIICBOE("ScalarCondition"); return null; }
    public String keepSpecifyMyselfDerived(VillageSettingsCQ sq)
    { throwIICBOE("(Specify)MyselfDerived"); return null;}
    public String keepQueryMyselfDerived(VillageSettingsCQ sq)
    { throwIICBOE("(Query)MyselfDerived"); return null;}
    public String keepQueryMyselfDerivedParameter(Object vl)
    { throwIICBOE("(Query)MyselfDerived"); return null;}
    public String keepMyselfExists(VillageSettingsCQ sq)
    { throwIICBOE("MyselfExists"); return null;}

    protected void throwIICBOE(String name)
    { throw new IllegalConditionBeanOperationException(name + " at InlineView is unsupported."); }

    // ===================================================================================
    //                                                                       Very Internal
    //                                                                       =============
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xinCB() { return VillageSettingsCB.class.getName(); }
    protected String xinCQ() { return VillageSettingsCQ.class.getName(); }
}
