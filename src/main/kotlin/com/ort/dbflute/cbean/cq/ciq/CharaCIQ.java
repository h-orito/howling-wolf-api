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
 * The condition-query for in-line of chara.
 * @author DBFlute(AutoGenerator)
 */
public class CharaCIQ extends AbstractBsCharaCQ {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected BsCharaCQ _myCQ;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public CharaCIQ(ConditionQuery referrerQuery, SqlClause sqlClause
                        , String aliasName, int nestLevel, BsCharaCQ myCQ) {
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
    protected ConditionValue xgetCValueCharaId() { return _myCQ.xdfgetCharaId(); }
    public String keepCharaId_ExistsReferrer_AbilityByCharaIdList(AbilityCQ sq)
    { throwIICBOE("ExistsReferrer"); return null; }
    public String keepCharaId_ExistsReferrer_AbilityByTargetCharaIdList(AbilityCQ sq)
    { throwIICBOE("ExistsReferrer"); return null; }
    public String keepCharaId_ExistsReferrer_CharaImageList(CharaImageCQ sq)
    { throwIICBOE("ExistsReferrer"); return null; }
    public String keepCharaId_ExistsReferrer_VillagePlayerList(VillagePlayerCQ sq)
    { throwIICBOE("ExistsReferrer"); return null; }
    public String keepCharaId_ExistsReferrer_VoteByCharaIdList(VoteCQ sq)
    { throwIICBOE("ExistsReferrer"); return null; }
    public String keepCharaId_ExistsReferrer_VoteByVoteCharaIdList(VoteCQ sq)
    { throwIICBOE("ExistsReferrer"); return null; }
    public String keepCharaId_NotExistsReferrer_AbilityByCharaIdList(AbilityCQ sq)
    { throwIICBOE("NotExistsReferrer"); return null; }
    public String keepCharaId_NotExistsReferrer_AbilityByTargetCharaIdList(AbilityCQ sq)
    { throwIICBOE("NotExistsReferrer"); return null; }
    public String keepCharaId_NotExistsReferrer_CharaImageList(CharaImageCQ sq)
    { throwIICBOE("NotExistsReferrer"); return null; }
    public String keepCharaId_NotExistsReferrer_VillagePlayerList(VillagePlayerCQ sq)
    { throwIICBOE("NotExistsReferrer"); return null; }
    public String keepCharaId_NotExistsReferrer_VoteByCharaIdList(VoteCQ sq)
    { throwIICBOE("NotExistsReferrer"); return null; }
    public String keepCharaId_NotExistsReferrer_VoteByVoteCharaIdList(VoteCQ sq)
    { throwIICBOE("NotExistsReferrer"); return null; }
    public String keepCharaId_SpecifyDerivedReferrer_AbilityByCharaIdList(AbilityCQ sq)
    { throwIICBOE("(Specify)DerivedReferrer"); return null; }
    public String keepCharaId_SpecifyDerivedReferrer_AbilityByTargetCharaIdList(AbilityCQ sq)
    { throwIICBOE("(Specify)DerivedReferrer"); return null; }
    public String keepCharaId_SpecifyDerivedReferrer_CharaImageList(CharaImageCQ sq)
    { throwIICBOE("(Specify)DerivedReferrer"); return null; }
    public String keepCharaId_SpecifyDerivedReferrer_VillagePlayerList(VillagePlayerCQ sq)
    { throwIICBOE("(Specify)DerivedReferrer"); return null; }
    public String keepCharaId_SpecifyDerivedReferrer_VoteByCharaIdList(VoteCQ sq)
    { throwIICBOE("(Specify)DerivedReferrer"); return null; }
    public String keepCharaId_SpecifyDerivedReferrer_VoteByVoteCharaIdList(VoteCQ sq)
    { throwIICBOE("(Specify)DerivedReferrer"); return null; }
    public String keepCharaId_QueryDerivedReferrer_AbilityByCharaIdList(AbilityCQ sq)
    { throwIICBOE("(Query)DerivedReferrer"); return null; }
    public String keepCharaId_QueryDerivedReferrer_AbilityByCharaIdListParameter(Object vl)
    { throwIICBOE("(Query)DerivedReferrer"); return null; }
    public String keepCharaId_QueryDerivedReferrer_AbilityByTargetCharaIdList(AbilityCQ sq)
    { throwIICBOE("(Query)DerivedReferrer"); return null; }
    public String keepCharaId_QueryDerivedReferrer_AbilityByTargetCharaIdListParameter(Object vl)
    { throwIICBOE("(Query)DerivedReferrer"); return null; }
    public String keepCharaId_QueryDerivedReferrer_CharaImageList(CharaImageCQ sq)
    { throwIICBOE("(Query)DerivedReferrer"); return null; }
    public String keepCharaId_QueryDerivedReferrer_CharaImageListParameter(Object vl)
    { throwIICBOE("(Query)DerivedReferrer"); return null; }
    public String keepCharaId_QueryDerivedReferrer_VillagePlayerList(VillagePlayerCQ sq)
    { throwIICBOE("(Query)DerivedReferrer"); return null; }
    public String keepCharaId_QueryDerivedReferrer_VillagePlayerListParameter(Object vl)
    { throwIICBOE("(Query)DerivedReferrer"); return null; }
    public String keepCharaId_QueryDerivedReferrer_VoteByCharaIdList(VoteCQ sq)
    { throwIICBOE("(Query)DerivedReferrer"); return null; }
    public String keepCharaId_QueryDerivedReferrer_VoteByCharaIdListParameter(Object vl)
    { throwIICBOE("(Query)DerivedReferrer"); return null; }
    public String keepCharaId_QueryDerivedReferrer_VoteByVoteCharaIdList(VoteCQ sq)
    { throwIICBOE("(Query)DerivedReferrer"); return null; }
    public String keepCharaId_QueryDerivedReferrer_VoteByVoteCharaIdListParameter(Object vl)
    { throwIICBOE("(Query)DerivedReferrer"); return null; }
    protected ConditionValue xgetCValueCharaName() { return _myCQ.xdfgetCharaName(); }
    protected ConditionValue xgetCValueCharaShortName() { return _myCQ.xdfgetCharaShortName(); }
    protected ConditionValue xgetCValueCharaGroupId() { return _myCQ.xdfgetCharaGroupId(); }
    protected ConditionValue xgetCValueDefaultJoinMessage() { return _myCQ.xdfgetDefaultJoinMessage(); }
    protected ConditionValue xgetCValueDefaultFirstdayMessage() { return _myCQ.xdfgetDefaultFirstdayMessage(); }
    protected ConditionValue xgetCValueDisplayWidth() { return _myCQ.xdfgetDisplayWidth(); }
    protected ConditionValue xgetCValueDisplayHeight() { return _myCQ.xdfgetDisplayHeight(); }
    protected ConditionValue xgetCValueRegisterDatetime() { return _myCQ.xdfgetRegisterDatetime(); }
    protected ConditionValue xgetCValueRegisterTrace() { return _myCQ.xdfgetRegisterTrace(); }
    protected ConditionValue xgetCValueUpdateDatetime() { return _myCQ.xdfgetUpdateDatetime(); }
    protected ConditionValue xgetCValueUpdateTrace() { return _myCQ.xdfgetUpdateTrace(); }
    protected Map<String, Object> xfindFixedConditionDynamicParameterMap(String pp) { return null; }
    public String keepScalarCondition(CharaCQ sq)
    { throwIICBOE("ScalarCondition"); return null; }
    public String keepSpecifyMyselfDerived(CharaCQ sq)
    { throwIICBOE("(Specify)MyselfDerived"); return null;}
    public String keepQueryMyselfDerived(CharaCQ sq)
    { throwIICBOE("(Query)MyselfDerived"); return null;}
    public String keepQueryMyselfDerivedParameter(Object vl)
    { throwIICBOE("(Query)MyselfDerived"); return null;}
    public String keepMyselfExists(CharaCQ sq)
    { throwIICBOE("MyselfExists"); return null;}

    protected void throwIICBOE(String name)
    { throw new IllegalConditionBeanOperationException(name + " at InlineView is unsupported."); }

    // ===================================================================================
    //                                                                       Very Internal
    //                                                                       =============
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xinCB() { return CharaCB.class.getName(); }
    protected String xinCQ() { return CharaCQ.class.getName(); }
}
