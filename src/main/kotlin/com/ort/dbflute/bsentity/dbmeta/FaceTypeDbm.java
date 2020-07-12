package com.ort.dbflute.bsentity.dbmeta;

import java.util.List;
import java.util.Map;

import org.dbflute.Entity;
import org.dbflute.dbmeta.AbstractDBMeta;
import org.dbflute.dbmeta.info.*;
import org.dbflute.dbmeta.name.*;
import org.dbflute.dbmeta.property.PropertyGateway;
import org.dbflute.dbway.DBDef;
import com.ort.dbflute.allcommon.*;
import com.ort.dbflute.exentity.*;

/**
 * The DB meta of face_type. (Singleton)
 * @author DBFlute(AutoGenerator)
 */
public class FaceTypeDbm extends AbstractDBMeta {

    // ===================================================================================
    //                                                                           Singleton
    //                                                                           =========
    private static final FaceTypeDbm _instance = new FaceTypeDbm();
    private FaceTypeDbm() {}
    public static FaceTypeDbm getInstance() { return _instance; }

    // ===================================================================================
    //                                                                       Current DBDef
    //                                                                       =============
    public String getProjectName() { return DBCurrent.getInstance().projectName(); }
    public String getProjectPrefix() { return DBCurrent.getInstance().projectPrefix(); }
    public String getGenerationGapBasePrefix() { return DBCurrent.getInstance().generationGapBasePrefix(); }
    public DBDef getCurrentDBDef() { return DBCurrent.getInstance().currentDBDef(); }

    // ===================================================================================
    //                                                                    Property Gateway
    //                                                                    ================
    // -----------------------------------------------------
    //                                       Column Property
    //                                       ---------------
    protected final Map<String, PropertyGateway> _epgMap = newHashMap();
    { xsetupEpg(); }
    protected void xsetupEpg() {
        setupEpg(_epgMap, et -> ((FaceType)et).getFaceTypeCode(), (et, vl) -> {
            CDef.FaceType cls = (CDef.FaceType)gcls(et, columnFaceTypeCode(), vl);
            if (cls != null) {
                ((FaceType)et).setFaceTypeCodeAsFaceType(cls);
            } else {
                ((FaceType)et).mynativeMappingFaceTypeCode((String)vl);
            }
        }, "faceTypeCode");
        setupEpg(_epgMap, et -> ((FaceType)et).getFaceTypeName(), (et, vl) -> ((FaceType)et).setFaceTypeName((String)vl), "faceTypeName");
        setupEpg(_epgMap, et -> ((FaceType)et).getDispOrder(), (et, vl) -> ((FaceType)et).setDispOrder(cti(vl)), "dispOrder");
    }
    public PropertyGateway findPropertyGateway(String prop)
    { return doFindEpg(_epgMap, prop); }

    // ===================================================================================
    //                                                                          Table Info
    //                                                                          ==========
    protected final String _tableDbName = "face_type";
    protected final String _tableDispName = "FACE_TYPE";
    protected final String _tablePropertyName = "faceType";
    protected final TableSqlName _tableSqlName = new TableSqlName("FACE_TYPE", _tableDbName);
    { _tableSqlName.xacceptFilter(DBFluteConfig.getInstance().getTableSqlNameFilter()); }
    public String getTableDbName() { return _tableDbName; }
    public String getTableDispName() { return _tableDispName; }
    public String getTablePropertyName() { return _tablePropertyName; }
    public TableSqlName getTableSqlName() { return _tableSqlName; }

    // ===================================================================================
    //                                                                         Column Info
    //                                                                         ===========
    protected final ColumnInfo _columnFaceTypeCode = cci("FACE_TYPE_CODE", "FACE_TYPE_CODE", null, null, String.class, "faceTypeCode", null, true, false, true, "VARCHAR", 20, 0, null, null, false, null, null, null, "charaImageList", CDef.DefMeta.FaceType, false);
    protected final ColumnInfo _columnFaceTypeName = cci("FACE_TYPE_NAME", "FACE_TYPE_NAME", null, null, String.class, "faceTypeName", null, false, false, true, "VARCHAR", 20, 0, null, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnDispOrder = cci("DISP_ORDER", "DISP_ORDER", null, null, Integer.class, "dispOrder", null, false, false, true, "INT UNSIGNED", 10, 0, null, null, false, null, null, null, null, null, false);

    /**
     * FACE_TYPE_CODE: {PK, NotNull, VARCHAR(20), classification=FaceType}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnFaceTypeCode() { return _columnFaceTypeCode; }
    /**
     * FACE_TYPE_NAME: {NotNull, VARCHAR(20)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnFaceTypeName() { return _columnFaceTypeName; }
    /**
     * DISP_ORDER: {NotNull, INT UNSIGNED(10)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnDispOrder() { return _columnDispOrder; }

    protected List<ColumnInfo> ccil() {
        List<ColumnInfo> ls = newArrayList();
        ls.add(columnFaceTypeCode());
        ls.add(columnFaceTypeName());
        ls.add(columnDispOrder());
        return ls;
    }

    { initializeInformationResource(); }

    // ===================================================================================
    //                                                                         Unique Info
    //                                                                         ===========
    // -----------------------------------------------------
    //                                       Primary Element
    //                                       ---------------
    protected UniqueInfo cpui() { return hpcpui(columnFaceTypeCode()); }
    public boolean hasPrimaryKey() { return true; }
    public boolean hasCompoundPrimaryKey() { return false; }

    // ===================================================================================
    //                                                                       Relation Info
    //                                                                       =============
    // cannot cache because it uses related DB meta instance while booting
    // (instead, cached by super's collection)
    // -----------------------------------------------------
    //                                      Foreign Property
    //                                      ----------------

    // -----------------------------------------------------
    //                                     Referrer Property
    //                                     -----------------
    /**
     * CHARA_IMAGE by FACE_TYPE_CODE, named 'charaImageList'.
     * @return The information object of referrer property. (NotNull)
     */
    public ReferrerInfo referrerCharaImageList() {
        Map<ColumnInfo, ColumnInfo> mp = newLinkedHashMap(columnFaceTypeCode(), CharaImageDbm.getInstance().columnFaceTypeCode());
        return cri("FK_CHARA_IMAGE_FACE_TYPE", "charaImageList", this, CharaImageDbm.getInstance(), mp, false, "faceType");
    }

    // ===================================================================================
    //                                                                        Various Info
    //                                                                        ============

    // ===================================================================================
    //                                                                           Type Name
    //                                                                           =========
    public String getEntityTypeName() { return "com.ort.dbflute.exentity.FaceType"; }
    public String getConditionBeanTypeName() { return "com.ort.dbflute.cbean.FaceTypeCB"; }
    public String getBehaviorTypeName() { return "com.ort.dbflute.exbhv.FaceTypeBhv"; }

    // ===================================================================================
    //                                                                         Object Type
    //                                                                         ===========
    public Class<FaceType> getEntityType() { return FaceType.class; }

    // ===================================================================================
    //                                                                     Object Instance
    //                                                                     ===============
    public FaceType newEntity() { return new FaceType(); }

    // ===================================================================================
    //                                                                   Map Communication
    //                                                                   =================
    public void acceptPrimaryKeyMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptPrimaryKeyMap((FaceType)et, mp); }
    public void acceptAllColumnMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptAllColumnMap((FaceType)et, mp); }
    public Map<String, Object> extractPrimaryKeyMap(Entity et) { return doExtractPrimaryKeyMap(et); }
    public Map<String, Object> extractAllColumnMap(Entity et) { return doExtractAllColumnMap(et); }
}
