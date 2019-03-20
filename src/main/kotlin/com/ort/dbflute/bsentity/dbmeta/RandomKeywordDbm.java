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
 * The DB meta of random_keyword. (Singleton)
 * @author DBFlute(AutoGenerator)
 */
public class RandomKeywordDbm extends AbstractDBMeta {

    // ===================================================================================
    //                                                                           Singleton
    //                                                                           =========
    private static final RandomKeywordDbm _instance = new RandomKeywordDbm();
    private RandomKeywordDbm() {}
    public static RandomKeywordDbm getInstance() { return _instance; }

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
        setupEpg(_epgMap, et -> ((RandomKeyword)et).getRandomKeywordId(), (et, vl) -> ((RandomKeyword)et).setRandomKeywordId(cti(vl)), "randomKeywordId");
        setupEpg(_epgMap, et -> ((RandomKeyword)et).getKeyword(), (et, vl) -> ((RandomKeyword)et).setKeyword((String)vl), "keyword");
    }
    public PropertyGateway findPropertyGateway(String prop)
    { return doFindEpg(_epgMap, prop); }

    // ===================================================================================
    //                                                                          Table Info
    //                                                                          ==========
    protected final String _tableDbName = "random_keyword";
    protected final String _tableDispName = "RANDOM_KEYWORD";
    protected final String _tablePropertyName = "randomKeyword";
    protected final TableSqlName _tableSqlName = new TableSqlName("RANDOM_KEYWORD", _tableDbName);
    { _tableSqlName.xacceptFilter(DBFluteConfig.getInstance().getTableSqlNameFilter()); }
    public String getTableDbName() { return _tableDbName; }
    public String getTableDispName() { return _tableDispName; }
    public String getTablePropertyName() { return _tablePropertyName; }
    public TableSqlName getTableSqlName() { return _tableSqlName; }

    // ===================================================================================
    //                                                                         Column Info
    //                                                                         ===========
    protected final ColumnInfo _columnRandomKeywordId = cci("RANDOM_KEYWORD_ID", "RANDOM_KEYWORD_ID", null, null, Integer.class, "randomKeywordId", null, true, true, true, "INT UNSIGNED", 10, 0, null, null, false, null, null, null, "randomContentList", null, false);
    protected final ColumnInfo _columnKeyword = cci("KEYWORD", "KEYWORD", null, null, String.class, "keyword", null, false, false, true, "VARCHAR", 10, 0, null, null, false, null, null, null, null, null, false);

    /**
     * RANDOM_KEYWORD_ID: {PK, ID, NotNull, INT UNSIGNED(10)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnRandomKeywordId() { return _columnRandomKeywordId; }
    /**
     * KEYWORD: {UQ, NotNull, VARCHAR(10)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnKeyword() { return _columnKeyword; }

    protected List<ColumnInfo> ccil() {
        List<ColumnInfo> ls = newArrayList();
        ls.add(columnRandomKeywordId());
        ls.add(columnKeyword());
        return ls;
    }

    { initializeInformationResource(); }

    // ===================================================================================
    //                                                                         Unique Info
    //                                                                         ===========
    // -----------------------------------------------------
    //                                       Primary Element
    //                                       ---------------
    protected UniqueInfo cpui() { return hpcpui(columnRandomKeywordId()); }
    public boolean hasPrimaryKey() { return true; }
    public boolean hasCompoundPrimaryKey() { return false; }

    // -----------------------------------------------------
    //                                        Unique Element
    //                                        --------------
    public UniqueInfo uniqueOf() { return hpcui(columnKeyword()); }

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
     * RANDOM_CONTENT by RANDOM_KEYWORD_ID, named 'randomContentList'.
     * @return The information object of referrer property. (NotNull)
     */
    public ReferrerInfo referrerRandomContentList() {
        Map<ColumnInfo, ColumnInfo> mp = newLinkedHashMap(columnRandomKeywordId(), RandomContentDbm.getInstance().columnRandomKeywordId());
        return cri("FK_RANDOM_CONTENT_RANDOM_KEYWORD", "randomContentList", this, RandomContentDbm.getInstance(), mp, false, "randomKeyword");
    }

    // ===================================================================================
    //                                                                        Various Info
    //                                                                        ============
    public boolean hasIdentity() { return true; }

    // ===================================================================================
    //                                                                           Type Name
    //                                                                           =========
    public String getEntityTypeName() { return "com.ort.dbflute.exentity.RandomKeyword"; }
    public String getConditionBeanTypeName() { return "com.ort.dbflute.cbean.RandomKeywordCB"; }
    public String getBehaviorTypeName() { return "com.ort.dbflute.exbhv.RandomKeywordBhv"; }

    // ===================================================================================
    //                                                                         Object Type
    //                                                                         ===========
    public Class<RandomKeyword> getEntityType() { return RandomKeyword.class; }

    // ===================================================================================
    //                                                                     Object Instance
    //                                                                     ===============
    public RandomKeyword newEntity() { return new RandomKeyword(); }

    // ===================================================================================
    //                                                                   Map Communication
    //                                                                   =================
    public void acceptPrimaryKeyMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptPrimaryKeyMap((RandomKeyword)et, mp); }
    public void acceptAllColumnMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptAllColumnMap((RandomKeyword)et, mp); }
    public Map<String, Object> extractPrimaryKeyMap(Entity et) { return doExtractPrimaryKeyMap(et); }
    public Map<String, Object> extractAllColumnMap(Entity et) { return doExtractAllColumnMap(et); }
}
