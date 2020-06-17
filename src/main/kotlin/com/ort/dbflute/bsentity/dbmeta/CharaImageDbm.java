package com.ort.dbflute.bsentity.dbmeta;

import java.util.List;
import java.util.Map;

import org.dbflute.Entity;
import org.dbflute.optional.OptionalEntity;
import org.dbflute.dbmeta.AbstractDBMeta;
import org.dbflute.dbmeta.info.*;
import org.dbflute.dbmeta.name.*;
import org.dbflute.dbmeta.property.PropertyGateway;
import org.dbflute.dbway.DBDef;
import com.ort.dbflute.allcommon.*;
import com.ort.dbflute.exentity.*;

/**
 * The DB meta of CHARA_IMAGE. (Singleton)
 * @author DBFlute(AutoGenerator)
 */
public class CharaImageDbm extends AbstractDBMeta {

    // ===================================================================================
    //                                                                           Singleton
    //                                                                           =========
    private static final CharaImageDbm _instance = new CharaImageDbm();
    private CharaImageDbm() {}
    public static CharaImageDbm getInstance() { return _instance; }

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
        setupEpg(_epgMap, et -> ((CharaImage)et).getCharaId(), (et, vl) -> ((CharaImage)et).setCharaId(cti(vl)), "charaId");
        setupEpg(_epgMap, et -> ((CharaImage)et).getFaceTypeCode(), (et, vl) -> {
            CDef.FaceType cls = (CDef.FaceType)gcls(et, columnFaceTypeCode(), vl);
            if (cls != null) {
                ((CharaImage)et).setFaceTypeCodeAsFaceType(cls);
            } else {
                ((CharaImage)et).mynativeMappingFaceTypeCode((String)vl);
            }
        }, "faceTypeCode");
        setupEpg(_epgMap, et -> ((CharaImage)et).getCharaImgUrl(), (et, vl) -> ((CharaImage)et).setCharaImgUrl((String)vl), "charaImgUrl");
    }
    public PropertyGateway findPropertyGateway(String prop)
    { return doFindEpg(_epgMap, prop); }

    // -----------------------------------------------------
    //                                      Foreign Property
    //                                      ----------------
    protected final Map<String, PropertyGateway> _efpgMap = newHashMap();
    { xsetupEfpg(); }
    @SuppressWarnings("unchecked")
    protected void xsetupEfpg() {
        setupEfpg(_efpgMap, et -> ((CharaImage)et).getChara(), (et, vl) -> ((CharaImage)et).setChara((OptionalEntity<Chara>)vl), "chara");
        setupEfpg(_efpgMap, et -> ((CharaImage)et).getFaceType(), (et, vl) -> ((CharaImage)et).setFaceType((OptionalEntity<FaceType>)vl), "faceType");
    }
    public PropertyGateway findForeignPropertyGateway(String prop)
    { return doFindEfpg(_efpgMap, prop); }

    // ===================================================================================
    //                                                                          Table Info
    //                                                                          ==========
    protected final String _tableDbName = "CHARA_IMAGE";
    protected final String _tableDispName = "CHARA_IMAGE";
    protected final String _tablePropertyName = "charaImage";
    protected final TableSqlName _tableSqlName = new TableSqlName("CHARA_IMAGE", _tableDbName);
    { _tableSqlName.xacceptFilter(DBFluteConfig.getInstance().getTableSqlNameFilter()); }
    public String getTableDbName() { return _tableDbName; }
    public String getTableDispName() { return _tableDispName; }
    public String getTablePropertyName() { return _tablePropertyName; }
    public TableSqlName getTableSqlName() { return _tableSqlName; }

    // ===================================================================================
    //                                                                         Column Info
    //                                                                         ===========
    protected final ColumnInfo _columnCharaId = cci("CHARA_ID", "CHARA_ID", null, null, Integer.class, "charaId", null, true, false, true, "INT UNSIGNED", 10, 0, null, null, false, null, null, "chara", null, null, false);
    protected final ColumnInfo _columnFaceTypeCode = cci("FACE_TYPE_CODE", "FACE_TYPE_CODE", null, null, String.class, "faceTypeCode", null, true, false, true, "VARCHAR", 20, 0, null, null, false, null, null, "faceType", null, CDef.DefMeta.FaceType, false);
    protected final ColumnInfo _columnCharaImgUrl = cci("CHARA_IMG_URL", "CHARA_IMG_URL", null, null, String.class, "charaImgUrl", null, false, false, true, "VARCHAR", 100, 0, null, null, false, null, null, null, null, null, false);

    /**
     * CHARA_ID: {PK, NotNull, INT UNSIGNED(10), FK to CHARA}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnCharaId() { return _columnCharaId; }
    /**
     * FACE_TYPE_CODE: {PK, IX, NotNull, VARCHAR(20), FK to FACE_TYPE, classification=FaceType}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnFaceTypeCode() { return _columnFaceTypeCode; }
    /**
     * CHARA_IMG_URL: {NotNull, VARCHAR(100)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnCharaImgUrl() { return _columnCharaImgUrl; }

    protected List<ColumnInfo> ccil() {
        List<ColumnInfo> ls = newArrayList();
        ls.add(columnCharaId());
        ls.add(columnFaceTypeCode());
        ls.add(columnCharaImgUrl());
        return ls;
    }

    { initializeInformationResource(); }

    // ===================================================================================
    //                                                                         Unique Info
    //                                                                         ===========
    // -----------------------------------------------------
    //                                       Primary Element
    //                                       ---------------
    protected UniqueInfo cpui() {
        List<ColumnInfo> ls = newArrayListSized(4);
        ls.add(columnCharaId());
        ls.add(columnFaceTypeCode());
        return hpcpui(ls);
    }
    public boolean hasPrimaryKey() { return true; }
    public boolean hasCompoundPrimaryKey() { return true; }

    // ===================================================================================
    //                                                                       Relation Info
    //                                                                       =============
    // cannot cache because it uses related DB meta instance while booting
    // (instead, cached by super's collection)
    // -----------------------------------------------------
    //                                      Foreign Property
    //                                      ----------------
    /**
     * CHARA by my CHARA_ID, named 'chara'.
     * @return The information object of foreign property. (NotNull)
     */
    public ForeignInfo foreignChara() {
        Map<ColumnInfo, ColumnInfo> mp = newLinkedHashMap(columnCharaId(), CharaDbm.getInstance().columnCharaId());
        return cfi("FK_CHARA_IMAGE_CHARA", "chara", this, CharaDbm.getInstance(), mp, 0, org.dbflute.optional.OptionalEntity.class, false, false, false, false, null, null, false, "charaImageList", false);
    }
    /**
     * FACE_TYPE by my FACE_TYPE_CODE, named 'faceType'.
     * @return The information object of foreign property. (NotNull)
     */
    public ForeignInfo foreignFaceType() {
        Map<ColumnInfo, ColumnInfo> mp = newLinkedHashMap(columnFaceTypeCode(), FaceTypeDbm.getInstance().columnFaceTypeCode());
        return cfi("FK_CHARA_IMAGE_FACE_TYPE", "faceType", this, FaceTypeDbm.getInstance(), mp, 1, org.dbflute.optional.OptionalEntity.class, false, false, false, false, null, null, false, "charaImageList", false);
    }

    // -----------------------------------------------------
    //                                     Referrer Property
    //                                     -----------------

    // ===================================================================================
    //                                                                        Various Info
    //                                                                        ============

    // ===================================================================================
    //                                                                           Type Name
    //                                                                           =========
    public String getEntityTypeName() { return "com.ort.dbflute.exentity.CharaImage"; }
    public String getConditionBeanTypeName() { return "com.ort.dbflute.cbean.CharaImageCB"; }
    public String getBehaviorTypeName() { return "com.ort.dbflute.exbhv.CharaImageBhv"; }

    // ===================================================================================
    //                                                                         Object Type
    //                                                                         ===========
    public Class<CharaImage> getEntityType() { return CharaImage.class; }

    // ===================================================================================
    //                                                                     Object Instance
    //                                                                     ===============
    public CharaImage newEntity() { return new CharaImage(); }

    // ===================================================================================
    //                                                                   Map Communication
    //                                                                   =================
    public void acceptPrimaryKeyMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptPrimaryKeyMap((CharaImage)et, mp); }
    public void acceptAllColumnMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptAllColumnMap((CharaImage)et, mp); }
    public Map<String, Object> extractPrimaryKeyMap(Entity et) { return doExtractPrimaryKeyMap(et); }
    public Map<String, Object> extractAllColumnMap(Entity et) { return doExtractAllColumnMap(et); }
}
