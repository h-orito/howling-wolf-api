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
 * The DB meta of random_content. (Singleton)
 * @author DBFlute(AutoGenerator)
 */
public class RandomContentDbm extends AbstractDBMeta {

    // ===================================================================================
    //                                                                           Singleton
    //                                                                           =========
    private static final RandomContentDbm _instance = new RandomContentDbm();
    private RandomContentDbm() {}
    public static RandomContentDbm getInstance() { return _instance; }

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
        setupEpg(_epgMap, et -> ((RandomContent)et).getRandomContentId(), (et, vl) -> ((RandomContent)et).setRandomContentId(cti(vl)), "randomContentId");
        setupEpg(_epgMap, et -> ((RandomContent)et).getRandomKeywordId(), (et, vl) -> ((RandomContent)et).setRandomKeywordId(cti(vl)), "randomKeywordId");
        setupEpg(_epgMap, et -> ((RandomContent)et).getRandomMessage(), (et, vl) -> ((RandomContent)et).setRandomMessage((String)vl), "randomMessage");
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
        setupEfpg(_efpgMap, et -> ((RandomContent)et).getRandomKeyword(), (et, vl) -> ((RandomContent)et).setRandomKeyword((OptionalEntity<RandomKeyword>)vl), "randomKeyword");
    }
    public PropertyGateway findForeignPropertyGateway(String prop)
    { return doFindEfpg(_efpgMap, prop); }

    // ===================================================================================
    //                                                                          Table Info
    //                                                                          ==========
    protected final String _tableDbName = "random_content";
    protected final String _tableDispName = "RANDOM_CONTENT";
    protected final String _tablePropertyName = "randomContent";
    protected final TableSqlName _tableSqlName = new TableSqlName("RANDOM_CONTENT", _tableDbName);
    { _tableSqlName.xacceptFilter(DBFluteConfig.getInstance().getTableSqlNameFilter()); }
    public String getTableDbName() { return _tableDbName; }
    public String getTableDispName() { return _tableDispName; }
    public String getTablePropertyName() { return _tablePropertyName; }
    public TableSqlName getTableSqlName() { return _tableSqlName; }

    // ===================================================================================
    //                                                                         Column Info
    //                                                                         ===========
    protected final ColumnInfo _columnRandomContentId = cci("RANDOM_CONTENT_ID", "RANDOM_CONTENT_ID", null, null, Integer.class, "randomContentId", null, true, true, true, "INT UNSIGNED", 10, 0, null, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnRandomKeywordId = cci("RANDOM_KEYWORD_ID", "RANDOM_KEYWORD_ID", null, null, Integer.class, "randomKeywordId", null, false, false, true, "INT UNSIGNED", 10, 0, null, null, false, null, null, "randomKeyword", null, null, false);
    protected final ColumnInfo _columnRandomMessage = cci("RANDOM_MESSAGE", "RANDOM_MESSAGE", null, null, String.class, "randomMessage", null, false, false, true, "VARCHAR", 20, 0, null, null, false, null, null, null, null, null, false);

    /**
     * RANDOM_CONTENT_ID: {PK, ID, NotNull, INT UNSIGNED(10)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnRandomContentId() { return _columnRandomContentId; }
    /**
     * RANDOM_KEYWORD_ID: {IX, NotNull, INT UNSIGNED(10), FK to random_keyword}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnRandomKeywordId() { return _columnRandomKeywordId; }
    /**
     * RANDOM_MESSAGE: {NotNull, VARCHAR(20)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnRandomMessage() { return _columnRandomMessage; }

    protected List<ColumnInfo> ccil() {
        List<ColumnInfo> ls = newArrayList();
        ls.add(columnRandomContentId());
        ls.add(columnRandomKeywordId());
        ls.add(columnRandomMessage());
        return ls;
    }

    { initializeInformationResource(); }

    // ===================================================================================
    //                                                                         Unique Info
    //                                                                         ===========
    // -----------------------------------------------------
    //                                       Primary Element
    //                                       ---------------
    protected UniqueInfo cpui() { return hpcpui(columnRandomContentId()); }
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
    /**
     * RANDOM_KEYWORD by my RANDOM_KEYWORD_ID, named 'randomKeyword'.
     * @return The information object of foreign property. (NotNull)
     */
    public ForeignInfo foreignRandomKeyword() {
        Map<ColumnInfo, ColumnInfo> mp = newLinkedHashMap(columnRandomKeywordId(), RandomKeywordDbm.getInstance().columnRandomKeywordId());
        return cfi("FK_RANDOM_CONTENT_RANDOM_KEYWORD", "randomKeyword", this, RandomKeywordDbm.getInstance(), mp, 0, org.dbflute.optional.OptionalEntity.class, false, false, false, false, null, null, false, "randomContentList", false);
    }

    // -----------------------------------------------------
    //                                     Referrer Property
    //                                     -----------------

    // ===================================================================================
    //                                                                        Various Info
    //                                                                        ============
    public boolean hasIdentity() { return true; }

    // ===================================================================================
    //                                                                           Type Name
    //                                                                           =========
    public String getEntityTypeName() { return "com.ort.dbflute.exentity.RandomContent"; }
    public String getConditionBeanTypeName() { return "com.ort.dbflute.cbean.RandomContentCB"; }
    public String getBehaviorTypeName() { return "com.ort.dbflute.exbhv.RandomContentBhv"; }

    // ===================================================================================
    //                                                                         Object Type
    //                                                                         ===========
    public Class<RandomContent> getEntityType() { return RandomContent.class; }

    // ===================================================================================
    //                                                                     Object Instance
    //                                                                     ===============
    public RandomContent newEntity() { return new RandomContent(); }

    // ===================================================================================
    //                                                                   Map Communication
    //                                                                   =================
    public void acceptPrimaryKeyMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptPrimaryKeyMap((RandomContent)et, mp); }
    public void acceptAllColumnMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptAllColumnMap((RandomContent)et, mp); }
    public Map<String, Object> extractPrimaryKeyMap(Entity et) { return doExtractPrimaryKeyMap(et); }
    public Map<String, Object> extractAllColumnMap(Entity et) { return doExtractAllColumnMap(et); }
}
