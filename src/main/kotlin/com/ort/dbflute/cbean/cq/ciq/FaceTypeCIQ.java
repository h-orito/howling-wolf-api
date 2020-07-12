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
 * The condition-query for in-line of face_type.
 * @author DBFlute(AutoGenerator)
 */
public class FaceTypeCIQ extends AbstractBsFaceTypeCQ {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected BsFaceTypeCQ _myCQ;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public FaceTypeCIQ(ConditionQuery referrerQuery, SqlClause sqlClause
                        , String aliasName, int nestLevel, BsFaceTypeCQ myCQ) {
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
    protected ConditionValue xgetCValueFaceTypeCode() { return _myCQ.xdfgetFaceTypeCode(); }
    public String keepFaceTypeCode_ExistsReferrer_CharaImageList(CharaImageCQ sq)
    { throwIICBOE("ExistsReferrer"); return null; }
    public String keepFaceTypeCode_NotExistsReferrer_CharaImageList(CharaImageCQ sq)
    { throwIICBOE("NotExistsReferrer"); return null; }
    public String keepFaceTypeCode_SpecifyDerivedReferrer_CharaImageList(CharaImageCQ sq)
    { throwIICBOE("(Specify)DerivedReferrer"); return null; }
    public String keepFaceTypeCode_QueryDerivedReferrer_CharaImageList(CharaImageCQ sq)
    { throwIICBOE("(Query)DerivedReferrer"); return null; }
    public String keepFaceTypeCode_QueryDerivedReferrer_CharaImageListParameter(Object vl)
    { throwIICBOE("(Query)DerivedReferrer"); return null; }
    protected ConditionValue xgetCValueFaceTypeName() { return _myCQ.xdfgetFaceTypeName(); }
    protected ConditionValue xgetCValueDispOrder() { return _myCQ.xdfgetDispOrder(); }
    protected Map<String, Object> xfindFixedConditionDynamicParameterMap(String pp) { return null; }
    public String keepScalarCondition(FaceTypeCQ sq)
    { throwIICBOE("ScalarCondition"); return null; }
    public String keepSpecifyMyselfDerived(FaceTypeCQ sq)
    { throwIICBOE("(Specify)MyselfDerived"); return null;}
    public String keepQueryMyselfDerived(FaceTypeCQ sq)
    { throwIICBOE("(Query)MyselfDerived"); return null;}
    public String keepQueryMyselfDerivedParameter(Object vl)
    { throwIICBOE("(Query)MyselfDerived"); return null;}
    public String keepMyselfExists(FaceTypeCQ sq)
    { throwIICBOE("MyselfExists"); return null;}

    protected void throwIICBOE(String name)
    { throw new IllegalConditionBeanOperationException(name + " at InlineView is unsupported."); }

    // ===================================================================================
    //                                                                       Very Internal
    //                                                                       =============
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xinCB() { return FaceTypeCB.class.getName(); }
    protected String xinCQ() { return FaceTypeCQ.class.getName(); }
}
